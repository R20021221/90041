# COMP90041 Master Review Tree - Week 1-5

> 结构：每章先放知识树小纲，再放 `复习总结 Summary`，最后放 `Bilingual Notes`。
> 标记：`[X考试]` 表示 Week 12 Revision 明确列为 non-examinable，不会加入考试；内容仍保留，方便完整理解课程脉络。

## 0. 文件来源与使用方式 Sources & Usage

### 来源文件 Source files

- `Week_1_Introduction_to_Programming.pdf`
- `Week_2_Control Flows.pdf`
- `Week_3_Classes and Methods - I.pdf`
- `Week_4_Classes and Methods - II.pdf`
- `Week_5_Arrays.pdf`
- `COMP90041_Java_复习总结_Week1-5.md`
- `COMP90041_Bilingual_Notes.md`
- `Week12_Revision.pdf` 用于 `[X考试]` 标记

### 阅读方式 How to read

- 先看每章的 `知识树小纲 Knowledge Tree`，确认这一章有哪些知识点。
- 再看 `复习总结 Summary`，抓定义、常考点、代码模板。
- 最后看 `Bilingual Notes`，补足英文定义、中文解释和短代码例子。
- Week 5 的数组内容已经标为 `[X考试]`，因为 Week 12 Revision 将 Arrays 列为 non-examinable。

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
- 13. 高频易混对比 High-Confusion Comparisons
- 14. 考点速查清单 Review Checklist
- 15. 最后复习建议 Final Review Advice
- 16. PDF 覆盖终审 PDF Coverage Audit

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
- 补充（中）：在很多地方，代码块可以替代单条语句；同时，代码块也会创建局部变量的作用域。

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
- 定义（中）：控制流是指决定语句执行顺序的分支和循环机制。
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

##### 默认初始化值（无显式初始化时）

| 类型 | 默认值 |
|------|--------|
| `boolean` | `false` |
| 数值类型 (`int`, `double`…) | `0` |
| 类类型 / 数组类型 | `null` |

#### ★ `toString()` 方法

**定义**：提供对象的文本表示形式。**打印对象或字符串拼接时自动调用**。

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
- 定义（中）：对象是类的一个实例，而实例化就是创建这个对象的过程。
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

#### `this` Keyword / `this` 关键字
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

**Parameter（形参）**：写在方法定义里的变量。
**Argument（实参）**：调用方法时传入的实际值。

```java
public double myMethod(int param1, double param2) { ... }  // param1, param2 是形参
double result = myMethod(1, 3.0);                          // 1, 3.0 是实参
```

#### ★ Java 参数传递机制：Pass-by-Value（值传递）

> ★★★ **Java 只有值传递（Pass-by-Value）！**

| 参数类型 | 传递的内容 | 方法内修改是否影响原变量 |
|----------|-----------|--------------------------|
| 基本类型 | 值的**副本** | ❌ 不影响 |
| 引用类型（对象） | **引用的副本**（地址） | ✅ 可以通过引用修改对象内容 |
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
- Definition (EN): Java is pass-by-value: method parameters receive copies of the passed values.
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
- `main` 方法是静态的，所以在 `main` 中不能直接调用非静态方法，需先创建对象
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

**Enum / 枚举**：定义一组**固定的、带名字的常量值**的特殊类。
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

#### ★ 隐私泄漏（Privacy Leak）与深拷贝

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

## 13. 高频易混对比 High-Confusion Comparisons

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

## 14. 考点速查清单 Review Checklist

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

## 15. 最后复习建议 Final Review Advice

### 7. Final Review Advice / 最后复习建议

- Read the note by concept, not by week, and focus first on the comparison section if you are still mixing similar terms.
- 复习时优先按概念而不是按周次阅读；如果你还容易混淆相近术语，先看“高频易混对比”那一节。

- When memorizing a term, always ask three things: what it is, what it returns or stores, and how it behaves in code.
- 记一个术语时，建议总问自己三件事：它是什么、它返回或存储什么、它在代码里怎么表现。

- If a definition still feels abstract, rewrite the short example by hand and change one value to see what stays the same and what changes.
- 如果某个定义还是偏抽象，就把后面的短例子手写一遍，再改一个值，观察“什么不变、什么会变”。

## 16. PDF 覆盖终审 PDF Coverage Audit

终审方法：对照 Week 1-5 PDF 的 slide title/目录顺序，检查本文件是否覆盖对应知识点。行政、版权、Acknowledgement、break、see you next time 等非知识性页面在“课程信息/学习资源”层面合并处理。

| PDF | 覆盖结论 | 已覆盖主题 |
|---|---|---|
| Week 1 - Introduction to Programming | OK | 课程信息、考核规则、Java 工具链、程序结构、数据类型、变量、I/O、运算符、类型转换、String |
| Week 2 - Control Flows | OK | 表达式/语句/代码块、条件分支、switch、循环、break/continue、labelled break、exit、debugging |
| Week 3 - Classes and Methods I | OK | OOP 动机、类与对象、引用类型、字段、方法、参数、this、equals、toString、构造器 |
| Week 4 - Classes and Methods II | OK | getter/setter、访问控制、重载、static、final、内存、引用、pass-by-value、String 特例、null、匿名对象 |
| Week 5 - Arrays | OK | enum、wrapper class、boxing/unboxing、数组声明/创建/访问/初始化/遍历、数组引用、privacy leak、char[] vs String；数组已标 `[X考试]` |

### 终审备注 Audit Notes

- Week 1-5 的复习总结内容已按原章节全部纳入：Summary chapters 1-14。
- Week 1-5 的 bilingual concept notes 已全部纳入：所有二级知识块和三级概念小节均已归位。
- Week 12 Revision 中明确排除的 Week 5 数组内容已标 `[X考试]`，但没有删除。
- PDF 中重复出现的 copyright、acknowledgement、additional reading、live coding、break 等页面已合并到来源/学习资源或对应实践说明中。
