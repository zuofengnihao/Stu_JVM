# Stu_JVM

## 第一章 虚拟机介绍

* 寄存器结构 指令集简单 指令多 设计简单 执行效率较低

* 栈结构(HotSpot) 指令集多 指令简单 执行高效 耦合度高

1. 三大虚拟机商用虚拟机 oracle的HotSpot(Sun)和JRockit(Bea) ibm的J9 OpenJDK虚拟机HotSpot
2. android Dalvik虚拟机 apk 不遵循java虚拟机规范
3. 可能会替换HotSpot的虚拟机 oracle labs Graal VM 中间格式 语言：Java Scala Groovy Kotlin C C++ JavaScript Ruby Python R等
4. 其他虚拟机 taobaoVM 阿里深度优化的虚拟机 严重依赖Intel处理器 可以虚拟机间共享对象



## 第二章 类加载子系统

### 第一节 内存结构描述

#### 内存简图
ClassFile => 类加载子系统 <=> 运行时数据区(方法区 Java堆 (线程共享) | (线程独占) 程序计数器 JVM栈 本地方法栈) <=> 执行引擎 | 本地方法接口 <= 本地方法库 

### 第二节 类加载器与类的加载过程

#### 类加载子系统简图
字节码文件 => {类加载子系统: 加载阶段|引导类加载器 扩展类加载器 系统类加载器| -> 链接阶段(验证 准备 解析) -> 初始化阶段}

#### 类加载过程
开始 类如果没有装载 则加载这个类 使用相应的类加载器(ClassLoader)装载 装在过程中出现问题会抛出异常 如果这个类正常装载后 或者文件已经装载过 就会链接 初始化

1. 加载Loading：  
1.通过类的全限定名获取定义此类的二进制字节流  
2.将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构  
3.在内存中生成一个代表这个类的java.lang.Class对象作为方法区这个类的各种数据的访问入口  
重要：此阶段主要功能是生成类的实例 即Class对象实例

2. 链接：  
1.验证：魔术CAFEBABE   
2.准备阶段：所有static变量(常亮final static 在编译期间已经分配 在此阶段显式初始化)赋初始值 int为0 浮点为0.0 布尔false 引用null 初始化环节才完成赋值  
3.解析：将常量池内的符号引用转换为直接引用的过程

3. 初始化：执行类构造器方法clinit()过程 当类中没有static变量或者static静态代码块时是不会有clinit()方法出现的 若该类的父类有clinit() jvm
会保证该类的父类的clinit()方法已经执行 一个类的Clinit()方法在多线程下一定会被同步加锁

### 第三节 类的加载器分类

jvm支持两种类型的类加载器，分别为引导类加载器(Bootstrap ClassLoader)和自定义类加载器(User-Defined ClassLoader)

将所有派生于抽象类Classloader的类加载器都划分为自定义加载器(Extension ClassLoader和System CLassLoader都属于此类)

我最常见的类加载器始终只有3个：  

1. Bootstrap Class Loader 引导类加载器：C/C++编写 不可获取 负责加载Java核心类库(jre/lib/rt.jar,resources.jar或sun.boot.class.path) 具体见图 022.png 

2. Extension Class Loader 扩展类加载器：Java编写 派生与ClassLoader 父类为引导类加载器 负责加载java.ext.dirs jre/lib/ext子目录 具体简图 023.png

3. System Class Loader 系统类加载器：Java编写 派生与ClassLoader 父类为扩展类加载器 加载java.class.path 我们程序的默认加载器 具体见图 024.png

用户自定义加载器：需求分析
1. 隔离加载类
2. 修改类的加载方式
3. 扩展加载源
4. 防止源码泄露  

实现：见026.png

### 第三节 ClassLoader的使用说明

ClassLoader 抽象类 除引导类加载器其他类加载器都继承自ClassLoader  

方法详见027.png

获取ClassLoader 详见028.png

### 第四节 双亲委派机制
当一个类加载器准备加载一个类时会先委派给父类加载器加载直至最顶层 父类加载器会尝试加载此类 如果加载不成功再由子类加载器加载直至最底层  

优点：避免类的重复加载 保护程序安全 防止核心API被随意篡改（沙箱安全机制）


### 第五节 其他内容

两个class对象是否为同一个类存在两个必要条件：
1. 类的完整类名一致(包括包名)
2. 加载这个类的ClassLoader（指ClassLoader实例对象）一致

如果一个类型是由用户类加载器加载的 JVM会将这个类加载器的一个引用作为类型信息的一部分保存在方法区中。  

对类的使用分为主动使用与被动使用  
主动：
1. 创建类的实例（new）
2. 访问某个类或接口的静态变量，或者对该静态变量赋值
3. 调用类的静态方法
4. 反射（Class.forName()）
5. 初始化一个类的子类
6. JVM启动时被标明为启动类的类
7. JDK7开始提供的动态语言支持：  
   java.lang.invoke.MethodHandle实例的解析结果REF_getStatic REF_putStatic REF_invokeStatic句柄对应的类没有初始化，则初始化  

除以上7中情况 其他都是对类的被动使用 都不会导致类的初始化  


## 第三章 运行时数据区概述及线程

### 第一节 概述

详见图片 009.png  
线程共享 方法区（元空间） 堆内存  
线程独占 JVM栈 本地方法栈 程序计数器  

每个JVM只有一个Runtime实例 即运行时环境

### 第二节 线程

JVM每个线程都与操纵系统的本地线程直接映射 操作系统负责安排调度可用cpu 本地线程初始化后调用Run方法

## 第四章 程序计数器

### 第一节 PCRegister介绍

PC寄存器用来存储指向下一条指令的地址，也即将要执行的指令代码。由执行引擎读取下一条指令。
它是唯一没有规定任何OutOfMemoryError情况的区域。详细见005-007.png

### 第二节 举例说明

详见代码和011.png

### 第三节 两个常见的问题

1. 使用pc寄存器存储字节码指令地址有什么用 答：线程线程间来回切换我们需要记录每个线程执行到了哪里
2. pc寄存器为什么设计为线程私有 答：因为线程间来回切换是无法预知的

## 第五章 虚拟机栈JVM Stack

### 第一节 虚拟机栈概述

详见001-016.png  
-Xss 设置线程的最大栈空间

### 第二节 栈的存储单位



### 第三节 局部变量表

### 第四节 操作数栈

### 第五节 代码追踪

### 第六节 栈顶缓存技术

### 第七节 动态链接

### 第八节 方法的调用：解析与分派

### 第九节 方法的返回地址

### 第十节 一些附加信息

### 第十一节 栈的相关面试