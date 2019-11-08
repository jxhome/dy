package com.jx.douyin.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.jx.douyin.dao.DyMapper;
import com.jx.douyin.domain.Douyin;
import com.jx.douyin.domain.Ocr;
import com.jx.douyin.domain.Word;
import com.jx.douyin.domain.enums.MailContentTypeEnum;
import com.jx.douyin.service.DyServcie;
import com.jx.douyin.utils.BdOcrUtils;
import com.jx.douyin.utils.CutPictureUtils;
import com.jx.douyin.utils.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/21 15:09
 */
@Service
public class DyServiceImpl extends ServiceImpl<DyMapper,Douyin> implements DyServcie{
    @Autowired
    private DyMapper dyMapper;

    @Override
    public void dyinfo(String url,String mail){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String pathName = "F:/"+df.format(new Date())+".jpg";
        //截取图片
        //String url = "https://www.iesdouyin.com/share/user/60693152856?u_code=kd1e4m5c&timestamp=1557662180";
        CutPictureUtils.getImg(pathName,url);
        //图片识别
        String imgStr = BdOcrUtils.getImgStr(pathName);
        Gson gson = new Gson();
        Ocr ocr = gson.fromJson(imgStr, Ocr.class);
        List<Word> wordList = ocr.getWords_result();
        Douyin douyin = new Douyin();
        for(Word word:wordList){
            //System.out.println(word.toString());
            if(word.getWords().contains("喜欢")){
                //word.getWords().substring(word.getWords().lastIndexOf("喜欢"));
                douyin.setLoveNum(Integer.parseInt(word.getWords().substring(2)));
            }
            if(word.getWords().contains("作品")){
                douyin.setWorkNum(Integer.parseInt(word.getWords().substring(2)));
            }
            if(word.getWords().contains("粉丝")){
                String str = word.getWords().replace("关注", "/").replace("粉丝", "/")
                        .replace("赞", "/");
                System.out.println(str);
                String[] strs = str.split("/");
                douyin.setFollowNum(Integer.parseInt(strs[0]));
                douyin.setFansNum(strs[1]);
            }
        }

        System.out.println("您的抖音数据"+douyin.toString());
        Douyin lastData = baseMapper.lastData();
        if(lastData != null){
            if(!lastData.getLoveNum().equals(douyin.getLoveNum()) || !lastData.getFollowNum().equals(douyin.getFollowNum())
                    || !lastData.getWorkNum().equals(douyin.getWorkNum())){
                //数据存入数据库
                this.save(douyin);
                try {
                    //发送邮件
                    new MailSender()
                            .title("抖音监控提醒")
                            .content("您关注的用户抖音有新动态了！点击查看："+url)
                            .contentType(MailContentTypeEnum.TEXT)
                            .targets(new ArrayList<String>(){{
                                add(mail);
                            }})
                            .send();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            this.save(douyin);
            try {
                new MailSender()
                        .title("抖音监控提醒")
                        .content("添加抖音动态监控成功！点击查看："+url)
                        .contentType(MailContentTypeEnum.TEXT)
                        .targets(new ArrayList<String>(){{
                            add(mail);
                        }})
                        .send();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
