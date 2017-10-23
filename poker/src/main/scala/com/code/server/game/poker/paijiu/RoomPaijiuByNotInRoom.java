package com.code.server.game.poker.paijiu;

import com.code.server.constant.exception.DataNotFoundException;
import com.code.server.constant.response.ResponseVo;
import com.code.server.game.poker.config.ServerConfig;
import com.code.server.game.room.Room;
import com.code.server.game.room.kafka.MsgSender;
import com.code.server.game.room.service.RoomManager;
import com.code.server.redis.config.IConstant;
import com.code.server.util.IdWorker;
import com.code.server.util.SpringUtil;
import com.code.server.util.timer.GameTimer;
import com.code.server.util.timer.TimerNode;

/**
 * 项目名称：${project_name}
 * 类名称：${type_name}
 * 类描述：
 * 创建人：Clark
 * 创建时间：${date} ${time}
 * 修改人：Clark
 * 修改时间：${date} ${time}
 * 修改备注：
 *
 * @version 1.0
 */
public class RoomPaijiuByNotInRoom extends Room {

    public static int createRoomNotInRoom(long userId, String roomType, String gameType,Integer gameNumber,boolean isCreaterJoin) throws DataNotFoundException {
        RoomPaijiu roomPaijiu = new RoomPaijiu();
        roomPaijiu.setRoomId(Room.getRoomIdStr(Room.genRoomId()));
        roomPaijiu.setRoomType(roomType);
        roomPaijiu.setGameType(gameType);
        roomPaijiu.setGameNumber(gameNumber);
        roomPaijiu.setBankerId(0l);
        roomPaijiu.setCreateUser(userId);
        roomPaijiu.setPersonNumber(4);
        roomPaijiu.setCreaterJoin(isCreaterJoin);
        roomPaijiu.init(gameNumber, 1);

        //代建房 定时解散
        if (!isCreaterJoin) {
            //给代建房 开房者 扣钱
            roomPaijiu.spendMoney();
            TimerNode prepareRoomNode = new TimerNode(System.currentTimeMillis(), IConstant.HOUR_1, false, roomPaijiu::dissolutionRoom);
            roomPaijiu.prepareRoomTimerNode = prepareRoomNode;
            GameTimer.addTimerNode(prepareRoomNode);
        }

        ServerConfig serverConfig = SpringUtil.getBean(ServerConfig.class);
        RoomManager.addRoom(roomPaijiu.getRoomId(), "" + serverConfig.getServerId(), roomPaijiu);
        IdWorker idword = new IdWorker(serverConfig.getServerId(),0);
        roomPaijiu.setUuid(idword.nextId());


        MsgSender.sendMsg2Player(new ResponseVo("pokerRoomService", "createPaijiuRoomNotInRoom", roomPaijiu.toVo(userId)), userId);

        return 0;
    }

}