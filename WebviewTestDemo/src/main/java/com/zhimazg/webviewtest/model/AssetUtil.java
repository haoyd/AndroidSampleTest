package com.zhimazg.webviewtest.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by haoyundong on 2016/11/1.
 */

public class AssetUtil {

    private static AssetManager assetManager;


    public static String file2String(Context context, String fileName) {
        assetManager = context.getAssets();
        try {
            InputStreamReader inputReader = new InputStreamReader( assetManager.open(fileName) );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String Result="";
            while((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
