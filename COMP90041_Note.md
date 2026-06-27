# COMP90041 Master Review Tree - Week 1-6

> 结构：每章先放知识树小纲，再放 `复习总结 Summary`，最后放 `Bilingual Notes`。
> 标记：`[X考试]` 表示 Week 12 Revision 明确列为 non-examinable，不会加入考试；内容仍保留，方便完整理解课程脉络。

## 0. 文件来源与使用方式 Sources & Usage

### 来源文件 Source files

- `Week_1_Introduction_to_Programming.pdf`
- `Week_2_Control Flows.pdf`
- `Week_3_Classes and Methods - I.pdf`
- `Week_4_Classes and Methods - II.pdf`
- `Week_5_Arrays.pdf`
- `Week_6_Arrays II.pdf`
- `COMP90041_Java_复习总结_Week1-5.md`
- `COMP90041_Bilingual_Notes.md`
- `Week12_Revision.pdf` 用于 `[X考试]` 标记

### 阅读方式 How to read

- 先看每章的 `知识树小纲 Knowledge Tree`，确认这一章有哪些知识点。
- 再看 `复习总结 Summary`，抓定义、常考点、代码模板。
- 最后看 `Bilingual Notes`，补足英文定义、中文解释和短代码例子。
- Week 5-6 的数组、变长参数、数组排序等内容已经标为 `[X考试]`，因为 Week 12 Revision 将它们列为 non-examinable；但本文件仍保留完整复习内容。

### 课程信息与通用页面 Course Admin & Recurring Slides

- Course overview / 课程概况：about this subject, lecturers, teaching staff, subject logistics
- Class interaction / 课堂互动：getting to know you, getting the most out of this course
- Assessment / 考核：ungraded quiz, assessments, hurdle requirements
- Ungraded Quiz - What It Means / 非计分测验说明
- Extensions & special consideration / 延期与特殊考虑：assignments and exams
- Extensions & Special Consideration - Assignments / 作业延期与特殊考虑
- Extensions & Special Consideration - Exams / 考试特殊考虑
- Academic integrity / 学术诚信：academic misconduct, copyright notice
- Schedule / 课程安排：tentative subject schedule, tutorial rescheduling
- Tutorial Rescheduling - Public Holiday (Monday), Week 2 only for tutorials on Monday / 公共假期 tutorial 调整
- Learning flow / 学习流程：quick recap, quick practice, live coding, additional reading resources
- Recurring non-content pages / 通用页面：Acknowledgement of Country, copyright warning, break, see you next time

## 目录 Table of Contents

- 1. Java 基础工具链 Java Toolchain
- 2. 数据类型与变量 Data Types & Variables
- 3. 运算符与表达式 Operators & Expressions
- 4. 控制流 Control Flow
- 5. 类与对象基础 Classes & Objects
- 6. 方法 Methods
- 7. 封装与访问控制 Encapsulation & Access Control
- 8. Static 与 final Static & Final
- 9. 引用与内存 References & Memory
- 10. 枚举 Enum
- 11. 包装类 Wrapper Class
- 12. 数组 Array [X考试]
- 13. Arrays II 数组进阶 [X考试]
- 14. 高频易混对比 High-Confusion Comparisons
- 15. 考点速查清单 Review Checklist
- 16. 最后复习建议 Final Review Advice
- 17. PDF 覆盖终审 PDF Coverage Audit

## 1. Java 基础工具链 Java Toolchain

### 知识树小纲 Knowledge Tree

- Programming / 编程
- Java program / Java 程序
- javac / JVM / JRE / JDK
- Getting Started - Overview / 入门概览
- Compilers & Interpreters / 编译器与解释器
- First Program - Hello World / 第一个程序
- `main` method / `main` 方法
- Basic program structure / 程序基本结构
- General Code Structure / 通用代码结构
- Console output & input / 控制台输入输出
- I/O: Standard Output / 标准输出
- I/O: Formatted Output / 格式化输出
- I/O: Standard Input / 标准输入
- I/O: Command Line Input / 命令行输入
- Command Line Input / 命令行输入

### 复习总结 Summary

### 1. Java 基础工具链

#### ★ 定义速查

| 工具 | 英文定义 | 中文定义 |
|------|----------|----------|
| **javac** (Java Compiler) | Translates source code (`.java`) into bytecode (`.class`) | 将源代码编译为字节码 |
| **JVM** (Java Virtual Machine) | Executes bytecode; has interpreter + JIT compiler | 执行字节码；包含解释器和 JIT 编译器 |
| **JRE** (Java Runtime Environment) | Runtime environment + system libraries (e.g., `System.out`) | 运行环境 + 系统库 |
| **JDK** (Java Development Kit) | Full development kit: JRE + compiler + dev tools | 完整开发包：JRE + 编译器 + 开发工具 |

#### ★ 常考点

- **JDK ⊃ JRE ⊃ JVM**：包含关系，JDK 最大
- JVM 执行字节码有两种方式：**解释执行（Interpreter）** 和 **JIT 即时编译（Just-In-Time Compiler）**
- Java 源码 → `javac` 编译 → 字节码 `.class` → JVM 执行
- 口诀：**JDK 开发，JRE 运行，JVM 执行**

#### 程序基本结构

```java
class ClassName {
    public static void main(String[] args) {
        // 代码从这里开始执行
    }
}
```

> ★ `main` 方法是 Java 程序的**唯一入口点**，JVM 启动时必须找到它。

---

### Bilingual Notes

#### Programming / 编程
- Definition (EN): Programming is the process of writing instructions that tell a computer what to do.
- 定义（中）：编程是编写一组指令来告诉计算机执行什么任务的过程。
- Expansion (EN): In this subject, programming is not only about syntax; it is about expressing data, logic, and problem-solving steps in a precise form.
- 补充（中）：在这门课里，编程不只是记语法，更重要的是把数据、逻辑和解题步骤准确地表达出来。

```java
System.out.println("Hello, Java");
```

#### Java Program / Java 程序
- Definition (EN): A Java program is a collection of classes containing data and code.
- 定义（中）：Java 程序是由若干类组成的集合，里面包含数据和代码。
- Expansion (EN): The lecture emphasizes that a program has two core parts: code, which performs operations, and data, which the code works on.
- 补充（中）：讲义强调，一个程序本质上由两部分构成：执行操作的代码，以及代码要处理的数据。

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}
```

#### Java Toolchain: Compiler, JVM, JRE, JDK / Java 工具链：编译器、JVM、JRE、JDK
- Definition (EN): The Java compiler (`javac`) translates source code into bytecode; the JVM executes bytecode; the JRE provides the runtime environment and libraries; the JDK provides development tools and libraries.
- 定义（中）：Java 编译器 `javac` 把源代码编译成字节码；JVM 负责执行字节码；JRE 提供运行环境和运行库；JDK 提供开发所需的工具和库。
- Expansion (EN): The lecture also mentions two ways bytecode is executed in the JVM: interpretation and JIT compilation. A simple way to remember the hierarchy is: JDK is for building, JRE is for running, and JVM is the execution engine inside the runtime.
- 补充（中）：讲义还提到 JVM 执行字节码有两种方式：解释执行和 JIT 即时编译。可以简单记为：JDK 用来开发，JRE 用来运行，而 JVM 是运行时内部真正执行字节码的引擎。

```java
// javac Hello.java
// java Hello
```

#### `main` Method / `main` 方法
- Definition (EN): The `main` method is the entry point of a Java program.
- 定义（中）：`main` 方法是 Java 程序的入口点。
- Expansion (EN): The compiler/runtime looks for a method named `main` with the correct signature when program execution starts.
- 补充（中）：程序开始执行时，Java 运行环境会寻找签名正确的 `main` 方法作为起点。

```java
public static void main(String[] args) {
    System.out.println("Start");
}
```

#### Console Output / 控制台输出
- Definition (EN): Console output sends text or values to standard output.
- 定义（中）：控制台输出是把文本或数值发送到标准输出。
- Expansion (EN): `System.out.print` prints without an automatic newline, `System.out.println` prints with a newline, and `System.out.printf` supports formatted output.
- 补充（中）：`System.out.print` 输出后不自动换行，`System.out.println` 输出后自动换行，`System.out.printf` 支持格式化输出。

```java
System.out.println("Hello");
System.out.printf("Average: %.2f%n", 5.0);
```

#### Console Input / 控制台输入
- Definition (EN): Console input reads user-provided values from standard input.
- 定义（中）：控制台输入是从标准输入中读取用户提供的数据。
- Expansion (EN): The lecture introduces `Scanner`, which reads from `System.in`. This is a common way to collect keyboard input in beginner Java programs.
- 补充（中）：讲义使用 `Scanner` 从 `System.in` 读取数据，这是入门 Java 中最常见的键盘输入方式之一。

```java
Scanner scanner = new Scanner(System.in);
int size = scanner.nextInt();
```

## 2. 数据类型与变量 Data Types & Variables

### 知识树小纲 Knowledge Tree

- Data type / 数据类型
- Primitive type / 基本类型
- Data Types - Primitive / 基本数据类型
- Class type & array type / 类类型与数组类型
- Variable / 变量
- Declaration / 声明
- Assignment / 赋值
- Literal / 字面量

### 复习总结 Summary

### 2. 数据类型与变量

#### ★ 定义速查

**Data Type / 数据类型**：描述变量或数据能保存什么类型的值。Java 数据类型分为三组：

| 分组 | 例子 | 特点 |
|------|------|------|
| **Primitive（基本类型）** | `int`, `double`, `char`, `boolean`, `float`, `long`, `byte`, `short` | 直接存储值，固定大小，按值传递 |
| **Class Type（类类型）** | `String`, `Scanner`, `Car` | 引用类型，变量保存内存地址 |
| **Array Type（数组类型）** | `int[]`, `double[]` | 引用类型，连续存储同类型元素 |

#### ★ 常用基本类型

| 类型 | 大小 | 范围/说明 |
|------|------|-----------|
| `int` | 32-bit | 整数，最常用 |
| `double` | 64-bit | 浮点数，最常用 |
| `char` | 16-bit | 单个字符（Unicode） |
| `boolean` | — | 只有 `true` / `false` |
| `float` | 32-bit | 浮点数（精度低于 double） |
| `long` | 64-bit | 大整数 |

#### ★ 变量 (Variable)

**定义**：变量是一个有名字的数据存储位置。
**定义（EN）**：A variable is a named location that stores data.

```java
int number;       // 声明（Declaration）
number = 3;       // 赋值（Assignment）
int count = 5;    // 声明 + 赋值合并
```

#### ★ 常考点

- 变量**使用前必须声明**，声明时需指定类型
- 变量名以**字母开头**，可包含字母、数字、下划线
- **整数除法**：`5/2 = 2`（截断）；**浮点除法**：`5.0/2 = 2.5`
- **类型转换（Type Conversion）**：
  - **Widening（宽化）**：自动发生，小类型 → 大类型 `byte → short → int → long → float → double`
  - **Narrowing（窄化）**：需要强制转换 `(int) 5.9` → `5`
- `char` 类型可以转换为 `int`（对应 ASCII/Unicode 编码）：`(int)'A'` → `65`

---

### Bilingual Notes

#### Data Type / 数据类型
- Definition (EN): A data type describes what kind of value a datum or variable can hold.
- 定义（中）：数据类型描述一个数据或变量能够保存什么类型的值。
- Expansion (EN): The lecture divides Java data types into three groups: primitive types, class types, and array types.
- 补充（中）：讲义把 Java 数据类型分成三组：基本类型、类类型和数组类型。

```java
int age = 20;
String name = "Amy";
double[] scores = {85.5, 90.0};
```

#### Primitive Type / 基本类型
- Definition (EN): A primitive type stores a simple value directly, such as an `int`, `double`, `char`, or `boolean`.
- 定义（中）：基本类型直接存储简单值，例如 `int`、`double`、`char`、`boolean`。
- Expansion (EN): Primitive variables have fixed-size storage and are passed by value. They are different from objects, which are reference types.
- 补充（中）：基本类型变量占用固定大小的存储空间，并按值传递；它们不同于对象那样的引用类型。

```java
int number = 42;
boolean passed = true;
```

#### Class Type and Array Type / 类类型与数组类型
- Definition (EN): A class type names an object type defined by a class, and an array type names a sequence type whose elements all share the same base type.
- 定义（中）：类类型表示由某个类定义出的对象类型；数组类型表示一种序列类型，其中所有元素都具有相同的基类型。
- Expansion (EN): Both class types and array types are reference types in Java, so variables of these types store references rather than the full data directly.
- 补充（中）：类类型和数组类型在 Java 中都属于引用类型，因此对应变量保存的是引用，而不是完整数据本身。

```java
String text = "hello";
int[] values = {1, 2, 3};
```

#### Variable / 变量
- Definition (EN): A variable is a named location that stores data.
- 定义（中）：变量是一个有名字的数据存储位置。
- Expansion (EN): A variable must be declared before use, and its type determines what values it can store. Lecture notes also stress choosing descriptive names.
- 补充（中）：变量在使用前必须先声明，它的类型决定了它能存什么值。讲义也强调变量名应尽量具有描述性。

```java
int number;
number = 3;
```

#### Declaration / 声明
- Definition (EN): A declaration introduces a variable or method to the program and specifies its type or form.
- 定义（中）：声明是把变量或方法引入程序，并说明它的类型或形式。
- Expansion (EN): Declaring a variable creates the name and type information, but it does not necessarily give the variable a useful value yet.
- 补充（中）：声明变量时只是建立了变量名和类型信息，并不一定已经给它一个可用的值。

```java
int count;
```

#### Assignment / 赋值
- Definition (EN): Assignment stores a value into a variable.
- 定义（中）：赋值就是把一个值存入变量中。
- Expansion (EN): The lecture distinguishes declaration from assignment. You may declare first and assign later, or combine both in one statement.
- 补充（中）：讲义明确区分了声明和赋值。你可以先声明再赋值，也可以在同一条语句中完成两者。

```java
int count;
count = 5;
```

#### Literal / 字面量
- Definition (EN): A literal is a value written directly in the source code, such as `3`, `5.0`, `'A'`, or `"hello"`.
- 定义（中）：字面量是直接写在源代码里的值，例如 `3`、`5.0`、`'A'` 或 `"hello"`。
- Expansion (EN): Literals are the simplest way to provide values to expressions, assignments, and method calls.
- 补充（中）：字面量是表达式、赋值和方法调用中最直接的值来源。

```java
int x = 3;
String s = "hello";
```

#### Boolean Value / 布尔值
- Definition (EN): A boolean value is either `true` or `false`.
- 定义（中）：布尔值只有两种可能：`true` 或 `false`。
- Expansion (EN): Comparison operations always produce boolean results, and boolean values control branching and looping later in the course.
- 补充（中）：比较运算总会产生布尔结果，而这些布尔值会在后面的分支和循环结构中起控制作用。

```java
boolean ok = 5 != 4;
```

## 3. 运算符与表达式 Operators & Expressions

### 知识树小纲 Knowledge Tree

- Operator & operand / 运算符与操作数
- Expression / 表达式
- Number Types / 数值类型
- Integer vs Float Division / 整数除法与浮点除法
- Arithmetic, comparison, logical, assignment and ternary operators / 各类运算符
- Operations for Booleans / 布尔运算
- Increments and Decrements / 自增与自减
- Type Conversions / 类型转换
- Char Type Conversions / 字符类型转换
- Short-circuit logic / 短路运算
- Precedence and associativity / 优先级与结合性
- The String Type & String Operations / String 类型与操作

### 复习总结 Summary

### 3. 运算符与表达式

#### ★ 定义速查

**Expression / 表达式**：由变量、运算符、方法调用等组成，**求值后得到一个值**的结构。

**Operator / 运算符**：执行某种操作的符号（如 `+`, `-`, `*`, `/`, `%`）

**Operand / 操作数**：运算符作用的值

#### ★ 运算符分类

| 类别 | 运算符 | 说明 |
|------|--------|------|
| 算术 | `+  -  *  /  %` | `%` 是取余（模运算） |
| 比较 | `<  <=  >  >=  ==  !=` | 结果是 `boolean` |
| 逻辑 | `&&  \|\|  !` | AND、OR、NOT |
| 自增/自减 | `++  --` | 前缀/后缀 |
| 赋值 | `=  +=  -=  *=  /=` | 复合赋值 |
| 三元 | `condition ? a : b` | 条件运算符 |

#### ★ 常考点

- `&&` 和 `||` 是**短路运算符（Short-circuit）**：
  - `false && anything` → 不再计算右边
  - `true || anything` → 不再计算右边
- **前置 vs 后置自增**：
  - `++x`：先加再返回（返回 6，若 x=5）
  - `x++`：先返回再加（返回 5，若 x=5）
- **运算符优先级**：括号 > 单目（`!`, `++`） > 算术（`*`, `/`） > 加减 > 比较 > 逻辑（`&&` > `||`） > 赋值
- **String 拼接**：`+` 若有一个 String，则另一个操作数自动转为 String：`"x = " + 1` → `"x = 1"`

---

### Bilingual Notes

#### Operator and Operand / 运算符与操作数
- Definition (EN): An operator performs an operation, and the values it works on are called operands.
- 定义（中）：运算符负责执行某种运算，被它作用的值叫操作数。
- Expansion (EN): The Week 1 lecture introduces arithmetic, comparison, and logical operators. Operators are the building blocks from which expressions are formed.
- 补充（中）：第 1 周讲义介绍了算术、比较和逻辑运算符。表达式正是由这些运算符和操作数组合而成的。

```java
int sum = 2 + 3;
```

#### Expression / 表达式
- Definition (EN): An expression is a combination of variables, operators, and method invocations that evaluates to a single value.
- 定义（中）：表达式是由变量、运算符和方法调用等组成、最终会求值得到一个单一值的结构。
- Expansion (EN): Expressions are used for assignments, calculations, conditions, passing arguments, and returning values. An expression produces a value; that is its most important feature.
- 补充（中）：表达式可用于赋值、计算、条件判断、传参和返回值。它最重要的特征是“会产生一个值”。

```java
int result = x + y * z;
```

## 4. 控制流 Control Flow

### 知识树小纲 Knowledge Tree

- Statement & block / 语句与代码块
- Control Flows - Overview / 控制流概览
- Expressions, Statements and Blocks / 表达式、语句与代码块
- Boolean expression & condition / 布尔表达式与条件
- `if`, `if-else`, multiway `if-else` / 条件分支
- `switch` / 多路分支
- The switch Statement / switch 语句
- `while`, `do-while`, `for`, nested loop / 循环
- The while/do-while/for Statement / 三类循环语句
- The while Statement / while 语句
- The do while Statement / do while 语句
- The for Statement / for 语句
- Nested Loops / 嵌套循环
- `break`, `continue`, labelled break / 循环控制
- The exit Statement / exit 语句
- Debugging and assertions / 调试与断言

### 复习总结 Summary

### 4. 控制流

#### ★ 定义速查

**Flow Control / 控制流**：决定语句执行顺序的分支和循环机制。

**Statement / 语句**：驱动程序执行某个具体动作的完整指令（不同于"产生值"的表达式）。

**Block / 代码块**：用花括号 `{}` 括起来的零条或多条语句，可创建局部变量作用域。

#### ★ 分支结构

##### `if` / `if-else`

```java
if (condition) {
    // 条件为真时执行
} else if (condition2) {
    // 多路分支
} else {
    // 其他情况
}
```

**定义**：`if-else` 在两个可选分支之间做选择，条件为 `boolean` 表达式。

##### 条件运算符（Ternary Operator）

```java
int max = (a > b) ? a : b;  // 相当于 if-else，但是一个表达式（有返回值）
```

##### `switch` 语句

```java
switch (controlExpression) {
    case VALUE1:
        // 代码
        break;       // ⚠️ 必须有 break，否则会继续执行下一个 case（fall-through）
    case VALUE2:
        break;
    default:
        // 没有匹配时执行
}
```

**定义**：根据控制表达式的值进行多路分支。

#### ★ 循环结构

##### `while` 语句

```java
int count = 10;
while (count >= 0) {   // 先判断条件
    System.out.println(count);
    count--;
}
```

**定义**：先检查条件，条件为真才执行循环体。**可能执行 0 次**。

##### `do-while` 语句

```java
int count = 0;
do {
    count++;         // 先执行循环体
} while (count < 1); // 再检查条件
```

**定义**：先执行循环体，再检查条件。**至少执行 1 次**。

##### `for` 语句

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

**定义**：把初始化、条件检查、更新三部分放在同一个循环头中。

##### `for-each` 语句（增强 for 循环）

```java
int[] values = {1, 2, 3};
for (int value : values) {   // 读作：对 values 中的每个 value
    System.out.println(value);
}
```

**定义**：遍历数组或集合的每个元素，语法简洁，但**无法使用索引**。

#### ★ `break` / `continue`

| 关键字 | 作用 |
|--------|------|
| `break` | **退出**最近的循环或 switch |
| `continue` | **跳过**当前迭代的剩余代码，进入下一轮 |
| `break label` | 退出指定层的循环（嵌套循环专用） |
```java
// 简单说一说break label的使用

