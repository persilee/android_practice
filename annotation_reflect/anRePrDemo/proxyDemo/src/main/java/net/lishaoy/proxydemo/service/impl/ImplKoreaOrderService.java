package net.lishaoy.proxydemo.service.impl;

import net.lishaoy.proxydemo.service.OrderService;

public class ImplKoreaOrderService implements OrderService {

    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号为：666888");
        return 666888;
    }
}
