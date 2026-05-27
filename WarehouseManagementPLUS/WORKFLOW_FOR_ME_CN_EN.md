# Workflow 1 - Human-Facing / 给我看的开发工作流

Source of truth: `requirement.docx` in this folder, plus the current Assignment 1 scaffold in `src/`.

Alignment rule: this workflow and `WORKFLOW_FOR_AI_EN_COMPACT.md` describe the same concrete goals. The human version explains them more clearly in Chinese with English keywords; the AI version is compressed English.

## 0. Boundary / 边界

1. Academic honesty / 学术诚信
   - 你可以用 AI 帮你理解概念、规划结构、解释错误、做小例子、做 checklist。
   - 不要让 AI 生成完整作业或大段最终代码，也不要提交自己不能解释的代码。
   - 如果使用 AI，在 `WarehouseManagerEngine.java` 结尾加入 `AI Usage Declaration` 注释块，说明 AI 只用于理解、规划或调试等合规用途。

2. Hard bans / 禁止项
   - 不要使用 `java.nio.Files`，会有 2 分 penalty。
   - 不要使用 `System.exit()`，必须 graceful exit。
   - 不要继续使用 `WarehouseGenerator.java` 随机生成地图；Assignment 2 地图必须从文件读取。
   - 不要用复杂集合，如 `TreeMap`, `TreeSet`, `Vector`。可以用 `ArrayList`, `HashMap` 等简单 Collections。
   - 不要用 IntelliJ 或自动工具生成 UML 图，否则 UML 0 分。

3. Submission / 提交物
   - Java code on EdStem.
   - `WarehouseManagerEngine.java` 不能放进任何 package。
   - UML Diagram: PDF 或高分辨率 PNG。
   - Javadoc 不需要提交，但代码要能生成 Javadoc 且主要类/方法有 Javadoc。

## 1. Overall Target / 总目标

把当前 Assignment 1 风格的 Warehouse Manager 扩展成 Assignment 2:

- 3D warehouse map: `floors x rows x columns`, 最多 3 层。
- 每层是一个 2D floor map，有自己的 forklift state，forklift 可独立移动。
- 地图从 warehouse CSV 读取，不再随机生成。
- 员工从 employees CSV 读取，有 4 种 role/designation。
- Payroll/payslip 从 `data/payslips.csv` 读取和写回。
- 操作人员登录后根据角色显示不同菜单。
- 操作人员/高级操作员/主管可以 start/resume warehouse shift。
- Payroll Manager 不能操作 forklift，只能看 summary、生成和查看 payslips。
- 每个员工维护自己的 shift summary，用于 salary/payslip calculation。
- 所有 console output 必须尽量完全匹配 requirement 示例；自动测试会因为空格、冒号、大小写差异扣分。

## 2. Project Structure / 项目结构

建议先重构成 OOP 结构，而不是只在一个 engine 里堆逻辑。

必须满足评分点 (at least 3 packages):

- 至少 3 个 packages，例如:
  - `warehouse`: map, floor, cell, shelf, item, forklift.
  - `employee`: employee hierarchy, designation, shift summary.
  - `payroll`: payslip, salary calculator, payroll service.
  - `io`: file readers/writers, CSV parsing.
  - `IOExceptions`: custom IOExceptions.
- `WarehouseManagerEngine.java` 留在默认 package，因为要求不能移动。
- 至少一个 inheritance hierarchy，例如:
  - abstract `Employee`
  - `Operator`, `SeniorOperator`, `Supervisor`, `PayrollManager`
- 至少一个 interface，例如:
  - `ShiftCapable` for roles that can start/resume shift.
  - `PayslipViewable` or `SummaryViewable` if useful.
- 使用 enums:
  - `CellType`: `WALL`, `AISLE`, `RESTRICTED`, `SHELF`, `START`
  - `ShelfType`: `ELECTRONICS`, `CLOTHING`, `GROCERY`, `FURNITURE`
  - `Designation`: `OPERATOR`, `SENIOR_OPERATOR`, `SUPERVISOR`, `PAYROLL_MANAGER`