tag:
for(int i = 0; i < 100; 1++){
	for(int j = 0 ; j < 100; j++){ /*千万不能再用i了，要注意局部变量的问题，一个										嵌套内都属于局部变量。*/ 
		if(i > 10){
			System.out.println("Success");
			break tag;
		}
	}
}
```
#### ★ 调试 (Debugging)

- **Bug**：导致程序错误的缺陷
- **Debugging**：找到并修复 bug 的过程
- 常用方法：输出语句追踪变量 `System.out.println("count = " + count);`
- **Assertion（断言）**：`assert Boolean_Expression;`
  - 若表达式为 `false`，程序报错终止
  - 默认**关闭**；用 `java -enableassertions ClassName` 启用

#### ★ 常考点

- `switch` 的 `case` 标签类型必须与控制表达式匹配
- **Nested loop（嵌套循环）**：内层循环对外层每一次迭代都完整执行一遍
- `if (x < 2);` 中的分号导致 `if` 语句体为空，后面的语句**无条件执行**（陷阱！）
- `System.exit(0)` 正常退出；`System.exit(非0)` 表示出错退出

---

### Bilingual Notes

#### Statement / 语句
- Definition (EN): A statement is a complete instruction that directs the program to perform a specific action.
- 定义（中）：语句是一条完整的指令，用来驱动程序执行某个具体动作。
- Expansion (EN): Unlike expressions, statements do not primarily exist to produce a value. They usually perform an action, change state, or control execution.
- 补充（中）：和表达式不同，语句的核心目的不是产生值，而是执行动作、改变状态或控制程序流程。

```java
int x = 10;
System.out.println(x);
```

#### Block / 代码块
- Definition (EN): A block is a group of zero or more statements enclosed by balanced braces.
- 定义（中）：代码块是由一对花括号括起来的零条或多条语句。
- Expansion (EN): A block can often appear anywhere a single statement is allowed. Blocks also create scope for local variables.
- 补充（中）：在很多地方，代码块可以替代单条语句；同时，代码块也会***创建局部变量***的作用域。

```java
{
    int x = 1;
    System.out.println(x);
}
```

#### Boolean Expression and Condition / 布尔表达式与条件
- Definition (EN): A boolean expression is an expression that evaluates to `true` or `false`; when used to control execution, it is often called a condition.
- 定义（中）：布尔表达式是求值结果为 `true` 或 `false` 的表达式；当它用于控制执行流程时，通常也称为条件。
- Expansion (EN): Most branching and looping constructs in Java are controlled by boolean expressions.
- 补充（中）：Java 中大多数分支和循环结构，都是由布尔表达式来控制的。

```java
boolean eligible = age >= 18;
```

#### Flow Control / 控制流
- Definition (EN): Flow control refers to the branching and looping mechanisms that determine the order in which statements are executed.
- 定义（中）：***控制流是指决定语句执行顺序的分支和循环机制。***
- Expansion (EN): Sequential execution is the default, but flow-control constructs allow a program to choose paths and repeat work.
- 补充（中）：程序默认按顺序执行，但控制流结构可以让程序进行路径选择或重复执行。

```java
if (score > 50) {
    System.out.println("Pass");
}
```

#### `if` Statement / `if` 语句
- Definition (EN): An `if` statement executes a statement or block only when its condition is true.
- 定义（中）：`if` 语句会在条件为真时执行某条语句或某个代码块。
- Expansion (EN): This is the simplest branching structure in Java. If the condition is false and there is no `else`, the program simply skips that branch.
- 补充（中）：这是 Java 中最基本的分支结构。如果条件为假且没有 `else`，程序就直接跳过这部分代码。

```java
if (x > 0) {
    System.out.println("positive");
}
```

#### `if-else` Statement / `if-else` 语句
- Definition (EN): An `if-else` statement chooses between two alternative branches.
- 定义（中）：`if-else` 语句在两个可选分支之间做选择。
- Expansion (EN): Exactly one branch is taken. This makes `if-else` useful when two outcomes are mutually exclusive.
- 补充（中）：在执行时，两个分支中只会走一个，因此它特别适合表达互斥的两种情况。

```java
if (x > 0) {
    System.out.println("positive");
} else {
    System.out.println("not positive");
}
```

#### Nested Statement / 嵌套语句
- Definition (EN): A nested statement is a statement placed inside another statement.
- 定义（中）：嵌套语句是写在另一条语句内部的语句。
- Expansion (EN): `if` and `if-else` statements can contain other `if`, `if-else`, or loop statements. Indentation is important for readability.
- 补充（中）：`if` 和 `if-else` 内部还可以继续包含别的 `if`、`if-else` 或循环结构，因此良好的缩进对可读性非常重要。

```java
if (x > 0) {
    if (x % 2 == 0) {
        System.out.println("positive even");
    }
}
```

#### Multiway `if-else` / 多路 `if-else`
- Definition (EN): A multiway `if-else` is a chain of nested `if-else` statements used to choose among several alternatives.
- 定义（中）：多路 `if-else` 是一连串嵌套起来的 `if-else`，用来在多个选项中选择其一。
- Expansion (EN): Conditions are checked in order until one becomes true. The final `else` is optional.
- 补充（中）：条件会按照书写顺序依次检查，直到某个条件为真为止；最后的 `else` 是可选的。

```java
if (score >= 80) {
    System.out.println("H1");
} else if (score >= 70) {
    System.out.println("H2A");
} else {
    System.out.println("Other");
}
```

#### Conditional Operator / 条件运算符（三元运算符）
- Definition (EN): The conditional operator `?:` is a compact form of certain `if-else` decisions and produces a value.
- 定义（中）：条件运算符 `?:` 是某些 `if-else` 的简写形式，而且它本身会产生一个值。
- Expansion (EN): Because it returns a value, it is an expression rather than a statement.
- 补充（中）：由于它会求值得到一个结果，所以它属于表达式，而不是普通语句。

```java
int max = (a > b) ? a : b;
```

#### `switch` Statement / `switch` 语句
- Definition (EN): A `switch` statement performs multiway branching based on the value of a controlling expression.
- 定义（中）：`switch` 语句根据一个控制表达式的值来进行多路分支。
- Expansion (EN): Each `case` label must match the controlling expression type, labels should be unique, and a `default` branch is good practice.
- 补充（中）：每个 `case` 标签都必须与控制表达式的类型匹配，标签应该唯一，而且通常建议写上 `default` 分支。

```java
switch (day) {
    case 1: System.out.println("Mon"); break;
    default: System.out.println("Other");
}
```

#### `break` and `continue` / `break` 与 `continue`
- Definition (EN): `break` exits the nearest loop or `switch`, while `continue` skips the rest of the current loop iteration and moves to the next one.
- 定义（中）：`break` 会退出最近的一层循环或 `switch`；`continue` 会跳过当前这一轮循环剩余部分，直接进入下一轮。
- Expansion (EN): In `switch`, `break` prevents fall-through into the next case. In loops, both keywords affect control flow and should be used carefully.
- 补充（中）：在 `switch` 中，`break` 用来避免继续落入下一个 `case`；在循环里，这两个关键字都会改变正常流程，因此要谨慎使用。

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue;
    if (i == 4) break;
}
```

#### Loop / 循环
- Definition (EN): A loop repeatedly executes a block of code while a specified condition remains true or for a specified number of iterations.
- 定义（中）：循环会在某个条件成立时反复执行一段代码，或者按照指定次数重复执行。
- Expansion (EN): The lecture defines the repeated part as the loop body, and each repetition as an iteration.
- 补充（中）：讲义把被重复执行的那段代码称为循环体，而每执行一次循环体就叫一次迭代。

```java
int count = 3;
while (count > 0) {
    count--;
}
```

#### `while` Statement / `while` 语句
- Definition (EN): A `while` loop tests its condition first and executes the loop body only while the condition is true.
- 定义（中）：`while` 循环会先检查条件，只有条件为真时才执行循环体。
- Expansion (EN): A `while` loop may execute zero times. A common pattern is: initialize, test, update.
- 补充（中）：`while` 循环可能一次都不执行。它的常见写法是：先初始化，再判断条件，然后在循环体内更新控制变量。

```java
int count = 10;
while (count >= 0) {
    count--;
}
```

#### `do-while` Statement / `do-while` 语句
- Definition (EN): A `do-while` loop executes its body first and checks the condition afterward.
- 定义（中）：`do-while` 循环先执行循环体，再检查条件。
- Expansion (EN): This means the loop body executes at least once, even if the condition is false at the first check.
- 补充（中）：这意味着无论条件第一次检查时是否为假，循环体至少都会执行一次。

```java
int count = 0;
do {
    count++;
} while (count < 1);
```

#### `for` Statement / `for` 语句
- Definition (EN): A `for` loop combines initialization, condition checking, and update in a single loop header.
- 定义（中）：`for` 循环把初始化、条件检查和更新三部分放在同一个循环头中。
- Expansion (EN): It is especially useful when the number of iterations or the loop variable pattern is clear.
- 补充（中）：当迭代次数或循环变量变化模式很清楚时，`for` 循环通常最合适。

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}
```

#### Nested Loop / 嵌套循环
- Definition (EN): A nested loop is a loop inside another loop.
- 定义（中）：嵌套循环就是在一个循环内部再写一个循环。
- Expansion (EN): The inner loop runs to completion for each iteration of the outer loop.
- 补充（中）：对于外层循环的每一次迭代，内层循环都会完整执行一遍。

```java
for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 3; col++) {
        System.out.println(row + "," + col);
    }
}
```

#### Infinite Loop / 无限循环
- Definition (EN): An infinite loop is a loop whose condition never becomes false.
- 定义（中）：无限循环是指条件始终不会变成假的循环。
- Expansion (EN): The Week 2 lecture warns about “the dreaded infinite loop.” It usually happens when the control variable is not updated correctly.
- 补充（中）：第 2 周讲义特别提醒要警惕无限循环。它通常是因为控制变量没有被正确更新导致的。

```java
while (true) {
    break;
}
```

#### Debugging / 调试
- Definition (EN): Debugging is the process of finding, understanding, and fixing errors in a program.
- 定义（中）：调试是发现、理解并修复程序错误的过程。
- Expansion (EN): In an introductory course, debugging often means tracing variable values, checking conditions, and verifying that the actual flow matches the intended flow.
- 补充（中）：在入门编程中，调试通常表现为追踪变量值、检查条件是否正确，以及确认程序实际执行路径是否符合预期。

```java
System.out.println("x = " + x);
```

## 5. 类与对象基础 Classes & Objects

### 知识树小纲 Knowledge Tree

- OOP motivation / 面向对象动机
- Classes and Methods - Overview / 类与方法概览
- Why object-oriented programming? / 为什么需要 OOP
- A better way to organize / 更好的代码组织方式
- Class / 类
- What is a Class? / 什么是类
- Object, instance, instantiation / 对象、实例、实例化
- Classes and Objects / 类与对象
- Example of Class Definition / 类定义例子
- Relationship between Class and Object / 类与对象的关系
- Primitive vs Reference(Objects) Types / 基本类型与引用对象类型
- Field / instance variable / 字段与实例变量
- Class and Method Definitions / 类与方法定义
- The new Operator / new 运算符
- Types of Methods / 方法类型
- Parameters and Arguments / 形参与实参
- Exercise - Fix the Code / 修复代码练习
- Constructor / 构造器
- Types of Constructors / 构造器类型
- `this`, `toString()`, `equals()` / 常用对象方法
- The this Keyword / this 关键字
- Using equals() Method / 使用 equals 方法
- Using the toString() Method / 使用 toString 方法
- Comparing Objects & Printing Objects / 对象比较与对象输出
- Comparing Objects in Java / Java 对象比较
- Printing Objects in Java / Java 对象输出

### 复习总结 Summary

### 5. 类与对象（基础）

#### ★ 定义速查

**Class / 类**：用来创建对象的**蓝图或模板**，定义了对象拥有的数据（字段）和行为（方法）。
**EN**: A class is a blueprint or template for creating objects and defining their data and actions.

**Object / 对象**：类的一个**实例（Instance）**，包含实际数据并可执行动作。
**EN**: An object is an instance of a class; it contains actual data and performs actions.

**Instantiation / 实例化**：使用 `new` 创建对象的过程。

```java
Car myCar = new Car();   // 声明 + 实例化
```

**Field / Instance Variable / 实例变量**：在类内部声明、为每个对象保存数据的变量。
每个对象有**自己独立的**字段值，但所有对象共享同样的字段定义。

#### ★ 类的典型结构

```java
public class Car {
    // 实例变量（Fields）
    private String manufacturer;
    private int yearBuilt;

    // 构造器（Constructor）
    public Car(String manufacturer, int yearBuilt) {
        this.manufacturer = manufacturer;
        this.yearBuilt = yearBuilt;
    }

    // 方法（Methods）
    public String getManufacturer() { return manufacturer; }
    public void setYearBuilt(int year) { this.yearBuilt = year; }

    // toString
    public String toString() {
        return yearBuilt + " " + manufacturer;
    }

