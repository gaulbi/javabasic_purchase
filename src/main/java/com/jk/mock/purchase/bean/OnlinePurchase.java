package com.jk.mock.purchase.bean;

import lombok.Data;

@Data
public class OnlinePurchase {
    private String invoiceId;
    private String userId;
    private String itemId;
    private int quantity;
    private double price;
    private boolean vip;
}
