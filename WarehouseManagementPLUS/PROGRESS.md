# WarehouseManagementPLUS Progress

Purpose: track implementation progress against `WORKFLOW_FOR_ME_CN_EN.md` and `WORKFLOW_FOR_AI_EN_COMPACT.md`.

Rule: only mark an item complete after the code is implemented and verified. Reading/planning items may be checked now; implementation items remain unchecked until finished.

## Design Notes

- CSV loading must stay flexible: warehouse and employees file paths come from command-line arguments and should be passed into reader methods/classes, not hardcoded.
- `data/payslips.csv` is the only fixed CSV path because the workflow explicitly requires it.
- CSV reader classes should populate domain objects through clear methods rather than owning menu or movement logic.
- Test commands may use concrete fixture paths such as `src/data/master_warehouse_1.csv`, but production code must not hardcode those fixture names.

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

- [x] `CellType.java`: keep existing enum values; later move/package if needed.
- [x] `Item.java`: keep simple item-name model; later move/package if needed.
- [ ] `Shelf.java`: adapt to support `ShelfType` and file-loaded items.
- [ ] `WarehouseCell.java`: adapt to support typed shelves and safer shelf access.
- [x] `Forklift.java`: adapt to per-floor forklift state and per-employee summary updates.
- [ ] `Messages.java`: rewrite/extend exact Assignment 2 output strings.
- [ ] `Constants.java`: rewrite/extend Assignment 2 constants and salary rates.
- [ ] `WarehouseMap.java`: replace current 2D/random-map responsibility with multi-floor file-loaded design.
- [ ] `WarehouseManagerEngine.java`: keep in default package; rewrite orchestration for A2 args, file loading, login, role menus.

### Deprecate or Remove from A2 Flow

- [x] `WarehouseGenerator.java`: stop using it because A2 maps are loaded from files.
- [x] `OperationHistory.java`: remove from active flow because A2 tracks shift summary, not operation history.
- [x] `OperationRecord.java`: remove from active flow unless reused only internally without affecting required output.
- [x] `OperationType.java`: remove from active flow unless reused only internally without affecting required output.

## Implementation Progress

### Phase 1 - Project Structure and Shared Types

- [x] Decide package structure with at least 3 packages while keeping `WarehouseManagerEngine.java` in default package.
- [x] Add or move warehouse domain classes into package such as `warehouse`.
- [x] Add employee domain package such as `employee`.
- [x] Add payroll package such as `payroll`.
- [x] Add file parsing package such as `io`.
- [x] Add exception package such as `IOExceptions`.
- [x] Add `ShelfType` enum.
- [x] Add `Designation` enum.
- [x] Add at least one inheritance hierarchy for employees.
- [x] Add at least one interface for role capability or common behavior.
- [x] Ensure all package/class names follow Java conventions.

### Phase 2 - Command-Line Validation

- [x] Change required args from 3 to 5.
- [x] Validate missing args with exact usage message.
- [x] Validate non-integer `floors`, `rows`, `cols`.
- [x] Validate `floors` is between 1 and 3.
- [x] Validate `rows` and `cols` are at least 4.
- [x] Validate missing/unreadable warehouse and employees files.
- [x] Terminate gracefully without `System.exit()`.

### Phase 3 - Warehouse Model and Display

- [x] Initialise `floors x rows x cols` warehouse.
- [x] Set every floor boundary to `WALL`.
- [x] Set every floor interior to `AISLE`.
- [x] Set `(1,1)` on each floor to `START`.
- [x] Give each floor its own `Forklift`.
- [x] Remove Warehouse ID from display.
- [x] Print Assignment 2 legend exactly.
- [x] Print every floor in floor-selection view.
- [x] Print selected floor before movement menu.
- [x] Preserve correct symbols: `#`, `.`, `X`, `S`, `O`, `F`.

### Phase 4 - Warehouse CSV Reading

- [x] Read warehouse file path from command-line args.
- [x] Skip header and empty lines.
- [x] Parse `floor,row,col,cell_type,shelf_type,item_name`.
- [x] Convert floor number from 1-based file value to internal index.
- [x] Validate field count and print exact invalid-line message.
- [x] Validate floor bounds and print exact message.
- [x] Validate row/col bounds and boundary placement.
- [x] Validate cell type is only `RESTRICTED` or `SHELF`.
- [x] Validate overlap/mismatch cases.
- [x] Validate restricted shelf type is blank or `-`.
- [x] Validate shelf type enum.
- [x] Validate shelf type mismatch on repeated shelf location.
- [x] Load valid shelf item names without item-type validation.
- [x] Skip invalid lines without terminating program.

### Phase 5 - Employees CSV Reading