    // equals
    public boolean equals(Car other) {
        return this.yearBuilt == other.yearBuilt &&
               this.manufacturer.equals(other.manufacturer);
    }
}
```

#### ★ 构造器 (Constructor)

**定义**：用于初始化新创建对象的特殊成员。
**EN**: A constructor is a special member used to initialize a newly created object.

| 特征 | 说明 |
|------|------|
| 名称 | 必须与类名**完全相同** |
| 返回类型 | **无**（不写 void） |
| 调用方式 | `new` 创建对象时自动调用 |
| 不同于方法 | 不能用点运算符调用，不能被继承 |

##### 三种构造器类型

```java
public Car() { }                                 // 1. 默认构造器（无参）
public Car(String manufacturer, int year) { ... } // 2. 带参构造器
public Car(Car other) { ... }                     // 3. 拷贝构造器（复制另一个对象）
```

> ★ **默认构造器**：只有在类中**完全没有**定义任何构造器时，Java 才自动生成。一旦你写了带参构造器，Java 就**不再**自动生成无参构造器！

##### *默认初始化值*（无显式初始化时）

| 类型 | 默认值 |
|------|--------|
| `boolean` | `false` |
| 数值类型 (`int`, `double`…) | `0` |
| 类类型 / 数组类型 | `null` |

#### ★ `toString()` 方法

**定义**：提供对象的文本表示形式。**打印对象或字符串拼接时*自动调用***。

```java
System.out.println(myCar);         // 自动调用 myCar.toString()
String s = "Car: " + myCar;       // 也自动调用 toString()
```

#### ★ `equals()` 方法

**定义**：判断两个对象在内容或逻辑上是否相等。

```java
myCar.equals(yourCar);  // 比较内容
myCar == yourCar;       // 比较引用（是否同一对象）
```

#### ★ `this` 关键字

**定义**：在实例方法或构造器中，`this` 指向**当前对象**。
主要用途：区分同名的实例变量和形参。

```java
public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;  // this.yearBuilt = 实例变量；yearBuilt = 形参
}
public void setYearBuilt() {
	int yearBuilt = 10;
    this.yearBuilt = yearBuilt;  
}
```

---

### Bilingual Notes

#### Class / 类
- Definition (EN): A class is a blueprint or template for creating objects and defining their data and actions.
- 定义（中）：类是用来创建对象的蓝图或模板，它定义了对象拥有的数据和可执行的行为。
- Expansion (EN): In Java, everything is organized around classes. A class contains members such as fields and methods, and every method must appear inside a class.
- 补充（中）：在 Java 里，所有代码都围绕类来组织。类中包含成员，例如字段和方法，而且每个方法都必须写在类里面。

```java
class Car {
    String model;
}
```

#### Object-Oriented Programming (OOP) / 面向对象编程
- Definition (EN): Object-oriented programming is a way of organizing programs around objects that combine data and behavior.
- 定义（中）：面向对象编程是一种围绕对象来组织程序的方法，对象把数据和行为结合在一起。
- Expansion (EN): The lectures use examples such as `Car` to show why OOP scales better than manually managing many separate variables.
- 补充（中）：讲义用 `Car` 这类例子说明，和手动维护大量分散变量相比，面向对象更适合组织复杂数据和行为。

```java
Car myCar = new Car();
```

#### Object, Instance, and Instantiation / 对象、实例与实例化
- Definition (EN): An object is an instance of a class, and instantiation is the act of creating that object.
- 定义（中）：对象是类的一个实例，而实例化就是创建这个对象的过程。用 new 字符。
- Expansion (EN): A class defines the common structure, but each object stores its own actual data values.
- 补充（中）：类定义的是共同结构，而每个对象保存的是各自独立的实际数据值。

```java
Car myCar = new Car();
```

#### Field / Attribute / Instance Variable / 字段 / 属性 / 实例变量
- Definition (EN): A field, attribute, or instance variable is a variable declared inside a class to store data for each object.
- 定义（中）：字段、属性或实例变量，是定义在类内部、用于为每个对象保存数据的变量。
- Expansion (EN): All objects of the same class share the same field definitions, but each object has its own field values.
- 补充（中）：同一个类的所有对象共享同样的字段定义，但每个对象拥有自己的字段值。

```java
class Car {
    private String manufacturer;
}
```

#### `this` Keyword / `this` *关键字*
- Definition (EN): `this` refers to the current object in an instance method or constructor.
- 定义（中）：`this` 指向当前对象，在实例方法和构造器中都可以使用。
- Expansion (EN): It is often used to make object reference explicit and to distinguish an instance variable from a local variable or parameter with the same name.
- 补充（中）：它常用于显式表示当前对象，也常用来区分实例变量和同名的局部变量或形参。

```java
public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
}
```

#### Constructor / 构造器
- Definition (EN): A constructor is a special member used to initialize a newly created object.
- 定义（中）：构造器是用于初始化新创建对象的特殊成员。
- Expansion (EN): A constructor has the same name as the class, has no return type, and is called when `new` creates an object.
- 补充（中）：构造器和类同名，没有返回类型，并且会在使用 `new` 创建对象时被调用。

```java
public Car(String manufacturer) {
    this.manufacturer = manufacturer;
}
```

#### Default, Parameterized, and Copy Constructors / 默认构造器、带参构造器与拷贝构造器
- Definition (EN): A default constructor takes no arguments, a parameterized constructor accepts values to initialize fields, and a copy constructor creates a new object from an existing object.
- 定义（中）：默认构造器不接收参数；带参构造器接收值来初始化字段；拷贝构造器根据已有对象创建一个新对象。
- Expansion (EN): Java only generates a default constructor automatically when no constructor is explicitly defined. The lecture also recommends providing your own no-argument constructor when appropriate.
- 补充（中）：只有在类里完全没有显式构造器时，Java 才会自动生成默认构造器。讲义也建议在合适时显式提供自己的无参构造器。

```java
public Car() { }
public Car(String name) { this.name = name; }
public Car(Car other) { this.name = other.name; }
```

#### `toString()` / `toString()` 方法
- Definition (EN): `toString()` provides a textual representation of an object.
- 定义（中）：`toString()` 方法用于提供对象的文本表示形式。
- Expansion (EN): It is called automatically when an object is printed directly or concatenated into a string.
- 补充（中）：当对象被直接打印，或与字符串拼接时，`toString()` 往往会被自动调用。

```java
System.out.println(myCar);
```

#### `equals()` / `equals()` 方法
- Definition (EN): `equals()` is used to decide whether two objects should be considered equal in content or meaning.
- 定义（中）：`equals()` 用来判断两个对象在内容或语义上是否应被视为相等。
- Expansion (EN): By default, object equality behavior is inherited, but classes can override `equals()` to compare meaningful content rather than identity.
- 补充（中）：对象默认会继承基础的相等性行为，但类也可以重写 `equals()`，从而比较“内容是否相等”，而不是只比较“是不是同一个对象”。

```java
boolean same = a.equals(b);
```

## 6. 方法 Methods

### 知识树小纲 Knowledge Tree

- Method / 方法
- Void vs returning method / 无返回值与有返回值方法
- `return` statement / return 语句
- Method invocation / 方法调用
- Parameter vs argument / 形参与实参
- Local variable and scope / 局部变量与作用域
- Parameter passing / 参数传递
- Overloading and signature / 重载与签名

### 复习总结 Summary

### 6. 方法

#### ★ 定义速查

**Method / 方法**：一段有名字的代码块，定义对象或类可以执行的行为。方法分为**方法头**和**方法体**。

**Void Method / 无返回值方法**：执行动作但不返回值，用 `void` 声明。
**Returning Method / 有返回值方法**：返回某种指定类型的值，必须有 `return` 语句。

```java
public void printName() { ... }           // void 方法
public int square(int x) { return x*x; } // 有返回值方法
```

#### ★ 参数（Parameter）vs 实参（Argument）

**Parameter（形参）**：写在***方法定义***里的变量。
**Argument（实参）**：调用方法时***传入***的实际值。

```java
public double myMethod(int param1, double param2) { ... }  // param1, param2 是形参
double result = myMethod(1, 3.0);                          // 1, 3.0 是实参
```

#### ★ Java 参数传递机制：Pass-by-Value（值传递）

> ★★★ **Java 只有值传递（Pass-by-Value）！**

```java
public class Test {
    public static void main(String[] args) {
        Room myRoom = new Room(10); // 钥匙A (指向10平米房)
        destroyRoom(myRoom);
        
        // 关键点：如果是引用传递，myRoom 应该变成新房间（100平米）
        // 如果是值传递，myRoom 依然拿着旧钥匙A（10平米）
        System.out.println("外面的房间面积: " + myRoom.size); 
    }

    public static void destroyRoom(Room room) {
        // 在方法内部，重新 new 了一个新对象，相当于把手里的钥匙换成了 钥匙B
        room = new Room(100); 
        System.out.println("方法内部的房间面积: " + room.size);
    }
}
```

| 参数类型     | 传递的内容              | 方法内修改是否影响原变量      |
| -------- | ------------------ | ----------------- |
| 基本类型     | 值的**副本**           | ❌ 不影响             |
| 引用类型（对象） | **引用的副本**（地址）      | ✅ 可以通过引用修改对象内容    |
| `String` | 引用的副本，但 String 不可变 | ❌ 不影响（创建新 String） |

#### ★ 局部变量（Local Variable）与作用域（Scope）

**定义**：在方法或代码块内部声明的变量；作用域是它可以被使用的范围。
代码块结束时，局部变量消失；`for` 循环初始化部分的变量作用域也只在该循环内。

#### ★ 方法重载（Overloading）

**定义**：在同一个类中定义两个或多个**同名但签名不同**的方法。
**Signature（签名）** = 方法名 + 参数列表（类型 + 数量 + 顺序）。

```java
void setCar(Car other) { }                    // 签名：setCar(Car)
void setCar(String name, int year) { }        // 签名：setCar(String, int)
// ❌ 仅返回类型不同，不构成合法重载！
```

---

### Bilingual Notes

#### Method / 方法
- Definition (EN): A method is a named block of code that defines an action an object or class can perform.
- 定义（中）：方法是一段有名字的代码块，用来定义对象或类可以执行的行为。
- Expansion (EN): The lecture divides a method into a heading and a body. Methods are called through method invocation.
- 补充（中）：讲义把方法分成方法头和方法体两部分。方法通过调用来执行。

```java
public void sayHello() {
    System.out.println("Hello");
}
```

#### Void Method and Returning Method / 无返回值方法与有返回值方法
- Definition (EN): A void method performs an action without returning a value, while a returning method produces a value of a specified type.
- 定义（中）：无返回值方法执行动作但不返回结果；有返回值方法会返回某种指定类型的值。
- Expansion (EN): A returning method must return a value of the declared type. A void method may still use `return;` to exit early.
- 补充（中）：有返回值方法必须返回与声明类型一致的值；无返回值方法虽然不返回数据，但仍然可以用 `return;` 提前结束。

```java
public void printName() { }
public int square(int x) { return x * x; }
```

#### Return Statement / `return` 语句
- Definition (EN): A return statement ends a method invocation and optionally sends a value back to the caller.
- 定义（中）：`return` 语句会结束一次方法调用，并可选择把一个值返回给调用者。
- Expansion (EN): In value-returning methods, `return` is mandatory. In void methods, `return;` is optional and mainly used for early exit.
- 补充（中）：在有返回值的方法里，`return` 是必须的；在 `void` 方法里，`return;` 是可选的，主要用于提前退出。

```java
return x + 1;
```

#### Method Invocation / 方法调用
- Definition (EN): Method invocation is the act of calling a method so that it executes.
- 定义（中）：方法调用就是触发某个方法执行的动作。
- Expansion (EN): If a method returns a value, its invocation can be used as an expression. If it is void, the invocation is used as a statement.
- 补充（中）：如果方法有返回值，那么调用它可以作为表达式的一部分；如果是 `void` 方法，那么它通常作为一条语句出现。

```java
int n = obj.getValue();
obj.writeOutput();
```

#### Local Variable and Scope / 局部变量与作用域
- Definition (EN): A local variable is declared inside a method or block, and scope is the region where that variable can be used.
- 定义（中）：局部变量是在方法或代码块内部声明的变量；作用域是该变量可以被使用的范围。
- Expansion (EN): Local variables disappear when their block ends. Variables declared in loop initialization are also local to that loop.
- 补充（中）：当代码块结束时，局部变量就不再存在；在循环初始化部分声明的变量，其作用域也只限于该循环。

```java
if (true) {
    int x = 1;
}
```

#### Parameter and Argument / 形参与实参
- Definition (EN): A parameter is a variable listed in a method definition, while an argument is the actual value passed at invocation time.
- 定义（中）：形参是写在方法定义里的变量；实参是在调用方法时传进去的实际值。
- Expansion (EN): Parameter lists specify number, type, and order. Arguments must match parameters in type and order, although Java may perform some automatic conversions.
- 补充（中）：形参列表规定了参数的个数、类型和顺序；实参通常需要在类型和顺序上与形参匹配，不过 Java 有时会做自动类型转换。

```java
double result = myMethod(1, 2, 3.0);
```

#### Parameter Passing / 参数传递
- Definition (EN): Java is ***pass-by-value***: method parameters receive copies of the passed values.
- 定义（中）：Java 采用值传递：方法参数得到的是传入值的副本。
- Expansion (EN): For primitive arguments, the copied value is the primitive itself. For object arguments, the copied value is the reference, so the method can still modify the same underlying object through that copied reference.
- 补充（中）：对于基本类型，复制的是那个基本值本身；对于对象参数，复制的是引用，所以方法虽然拿到的是“引用副本”，但仍然可以通过它修改同一个底层对象。

```java
void change(Car c) { c.price = 200; }
```

#### Overloading and Signature / 重载与方法签名
- Definition (EN): Overloading means defining two or more methods in the same class with the same name but different signatures; a signature is the method name together with its parameter list.
- 定义（中）：重载是指在同一个类中定义两个或多个同名但签名不同的方法；签名是“方法名 + 参数列表”的组合。
- Expansion (EN): Different signatures must differ in parameter number and/or parameter types. Changing only the return type does not create a valid overload.
- 补充（中）：不同签名必须在参数个数和/或参数类型上不同；仅仅修改返回类型并不能构成合法重载。

```java
void setCar(Car other) { }
void setCar(String name, int year) { }
```

## 7. 封装与访问控制 Encapsulation & Access Control

### 知识树小纲 Knowledge Tree

- Encapsulation / 封装
- Access modifier / 访问修饰符
- Access Modifiers / 访问修饰符
- `public`, `private`, `protected`, default / 四类访问级别
- Getter/accessor / 访问器
- Accessors and Mutators / 访问器与修改器
- Accessor Methods ("Getters") / Getter 访问器方法
- Setter/mutator / 修改器
- Mutator Method ("Setters") / Setter 修改器方法

### 复习总结 Summary

### 7. 封装与访问控制

#### ★ 定义速查

**Encapsulation / 封装**：把数据和方法打包在一起，同时限制外部直接访问内部细节的做法。
**EN**: Bundling data and methods together while controlling direct access to internal details.

**Access Modifier / 访问修饰符**：控制类成员可见性的关键字。

| 修饰符 | 可访问范围 | 常用场景 |
|--------|----------|----------|
| `public` | 任何地方 | 方法、构造器 |
| `private` | 仅本类内部 | **实例变量（推荐）** |
| `protected` | 本类 + 子类（继承相关，后续课程） | — |
| 默认（无修饰符） | 同包内 | — |

> ★ **实例变量默认应设为 `private`**，通过 getter/setter 访问。

**Accessor / Getter / 访问器**：返回私有字段值，不允许外部直接修改。
**Mutator / Setter / 修改器**：以受控方式修改私有字段值，可在修改前进行验证。

```java
public int getYearBuilt() { return yearBuilt; }             // Getter

public void setYearBuilt(int yearBuilt) {
    if (yearBuilt >= 0) {                                    // 验证输入
        this.yearBuilt = yearBuilt;
    }
}                                                            // Setter
```

---

### Bilingual Notes

#### Access Modifier / 访问修饰符
- Definition (EN): An access modifier controls the visibility of class members such as variables and methods.
- 定义（中）：访问修饰符用于控制类成员（如变量和方法）的可见性。
- Expansion (EN): The lecture introduces `public`, `private`, `protected`, and default access. Visibility is central to encapsulation and information hiding.
- 补充（中）：讲义介绍了 `public`、`private`、`protected` 和默认访问级别。可见性控制是封装与信息隐藏的核心。

```java
private int yearBuilt;
public int getYearBuilt() { return yearBuilt; }
```

#### `public`, `private`, `protected`, and Default / `public`、`private`、`protected` 与默认访问
- Definition (EN): `public` allows access everywhere, `private` allows access only inside the same class, `protected` relates to inheritance, and default access depends on package visibility.
- 定义（中）：`public` 表示任何地方都可访问；`private` 只允许在本类内部访问；`protected` 与继承相关；默认访问通常由包可见性决定。
- Expansion (EN): At this stage, the most important practical guideline is that instance variables should usually be private by default.
- 补充（中）：在当前阶段，最重要的实践建议是：实例变量通常默认应该设为 `private`。

```java
public class Car {
    private String model;
}
```

#### Encapsulation / 封装
- Definition (EN): Encapsulation is the practice of bundling data and methods together while controlling direct access to internal details.
- 定义（中）：封装是把数据和方法打包在一起，同时限制外部直接访问内部细节的做法。
- Expansion (EN): Encapsulation protects object state, prevents accidental misuse, and allows validation logic to be placed inside methods instead of scattered outside the class.
- 补充（中）：封装可以保护对象状态，避免外部误用，并把校验逻辑集中放进类的方法中，而不是散落在类外部。

```java
class Car {
    private int yearBuilt;
}
```

#### Accessor / Getter / 访问器 / Getter
- Definition (EN): An accessor, often called a getter, returns the value of a private field without allowing direct external modification.
- 定义（中）：访问器，也常叫 getter，用于返回私有字段的值，同时避免外部直接修改该字段。
- Expansion (EN): The lecture notes that a getter can compute or transform a value before returning it, so it is more than just a mechanical field read.
- 补充（中）：讲义特别指出，getter 在返回前还可以先做计算或转换，因此它不只是机械地把字段值“拿出来”。

```java
public int getYearBuilt() {
    return yearBuilt;
}
```

#### Mutator / Setter / 修改器 / Setter
- Definition (EN): A mutator, often called a setter, changes the value of a private field in a controlled way.
- 定义（中）：修改器，也常叫 setter，用于以受控方式修改私有字段的值。
- Expansion (EN): A setter can validate input before updating the field, which is one of the main reasons encapsulation is useful.
- 补充（中）：setter 可以在真正修改字段前先校验输入，这正是封装有价值的重要原因之一。

```java
public void setYearBuilt(int yearBuilt) {
    if (yearBuilt >= 0) {
        this.yearBuilt = yearBuilt;
    }
}
```

## 8. Static 与 final Static & Final

### 知识树小纲 Knowledge Tree

- Static method / 静态方法
- Static variable / 静态变量
- Static Variables / 静态变量
- Static Variable Initialization / 静态变量初始化
- `main` as static method / main 是静态方法
- Main in any class / 任意类中的 main
- What is the output of the command java MyClass? / java MyClass 命令输出判断
- Constant and `final` / 常量与 final
- Constants variables / 常量变量

### 复习总结 Summary

### 8. Static & final

#### ★ `static` 静态成员

**Static Variable / 静态变量**：属于类本身，**所有对象共享同一份**。
**Static Method / 静态方法**：属于类，不需要创建对象即可调用，通过类名调用。

```java
class Test {
    static int count = 0;             // 静态变量：每个类只有一份
    int id;                           // 实例变量：每个对象一份

    public static void hello() { }    // 静态方法
    Test() { count++; }               // 构造器中可访问静态变量
}

