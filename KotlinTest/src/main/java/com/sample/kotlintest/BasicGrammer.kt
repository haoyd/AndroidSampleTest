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

    // ******************************************************************************************** 比较两个数字

    /**
     * kotlin中没有基础数据类型，只有封装数据类型
     * === 比较对象地址
     * ==  比较数据大小
     */
    fun compareNum() {
        val a = 100
        println(a === a)        // 结果为true，对象地址相等，值也相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了装箱，但是值是相等的，都是10000
        println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA) // true，值相等
    }

    // ******************************************************************************************** 数据类型转换

    /**
     * 较小的数据类型并不能够隐式转换为较大的数据类型，需要用toInt()进行转换
     */
    fun convertType() {
        val b: Byte = 1
//        val i: Int = b    这是错误的
        val i: Int = b.toInt()
    }


    // ******************************************************************************************** 数组

    fun arrayTest() {
        val a = arrayOf(1, 2, 3)

        // []代表调用成员函数get set

        //除了Array， 还有ByteArray  ShortArray  IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高。
        val x: IntArray = intArrayOf(1, 2, 3)
    }

    // ******************************************************************************************** 字符串

    fun stringTest() {
        /**
         * 可以用"""支持多行字符串
         */

        val text = """
            dkfjldfjlk
            ldkjfldjflkd
            ldkjfldjflj
            """
        println(text)   // 输出有一些前置空格

        val text2 = """
            ldjfldfjlk
            dkjfldjfl
            lkjdfljkdfl
            """.trimMargin()
        println(text2)
    }

    // ******************************************************************************************** 条件判断

    fun ifTest() {
        var max :Int
        if (1 < 2) max = 2

        // 作为表达式
        max = if (1 < 2) 2 else 1
    }

    fun whenTest() {
        var x = 1;

        when (x) {
            1       ->    print("x = 1")
            2       ->    print("x = 2")
            else    ->    print("x不是1，也不是2")
        }

        when (x) {
            0, 1 -> println("x == 0 or x == 1")
            else -> println("otherwise")
        }

        when (x) {
            1 -> println("x == 1")
            2 -> println("x == 2")
            else -> { // 注意这个块
                println("x 不是 1 ，也不是 2")
            }
        }

        when (x) {
            in 0..10 -> println("x 在该区间范围内")
            else -> println("x 不在该区间范围内")
        }

        val items = setOf("apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
    }


    // ******************************************************************************************** 循环控制

    fun iteratorTest() {
        /**
         * for循环语法：for (item in collection) print(item)
         */
        var ints = arrayOf(1, 2, 3)

        for (item: Int in ints) {
            // ……
        }

        // 通过索引遍历数组
        for (i in ints.indices) {
            print(ints[i])
        }

        // 在区间上遍历"会编译成优化的实现而不会创建额外对象
        for ((index, value) in ints.withIndex()) {
            println("the element at $index is $value")
        }
    }


}

