package com.sample.kotlintest

/**
 * Created by haoyundong on 2018/4/9.
 */
class BasicGrammer {

    // ******************************************************************************************** 函数定义

    /**
     * 有返回值的
     */
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 表达式作为函数体，返回类型自动推断
     */
    fun sum2(a: Int, b: Int) = a + b


    /**
     * public 方法则必须明确写出返回类型
     */
    public fun sum3(a: Int, b: Int): Int = a + b

    /**
     * 无返回值的函数
     */
    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

    /**
     * 变长参数vararg
     */
    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)
        }
    }

    fun useVars() {
        vars(1, 2, 3, 4, 5)
    }

    // ******************************************************************************************** lambda匿名函数

    /**
     * Lambda匿名函数
     */
    fun lambdaTest() {
        val sumLambda: (Int, Int) -> Int = {x, y -> x + y}
        println(sumLambda(1, 2))
    }

    // ******************************************************************************************** 定义常量与变量

    /**
     * 可变变量
     */
    var var1 : Int = 0

    /**
     * 不可变变量：只能赋值一次的变量
     */
    val var2 : Int = 0

    /**
     * 弱类型：系统会自动推断类型
     */
    var var3 = 0

    // ******************************************************************************************** 字符串模板

    /**
     * $                表示一个变量名或者变量值
     * $name            表示变量值
     * ${name.fun()}    表示变量的方法返回值
     */
    val a = 1
    val b = "a is $a"
    val c = "${b.replace("is", "was")}, but now is $a"

    // ******************************************************************************************** NULL检查机制

    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1

    /**
     * 当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null。
     * 当 str 中的字符串内容不是一个整数时, 返回 null
     */
    fun parseInt(str: String): Int? {
        // ...
        return str?.toInt()
    }

    // ******************************************************************************************** 类型转换及自动类型判断

    fun getStringLength1(obj: Any): Int? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }

        //在这里还有一种方法，与Java中instanceof不同，使用!is
        // if (obj !is String){
        //   // XXX
        // }

        // 这里的obj仍然是Any类型的引用
        return null
    }

    fun getStringLength(obj: Any): Int? {
        if (obj !is String)
            return null
        // 在这个分支中, `obj` 的类型会被自动转换为 `String`
        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
        if (obj is String && obj.length > 0)
            return obj.length
        return null
    }


    // ******************************************************************************************** 区间

    fun duration() {
        var i : Int = 1

        for (i in 1..4) print(i) // 输出“1234”

        for (i in 4..1) print(i) // 什么都不输出

        if (i in 1..10) { // 等同于 1 <= i && i <= 10
            println(i)
        }

        // 使用 step 指定步长
        for (i in 1..4 step 2) print(i) // 输出“13”

        for (i in 4 downTo 1 step 2) print(i) // 输出“42”


        // 使用 until 函数排除结束元素
        for (i in 1 until 10) {   // i in [1, 10) 排除了 10
            println(i)
        }
    }








}

