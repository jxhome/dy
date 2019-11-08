package com.jx.douyin.domain;

import java.util.List;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/21 16:53
 */
public class Ocr {
    private String log_id;
    private List<Word> words_result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public List<Word> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<Word> words_result) {
        this.words_result = words_result;
    }

    @Override
    public String toString() {
        return "Douyin{" +
                "log_id=" + log_id +
                ", words_result=" + words_result +
                '}';
    }
}
