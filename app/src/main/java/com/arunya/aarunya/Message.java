package com.arunya.aarunya;

import java.util.Date;

/**
 * Created by RAJ on 24-03-2018.
 */

public class Message
{
    private String mText;
    private String mSender;
    private Date mDate;
    /*for getting date on the message */
    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }







}
