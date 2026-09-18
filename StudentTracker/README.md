# Student Grade & Attendance Tracker (StudentTracker)

A lightweight, console-based Java utility designed to simplify grade logging, attendance monitoring, and academic eligibility tracking for course instructors. 

I built this project to automate routine manual calculations—such as identifying at-risk students below the mandatory 75% attendance mark and calculating average continuous assessment scores—without needing a heavy database or complex GUI setup.

---

## Key Features

- **Student Record Management:** Add and store student profiles with unique registration IDs, names, and attendance counters.
- **Academic Score Logging:** Append examination/quiz scores on the fly with built-in input validation (rejecting out-of-range marks like negative values or scores above 100).
- **Attendance & Eligibility Analytics:** Calculates real-time attendance percentage and automatically flags students with a `DEFICIT (<75%)` warning.
- **Local Persistence:** Data automatically writes to and loads from a plain text storage file (`students.txt`), so progress is retained between terminal sessions.
- **Robust Exception Handling:** Catches malformed user inputs and file I/O interruptions gracefully to avoid application crashes.

---

## Tech Stack & Architecture

- **Language:** Java (JDK 17+)
- **Storage:** Flat-file I/O (`BufferedReader` / `PrintWriter`)
- **Key Concepts:** Object-Oriented Programming (Inheritance, Encapsulation), Custom Exceptions, Collections Framework (`List`, `ArrayList`)

### Directory Structure

```text
StudentTracker/
├── app/
│   ├── Main.java               # CLI entry point and menu loops
│   └── StudentService.java     # Core business logic and analytics
├── exception/
│   └── InvalidScoreException.java # Custom checked exception
├── model/
│   ├── Person.java             # Base abstract entity
│   └── Student.java            # Extended student domain entity
├── storage/
│   └── FileStorage.java        # Read/write serialization logic
├── bin/                        # Compiled bytecode output (.class)
└── students.txt                # Auto-generated persistent storage
```

---

## How to Compile and Run

Make sure you have JDK 17 (or newer) installed and accessible from your terminal.

### 1. Clone the repository
```bash
git clone https://github.com/th25thbam/StudentTracker.git
cd SGAT
```

### 2. Compile
From the root directory (`StudentTracker`), compile all modules into an output directory named `bin`:

```bash
javac -sourcepath . -d bin app/Main.java
```

*(Alternatively, to compile all packages explicitly: `javac -d bin model/*.java exception/*.java storage/*.java app/*.java`)*

### 3. Run
Launch the interactive console menu:

```bash
java -cp bin app.Main
```

---

## Sample Run

```text
=== STUDENT TRACKER MENU ===
1. Add New Student
2. Enter Marks for Student
3. Display Summary Report
4. Exit
Enter choice (1-4): 1
Enter Student ID: 21BCE10420
Enter Name: Seris
Enter Attended Classes: 24
Enter Total Classes: 30
Student recorded.

=== STUDENT TRACKER MENU ===
1. Add New Student
2. Enter Marks for Student
3. Display Summary Report
4. Exit
Enter choice (1-4): 2
Enter Student ID: 21BCE10420
Enter Mark (0-100): 88.5
Mark added successfully.

=== STUDENT TRACKER MENU ===
1. Add New Student
2. Enter Marks for Student
3. Display Summary Report
4. Exit
Enter choice (1-4): 3

--- Performance & Defaulter Summary ---
ID: 21BCE10420 | Name: Seris | Average: 88.50 | Attendance: 80.0% [ELIGIBLE]
```

---

## Future Enhancements
- Export detailed student grade sheets to formatted `.csv` or `.pdf` reports.
- Support weighting factors for assignments, midterms, and final exams.
- Migrate to a SQLite database backend using JDBC for structured relational querying.