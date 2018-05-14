package com.sample.mylibs.NetworkTest;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by haoyundong on 2018/5/14.
 */

public abstract class BaseNetRequest {

    private int connTimeOut = 1000 * 10;
    private int readTimeOut = 1000 * 10;
    private boolean useCaches = false;
    private boolean doInput = true;

    public abstract String get(String urlPath, Map<String, String> params);

    public abstract String post(String urlPath, Map<String, String> params);

    protected StringBuffer getParamString(Map<String, String> params) {
        StringBuffer result = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> param = iterator.next();
            String key = param.getKey();
            String value = param.getValue();
            result.append(key).append('=').append(value);
            if (iterator.hasNext()) {
                result.append('&');
            }
        }
        return result;
    }

    public int getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(int connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public boolean isUseCaches() {
        return useCaches;
    }

    public void setUseCaches(boolean useCaches) {
        this.useCaches = useCaches;
    }

    public boolean isDoInput() {
        return doInput;
    }

    public void setDoInput(boolean doInput) {
        this.doInput = doInput;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }
}
