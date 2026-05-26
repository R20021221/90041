# WarehouseManagementPLUS Progress

Purpose: track implementation progress against `WORKFLOW_FOR_ME_CN_EN.md` and `WORKFLOW_FOR_AI_EN_COMPACT.md`.

Rule: only mark an item complete after the code is implemented and verified. Reading/planning items may be checked now; implementation items remain unchecked until finished.

## Source Review

- [x] Read `requirement.docx` and extract Assignment 2 requirements.
- [x] Create human-facing workflow: `WORKFLOW_FOR_ME_CN_EN.md`.
- [x] Create AI-facing compact workflow: `WORKFLOW_FOR_AI_EN_COMPACT.md`.
- [x] Read all current base Java files in `src/`.
- [x] Confirm current base is Assignment 1 style: 3 command-line args, random 2D map, single menu, operation history.
- [x] Confirm no Java source has been modified yet.
- [x] Create immutable rule file: `RULER.md`.

## Current Base Map

### Keep or Adapt

- [ ] `CellType.java`: keep existing enum values; later move/package if needed.
- [ ] `Item.java`: keep simple item-name model; later move/package if needed.
- [ ] `Shelf.java`: adapt to support `ShelfType` and file-loaded items.
- [ ] `WarehouseCell.java`: adapt to support typed shelves and safer shelf access.
- [ ] `Forklift.java`: adapt to per-floor forklift state and per-employee summary updates.
- [ ] `Messages.java`: rewrite/extend exact Assignment 2 output strings.
- [ ] `Constants.java`: rewrite/extend Assignment 2 constants and salary rates.
- [ ] `WarehouseMap.java`: replace current 2D/random-map responsibility with multi-floor file-loaded design.
- [ ] `WarehouseManagerEngine.java`: keep in default package; rewrite orchestration for A2 args, file loading, login, role menus.

### Deprecate or Remove from A2 Flow

- [ ] `WarehouseGenerator.java`: stop using it because A2 maps are loaded from files.
- [ ] `OperationHistory.java`: remove from active flow because A2 tracks shift summary, not operation history.
- [ ] `OperationRecord.java`: remove from active flow unless reused only internally without affecting required output.
- [ ] `OperationType.java`: remove from active flow unless reused only internally without affecting required output.

## Implementation Progress

### Phase 1 - Project Structure and Shared Types

- [ ] Decide package structure with at least 3 packages while keeping `WarehouseManagerEngine.java` in default package.
- [ ] Add or move warehouse domain classes into package such as `warehouse`.
- [ ] Add employee domain package such as `employee`.
- [ ] Add payroll package such as `payroll`.
- [ ] Add file parsing package such as `io`.
- [ ] Add exception package such as `exceptions`.
- [ ] Add `ShelfType` enum.
- [ ] Add `Designation` enum.
- [ ] Add at least one inheritance hierarchy for employees.
- [ ] Add at least one interface for role capability or common behavior.
- [ ] Ensure all package/class names follow Java conventions.

### Phase 2 - Command-Line Validation

- [ ] Change required args from 3 to 5.
- [ ] Validate missing args with exact usage message.
- [ ] Validate non-integer `floors`, `rows`, `cols`.
- [ ] Validate `floors` is between 1 and 3.
- [ ] Validate `rows` and `cols` are at least 4.
- [ ] Validate missing/unreadable warehouse and employees files.
- [ ] Terminate gracefully without `System.exit()`.

### Phase 3 - Warehouse Model and Display

- [ ] Initialise `floors x rows x cols` warehouse.
- [ ] Set every floor boundary to `WALL`.
- [ ] Set every floor interior to `AISLE`.
- [ ] Set `(1,1)` on each floor to `START`.
- [ ] Give each floor its own `Forklift`.
- [ ] Remove Warehouse ID from display.
- [ ] Print Assignment 2 legend exactly.
- [ ] Print every floor in floor-selection view.
- [ ] Print selected floor before movement menu.
- [ ] Preserve correct symbols: `#`, `.`, `X`, `S`, `O`, `F`.

