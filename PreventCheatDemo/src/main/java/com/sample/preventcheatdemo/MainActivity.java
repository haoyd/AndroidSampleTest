package com.sample.preventcheatdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lahm.library.EasyProtectorLib;
import com.lahm.library.VirtualApkCheckUtil;

public class MainActivity extends AppCompatActivity {

    private TextView msgView;

    private StringBuilder sb = new StringBuilder();

    private CheatManager cheatManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgView = findViewById(R.id.tv_main);

        initData();

        msgView.setText(sb.toString());

    }

    private void initData() {
        cheatManager = new CheatManager(getApplicationContext());

        sb.append("package ：" + getPackageName() + "\n");
        sb.append("FileDir ：" + getFilesDir().getAbsolutePath() + "\n");

        boolean isFileDirReal = cheatManager.isFireDirQualified();
        boolean isMutiPkg = cheatManager.isMutiPkg();
        boolean isMutiVirtual = CheckVirtual.isRunInVirtual();

//        sb.append("dirCheckVirtual : " + !isFileDirReal + "\n");
//        sb.append("PkgCheckVitual : " + isMutiPkg + "\n");
//        sb.append("uidCheckVirtual : " + isMutiVirtual + "\n");

        sb.append((VirtualApkCheckUtil.getSingleInstance().checkByPrivateFilePath(this) ? "私有路径检测有多开" : "私有路径检测正常") + "\n");
        sb.append((VirtualApkCheckUtil.getSingleInstance().checkByOriginApkPackageName(this) ? "包名检测有多开" : "包名检测正常") + "\n");
        sb.append((VirtualApkCheckUtil.getSingleInstance().checkByMultiApkPackageName() ? "maps检测有多开" : "maps检测正常") + "\n");
        sb.append((EasyProtectorLib.checkIsUsingMultiVirtualApp() ? "ps检测有多开" : "ps检测正常") + "\n");
        sb.append((VirtualApkCheckUtil.getSingleInstance().checkByHasSameUid() ? "uid检测有多开" : "uid检测正常") + "\n");
    }


}
