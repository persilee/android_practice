package net.lishaoy.retrofitdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class LsyRetrofit {

    final Map<Method, ServiceMethod> serviceMethodMap = new ConcurrentHashMap<>();
    final Call.Factory factory;
    final HttpUrl baseUrl;

    public LsyRetrofit(Call.Factory factory, HttpUrl baseUrl) {
        this.factory = factory;
        this.baseUrl = baseUrl;
    }

    public <T> T create(final Class<T> service) {
        // 使用动态代理解析注解内容
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        ServiceMethod serviceMethod = loadServiceMethod(method);
                        return serviceMethod.invoke(args);
                    }
                });
    }

    private ServiceMethod loadServiceMethod(Method method) {
        //先不上锁，避免synchronized的性能损失
        ServiceMethod result = serviceMethodMap.get(method);
        if (result != null) return result;
        //多线程下，避免重复解析,
        synchronized (serviceMethodMap) {
            result = serviceMethodMap.get(method);
            if (result == null) {
                result = new ServiceMethod.Builder(this, method).build();
                serviceMethodMap.put(method, result);
            }
        }
        return result;
    }

    public static class Builder {
        private HttpUrl baseUrl;
        private Call.Factory factory;

        public Builder callFactory(Call.Factory factory) {
            this.factory = factory;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = HttpUrl.get(baseUrl);
            return this;
        }

        public LsyRetrofit build() {
            if (baseUrl == null) {

            }
            Call.Factory factory1 = this.factory;
            if (factory == null) {
                factory1 = new OkHttpClient();
            }

            return new LsyRetrofit(factory1, baseUrl);
        }
    }

}
