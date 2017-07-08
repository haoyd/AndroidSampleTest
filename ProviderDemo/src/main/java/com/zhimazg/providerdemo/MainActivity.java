package com.zhimazg.providerdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mContext = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "您点击了设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_from_native:
                getFromNative();
                break;
            case R.id.action_from_sim:
                getFromSim();
                break;
            case R.id.action_data_put:
                putDataToContent("Eric");
                break;
            case R.id.action_data_pick:
                pickDataToContent();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 获取本地的通讯录
     */
    private void getFromNative() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap<String, ContractInfo> map = new HashMap<String, ContractInfo>();
                ContentResolver resolver = mContext.getContentResolver();
                // 获取手机联系人
                Cursor phoneCursor = resolver.query(Phone.CONTENT_URI, null, null, null, null);

                if (phoneCursor != null) {
                    while (phoneCursor.moveToNext()) {
                        int nameIndex = phoneCursor.getColumnIndex(Phone.DISPLAY_NAME);
                        String name = phoneCursor.getString(nameIndex);
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(Phone.NUMBER));
                        if (!TextUtils.isEmpty(phoneNumber)) {
                            map.put(name, new ContractInfo(name, phoneNumber));
                            continue;
                        }
                    }
                }

                Set set = map.keySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    ContractInfo contractInfo = map.get(key);
                    Log.i(TAG, key + ":" + contractInfo.getPhone());
                }
            }
        }).start();


    }

    /**
     * 获取网络的通讯录
     */
    private void getFromSim() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getSimState() == TelephonyManager.SIM_STATE_READY) {
            //一般用这个
//            String url = "content://icc/adn";
            //上面的地址不行用下面这个,新测红米note上是用的这个。
            String url = "content://sim/adn";
//            Intent intent = new Intent();
//            intent.setData(Uri.parse(url));
            Uri uri = Uri.parse(url);

            ContentResolver resolver = mContext.getContentResolver();
            // 获取手机联系人
            Cursor mCursor = resolver.query(uri, null, null, null, null);

            HashMap<String, ContractInfo> map = new HashMap<String, ContractInfo>();

            if (mCursor != null) {
                while (mCursor.moveToNext()) {
                    int nameIndex = mCursor.getColumnIndex(Phone.DISPLAY_NAME);
                    String name = mCursor.getString(nameIndex);
                    String phoneNumber = mCursor.getString(mCursor.getColumnIndex(Phone.NUMBER));
                    if (!TextUtils.isEmpty(phoneNumber)) {
                        map.put(name, new ContractInfo(name, phoneNumber));
                        continue;
                    }
                }

                Set set = map.keySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    ContractInfo contractInfo = map.get(key);
                    Log.i(TAG, key + ":" + contractInfo.getPhone());
                }

            } else {
                Toast.makeText(mContext, "您的SIM上未绑定数据", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(mContext, "SIM卡不存在", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 存放数据
     */
    private void putDataToContent(String userName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyUsers.User.USER_NAME, userName);
        getContentResolver().insert(MyUsers.User.CONTENT_URI, contentValues);
    }

    /**
     * 取数据
     */
    private void pickDataToContent() {
        String columns[] = new String[]{MyUsers.User._ID, MyUsers.User.USER_NAME};
        Uri myUri = MyUsers.User.CONTENT_URI;
        Cursor cur = managedQuery(myUri, columns, null, null, null);
        if (cur.moveToFirst()) {
            String id = null;
            String userName = null;
            do {
                id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
                userName = cur.getString(cur.getColumnIndex(MyUsers.User.USER_NAME));
                Toast.makeText(this, id + " " + userName, Toast.LENGTH_LONG).show();
            } while (cur.moveToNext());
        }
    }


}













