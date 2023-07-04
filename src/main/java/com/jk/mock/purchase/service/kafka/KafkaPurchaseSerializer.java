package com.jk.mock.purchase.service.kafka;

import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.PurchaseSerializer;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPurchaseSerializer implements PurchaseSerializer {
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void sendToDownstream(Purchase purchase) {
       kafkaTemplate.send("DOWN", purchase.toString());
    }
}
