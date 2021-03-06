package com.code.server.game.poker.guess;

import com.code.server.constant.kafka.IKafaTopic;
import com.code.server.constant.kafka.KafkaMsgKey;
import com.code.server.constant.response.ErrorCode;
import com.code.server.constant.response.IfaceGameVo;
import com.code.server.constant.response.ResponseVo;
import com.code.server.game.room.Game;
import com.code.server.game.room.Room;
import com.code.server.game.room.kafka.MsgSender;
import com.code.server.kafka.MsgProducer;
import com.code.server.redis.service.RedisManager;
import com.code.server.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
public class GameGuessCar extends Game{

    protected static final Logger logger = LoggerFactory.getLogger(GameGuessCar.class);

    private static final long BET_TIME = 20000L;//时间

    private static final Integer RED = 0;
    private static final Integer GREEN = 1;
    private static final Integer NOT_SET_RESULT = 0;
    private static final Integer START = 1;
    private static final Integer OVER_BET = 2;

    public BankerCardInfoGuessCar bankerCardInfos = new BankerCardInfoGuessCar();
    public Map<Long, PlayerCardInfoGuessCar> playerCardInfos = new HashMap<>();
    protected Random rand = new Random();
    protected RoomGuessCar room;
    //protected long beginTime;
    protected int color = -1;
    protected double redScore;//red 0 green 1
    protected double greenScore;
    //protected int status;//0未设置结果，1已设置，开局，2下注结束


    public void init(List<Long> users) {
        //初始化玩家
        for (Long uid : users) {
            if(uid!=room.getBankerId()){
                PlayerCardInfoGuessCar playerCardInfo = getGameTypePlayerCardInfo();
                playerCardInfo.userId = uid;
                playerCardInfo.setFinalScore(RedisManager.getUserRedisService().getUserGold(uid));
                playerCardInfos.put(uid, playerCardInfo);
            }
        }
        bankerCardInfos.userId = room.getBankerId();
        bankerCardInfos.setScore(room.getBankerScore());
        this.users.addAll(users);
        updateLastOperateTime();
    }

    public void startGame(List<Long> users, Room room,int redOrGreen) {
        this.room = (RoomGuessCar) room;
        this.color = redOrGreen;
        init(users);
        updateLastOperateTime();
        //通知其他人游戏已经开始
        MsgSender.sendMsg2Player(new ResponseVo("gameGuessService", "gameBegin", "ok"), this.getUsers());
    }

    /**
     * 庄家设置结果
     * @return
     */
    public int setResult(long userId,int color) {
        /*logger.info(userId + "  设置结果: " + color);
        if(-1!=color){
            return ErrorCode.STATE_ERROR;
        }
        if (userId != bankerCardInfos.getUserId()) {//不是庄家
            return ErrorCode.NOT_BANKER;
        } else {
            this.color = color;
            this.status = START;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("color", color);
        ResponseVo vo = new ResponseVo("gameGuessService", "setResultResponse", result);
        MsgSender.sendMsg2Player(vo, users);

        MsgSender.sendMsg2Player("gameGuessService", "setResult", 0, userId);
        MsgSender.sendMsg2Player("gameGuessService", "canRaise", 0, users);//通知可以下注
        updateLastOperateTime();
        beginTime = System.currentTimeMillis();

        new Thread(new Runnable() {//设置倒计时
            @Override
            public void run() {
                logger.info(userId + "  倒计时: " + BET_TIME);
                try{
                    Thread.sleep(BET_TIME);
                    status = OVER_BET;
                    MsgSender.sendMsg2Player("gameGuessService", "betOver", 0, users);//通知可以下注
                    sendResult();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();*/

        return 0;
    }


