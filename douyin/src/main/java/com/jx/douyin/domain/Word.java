package com.jx.douyin.domain;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/21 17:06
 */
public class Word {
    private String words;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Word{" +
                "words='" + words + '\'' +
                '}';
    }
}
