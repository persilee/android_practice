package net.lishaoy.base.autoservice;

import java.util.ServiceLoader;

public class AutoServiceLoader {

    public static <T> T load(Class<T> service) {
        try {
            return ServiceLoader.load(service).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

}
