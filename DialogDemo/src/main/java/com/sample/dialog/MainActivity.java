package com.sample.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.CharacterPickerDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;

    private int progress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadView();
        loadListener();
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        button10 = (Button) findViewById(R.id.btn10);
        button11 = (Button) findViewById(R.id.btn11);
    }

    private void loadView() {

    }

    private void loadListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                hintDialog();
                break;
            case R.id.btn2:
                showAlert();
                break;
            case R.id.btn3:
                showInputDialog();
                break;
            case R.id.btn4:
                showCheckDialog();
                break;
            case R.id.btn5:
                showOptionDialog();
                break;
            case R.id.btn6:
                characterPicker();
                break;
            case R.id.btn7:
                datePickerShow();
                break;
            case R.id.btn8:
                progressShow();
                break;
            case R.id.btn9:
                timePicker();
                break;
            case R.id.btn10:
                listDialog();
                break;
            case R.id.btn11:
                ShangJiaDuanDialog();
                break;


        }
    }

    /**
     * Dialog类弹窗
     */
    private void hintDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("提示");

        dialog.setContentView(R.layout.layout_dialog_hint);
        Button dismiss = (Button) dialog.findViewById(R.id.dismiss);

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }



    /**
     * 显示AlertDialog
     */
    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("您启动了一个AlertDialog")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("中立", null)
                .show();

    }

    /**
     * 创建带输入框的提示框
     */
    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");

        final EditText editText = new EditText(this);
        builder.setView(editText);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);

        builder.show();
    }

    /**
     * 创建带复选框的提示框
     */
    private void showCheckDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");

        builder.setMultiChoiceItems(new String[]{"item1", "item2"},new boolean[]{true, false}, null);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);

        builder.show();
    }

    /**
     * 创建带单选按钮的提示框
     */
    private void showOptionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");

        builder.setSingleChoiceItems(new String[]{"item1", "item2"}, 0, null);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);

        builder.show();
    }



    private void characterPicker() {
        Dialog dialog = new CharacterPickerDialog(this, new View(MainActivity.this), null, "0123", false){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + "" , Toast.LENGTH_SHORT).show();
            }
        };
        dialog.show();
    }

    /**
     * 显示日期框
     */
    private void datePickerShow() {
        Dialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, 2016, 11, 10);
        dialog.show();
    }

    private void progressShow() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIndeterminate(false);
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("显示进度条");
        dialog.setMessage("我们在进步");

        dialog.show();


        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                dialog.setProgress(progress);

            }
        };

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (progress < 101) {
                    progress++;
                    handler.sendEmptyMessage(-1);
                } else {
                    this.cancel();
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },100,10);

    }


    private void timePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        }, 10, 53, true);

        timePickerDialog.show();
    }

    private void listDialog() {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.layout_dialog_list);
//        ListView listView = (ListView) dialog.findViewById(R.id.listview_dialog);
//        listView.setAdapter(getAdapter());
//        dialog.show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        builder.setView(R.layout.layout_dialog_list);

        View view = View.inflate(this, R.layout.layout_dialog_list, null);
        ListView listView = (ListView) view.findViewById(R.id.listview_dialog);
        listView.setAdapter(getAdapter());
        dialog.setView(view);
        configDialog(dialog);


    }

    /**
     * 商家端的实现逻辑
     */
    private void ShangJiaDuanDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertTheme);

        dialog.setTitle("分类")
                .setItems(getTestList(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    private void configDialog(AlertDialog.Builder dialog) {
//        WindowManager wm = getWindowManager();
//        Display display = wm.getDefaultDisplay();
//
//        WindowManager.LayoutParams p = getWindow().getAttributes();
//        p.height = (int) (display.getHeight() * 0.5);
//        p.width = (int) (display.getWidth() * 0.7);
//        dialog.show().getWindow().setAttributes(p);

        Window dialogWindow = dialog.show().getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

//        lp.x = 100; // 新位置X坐标
//        lp.y = 100; // 新位置Y坐标
        lp.width = 500; // 宽度
        lp.height = 600; // 高度
        lp.alpha = 0.7f; // 透明度

        dialogWindow.setAttributes(lp);
    }

    /**
     * 获取一个adapter
     * @return
     */
    private MyAdapter getAdapter() {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            list.add(""+i);
        }

        return new MyAdapter(MainActivity.this,list);
    }


    private String[] getTestList() {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 5; i++){
            list.add(""+i);
        }

        String[] arr = (String[]) list.toArray(new String[list.size()]);
        return arr;
    }

















    /**
     * 代码测试区
     */
    private void test() {
        new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light)
                .setTitle("提示")
                .setMessage("您启动了一个AlertDialog")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null).create().show();
    }


}