Test.hello();    // 通过类名调用静态方法
```

#### ★ 常考点

- 静态方法**不能直接访问**实例变量和实例方法（因为没有 `this`）
- 静态变量可以被静态方法访问
- `main` 方法是静态的，所以在 `main` 中***不能直接调用非静态方法，需先创建对象***
- 多个类可以各有自己的 `main`，`java ClassName` 指定从哪个 `main` 开始

#### ★ `final` 常量

**Constant / 常量**：赋值后值不能改变的变量，用 `final` 声明。

```java
public static final double PI = 3.14159;  // 类级别常量，命名全大写
```

> ★ 常量命名惯例：**全大写 + 下划线分隔**，如 `MAX_SIZE`、`PI`。

---

### Bilingual Notes

#### Static Method / 静态方法
- Definition (EN): A static method belongs to the class itself rather than to any individual object.
- 定义（中）：静态方法属于类本身，而不属于某个具体对象。
- Expansion (EN): It is declared with `static` and is commonly called by the class name. A static method cannot directly use instance fields or instance methods without an object.
- 补充（中）：静态方法通过 `static` 声明，通常用类名来调用。没有对象时，它不能直接访问实例字段或实例方法。

```java
class MyClass {
    public static void hello() { }
}
```

#### Static Variable / 静态变量
- Definition (EN): A static variable belongs to the class and is shared by all objects of that class.
- 定义（中）：静态变量属于类本身，由该类的所有对象共享。
- Expansion (EN): The lecture contrasts static and instance variables: static means one shared copy per class; instance means one separate copy per object.
- 补充（中）：讲义把静态变量和实例变量做了鲜明对比：静态变量是“每个类一份”，实例变量是“每个对象一份”。

```java
class Test {
    static int count = 0;
}
```

#### Constant and `final` / 常量与 `final`
- Definition (EN): A constant is a variable whose value cannot change after assignment; in Java it is declared with `final`.
- 定义（中）：常量是指一旦赋值后其值就不能再改变的变量；在 Java 中使用 `final` 声明。
- Expansion (EN): A common pattern is `public static final`, which defines a class-level named constant such as `PI`.
- 补充（中）：常见写法是 `public static final`，用于定义类级别的命名常量，例如 `PI`。

```java
public static final double PI = 3.14159;
```

## 9. 引用与内存 References & Memory

### 知识树小纲 Knowledge Tree

- Variables and memory / 变量与内存
- Storing Data / 数据存储
- How Variables Are Stored in Memory / 变量如何存入内存
- Primitive vs reference variable / 基本类型与引用类型
- References and class parameters / 引用与类参数
- Assignment vs aliasing / 赋值与别名共享
- Call-by-Value vs Call-by-Reference / 值传递与引用传递对比
- `null` / 空引用
- The Constant null / null 常量
- Anonymous object / 匿名对象
- The new Operator and Anonymous Objects / new 运算符与匿名对象
- String immutability / String 不可变
- `==` vs `equals()` / 引用比较与内容比较
- = vs == with Objects / 对象中的赋值与相等比较

### 复习总结 Summary

### 9. 引用与内存

#### ★ 定义速查

**Primitive Variable / 基本类型变量**：**直接存储值**本身，大小固定。
**Reference Variable / 引用类型变量**：存储**指向对象的引用（内存地址）**，对象本身存储在内存其他地方。

```java
int a = 42;          // a 直接存 42
Car myCar = new Car(); // myCar 存的是 Car 对象的内存地址
```

#### ★ 赋值 vs 别名共享（Aliasing）

```java
// 基本类型赋值 — 复制值
int a = 42;
int b = a;  // b 有自己独立的 42，互不影响

// 引用类型赋值 — 复制引用（共享同一对象！）
Car carA = new Car();
Car carB = carA;    // carB 和 carA 指向同一个对象！
carB.yearBuilt = 2025;  // 会改变 carA.yearBuilt！
```

#### ★ `null`

**定义**：表示引用变量不指向任何对象的特殊常量。
- 测试 `null` 用 `==` 或 `!=`，不用 `equals()`
- 访问 `null` 引用的方法或字段会抛出 **`NullPointerException`**

```java
Car myCar = null;
if (myCar == null) { ... }   // 正确做法
```

#### ★ 匿名对象（Anonymous Object）

```java
if (car1.equals(new Car("Toyota", 2023))) { ... }  // new Car(...) 是匿名对象，用后即废
```

---

### Bilingual Notes

#### Variables and Memory / 变量与内存
- Definition (EN): Program variables store values in main memory while the program is running.
- 定义（中）：程序运行时，变量的值会存放在主存中。
- Expansion (EN): The lecture distinguishes main memory from secondary storage and explains that variables are located using memory addresses.
- 补充（中）：讲义区分了主存和外存，并说明变量在内存中是通过地址定位的。

```java
int number = 42;
```

#### Primitive Variable vs Reference Variable / 基本类型变量 vs 引用类型变量
- Definition (EN): A primitive variable stores its actual value directly, while a reference variable stores a reference (memory address) to an object.
- 定义（中）：基本类型变量直接保存实际值，而引用类型变量保存的是指向对象的引用（内存地址）。
- Expansion (EN): Primitive storage size is fixed by type; reference variables also have fixed-size references, but the objects they point to can vary in size.
- 补充（中）：基本类型的存储大小由类型固定决定；引用变量本身也有固定大小，但它所指向的对象大小可以变化。

```java
int a = 42;
Car myCar = new Car();
```

#### Assignment vs Aliasing / 赋值 vs 别名共享
- Definition (EN): For primitives, assignment copies the actual value; for reference types, assignment copies the reference, so two variables may refer to the same object.
- 定义（中）：对于基本类型，赋值复制的是实际值；对于引用类型，赋值复制的是引用，因此两个变量可能会指向同一个对象。
- Expansion (EN): This is why `Car b = a;` does not create a new `Car`. It only creates another name for the same object, which is also called aliasing.
- 补充（中）：这就是为什么 `Car b = a;` 不会创建新的 `Car` 对象，它只是给同一个对象又起了一个名字，这种现象就叫别名共享。

```java
Car a = new Car();
Car b = a;
```

#### Strings as a Special Case / String 作为特殊情况
- Definition (EN): `String` is an object type, but it is immutable, meaning its contents cannot be changed after creation.
- 定义（中）：`String` 是对象类型，但它是不可变的，也就是说一旦创建，其内容就不能被改变。
- Expansion (EN): This is why passing a `String` into a method and “modifying” it usually creates a new string rather than changing the original one.
- 补充（中）：这就是为什么把 `String` 传进方法后再去“修改”它，通常会创建新字符串，而不是改变原来的那个字符串。

```java
void modify(String s) {
    s = s + " world";
}
```

#### `==` vs `equals()` for Objects / 对象中的 `==` 与 `equals()`
- Definition (EN): `==` checks whether two references point to the same object, while `equals()` is meant to compare content or logical equality.
- 定义（中）：`==` 检查两个引用是否指向同一个对象；`equals()` 用来比较内容或逻辑上的相等。
- Expansion (EN): If `equals()` is not overridden meaningfully, it may behave similarly to identity checks. Good class design often includes a useful `equals()` method.
- 补充（中）：如果类没有正确重写 `equals()`，它的行为可能和身份比较差不多。一个设计良好的类通常会提供有意义的 `equals()`。

```java
boolean sameObject = (a == b);
boolean sameContent = a.equals(b);
```

## 10. 枚举 Enum

### 知识树小纲 Knowledge Tree

- Enum / 枚举
- Enumerations / 枚举
- Enumerated Types / 枚举类型
- Declaring and Using Enums / 枚举声明与使用
- Enum constant and ordinal / 枚举常量与序号
- Benefits of Enums vs Strings / 枚举相对 String 的优势
- Enum comparison and `switch` / 枚举比较与 switch
- Enums in switch statements / switch 中使用枚举
- Common enum methods / 常见枚举方法
- Built-in Enum Methods / 枚举内建方法
- Enums vs Constants / 枚举与常量

### 复习总结 Summary

### 10. 枚举 Enum

#### ★ 定义速查

**Enum / 枚举**：定义一组**固定的、带名字的常量值**的特殊***类***。属于一个 class
**EN**: An enum is a special kind of class that defines a fixed set of named constant values.

```java
enum WorkDay { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }

WorkDay today = WorkDay.MONDAY;
```

#### ★ 内建方法

| 方法 | 说明 |
|------|------|
| `name()` | 返回常量名（字符串，不可覆盖） |
| `toString()` | 返回字符串表示（可覆盖） |
| `ordinal()` | 返回常量位置（从 0 开始） |
| `values()` | 返回所有枚举常量的数组 |
| `valueOf(String)` | 字符串转对应枚举常量 |
| `compareTo(other)` | 比较枚举位置 |
| `equals(other)` | 判断两个枚举值是否相同 |

#### ★ 常考点

- 枚举常量命名**全大写**，如 `MONDAY`
- 枚举可以用 `==` 或 `equals()` 比较
- 枚举在 `switch` 中使用时，`case` 后面**只写常量名**，不写类型名：

```java
switch (today) {
    case MONDAY:           // ✅ 正确
    // case WorkDay.MONDAY:  ❌ 错误！switch 里不加类型前缀
        break;
}
```

- 枚举 vs 常量（`final`）：枚举类型安全、支持方法、自带迭代

---

### Bilingual Notes

#### Enum / 枚举
- Definition (EN): An `enum` is a special kind of class that defines a fixed set of named constant values.
- 定义（中）：`enum` 是一种特殊的类，用来定义一组固定的、带名字的常量值。
- Expansion (EN): The lecture notes emphasize that enums are type-safe, structured, and better than plain strings for representing a closed set of valid choices.
- 补充（中）：讲义强调，枚举具有类型安全和结构化的优点，因此在表示一组有限合法选项时，通常比普通字符串更好。

```java
enum WorkDay { MONDAY, TUESDAY, WEDNESDAY }
```

#### Enum Constant and Ordinal / 枚举常量与序号
- Definition (EN): An enum constant is one named value inside an enum, and each constant has a hidden ordinal representing its position starting from 0.
- 定义（中）：枚举常量是枚举类型中的某个命名值；每个常量还带有一个隐藏的序号，表示它从 0 开始的位置。
- Expansion (EN): By convention, enum constants are written in uppercase letters, often with underscores between words.
- 补充（中）：按照惯例，枚举常量通常使用全大写命名，多个单词之间常用下划线分隔。

```java
WorkDay day = WorkDay.THURSDAY;
```

#### Enum Comparison and `switch` / 枚举比较与 `switch`
- Definition (EN): Enum values can be compared with `==` or `equals()`, and enums can be used as the controlling expression in a `switch` statement.
- 定义（中）：枚举值可以用 `==` 或 `equals()` 比较，也可以作为 `switch` 的控制表达式。
- Expansion (EN): In an enum-based `switch`, the case labels use the constant names only, not the enum type name.
- 补充（中）：在基于枚举的 `switch` 中，`case` 后面只写常量名，不需要再写枚举类型名。

```java
switch (day) {
    case MONDAY: System.out.println("Start"); break;
    default: System.out.println("Other");
}
```

#### Common Enum Methods / 常见枚举方法
- Definition (EN): Java enums provide built-in methods such as `name()`, `toString()`, `ordinal()`, `values()`, and `valueOf()`.
- 定义（中）：Java 的枚举提供了内建方法，例如 `name()`、`toString()`、`ordinal()`、`values()` 和 `valueOf()`。
- Expansion (EN): These methods make enums easy to print, iterate, parse, and compare in a structured way.
- 补充（中）：这些方法让枚举在打印、遍历、解析和比较时都更方便、更规范。

```java
for (WorkDay d : WorkDay.values()) {
    System.out.println(d.name());
}
```

## 11. 包装类 Wrapper Class

### 知识树小纲 Knowledge Tree

- Wrapper class / 包装类
- Why Wrapper Classes? / 为什么需要包装类
- Boxing and unboxing / 装箱与拆箱
- Autoboxing and auto-unboxing / 自动装箱拆箱
- Automatic Boxing and Unboxing / 自动装箱与拆箱
- Wrapper static methods / 包装类静态方法
- Wrapper Classes - Static Methods / 包装类静态方法

### 复习总结 Summary

### 11. 包装类 Wrapper Class

#### ★ 定义速查

**Wrapper Class / 包装类**：把基本类型值封装成对象的类，使基本类型能像对象一样使用。

| 基本类型 | 包装类 |
|----------|--------|
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character`（注意大写C，不是Char） |
| `boolean` | `Boolean` |
| `byte` / `short` / `long` / `float` | `Byte` / `Short` / `Long` / `Float` |

#### ★ 装箱与拆箱

**Boxing / 装箱**：基本类型 → 包装类对象
**Unboxing / 拆箱**：包装类对象 → 基本类型
Java 5.0+ 支持**自动装箱/拆箱（Autoboxing）**：

```java
Integer obj = 42;    // 自动装箱（Auto-boxing）
int x = obj;         // 自动拆箱（Auto-unboxing）
```

#### ★ 常用静态方法

```java
int n = Integer.parseInt("100");         // String → int
String s = Double.toString(123.99);      // double → String

// Character 类方法
Character.toUpperCase('a');     // → 'A'
Character.isDigit('5');         // → true
Character.isLetter('A');        // → true
Character.isWhitespace(' ');    // → true
```

---

### Bilingual Notes

#### Wrapper Class / 包装类
- Definition (EN): A wrapper class is an object type that wraps a primitive value so that the value can behave like an object.
- 定义（中）：包装类是一种对象类型，它把基本类型值封装起来，使这个值能够像对象一样使用。
- Expansion (EN): The lecture maps primitives to wrapper classes, such as `int -> Integer` and `double -> Double`. Wrapper classes are useful because many library features work with objects rather than primitives.
- 补充（中）：讲义把基本类型与包装类一一对应，例如 `int -> Integer`、`double -> Double`。包装类之所以重要，是因为很多库和集合只能处理对象，而不能直接处理基本类型。

```java
Integer numberObject = 42;
```

#### Boxing and Unboxing / 装箱与拆箱
- Definition (EN): Boxing converts a primitive value into a wrapper object, and unboxing converts a wrapper object back into its primitive value.
- 定义（中）：装箱是把基本类型值转换成包装类对象；拆箱则是把包装类对象转换回基本类型值。
- Expansion (EN): Since Java 5.0, both boxing and unboxing can happen automatically, which makes code shorter and more readable.
- 补充（中）：从 Java 5.0 开始，装箱和拆箱很多时候都会自动发生，这让代码更简洁也更易读。

```java
Integer obj = 42;
int x = obj;
```

#### Wrapper Static Methods / 包装类静态方法
- Definition (EN): Wrapper classes provide static methods for converting between strings and numeric values.
- 定义（中）：包装类提供静态方法，用于在字符串和数值之间进行转换。
- Expansion (EN): Examples from the lecture include `Integer.parseInt(...)` and `Double.toString(...)`. The `Character` class also provides many useful static helper methods for character processing.
- 补充（中）：讲义中的典型例子包括 `Integer.parseInt(...)` 和 `Double.toString(...)`。此外，`Character` 类还提供了很多处理字符的实用静态方法。

```java
int number = Integer.parseInt("100");
String text = Double.toString(123.99);
```

## 12. 数组 Array [X考试]

### 知识树小纲 Knowledge Tree

- Array / 数组 [X考试]
- What is an Array / 什么是数组 [X考试]
- Element, index, size / 元素、下标、大小 [X考试]
- Declaration and creation / 声明与创建 [X考试]
- Declaring and Creating Arrays / 声明和创建数组 [X考试]
- Length, access, bounds / 长度、访问、边界 [X考试]
- Referring to Arrays and Array Elements / 引用数组和数组元素 [X考试]
- Array Size in Java / Java 数组大小 [X考试]
- Initialization and traversal / 初始化与遍历 [X考试]
- Initializing Arrays / 初始化数组 [X考试]
- The "for-each" Loop / for-each 循环 [X考试]
- Uses of Square Brackets `[ ]` / 方括号用途 [X考试]
- What is the output? / 输出判断题 [X考试]
- Arrays as objects / 数组也是对象 [X考试]
- Understanding = and == with arrays / 理解数组中的赋值与相等比较 [X考试]
- Array assignment, equality, copying / 数组赋值、相等性、拷贝 [X考试]
- Array parameters and return values / 数组参数与返回数组 [X考试]
- Methods that return arrays / 返回数组的方法 [X考试]
- Privacy leak and deep copy / 隐私泄漏与深拷贝 [X考试]
- Privacy Leaks with Array Member Variables / 数组成员变量的隐私泄漏 [X考试]
- `char[]` vs `String` [X考试]
- char[] is Not a String / char[] 不是 String [X考试]

### 复习总结 Summary

### 12. 数组 Array

#### ★ 定义速查

**Array / 数组**：用来存储和处理**同类型数据集合**的数据结构。
**EN**: A data structure used to store and process a collection of same-type data.

- **Element（元素）**：数组中的单个项目
- **Index（下标）**：元素的位置编号，**从 0 开始**
- **Size / Length（大小/长度）**：数组能容纳的元素总数

#### ★ 声明与创建

```java
// 一步法
int[] scores = new int[5];             // 创建 5 个 int，默认为 0
double[] data = {1.3, 5.2, 5.3};      // 直接初始化，不需要 new

// 两步法
double[] score;
score = new double[5];
```

#### ★ 访问与遍历

```java
score[0] = 10.5;                        // 赋值（下标 0 ~ length-1）
System.out.println(score[3]);           // 读取

// 普通 for 循环（需要索引时使用）
for (int i = 0; i < score.length; i++) {
    System.out.println(score[i]);
}

// for-each 循环（只需要值时使用）
for (double s : score) {
    System.out.println(s);
}
```

#### ★ 数组是对象

- 数组变量存储的是**引用**（内存地址），不是数据本身
- `array.length` 是**实例变量**（不是方法，不加括号！）
- 打印数组名输出的是地址（如 `[D@659e0bfd`），不是内容

#### ★ 数组赋值与拷贝