### Phase 4 - Warehouse CSV Reading

- [ ] Read warehouse file path from command-line args.
- [ ] Skip header and empty lines.
- [ ] Parse `floor,row,col,cell_type,shelf_type,item_name`.
- [ ] Convert floor number from 1-based file value to internal index.
- [ ] Validate field count and print exact invalid-line message.
- [ ] Validate floor bounds and print exact message.
- [ ] Validate row/col bounds and boundary placement.
- [ ] Validate cell type is only `RESTRICTED` or `SHELF`.
- [ ] Validate overlap/mismatch cases.
- [ ] Validate restricted shelf type is blank or `-`.
- [ ] Validate shelf type enum.
- [ ] Validate shelf type mismatch on repeated shelf location.
- [ ] Load valid shelf item names without item-type validation.
- [ ] Skip invalid lines without terminating program.

### Phase 5 - Employees CSV Reading

- [ ] Read employees file path from command-line args.
- [ ] Skip header and empty lines.
- [ ] Parse `employee_id,employee_name,designation,base_salary,manager`.
- [ ] Allow missing/empty manager field.
- [ ] Validate at least 4 fields.
- [ ] Validate nonempty employee ID and name.
- [ ] Validate positive base salary.
- [ ] Validate designation enum.
- [ ] Create correct employee subtype per designation.
- [ ] Preserve employees-file order.
- [ ] Build direct manager-reportee relationships.
- [ ] Avoid validating manager ID existence or manager-reportee loops, per spec.

### Phase 6 - Payslips CSV Reading and Writing

- [ ] Read fixed path `data/payslips.csv`.
- [ ] Continue without error if payslip file is missing.
- [ ] Continue if file is header-only.
- [ ] Parse `employee_id,employee_name,base_pay,delivered_item_pay,hits_penalty,restricted_area_penalty,reportees_managing_pay,net_salary`.
- [ ] Validate exact 8 fields.
- [ ] Validate nonempty employee ID and name.
- [ ] Validate salary fields according to spec.
- [ ] Preserve loaded old payslips until current-session generation happens.
- [ ] Generate/write records in employees-file order.
- [ ] Replace whole payslip file only once at program termination.
- [ ] Preserve/write header.
- [ ] Call `flush()` when writing.
- [ ] Print save/goodbye messages correctly on final termination.

### Phase 7 - Login and Role Menus

- [ ] Print processing messages for warehouse, employees, and payslips files.
- [ ] Print `Welcome to Warehouse Manager Assignment 2.`
- [ ] Implement employee login prompt.
- [ ] Handle invalid employee ID with exact message.
- [ ] Handle login `X` termination.
- [ ] Print welcome line with employee name and designation.
- [ ] Show Operator/Senior Operator menu.
- [ ] Show Supervisor menu with reportees option.
- [ ] Show Payroll Manager menu.
- [ ] Handle invalid integer menu choices with `Invalid input.`
- [ ] Logout returns to employee login.

### Phase 8 - Shift Navigation

- [ ] Implement Option 1 start shift for operator-like roles.
- [ ] Show all-floor map and floor prompt.
- [ ] Handle invalid floor number with `Invalid Input`.
- [ ] Enter selected floor movement menu.
- [ ] Preserve Assignment 1 movement menu behavior where applicable.
- [ ] Preserve Assignment 1 shelf menu behavior where applicable.
- [ ] Handle `Q` from movement menu as paused shift.
- [ ] Return from paused shift to floor selection, then `X` to role menu.
- [ ] Implement Option 2 resume shift.
- [ ] Handle resume before any shift started.
- [ ] Resume shared warehouse state even after a different employee logs in.
- [ ] Detect all-floors completion.
- [ ] Print completion messages exactly.

### Phase 9 - Shift Summary

- [ ] Add `ShiftSummary` model.
- [ ] Track delivered items per employee.
- [ ] Track wall hits per employee.
- [ ] Track restricted-area hits per employee.
- [ ] Increment delivered count only after successful delivery at `START (O)`.
- [ ] Increment wall-hit count only for wall/boundary attempts.
- [ ] Increment restricted-hit count only for restricted-area attempts.
- [ ] Print own shift summary exactly.
- [ ] Print zero values when no movement/action happened.
- [ ] Remove operation-history output from active A2 menus.