- [x] Read employees file path from command-line args.
- [x] Skip header and empty lines.
- [x] Parse `employee_id,employee_name,designation,base_salary,manager`.
- [x] Allow missing/empty manager field.
- [x] Validate at least 4 fields.
- [x] Validate nonempty employee ID and name.
- [x] Validate positive base salary.
- [x] Validate designation enum.
- [x] Create correct employee subtype per designation.
- [x] Preserve employees-file order.
- [x] Build direct manager-reportee relationships.
- [x] Avoid validating manager ID existence or manager-reportee loops, per spec.

### Phase 6 - Payslips CSV Reading and Writing

- [x] Read fixed path `data/payslips.csv`.
- [x] Continue without error if payslip file is missing.
- [x] Continue if file is header-only.
- [x] Parse `employee_id,employee_name,base_pay,delivered_item_pay,hits_penalty,restricted_area_penalty,reportees_managing_pay,net_salary`.
- [x] Validate exact 8 fields.
- [x] Validate nonempty employee ID and name.
- [x] Validate salary fields according to spec.
- [x] Preserve loaded old payslips until current-session generation happens.
- [x] Generate/write records in employees-file order.
- [x] Replace whole payslip file only once at program termination.
- [x] Preserve/write header.
- [x] Call `flush()` when writing.
- [x] Print save/goodbye messages correctly on final termination.

### Phase 7 - Login and Role Menus

- [x] Print processing messages for warehouse, employees, and payslips files.
- [x] Print `Welcome to Warehouse Manager Assignment 2.`
- [x] Implement employee login prompt.
- [x] Handle invalid employee ID with exact message.
- [x] Handle login `X` termination.
- [x] Print welcome line with employee name and designation.
- [x] Show Operator/Senior Operator menu.
- [x] Show Supervisor menu with reportees option.
- [x] Show Payroll Manager menu.
- [x] Handle invalid integer menu choices with `Invalid input.`
- [x] Logout returns to employee login.

### Phase 8 - Shift Navigation

- [x] Implement Option 1 start shift for operator-like roles.
- [x] Show all-floor map and floor prompt.
- [x] Handle invalid floor number with `Invalid Input`.
- [x] Enter selected floor movement menu.
- [x] Preserve Assignment 1 movement menu behavior where applicable.
- [x] Preserve Assignment 1 shelf menu behavior where applicable.
- [x] Handle `Q` from movement menu as paused shift.
- [x] Return from paused shift to floor selection, then `X` to role menu.
- [x] Implement Option 2 resume shift.
- [x] Handle resume before any shift started.
- [x] Resume shared warehouse state even after a different employee logs in.
- [x] Detect all-floors completion.
- [x] Print completion messages exactly.

### Phase 9 - Shift Summary

- [x] Add `ShiftSummary` model.
- [x] Track delivered items per employee.
- [x] Track wall hits per employee.
- [x] Track restricted-area hits per employee.
- [x] Increment delivered count only after successful delivery at `START (O)`.
- [x] Increment wall-hit count only for wall/boundary attempts.
- [x] Increment restricted-hit count only for restricted-area attempts.
- [x] Print own shift summary exactly.
- [x] Print zero values when no movement/action happened.
- [x] Remove operation-history output from active A2 menus.

### Phase 10 - Payroll and Payslip Behavior

- [x] Implement salary calculation for operator, senior operator, and supervisor.
- [x] Implement payroll manager salary as base salary only.
- [x] Use inferred salary constants unless original table is recovered: delivery `10.00`, wall hit `0.25`, restricted hit `0.50`, reportee `5.00`.
- [x] Generate payslips for all employees from current session summaries.
- [x] Include employees with no movement.
- [x] Include payroll manager's own payslip.
- [x] Discard old loaded payslip data after current-session generation.
- [x] Print `Payslips generated successfully.`
- [x] Print one employee's payslip according to old/new/missing scenarios.
- [x] Print all generated/loaded payslips for payroll manager.
- [x] Print `Payslip not generated yet.` when required.
- [x] Print `Employee <EmployeeID>'s payslip not found.` when required.
- [x] Format money with exactly 2 decimals.

### Phase 11 - Supervisor and Payroll Reports

- [x] Supervisor option prints only direct reportees.
- [x] Supervisor report avoids privacy leaks.
- [x] Payroll manager option prints all employees' summaries.
- [x] Preserve employees-file order in reports.
- [x] Use exact summary format for each employee.

### Phase 12 - Exceptions

- [x] Add `InvalidLineException`.
- [x] Add `InvalidWarehouseException`.
- [x] Add `InvalidLocationException`.
- [x] Add `InvalidTypeException`.
- [x] Add `NotFoundException`.
- [x] Throw IOExceptions where invalid data/state is detected.
- [x] Catch file-line IOExceptions in file-reading control flow.
- [x] Catch runtime NotFound scenarios in menu/payslip flow.
- [x] Handle `FileNotFoundException` and `IOException`.
- [x] Keep fatal file-open behavior aligned with spec.