```java
double[] A = {1.0, 2.0, 3.0};
double[] B = A;          // ⚠️ 浅拷贝！B 和 A 指向同一个数组

// 深拷贝（内容复制）
for (int i = 0; i < A.length && i < B.length; i++) {
    B[i] = A[i];
}

// 或使用 clone()
B = A.clone();
```

#### ★ 隐私泄漏（Privacy Leak）与***深拷贝***

**隐私泄漏**：getter 直接返回私有数组的引用，外部代码可以修改私有数据。

```java
// ❌ 不安全（隐私泄漏）
public double[] getArray() { return anArray; }

// ✅ 安全（返回深拷贝）
public double[] getArray() { return anArray.clone(); }
```

#### ★ 方法接收/返回数组

```java
// 方法接收数组参数
public static void printArray(int[] arr) { ... }

// 方法返回数组
public static int[] doubleValues(int[] input) {
    int[] result = new int[input.length];
    for (int i = 0; i < input.length; i++) {
        result[i] = input[i] * 2;
    }
    return result;
}
```

#### ★ `char[]` 与 `String` 的区别

```java
char[] a = {'A', 'B', 'C'};
// String s = a;        // ❌ 非法！

String s = new String(a);       // ✅ 转换为 "ABC"
System.out.println(a);          // ✅ char[] 可直接 println，输出 ABC
```

#### ★ 常考点

- 下标越界 → 运行时抛出 **`ArrayIndexOutOfBoundsException`**
- `array.length` vs `string.length()` vs `list.size()` — 注意括号的有无
- `B = A` 不创建新数组，只是让 B 指向同一个数组
- `B == A` 为 `true` 当且仅当 B 和 A 指向**同一个数组对象**

---

### Bilingual Notes

> 本章整体属于 Week 12 Revision 标出的 non-examinable topics，故保留内容但标记为 `[X考试]`。

#### Array / 数组 [X考试]
- Definition (EN): An array is a data structure used to store and process a collection of same-type data.
- 定义（中）：数组是一种用来存储和处理同类型数据集合的数据结构。
- Expansion (EN): The lecture describes an array as a list of boxes with numbered positions. Arrays are ideal when you need indexed access to many related values of the same base type.
- 补充（中）：讲义把数组形象地描述成“带编号的一排盒子”。当你需要按下标访问一组同类型相关数据时，数组尤其合适。

```java
int[] scores = new int[4];
```

#### Array Element, Index, and Size / 数组元素、下标与大小 [X考试]
- Definition (EN): An element is one item in an array, the index is its position number, and the size is the total number of elements.
- 定义（中）：数组元素是数组中的单个项目；下标是它的位置编号；大小是数组能容纳的元素总数。
- Expansion (EN): Java arrays are zero-indexed, so valid indices run from `0` to `length - 1`.
- 补充（中）：Java 数组从 0 开始编号，因此合法下标范围是 `0` 到 `length - 1`。

```java
int value = scores[0];
```

#### Array Declaration and Creation / 数组声明与创建 [X考试]
- Definition (EN): Array declaration introduces an array variable type, and array creation allocates space for a specific number of elements.
- 定义（中）：数组声明是引入数组变量类型；数组创建则是为指定数量的元素分配空间。
- Expansion (EN): The lecture shows both one-statement and two-statement forms. Creation uses `new`, while declaration only introduces the variable.
- 补充（中）：讲义展示了单语句和双语句两种写法。创建数组要用 `new`，而声明本身只是引入变量。

```java
double[] score;
score = new double[5];
```

#### Array Length / 数组长度 [X考试]
- Definition (EN): `length` is the instance variable of an array that stores its size.
- 定义（中）：`length` 是数组自带的实例变量，用来保存数组长度。
- Expansion (EN): It is set automatically when the array is created and cannot be changed directly. The lecture also contrasts `array.length` with `str.length()` for strings.
- 补充（中）：数组创建时，`length` 会自动设定，而且不能直接修改。讲义还特别对比了 `array.length` 和字符串的 `str.length()`。

```java
System.out.println(scores.length);
```

#### Accessing Arrays and Bounds / 数组访问与边界 [X考试]
- Definition (EN): An array element is accessed with an indexed expression such as `arrayName[index]`.
- 定义（中）：数组元素通过带下标的表达式访问，例如 `arrayName[index]`。
- Expansion (EN): Accessing an index outside the valid range causes a runtime error called `ArrayIndexOutOfBoundsException`.
- 补充（中）：如果访问了合法范围之外的下标，就会发生运行时错误 `ArrayIndexOutOfBoundsException`。

```java
score[3] = 10.5;
```

#### Array Initialization / 数组初始化 [X考试]
- Definition (EN): Array initialization gives values to array elements, either explicitly with braces or later through assignments or loops.
- 定义（中）：数组初始化就是给数组元素赋初值，可以在声明时用花括号直接写出，也可以之后通过赋值或循环完成。
- Expansion (EN): If elements are not initialized explicitly, Java automatically assigns each element the default value for its base type.
- 补充（中）：如果数组元素没有被显式初始化，Java 会自动把每个元素设为其基类型的默认值。

```java
double[] score = {1.3, 5.2, 5.3};
```

#### Array Traversal / 数组遍历 [X考试]
- Definition (EN): Array traversal means visiting array elements one by one, usually with a loop.
- 定义（中）：数组遍历就是通常借助循环按顺序逐个访问数组元素。
- Expansion (EN): The lecture mostly uses index-based `for` loops, which are useful when you need both the position and the value.
- 补充（中）：讲义主要使用基于下标的 `for` 循环来遍历数组，这种方式在你同时需要“位置”和“值”时尤其方便。

```java
for (int i = 0; i < reading.length; i++) {
    System.out.println(reading[i]);
}
```

#### Arrays as Objects / 数组也是对象 [X考试]
- Definition (EN): In Java, arrays are objects, so array variables store references rather than the full array contents directly.
- 定义（中）：在 Java 中，数组本身也是对象，因此数组变量保存的是引用，而不是完整数组内容本身。
- Expansion (EN): This is why arrays behave like objects in assignment, comparison, and method passing.
- 补充（中）：这就是为什么数组在赋值、比较和方法传参时，会表现得和一般对象非常相似。

```java
double[] a = new double[3];
double[] b = a;
```

#### Array Assignment, Equality, and Copying / 数组赋值、相等性与拷贝 [X考试]
- Definition (EN): Assigning one array variable to another copies the reference, `==` checks whether two array variables refer to the same array, and element-wise copying is needed to duplicate contents.
- 定义（中）：把一个数组变量赋给另一个变量时，复制的是引用；`==` 检查的是两个变量是否指向同一个数组；若想复制内容，则需要逐元素拷贝。
- Expansion (EN): The lecture discusses shallow copying with reference assignment and contrasts it with content copying via a loop. For beginners, the key point is that `B = A` does not create a new independent array.
- 补充（中）：讲义对比了引用赋值带来的浅层共享，与通过循环复制内容的做法。初学时最关键的一点是：`B = A` 不会创建一个独立的新数组。

```java
for (int i = 0; i < A.length && i < B.length; i++) {
    B[i] = A[i];
}
```

#### Array Parameters and Returning Arrays / 数组参数与返回数组 [X考试]
- Definition (EN): A method can accept an array as a parameter and can also return an array as its result.
- 定义（中）：方法既可以把数组作为参数接收，也可以把数组作为返回结果返回。
- Expansion (EN): Because arrays are reference types, passing or returning arrays should always make you think about shared mutable data.
- 补充（中）：由于数组是引用类型，因此只要涉及数组作为参数或返回值，就要特别留意“共享且可变”的数据风险。

```java
public static int[] doubleValues(int[] input) {
    int[] result = new int[input.length];
    return result;
}
```

#### Privacy Leak and Deep Copy / 隐私泄漏与深拷贝 [X考试]
- Definition (EN): A privacy leak happens when internal private array data is exposed directly, allowing outside code to modify it; a deep copy prevents this by returning an independent copy.
- 定义（中）：当类把内部私有数组直接暴露出去，外部代码就能修改它，这叫隐私泄漏；深拷贝通过返回一个独立副本来避免这个问题。
- Expansion (EN): The lecture warns that returning a private array directly from an accessor is unsafe. If the array contains objects, each object may also need copying to avoid leaks fully.
- 补充（中）：讲义明确提醒：getter 如果直接返回私有数组，是不安全的。如果数组里装的是对象，那么为了彻底避免泄漏，数组中的每个对象往往也需要复制。

```java
public double[] getArray() {
    return anArray.clone();
}
```

## 13. Arrays II 数组进阶 [X考试]

> Week 12 Revision 明确把 Arrays、Variable number of parameters、Sorting an Array 列为 non-examinable，所以本章大量内容标 `[X考试]`。  
> 但按你的复习策略，这一章仍然通览：它和数组引用、封装、enum、class、method、loop 等前面知识高度交叉，很适合用来读代码和排坑。

### 知识树小纲 Knowledge Tree

- Arrays II overview / 数组进阶概览 [X考试]
  - Methods with a variable number of parameters / 变长参数 [X考试]
  - Resizable arrays / 可扩容数组 [X考试]
  - Sorting arrays / 数组排序 [X考试]
  - Multidimensional arrays / 多维数组 [X考试]

- Varargs 变长参数 [X考试]
  - Methods with a variable No. of parameters / 变长参数方法 [X考试]
  - Syntax: `Type... name`
  - Example: `int... numbers`
  - Vararg must be the last parameter
  - Java treats varargs as an array inside the method
  - `System.out.printf(format, arg1, arg2, ..., argN)` as a familiar example

- Unknown array size 未知大小数组 [X考试]
  - Final size may be unknown at the start
  - Guessing too small causes insufficient space
  - Guessing too large wastes memory
  - Naive solution: reallocate the whole array each time a new element is added
  - Naive approach creates large copying overhead

- Partially filled array 部分填充数组 [X考试]
  - `array.length` means total capacity, not actual used count
  - Use `count` to track how many elements are actually filled
  - Valid filled range is `array[0]` to `array[count - 1]`
  - Unused elements should not be treated as meaningful data
  - `count` must be passed to methods that process a partially filled array
  - Better design: encapsulate the array and count inside a class

- Efficient resizing strategy 高效扩容策略 [X考试]
  - When the array is full, create a new array with double capacity
  - Copy existing elements into the new array
  - Replace the old array reference with the new one
  - Doubling reduces number of reallocations and total copied elements

- Sorting an array 数组排序 [X考试]
  - Sorting rearranges elements within an array
  - Selection sort repeatedly finds the smallest unsorted element
  - The smallest element is moved to the front of the unsorted part
  - Selection sort is easy to understand and code
  - More efficient sorting algorithms are left for future units / ED lessons

- Multidimensional arrays 多维数组 [X考试]
  - Arrays with more than one index
  - Two-dimensional arrays are the most common case
  - Useful for tables, matrices, structured rows and columns
  - Declaration: `type[][] arrayName = new type[rowSize][columnSize]`
  - Each element is still a variable of the base type
  - Initializing Multidimensional Arrays / 初始化多维数组 [X考试]

- Arrays of arrays 数组的数组 [X考试]
  - Java multidimensional arrays are arrays of arrays
  - `a.length` gives number of rows
  - `a[0].length` gives number of columns in the first row
  - Rows can be created separately

- Ragged array 不规则数组 [X考试]
  - Rows can have different lengths
  - Ragged arrays can save memory
  - Ragged arrays increase complexity

- Multidimensional arrays as parameters 多维数组作为参数 [X考试]
  - Method can return a 2D array: `double[][] generateMatrix()`
  - Method can accept a 2D array: `printTable(int[][] table)`
  - A single row of a 2D array is a 1D array: `printRow(numbers[0])`

- Random Generator 随机数生成器
  - Random Generators / 随机数生成器
  - `Random rand = new Random()`
  - Generates pseudo-random numbers
  - Common in simulations, games, testing
  - Uses a seed to produce a reproducible sequence
  - Important methods: `nextInt()`, `nextInt(bound)`, `nextDouble()`, `nextFloat()`, `nextBoolean()`, `setSeed(long seed)`
  - This topic is not separately named in Week 12's non-examinable list, so it is not marked `[X考试]`; still review it because it appears in Week 6.

- Live Coding: Order Engine 订单系统练习 [mostly X考试]
  - Demonstrates 1D and 2D arrays [X考试]
  - Demonstrates partially filled arrays with counters [X考试]
  - Demonstrates resizable arrays with doubling strategy [X考试]
  - Demonstrates varargs [X考试]
  - Also revises enum, class design, constructors, getters/setters, encapsulation, and `main`
  - Components: `Menu` enum, `Client` class, `OrderEngine` class

### 复习总结 Summary

#### 13.1 Arrays II Overview / 数组进阶概览 [X考试]

Week 6 continues from Week 5 arrays. The central idea is that arrays are fixed-size objects, so when the required amount of data is unknown, the programmer must manage capacity, actual used count, resizing, copying, and valid access range.

第 6 周是在第 5 周数组基础上继续扩展。核心是：数组本身大小固定，因此当数据量一开始不知道时，程序员需要管理容量、实际使用数量、扩容、拷贝和合法访问范围。

常见主线：

| Topic | 中文 | 核心问题 |
|---|---|---|
| Varargs | 变长参数 | 方法参数数量不固定怎么办 |
| Unknown array size | 未知大小数组 | 一开始不知道要存多少元素怎么办 |
| Partially filled array | 部分填充数组 | 数组容量和实际元素数量如何区分 |
| Resizable array | 可扩容数组 | 满了以后怎样高效扩容 |
| Sorting array | 数组排序 | 如何按顺序重新排列数组元素 |
| Multidimensional array | 多维数组 | 如何表示表格、矩阵、二维数据 |
| Random generator | 随机数生成器 | 如何生成可控的伪随机数据 |

#### 13.2 Varargs 变长参数 [X考试]

**定义**：Varargs allows a method to accept zero or more arguments of the same type.  
**中文定义**：变长参数允许一个方法接收 0 个或多个同类型参数。

```java
public static int max(int... numbers) {
    int largest = Integer.MIN_VALUE;
    for (int n : numbers) {
        if (n > largest) {
            largest = n;
        }
    }
    return largest;
}
```

调用方式：

```java
max(3, 7, 2);
max();
```

常考/易错点：

- `Type... name` 中的 `...` 是必须的。
- varargs 在方法内部表现得像数组。
- varargs 必须是最后一个参数。
- `int... numbers` 可以接收 zero or more `int` values。
- `System.out.printf(format, arg1, arg2, ..., argN)` 是常见的变长参数例子。

#### 13.3 Unknown Array Size 未知大小数组 [X考试]

问题：有些时候数组最终需要多大，一开始并不知道。

例子：用户可以输入任意多个数字，程序无法提前知道总数。

如果估计太小：

- 数组会装不下。

如果估计太大：

- 浪费内存。

naive solution 是每加入一个元素就创建一个更大的新数组，然后把旧数组内容全部复制过去。这种方式逻辑简单，但非常低效，因为每次添加都要重新分配和复制。

```java
int[] numbers = {};
for (int i = 0; i < 100; i++) {
    int[] newArray = new int[numbers.length + 1];
    for (int j = 0; j < numbers.length; j++) {
        newArray[j] = numbers[j];
    }
    newArray[numbers.length] = i;
    numbers = newArray;
}
```

记忆点：**每次只扩 1 个位置，会导致复制开销不断累积。**

#### 13.4 Partially Filled Array 部分填充数组 [X考试]

**定义**：A partially filled array is an array whose capacity is larger than the number of actual meaningful elements stored in it.  
**中文定义**：部分填充数组是指数组容量大于实际有效元素数量的数组。

关键区别：

| Concept | Meaning |
|---|---|
| `array.length` | total capacity / 数组总容量 |
| `count` | number of filled elements / 实际有效元素数量 |
| valid filled range | `array[0]` to `array[count - 1]` |

典型写法：

```java
int[] numbers = new int[1000];
int count = 0;

while (input != -1 && count < numbers.length) {
    numbers[count] = input;
    count++;
    input = sc.nextInt();
}
```

常考/易错点：

- `array.length` 不等于已经填入的元素个数。
- 未使用的位置可能含有默认值，例如 `0`，但这些默认值不一定是有效数据。
- 处理部分填充数组的方法通常需要同时接收 `array` 和 `count`。
- 更好的设计是把 `array` 和 `count` 封装到同一个类中，避免到处手动传两个变量。

#### 13.5 Efficient Resizing Strategy 高效扩容策略 [X考试]

高效做法：数组满了之后，不是每次只加 1 个空间，而是直接把容量翻倍。

```java
if (count == numbers.length) {
    int[] newArray = new int[numbers.length * 2];
    for (int j = 0; j < numbers.length; j++) {
        newArray[j] = numbers[j];
    }
    numbers = newArray;
}
numbers[count] = i;
count++;
```

为什么翻倍更好：

- 减少重新分配数组的次数。
- 减少总复制元素数量。
- 在实际程序中更接近动态数组/ArrayList 背后的基本思想。

高频提醒：

- `count == numbers.length` 表示容量满了。
- 扩容后不要忘记 `numbers = newArray;`。
- 加入新元素后才 `count++`。

#### 13.6 Sorting an Array 数组排序 [X考试]

**定义**：Sorting rearranges elements within an array into a specified order.  
**中文定义**：排序是把数组中的元素按照某种顺序重新排列。

Week 6 介绍的是 selection sort 的思想：

1. 把数组分成 sorted part 和 unsorted part。
2. 在 unsorted part 中找到最小元素。
3. 把这个最小元素放到 unsorted part 的开头。
4. 重复直到整个数组有序。

核心句：**Find the smallest element from the unsorted portion and put it at the start.**

复习重点：

- selection sort 容易理解和实现。
- 它不是最高效的排序算法。
- 更高效的排序算法属于之后课程/ED lesson 的 advanced topic。

#### 13.7 Multidimensional Arrays 多维数组 [X考试]

**定义**：A multidimensional array is an array with more than one index.  
**中文定义**：多维数组是需要多个下标才能定位元素的数组。

最常见的是二维数组：

```java
int[][] table = new int[100][10];
char[][] chars = new char[5][12];
```

声明格式：

