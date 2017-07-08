package com.zhimazg.explorerdown;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.order_down);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://test.api.supply.zhimazg.com/user/my_order_pdf?&token=1482467171d275cd0dc398ee27f5bcfd2bf77fca34uid3&batch_group_id=84");
                intent.setData(content_url);
                startActivity(intent);
            }
        });
    }
}
