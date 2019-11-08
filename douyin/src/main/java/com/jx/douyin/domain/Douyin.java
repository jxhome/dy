package com.jx.douyin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/21 17:19
 */
@Data
@TableName("dy")
public class Douyin {
    @TableId
    private Integer id;
    //喜欢
    private Integer loveNum;
    //作品
    private Integer workNum;
    //关注
    private Integer followNum;
    //粉丝
    private String fansNum;
}
