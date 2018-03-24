package com.arunya.aarunya;

/**
 * Created by SOURAV PAUL on 3/21/2018.
 */

public class TransporterAssignmentDetail {

    private String mFrom;
    private String mTo;
    private String mDistance;
    private String mDuration;
    private String mFullPayment;


    /**
     *Constructor
     */
    public TransporterAssignmentDetail (String from,String to,String distance,String duration, String fullPayment) {

        mFrom = from;
        mTo = to;
        mDistance = distance;
        mDuration = duration;
        mFullPayment = fullPayment;
    }

    /**
     * Get From
     */

    public String getFrom() {

        return mFrom;
    }

    /**
     * Get To
     */

    public String getTo() {

        return mTo;
    }

    /**
     * Get Distance
     */

    public String getDistance() {

        return mDistance;
    }

    /**
     * Get Duration
     */

    public String getDuration() {

        return mDuration;
    }

    /**
     * Get full Payment Details
     */

    public String getFullPayment() {

       return mFullPayment;
    }
}