当前源码里 `OperationHistory` 是 Assignment 1 需求，Assignment 2 明确说 operation history 不需要；新的重点是 `ShiftSummary`。

## 3. Command-Line Arguments / 命令行参数

程序必须接受 5 个参数，顺序固定:

```text
java WarehouseManagerEngine <floors> <rows> <cols> <master file> <employees file>
```

Example:

```text
java WarehouseManagerEngine 2 5 5 data/master_warehouse.csv data/employees.csv
```

Validation order / 校验:

1. 少于 5 个参数:
   - Print exactly:
     `Invalid number of Command Line Arguments. Usage: java WarehouseManagerEngine <floors> <rows> <cols> <master file> <employees file>`
   - then terminate gracefully.
2. `floors`, `rows`, `cols` 不是整数:
   - `Error: Floors, rows and columns must be integers.`
   - then terminate gracefully.
3. `floors < 1` or `floors > 3`:
   - `Error: Number of floors has to be between 1 and 3.`
   - then terminate gracefully.
4. `rows < 4` or `cols < 4`:
   - `Error: Rows and columns must be at least 4 to allow proper map layout.`
   - then terminate gracefully.
5. warehouse file or employees file not found:
   - `Unable to process file. Exiting program.`
   - then terminate gracefully.

如果参数有效:

- 初始化 `floors x rows x cols` map。
- 每层 boundary 是 `WALL`, 内部默认 `AISLE`, `(1,1)` 是 `START`。
- 然后读取 warehouse file, employees file, payslips file。

## 4. File Handling / 文件处理

### 4.1 Common CSV rules / 通用规则

- `data` folder 总是在 EdStem workspace 中。
- warehouse/employees 文件名不能 hardcode，要用 command-line args。
- payslips 文件 path hardcode 为 `data/payslips.csv`。
- 所有 CSV 第一行是 header，读取时跳过。
- Empty line 直接跳过。
- 用 `Scanner` / `PrintWriter` 即可，不要过度复杂化。
- 读取每行时用 `split(",")`。
- 文件里的字符串字段不会包含 comma。
- 遇到 invalid data line: 打印指定错误，跳过该行，继续读下一行，不要终止。
- Line number 从 1 开始，header 是 line 1，第一条数据是 line 2。
- 写文件时必须 `flush()`。
- EdStem 使用 Linux-style paths。

### 4.2 Warehouse map file / 仓库地图文件

Fields:

```text
floor,row,col,cell_type,shelf_type,item_name
```

Valid values:

- `cell_type`: only `RESTRICTED` or `SHELF`
- `shelf_type`: `ELECTRONICS`, `CLOTHING`, `GROCERY`, `FURNITURE`; for `RESTRICTED`, shelf type may be blank or `-`
- `item_name`: can be blank; no item-type validation is required

Index rule:

- `row` and `col` are 0-based array indexes.
- `floor` is numbered from 1, so convert it to 0-based internally.

Warehouse validation per data line:

1. Wrong number of fields:
   - `Invalid Warehouse line at line xx. Skipping this line.`
2. Invalid floor number: floor <= 0 or out of command-line floor bounds:
   - `Invalid floor number in warehouse file: xx. Skipping this line.`
3. Invalid row/col: out of bounds or boundary cell:
   - `Invalid location in warehouse file at line xx. Skipping this line.`
4. Invalid cell type:
   - `Invalid cell type at line xx. Skipping this line.`
5. Location already not `AISLE` and conflicts with incoming cell type:
   - `Restricted location overlaps shelf at line xx. Skipping this line.`
6. `RESTRICTED` line has nonblank/non-`-` shelf type:
   - `Shelf Type cannot be defined for Restricted Location at line xx. Skipping this line.`
7. `SHELF` line has invalid shelf type:
   - `Invalid shelf type at line xx. Skipping this line.`
