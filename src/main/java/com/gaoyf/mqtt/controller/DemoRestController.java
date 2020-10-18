package com.gaoyf.mqtt.controller;

import com.gaoyf.mqtt.core.IMQTTPublisher;
import com.gaoyf.mqtt.core.IMQTTSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;


import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author gaoyf
 * @since 2020/4/9 0009 16:14
 * <p>
 * 测试controller
 */

@RestController
public class DemoRestController {
//    public static String TOPIC_LOOP_TEST = "mqtt/loop/message";
    public static String TOPIC_LOOP_TEST = "hotel_sub_gateway002";

    @Autowired
    IMQTTPublisher publisher;

    @Autowired
    IMQTTSubscriber subscriber;

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行，init（）方法之前执行。PreDestroy（）方法在destroy（）方法知性之后执行
     * 这里初始化订阅一个主题
     */
    @PostConstruct
    public void init() {
        subscriber.subscribeMessage(TOPIC_LOOP_TEST);
    }


    /**
     * 向指定主题发送消息
     *
     * @param data 数据
     * @return 响应
     */
    @RequestMapping(value = "/mqtt/push/message", method = RequestMethod.POST)
    public String index(@RequestBody String data) {
        System.out.println(data);
        List<String> contentList = new ArrayList<>();
        contentList.add("hote_sub_gateway");
        contentList.add("hotel_sub_gateway001");
        contentList.add("hotel_sub_gateway002");
        System.out.println("for test");
        System.out.println("for test");
        System.out.println("for test");
        System.out.println("for test");
        System.out.println("for test");
        System.out.println("for test");


        for (int i = 0; i<contentList.size(); i++) {
        publisher.publishMessage(contentList.get(i), data);

    }
        return "Success";
    }

}
