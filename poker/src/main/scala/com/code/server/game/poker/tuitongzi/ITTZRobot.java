package com.code.server.game.poker.tuitongzi;

import com.code.server.constant.robot.IRobot;

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
public interface ITTZRobot extends IRobot {

    void crap(GameTuiTongZi game);
    void bet(GameTuiTongZi game);
    void open(GameTuiTongZi game);

    void getReady(RoomTuiTongZi room);


}
