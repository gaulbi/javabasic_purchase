package com.jk.mock.purchase.kafka;

import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.Processor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class StoreListener {
    @Autowired private Processor processor;
    @KafkaListener(topics = "STORE", groupId = "app")
    public void purchaseListen(String message){
        JSONObject jsonObject = new JSONObject(message);
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(jsonObject.optString("purchaseId"));
        purchase.setCustomerId(jsonObject.optString("customerId"));
        purchase.setQuantity(jsonObject.optInt("quantity"));
        purchase.setPrice(jsonObject.optDouble("price"));
        purchase.setProductId(jsonObject.optString("productId"));

        boolean isValidPurchase = processor.validatePurchase(purchase);
        if(isValidPurchase){
            processor.process(purchase);
        }
    }
}
