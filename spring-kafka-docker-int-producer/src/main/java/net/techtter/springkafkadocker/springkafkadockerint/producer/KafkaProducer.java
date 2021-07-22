package net.techtter.springkafkadocker.springkafkadockerint.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC= "my_topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void writeMessage(String msg){
        this.kafkaTemplate.send(TOPIC,msg);
    }

}
