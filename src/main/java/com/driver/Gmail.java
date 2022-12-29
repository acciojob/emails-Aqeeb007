package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Gmail extends Email {

    public class Pair{
        Date date;
        String massage;

        public Pair(Date date, String massage) {
            this.date = date;
            this.massage = massage;
        }
    }
    int inboxCapacity; //maximum number of mails inbox can store
    List<Pair> Inbox = new ArrayList<>();
    Stack<Date> stk = new Stack<>();

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(Inbox.size() < inboxCapacity){
            Inbox.add(new Pair(date,message));
        }else {
            Inbox.remove(0);
            stk.push(date);
            Inbox.add(new Pair(date,message));
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int inboxSize = getInboxSize();

        if(inboxSize != 0){
            for (int i = 0; i < Inbox.size(); i++) {
                Pair p = Inbox.get(i);
                if(p.massage.equals(message)){
                    Inbox.remove(i);
                    stk.push(p.date);
                    break;
                }
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        int l = Inbox.size();
        if(l == 0){
            return null;
        }else{
            Pair p = Inbox.get(Inbox.size()-1);
            return p.massage;
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        int l = Inbox.size();
        if(l == 0){
            return null;
        }else{
            Pair p = Inbox.get(0);
            return p.massage;
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int tMail = 0;
        for(Pair p : Inbox){
            if(p.date.compareTo(start) >= 0 && p.date.compareTo(end) <= 0){
                tMail++;
            }
        }
        return tMail;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return stk.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        while (stk.size() > 0){
            stk.pop();
        }
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
