package com.jk.mock.purchase.service.kafka;

import com.jk.mock.purchase.bean.Purchase;
import com.jk.mock.purchase.service.PurchaseSerializer;

public class KafkaPurchaseSerializer implements PurchaseSerializer {
    @Override
    public void sendToDownstream(Purchase purchase) {

    }
}
