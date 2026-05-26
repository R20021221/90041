# Workflow 2 - AI-Facing Compact English Brief

Source: `requirement.docx` + current A1 scaffold in `src/`. Concrete goals must match `WORKFLOW_FOR_ME_CN_EN.md`; this version is compact, not reduced in scope.

## 0. Constraints

- Academic-use constraint: assist with planning/review/debug/small examples; do not output a full submit-ready solution or large final-code chunks. Student must understand and own submitted code.
- If AI used, add an `AI Usage Declaration` comment block at end of `WarehouseManagerEngine.java`.
- Keep `WarehouseManagerEngine.java` in default package.
- Create at least 3 packages for other classes.
- Must compile on EdStem; no compile = 0.
- Do not use `java.nio.Files` (-2 marks).
- Do not use `System.exit()` (-0.5/control-flow issue); exit via loops/returns.
- Do not use `WarehouseGenerator.java`; maps are file-loaded.
- Do not use complex collections (`TreeMap`, `TreeSet`, `Vector`). Use simple Collections such as `ArrayList`, `HashMap`.
- Generics implementation optional/no credit. Using generic library classes such as `ArrayList<>` is fine.
- UML must be manual, not IntelliJ/auto-generated. Submit PDF or high-res PNG.
- Javadoc major classes/methods/enums; generated Javadoc should have no errors. Default constructor and enum-value warnings are excluded.

## 1. Target System

Upgrade A1 Warehouse Manager to A2:

- 3D warehouse: `floors x rows x cols`, floor numbers 1..3 max.
- Each floor is a 2D map with its own forklift; forklifts move independently.
- Load warehouse cells/items from warehouse CSV.
- Load employees/base salaries/reporting lines from employees CSV.
- Load/read/write payslips at fixed path `data/payslips.csv`.
- Login by employee ID; role-specific menus.
- `OPERATOR`, `SENIOR_OPERATOR`, `SUPERVISOR`: start/resume shift, navigate floors, pick/deliver, view own summary/payslip.
- `SUPERVISOR`: additionally view direct reportees' summaries only.
- `PAYROLL_MANAGER`: view all summaries, generate payslips, view loaded/generated payslips; no forklift menu.
- Track per-employee `ShiftSummary`: delivered item count, wall hits, restricted-area hits. A2 has no operation history requirement.
- Output must match examples exactly enough for automated tests.

## 2. OOP/Architecture

- Suggested packages: `warehouse`, `employee`, `payroll`, `io`, `exceptions`; at least 3 required.
- Enums: `CellType {WALL,AISLE,RESTRICTED,SHELF,START}`, `ShelfType {ELECTRONICS,CLOTHING,GROCERY,FURNITURE}`, `Designation {OPERATOR,SENIOR_OPERATOR,SUPERVISOR,PAYROLL_MANAGER}`.
- Need one inheritance hierarchy, e.g. abstract `Employee` -> `Operator`, `SeniorOperator`, `Supervisor`, `PayrollManager`.
- Need one interface, e.g. `ShiftCapable`, `PayslipViewable`, `SummaryViewable`.
- Encapsulate fields; avoid privacy leaks, redundant object passing, overuse of static methods.
- Use constants/messages to centralize exact output.

## 3. Command Args

Program accepts exactly 5 args:

`java WarehouseManagerEngine <floors> <rows> <cols> <master file> <employees file>`

Example: `java WarehouseManagerEngine 2 5 5 data/master_warehouse.csv data/employees.csv`

Validation:

- `<5 args`: print `Invalid number of Command Line Arguments. Usage: java WarehouseManagerEngine <floors> <rows> <cols> <master file> <employees file>`; terminate gracefully.
- non-integer floors/rows/cols: print `Error: Floors, rows and columns must be integers.`; terminate gracefully.
- floors `<1` or `>3`: print `Error: Number of floors has to be between 1 and 3.`; terminate gracefully.
- rows/cols `<4`: print `Error: Rows and columns must be at least 4 to allow proper map layout.`; terminate gracefully.
- map or employees file not found/readable: print `Unable to process file. Exiting program.`; terminate gracefully.
- If valid: initialize every floor with boundary `WALL`, interior `AISLE`, `(1,1)` `START`; then file-load.