### Phase 13 - Quality, Javadoc, UML

- [ ] Add meaningful Javadoc to major classes and methods.
- [ ] Add Javadoc to enum types.
- [ ] Keep inline comments only where they clarify complex logic.
- [ ] Check naming, indentation, and line lengths.
- [x] Verify no `java.nio.Files`.
- [x] Verify no `System.exit()`.
- [x] Verify `WarehouseManagerEngine.java` remains outside packages.
- [x] Verify no complex collections are used.
- [x] Generate Javadoc locally without errors.
- [ ] Build manual UML diagram and export as PDF/PNG.

### Phase 14 - Verification

- [x] Compile all Java sources.
- [x] Test command-line validation cases.
- [x] Test warehouse CSV invalid-line cases.
- [x] Test employees CSV invalid-line cases.
- [x] Test payslips CSV missing/header-only/invalid-line cases.
- [x] Test login and every role menu.
- [x] Test shift start, pause, resume, and completion.
- [x] Test resume by a different employee.
- [x] Test per-employee summary counts.
- [x] Test supervisor direct-reportee view.
- [x] Test payroll manager reports.
- [x] Test payslip generation and display scenarios.
- [x] Test payslip file write-back at termination.
- [ ] Compare console output against requirement examples.
- [x] Run final EdStem-style compile/run check.

## Progress Log

