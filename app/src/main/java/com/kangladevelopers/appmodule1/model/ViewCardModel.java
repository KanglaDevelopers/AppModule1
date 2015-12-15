package com.kangladevelopers.appmodule1.model;

/**
 * Created by HUIDROM on 11/14/2015.
 */
public class ViewCardModel {
    private String BubbleText;
    private String title;
    private String messageBody;

    public ViewCardModel(String bubbleText, String title, String messageBody) {
        BubbleText = bubbleText;
        this.title = title;
        this.messageBody = messageBody;
    }

    public String getBubbleText() {
        return BubbleText;
    }

    public void setBubbleText(String bubbleText) {
        BubbleText = bubbleText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
