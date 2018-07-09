package com.arunya.aarunya;

/**
 * Created by SOURAV PAUL on 3/31/2018.
 */

public class FindTransporterInfo {

    private String mName;
    private String mTypeOfTruck;
    private String mQuantity;
    private String mDistrict;
    private String mVehicleNumber;

    public FindTransporterInfo(String mName, String mTypeOfTruck, String mQuantity, String mDistrict, String mVehicleNumber) {
        this.mName = mName;
        this.mTypeOfTruck = mTypeOfTruck;
        this.mQuantity = mQuantity;
        this.mDistrict = mDistrict;
        this.mVehicleNumber = mVehicleNumber;
    }

    public String getmName() {
        return mName;
    }

    public String getmTypeOfTruck() {
        return mTypeOfTruck;
    }

    public String getmQuantity() {
        return mQuantity;
    }

    public String getmDistrict() {
        return mDistrict;
    }

    public String getmVehicleNumber() {
        return mVehicleNumber;
    }
}