| Date | Change | Status |
| --- | --- | --- |
| 2026-05-26 | Read requirement/workflows and all teacher-provided Java base files. | Done |
| 2026-05-26 | Re-read `RULER.md`, `WORKFLOW_FOR_AI_EN_COMPACT.md`, `MEMORY.md`, and `PROGRESS.md` before formal implementation. | Done |
| 2026-05-26 | Created this progress tracker. | Done |
| 2026-05-26 | Created immutable `RULER.md` and updated handoff memory. | Done |
| 2026-05-26 | Converted `RULER.md` to English-only wording and kept it read-only. | Done |
| 2026-05-26 | Investigated missing `requirement.docx`; no copy found in project, `D:\STUDY`, Git history, D recycle bin, or same-size/date search. | Done |
| 2026-05-26 | Phase 1 first slice: added package skeletons, employee hierarchy, role/shelf enums, shift summary, required IOExceptions, and verified compile to `/tmp/wmp-classes`. | Done |
| 2026-05-26 | Removed redundant same-package `warehouse.Item` imports and deleted `WarehouseGenerator.java`; stale map references remain for the later A2 map rewrite. | Partial |
| 2026-05-26 | Deleted operation-history classes and removed their active references from forklift, map, engine, constants, and messages; remaining compile failures are package/default-package and stale generator issues. | Done |
| 2026-05-26 | Moved `Constants.java` and `Messages.java` into the `warehouse` package; compile now fails only on stale `WarehouseGenerator` references in `WarehouseMap`. | Done |
| 2026-05-26 | Added CSV flexibility design note: warehouse/employees paths must come from args; only payslip path is fixed by workflow. | Planned |
| 2026-05-27 | Removed stale `WarehouseGenerator` dependency and old random-fill helper methods from `WarehouseMap`; verified full Java compile to `/tmp/wmp-classes`. | Done |
| 2026-05-27 | Phase 1 completed: package/shared-type refactor is in place and current Java sources compile. | Done |
| 2026-05-27 | Clarified CSV testing rule: hardcoded fixture paths are acceptable in manual test commands only, not in production code. | Planned |
| 2026-05-27 | Phase 2 completed: implemented 5-argument validation, numeric/range checks, readable file checks, graceful returns, and verified command-line error cases. | Done |
| 2026-05-27 | Phase 3 first slice: converted `WarehouseMap` to a 3D grid with one forklift per floor, base floor initialization, selected-floor display, and verified compile/start-shift smoke tests. | Done |
| 2026-05-27 | Phase 3 floor-selection slice: added all-floor display prompt, valid floor selection, invalid floor redisplay, and `X` return to main menu; compile and smoke tests pass. | Done |
| 2026-05-27 | Phase 4 step 1: added `WarehouseCsvReader`, opened warehouse CSV path from args, skipped header/empty lines, counted structurally valid rows, printed temporary load count, and verified with fixture input. | Done |
| 2026-05-27 | Phase 4 completed: warehouse CSV rows now validate, print required row errors, populate shelves/restricted cells/items, skip invalid lines, and display loaded `S`/`X` symbols. | Done |
| 2026-05-27 | Phase 5 completed: added `EmployeeCsvReader`, validates employee rows, creates employee subtypes in file order, builds direct supervisor reportees, and verifies provided plus temporary fixtures. | Done |
| 2026-05-27 | Phase 6 steps 1-2: implemented `Payslip` model and `PayslipCsvReader`, read fixed `data/payslips.csv`, handled missing file, validated rows, and verified error outputs with temporary fixture. | Done |
| 2026-05-27 | Phase 6 step 3: added payslip writer, writes header with flush at termination when file is missing or session data is generated, preserves existing file untouched when no generation occurred. | Done |
| 2026-05-27 | Phase 7 completed: added employee login loop, invalid ID handling, login termination, role-specific menus, logout flow, and invalid menu input handling; smoke tests pass. | Done |
| 2026-05-27 | Phase 8 first two steps: split start/resume/floor-selection flow, added no-start resume guard, pause return behavior, shared resume state, and completion message checks; compile and smoke tests pass. | Done |
| 2026-05-27 | Phase 8 completed: regression-tested movement and shelf menu behavior, including movement directions, invalid movement input, wall/restricted hits, shelf view/pick/invalid input, delivery, pause, and floor-menu return. | Done |
| 2026-05-27 | Phase 9 completed: connected per-employee shift summaries to shift actions, counted successful deliveries/wall hits/restricted hits, printed own summary, and verified zero/action/cross-employee scenarios. | Done |
| 2026-05-28 | Phase 10 completed: generated payslips from current summaries, calculated salary components, implemented own/all payslip views, handled missing/not-found/old-vs-new scenarios, and verified write-back in a temporary workdir. | Done |
| 2026-05-28 | Phase 11 completed: implemented supervisor direct-reportee summaries and payroll-manager all-employee summaries, preserving employees-file order and reportee privacy. | Done |
| 2026-05-28 | Phase 12 first slice: confirmed all required custom exception classes exist in `IOExceptions` package and verified compile. | Done |
| 2026-05-28 | Phase 12 file-reader slice: wired warehouse, employee, and payslip readers to throw/catch custom line-level exceptions while preserving existing console output. | Done |
| 2026-05-28 | Phase 12 completed: connected runtime not-found cases and file-open IO failures to custom/checked exception handling while preserving required console behavior. | Done |
| 2026-05-28 | Phase 13 hard compliance checks: compile, forbidden API scans, package/default-package checks, complex-collection scan, and Javadoc generation passed; cleanup still needed for long lines and stale `.class` files. | Partial |
| 2026-05-28 | Phase 14 broad verification run passed across command-line validation, CSV invalid lines, role menus, shift/resume/completion, summaries, payroll reports, payslip generation/display, write-back, and final EdStem-style compile/run. | Done |
| 2026-05-28 | Removed stale `.class` compilation outputs from `src`; Java source cleanup for four long lines remains. | Done |
| 2026-05-28 | Re-read `MEMORY.md`, `PROGRESS.md`, `RULER.md`, and `WORKFLOW_FOR_AI_EN_COMPACT.md`; no Java source changes made. | Done |
| 2026-05-28 | Fixed teacher-test output formatting around all-floor map prompt, role-menu return newline, and login termination save message; compile and smoke test passed. | Done |
| 2026-05-28 | Adjusted context-specific newline behavior for valid floor selection and successful login/menu spacing; smoke test skipped per user request. | Done |
| 2026-05-28 | Added context-specific blank line after own shift summary before returning to operator/supervisor menus; compile passed. | Done |
| 2026-05-28 | Changed warehouse CSV validation priority so restricted rows with shelf type print the required restricted-location shelf-type message before overlap checks; compile passed. | Done |
| 2026-05-28 | Aligned program output with `src/example.md`: added `FLOOR_COMPLETE` message, single-floor-complete detection after delivery, caller-level trailing blanks for `View my payslip` / `Payslips generated successfully.` / reportee + all-employee summary iterations, leading blanks before "View all" listings, and per-payslip trailing `separator + blank` in `viewAllPayslips`. End-to-end run matches the example under UTF-8. | Done |
| 2026-05-28 | Re-read handoff docs, workflow, current Java diffs, file layout, and `src/example.md` after Claude's follow-up work; no Java source changes made. | Done |
| 2026-05-28 | Fixed collected teacher-test issues: warehouse trailing-comma field counts, invalid-login prompt newline, payslip exit saving condition, and final floor/warehouse completion message order/spacing; compile passed. | Done |
| 2026-05-28 | Fixed resume behavior for already-complete warehouses so completion message wins over no-start resume guard; compile passed. | Done |
| 2026-05-29 | Filtered payslip printing and write-back against the current employees file per teacher guidance; compile and targeted temporary-file tests passed. | Done |
| 2026-05-29 | Hardened numeric CSV edge cases by rejecting `NaN` and infinite values in employee base salary and payslip money parsing; compile passed. | Done |
| 2026-05-29 | Switched interactive console input reads from line-based `nextLine().trim()` to token-based helpers using `Scanner.next().trim()` so whitespace-only lines between commands are skipped; CSV readers remain line-based. Compile and blank-line input smoke test passed. | Done |
