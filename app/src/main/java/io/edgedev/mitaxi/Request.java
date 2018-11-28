package io.edgedev.mitaxi;


/**
 * Created by OPEYEMI OLORUNLEKE on 6/15/2017.
 */

public class Request {
    private String mUserID;
    private String mName;
    private String mEmail;
    private String mDriverName;

    public Request() {
    }

    public Request(String userID, String name, String email) {
        mUserID = userID;
        mName = name;
        mEmail = email;
        this.mDriverName = "";
    }

    public String getUserID() {
        return mUserID;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setDriverName(String driverName) {
        this.mDriverName = driverName;
    }

    public String getDriverName(String driverName) {
        return mDriverName;
    }
}
