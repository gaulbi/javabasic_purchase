package com.jk.mock.purchase.service;

import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.kafka.KafkaPurchaseSerializer;
import com.jk.mock.purchase.service.rdbms.RDBMSPurchaseSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {
    private final List<PurchaseSerializer> serializers = new ArrayList<>();

    public Processor(){
        serializers.add(new RDBMSPurchaseSerializer());
        serializers.add(new KafkaPurchaseSerializer());
    }

    public boolean validatePurchase(Purchase purchase){
        return true;
    }

    public void process(Purchase purchase){
        for (PurchaseSerializer serializer: serializers){
            serializer.sendToDownstream(purchase);
        }
    }
}
