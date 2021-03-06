package com.code.server.constant.response;


import com.code.server.constant.db.UserInfo;

/**
 * Created by sunxianping on 2017/3/27.
 */
public class UserVo {
    public long id; // required
    public String username; // required
    public String image; // required
    public String seatId; // required
    public String account; // required
    public String ipConfig; // required
    public double money; // required
    public String roomId; // required
    public int vip; // required
    public String uuid; // required
    public String openId; // required
    public int sex; // required
    public int referee;
    public UserInfo userInfo;
    public double gold;
    public String coord = "";

    public long getId() {
        return id;
    }

    public UserVo setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getImage() {
        return image;
    }

    public UserVo setImage(String image) {
        this.image = image;
        return this;
    }

    public String getSeatId() {
        return seatId;
    }

    public UserVo setSeatId(String seatId) {
        this.seatId = seatId;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public UserVo setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getIpConfig() {
        return ipConfig;
    }

    public UserVo setIpConfig(String ipConfig) {
        this.ipConfig = ipConfig;
        return this;
    }

    public double getMoney() {
        return money;
    }

    public UserVo setMoney(double money) {
        this.money = money;
        return this;
    }

    public String getRoomId() {
        return roomId;
    }

    public UserVo setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public int getVip() {
        return vip;
    }

    public UserVo setVip(int vip) {
        this.vip = vip;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserVo setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public UserVo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public UserVo setSex(int sex) {
        this.sex = sex;
        return this;
    }



    public int getReferee() {
        return referee;
    }

    public UserVo setReferee(int referee) {
        this.referee = referee;
        return this;
    }

    public com.code.server.constant.db.UserInfo getUserInfo() {
        return userInfo;
    }

    public UserVo setUserInfo(com.code.server.constant.db.UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public double getGold() {
        return gold;
    }

    public UserVo setGold(double gold) {
        this.gold = gold;
        return this;
    }

    public String getCoord() {
        return coord;
    }

    public UserVo setCoord(String coord) {
        this.coord = coord;
        return this;
    }
}
