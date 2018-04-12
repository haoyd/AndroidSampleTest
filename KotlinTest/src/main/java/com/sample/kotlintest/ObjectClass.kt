package com.sample.kotlintest

import kotlin.properties.Delegates
import kotlin.reflect.KProperty
/**
 * Created by haoyundong on 2018/4/10.
 */
class ObjectClass {

    /**
     *入口
     */
    fun index() {
        var site = Runnbo()
    }



    class Runnbo() {
        var name: String = ""
    }

    class Persion(firstName: String) {  // 主构造器放到类的后面

        init {
            // 初始化的代码放init中
        }

        /**
         * 也可以有多个次构造器
         */
        constructor(firstName: String, lastName: String) : this(firstName) {
            var a = 1
        }


        /**
         * getter 和 setter属性声明的完整语法
         *
         * var <propertyName>[: <PropertyType>] [= <property_initializer>]
         * [<getter>]
         * [<setter>]
         */
        var lastName : String = "Zhang"
            get() = field;
            set

        var no: Int = 100
            get() = field
            set(value) {
                if (value < 10) {
                    field = value
                } else {
                    field = -1
                }
            }

        var height: Float = 175f
            private set
    }

    /**
     * 构造函数私有化
     */
    class Simple private constructor() {
        var a = 1
    }


    // ******************************************************************************************** 类的修饰符

    /**         类的修饰符包括 classModifier 和_accessModifier_:

    classModifier: 类属性修饰符，标示类本身特性。

    abstract    // 抽象类
    final       // 类不可继承，默认属性
    enum        // 枚举类
    open        // 类可继承，类默认是final的
    annotation  // 注解类


    accessModifier: 访问权限修饰符

    private    // 仅在同一个文件中可见
    protected  // 同一个文件中或子类可见
    public     // 所有调用的地方都可见
    internal   // 同一个模块中可见

     */


    // ******************************************************************************************** 接口

    interface MyInterface {
        fun bar()    // 未实现
        fun foo() {  //已实现
            // 可选的方法体
            println("foo")
        }
    }

    class Child : MyInterface {
        override fun bar() {
            // 方法体
        }
    }

    /**
     * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
     */
    interface MyInterface1{
        var name:String //name 属性, 抽象的
    }

    interface A {
        fun foo() { print("A") }   // 已实现
        fun bar()                  // 未实现，没有方法体，是抽象的
    }

    interface B {
        fun foo() { print("B") }   // 已实现
        fun bar() { print("bar") } // 已实现
    }

    class C : A {
        override fun bar() { print("bar") }   // 重写
    }

    class D : A, B {
        override fun foo() {
            super<A>.foo()
            super<B>.foo()
        }

        override fun bar() {
            super<B>.bar()
        }
    }


    // ******************************************************************************************** 扩展

    /**
    Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式。
    扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。

    格式：
    fun receiverType.functionName(params){
        body
    }
     */

    class User(var name:String)

    /**扩展函数**/
    fun User.Print(){
        print("用户名 $name")
    }

    fun main(arg:Array<String>){
        var user = User("Runoob")
        user.Print()
    }


    /**
    伴生对象的扩展
    如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
    伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用
     */
    class MyClass {
        companion object { }  // 将被称为 "Companion"
    }

    fun MyClass.Companion.foo() {
        println("伴随对象的扩展函数")
    }

    val MyClass.Companion.no: Int
        get() = 10

    fun main1(args: Array<String>) {
        println("no:${MyClass.no}")
        MyClass.foo()
    }

    /**
    扩展的作用域
    通常扩展函数或属性定义在顶级包下:


    package foo.bar

    fun Baz.goo() { …… }
    要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:

    package com.example.usage

    import foo.bar.goo // 导入所有名为 goo 的扩展
    // 或者
    import foo.bar.*   // 从 foo.bar 导入一切

    fun usage(baz: Baz) {
    baz.goo()
    }
     */


    // ******************************************************************************************** Kotlin 数据类与密封类


    /**
    主构造函数至少包含一个参数。
    所有的主构造函数的参数必须标识为val 或者 var ;
    数据类不可以声明为 abstract, open, sealed 或者 inner;
    数据类不能继承其他类 (但是可以实现接口)。
     */
    data class User1(val name: String, val age: Int)

    fun main() {
        val jack = User1(name = "jack", age = 1)
        val olderJack = jack.copy(age = 2)
        println(jack)
        println(olderJack)
    }

