package com.demo.web.simple.route;

/**
 * Created by yangyang115 on 18-7-14.
 */
public class RouteMapping {

    private String path;
    private HttpMethodEnum method;
    private String[] handles;

    public RouteMapping() {
    }

    public RouteMapping(String path, HttpMethodEnum method, String[] handles) {
        this.path = path;
        this.method = method;
        this.handles = handles;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethodEnum getMethod() {
        return method;
    }

    public void setMethod(HttpMethodEnum method) {
        this.method = method;
    }

    public String[] getHandles() {
        return handles;
    }

    public void setHandles(String[] handles) {
        this.handles = handles;
    }
}
