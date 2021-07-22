package net.techtter.springkafkadocker.springkafkadockerint.controller;

import net.techtter.springkafkadocker.springkafkadockerint.model.Book;
import net.techtter.springkafkadocker.springkafkadockerint.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "my_topic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC, book);
        return "Livro Salvo com Sucesso";
    }

}