    /**
     * 标准库提供了 Pair 和 Triple 。在大多数情形中，命名数据类是更好的设计选择，因为这样代码可读性更强而且提供了有意义的名字和属性。
     */


    /**
    密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。在某种意义上，他们是枚举类的扩展：枚举类型的值集合 也是受限的，但每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例。
    声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
    sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
     */
    sealed class Expr {
        data class Const(val number: Double) : Expr()
        data class Sum(val e1: Expr, val e2: Expr) : Expr()
        object NotANumber : Expr()

        /**
         * 使用密封类的关键好处在于使用 when 表达式 的时候，如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了。
         */
        fun eval(expr: Expr): Double = when (expr) {
            is Const -> expr.number
            is Sum -> eval(expr.e1) + eval(expr.e2)
            NotANumber -> Double.NaN
        }

    }


    // ******************************************************************************************** 委托


    /**
    Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。
    类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。
    以下实例中派生类 Derived 继承了接口 Base 所有方法，并且委托一个传入的 Base 类的对象来执行这些方法。
     */

    // 创建接口
    interface Base {
        fun print()
    }

    // 实现此接口的被委托的类
    class BaseImpl(val x: Int) : Base {
        override fun print() { print(x) }
    }

    // 通过关键字 by 建立委托类
    class Derived(b: Base) : Base by b

    fun main2(args: Array<String>) {
        val b = BaseImpl(10)
        Derived(b).print() // 输出 10
    }


    /**
    属性委托
    属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理
    格式：val/var <属性名>: <类型> by <表达式>

    by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)将被委托给这个对象的 getValue() 和 setValue() 方法。属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)。
     */

    // 定义包含属性委托的类
    class Example {
        var p: String by Delegate()
    }

    // 委托的类
    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, 这里委托了 ${property.name} 属性"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$thisRef 的 ${property.name} 属性赋值为 $value")
        }
    }
    fun main3(args: Array<String>) {
        val e = Example()
        println(e.p)     // 访问该属性，调用 getValue() 函数

        e.p = "Runoob"   // 调用 setValue() 函数
        println(e.p)
    }

    /**
    延迟属性 Lazy

    lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
     */
    val lazyValue: String by lazy {
        println("computed!")     // 第一次调用输出，第二次调用不执行
        "Hello"
    }

    fun main4(args: Array<String>) {
        println(lazyValue)   // 第一次执行，执行两次输出表达式
        println(lazyValue)   // 第二次执行，只输出返回值
    }


    /**
    可观察属性 Observable

    observable 可以用于实现观察者模式。
    Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。
    在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
     */

    class User3 {
        var name: String by Delegates.observable("初始值") {
            prop, old, new ->
            println("旧值：$old -> 新值：$new")
        }
    }

    fun main5(args: Array<String>) {
        val user = User3()
        user.name = "第一次赋值"
        user.name = "第二次赋值"

        /**
         结果：
         旧值：初始值 -> 新值：第一次赋值
         旧值：第一次赋值 -> 新值：第二次赋值
         */
    }

    /**
    把属性储存在映射中

    一个常见的用例是在一个映射（map）里存储属性的值。 这经常出现在像解析 JSON 或者做其他"动态"事情的应用中。 在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
     */
    class Site(val map: Map<String, Any?>) {
        val name: String by map
        val url: String  by map
    }

    fun main6(args: Array<String>) {
        // 构造函数接受一个映射参数
        val site = Site(mapOf(
                "name" to "菜鸟教程",
                "url"  to "www.runoob.com"
        ))

        // 读取映射值
        println(site.name)
        println(site.url)

        /**
        菜鸟教程
        www.runoob.com
         */
    }

    /**
    如果使用 var 属性，需要把 Map 换成 MutableMap：
     */
    class Site1(val map: MutableMap<String, Any?>) {
        val name: String by map
        val url: String by map
    }

    fun main7(args: Array<String>) {

        var map:MutableMap<String, Any?> = mutableMapOf(
                "name" to "菜鸟教程",
                "url" to "www.runoob.com"
        )

        val site = Site1(map)

        println(site.name)
        println(site.url)

        println("--------------")
        map.put("name", "Google")
        map.put("url", "www.google.com")

        println(site.name)
        println(site.url)

    }

    /**
     * notNull 适用于那些无法在初始化阶段就确定属性值的场合。
     */
    class Foo {
        var notNullBar: String by Delegates.notNull<String>()
    }

    fun test() {
        var foo = Foo()
        foo.notNullBar = "bar"
        println(foo.notNullBar)
    }




}