```java
type[][] arrayName = new type[rowSize][columnSize];
```

用途：

- tables / 表格
- matrices / 矩阵
- rows and columns / 行列结构
- structured data storage / 结构化数据存储

关键点：

- 二维数组元素用两个 index 访问，例如 `table[row][col]`。
- 每个元素仍然是 base type 的变量。
- 多维数组可以有更多维，例如 `double[][][] map`。

#### 13.8 Arrays of Arrays 数组的数组 [X考试]

***Java 中多维数组本质上是 arrays of arrays。***

```java
int[][] numbers = new int[3][5];
```

可以理解为：

- `numbers` 是一个数组。
- `numbers[0]`、`numbers[1]`、`numbers[2]` 各自又是一个 `int[]`。

长度含义：

```java
a.length      // number of rows
a[0].length   // number of columns in first row
```

也可以先创建外层数组，再分别创建每一行：

```java
int[][] numbers = new int[3][];
numbers[0] = new int[5];
numbers[1] = new int[5];
numbers[2] = new int[5];
```

#### 13.9 Ragged Array 不规则数组 [X考试]

**定义**：A ragged array is a multidimensional array whose rows can have different lengths.  
**中文定义**：不规则数组是指每一行长度可以不同的多维数组。

```java
int[][] numbers = new int[3][];
numbers[0] = new int[5];
numbers[1] = new int[8];
numbers[2] = new int[4];
```

优点：

- Saves memory / 节省内存。

缺点：

- Increases complexity / 增加复杂度。

易错点：

- 不要假设每一行长度都等于 `numbers[0].length`。
- 遍历 ragged array 时，内层循环通常写 `numbers[row].length`。

```java
for (int row = 0; row < numbers.length; row++) {
    for (int col = 0; col < numbers[row].length; col++) {
        System.out.println(numbers[row][col]);
    }
}
```

#### 13.10 Multidimensional Arrays as Parameters 多维数组作为参数 [X考试]

方法可以返回二维数组：

```java
public double[][] generateMatrix() {
    // ...
}
```

方法可以接收二维数组：

```java
public void printTable(int[][] table) {
    // ...
}
```

二维数组中的某一行可以作为一维数组传入方法：

```java
int[][] numbers = {{85, 90, 78}, {76, 88, 91}};
printRow(numbers[0]);
```

记忆点：

- `numbers` 是 `int[][]`。
- `numbers[0]` 是 `int[]`。
- 所以 `printRow(int[] row)` 可以接收 `numbers[0]`。

#### 13.11 Random Generator 随机数生成器

**定义**：`Random` provides methods to generate pseudo-random numbers.  
**中文定义**：`Random` 提供生成伪随机数的方法。

典型用法：

```java
Random rand = new Random();
int num = rand.nextInt(100);
boolean b = rand.nextBoolean();
```

常用方法：

| Method | Meaning |
|---|---|
| `nextInt()` | returns a random `int` |
| `nextInt(bound)` | returns an int from `0` inclusive to `bound` exclusive |
| `nextDouble()` | returns a double between `0.0` and `1.0` |
| `nextFloat()` | returns a float between `0.0` and `1.0` |
| `nextBoolean()` | returns `true` or `false` randomly |
| `setSeed(long seed)` | sets the seed for reproducibility |

关于 seed：
- Random 使用 seed 生成一串伪随机数。
- 如果重置相同 seed，再运行一次，会得到同一组随机数。
- 这叫 reproducibility，在测试和对照代码行为时很有用。
### Bilingual Notes

#### Varargs / 变长参数 [X考试]

- Definition (EN): Varargs allow a method to accept any number of arguments of the same type, including zero arguments.
- 定义（中）：变长参数允许方法接收任意数量的同类型参数，包括 0 个参数。
- Expansion (EN): Inside the method, Java treats the varargs parameter like an array. This makes varargs convenient when the caller should not need to manually create an array.
- 补充（中）：在方法内部，Java 会把变长参数当成数组处理。因此当调用者不想手动创建数组时，变长参数很方便。

```java
public static void printAll(String... words) {
    for (String word : words) {
        System.out.println(word);
    }
}
```

#### Unknown Array Size / 未知大小数组 [X考试]

- Definition (EN): An unknown-size array problem occurs when the program must store values but cannot know in advance how many values will be needed.
- 定义（中）：未知大小数组问题指程序需要存储一组值，但一开始无法知道最终需要多少个位置。
- Expansion (EN): Because Java arrays have fixed length after creation, the programmer must either estimate capacity, use a resizing strategy, or switch to a collection type in later Java topics.
- 补充（中）：因为 Java 数组创建后长度固定，所以程序员要么预估容量，要么设计扩容策略，要么在之后的 Java 内容中使用集合类型。

#### Partially Filled Array / 部分填充数组 [X考试]

- Definition (EN): A partially filled array uses a fixed-capacity array together with a counter that records how many positions currently store meaningful data.
- 定义（中）：部分填充数组用一个固定容量数组配合一个计数器，记录当前有多少位置真正存了有效数据。
- Expansion (EN): The counter is essential because the array's `length` only reports capacity, not the number of used elements.
- 补充（中）：计数器很关键，因为数组的 `length` 只表示容量，不表示已经使用了多少个元素。

```java
int[] values = new int[10];
int count = 0;
values[count] = 42;
count++;
```

#### Resizable Array / 可扩容数组 [X考试]

- Definition (EN): A resizable array is an array-management pattern where a larger array is created and existing elements are copied when the current array becomes full.
- 定义（中）：可扩容数组是一种数组管理模式：当前数组满了以后，新建一个更大的数组，并把旧元素复制过去。
- Expansion (EN): Doubling capacity is more efficient than increasing the array by one element each time because it reduces repeated copying.
- 补充（中）：容量翻倍比每次只增加一个位置更高效，因为它减少了反复复制的次数。

#### Selection Sort / 选择排序 [X考试]

- Definition (EN): Selection sort is a sorting algorithm that repeatedly selects the smallest element from the unsorted portion and places it at the front.
- 定义（中）：选择排序是一种排序算法，它反复从未排序部分选出最小元素，并把它放到前面。
- Expansion (EN): It is easy to understand and implement, but it is not the most efficient sorting algorithm.
- 补充（中）：选择排序容易理解和实现，但并不是最高效的排序算法。

#### Multidimensional Array / 多维数组 [X考试]

- Definition (EN): A multidimensional array is an array structure accessed using more than one index.
- 定义（中）：多维数组是需要多个下标访问的数组结构。
- Expansion (EN): In Java, multidimensional arrays are arrays of arrays, which means each row can itself be an independent array.
- 补充（中）：在 Java 中，多维数组本质上是数组的数组，因此每一行本身也可以是独立数组。

```java
int[][] table = new int[3][4];
table[0][0] = 10;
```

#### Ragged Array / 不规则数组 [X考试]

- Definition (EN): A ragged array is a multidimensional array whose rows do not all have the same length.
- 定义（中）：不规则数组是各行长度不完全相同的多维数组。
- Expansion (EN): Ragged arrays can save memory when rows naturally contain different amounts of data, but loops must use each row's own length.
- 补充（中）：当每一行天然数据量不同时，不规则数组可以节省内存；但遍历时必须使用每一行自己的长度。

```java
for (int row = 0; row < data.length; row++) {
    for (int col = 0; col < data[row].length; col++) {
        System.out.println(data[row][col]);
    }
}
```

#### Random Generator / 随机数生成器

- Definition (EN): A random generator produces pseudo-random values through methods such as `nextInt`, `nextDouble`, and `nextBoolean`.
- 定义（中）：随机数生成器通过 `nextInt`、`nextDouble`、`nextBoolean` 等方法生成伪随机值。
- Expansion (EN): Setting a seed makes the generated sequence reproducible, which is useful for testing.
- 补充（中）：设置 seed 可以让生成的随机序列可复现，这对测试很有用。


### Week 6 考点/通览清单 Review Checklist

> 勾选时不要因为 `[X考试]` 就完全跳过。这里的目标是：能读懂、能解释，不必把高级数组算法当主考点死背。

- [ ] 知道 varargs 的语法：`Type... name` [X考试]
- [ ] 知道 varargs 必须是最后一个参数 [X考试]
- [ ] 能解释 varargs 在方法内部像数组 [X考试]
- [ ] 能解释未知大小数组为什么麻烦 [X考试]
- [ ] 能区分 `array.length` 和 `count` [X考试]
- [ ] 知道部分填充数组的有效范围是 `0` 到 `count - 1` [X考试]
- [ ] 知道为什么把 array 和 count 封装进类更安全 [X考试]
- [ ] 能说出 naive resizing 为什么低效 [X考试]
- [ ] 能说出 doubling strategy 的基本步骤 [X考试]
- [ ] 知道 selection sort 的核心思想 [X考试]
- [ ] 知道二维数组声明和访问语法：`int[][] table`, `table[row][col]` [X考试]
- [ ] 知道 Java 多维数组本质是 arrays of arrays [X考试]
- [ ] 能解释 `a.length` vs `a[0].length` [X考试]
- [ ] 知道 ragged array 的优缺点 [X考试]
- [ ] 能看懂二维数组作为参数、返回值、一行作为一维数组传入方法 [X考试]
- [ ] 知道 `Random` 的常见方法：`nextInt`, `nextDouble`, `nextBoolean`, `setSeed`
- [ ] 知道 seed 和 reproducibility 的关系
- [ ] 能通览 Order Engine 的三个组件：`Menu`, `Client`, `OrderEngine`
- [ ] 能看懂 Order Engine 里 array、count、doubling、varargs 的作用 [X考试]

## 14. 高频易混对比 High-Confusion Comparisons

> 注意：原 Week1-5 总结中的“必考”标题沿用原文；具体是否考试，以本文件中的 `[X考试]` 标记和 Week 12 Revision 为准。

### 复习总结 Summary

### 13. ⚠️ 高频易混对比（必考）

| 对比点 | 一个 | 另一个 | 关键区别 |
|--------|------|--------|----------|
| **表达式 vs 语句** | Expression（有值） | Statement（执行动作） | `x + 1` 是表达式；`x = 1;` 是语句 |
| **类 vs 对象 vs 实例** | Class = 蓝图 | Object/Instance = 运行中的具体实体 | `Car` 是类；`new Car()` 是对象 |
| **形参 vs 实参** | Parameter（方法定义中的变量） | Argument（调用时传入的值） | 定义 vs 使用 |
| **实例变量 vs 静态变量** | 每个对象一份 | 整个类共享一份 | `static` 关键字区分 |
| **基本类型 vs 引用类型** | 直接存值 | 存引用（地址） | `int` vs `Car` |
| **`while` vs `do-while`** | 可能 0 次执行 | 至少 1 次执行 | 条件判断在前 vs 在后 |
| **`==` vs `equals()`** | 比较引用（地址） | 比较内容/逻辑相等 | 对象用 `equals()`，基本类型用 `==` |
| **`array.length` vs `str.length()`** | 数组：属性（无括号） | 字符串：方法（有括号） | 一个是变量，一个是方法 |
| **浅拷贝 vs 深拷贝** | `B = A`（共享同一数组） | 逐元素复制 / `.clone()` | 改 A 会影响 B（浅）vs 不影响（深） |
| **`break` vs `continue`** | 退出整个循环 | 跳过本次迭代，继续下一轮 | 完全终止 vs 跳过一轮 |
| **static 方法 vs 实例方法** | 不能访问实例变量，用类名调用 | 可以访问实例变量，用对象调用 | 有无 `static` 关键字 |
| **String 的 `==` vs `equals()`** | `==` 比较引用 | `equals()` 比较字符序列 | 字符串比较必须用 `equals()` |

---

### Bilingual Notes

### 6. High-Confusion Quick Comparisons / 高频易混对比速记

- Expression vs Statement: An expression produces a value; a statement performs an action.  
  表达式会产生一个值；语句执行一个动作。

- Class vs Object vs Instance: A class is a blueprint; an object is a concrete runtime entity; an instance is an object created from a class.  
  类是蓝图；对象是运行中的具体实体；实例就是由类创建出来的对象。

- Parameter vs Argument: A parameter appears in a method definition; an argument is the actual value passed in a call.  
  形参写在方法定义里；实参是在调用时真正传进去的值。

- Instance Member vs Static Member: An instance member belongs to each object; a static member belongs to the class and is shared.  
  实例成员属于每个对象各自一份；静态成员属于类本身并被共享。

- Primitive vs Reference: A primitive stores a direct value; a reference stores an address-like reference to an object.  
  基本类型直接存值；引用类型保存的是指向对象的引用。

- Assignment vs Aliasing: Primitive assignment copies the value; reference assignment may create two names for the same object.  
  基本类型赋值复制值本身；引用赋值可能只是让两个变量指向同一个对象。

- Array Variable vs Array Object: The array variable stores the reference; the array object stores the actual elements.  
  数组变量保存引用；数组对象才真正保存各个元素。

- `==` vs `equals()`: `==` checks identity; `equals()` checks logical or content equality when properly implemented.  
  `==` 检查是不是同一个对象；`equals()` 在正确实现时检查逻辑或内容是否相等。

- `while` vs `do-while`: `while` may run zero times; `do-while` runs at least once.  
  `while` 可能一次都不执行；`do-while` 至少执行一次。

- `length` vs `length()`: Arrays use the variable `length`; strings use the method `length()`.  
  数组用变量 `length`；字符串用方法 `length()`。

## 15. 考点速查清单 Review Checklist

> 注意：Week 5 中与数组相关的 checklist 项对应 `[X考试]`。

### 14. 📋 考点速查清单

#### Week 1 — Java 基础

- [ ] `javac` / `JVM` / `JRE` / `JDK` 各自的职责和层级关系
- [ ] `main` 方法签名：`public static void main(String[] args)`
- [ ] 基本类型分类及默认值
- [ ] 整数除法 vs 浮点除法：`5/2=2` vs `5.0/2=2.5`
- [ ] 类型宽化（自动）vs 窄化（强制转换）
- [ ] 前置/后置自增：`++x` vs `x++` 的区别
- [ ] 短路运算符 `&&` 和 `||`
- [ ] `char` 与 `int` 的转换（ASCII）
- [ ] `System.out.print` vs `println` vs `printf` 的区别
- [ ] `Scanner` 读取输入的基本用法

#### Week 2 — 控制流

- [ ] `if` / `if-else` / 多路 `if-else` 的结构
- [ ] 条件运算符 `? :` 的用法（它是表达式，有值）
- [ ] `switch` 语句：`break` 的重要性；`case` 标签类型限制；`default`
- [ ] `while` 可能 0 次；`do-while` 至少 1 次
- [ ] `for` 循环三部分：初始化；条件；更新
- [ ] `break` 退出循环；`continue` 跳过本轮
- [ ] 无限循环的成因
- [ ] `assert` 断言的默认关闭状态

#### Week 3 — 类与方法 I

- [ ] 类 = 蓝图；对象 = 实例；实例化 = `new`
- [ ] 方法头 + 方法体；`void` vs 有返回值方法
- [ ] `return` 在有返回值方法中是必须的；在 void 中用于提前退出
- [ ] 形参 vs 实参（Parameter vs Argument）
- [ ] `this` 的作用：区分实例变量和形参
- [ ] 三种构造器：默认 / 带参 / 拷贝
- [ ] 没有构造器时 Java 自动生成默认构造器；有了带参构造器就不再自动生成
- [ ] `toString()` 打印时自动调用
- [ ] `==` 比较引用；`equals()` 比较内容

#### Week 4 — 类与方法 II

- [ ] `public` vs `private`：实例变量应 `private`
- [ ] `getter` 方法以 `get` 开头；`setter` 方法以 `set` 开头
- [ ] 重载（Overloading）：同名方法，签名（参数）不同；仅返回类型不同不构成重载
- [ ] `static` 方法：不能访问实例变量；通过类名调用
- [ ] `static` 变量：类共享一份
- [ ] `final`：值不可变，命名全大写
- [ ] 基本类型变量存值；引用类型变量存地址
- [ ] `B = A`（引用类型）：共享同一对象，改 A 影响 B
- [ ] Java 是**值传递**：传基本类型复制值；传对象复制引用
- [ ] `String` 不可变：方法内修改不影响原 String
- [ ] `null`：测试用 `==`；访问 null 引用 → `NullPointerException`

#### Week 5 — 枚举、包装类、数组

- [ ] `enum`：固定常量集合，类型安全；常量名全大写
- [ ] `enum` 在 `switch` 中：`case` 后只写常量名，不写类型前缀
- [ ] `enum` 内置方法：`values()`, `ordinal()`, `name()`, `valueOf()`
- [ ] 包装类：`int→Integer`, `char→Character`, `double→Double` 等
- [ ] 自动装箱/拆箱（Java 5.0+）
- [ ] `Integer.parseInt()` / `Double.toString()` 等静态方法
- [ ] `Character` 方法：`isDigit`, `isLetter`, `toUpperCase`, `isWhitespace`
- [ ] 数组：下标从 0 开始；`length` 是属性（无括号）
- [ ] `ArrayIndexOutOfBoundsException` 触发条件
- [ ] `B = A` 是浅拷贝；用循环或 `.clone()` 做深拷贝
- [ ] `==` 对数组比较引用；内容比较需逐元素
- [ ] 数组 getter 直接返回引用 → 隐私泄漏；用 `.clone()` 安全返回
- [ ] `for-each` 语法：`for (Type var : array)`；无法使用索引
- [ ] `char[]` 不是 `String`；转换用 `new String(charArray)`

---

*整理自 COMP90041 Week 1–5 讲义 + 双语笔记 | 2026 Semester 1*

## 16. 最后复习建议 Final Review Advice

### 7. Final Review Advice / 最后复习建议

- Read the note by concept, not by week, and focus first on the comparison section if you are still mixing similar terms.
- 复习时优先按概念而不是按周次阅读；如果你还容易混淆相近术语，先看“高频易混对比”那一节。

- When memorizing a term, always ask three things: what it is, what it returns or stores, and how it behaves in code.
- 记一个术语时，建议总问自己三件事：它是什么、它返回或存储什么、它在代码里怎么表现。

