package com.demo.web.simple.comment.utils;

import com.demo.web.simple.route.HttpMethodEnum;
import com.demo.web.simple.route.RouteMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class RouteMappingPropertyUtil {
    private RouteMappingPropertyUtil() {
    }

    private static Properties properties = new Properties();

    static {
        String[] fileNames = new String[]{"route-mapping.properties"};
        for (String fileName : fileNames) {
            try {
                InputStream inputStream = RouteMappingPropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
                if (inputStream != null) {
                    properties.load(inputStream);
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static RouteMapping getRouteMapping(String key) {
        String property = (String) properties.get(key);
        if (property != null && !property.isEmpty()) {
            String[] rmapStrs = property.split("#");
            RouteMapping mapping = new RouteMapping(rmapStrs[0], HttpMethodEnum.valueOf(rmapStrs[1]), rmapStrs[2].split(","));
            return mapping;
        }
        return null;
    }

    public static Set<Object> getPropertyKeys() {
        return properties.keySet();
    }

    public static Set<RouteMapping> getRouteMappings(){
        Set<RouteMapping> routeMappings = new HashSet<>();
        Set<Object> keys = properties.keySet();
        for (Object key: keys){
            routeMappings.add(getRouteMapping(key.toString()));
        }
        return routeMappings;
    }

}