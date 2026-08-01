# TrustWork 

**A Console-Based Tool for Skill Verification & Trust Network Management**

---

## 📌 Overview

**TrustWork is a console-based tool** (not a full system) designed to help manage worker skill verification and trust networks for informal sector workers.

**Key Characteristics:**
- **Console Interface**: Text-based menu-driven command-line application
- **Tool Purpose**: Enables workers to verify skills, document experience, and build trust networks
- **No External Dependencies**: Standalone tool with local JSON file storage

**What TrustWork Does:**
- Manage worker profiles with skill verification
- Track employment history and experience
- Create and monitor trust relationships between workers and employers
- Generate reports and analytics

The tool implements three core data structures (AVL Tree, Doubly Linked List, Graph) to efficiently manage worker profiles, employment history, and trust relationships.

## ▶️ How to Run

Open the project in **Visual Studio Code** and open the integrated terminal (**Terminal → New Terminal**).

Compile all Java source files:

```powershell
javac -d bin $(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

Run the application:

```powershell
java -cp bin TrustWorkApplication
```

---

## ✨ Features

### Version 1.0 (Base Implementation)
- Add and search worker profiles (AVL Tree - O(log n))
- Track job history (Doubly Linked List - bidirectional)
- Manage trust network connections (Graph)
- JSON data persistence

### Version 2.0 (Enhanced)
- Advanced search (by name, skill, location)
- Edit and delete worker profiles
- CSV data export
- Experience level categorization
- Worker rankings (top 10 by vouches/rating)
- System analytics and statistics

---

## 👥 Team (NIBM Batch 25.2F, Group 11)

| Name | ID | Data Structure | Module |
|------|-----|-----------------|--------|
| L H S Senethma | COHNDSE252F-015 | AVL Tree | Worker Profiles |
| G A A E Perera | COHNDSE252F-055 | Doubly Linked List | Job History |
| N D D I Pramuditha | COHNDSE252F-069 | Graph | Trust Network |

---

## 🏗️ Data Structures

1. **AVL Tree** - Worker Profile Management
   - Search: O(log n) | Insert: O(log n) | Delete: O(log n)

2. **Doubly Linked List** - Job History Management
   - Insert: O(1) | Traverse: O(n) bidirectional

3. **Graph** - Trust Network Management
   - Add Connection: O(1) | Path Finding: O(V+E)

---

## 💻 Technologies

- **Language**: Java (JDK 11+)
- **Interface**: Console/Command-Line (Text-based menu)
- **IDE**: Visual Studio Code
- **Version Control**: Git & GitHub
- **Data Format**: JSON (local file storage), CSV (export)
- **Patterns**: OOP, MVC, Singleton, Factory, Iterator
- **No External Database**: Standalone tool with file-based persistence

---

## ⚙️ Setup & Execution

### Compile (All Platforms - One Line)

**Windows:**
```batch
javac -d bin -cp bin src\utils\*.java && javac -d bin -cp bin src\member1\*.java && javac -d bin -cp bin src\member2\*.java && javac -d bin -cp bin src\member3\*.java && javac -d bin -cp bin src\TrustWorkApplication.java
```

**Mac/Linux:**
```bash
javac -d bin -cp bin src/utils/*.java && javac -d bin -cp bin src/member1/*.java && javac -d bin -cp bin src/member2/*.java && javac -d bin -cp bin src/member3/*.java && javac -d bin -cp bin src/TrustWorkApplication.java
```

### Run
```bash
java -cp bin TrustWorkApplication
```

---

## 📂 Project Structure

```
TrustWork/
├── src/
│   ├── utils/          (Validators, Formatters, File Management)
│   ├── member1/        (AVL Tree - Worker Profiles)
│   ├── member2/        (Doubly Linked List - Job History)
│   ├── member3/        (Graph - Trust Network)
│   └── TrustWorkApplication.java
├── bin/                (Compiled files)
├── data/               (JSON data files)
└── README.md
```

---

## 🚀 Usage

Run the application:
```bash
java -cp bin TrustWorkApplication
```

**Main Menu Options:**
1. Worker Profile Management (Add, Search, Edit, Delete, Export)
2. Job History Management (Add, View, Calculate Experience, Export)
3. Trust Network Management (Add Employers, Vouch, Rankings, Export)
4. Analytics & Statistics
5. Help & Tutorials
6. Exit

---

## 📊 Version Comparison

| Feature | v1.0 | v2.0 |
|---------|------|------|
| Core Data Structures | ✓ | ✓ |
| Basic CRUD | ✓ | ✓ |
| Advanced Search | ✗ | ✓ |
| CSV Export | ✗ | ✓ |
| Analytics | ✗ | ✓ |
| Rankings | ✗ | ✓ |
| Code Size | ~1200 lines | ~2000 lines |

---

## 🔗 Git Workflow

```
main
  ├── feature/avl-tree (v1.0) → (v2.0 enhanced)
  ├── feature/dll (v1.0) → (v2.0 enhanced)
  └── feature/graph (v1.0) → (v2.0 enhanced)
```

**Two commits per member:**
- Commit 1: v1.0 Base Implementation
- Commit 2: v2.0 Usability Enhancements

---

## 📚 References (APA 7)

Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). *Introduction to algorithms* (3rd ed.). MIT Press.

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design patterns: Elements of reusable object-oriented software*. Addison-Wesley.

McConnell, S. (2004). *Code complete* (2nd ed.). Microsoft Press.

Sedgewick, R., & Wayne, K. (2011). *Algorithms* (4th ed.). Addison-Wesley Professional.

Sommerville, I. (2015). *Software engineering* (10th ed.). Pearson.

---

## ✅ System Requirements

- Java JDK 11 or higher
- 2GB RAM minimum
- Windows, Mac, or Linux OS

---

**Status:** ✅ Production Ready | **Version:** v2.0 Enhanced | **Date:** July 2026