- If a definition still feels abstract, rewrite the short example by hand and change one value to see what stays the same and what changes.
- 如果某个定义还是偏抽象，就把后面的短例子手写一遍，再改一个值，观察“什么不变、什么会变”。

## 17. PDF 覆盖终审 PDF Coverage Audit

终审方法：对照 Week 1-6 PDF 的 slide title/目录顺序，检查本文件是否覆盖对应知识点。行政、版权、Acknowledgement、break、see you next time 等非知识性页面在“课程信息/学习资源”层面合并处理。

| PDF | 覆盖结论 | 已覆盖主题 |
|---|---|---|
| Week 1 - Introduction to Programming | OK | 课程信息、考核规则、Java 工具链、程序结构、数据类型、变量、I/O、运算符、类型转换、String |
| Week 2 - Control Flows | OK | 表达式/语句/代码块、条件分支、switch、循环、break/continue、labelled break、exit、debugging |
| Week 3 - Classes and Methods I | OK | OOP 动机、类与对象、引用类型、字段、方法、参数、this、equals、toString、构造器 |
| Week 4 - Classes and Methods II | OK | getter/setter、访问控制、重载、static、final、内存、引用、pass-by-value、String 特例、null、匿名对象 |
| Week 5 - Arrays | OK | enum、wrapper class、boxing/unboxing、数组声明/创建/访问/初始化/遍历、数组引用、privacy leak、char[] vs String；数组已标 `[X考试]` |
| Week 6 - Arrays II | OK | varargs、unknown array size、partially filled array、doubling resize、selection sort、multidimensional arrays、arrays of arrays、ragged array、2D array parameters、Random generator、Order Engine；数组/变长参数/排序相关内容已标 `[X考试]` |

### 终审备注 Audit Notes

- Week 1-5 的复习总结内容已按原章节全部纳入：Summary chapters 1-14。
- Week 1-5 的 bilingual concept notes 已全部纳入：所有二级知识块和三级概念小节均已归位。
- Week 6 已新增总分式章节：知识树小纲、复习总结、Bilingual Notes、Review Checklist。
- Week 12 Revision 中明确排除的 Week 5-6 数组、变长参数、数组排序等内容已标 `[X考试]`，但没有删除。
- PDF 中重复出现的 copyright、acknowledgement、additional reading、live coding、break 等页面已合并到来源/学习资源或对应实践说明中。


## Week 7- package，Javadoc，耦合&内聚，继承（父类&子类），Override，Object类，Abstract&Polymorphism
### 1.package
用法简单
![[Pasted image 20260616015727.png]]

左边为utils package，右边为调用package
也就是使用import packageName.MethodName
注意，只要权限允许，都可以访问。外部只能访问public权限
修饰符访问范围
	`public`     所有包、所有类** 都能访问（全局开放）
	`protected`     同一个包内任意类可访问，同时还有其他包中的该类子代

![[Pasted image 20260616164417.png]]

	`default(None) `         **不同包中，只有子类**可以访问默认（无修饰符）包访问权限**仅同一个包内**的类可访问，跨包完全无法使用
	`private`        仅当前类内部**可访问，外部任何类 / 包都看不到

### 2. Javadoc
/** XXXX*/
能通过html得到一些信息
目标还是为人类服务，不是注解。人类能看懂的内容。
几个常用的：
	|标签|作用|使用场景|
	|---|---|---|
	|`@author`|标注代码作者|类、枚举上方|
	|`@version`|标注版本号|类、枚举上方|
	|`@param 参数名 描述`|描述方法 / 构造器的参数|**有参方法、构造方法必须写**|
	|`@return 描述`|描述方法返回值|**有返回值的方法必须写**；`void` 方法不用|
	|`@throws 异常类名 描述`|描述方法主动抛出的异常|会抛出异常的方法|
	|`@see 类名/方法名`|引用、关联其他类 / 方法|跳转参考其他代码|
	|`@since`|标注该功能从哪个版本开始存在|可选，大型项目使用|


### 补充设计范式
abstraction
Encapsulation
Inheritance
Polymorphism
***学会拼写***
### 3. coupling & cohesion
coupling 耦合 外部， 尽量少 --> 错一个都错
cohesion 内聚 内部，尽量多 --> 功能性强，代码清晰
但注意cohesion也不是乱七八糟的都往里面放，至少要符合这个类整体的目标是干嘛的

### 4. Inheritance

![[Pasted image 20260616021217.png]]
#### 名称
父：super class/ parent/base case
子：sub case/derived/child

目的：creat new classes from parent

#### why？
1. code reuse --》define only
2. 区分子代差异，重写父类的部分方法
3. 加一些父类不用的额外数据
4. 同一种行为（目的），不同的执行方式

#### 使用super直接调用父类参数
	How do we access things inherited from parent?  
	• super() to call the constructors // add arguments if parameterised  
	• super.variableNames  
	• super.methodNames() // add arguments if parameterised  
	• this.variableNames // bad practice but not incorrect  
	• this.methodNames() // bad practice but not incorrect  
	• Call directly using variableName or methodNames // bad practice
***用this不会报错，但是不好***
#### Constructor
从父类到子类依次调用
虽然子类是为了独立功能记录和执行，但是父类需要作为基础，才能有子类。

![[Pasted image 20260616021624.png]]图中可以明显观察到递进关系

![[Pasted image 20260616021723.png]]
观察后可以明显发现，子类使用了super调用了父类的constructor
	`Employee`（顶层父类：通用员工）
	↓ 继承
	`CasualEmployee`（一级子类：临时工）
	↓ 继承
	`Tutor`（二级子类：讲师）
	这是一个**三层继承的员工模型**：父类存放所有员工的通用信息，每一层子类不断扩展自身独有属性；依靠 `super` 关键字逐层调用父类构造器，完成对象从顶层到底层的完整初始化，是课件中「继承 + 构造器」的标准示范代码。
我们可以理解为求同存异，通过父类求同，通过子类存异


#### Override 重写
![[Pasted image 20260616022547.png]]
左侧为父类，右侧为子类
显然可以发现displayDetails这个方法被重写了

##### 几种最常见的 “定义不同” 示例
以`displayDetails`方法举例：
1. **方法名不一样**
    父类：`displayDetails()`
    子类：`showDetails()`
    → 名称不同，定义不同。
2. **参数个数不一样**
    父类（无参）：`void displayDetails()`
    子类（带参）：`void displayDetails(String name)`
    → 参数数量不同，定义不同。
3. **参数类型不一样**
    父类：`void print(int code)`
    子类：`void print(String code)`
    → 参数类型不同，定义不同。
##### 访问权限！：
public > protected > 默认包访问权限(无修饰符) > private
子类 access不能小于 父类 access
同时，父类不能为private
否则
***编译报错！！！***

##### 重写类型
	返回类型为基础类型时，不能重写 ---> 基本数据类型（`int`/`float`/`boolean` 等）
	返回类型是类时，可以重写，But they must be a direct descendant of the type used in BaseClass. Also called covariant type.

![[Pasted image 20260616024456.png]]

#### 防止继承

使用final，不能修改！！！
无论是变量还是method甚至是类，都可以通过final，拒绝继承

### Object 类

JDK自带，属于顶层语言
***不是对象！！！***
#### instanceOf vs getClass()

instanceOf 判断属不属于某个Class
getClass 知道是哪个具体的class
![[Pasted image 20260616025924.png]]
显然可以看到，getClass() != otherObject.getClass()的部分，我可知，该method一定属于某一个具体的class之下。

### Polymorphism 多态性

多态的核心是：
> 同一个父类类型的变量，可以指向不同子类对象；调用同一个方法时，运行时根据真实对象决定执行哪个版本。
#### Overloading 重载 VS Overriding 重写

整理一下我们可以简单的发现，Overload本质是同一method下，不同的参数类型。
但是override是，同一method下，不同的表达形式，注意要在sub class中。
![[Pasted image 20260616155636.png]]

同时可以观察到，overloading是static polymorphism，override是dynamic polymorphism
##### Why would we need polymorphism?  
	• Overloading – Same/similar functionality different data types.
	• abs(float a)  
	• abs(int a)  
	• abs(double a)  
	• Overriding - Similar kind of object but different functionality. 
	• displayDetails() of Employee  
	• displayDetails() of CasualEmployee

#### Early binding VS Later binding
##### Early/Static/Compile-Time Binding – bind a method at compile time. --> static
##### Late/Dynamic/RunTime Binding – bind a method at runtime. --> dynamic

#### UpCasting VS DownCasting

Up：
Base case = sub case

Down：
sub case = Base case

注意点：
Remember downcasting double to int gives a compile time error – possible lossy conversion,  because there is a data loss.
其实就是常说的，大转小问题，double不能直接转int，会编译报错
反过来就没有关系，int可以转double
![[Pasted image 20260616160647.png|637]]

可以强制转，通过：
CasualEmployee casual = (CasualEmployee) emp;
但是有可能会有runtime error

### Abstract
可以简单理解为一个规则，规范了子代必须要写某些method以用来实现该功能，也避免调用的时候产生编译报错的现象。
当然子类也可以继续是抽象类，暂时不实现该方法，但仍然要让其继续抽象下去。
	`普通子类：
	`必须实现 abstract method，不管你用不用。

	抽象子类：
	可以暂时不实现，但不能 new。

最终要 new 的具体类：
必须把所有 abstract method 都实现完。
具体写法：
`abstract class Employee {
    `public abstract float calculateSalary();
`}
`abstract class CasualEmployee extends Employee {
    `float hourlyRate;
`}
注意事项：
子代写具体method以实现抽象类时
有且只能命名为：`calculateSalary()
只有这时才是真正的override
不能加一个形参进去，加了就是overload

报错信息：
只要写了abstract method，子代没实现，无论是否调用，都是直接报错

	父类：
	abstract method：
	calculateSalary()
	
	子类写：
	calculateSalary()
	→ override，正确实现抽象方法
	
	子类写：
	calculateSalary(int numHours)
	→ overload，不算实现抽象方法
	
	如果子类是普通 class，却只写了 overload：
	→ 编译报错
	
	如果子类也是 abstract：
	→ 可以暂时不实现，但不能 new
	
	如果子类既写 override 又写 overload：
	→ 完全可以

### 本章总结：
这章主要讲 Java OOP 的类组织和类关系设计。

前面先补充 package、import、classpath、Math class 和 Javadoc，
这些是为了让多个 class 能够被组织、调用和说明。
注意：import只是告诉他用哪个package，而非改变权限，只要是有一定限制的package，都存在不能使用的情况，当然具体情况具体分析。但是import是必须的！

然后进入 OOP 的核心思想：
class 把数据和行为封装在一起；
abstraction 隐藏复杂细节；在子代中实现
inheritance 让子类复用父类内容；复用！
polymorphism 让同一个方法调用在不同子类对象上表现出不同实现。

继承中要注意：
子类用 extends 继承父类；
constructor 不会被继承，但会从父类到子类依次调用；
子类可以 override 父类方法；
访问权限决定子类能继承和访问哪些成员；
Object 是所有 class 的顶层父类。

final：前面加上final之后，就会增加很多限制
class会不能继承
method会不能重写
variable会不能修改
当然不影响使用

多态中要注意：
overloading 是方法名相同、参数不同，属于 early binding；
overriding 是子类重写父类方法，属于 late binding；
upcasting 是子类转父类，安全自动；
downcasting 是父类转子类，需要强转，可能出错。

抽象类用于建立父类模板：
共同内容写在父类；
不同但必须存在的行为写成 abstract method；
具体子类必须实现这些方法，否则编译报错。

## Week 8 -- Modularity模块化，UML，Interface，Interface VS Abstract，接口特例

### Modilarity
##### 层级
System
 └── packages
      └── classes
           └── methods

#### 五个标准
Decomposability：复杂问题分步化
Composability：同一步骤重复化
Understandability：独立理解单个模块的用处
Continuity：最小改动
Protection：错误控制最小范围

#### 设计规则
	1. Direct Mapping：代码要贴近现实
	2. Few Interface：减少连接
	3. small interface：改用private的要用private
	4. Explicit Interfaces：依赖性要明显，不要对不上
	5. Information hiding

#### UML
识图！！！

##### Class
![[Pasted image 20260616174553.png]]

	1. 顶部是class Name
	2. 中间是 Attributes 属性
		1. Name
		2. Access modifiers
		3. Data type
	3. 底部是method
		1. method name
		2. arguments
		3. return type
几个符号要记一下：
+public | -private | # protected | ~ package/default
下划线表示静态成员

##### Package

![[Pasted image 20260616175000.png]]

##### Inheritance

![[Pasted image 20260616175027.png]]
看一下箭头方向，子代指向父代
线段种类可以看一下
实线  ——表示子代到父代
虚线  -----表示class到接口
#### Association
V型箭头或无箭头
`1      exactly one
`0..1   zero or one
`1..*   one or many
`0..*   zero or many
#### Aggregation（弱） & Composition（强）

Aggregation：
例子：
```
Department ◇---- Professor
```
意思是：
```
Department has Professor
```

Composition：
例子：
```
University ◆---- Department
```
意思是：
```
University is composed of Departments
```

### Interface
是一种数据类型，data type
也就是说，interface 只规定：
```
你必须有什么方法
方法名是什么
参数是什么
返回值是什么
```
例如：
```
public interface Printable {
    void print();
}
接口规范要有什么方法
class Printer implements Printable {
    public void print() {
        System.out.println("Printer is printing...");
    }
}

class Report implements Printable {
    public void print() {
        System.out.println("Report is printing...");
    }
}
```
interface包含两个内容：
method和constant
但是！只有constant不好！注意是常量不是变量，也就是说interface默认自带static和final
interface中的，默认公开，不允许使用protected和private

##### 接口实现-implements
如果类要实现接口，就必须要做完。
不能做一半留一半，做不完，就定为抽象类，剩下的让子代做
```
public interface Calculable {
    double PI = 3.14;
    double surfaceArea();
    double volume();
}

必须有以下的：
class Cuboid implements Calculable{
	public double surfaceArea() {...}
	public double volume() {...}
}

否则：
abstract class CircularBase implements Calculable {
    public double surfaceArea() {...}
    // volume() 没实现，所以这个类必须 abstract
}

public class Cylinder extends CircularBase{
	double volume() {...} // 子代补完内容
}
```

### Interface VS Abstract
#### Abstract class 适合什么时候？
适合这些类本来就在同一个继承体系里面，而且它们有部分共同实现。

比如：
```
Shape 
├── Circle 
├── Cylinder 
└── Cone 
```
它们都是 Shape，可以共享一些属性或方法。

例如：
```
abstract class Shape {
    protected String colour;
    public void setColour(String colour) {this.colour = colour;}
    public abstract double area();
    }
```

#### Interface 适合什么时候？
interface 适合表达一种“能力”。
这些类不一定属于同一个家族，但它们都具有某种能力。
比如：
```
Phone can be chargedCar can be chargedApple Watch can be charged
```
它们不是同一类东西，但都可以 `charge()`。
所以可以写：
```
interface Chargeable {
	void charge();}
```
然后：
```
class Phone implements Chargeableclass ElectricCar implements Chargeableclass AppleWatch implements Chargeable
```
所以你可以这样理解：
```
abstract class 更像是 “is-a”
interface 更像是 “can-do”
```

### Derived Interface：接口继承接口

interface 可以继承另一个 interface，而且可以继承多个 interface。
例如：
```
public interface Payable {
	void pay(double amount);}

public interface Refundable {
	void refund(double amount);}
	
public interface Transactional extends Payable, Refundable {
	void printReceipt();}
```
这表示：
```
Transactional 同时拥有 Payable 和 Refundable 的方法要求
```

### Comparable Interface
官方提供的一个顶层接口
compareTo
The return type is int:```
	1. 0 if two objects are equal
	2. A negative number if THIS object "comes before" the parameter other
	3. A positive number if THIS object "comes after" the parameter other
	4. If the other object does not belong to same class, throw a ClassCastException

comparable是接口，但是compareTo是属于它的method，既然implements就要在具体类中重写
```
public class SomeClass implements Comparable<SomeClass> {  
	@Override  
	public int compareTo(SomeClass other) {  
		// return negative / zero / positive}  
}
```

### 一些Interface的注意点
Java允许有多个接口
一个class中implements多个接口，method可以一样
但是
变量名一样 出错
method 返回类型不一样 出错


#### 坑 1：前后两个 interface 不是完全同一个意思

前面模块设计里面的 interface：

```
模块之间的通信口，广义概念
```

Java 里面的 `interface`：

```
Java 语言中的一种类型，用 interface 关键字声明
```

这两个有关联，但不是完全一样。

#### 坑 2：interface 不是 class
所以不能说：
```
interface 是一种特殊 class
```
更准确是：
```
interface 是一种 reference type，但不是 class。
```
它可以被 class 实现：
```
class A implements SomeInterface
```
但不是：
```
class A extends SomeInterface
```

#### 坑 3：interface 里的变量默认是常量
interface 里写：
```
double PI = 3.14;
```
其实是：
```
public static final double PI = 3.14;
```
所以不能改：
```
PI = 3.14159; // 不行
```
这和你刚才问的 `final` 正好接上了：  
**可以读，但不能改。**
#### 坑 4：实现 interface 方法时必须是 public

PDF 第 27 页的代码概念是对的，但如果严格按 Java 编译，有些方法少了 `public`，会出问题。
比如 interface 里：
```
double surfaceArea();
```
默认是：
```
public abstract double surfaceArea();
```
所以 class 里面实现时必须写：
```
public double surfaceArea() {    ...}
```
不能只写：
```
double surfaceArea() {    ...}
```
因为这是 package-private，比 public 权限更低。

#### 坑 5：abstract class 可以 implements interface 但不实现完
这个很重要。
```
abstract class CircularBase implements Calculable {    public double surfaceArea() {        ...    }}
```
如果它没有实现 `volume()`，那它必须是 `abstract`。
普通 class 不可以这样。

## Week - 9~11 