8. Same shelf location already has a different shelf type:
   - `Shelf Type mismatched at line xx. Skipping this line.`
9. If valid:
   - mark cell as restricted or shelf.
   - if shelf and item exists, add item to shelf.
   - if restricted and item exists, ignore item validation and continue.

Do not validate item-vs-shelf-type matching. Requirement says this is out of scope.

### 4.3 Employees file / 员工文件

Fields:

```text
employee_id,employee_name,designation,base_salary,manager
```

Important:

- At least 4 fields are mandatory; `manager` may be empty or absent.
- Valid designations:
  - `OPERATOR`
  - `SENIOR_OPERATOR`
  - `SUPERVISOR`
  - `PAYROLL_MANAGER`

Employee validation per data line:

1. Fewer than 4 fields:
   - `Incorrect Employees line at line xx. Skipping this line.`
2. Empty employee ID, empty name, or `base_salary <= 0`:
   - `Incorrect Employee Details at line xx. Skipping the line.`
3. Invalid designation:
   - `Incorrect Employee Designation at line xx. Skipping this line.`
4. Build manager-reportee relationships after or during reading.
5. You do not need to validate whether manager ID exists.
6. You do not need to detect manager-reportee loops.
7. Supervisors can see only direct reportees.

### 4.4 Payslips file / 工资单文件

Path:

```text
data/payslips.csv
```

Fields:

```text
employee_id,employee_name,base_pay,delivered_item_pay,hits_penalty,restricted_area_penalty,reportees_managing_pay,net_salary
```

Rules:

- If file does not exist: do not terminate; continue to main menu.
- If file exists but only has header: continue to main menu.
- If file has data rows, read each line.
- Data types in payslip file can be assumed to match field types.

Payslip validation per data line:

1. Wrong number of fields:
   - `Incorrect Payslips line at line xx. Skipping this line.`
2. Empty employee ID or name:
   - `Incorrect Employee Details at line xx. Skipping this line.`
3. Invalid salary details:
   - if `base_pay <= 0`
   - or `hits_penalty < 0`
   - or `restricted_area_penalty < 0`
   - or `reportee_management_pay < 0`
   - or `delivered_item_pay < 0`
   - or `net_salary <= 0`
   - print `Incorrect Employee Salary details at line xx. Skipping this line.`

Write-back:

- If Payroll Manager generated payslips in the current session, discard old loaded payslip data and write current generated payslips.
- Write employee records in the same order as employees were read.
- Replace whole file, keep header.
- Write only once at program termination.
- If no new payslips were generated and existing payslip data was loaded, leave existing data untouched.
- If `data/payslips.csv` did not exist, create it before termination when needed; if no payslips were generated, header-only creation may be needed to satisfy the file-exists requirement.
- On final `X` termination, examples show:
  - `Saving Payslips file: data/payslips.csv`
  - `Goodbye!`

## 5. Domain Model / 领域模型

### 5.1 Warehouse / 仓库

- Warehouse has 1 to 3 floors.
- Each floor has its own 2D grid and its own forklift.
- Display all floors in the floor-selection view.
- Display selected floor before movement menu.
- Do not display Warehouse ID anymore.
- Legend:
  - `Legend: # Wall | . Aisle | X Restricted | S Shelf | O Start | F Forklift`
- Floor header:
  - `==========Floor: n==========`
- Forklift location:
  - `Forklift at: (row,col)`
- Print symbols:
  - `#` wall
  - `.` aisle
  - `X` restricted
  - `S` shelf
  - `O` start
  - `F` forklift

### 5.2 Shelves and items / 货架与物品

- Shelf has a type: `ELECTRONICS`, `CLOTHING`, `GROCERY`, `FURNITURE`.
- Item has a name.
- Do not validate item type against shelf type.
- Shelf menu and movement menu are the same as Assignment 1/current scaffold unless Assignment 2 says otherwise.

### 5.3 Employees / 员工

Common employee fields:

