package com.halfacode;

import com.halfacode.entity.WikimediaData;
import com.halfacode.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);


    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics ="wikimedia_recentchange",
             groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("message Recieved -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaRepository.save(wikimediaData);
    }
}