### 1. Exceptions & Exceptions Handling
##### 定义
exception 异常 --》会中断程序的正常运行
throwing an exception --》 catch the exception --》 OS return the control to program
一定是runtime error，绝不可能是compile error

##### Exception Stack
Message Stack
从最初调用的函数一步步往上，直到找到最具体出现问题的方法。
![[Pasted image 20260616212213.png]]


##### Try-Catch block

###### One Try-catch
```
try{
    ...} 
catch (Exception e){
    ...} 
finally{
    ...}
```
将可能出问题的地方放在try block中，出问题，权限归于catch block
出现问题我们由以下选择：
```
When an exception happens you can:
	• Either quit the program *gracefully* by printing an *error message*
	• Can prompt the user to take an appropriate action such as *reentering inputs*
	• Can lead to *an alternate flow* of a program by invoking different method calls or setting default values
```

e.g：
![[Pasted image 20260616212729.png]]
这个Exception ex可以处理所有的exception
###### Nested Try-catch block
![[Pasted image 20260616213018.png]]
本质为，分了不同的exception方式，也可同时处理多个exception

###### Pitfalls
每一步都说明，但是会先说一句：
出错了！
然后再说有哪些错误
![[Pasted image 20260616213530.png]]

##### 常见exception
###### RuntimeException – anything that happened during runtime. 
Subclasses：
	1. ArithmeticException – divide by zero
	2. *ClassCastException* – Remember inheritance upcasting/downcasting?
	3. *NullPointerException* – accessing variables or methods of variables that are null.
	4. *NoSuchElementException* – issues with your Scanner object taking inputs? Input is notfound?
	5. *IndexOutOfBounds (or ArrayIndexOutOfBoundsException)* - accessing index that does is greater than the size of the array.

###### IOException – exceptions accessing input/output like files. 
Subclasses：
	1.*FileNotFoundException* – file is not present in the filesystem or cannot be opened for read/write.
	2. *EOFException* – end of file is met while reading input

##### 自定义exception
定义一些错误，方便用户知道哪里有问题

例子：
```
public class MathException extends Exception {
    public MathException() {
    }
    public MathException(String message) {
        super(message);
    }
}
```
一定隶属于Exception这个super class中
之后就可以被
Exception ex或者MathException接住，然后弹出错误提示

###### `super(message)` 是干嘛的？
它的意思是：
把你传进来的错误信息交给父类 `Exception` 保存。
通过某段代码来解析一下吧
1.
```java
public class NotFoundException extends Exception {
	public NotFoundException(String message) {
		super(message);}
}
```

2.
```java
private void viewAllPayslips() {
	try {
		if (!this.payslipsGeneratedThisSession && !this.payslipFileExists) 
			{
			throw new 
			NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
			}
		ArrayList<Payslip> currentEmployeePayslips = 
		getPayslipsForCurrentEmployees();
		
		if (currentEmployeePayslips.isEmpty()) {
			throw new 
			NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
			}
		System.out.println();
		
		for (Payslip payslip : currentEmployeePayslips) {
			Messages.printPayslip(payslip);
			System.out.println(Messages.PAYSLIP_SEPARATOR);
			System.out.println();}
	} 
	catch (NotFoundException ex) {
		System.out.println(ex.getMessage());}
}
```

你现在看到的是：
`throw new NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
它等价于：
`throw new NotFoundException("Payslip has not been generated yet.");

可以理解为再Exception包中，我们存放了一些除了可以自定义用于exception函数，在实际执行时，先告诉这里打算如何弹出什么message
在运行时，如果抓住了报错信息，就给出相应的结果
catch具体里面有什么？不属于exception处理管辖

##### Throws VS Throw
`throw` 是**真正把一个异常丢出去**；`throws` 是**在方法头提前声明这个方法可能会丢异常**。

例如：
```
public void readFile() throws IOException{// 声明：我可能会出 
	IOException throw new IOException("File not found");
	// 实际：现在真的抛出异常
	}
注意这次里面没有catch
```
一句话记：
> **throw 是动作，throws 是声明。**

当你的方法抛出异常但未使用catch块处理时，该方法定义必须通过throws关键字声明可能抛出的异常类型。
***都不写会编译报错！***

##### Throwable
真正的父类，对于exception&error

一般不用，过大！

##### Finally Block
在`exception`后，会最后执行完`finally`中的内容
```
try{
	// 原代码
}
catch(Exception ex){
	//出错后，做一些为了这些错误的措施
}
finally{
	//善后
}
```

### 2. 文件处理

不放在文件就会放在内存里，程序一停，内存被释放，从头跑程序。。。

Two kinds of files
	• ****Text Files**** – files containing numbers, Strings and other readable data format.
	• ***Binary Files*** – audio/video files, images, etc.

You can read/write the files using System streams
	• Output stream – ***System.out***
	• Input stream – ***System.in***

##### 读取文件 --- Textfile
几种scanner语句：
```
Scanner scanner = new Scanner(System.in); // reading from System input
int a = scanner.nextInt();

Scanner scanner = new Scanner(new FileInputStream("C://input.txt"));
int a = scanner.nextInt(); //reads first integer
float b = scanner.nextFloat(); // reads the other float
scanner.nextLine(); // goes to the next line
//repeat reading other lines and inputs on other lines one by one.
```


###### Text File Reading：读文本文件

最基本结构是：
```
Scanner input = null;

try {
	input = new Scanner(new FileInputStream("C:\\input.txt"));
	while (input.hasNextLine()) {
		String line = input.nextLine();
		String[] parts = line.split(" "); // use parts
	}
}
catch (Exception ex) {
	// handle exception
	} 
finally {
	if (input != null) {
		input.close();
	}   
}
```

这里要看懂三层：
```
new FileInputStream("C:\\input.txt")
```

意思是：打开这个文件，准备从文件里读 bytes。
```
new Scanner(...)
```

意思是：用 Scanner 包住这个 input stream，让你可以更方便地读 `int`、`double`、`String`、一整行。
```
while (input.hasNextLine())
```

意思是：只要文件还有下一行，就继续读。
读文件不能无限 `nextLine()`，要用 `hasNextLine()` 判断是否到文件末尾；同时 Scanner 用完要 close。（用finally去close）

###### Text File Writing：写文本文件

最基本结构是：
```
PrintWriter printer = null;
try {
	printer = new PrintWriter(new FileOutputStream("C:\\output.txt"/*在这加
	[,true]决定是那种写入形式*/));
	printer.print("This is a text");
	printer.println("This is a line");
	printer.printf("Number: %d", 10);}
catch (Exception ex) {
// handle exception}
finally {
if (printer != null){
	printer.close();
}}
```

这里也有两层：
```
new FileOutputStream("C:\\output.txt")
```

意思是：打开这个文件，准备往里面写 bytes。
```
new PrintWriter(...)
```

意思是：用 PrintWriter 包住 output stream(System.in)，让你可以像 `System.out.print()` 一样写文本。

***注意：***文本文件写入常用的是 `print()`、`println()`、`printf()`。**  

如果你看到 `writeInt()`、`writeDouble()` 这种，更应该联想到 binary file 的 `ObjectOutputStream`，不是普通 `PrintWriter`。

Week 11 也明确说 binary file writing 用 `writeInt`、`writeDouble`、`writeUTF`、`writeObject`，而不是 `print/printf/println`。

###### OverWrite VS Append
写文件时有两种模式。

默认：overwrite 覆盖写入
```
new FileOutputStream("C:\\output.txt")
```
如果文件已经存在，原来的内容会被覆盖。

append：追加写入
```
new FileOutputStream("C:\\output.txt", true)
```
第二个参数：
`true
表示 append mode，也就是在原文件末尾继续加内容，不清空原文件。课件第 26 页也说明，`FileOutputStream(filename, true)` 里的 `true` 会让文件以 append mode 打开。

###### 文件关闭
.close -- 关闭文件 --- 不弄会资源泄露，写入的东西没保存
.flush -- 弹出buffer --- 很多时候自动执行，建议还是写一下

这就是用finally的时候

##### Buffering reader & writer

| 工具               | 用途            | 特点                        |
| ---------------- | ------------- | ------------------------- |
| `Scanner`        | 读文本，适合初学和解析输入 | 简单，但效率一般                  |
| `BufferedReader` | 读文本           | 使用 buffer，更高效             |
| `PrintWriter`    | 写文本           | 可以 `print/println/printf` |
| `BufferedWriter` | 写文本           | 使用 buffer，更高效             |

Week 11 recap 里说，`BufferedReader` 比 Scanner 更高效，因为用了 buffer；`BufferedWriter` 比 PrintWriter 更高效，也因为用了 buffer。

你现在主要记：

**Scanner / PrintWriter 更容易写；BufferedReader / BufferedWriter 更偏效率。**

![[Pasted image 20260616225534.png]]
![[Pasted image 20260616225547.png]]

##### Binary File
Binary file 不是给人直接读的。比如：
```
image
audio
video
compressed file
database file
docx
```
它们本质上也是 bytes/bits，但打开后不是普通文本。课件 Week 11 说，binary files 需要 special drivers 才能把内容转换成有意义的格式。
###### 写 binary file

```
ObjectOutputStream output = null;
try {
	output = new ObjectOutputStream(new FileOutputStream("C:\\output.dat"));
	output.writeInt(23);
	output.writeDouble(3.14);
	output.writeUTF("Hello");} 
catch (Exception ex) {
	// handle exception} 
finally {    
	if (output != null) {
		output.close();
	}}
```

重点是：

```
ObjectOutputStream
```

对应写 binary data。

常见方法：

```
writeInt()、writeDouble()、writeUTF()、writeObject()
```

Week 11 第 9 页明确说，写 binary file 用 `ObjectOutputStream`，不是 `PrintWriter`；用 `writeInt/writeDouble/writeUTF/writeObject`，不是 `print/printf/println`。

###### 读 binary file
```
ObjectInputStream input = null;
try {
	input = new ObjectInputStream(new FileInputStream("C:\\input.dat");
	int number = input.readInt();
	double value = input.readDouble();
	String text = input.readUTF();}
catch (Exception ex) {
	// handle exception}
finally {
	if (input != null) {
		input.close();
}}
```

重点是：
```
ObjectInputStream
```
对应读 binary data。

常见方法：
```
readInt()、readDouble()、readUTF()、readObject()
```

Week 11 第 10 页也对应说明，读 binary file 用 `ObjectInputStream`，不是 `Scanner`。

##### Summary
读文本：Scanner + FileInputStream
写文本：PrintWriter + 
读二进制：ObjectInputStream + FileInputStream
写二进制：ObjectOutputStream + FileOutputStream
覆盖写入：new FileOutputStream(filename)
追加写入：new FileOutputStream(filename, true)
读文件循环：while (scanner.hasNextLine())
资源关闭：finally 里面 close()


### 3. Generics 泛型

• 泛型允许编写灵活、可复用的代码，能够适用于任何数据类型。
• 它们在保持代码通用性的同时，支持类型安全的操作。
• 它们与接口和继承所提供的功能有所不同

**Generics Example**

**ArrayList**：
`ArrayList<String> list = new ArrayList<>();

高级用法：
```
class Student implements Comparable<Student> {
	int studentId;
	String name;

	@Override
	public int compareTo(Student other) {
		return Integer.compare(this.studentId, other.studentId ); }
}
		// sort by grade

class Book implements Comparable<Book> {
	int year;
	String name;

	@Override
	public int compareTo(Book other) {
		return Integer.compare(this.year, other.year); }
}
// sort by year

class Movie implements Comparable<Movie> {
	double rating;
	String name;

	@Override
	public int compareTo(Movie other) {
		return Double.compare(this.rating, other.rating); }
}
// sort by rating
```

**泛型在这里的好处:**

`关键是这三个：`
	`Comparable<Student>`
	`Comparable<Book>`
	`Comparable<Movie>`
`它们让 Java 知道：`
`Student 只能和 Student 比Book 只能和 Book 比Movie 只能和 Movie 比`

`这就是 **type safety**。`

`如果没有泛型，可能会出现很奇怪的比较，比如：`
`student.compareTo(book);`
`但有了：`
`Comparable<Student>`
`Java 编译器就会阻止你把 `Book` 传进去。`


Generics Naming Conventions

`• T: Type (general purpose)`
`• E: Element (used in collections like ArrayList<E>)`
`• K: Key (used in maps like HashMap<K, V>)`
`• V: Value`
`• N: Number`
`• S, U, V: Second, third, fourth types, etc.`


##### T的用法

`T is a type parameter; <T> indicates a generic method or class.
`Generics allow defining classes and methods that operate on any reference type.
`When a specific type is provided, it produces a concrete version of the class or method.
`Generics improve *code reusability* and type safety at compile time.

```
class ArraySorter<T extends Comparable<T>> {    
	public void sortArray(T[] array) {       
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
}}}}
```

A generic (parameterized) class includes the type parameter in angle brackets after the class name.
本质上就是个占位符，里面我想后补哪个class method都可以
当然有的一定要用reference type：
	int     -> Integer
	double  -> Double
	char    -> Character
	boolean -> Boolean
很重要，记！

当放进某个type之后，这个generic就变成其专属了，比如T = String，那这个泛型就不能再返回字符之类的了
T类型的XXX（变量，method, 返回值相同）

The type parameter can be used in:
	• Instance variables
	• Method parameters
	• Return types

##### Arraysort
代码块如下：
```
class ArraySorter<T extends Comparable<T>> {    
	public void sortArray(T[] array) {       
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
}}}}
```

通过该方法可以简化代码行数，让每一个 class 都使用这个，而非让每个 class 都自己写一串 sort，非常的费时间。

本质就是一个工具，当然算法结构可以优化，不是此处讨论重点

而且一定要记得写清楚 compareTo 的执行方式，不写清楚，不会比较

##### Bound
泛型有使用边界
T 本身是依附于实例存在的也可以说是具体的某个 Object
但是如果由 static，T 就不能直接调用该方法，因为 static 并非依附于某个具体实例 Object，而是 class 本身

![[Pasted image 20260617020252.png]]

#### Collection Framework

> Collection 是一个把多个元素组织成一个整体的对象。

简单说就是：
`一个 Collection = 一个装很多数据的容器

比如：
```
ArrayList<String> names = new ArrayList<>();
```

***Collection **不是 array。*****

数组是这样：
```
String[] names = new String[3];
```

Collection，比如 `ArrayList`，是这样：
```
ArrayList<String> names = new ArrayList<>();
```

Collections Framework 分成三部分：
```
	Interfaces
	Implementations
	Algorithms
```

1.Interfaces：接口，规定“这个容器应该有什么功能”
比如：
`List<E>Set<E>Map<K, V>
这些是接口，不是具体容器。

它们负责规定：
`List 应该有顺序，可以按 index 访问。Set 不应该有重复元素。Map 应该用 key 找 value。
接口像是“规则说明书”。

2.Implementations：实现类，真正能 new 出来的容器
```
ArrayList<String> list = new ArrayList<>();
HashSet<String> set = new HashSet<>();
HashMap<String, Integer> map = new HashMap<>();
```
这里的：
```
ArrayList
HashSet
HashMap
```
就是具体实现类。

可以这样：
```
List<String> list = new ArrayList<>();
```

```
变量类型用 List 接口实际对象用 ArrayList 实现类

接口 = 规定功能实现类 = 真正干活
```
3.Algorithms：算法，Java 提供好的操作方法
这里要区分：
```
Collection:集合接口，表示一组元素。

Collections:工具类，里面有很多操作集合的方法。
	Collections.sort(...)
	Collections.reverse(...)
	Collections.shuffle(...)
	
Collections Framework:整个集合框架体系。
```
##### 小区别
`List<E>:  
有顺序，可重复，用 index 找元素。  
例子：ArrayList  
  
`Set<E>: 
不重复，不强调 index。  
例子：HashSet  
  
`Map<K, V>: 
key-value，不是单纯装元素，而是用 key 找 value。  
例子：HashMap

##### 讲讲两个独特的接口

###### 迭代器，iterator

用 hasNext 去检测是否到头了
![[Pasted image 20260617021905.png]] 


###### 比较器，comparator
![[Pasted image 20260617022011.png]]
用 `Comparator`
例如：
```
class AgeComparator implements Comparator<Person> {    
	@Override    
	public int compare(Person p1, Person p2) {        
	return Integer.compare(p1.getAge(), p2.getAge());
}}
```

然后：
```
Collections.sort(people, new AgeComparator());
```

意思是：
```
用 AgeComparator 这个外部比较器来排序 people
```

#### ArrayList
几个操作步骤：
先调用：
`ArrayList<String> list = new ArrayList<>();`

核心：
```
add()
get()
set()
size()
remove()
isEmpty()
contains()
for-each loop
```

example：
```

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    
        // 创建一个只能存 String 的 ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 在 ArrayList 的最后添加元素
        list.add("Apple");
        list.add("Orange");
        // Current list: [Apple, Orange]
        
        // 在 index 1 的位置插入 "Banana"
        // 原来的 Orange 会往后移动
        list.add(1, "Banana");
        // Current list: [Apple, Banana, Orange]
        
        // 获取 index 0 位置的元素，也就是第一个元素
        String item = list.get(0);
        // item = "Apple"
        System.out.println("First item: " + item);

        // 把 index 2 位置的元素替换成 "Pear"
        list.set(2, "Pear");
        // Current list: [Apple, Banana, Pear]

        // 获取 ArrayList 当前有多少个元素
        int size = list.size();
        // size = 3
        System.out.println("Size: " + size);

        // 删除 index 0 位置的元素，也就是 "Apple"
        list.remove(0);
        // Current list: [Banana, Pear]

        // 删除内容为 "Banana" 的元素
        list.remove("Banana");
        // Current list: [Pear]

        // 判断 ArrayList 是否为空
        boolean empty = list.isEmpty();
        System.out.println("Is empty? " + empty);

        // 判断 ArrayList 里面是否包含 "Apple"
        boolean hasApple = list.contains("Apple");
        System.out.println("Contains Apple? " + hasApple);
        
        // 遍历 ArrayList，把里面的元素一个个打印出来
        for (String s : list) {
            System.out.println(s);
        }
    }
}
```