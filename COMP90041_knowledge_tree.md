# COMP90041 知识树 Knowledge Tree

来源：Week 1 到 Week 11 的 11 个 PDF。  
标记：`[X考试]` 表示 Week 12 Revision 明确列为 non-examinable 的内容，也就是不会加入考试。  
说明：本文件保留完整知识框架，只做标记，不删除不考内容。

## 0. 课程信息 Course Admin

- 课程概况 Subject overview [W1]
  - About this subject, lecturers, teaching staff, subject logistics
  - Tentative subject schedule, tutorial rescheduling

- 考核规则 Assessment rules [W1]
  - Assessments, hurdle requirements
  - Extensions & special consideration: assignments and exams
  - Ungraded quiz, academic misconduct, academic integrity

- 学习资源 Learning resources [W1-W11]
  - Quick recap, quick practice, live coding
  - Additional reading resources
  - Acknowledgement of Country, copyright notice

## 1. Java 基础 Java Basics

- 程序运行 Program execution [W1]
  - Compilers & interpreters
  - Hello World, general code structure
  - `main` method, command line input

- 基本类型与变量 Data types & variables [W1]
  - Primitive data types, variables
  - Number types, booleans, characters
  - String type and string operations

- 输入输出 Basic I/O [W1]
  - Standard output
  - Formatted output
  - Standard input

- 表达式与运算 Expressions & operations [W1-W2]
  - Integer vs float division
  - Comparison operations, boolean operations
  - Increment/decrement
  - Type conversions, char conversions
  - Precedence and associativity
  - Expressions, statements, blocks

- String 特性 String details [W1, W4-W5]
  - Strings are immutable
  - String as reference/object
  - String as a special case of pass-by-value
  - `char[]` is not a String [X考试]

## 2. 控制流 Control Flow

- 条件分支 Branching [W2, W5]
  - `if-else`
  - Conditional operator
  - `switch`
  - Enums in `switch`

- 循环 Loops [W2, W5]
  - `while`
  - `do while`
  - `for`
  - Nested loops
  - `for-each` loop [X考试]

- 循环控制 Loop control [W2]
  - `break`
  - `continue`
  - Labelled `break`
  - `exit`

- 调试 Debugging [W2]
  - Debugging process
  - Practice and live coding: sum of numbers

## 3. 类、对象与方法 Classes, Objects & Methods

- OOP 入门 OOP motivation [W3]
  - Why object-oriented programming
  - Organising code with classes

- 类与对象 Classes & objects [W3]
  - Class definition
  - Object creation with `new`
  - Class-object relationship
  - Primitive vs reference/object types

- 变量与方法 Fields & methods [W3-W4]
  - Instance variables
  - Method definitions and invocation
  - Method types
  - Parameters and arguments

- 对象常用方法 Object methods [W3, W7]
  - `this`
  - `equals()`
  - `toString()`
  - Printing objects
  - `instanceof` vs `getClass()`

- 构造器 Constructors [W3, W7]
  - Constructor basics
  - Constructor types
  - Constructors in inheritance

## 4. 封装、静态成员与内存 Encapsulation, Static Members & Memory

- 封装 Encapsulation [W4, W7]
  - Access modifiers
  - Getters and setters
  - Accessors and mutators
  - Protected and default access

- 静态成员 Static members [W4]
  - Static methods
  - Static variables
  - Static variable initialization
  - Constants
  - `main` in any class

- 方法重载 Method overloading [W4, W7]
  - Overloading
  - Overloading vs overriding

- 引用与内存 References & memory [W4-W5]
  - Variables and memory
  - Reference variables
  - Java is pass-by-value
  - Object reference passing
  - `=` vs `==`
  - `null`
  - Anonymous objects
  - Array references and array equality [X考试]

- 隐私泄漏 Privacy leaks [W5]
  - Returning arrays from methods [X考试]
  - Array member variables and safe getters [X考试]

## 5. 枚举、包装类与数组 Enums, Wrappers & Arrays

- 枚举 Enums [W5]
  - Enumerated types
  - Declaring and using enums
  - Enums vs strings
  - Enums vs constants
  - Built-in enum methods

- 包装类 Wrapper classes [W5]
  - Wrapper classes
  - Boxing and unboxing
  - Automatic boxing/unboxing
  - Static methods in wrapper classes

- 数组基础 Arrays [W5] [X考试]
  - What is an array
  - Declaring, creating, accessing arrays
  - Array size
  - Square brackets `[ ]`
  - Array initialization
  - Arrays are objects
  - `char[]` vs String
  - `for-each` loop

- 数组进阶 Arrays II [W6] [X考试]
  - Unknown array size
  - Partially filled arrays
  - Efficient resizing strategy
  - Multidimensional arrays
  - Two-dimensional arrays
  - Arrays of arrays
  - Ragged arrays
  - Multidimensional arrays as parameters

- 变长参数 Variable number of parameters [W6] [X考试]
  - Methods with variable number of parameters

- 数组排序 Sorting arrays [W6] [X考试]
  - Sorting an array

- 随机数 Random generator [W6]
  - Random generator
  - Important random methods

## 6. OOP 进阶 Advanced OOP

