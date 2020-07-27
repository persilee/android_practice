package net.lishaoy.proxydemo;

import net.lishaoy.proxydemo.service.OrderService;
import net.lishaoy.proxydemo.service.impl.ImplKoreaOrderService;

public class ProxyKoreaOrder implements OrderService {

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int saveOrder() {
        System.out.print("韩国代购订单，");
        return orderService.saveOrder();
    }
}
