package com.arunya.aarunya;

/**
 * Created by SOURAV PAUL on 3/10/2018.
 */

public class UserInformation {

    private String name;
    private String dob;
    // private String state;
    // private String district;
    private String address;
    private String phone_num;
    private String aadhaar;
    private String registerAs;


    public UserInformation(String name, String dob, String address,
                           String phone_num, String aadhaar, String registerAs) {
        this.name = name;
        this.dob = dob;
        //this.state = state;
        //this.district = district;
        this.address = address;
        this.phone_num = phone_num;
        this.aadhaar = aadhaar;
        this.registerAs = registerAs;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterAs() {
        return registerAs;
    }

    public void setRegisterAs(String name) {
        this.registerAs = registerAs;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    //public String getState() {
    //    return state;
    // }

    //public void setState(String state) {
    //   this.state = state;
    //}


    //public String getDistrict() {
    //  return district;
    //}

    //public void setDistrict(String district) {
    //  this.district = district;
    //}


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }


}