package com.zhimazg.UnitTesst;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by haoyundong on 2017/3/30.
 */

public class FirstUiautomatorTest extends BaseUiAutomatorTestCase {

    private UiObject page1 = null;
    private UiObject page2 = null;
    private UiObject page3 = null;
    private UiObject page4 = null;
    private UiObject page5 = null;
    private UiScrollable listView = null;


    public void testZhimaShop() throws UiObjectNotFoundException{
        init();
        testMainPage();
        testBanner();
        testTopTip();
        testMainListView();
        testGoodsItem();


    }

    /**
     * 初始化UI
     */
    public void init() {
        try {
            mUiSelector = new UiSelector();

            getUiDevice().pressHome();
            UiObject screen2 = getElementByDescription("第2屏");
            screen2.click();

            UiObject browObject = getElement("芝麻掌柜");
            browObject.clickAndWaitForNewWindow();


            page1 = getElement("首页");
            page2 = getElement("商品分类");
            page3 = getElement("供货商");
            page4 = getElement("购物车");
            page5 = getElement("我的");

            listView = new UiScrollable(mUiSelector.resourceId("com.zhimazg.shop:id/home_data_list"));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    /**
     * 测试底部标签的切换
     */
    public void testMainPage() {
        try {
            page2.click();
            page3.click();

            page4.click();
            page5.click();
            page1.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试banner的点击效果
     */
    public void testBanner() {
        try {
            UiObject banner = getElementById("com.zhimazg.shop:id/banner_viewpager");
            banner.click();
            sleep(2000);
            getUiDevice().pressBack();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void testTopTip() {
        try {
            UiObject sort = getElement("我常采购");
            sort.click();
            sleep(2000);
            getUiDevice().pressBack();

            UiObject hotSale = getElement("热销商品");
            hotSale.click();
            sleep(2000);
            getUiDevice().pressBack();

            UiObject activityProduct = getElement("活动商品");
            activityProduct.click();
            sleep(2000);
            getUiDevice().pressBack();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void testMainListView() {
        try {
            listView.scrollForward();
            listView.scrollBackward();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void testGoodsItem() {
        try {
            listView.scrollForward();

            UiObject product1 = getElementById("com.zhimazg.shop:id/product_img");
            product1.click();
            sleep(2000);

            UiObject add = getElementById("com.zhimazg.shop:id/product_detail_add");
            add.click();
            add.click();

            UiObject reduce = getElementById("com.zhimazg.shop:id/product_detail_reduce");
            reduce.click();

            UiObject collect = getElementById("com.zhimazg.shop:id/radio_product_detail_collect");
            collect.click();
            sleep(1000);
            collect.click();

            UiObject cart = getElementById("com.zhimazg.shop:id/product_detail_bottom_cart");
            cart.click();

            sleep(2000);

            getUiDevice().pressBack();
            getUiDevice().pressBack();


            getUiDevice().pressBack();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }




    public void test() {
//        try {
//
//        } catch (UiObjectNotFoundException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//        e.printStackTrace();
//    }
    }








}