## 4. Common File Rules

- `data` folder exists next to code/packages in EdStem.
- Warehouse/employees file names come from args; do not hardcode them.
- Payslip path is always `data/payslips.csv`; not passed as arg.
- All CSV files have header row; skip line 1.
- Empty lines: skip.
- Split by comma; string fields contain no commas.
- Invalid data lines: throw/handle appropriate exception, print exact message with 1-based line number, skip line, continue.
- Header is line 1; first data line is line 2.
- Use `Scanner`/`PrintWriter`; call `flush()` when writing.
- Use Linux-style paths.

## 5. Warehouse CSV

Fields: `floor,row,col,cell_type,shelf_type,item_name` (6 fields).

- `floor`: file uses 1-based floor number; convert to internal 0-based index.
- `row`,`col`: 0-based 2D array indexes.
- `cell_type`: only `RESTRICTED` or `SHELF`.
- `shelf_type`: for shelves only one of `ELECTRONICS`, `CLOTHING`, `GROCERY`, `FURNITURE`; for restricted may be blank or `-`.
- `item_name`: may be blank; no item-type validation.

Per-line validation/messages:

- wrong field count: `Invalid Warehouse line at line xx. Skipping this line.`
- invalid floor (<=0 or out of arg bounds): `Invalid floor number in warehouse file: xx. Skipping this line.`
- row/col out of bounds or boundary: `Invalid location in warehouse file at line xx. Skipping this line.`
- invalid cell type: `Invalid cell type at line xx. Skipping this line.`
- existing non-`AISLE` cell conflicts with incoming type: `Restricted location overlaps shelf at line xx. Skipping this line.`
- restricted line has nonblank/non-`-` shelf type: `Shelf Type cannot be defined for Restricted Location at line xx. Skipping this line.`
- shelf line has invalid shelf type: `Invalid shelf type at line xx. Skipping this line.`
- same shelf location already has different shelf type: `Shelf Type mismatched at line xx. Skipping this line.`
- If valid: set cell type/shelf type; add item to shelf if shelf item present; if restricted item present, ignore item validation and continue.
- Do not validate item type vs shelf type; out of scope.

## 6. Employees CSV

Fields: `employee_id,employee_name,designation,base_salary,manager`.

- At least 4 mandatory fields; manager may be empty/missing.
- Valid designations: `OPERATOR`, `SENIOR_OPERATOR`, `SUPERVISOR`, `PAYROLL_MANAGER`.

Validation/messages:

- fewer than 4 fields: `Incorrect Employees line at line xx. Skipping this line.`
- empty ID/name or `base_salary <= 0`: `Incorrect Employee Details at line xx. Skipping the line.`
- invalid designation: `Incorrect Employee Designation at line xx. Skipping this line.`
- Maintain manager-reportee data. No need to validate manager ID existence. No need to detect loops. Supervisors see direct reportees only.

## 7. Payslips CSV

Path: `data/payslips.csv`.

Fields: `employee_id,employee_name,base_pay,delivered_item_pay,hits_penalty,restricted_area_penalty,reportees_managing_pay,net_salary` (8 fields).

Read rules:

- File missing: no error; continue to menu.
- Header-only file: continue to menu.
- Data rows: read/validate each.
- Field data types can be assumed valid.

Validation/messages:

- wrong field count: `Incorrect Payslips line at line xx. Skipping this line.`
- empty employee ID/name: `Incorrect Employee Details at line xx. Skipping this line.`
- invalid salary if `base_pay <= 0` or any of `hits_penalty`, `restricted_area_penalty`, `reportee_management_pay`, `delivered_item_pay` `<0` or `net_salary <=0`: print `Incorrect Employee Salary details at line xx. Skipping this line.`

Write rules:

- If payroll manager generated payslips this session: discard loaded payslip data; write generated data only.
- Write records in employees-file order.
- Replace whole file, preserve header.
- Write only once at termination.
- If no new generation and existing payslip data was loaded: keep existing file data untouched.
- If file missing: create before termination when needed; if no generation, header-only creation may be required by spec.
- Final `X` termination examples show `Saving Payslips file: data/payslips.csv` then `Goodbye!`.

## 8. Warehouse Display/Movement

- Do not display Warehouse ID.
- Legend: `Legend: # Wall | . Aisle | X Restricted | S Shelf | O Start | F Forklift`
- Floor header: `==========Floor: n==========`
- Forklift line: `Forklift at: (row,col)`
- Symbols: wall `#`, aisle `.`, restricted `X`, shelf `S`, start `O`, forklift `F`.
- Floor-selection view: show legend + all floors + each floor's forklift position; prompt `Enter a floor number to navigate the warehouse or X to return to the main menu :`
- Invalid floor number (integer but out of range): `Invalid Input`; redisplay all floors and prompt again.
- Valid floor: show selected floor + movement menu.
- Movement/shelf menu behavior is same as A1/current scaffold unless overridden here.
- Movement menu:
  ```
  Enter direction:
  U - Up.
  D - Down.
  L - Left.
  R - Right.
  T - Deliver carried item at START (O).
  Q - Quit to main menu.
  >
  ```
- On movement `Q`: print `Shift paused.`, show all-floor map again, ask floor or `X`; `X` returns to role menu.
- Completion condition: all shelves on all floors visited and empty, all items delivered, forklift carrying nothing.
- Completion message: `All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.`
- If current floor becomes empty after delivery, examples show: `This floor has all shelves empty. Return to floor menu.`
- Start cell displays `F` when forklift is there and `O` when forklift leaves.
- Successful delivery at `START (O)` increments current employee delivered count.
- Attempt into wall/boundary increments current employee wall-hit count.
- Attempt into restricted increments current employee restricted-hit count.
- Current employee receives only their own future summary increments; shared warehouse state may be resumed by another employee.

## 9. Salary/Payslips

Formula for everyone except payroll manager:

`netSalary = baseSalary + deliveredCount*deliveryPay - wallHits*hitsPenalty - restrictedHits*restrictedAreaPenalty`

Supervisor additionally:

`+ directReporteeCount*reporteeManagementPay`

Payroll manager:

`netSalary = baseSalary`; variable pays/penalties `0.00`.

Salary table is missing from DOCX extraction (`PreviewHTMLCSSJavaScript`). Infer from examples unless original table recovered:

- `deliveryPay = 10.00`
- `hitsPenalty = 0.25`
- `restrictedAreaPenalty = 0.50`
- `reporteeManagementPay = 5.00`

Payslip format, 2 decimal money:

```text
EmployeeID: <id>
Employee Name: <name>
Base salary: <base.2f>
Delivered Item Pay: <deliveredPay.2f>
Hits Penalty: <hitsPenaltyTotal.2f>
Restricted Penalty: <restrictedPenaltyTotal.2f>
Reportees Management Pay: <reporteePay.2f>
Net Salary: <net.2f>
```

Between multiple payslips, examples show `=======================`.

## 10. Startup/Login

After valid args/file processing, print:

```text
Processing Warehouse file: <warehouse arg path>
Processing Employees file: <employees arg path>
Processing Payslips file: data/payslips.csv
Welcome to Warehouse Manager Assignment 2.
```

Login loop:

```text
=== Employee Login ===
Enter your Employee ID or X to terminate:
```

- Bad employee ID: `Employee ID not found. Please try again.` then login prompt.
- `X`: terminate gracefully, save/write payslips if required, print `Goodbye!`.
- Valid ID: `Welcome, <name> [<DESIGNATION>]` then role menu.

## 11. Menus

Use exact formatting expected by tests. Requirement examples vary slightly for supervisor option 5; prefer explicit `View all reportees' shift summary`.

Operator/Senior:

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

Payroll manager:

```text
=== Payroll Manager Menu — <Name> [PAYROLL_MANAGER] ===
1. View all employees' shift summary
2. Generate payslips
3. View all generated payslips
4. Logout
>
```

Invalid listed-menu integer: `Invalid input.` then redisplay menu. Main menu only needs invalid integers; string/double main-menu input out of scope.

Logout: Operator/Senior option 5, Supervisor option 6, Payroll option 4. Logout returns to login. Program ends only at login `X`.

## 12. Operator/Senior/Supervisor Options

Option 1 Start shift:

- If warehouse already complete: print completion message, redisplay menu.
- If paused/incomplete shift exists: behave as resume.
- Otherwise show all-floor map and floor prompt.
- Valid floor enters movement menu.

Option 2 Resume:

- No previous shift: `Shift not started, cannot resume shift.`
- Paused/incomplete shift: show updated all-floor map and continue saved state.
- Completed shift: completion message.
- Different employee can resume shared warehouse state; future actions count to that employee.

Option 3 View my shift summary:

```text
No. of Items delivered: n
No. of Walls hit: n
No. of Restricted Areas hit: n
```

If no movement, print zeroes.

Option 4 View my payslip:

- File missing and no session-generated payslips: `Payslip not generated yet.`
- File exists but employee record missing and no session-generated payslip: `Employee <EmployeeID>'s payslip not found.`
- No old record but generated this session: show generated payslip.
- Old record exists and no new generation: show loaded old payslip.
- Old record exists and new generation: show newly generated payslip.

Supervisor option 5:

- Print only direct reportees:
  ```text
  Employee Id: <id>, Employee Name: <name>, Designation: <designation>
  No. of Items delivered: n
  No. of Walls hit: n
  No. of Restricted Areas hit: n
  ```
- Prevent privacy leaks across supervisors.

## 13. Payroll Manager Options

Option 1 View all employees' summaries:

- Print every employee in employees-file order:
  ```text
  Employee Id: <id>, Employee Name: <name>, Designation: <designation>
  No. of Items delivered: n
  No. of Walls hit: n
  No. of Restricted Areas hit: n
  ```

Option 2 Generate payslips:

- Generate for all employees, including no-movement employees and payroll manager.
- Use current session summaries only.
- Discard old loaded payslip data.
- Keep employees-file order.
- Print `Payslips generated successfully.`

Option 3 View all generated payslips:

- Loaded file data exists and no current generation: display loaded data.
- Current generation exists: display generated data.
- File missing and no current generation: `Payslip not generated yet.` then payroll menu.

Option 4 Logout: return to login.

## 14. Exceptions

Create/use custom exceptions as appropriate:

- `InvalidLineException`
- `InvalidWarehouseException`
- `InvalidLocationException`
- `InvalidTypeException`
- `NotFoundException`

Throw where detected; catch in caller controlling file/menu flow. Line-level file exceptions print exact message and continue. Fatal warehouse/employees open/read exceptions print `Unable to process file. Exiting program.` and terminate gracefully.

## 15. Verification Checklist

- Compile on EdStem.
- Validate all command-arg errors.
- Validate warehouse reader: field count, floor, location, cell type, overlap, restricted shelf type, shelf type mismatch, item load.
- Validate employees reader: field count, ID/name/salary, designation, manager-reportee direct links.
- Validate payslips reader: missing/header-only/data, field count, empty ID/name, invalid salary fields.
- Validate startup messages/login/invalid ID.
- Validate role menus and invalid integer command.
- Validate start/resume/pause/floor selection/shared shift state/all-floors completion.
- Validate per-employee summary counts.
- Validate supervisor direct-reportee privacy.
- Validate payroll manager summary/generate/view scenarios.
- Validate employee payslip old/new/missing scenarios.
- Validate file write once at termination, header, employees order, flush.
- Validate exact money formatting with 2 decimals.
- Validate no `java.nio.Files`, no `System.exit`, no `WarehouseGenerator` usage.
- Validate packages, inheritance, interface, enums, Javadoc, manual UML.
