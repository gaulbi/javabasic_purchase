package com.jk.mock.purchase.service;

import com.jk.mock.purchase.bean.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {
    @Autowired
    private PurchaseSerializer kafkaPurchaseSerializer;
    @Autowired
    private PurchaseSerializer rdbmsPurchaseSerializer;
    private final List<PurchaseSerializer> serializers = new ArrayList<>();

    public boolean validatePurchase(Purchase purchase){
        return true;
    }

    public void process(Purchase purchase){
        kafkaPurchaseSerializer.sendToDownstream(purchase);
        rdbmsPurchaseSerializer.sendToDownstream(purchase);
    }
}
