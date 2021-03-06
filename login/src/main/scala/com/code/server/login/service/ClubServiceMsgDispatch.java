package com.code.server.login.service;

import com.code.server.constant.kafka.IKafaTopic;
import com.code.server.constant.kafka.KafkaMsgKey;
import com.code.server.constant.response.ResponseVo;
import com.code.server.kafka.MsgProducer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunxianping on 2018/1/15.
 */
@Service
public class ClubServiceMsgDispatch {


    @Autowired
    GameClubService gameClubService;


    @Autowired
    MsgProducer kafkaMsgProducer;


    public void dispatchMsg(KafkaMsgKey msgKey, JsonNode params) {
        String service = params.get("service").asText();
        String method = params.get("method").asText();
        JsonNode node = params.get("params");
        int rtn = dispatchUserService(msgKey, method, node, params);
        if (rtn != 0) {
            ResponseVo vo = new ResponseVo(service, method, rtn);
            kafkaMsgProducer.send2Partition(IKafaTopic.GATE_TOPIC, msgKey.getPartition(), "" + msgKey.getUserId(), vo);
        }
    }


    private int dispatchUserService(KafkaMsgKey msgKey, String method, JsonNode params, JsonNode allParams) {
        long userId = msgKey.getUserId();
        String clubId = params.path("clubId").asText();
        switch (method) {
            case "lookClub":
                return gameClubService.lookClub(msgKey, userId);
            case "getClubInfo":
                return gameClubService.getClubInfo(msgKey, userId, clubId);
            case "createClub":
                String clubName = params.get("clubName").asText();
                String wx = params.get("wx").asText();
                String area = params.get("area").asText();
                String desc = params.get("desc").asText();
                return gameClubService.createClub(msgKey, userId, clubName, wx, area, desc);
            case "setClub":
                String clubName_set = params.get("clubName").asText();
                String wx_set = params.get("wx").asText();
                String area_set = params.get("area").asText();
                String desc_set = params.get("desc").asText();
                return gameClubService.setClub(msgKey, userId, clubId, clubName_set, wx_set, area_set, desc_set);
            case "markUser":
                long markUser = params.get("markUser").asLong();
                String mark1 = params.get("mark").asText();
                return gameClubService.markUser(msgKey, userId, clubId, markUser, mark1);
            case "dissolve":
                return gameClubService.dissolve(msgKey, userId, clubId);
            case "isHasClub":
                return gameClubService.isHasClub(msgKey, userId, clubId);
            case "joinClub":
                String mark = params.get("mark").asText();
                return gameClubService.joinClub(msgKey, userId, clubId, mark);
            case "quitClub":
                return gameClubService.quitClub(msgKey, userId, clubId);
            case "agree":
                long agreeUser = params.get("applyUserId").asLong();
                boolean isAgree = params.get("isAgree").asBoolean();
                return gameClubService.agree(msgKey, userId, clubId, agreeUser, isAgree);

            case "charge":
                int money = params.get("money").asInt();
                return gameClubService.charge(msgKey, userId, clubId, money);

            case "createRoomModel":
                String createCommand = params.get("createCommand").asText();
                String gameType = params.get("gameType").asText();
                int gameNumber = params.get("gameNumber").asInt();
                String desc1 = params.get("desc").asText();
                return gameClubService.createRoomModel(msgKey,  userId, clubId, createCommand,gameType, gameNumber, desc1);

            case "removeRoomModel":
                String roomModelId = params.get("roomModelId").asText();
                return gameClubService.removeRoomModel(msgKey, userId, clubId, roomModelId);
            case "setRoomModel":
                String createCommand_set = params.get("createCommand").asText();
                String gameType_set = params.get("gameType").asText();
                int gameNumber_set = params.get("gameNumber").asInt();
                String desc1_set = params.get("desc").asText();
                String roomModelId_set = params.get("roomModelId").asText();
                return gameClubService.setRoomModel(msgKey,  userId, clubId,roomModelId_set,createCommand_set, gameType_set, gameNumber_set, desc1_set);
            case "clubRoomSetId":

                String clubModelId = params.get("clubModelId").asText();
                String roomId = params.get("roomId").asText();
                return gameClubService.clubRoomSetId(clubId,clubModelId,roomId);

            case "clubGameStart":
                String clubModelId1 = params.get("clubModelId").asText();
//                String roomId = params.get("roomId").asText();
                return gameClubService.cludGameStart(clubId, clubModelId1);
            case "getFreeUser":
                return gameClubService.getFreeUser(msgKey,clubId);
            case "invite":
                String inviteUser = params.get("inviteUser").asText();
                String roomId1 = params.get("roomId").asText();
                String roomModel = params.get("roomModel").asText();
                String name = params.get("name").asText();
                return gameClubService.invite(msgKey,clubId, roomId1,inviteUser,roomModel,name);
            case "getClubRecord":
                return gameClubService.getClubRecord(msgKey, userId,clubId);

            case "clubDrawBack":
                String clubModelId2 = params.get("clubModelId").asText();
                return gameClubService.clubDrawBack(clubId,clubModelId2);
            case "kickUser":
                long kickUser = params.get("kickUserId").asLong();
                return gameClubService.kickUser(msgKey, userId, clubId, kickUser);

            case "getChargeRecord":
                return gameClubService.getChargeRecord(msgKey, userId, clubId);
        }
        return 0;
    }
}