### Phase 10 - Payroll and Payslip Behavior

- [ ] Implement salary calculation for operator, senior operator, and supervisor.
- [ ] Implement payroll manager salary as base salary only.
- [ ] Use inferred salary constants unless original table is recovered: delivery `10.00`, wall hit `0.25`, restricted hit `0.50`, reportee `5.00`.
- [ ] Generate payslips for all employees from current session summaries.
- [ ] Include employees with no movement.
- [ ] Include payroll manager's own payslip.
- [ ] Discard old loaded payslip data after current-session generation.
- [ ] Print `Payslips generated successfully.`
- [ ] Print one employee's payslip according to old/new/missing scenarios.
- [ ] Print all generated/loaded payslips for payroll manager.
- [ ] Print `Payslip not generated yet.` when required.
- [ ] Print `Employee <EmployeeID>'s payslip not found.` when required.
- [ ] Format money with exactly 2 decimals.

### Phase 11 - Supervisor and Payroll Reports

- [ ] Supervisor option prints only direct reportees.
- [ ] Supervisor report avoids privacy leaks.
- [ ] Payroll manager option prints all employees' summaries.
- [ ] Preserve employees-file order in reports.
- [ ] Use exact summary format for each employee.

### Phase 12 - Exceptions

- [ ] Add `InvalidLineException`.
- [ ] Add `InvalidWarehouseException`.
- [ ] Add `InvalidLocationException`.
- [ ] Add `InvalidTypeException`.
- [ ] Add `NotFoundException`.
- [ ] Throw exceptions where invalid data/state is detected.
- [ ] Catch file-line exceptions in file-reading control flow.
- [ ] Catch runtime NotFound scenarios in menu/payslip flow.
- [ ] Handle `FileNotFoundException` and `IOException`.
- [ ] Keep fatal file-open behavior aligned with spec.

### Phase 13 - Quality, Javadoc, UML

- [ ] Add meaningful Javadoc to major classes and methods.
- [ ] Add Javadoc to enum types.
- [ ] Keep inline comments only where they clarify complex logic.
- [ ] Check naming, indentation, and line lengths.
- [ ] Verify no `java.nio.Files`.
- [ ] Verify no `System.exit()`.
- [ ] Verify `WarehouseManagerEngine.java` remains outside packages.
- [ ] Verify no complex collections are used.
- [ ] Generate Javadoc locally without errors.
- [ ] Build manual UML diagram and export as PDF/PNG.

### Phase 14 - Verification

- [ ] Compile all Java sources.
- [ ] Test command-line validation cases.
- [ ] Test warehouse CSV invalid-line cases.
- [ ] Test employees CSV invalid-line cases.
- [ ] Test payslips CSV missing/header-only/invalid-line cases.
- [ ] Test login and every role menu.
- [ ] Test shift start, pause, resume, and completion.
- [ ] Test resume by a different employee.
- [ ] Test per-employee summary counts.
- [ ] Test supervisor direct-reportee view.
- [ ] Test payroll manager reports.
- [ ] Test payslip generation and display scenarios.
- [ ] Test payslip file write-back at termination.
- [ ] Compare console output against requirement examples.
- [ ] Run final EdStem-style compile/run check.

## Progress Log

| Date | Change | Status |
| --- | --- | --- |
| 2026-05-26 | Read requirement/workflows and all teacher-provided Java base files. | Done |
| 2026-05-26 | Re-read `RULER.md`, `WORKFLOW_FOR_AI_EN_COMPACT.md`, `MEMORY.md`, and `PROGRESS.md` before formal implementation. | Done |
| 2026-05-26 | Created this progress tracker. | Done |
| 2026-05-26 | Created immutable `RULER.md` and updated handoff memory. | Done |
| 2026-05-26 | Converted `RULER.md` to English-only wording and kept it read-only. | Done |
