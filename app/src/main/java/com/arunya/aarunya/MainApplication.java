package com.arunya.aarunya;

import android.app.Application;
import android.content.Context;
/**
 * Created by SOURAV PAUL on 3/10/2018.
 */

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}

