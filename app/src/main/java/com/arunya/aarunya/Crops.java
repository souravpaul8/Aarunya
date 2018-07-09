package com.arunya.aarunya;

/**
 * Created by SOURAV PAUL on 3/16/2018.
 */

public class Crops {

    private String mCrop;
    private String mQuantity;
    private String mPrice;
    private String mDistrict;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constructor
     */
    public Crops(String crop, String quantity, String price, String district, int imageResourceId) {

        mCrop = crop;
        mQuantity = quantity;
        mPrice = price;
        mDistrict = district;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get Crop Type
     */

    public String getCrop() {

        return mCrop;
    }

    /**
     * Get Quantity of Crops
     */

    public String getQuantity() {

        return mQuantity;
    }

    /**
     * Get Price of Crops
     */

    public String getPrice() {

        return mPrice;
    }

    /**
     * Get District of Crops
     */

    public String getDistrict() {

        return mDistrict;
    }

    /**
     * Get Image for the Crop
     **/

    public int getImageResourceId() {

        return mImageResourceId;
    }
}
