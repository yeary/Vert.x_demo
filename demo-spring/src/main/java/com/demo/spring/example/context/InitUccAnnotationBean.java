package com.demo.spring.example.context;

import com.demo.spring.example.config.ConfigSource;
import com.demo.spring.example.spring.config.UccConfig;
import com.demo.spring.example.spring.config.UccConfigSource;

public class InitUccAnnotationBean {

    @UccConfigSource("xxAdfConfigSource")
    private ConfigSource xxAdfConfigSource;


    @UccConfig(name = "xxAdfConfig", source = "xxAdfConfigSource")
    private com.demo.spring.example.config.UccConfig xxAdfConfig;

    public ConfigSource getXxAdfConfigSource() {
        return xxAdfConfigSource;
    }

    public void setXxAdfConfigSource(ConfigSource xxAdfConfigSource) {
        this.xxAdfConfigSource = xxAdfConfigSource;
    }

    public com.demo.spring.example.config.UccConfig getXxAdfConfig() {
        return xxAdfConfig;
    }

    public void setXxAdfConfig(com.demo.spring.example.config.UccConfig xxAdfConfig) {
        this.xxAdfConfig = xxAdfConfig;
    }
}