- 包与工具类 Packages & utility classes [W7]
  - Packages
  - Creating and using packages
  - Math class

- 注释与文档 Comments & documentation [W7]
  - Java commenting styles
  - Javadoc comments

- OOP 四大支柱 OOP pillars [W7]
  - Encapsulation
  - Abstraction
  - Inheritance
  - Polymorphism

- 设计质量 Design quality [W7-W8]
  - Coupling and cohesion
  - Cohesion examples
  - Coupling examples
  - Modularity
  - Modular design criteria
  - Decomposability vs composability

- 继承 Inheritance [W7]
  - Base classes and subclasses
  - `super`
  - Constructors in inheritance
  - Access modifiers for inheritance
  - Preventing inheritance
  - Is-a vs has-a relationships

- 覆盖、多态与绑定 Overriding, polymorphism & binding [W7]
  - Method overriding
  - Polymorphism
  - Early binding vs late binding
  - Upcasting vs downcasting

- Object 类 Object class [W7]
  - Object class
  - Implementing `equals`
  - Pitfalls

- 抽象类 Abstract classes [W7-W8]
  - Abstract classes
  - Abstract classes vs interfaces [X考试]

## 7. UML、模块化与接口 UML, Modularity & Interfaces

- UML 类图 UML diagrams [W8]
  - UML entities
  - Classes, packages, inheritance
  - Association, aggregation
  - Interface associations [X考试]

- 接口 Interfaces [W8, W10] [X考试]
  - Interface basics
  - Implementing interfaces
  - Derived interfaces
  - Multiple interfaces
  - Interfaces in collections

- 接口比较 Interface comparison [W8, W10] [X考试]
  - Abstract classes vs interfaces
  - Comparable interface
  - Comparator interface
  - Comparator vs Comparable

- 接口冲突 Interface pitfalls [W8] [X考试]
  - Diamond problem
  - Inconsistent interfaces

## 8. 异常处理 Exception Handling [X考试]

- 异常基础 Exception basics [W9] [X考试]
  - What are exceptions
  - Exception stack
  - Java exception classes
  - Exception vs Error

- 捕获与处理 Try-catch-finally [W9] [X考试]
  - `try-catch`
  - Nested catch blocks
  - Pitfalls in nested catch
  - `finally`

- 自定义与抛出 Throwing exceptions [W9] [X考试]
  - Custom exception classes
  - `throw` vs `throws`

- Throwable 高级主题 Throwable [W9] [X考试]
  - Throwable
  - Errors

## 9. 文件处理 File Handling [X考试]

- 文本文件 I/O Text file I/O [W9] [X考试]
  - File streams
  - Reading files with `Scanner`
  - Writing files with `PrintWriter`
  - Writing vs appending
  - File paths
  - File class

- 磁盘与缓冲读写 Disk & buffered I/O [W9] [X考试]
  - Disk reading/writing
  - Buffered reading/writing
  - Buffered reading
  - Buffered writing

- 其他 Reader/Writer Other Java readers/writers [W9, W11] [X考试]
  - Other Java readers
  - Other Java writers
  - Other methods for reading/writing

- 二进制文件 Binary files [W11] [X考试]
  - Binary files
  - Binary files in Java
  - Writing binary files
  - Reading binary files

- 随机访问文件 Random access file [W11] [X考试]
  - Random Access File

## 10. 泛型与集合 Generics & Collections

- 泛型基础 Generics [W10] [X考试]
  - What are generics
  - Generic examples
  - Generic types
  - Naming conventions

- 泛型边界 Generic bounds [W10] [X考试]
  - Multiple generic types
  - Bounds for type
  - Generic bounds on methods

- 泛型高级主题 Advanced generics [W10] [X考试]
  - Generic inheritance
  - Interfaces with generics
  - Pitfalls with generics

- 集合框架 Collections framework [W10]
  - Collections
  - Benefits of collections
  - Collection interfaces
  - Collection classes

- 常用集合接口/类 Common collection tools [W10]
  - Iterator
  - ArrayList
  - ArrayList operations
  - Comparator and Comparable [X考试]

## 11. 高级主题 Advanced Topics [X考试]

- Try-with-resources [W11] [X考试]
- 递归 Recursion [W11] [X考试]
- Lambda 表达式 Lambda statements [W11] [X考试]
- GUI 图形界面 [W11] [X考试]
- 多线程 Multi-threading [W11] [X考试]

## 12. 不考范围 Non-examinable Summary

以下内容来自 Week 12 Revision 的 Non-Examinable Topics：

- Arrays [X考试]
- Variable number of parameters [X考试]
- Sorting an Array [X考试]
- Interfaces [X考试]
- Inconsistent Interfaces [X考试]
- Exception Handling [X考试]
- Errors [X考试]
- Throwable [X考试]
- Generics [X考试]
- Interfaces with Generics [X考试]
- Pitfalls with Generics [X考试]
- File Handling [X考试]
- Disk Reading/Writing [X考试]
- Other Java Readers/Writers [X考试]
- Random Access File [X考试]
- Advanced Topics [X考试]
- Try-with-resources [X考试]
- GUI [X考试]
- Lambda [X考试]
- Recursion [X考试]
- Multi-threading [X考试]
