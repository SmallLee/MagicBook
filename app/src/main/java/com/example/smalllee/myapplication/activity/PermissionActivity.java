package com.example.smalllee.myapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.smalllee.myapplication.R;

// 动态权限申请
/*
* 1、targetSDKVersion < 23 & API(手机系统) < 6.0 ：安装时默认获得权限，且用户无法在安装App之后取消权限。
2、targetSDKVersion < 23 & API(手机系统) >= 6.0 ：安装时默认获得权限，但是用户可以在安装App完成后动态取消授权
（ 取消时手机会弹出提醒，告诉用户这个是为旧版手机打造的应用，让用户谨慎操作 ）。
3、targetSDKVersion >= 23 & API(手机系统) < 6.0 ：安装时默认获得权限，且用户无法在安装App之后取消权限。
4、targetSDKVersion >= 23 & API(手机系统) >= 6.0 ：安装时不会获得权限，可以在运行时向用户申请权限。
用户授权以后仍然可以在设置界面中取消授权，用户主动在设置界面取消后，在app运行过程中可能会出现crash
* */
public class PermissionActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CALL_PHONE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }

    public void callPhone(View view) {
        boolean granted = checkPermission(Manifest.permission.CALL_PHONE);
        if (granted) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18201431960"));
            startActivity(intent);
        } else {
            requestPermission(Manifest.permission.CALL_PHONE);
        }
    }

    public boolean checkPermission(String permission) {
        boolean result = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int targetSdkVersion = getApplicationInfo().targetSdkVersion;
            if (targetSdkVersion > Build.VERSION_CODES.M) {
                result = ContextCompat.checkSelfPermission(this,permission)
                == PackageManager.PERMISSION_GRANTED;
            } else {
                result = PermissionChecker.checkSelfPermission(this,permission)
                        == PackageManager.PERMISSION_GRANTED;
            }
        }
        return result;
    }

    public void requestPermission(String permission) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
            Toast.makeText(this,"shouldShowRequest",Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{permission},REQUEST_CODE_CALL_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 1 && requestCode == REQUEST_CODE_CALL_PHONE) {
            Toast.makeText(this,"可以打电话了",Toast.LENGTH_SHORT).show();
        }
    }
}
