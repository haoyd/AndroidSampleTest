package com.sample.SmoothList.model.bean;

import java.util.List;

/**
 * Created by haoyundong on 16/9/26.
 */

public class ProductInfo {

    public int code;
    public String msg;
    public DataBean data;



    public static class DataBean {

        public StoreBean store;
        public List<GoodsListBean> goods_list;

        public static class StoreBean {
            public String store_id;
            public String store_name;
            public String store_label;
            public String store_notice;
            public String store_workingtime;
            public String store_state;
            public String praise_rate;
            public String property_id;
            public String express_fee;
            public String order_min_price;
            public String can_use_voucher;
            public String can_online_pay;
            public String store_sales;

        }

        public static class GoodsListBean {
            public String stc_id;
            public String stc_name;
            public int order_goods_limit;


            public List<ChildGoodsListBean> goods_list;


            public static class ChildGoodsListBean {
                public String goods_id;
                public String goods_name;
                public String barcode;
                public String store_id;
                public String goods_price;
                public String goods_marketprice;
                public int month_salenum;
                public int goods_storage;
                public String goods_image;
                public String goods_state;
                public String stc_id;
                public String goods_unit;
                public int goods_min_ordernum;
                public int goods_max_ordernum;
                public String box_price;
                public String box_num;
                public String goods_max_ordernum_indays;
                public String goods_desc;
                public String sell_time;
                public String goods_image_big;

            }
        }
    }
}
