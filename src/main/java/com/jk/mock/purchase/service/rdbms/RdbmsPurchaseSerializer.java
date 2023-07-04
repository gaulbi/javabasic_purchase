package com.jk.mock.purchase.service.rdbms;

import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.PurchaseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdbmsPurchaseSerializer implements PurchaseSerializer {
    @Autowired private PurchaseRepository purchaseRepository;
    @Override
    public void sendToDownstream(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
