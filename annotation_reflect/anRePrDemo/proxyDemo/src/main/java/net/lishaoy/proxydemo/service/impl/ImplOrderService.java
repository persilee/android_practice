package net.lishaoy.proxydemo.service.impl;

import net.lishaoy.proxydemo.service.OrderService;

public class ImplOrderService implements OrderService {

    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号为：666666");
        return 666666;
    }
}
