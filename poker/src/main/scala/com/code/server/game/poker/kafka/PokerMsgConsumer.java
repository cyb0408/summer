package com.code.server.game.poker.kafka;

import com.code.server.game.poker.service.MsgDispatch;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author 2017/3/24 14:36
 */
@Component
public class PokerMsgConsumer {

//    @KafkaListener(id = "gameService", topicPartitions = {
//            @TopicPartition(topic = "gameService", partitions = "${serverConfig.serverId}")
//    })
//    public void listen(ConsumerRecord<String, String> record, Acknowledgment ack) {
//        MsgDispatch.dispatch(record);
//        ack.acknowledge();
//    }
//
//
//    @KafkaListener(id = "reconn_topic", topicPartitions = {
//            @TopicPartition(topic = "reconnService", partitions = "${serverConfig.serverId}")
//    })
//    public void listen_reconn(ConsumerRecord<String, String> record, Acknowledgment ack) {
//        MsgDispatch.dispatch(record);
//        ack.acknowledge();
//    }
//
//
//    @KafkaListener(id = "pokerRoomService", topicPartitions = {
//            @TopicPartition(topic = "pokerRoomService", partitions = "${serverConfig.serverId}")
//    })
//    public void listen_room(ConsumerRecord<String, String> record, Acknowledgment ack) {
//        MsgDispatch.dispatch(record);
//        ack.acknowledge();
//    }
}