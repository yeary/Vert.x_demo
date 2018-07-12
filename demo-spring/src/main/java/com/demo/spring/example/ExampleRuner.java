package com.demo.spring.example;

import com.alibaba.fastjson.JSON;
import com.demo.spring.example.article.WebEchoArticle;
import com.demo.spring.example.config.ConfigSource;
import com.demo.spring.example.context.ExampleSpringConfiguration;
import com.demo.spring.example.context.InitUccAnnotationBean;
import com.jd.security.configsec.JDSecurityPropertyInterface;
import com.jd.security.configsec.codec.binary.Base64;
import com.jd.security.configsec.spring.config.JDSecurityLoader;
import com.jd.security.org.xeustechnologies.jcl.JarClassLoader;
import com.jd.security.org.xeustechnologies.jcl.JclObjectFactory;
import io.vertx.core.Vertx;
import javassist.ClassPool;
import javassist.CtClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.security.provider.certpath.Vertex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yangyang115 on 18-7-4.
 */
public class ExampleRuner {


    public static void main(String[] srcs){
        ApplicationContext context = new AnnotationConfigApplicationContext(ExampleSpringConfiguration.class);
        System.out.println(JSON.toJSON(context.getBean("configSource")));

    }
}