- ID
- name
- designation
- base salary
- shift summary
- optional supervisor/manager
- ability to view own payslip, subject to payslip availability

Roles:

- `OPERATOR`
  - start/resume shift
  - move across floors and within a floor
  - pick and deliver items
  - view own shift summary
  - view own payslip
- `SENIOR_OPERATOR`
  - same permissions as operator
  - different pay grade comes only from base salary in file
- `SUPERVISOR`
  - all operator permissions
  - has direct reportees
  - can view all direct reportees' shift summaries
- `PAYROLL_MANAGER`
  - view all employees' shift summaries
  - generate payslips
  - view all generated or loaded payslips
  - salary is base salary only

### 5.4 Shift summary / 班次统计

For every employee:

- `No. of Items delivered`
- `No. of Walls hit`
- `No. of Restricted Areas hit`

Only these summary counters are needed; Assignment 1 operation history is not required.

Update rules:

- Increment delivered count when that employee successfully delivers an item at `START (O)`.
- Increment wall hits when that employee attempts to move into boundary/wall.
- Increment restricted hits when that employee attempts to enter restricted area.
- If no movement was made, all values print as `0`.

Format:

```text
No. of Items delivered: n
No. of Walls hit: n
No. of Restricted Areas hit: n
```

## 6. Salary and Payslip / 工资计算

Formula for everyone except Payroll Manager:

```text
netSalary = baseSalary
          + numberOfItemsDelivered * deliveryPay
          - numberOfBoundaryWallHits * hitsPenalty
          - numberOfRestrictedAreaAccess * restrictedAreaPenalty
```

Supervisor additionally:

```text
netSalary += numberOfReportees * reporteeManagementPay
```

Payroll Manager:

```text
netSalary = baseSalary
```

The salary constants table is not extractable from the DOCX; the file only contains `PreviewHTMLCSSJavaScript`. From the examples, use these inferred constants unless the original table is recovered:

- `deliveryPay = 10.00`
- `hitsPenalty = 0.25` per wall hit
- `restrictedAreaPenalty = 0.50` per restricted-area hit
- `reporteeManagementPay = 5.00` per direct reportee

Payslip output format:

```text
EmployeeID: E001
Employee Name: Alice Smith
Base salary: 1000.00
Delivered Item Pay: 10.00
Hits Penalty: 0.50
Restricted Penalty: 0.50
Reportees Management Pay: 0.00
Net Salary: 1009.00
```

Money should print with exactly 2 decimals.

## 7. Program Startup and Login / 启动与登录

After valid args and file processing, print:

```text
Processing Warehouse file: <warehouse file path from args>
Processing Employees file: <employees file path from args>
Processing Payslips file: data/payslips.csv
Welcome to Warehouse Manager Assignment 2.
```

Login prompt:

```text
=== Employee Login ===
Enter your Employee ID or X to terminate:
```

If ID does not exist:

```text
Employee ID not found. Please try again.
```

Then show login prompt again.

If `X`, terminate gracefully, save payslips if required, then:

```text
Goodbye!
```

If valid ID:

```text
Welcome, <Employee Name> [<DESIGNATION>]
```

Then show role-specific menu.

## 8. Role Menus / 角色菜单

Use exact labels expected by tests. The requirement examples vary slightly for supervisor option 5; prefer the explicit option name `View all reportees' shift summary`.

Operator/Senior Operator:

```text
=== Operator Menu — <Name> [<DESIGNATION>] ===
1. Start warehouse shift
2. Resume last shift
3. View my shift summary
4. View my payslip
5. Logout
>
```

Supervisor:

```text
=== Supervisor Menu — <Name> [SUPERVISOR] ===
1. Start warehouse shift
2. Resume last shift
3. View my shift summary
4. View my payslip
5. View all reportees' shift summary
6. Logout
>
```

Payroll Manager:

```text
=== Payroll Manager Menu — <Name> [PAYROLL_MANAGER] ===
1. View all employees' shift summary
2. Generate payslips
3. View all generated payslips
4. Logout
>
```

