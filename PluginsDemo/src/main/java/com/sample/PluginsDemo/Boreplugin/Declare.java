package com.sample.PluginsDemo.Boreplugin;

/**
 * Created by haoyundong on 2016/11/28.
 */

public class Declare {

    /**
     a.自动遍历目标布局中所有带id的文件, 无id的不会识别处理
     b.控件生成的变量名默认为id名称, 可以在弹出确认框右侧的名称输入栏中自行修改
     c.所有的Button或者带clickable=true的控件, 都会自动在代码中生成setOnClickListener相关代码
     d.所有EditText控件, 都会在代码中生成非空判断代码, 如果为空会提示EditText的hint内容, 如果hint为空则提示xxx字符串不能为空字样, 最后会把所有输入框的验证合并到一个submit方法中
     e.会自动识别布局中的include标签, 并读取对应布局中的控件
     */
}
