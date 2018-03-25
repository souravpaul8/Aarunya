package com.arunya.aarunya;
import android.app.Application;
import com.firebase.client.Firebase;
/**
 * Created by Raj_Sinha on 3/24/2018.
 */

public class AppLifeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}