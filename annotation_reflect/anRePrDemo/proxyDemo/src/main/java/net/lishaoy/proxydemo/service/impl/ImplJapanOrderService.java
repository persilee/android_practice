package net.lishaoy.proxydemo.service.impl;

import net.lishaoy.proxydemo.service.OrderService;

public class ImplJapanOrderService implements OrderService {
    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号为：888888");
        return 888888;
    }
}