        /**
         * 加注
         * @return
         */
    public int raise(long userId,double addChip,int color){
        logger.info(userId +"  下注: "+ addChip);

        if(playerCardInfos.get(userId).getRedScore() + playerCardInfos.get(userId).getGreenScore() + addChip > playerCardInfos.get(userId).getFinalScore()){
            return ErrorCode.NOT_HAVE_MORE_MONEY;
        }

        if(RED==color){
            if(redScore>=room.getBankerScore()){
                return ErrorCode.BET_WRONG;
            }else if(addChip+redScore-greenScore<=room.getBankerScore()){
                redScore+=addChip;
                playerCardInfos.get(userId).setRedScore(playerCardInfos.get(userId).getRedScore()+addChip);
            }else{
                double temp = addChip-(Math.abs(redScore-greenScore-room.getBankerScore()));
                redScore+=(temp);
                playerCardInfos.get(userId).setRedScore(playerCardInfos.get(userId).getRedScore()+temp);
            }
        }else{
            if(greenScore>=room.getBankerScore()){
                return ErrorCode.BET_WRONG;
            }else if(addChip+greenScore-redScore<=room.getBankerScore()){
                greenScore+=addChip;
                playerCardInfos.get(userId).setGreenScore(playerCardInfos.get(userId).getGreenScore()+addChip);
            }else{
                double temp = addChip-(Math.abs(greenScore-redScore-room.getBankerScore()));
                greenScore+=(temp);
                playerCardInfos.get(userId).setGreenScore(playerCardInfos.get(userId).getGreenScore()+temp);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("redAllScore",redScore);
        result.put("greenAllScore",greenScore);
        result.put("userId",userId);
        result.put("redScore",color==0?addChip:0.0);
        result.put("greenScore",color==1?addChip:0.0);
        result.put("color",color);
        ResponseVo vo = new ResponseVo("gameGuessService", "raiseResponse", result);
        MsgSender.sendMsg2Player(vo, users);

        MsgSender.sendMsg2Player("gameGuessService", "raise", 0, userId);
        updateLastOperateTime();

        return 0;
    }


    public int getRemainTime(long userId){
        Map<String, Object> result = new HashMap<>();
        long time = this.room.betEndTimerNode.getNextTriggerTime() - System.currentTimeMillis();
        result.put("remainTime", time);
        MsgSender.sendMsg2Player("gameGuessService", "getRemainTime", result, userId);
        return 0;
    }


    public int look(long userId){
        Map<String, Object> result = new HashMap<>();
        result.put("color", this.color);
        MsgSender.sendMsg2Player("gameGuessService", "look", result, userId);
        return 0;
    }

    public int change(long userId,int color){
        Map<String, Object> result = new HashMap<>();
        this.color = color;
        result.put("color", this.color);
        RoomGuessCar roomGuessCar = (RoomGuessCar)this.room;
        if(roomGuessCar.record!= null && roomGuessCar.record.size()>0){
            roomGuessCar.record.remove(roomGuessCar.record.size() - 1);
            roomGuessCar.record.add(color);
        }
        MsgSender.sendMsg2Player("gameGuessService", "change", result, userId);
        return 0;
    }

    //=====================================
    //==============结束操作================
    //=====================================


    /**
     * 发送战绩
     */
    protected void sendResult() {

        double tempS = bankerCardInfos.getScore();
        //算分
        for (PlayerCardInfoGuessCar playerCardInfo : playerCardInfos.values()) {
            if(RED==this.color){
                playerCardInfo.setFinalScore(playerCardInfo.getFinalScore()+playerCardInfo.getRedScore()*0.95-playerCardInfo.getGreenScore());
                bankerCardInfos.setScore(bankerCardInfos.getScore()+playerCardInfo.getGreenScore()-playerCardInfo.getRedScore());
                RedisManager.getUserRedisService().addUserGold(playerCardInfo.getUserId(),(playerCardInfo.getRedScore()*0.95-playerCardInfo.getGreenScore()));
                //RedisManager.getUserRedisService().addUserMoney(bankerCardInfos.getUserId(),(playerCardInfo.getGreenScore()-playerCardInfo.getRedScore()));
                this.room.bankerScore +=(playerCardInfo.getGreenScore()-playerCardInfo.getRedScore());
            }else{
                playerCardInfo.setFinalScore(playerCardInfo.getFinalScore()+playerCardInfo.getGreenScore()*0.95-playerCardInfo.getRedScore());
                bankerCardInfos.setScore(bankerCardInfos.getScore()+playerCardInfo.getRedScore()-playerCardInfo.getGreenScore());
                RedisManager.getUserRedisService().addUserGold(playerCardInfo.getUserId(),(playerCardInfo.getGreenScore()*0.95-playerCardInfo.getRedScore()));
                //RedisManager.getUserRedisService().addUserMoney(bankerCardInfos.getUserId(),(playerCardInfo.getRedScore()-playerCardInfo.getGreenScore()));
                this.room.bankerScore +=(playerCardInfo.getRedScore()-playerCardInfo.getGreenScore());
            }
        }

        //普通玩家
        if(playerCardInfos!=null && playerCardInfos.size()>0){
            for (Long l:playerCardInfos.keySet()) {
                Map<String, Object> result = new HashMap<>();
                result.put("color",this.color);

                result.put("finalScore",playerCardInfos.get(l).getFinalScore());
                double add = 0;
                if(RED==this.color){//设置赢了多少
                    result.put("score",playerCardInfos.get(l).getRedScore()*2*0.975-playerCardInfos.get(l).getGreenScore());
                    add = playerCardInfos.get(l).getRedScore();
                }else{
                    result.put("score",playerCardInfos.get(l).getGreenScore()*2*0.975-playerCardInfos.get(l).getRedScore());
                    add = playerCardInfos.get(l).getGreenScore();
                }

                Map<String, Object> addGold = new HashMap<>();
                addGold.put("userId", l);
                addGold.put("gold",add/100);
                KafkaMsgKey kafkaMsgKey = new KafkaMsgKey().setMsgId(KAFKA_MSG_ID_GUESS_ADD_GOLD);
                MsgProducer msgProducer = SpringUtil.getBean(MsgProducer.class);
                msgProducer.send(IKafaTopic.CENTER_TOPIC, kafkaMsgKey, addGold);

                ResponseVo vo = new ResponseVo("gameGuessService", "gameResult", result);
                MsgSender.sendMsg2Player(vo, l);

            }
        }

        /*RedisManager.getUserRedisService().setUserMoney(bankerCardInfos.getUserId(),RedisManager.getUserRedisService().getUserMoney(bankerCardInfos.getUserId()) + (bankerCardInfos.getScore()-tempS));*/


        //庄家
        Map<String, Object> result = new HashMap<>();

        //this.room.bankerScore = bankerCardInfos.getScore();
        result.put("score",bankerCardInfos.getScore()-tempS);
        result.put("bankerScore",bankerCardInfos.getScore());
        result.put("color",this.color);
        ResponseVo vo = new ResponseVo("gameGuessService", "gameBankerResult", result);
        ResponseVo voBanker = new ResponseVo("gameGuessService", "gameResult", result);
        //MsgSender.sendMsg2Player(vo, bankerCardInfos.getUserId());
        MsgSender.sendMsg2Player(voBanker, bankerCardInfos.getUserId());
        MsgSender.sendMsg2Player(vo, this.room.getUsers());

        //改变状态
        this.room.state = RoomGuessCar.STATE_GUESS;
        MsgSender.sendMsg2Player("gameGuessService","stateChange",this.room.state,this.room.getUsers());

        if (this.room.bankerScore <= 20) {
            MsgSender.sendMsg2Player("gameGuessService","gameOver","gameOver",this.room.getUsers());
            this.room.quitRoom(this.room.getBankerId());
        }
    }


    public PlayerCardInfoGuessCar getGameTypePlayerCardInfo() {
        switch (room.getGameType()) {
            case "1":
                return new PlayerCardInfoGuessCar();
            default:
                return new PlayerCardInfoGuessCar();
        }
    }





    //===========================================
    //==============get，set================
    //===========================================


    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public RoomGuessCar getRoom() {
        return room;
    }

    public GameGuessCar setRoom(RoomGuessCar room) {
        this.room = room;
        return this;
    }

    public Map<Long, PlayerCardInfoGuessCar> getPlayerCardInfos() {
        return playerCardInfos;
    }

    public void setPlayerCardInfos(Map<Long, PlayerCardInfoGuessCar> playerCardInfos) {
        this.playerCardInfos = playerCardInfos;
    }

    public BankerCardInfoGuessCar getBankerCardInfos() {
        return bankerCardInfos;
    }

    public void setBankerCardInfos(BankerCardInfoGuessCar bankerCardInfos) {
        this.bankerCardInfos = bankerCardInfos;
    }

    public double getRedScore() {
        return redScore;
    }

    public void setRedScore(double redScore) {
        this.redScore = redScore;
    }

    public double getGreenScore() {
        return greenScore;
    }

    public void setGreenScore(double greenScore) {
        this.greenScore = greenScore;
    }



    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public IfaceGameVo toVo(long userId) {
        GameGuessCarVo vo = new GameGuessCarVo();
        vo.bankerCardInfos = this.bankerCardInfos;
        vo.color = this.color;
        vo.playerCardInfos = this.playerCardInfos;
        vo.greenScore = this.greenScore;
        vo.redScore = this.redScore;
        return vo;
    }

}
