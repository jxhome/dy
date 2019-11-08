package com.jx.douyin.utils;


import com.jx.douyin.domain.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/8
 * Time：20:49
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public class TestMail {
    public static void main(String[] args) throws Exception
    {
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单文本内容发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("1052280265@qq.com");
                }})
                .send();
    }
}
