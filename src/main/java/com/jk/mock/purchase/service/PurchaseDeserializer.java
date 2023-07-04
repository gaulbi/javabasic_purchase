package com.jk.mock.purchase.service;

import com.jk.mock.purchase.bean.Purchase;

public interface PurchaseDeserializer {
    Purchase convert(String purchase);
}
