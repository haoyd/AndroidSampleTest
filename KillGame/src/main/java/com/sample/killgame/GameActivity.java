package com.sample.killgame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private RecyclerView listView;
    private PersonAdapter adapter;
    private TextView msgShow;

    private List<Person> persons = new ArrayList<>();

    private int totalNum = 0;
    private int badNum = 0;

    private int badIndex = 0;

    public static Intent getGameIntent(Context context, int total, int bad) {
        Intent intent = new Intent(context, GameActivity.class);
        intent.putExtra("total", total);
        intent.putExtra("bad", bad);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        msgShow = findViewById(R.id.tv_msg_show);
        listView = findViewById(R.id.rv_game);
        adapter = new PersonAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);
        initData();

        adapter.setPersons(persons);
    }

    private void initData() {
        totalNum = getIntent().getIntExtra("total", 0);
        badNum = getIntent().getIntExtra("bad", 1);

        if (totalNum < 2) {
            ToastBox.showBottom(this, "人数不够");
            return;
        }

        for (int i = 0; i < totalNum; i++) {
            persons.add(new Person(i));
        }

        Random rand = new Random();
        badIndex = rand.nextInt(totalNum);
        persons.get(badIndex).isBad = true;
    }

    public void verify(View view) {
        String msg = "被杀的人是:\n";
        for (Person person : persons) {
            if (person.isKilled) {
                msg = msg + (person.index + 1) + "号玩家\n";
            }
        }

        msgShow.setText(msg);
        adapter.setKilling(false);
    }
}
