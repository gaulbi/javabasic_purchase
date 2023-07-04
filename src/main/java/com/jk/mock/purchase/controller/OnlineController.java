package com.jk.mock.purchase.controller;

import com.jk.mock.purchase.bean.OnlinePurchase;
import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineController {
    private static final double VIP_DISCOUNT = 0.2d;
    @Autowired private Processor processor;

    @PostMapping("/v/post/purchase")
    public ResponseEntity<String> purchasePost(@RequestBody OnlinePurchase onlinePurchase){
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(onlinePurchase.getInvoiceId());
        purchase.setCustomerId(onlinePurchase.getUserId());
        purchase.setProductId(onlinePurchase.getItemId());
        purchase.setQuantity(onlinePurchase.getQuantity());
        if(onlinePurchase.isVip()){
            purchase.setPrice(onlinePurchase.getPrice() - (onlinePurchase.getPrice() * VIP_DISCOUNT));
        } else {
            purchase.setPrice(onlinePurchase.getPrice());
        }

        boolean isValidPurchase = processor.validatePurchase(purchase);
        if(isValidPurchase){
            processor.process(purchase);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