Invalid menu integer:

```text
Invalid input.
```

Then redisplay the same menu.

The main menu only needs invalid integers handled; string/double menu input is out of scope for main menu.

## 9. Operator / Senior Operator / Supervisor Workflow

### Option 1: Start warehouse shift

When selected:

1. If all shelves across all floors are already empty and forklift is not carrying anything:
   - `All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.`
   - redisplay role menu.
2. If a previous shift is paused and incomplete:
   - Option 1 behaves like resume shift.
3. Otherwise:
   - show legend.
   - show all floors with each floor's forklift position.
   - prompt:
     `Enter a floor number to navigate the warehouse or X to return to the main menu :`

Floor input:

- If invalid floor number:
  - `Invalid Input`
  - show all floors and prompt again.
- If `X`:
  - return to role menu.
- If valid floor:
  - display selected floor and movement menu.

Movement menu:

```text
Enter direction:
U - Up.
D - Down.
L - Left.
R - Right.
T - Deliver carried item at START (O).
Q - Quit to main menu.
>
```

When user enters `Q` inside movement menu:

- print `Shift paused.`
- show all-floor map again.
- ask floor number or `X`.
- `X` returns to role menu.

Shift completes automatically when:

- all shelves on all floors are visited and empty,
- all items have been picked and delivered,
- forklift is not carrying any item.

On completion:

```text
All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.
```

If current floor becomes empty after a delivery, examples also show:

```text
This floor has all shelves empty. Return to floor menu.
```

### Option 2: Resume last shift

Scenarios:

1. No shift has ever started:
   - `Shift not started, cannot resume shift.`
   - redisplay menu.
2. Shift paused and items remain:
   - show updated all-floor map.
   - continue from saved state.
3. Shift already completed:
   - `All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.`
4. Different employee resumes:
   - warehouse shift state is shared.
   - if items remain, continue from saved state.
   - that new employee's future actions update their own shift summary.

### Option 3: View my shift summary

Print the current employee's own summary only:

```text
No. of Items delivered: n
No. of Walls hit: n
No. of Restricted Areas hit: n
```

### Option 4: View my payslip

Decision table:

- Payslip file missing and no current-session payslips generated:
  - `Payslip not generated yet.`
- Payslip file exists but employee has no record and no current-session payslip generated:
  - `Employee <EmployeeID>'s payslip not found.`
- No old record but current-session payslip generated:
  - show generated payslip.
- Old record exists and no current-session payslips generated:
  - show loaded old payslip.
- Old record exists and current-session payslips generated:
  - show newly generated current-session payslip.

### Supervisor Option 5: View all reportees' shift summary

Only supervisor has this option.

Print direct reportees only, using:

```text
Employee Id: <id>, Employee Name: <name>, Designation: <designation>
No. of Items delivered: n
No. of Walls hit: n
No. of Restricted Areas hit: n
```

Do not leak other supervisors' reportees.

### Logout

- Operator/Senior Operator: option 5.
- Supervisor: option 6.
- Logout returns to employee login.
- Program only terminates when login prompt receives `X`.

## 10. Payroll Manager Workflow

### Option 1: View all employees' shift summary

Print every employee in employees-file order:

```text
Employee Id: <id>, Employee Name: <name>, Designation: <designation>
No. of Items delivered: n
No. of Walls hit: n
No. of Restricted Areas hit: n
```

### Option 2: Generate payslips

When selected:

- generate payslips for all employees.
- use current session shift summaries only.
- discard old data read from payslips file.
- generate even if employee made no movement.
- include Payroll Manager's own payslip.
- keep generated records in employee-file order.
- print:
  `Payslips generated successfully.`

### Option 3: View all generated payslips

Scenarios:

1. Payslip file has data and no current-session generation:
   - display loaded file data.
2. Current-session generation has happened:
   - display generated payslips.
3. Payslip file missing and no current-session generation:
   - `Payslip not generated yet.`
   - redisplay payroll menu.

