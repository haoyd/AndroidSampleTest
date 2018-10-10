package com.sample.killgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private Activity mActivity;
    private List<Person> persons = new ArrayList<>();

    private boolean isKilling = false;

    public PersonAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    public void setKilling(boolean killing) {
        isKilling = killing;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mActivity, R.layout.item_person, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bindData(persons.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Person person = persons.get(position);

                if (isKilling) {
                    person.isKilled = true;
                    ToastBox.showBottom(mActivity,  ((position + 1) + "号玩家被杀"));
                    isKilling = false;
                    return;
                }


                String alertMsg = person.isBad ? "你是卧底，接下来请选择一个要杀的人" : "你是平民";
                new AlertDialog.Builder(mActivity)
                        .setTitle("提示")
                        .setMessage(alertMsg)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (person.isBad) {
                                    isKilling = true;
                                }
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }

        public void bindData(Person person) {
            name.setText((person.index + 1) + "号玩家");
        }
    }
}
