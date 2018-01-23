package com.code.server.constant.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunxianping on 2018/1/19.
 */
public class ClubInfo {

    private Map<String,ClubMember> member = new HashMap<>();//成员
    private List<ClubMember> applyList = new ArrayList<>();//申请列表
    private List<RoomModel> roomModels = new ArrayList<>();//房间信息
    private Map<String, RoomInstance> roomInstance = new HashMap<>();//房间实例

    public Map<String, ClubMember> getMember() {
        return member;
    }

    public ClubInfo setMember(Map<String, ClubMember> member) {
        this.member = member;
        return this;
    }

    public List<ClubMember> getApplyList() {
        return applyList;
    }

    public ClubInfo setApplyList(List<ClubMember> applyList) {
        this.applyList = applyList;
        return this;
    }

    public List<RoomModel> getRoomModels() {
        return roomModels;
    }

    public ClubInfo setRoomModels(List<RoomModel> roomModels) {
        this.roomModels = roomModels;
        return this;
    }

    public Map<String, RoomInstance> getRoomInstance() {
        return roomInstance;
    }

    public ClubInfo setRoomInstance(Map<String, RoomInstance> roomInstance) {
        this.roomInstance = roomInstance;
        return this;
    }
}
