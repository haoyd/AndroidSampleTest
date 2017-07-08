package com.zhimazg.UnitTesst;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by haoyundong on 2017/4/6.
 */

public class BaseUiAutomatorTestCase extends UiAutomatorTestCase {

    protected UiSelector mUiSelector;

    protected UiObject getElement(String tip){
        try {
            return new UiObject(mUiSelector.text(tip));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected UiObject getElementById(String id) {
        try {
            return new UiObject(mUiSelector.resourceId(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected UiObject getElementByDescription(String des) {
        try {
            return new UiObject(mUiSelector.description(des));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
