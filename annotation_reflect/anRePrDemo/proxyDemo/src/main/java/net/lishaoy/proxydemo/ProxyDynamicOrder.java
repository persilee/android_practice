package net.lishaoy.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynamicOrder implements InvocationHandler {

    private Object orderService;

    public Object getOrderService() {
        return orderService;
    }

    public void setOrderService(Object orderService) {
        this.orderService = orderService;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                orderService.getClass().getClassLoader(),
                orderService.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(orderService, objects);
    }
}
