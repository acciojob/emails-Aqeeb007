package com.driver;

import java.util.Date;

public class Mail {
    public Date date;
    public String sender;
    public String massage;

    public Mail(Date date, String sender, String massage) {
        this.date = date;
        this.sender = sender;
        this.massage = massage;
    }
}