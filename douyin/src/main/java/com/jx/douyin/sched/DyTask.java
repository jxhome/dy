package com.jx.douyin.sched;

import com.jx.douyin.service.DyServcie;
import com.jx.douyin.utils.DateUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/22 9:11
 */
@Component
public class DyTask {
    @Autowired
    private DyServcie dyServcie;

    //@Scheduled(cron = "0 0/1 * * * ? ")
    @Scheduled(cron = "0/30 * * * * ?  ")
    public void dyCron(){
        System.setProperty("java.awt.headless", "false");
        dyServcie.dyinfo("https://www.iesdouyin.com/share/user/84282652000","1052280265@qq.com");
        System.out.println("执行时间："+ DateUtis.getCurrentDate());
    }
}
