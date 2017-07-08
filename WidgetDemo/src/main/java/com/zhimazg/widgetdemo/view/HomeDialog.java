package com.zhimazg.widgetdemo.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.zhimazg.widgetdemo.R;

/**
 * Created by haoyundong on 2017/2/14.
 */

public class HomeDialog extends Dialog {

    public HomeDialog(Context context) {
        super(context, R.style.LoadingDialog);
    }



        public static class Builder{
        private HomeDialog dialog;
        private View dialogView;
        private Context context;
        private int contentGravity = Gravity.CENTER;
        private int dialogGravity = Gravity.CENTER;
        private boolean isSystemDialog = false;

        public Builder(Context context) {
            this.context = context;
        }

        public View getDialogView() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            dialog = new HomeDialog(context);
            dialogView = inflater.inflate(R.layout.view_dialog, null);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = dialogGravity;

            dialog.setContentView(dialogView, params);

            return dialogView;
        }

        public void show() {
            if (context == null) {
                return;
            }
            if (context instanceof Activity && ((Activity) context).isFinishing()) {
                return;
            }
            getDialogView();
            dialog.show();
        }

    }


}
