package com.arunya.aarunya;

/**
 * Created by SOURAV PAUL on 3/29/2018.
 */

public class EnquiryInfo {

    private String name;
    private String mail;
    private  String enquiry;

    public EnquiryInfo(String name, String mail, String enquiry) {
        this.name = name;
        this.mail = mail;
        this.enquiry = enquiry;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getEnquiry() {
        return enquiry;
    }
}
