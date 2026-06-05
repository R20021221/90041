Part1:
Submission and Marking Rubrics
Submissions
Do not remove the  Java source code files provided to you from your submission. You must keep WarehouseManagerEngine.java, WarehouseGenerator.java, and add additional Java files as required.

Starter code has been provided to you here, on the EdStem platform, but you are welcome to develop the project using your own IDEs.

Submission is made via EdStem in the Code Challenge linked in the slides. Your submission will be the latest version of your code saved at the project deadline.

Your code MUST compile and run here on edstem. If your code does not compile, we cannot mark it, and you risk getting 0 marks.

Be sure to copy your code into your Code Challenge workspace before the deadline to avoid being locked out of submissions at the last minute. Do not forget to hit the Mark Button. Hitting the mark button creates a submission. You can submit as many times as you want. Only the version of your code submitted before the submission deadline will be graded, unless a valid extension is granted. 

Hitting the mark button creates a submission. 

It is highly recommended that you update your code on Edstem frequently and well before the submission deadline. Last-minute "connection errors" are not a valid excuse.

If you need an extension for valid reasons, up to 3 days, please fill out the form mentioned [here]. We will follow up with you. Ensure you have a valid reason and proper documentation with you before seeking the extension. If you seek an extension beyond 3 days, check the Special Consideration Module on Canvas and submit your request through this portal. 

Program Presentation
Including layout and style, readability, adherence to coding expectations and conventions, general care and appearance. 

The full mark for this section of marking is 4.

Marks awarded

Gain 0.5 marks each for the rubrics listed below.

All choices of variable (except array indices) and method names were meaningful;

All variable, method, and class names follow Java convention (camelCase and PascalCase);

Constant names follow Java convention (UPPER_SNAKE_CASE);

Comments were sufficient and meaningful; All public methods are commented. Some private methods or complex code blocks have appropriate comments.

Consistent bracket placement and indentation; Code should be readable.

Authorship statement (name, university email, student number) provided;

All magic numbers (essentially numbers other than 0 or 1) were assigned to constants; Repeated Strings are created as constants. Constants were defined as final static.

Code File Organisation - Clearly structured code with the correct order of variables, constructors, getters/setters, and methods.

Deductions

stylistic issue, if major -1.0 mark per issue; if minor, -0.5 mark per issue

Structure and Approach
Including decomposition into methods, declaration of instance variables at the appropriate locations, and choice of parameters to methods. 

The full mark for this section of marking is 8.

Marks awarded

[0.5 mark] Correct entities created as classes. There should be more classes added apart from the one provided to you.

[0.5 mark] No more than 3 nested blocks (nesting multiple if, for, switch, etc., should be kept to a level of 3 )

[0.5 mark] Code was not duplicated (tasks to be done in more than one place are in the method);

[0.5 mark] Use of Arrays, creating 1D arrays wherever appropriate.

[0.5 mark] No more than 3 static methods (including main) were used (Excluding methods in the Messages class) -- most methods should be bound to objects;

[0.5 mark] No more than 4 static variables were used -- most variables should be non-static ("final static" constants are not variables);

[1 mark] Good use of methods; No methods were too long or too complex; Code with more than 100 lines is considered a long method.

[1 mark] appropriate use of encapsulation; limiting the scope of variables to private or protected except where a reasonable justification is given. 

[1 mark] Array resizing demonstrated.

[1 mark] Enums identified and enums created

[1 mark] No privacy leaks are present with nested objects and arrays returned using getters.

Deductions

structural issue, if major -2.0 marks per issue, otherwise -1.0 mark per issue.

If you use ArrayList or any other classes from Collections, or Arrays copy methods, a penalty of 3 marks will be applied.

Program Execution
Including compilation, execution of test data, output presentation and readability.

Programs that do not compile in the test environment will lose all marks in this section. Be sure to verify your submission and check the output before you say "finished" to yourself. 

The full mark for this section of marking is 8.

Marks awarded

Gain 0.5 marks per test case passed;

Gain 0.25 marks for tests with slightly different output (e.g., small changes in whitespace; if the marker says the difference is not slight, that is final.  This should not occur if the available test cases are all checked.);

Gain 0 for other failed tests

Visible tests passed:  / 10

Hidden tests passed:  / 6

Total tests passed:  / 8

Total Marks for the Assignment:  20

Part2:
Guidance: Object Oriented Programming
1. Quick Tips
Now that you know about UML, perhaps start designing your solutions by creating a UML diagram first. Think about what classes need to be created. Some of them are provided to you as a scaffold. You can create other classes as well. 

The second step is to associate appropriate data with appropriate classes. Create the data fields as instance variables in those classes.

The third step would be to create the exceptions.

The next step is file handling. This will take the maximum amount of time.

The next step is to create a structure for running the menu options with the different Control Flows you have learned.

Exceptions thrown by a method should generally be handled in the method that invokes it, rather than inside the same method. The calling method should use a try-catch block to handle exceptions appropriately.  For example, when you use Integer.parseInt() and it throws a NumberFormatException, this exception is typically handled in the method where Integer.parseInt() is called.

Create packages to logically group entities, interfaces, and exceptions.

Think about enums.

Move on from arrays to ArrayList. What other data structures can you use from Collections classes for managing complex data and easier searching? You will learn about this in the coming weeks. 

2. Interfaces & Inheritance
Implement the inheritance between related entities. You must have at least one inheritance hierarchy. 

Think about what the common operations are for different entities. Interfaces are implemented where unrelated/related entities exhibit similar behaviour but have different implementations. You must create and implement at least one interface.  

3. File Parsing 
Use a simple Scanner and PrintWriter instead of over-complicating the reading/writing. Try to minimise duplicate code associated with reading and writing.

Do not forget to use flush() for writing.

When you read the files, you can read the entire line and then split the data on commas. This shall provide you with different data points in an array. Check the split method in the String class here. You can use this method to perform a split on a comma. You can use other methods from the String classes as well.

4. JavaDoc
Your code should be annotated using javadoc comments. We will generate the Javadoc for your code. You do not need to submit it. You can run javadoc on your machine (up to any levels of nested packages) by running the command

$ javadoc -d docs/ *.java
$ javadoc -d docs/ **/*.java
$ javadoc -d docs/ **/**/*.java
.
.

5. UML
The UML Diagram is discussed in Week 8's Lecture. The UML Diagram presented in the code challenge is just a starter design that can serve as a scaffold to guide you on the mandatory classes/methods for the assignment.

There are classes/code files in the scaffold, but they are not grouped into packages. There are some sample packages in the scaffold UML Design that you can use.  You must create these packages based on the UML and add the classes/code files to the packages.

Some classes in the UML scaffold include fields and methods. The three dots indicate that additional instance variables and methods that can be added as needed.

You need to update the UML and submit it as a PDF/PNG in your assignment. Use high-resolution images if submitted in PNG.