package com.sample.preventcheatdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        sb.append("dirCheckVirtual : " + !isFileDirReal + "\n");
        sb.append("PkgCheckVitual : " + isMutiPkg + "\n");
        sb.append("uidCheckVirtual : " + isMutiVirtual + "\n");
    }


}
