package net.lishaoy.proxydemo;

import net.lishaoy.proxydemo.service.OrderService;
import net.lishaoy.proxydemo.service.impl.ImplJapanOrderService;
import net.lishaoy.proxydemo.service.impl.ImplKoreaOrderService;
import net.lishaoy.proxydemo.service.impl.ImplOrderService;
import net.lishaoy.proxydemo.utils.ProxyUtil;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        // 静态代理模式
        // 国内订单
        OrderService order = new ImplOrderService();
        order.saveOrder();
        // 日本代购订单
        OrderService orderJapan = new ImplJapanOrderService();
        ProxyJapanOrder proxyJapanOrder = new ProxyJapanOrder();
        proxyJapanOrder.setOrderService(orderJapan);
        proxyJapanOrder.saveOrder();
        // 韩国代购订单
        OrderService orderKorea = new ImplKoreaOrderService();
        ProxyKoreaOrder proxyKoreaOrder = new ProxyKoreaOrder();
        proxyKoreaOrder.setOrderService(orderKorea);
        proxyKoreaOrder.saveOrder();

        // 动态代理模式
        // 普通订单
        ProxyDynamicOrder proxyDynamicOrder = new ProxyDynamicOrder();
        OrderService orderService = new ImplOrderService();
        proxyDynamicOrder.setOrderService(orderService);
        OrderService orderService1 = (OrderService) proxyDynamicOrder.getProxyInstance();
        orderService1.saveOrder();

        // 日本代购订单
        OrderService japanOrderService = new ImplJapanOrderService();
        proxyDynamicOrder.setOrderService(japanOrderService);
        OrderService japanOrderService1 = (OrderService) proxyDynamicOrder.getProxyInstance();
        japanOrderService1.saveOrder();

        // 韩国代购订单
        OrderService koreaOrderService = new ImplKoreaOrderService();
        proxyDynamicOrder.setOrderService(koreaOrderService);
        OrderService koreaOrderService1 = (OrderService) proxyDynamicOrder.getProxyInstance();
        koreaOrderService1.saveOrder();

        // 生成动态代理生成的class文件
        ProxyUtil.generateClassFile(koreaOrderService.getClass(), koreaOrderService1.getClass().getSimpleName());

    }

}
