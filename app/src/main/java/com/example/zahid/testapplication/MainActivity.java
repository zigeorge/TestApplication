package com.example.zahid.testapplication;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    private String OSVerstion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        String version = getAppVersionName();
        String deviceName = getDeviceName();
        String OS_VER = getOSVerstion();
        getLocation();
        Log.e("VERSION", version);
        Log.e("DEVICE", deviceName);
        Log.e("OSVERSION", OS_VER);
        textView.setText("VERSION:: " + version + "\nDEVICE:: " + deviceName + "\nOS_VERSION:: " + OS_VER);

    }

    private String getAppVersionName(){
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    public String getOSVerstion() {
        String codename = Build.VERSION.CODENAME;
        String incremental = Build.VERSION.INCREMENTAL;
        String release = Build.VERSION.RELEASE;
        String osName = Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();
        return osName + " " + release;
    }

    public String getLocation() {
//        ArrayList<String> permissions=new ArrayList<>();
//        PermissionUtils permissionUtils;
//
//        permissionUtils=new PermissionUtils(this);
//
//        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
//
//        permissionUtils.check_permission(permissions,"Need GPS permission for getting your location",1);
        return "";
    }
}