Between multiple payslips, examples show:

```text
=======================
```

### Option 4: Logout

Return to employee login.

## 11. Exceptions / 异常设计

Create custom IOExceptions where appropriate:

- `InvalidLineException`
- `InvalidWarehouseException`
- `InvalidLocationException`
- `InvalidTypeException`
- `NotFoundException`

Guideline:

- The method that detects/throws an exception should not always catch it in the same place.
- Prefer catching in the caller that controls file-reading flow or menu flow.
- File-line IOExceptions are caught, message printed, line skipped.
- Fatal file open errors for warehouse/employees print `Unable to process file. Exiting program.` and terminate gracefully.

## 12. Testing Workflow / 测试工作流

1. Compile first.
   - If it does not compile on EdStem, assignment gets 0.
2. Test command-line validation:
   - missing args
   - non-integer floors/rows/cols
   - floor out of range
   - rows/cols < 4
   - missing warehouse/employees files
3. Test file parsing:
   - warehouse wrong field count, bad floor, bad location, bad cell type, bad shelf type, overlap, restricted shelf type.
   - employees wrong field count, empty ID/name, salary <= 0, invalid designation, manager mapping.
   - payslips missing file, header-only file, wrong field count, bad employee details, invalid salary fields.
4. Test menus:
   - invalid employee ID.
   - each role gets correct menu.
   - invalid menu integer prints exact message.
   - logout returns to login.
   - `X` terminates.
5. Test shift:
   - start, invalid floor, valid floor, move, hit wall, hit restricted, pick, deliver, pause, resume.
   - resume by another employee.
   - all floors complete condition.
6. Test summaries and payroll:
   - employee own summary.
   - supervisor direct reportees only.
   - payroll manager all summaries.
   - generate payslips from current session.
   - employee view payslip in all old/new/missing scenarios.
   - write `data/payslips.csv` once at termination.
7. Test style deliverables:
   - Javadoc command works for package depth used.
   - UML manually updated and exported.
   - no `java.nio.Files`.
   - no `System.exit`.
   - `WarehouseManagerEngine.java` remains default package.

## 13. Marking Checklist / 评分点对照

- Program execution / automated tests: exact output, 10 marks.
- Architecture: real-world entities, packages, enums, hierarchy, 1 mark.
- OOP & encapsulation: private fields, getters/setters, no privacy leaks, low coupling/high cohesion, 2 marks.
- Polymorphism: inheritance, overloading, interface, overriding, 4 marks.
- Control flow: traceable loops, clear break conditions, switch/if-else, no more than 3 nested loops, no `System.exit`, 1 mark.
- File handling: read/write correctly, IOExceptions handled, no duplicated IO, no `java.nio.Files`, 2 marks.
- Style: naming, indentation, spacing, readable files, 1 mark.
- Documentation/Javadoc: major classes/methods, enums documented, no Javadoc errors, 2 marks.
- UML: major classes/methods, associations, multiplicities, packages, Java library Exception association, manual diagram, 3 marks.
- Exception handling: all custom and system IOExceptions handled, 2 marks.
- Collections: correct simple collections, no complex structures, 2 marks.

## 14. Recommended Build Order / 推荐实现顺序

1. Freeze output strings in `Messages` so formatting is controlled in one place.
2. Add enums and domain classes.
3. Replace 2D `WarehouseMap` with 3D warehouse/floor design.
4. Implement command-line validation.
5. Implement warehouse CSV reader.
6. Implement employees CSV reader and manager-reportee linking.
7. Implement payslip CSV reader/writer.
8. Implement employee login loop and role menus.
9. Implement floor selection and shift resume/pause state.
10. Connect movement/shelf actions to per-employee shift summary.
11. Implement salary calculation and payslip generation.
12. Implement all payslip view scenarios.
13. Add custom IOExceptions and refine catch locations.
14. Clean packages, comments, Javadoc.
15. Build UML manually.
16. Run exact-output tests and EdStem verification.
