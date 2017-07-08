package com.sample.PluginsDemo.GsonFormat;

import java.util.List;

/**
 * Created by haoyundong on 16/9/25.
 *
 * 点击alt + s 可以启动GsonFormat
 */

public class GsonFormatInfo {


    /**
     * code : 0
     * msg : ok
     * data : {"list":[{"id":"86","type":"1","models":"1","title":"芝麻掌柜测试","content":"任务说明：1个点1个订单","store_addr":"集合地点：永年县迎宾大道永美电厂对过岳庄村口","store_id":"3","arrival_time":"用车时间：2016-09-20 00:00:00","contact_name":"张涛峰","contact_phone":"15010458919","recruit_num":"1","worker_num":"1","send_num":"3","reward":"￥123/天","batch_group_id":"20","start_time":"2016-09-20 11:49:14","end_time":"2016-09-21 11:49:14","status":"-10","verifier":"","create_by":"zhangtaofeng","created_at":"2016-09-20 11:49:19","updated_at":"2016-09-20 13:10:01","sub_title":"东城区","ship_time":"2016-09-25","has_grab":1},{"id":"96","type":"1","models":"1","title":"芝麻掌柜测试","content":"任务说明：1个点5个订单","store_addr":"集合地点：永年县迎宾大道永美电厂对过岳庄村口","store_id":"3","arrival_time":"用车时间：2016-09-21 00:00:00","contact_name":"张涛峰","contact_phone":"15010458919","recruit_num":"1","worker_num":"1","send_num":"4","reward":"￥220/天","batch_group_id":"28","start_time":"2016-09-21 15:07:26","end_time":"2016-09-22 15:07:26","status":"-10","verifier":"","create_by":"zhangtaofeng","created_at":"2016-09-21 15:07:34","updated_at":"2016-09-21 16:10:02","sub_title":"东城区","ship_time":"2016-09-25","has_grab":1},{"id":"101","type":"1","models":"1","title":"芝麻掌柜测试","content":"任务说明：1个点3个订单","store_addr":"集合地点：永年县迎宾大道永美电厂对过岳庄村口","store_id":"3","arrival_time":"用车时间：2016-09-22 00:00:00","contact_name":"张涛峰","contact_phone":"15010458919","recruit_num":"1","worker_num":"1","send_num":"4","reward":"￥111/天","batch_group_id":"33","start_time":"2016-09-22 12:23:34","end_time":"2016-09-23 12:23:34","status":"-10","verifier":"","create_by":"zhangtaofeng","created_at":"2016-09-22 12:23:40","updated_at":"2016-09-22 14:10:02","sub_title":"东城区","ship_time":"2016-09-25","has_grab":1}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 86
         * type : 1
         * models : 1
         * title : 芝麻掌柜测试
         * content : 任务说明：1个点1个订单
         * store_addr : 集合地点：永年县迎宾大道永美电厂对过岳庄村口
         * store_id : 3
         * arrival_time : 用车时间：2016-09-20 00:00:00
         * contact_name : 张涛峰
         * contact_phone : 15010458919
         * recruit_num : 1
         * worker_num : 1
         * send_num : 3
         * reward : ￥123/天
         * batch_group_id : 20
         * start_time : 2016-09-20 11:49:14
         * end_time : 2016-09-21 11:49:14
         * status : -10
         * verifier :
         * create_by : zhangtaofeng
         * created_at : 2016-09-20 11:49:19
         * updated_at : 2016-09-20 13:10:01
         * sub_title : 东城区
         * ship_time : 2016-09-25
         * has_grab : 1
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String id;
            private String type;
            private String models;
            private String title;
            private String content;
            private String store_addr;
            private String store_id;
            private String arrival_time;
            private String contact_name;
            private String contact_phone;
            private String recruit_num;
            private String worker_num;
            private String send_num;
            private String reward;
            private String batch_group_id;
            private String start_time;
            private String end_time;
            private String status;
            private String verifier;
            private String create_by;
            private String created_at;
            private String updated_at;
            private String sub_title;
            private String ship_time;
            private int has_grab;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getModels() {
                return models;
            }

            public void setModels(String models) {
                this.models = models;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getStore_addr() {
                return store_addr;
            }

            public void setStore_addr(String store_addr) {
                this.store_addr = store_addr;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getArrival_time() {
                return arrival_time;
            }

            public void setArrival_time(String arrival_time) {
                this.arrival_time = arrival_time;
            }

            public String getContact_name() {
                return contact_name;
            }

            public void setContact_name(String contact_name) {
                this.contact_name = contact_name;
            }

            public String getContact_phone() {
                return contact_phone;
            }

            public void setContact_phone(String contact_phone) {
                this.contact_phone = contact_phone;
            }

            public String getRecruit_num() {
                return recruit_num;
            }

            public void setRecruit_num(String recruit_num) {
                this.recruit_num = recruit_num;
            }

            public String getWorker_num() {
                return worker_num;
            }

            public void setWorker_num(String worker_num) {
                this.worker_num = worker_num;
            }

            public String getSend_num() {
                return send_num;
            }

            public void setSend_num(String send_num) {
                this.send_num = send_num;
            }

            public String getReward() {
                return reward;
            }

            public void setReward(String reward) {
                this.reward = reward;
            }

            public String getBatch_group_id() {
                return batch_group_id;
            }

            public void setBatch_group_id(String batch_group_id) {
                this.batch_group_id = batch_group_id;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getVerifier() {
                return verifier;
            }

            public void setVerifier(String verifier) {
                this.verifier = verifier;
            }

            public String getCreate_by() {
                return create_by;
            }

            public void setCreate_by(String create_by) {
                this.create_by = create_by;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public String getShip_time() {
                return ship_time;
            }

            public void setShip_time(String ship_time) {
                this.ship_time = ship_time;
            }

            public int getHas_grab() {
                return has_grab;
            }

            public void setHas_grab(int has_grab) {
                this.has_grab = has_grab;
            }
        }
    }
}
