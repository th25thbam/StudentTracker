# Project Statement: Student Grade & Attendance Tracker (StudentTracker)

## 1. Problem Statement

In educational environments, course instructors and teaching assistants often rely on manual spreadsheets or paper records to track continuous assessment marks and classroom attendance. This manual workflow is prone to data entry mistakes, tedious calculations, and delays in identifying academically at-risk students—particularly those falling below mandatory attendance thresholds (such as the 75% institutional requirement). There is a need for a lightweight, dependency-free tool to record student marks, compute performance metrics instantly, and highlight attendance deficits without the overhead of heavy software or complex database setups.

## 2. Scope of the Project

The Student Grade & Attendance Tracker (SGAT) is a modular, console-based Java utility designed for single-course or cohort-level management.

### In-Scope:

* Registering students with unique IDs, names, and attendance counters.

* Logging continuous assessment marks with boundary validations (0 to 100).

* Automatic calculation of cumulative averages and attendance percentages.

* Flagging students who fall below the minimum 75% attendance threshold.

* Flat-file persistence (`students.txt`) to maintain state between application restarts.

* Defensive input handling to prevent runtime crashes caused by malformed user input.

### Out-of-Scope:

* Multi-user role-based authentication or remote client-server networking.

* Complex graphical user interfaces (GUI) or browser-based dashboards.

* External relational database servers (e.g., MySQL, PostgreSQL).

## 3. Target Users

* **Course Instructors & Professors:** To track class performance and assess final examination eligibility.

* **Teaching Assistants / Lab Instructors:** To log weekly assignment/quiz scores and verify lab attendance compliance.

* **Academic Advisors:** To quickly identify students requiring early academic or attendance interventions.

## 4. High-Level Features

* **Student Record Management:** Add and store student profile data with total classes conducted and attended.

* **Grade Logging with Validation:** Add marks with immediate boundary validation, throwing custom exceptions on invalid scores.

* **Automated Eligibility Engine:** Calculates attendance percentages dynamically and flags records with `[ELIGIBLE]` or `[DEFICIT (<75%)]`.

* **Summary Analytics Reporting:** Outputs a clear console summary displaying individual averages and overall standing.

* **Persistent File Storage:** Seamless read/write operations using standard Java file streams so no data is lost on exit.