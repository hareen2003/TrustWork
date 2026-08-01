# TrustWork - Complete Java Application

## 🎯 What is TrustWork?

**TrustWork** is a **Skill Verification & Trust Network System** for informal sector workers. It helps:
- Register and manage worker profiles
- Track job history and experience
- Build trust networks through employer vouches/recommendations
- Rank workers by reputation and skills

---

## 🏗️ Architecture

This application uses **THREE DATA STRUCTURES**:

### 1️⃣ **AVL Tree** (Worker Profile Management)
- **What**: Self-balancing binary search tree
- **Why**: Fast O(log n) worker lookups by ID
- **Where**: `src/member1/AVLTree.java`
- **Does**: Store and quickly search worker profiles

### 2️⃣ **Doubly Linked List** (Job History Management)  
- **What**: Bidirectional linked list
- **Why**: View jobs newest-first OR oldest-first (O(1) insert)
- **Where**: `src/member2/DoublyLinkedList.java`
- **Does**: Track job history chronologically

### 3️⃣ **Graph** (Trust Network Management)
- **What**: Undirected weighted graph
- **Why**: Model trust relationships between workers and employers
- **Where**: `src/member3/Graph.java`
- **Does**: Find trust paths, calculate ratings, rank workers

---

## 📂 File Structure

```
trustwork_complete/
│
├── src/
│   ├── utils/
│   │   ├── Validator.java          ← Input validation
│   │   ├── DateTimeHelper.java     ← Date/time operations
│   │   ├── DisplayFormatter.java   ← Console formatting
│   │   └── FileManager.java        ← File I/O
│   │
│   ├── member1/  (AVL Tree)
│   │   ├── AVLTree.java
│   │   ├── WorkerProfile.java
│   │   └── WorkerProfileManager.java
│   │
│   ├── member2/  (Doubly Linked List)
│   │   ├── DoublyLinkedList.java
│   │   ├── JobEntry.java
│   │   └── JobHistoryManager.java
│   │
│   ├── member3/  (Graph)
│   │   ├── Graph.java
│   │   ├── VouchRecord.java
│   │   └── TrustNetworkManager.java
│   │
│   └── TrustWorkApplication.java   ← MAIN APPLICATION
│
└── bin/  (compiled .class files)
```

---

## 🚀 What Happens When You Run It?

When you execute `java -cp bin TrustWorkApplication`, here's what happens:

### **1. Application Starts**
```
============================================================
        Welcome to TrustWork - Main Menu
============================================================
```

### **2. You See Main Menu**
```
1. Worker Profile Management
2. Job History Management
3. Trust Network Management
4. View System Statistics
5. Exit

Select an option (1-5):
```

### **3. Choose an Option and Use the Tool**

The application is **interactive**! You:
- Type numbers (1-5)
- Enter data into prompts
- See formatted output
- Navigate back to menu

---

## 📋 What Can You Do With This Tool?

### **Option 1: Worker Profile Management** (Member 1 - AVL Tree)

**Submenu**:
```
1. Add New Worker
2. Search Worker by ID
3. View All Workers
4. Back to Main Menu
```

**Example Workflow**:
```
→ Add New Worker
  Enter Worker ID: W001
  Enter Full Name: John Doe
  Enter Email: john@example.com
  Enter Contact: +94XXXXXXXXXX
  Enter Location: Colombo
  Enter Skills: Carpentry, Welding
  ✓ Worker W001 added successfully

→ View All Workers
  Shows ALL workers in sorted order (thanks to AVL Tree!)
  ID    Name        Skills              Location  Vouches
  W001  John Doe    Carpentry, Welding  Colombo   0

→ Search Worker by ID
  Enter Worker ID: W001
  Shows full details of that worker
```

**What's Happening**:
- AVL Tree stores workers sorted by ID
- Search is **O(log n)** - super fast!
- Display shows workers in sorted order

---

### **Option 2: Job History Management** (Member 2 - Doubly Linked List)

**Submenu**:
```
1. Add Job Entry
2. View Worker Job History
3. Get Total Experience
4. Back to Main Menu
```

**Example Workflow**:
```
→ Add Job Entry
  Enter Worker ID: W001
  Enter Employer: ABC Construction
  Enter Job Title: Lead Carpenter
  Enter Description: Built wooden structures
  Enter Start Date: 2023-01-15
  Enter End Date: 2024-06-30
  Is current job? (yes/no): no
  ✓ Job added: Lead Carpenter at ABC Construction

→ View Worker Job History
  Enter Worker ID: W001
  Show from oldest to newest? (yes/no): no
  
  Job History for W001 (Newest to Oldest):
  ---------------------
  1. Lead Carpenter
     Employer: ABC Construction
     Period: 2023-01-15 to 2024-06-30
     Duration: 17 months
     Status: Completed

→ Get Total Experience
  Enter Worker ID: W001
  Total experience: 1 years and 5 months
```

**What's Happening**:
- Doubly Linked List stores jobs in chronological order
- Can view **newest first** OR **oldest first** (bidirectional!)
- Experience calculated from job dates

---

### **Option 3: Trust Network Management** (Member 3 - Graph)

**Submenu**:
```
1. Add Employer
2. Create Vouch
3. View Worker Trust Network
4. View Top Workers
5. Back to Main Menu
```

**Example Workflow**:
```
→ Add Employer
  Enter Employer ID: E001
  Enter Employer Name: ABC Construction
  ✓ Employer E001 added to network

→ Create Vouch
  Enter Worker ID: W001
  Enter Employer ID: E001
  Enter Employer Name: ABC Construction
  Enter Recommendation Comment: Excellent work quality
  Enter Rating (1-5): 4.5
  ✓ Vouch from ABC Construction to W001 created

→ View Worker Trust Network
  Enter Worker ID: W001
  
  ============================================================
                  Trust Network for W001
  ============================================================
  
  Total Vouches: 1
  Average Rating: 4.5/5.0
  
  Employers who vouched:
  ABC Construction (E001)
    Rating: 4.5/5.0
    Comment: Excellent work quality

→ View Top Workers
  1. W001
     Vouches: 1
     Rating: 4.5/5.0
```

**What's Happening**:
- Graph creates relationships between workers and employers
- Track trust/reputation through vouches
- Find top-rated workers

---

### **Option 4: View System Statistics**

Shows overall statistics:
```
=== Worker Statistics ===
Total: 5, Active: 4, Inactive: 1, Avg Vouches: 2.50, Avg Rating: 4.20

=== Job Statistics ===
Total Job Entries: 12

=== Trust Network Statistics ===
Network Vertices: 8
```

---

## 🎯 Complete Example - Using All Features

### **Scenario**: Build a worker's complete profile

```
STEP 1: Add a worker
Menu → 1 (Worker Management) → 1 (Add Worker)
- ID: W001
- Name: Ramesh Kumar
- Email: ramesh@example.com
- Contact: +94701234567
- Skills: Electrical Wiring, Solar Installation
- Location: Colombo
✓ Added

STEP 2: Add their job history
Menu → 2 (Job Management) → 1 (Add Job)
- Worker ID: W001
- Employer: Solar Tech Ltd
- Job Title: Senior Electrician
- Description: Installed solar panels
- Start: 2022-06-01
- End: 2024-01-31
- Current: No
✓ Added

STEP 3: View their experience
Menu → 2 → 3
- Shows: 1 year and 7 months of experience
✓ Calculated

STEP 4: Create a vouch
Menu → 3 (Trust Network) → 1 (Add Employer)
- Employer ID: E001
- Employer Name: Solar Tech Ltd
✓ Added

Menu → 3 → 2 (Create Vouch)
- Worker ID: W001
- Employer ID: E001
- Comment: Excellent electrician, very reliable
- Rating: 4.8
✓ Vouch created

STEP 5: View trust network
Menu → 3 → 3 (View Trust Network)
- Shows: Vouches from Solar Tech Ltd
- Shows: 4.8/5.0 rating
✓ Success!

STEP 6: View statistics
Menu → 4
- Shows all system stats
✓ Complete profile built!
```

---

## 💾 Data Persistence

When you run the application, it creates JSON files:
```
worker_profiles.json    ← Stores all worker profiles
job_histories.json      ← Stores all job entries
trust_network.json      ← Stores all vouches
```

These files **persist between runs**! Data is saved automatically.

---

## 🚀 Quick Start Commands

### **Step 1: Extract ZIP**
```bash
unzip trustwork_complete.zip
cd trustwork_complete
```

### **Step 2: Open in VS Code**
```bash
code .
```

### **Step 3: Open Terminal (Ctrl + `)**

### **Step 4: Compile All Java Files**
```bash
javac -d bin -cp bin src/utils/*.java
javac -d bin -cp bin src/member1/*.java
javac -d bin -cp bin src/member2/*.java
javac -d bin -cp bin src/member3/*.java
javac -d bin -cp bin src/TrustWorkApplication.java
```

### **Step 5: Run Application**
```bash
java -cp bin TrustWorkApplication
```

**Tool opens! You can now interact with it!** 🎉

---

## ✨ Key Features

✅ **3 Data Structures**: AVL Tree, DLL, Graph
✅ **2000+ Lines**: Professional Java code
✅ **Interactive Menu**: Easy to navigate
✅ **Data Validation**: Prevents bad input
✅ **Formatted Output**: Beautiful console display
✅ **Persistent Storage**: Saves data to JSON files
✅ **O(log n) Operations**: Fast and efficient
✅ **Real-world Use**: Practical trust network system

---

## 🎓 Learning Outcomes

After using this tool, you understand:

1. **AVL Trees**: Self-balancing, O(log n) operations
2. **Doubly Linked Lists**: Bidirectional traversal, O(1) head/tail
3. **Graphs**: Network representation, pathfinding, BFS
4. **Integration**: How 3 data structures work together
5. **Real-world Application**: Practical use cases for each DS

---

## 📊 Complexity Analysis

| Operation | Data Structure | Time | Space |
|-----------|---|---|---|
| Add Worker | AVL Tree | O(log n) | O(1) |
| Search Worker | AVL Tree | O(log n) | O(log n) |
| Add Job | DLL | O(1) | O(1) |
| View Job History | DLL | O(n) | O(n) |
| Create Vouch | Graph | O(1) | O(1) |
| Find Trust Path | Graph | O(V+E) | O(V) |

---

## 🎯 Usage Tips

### **Pro Tip 1: Test with Sample Data**
```
Add 3-4 workers
Add 2-3 jobs per worker
Create 5-6 vouches
View statistics

See how it all works together!
```

### **Pro Tip 2: Use Clear Names**
```
Good IDs: W001, E001, JOB-001
Bad IDs: a, xyz, !!!

Good Names: John Doe, ABC Construction
Bad Names: x, test, 123
```

### **Pro Tip 3: Try All Menu Options**
```
Each option shows different aspects
Combine them to see full picture
Experience each data structure!
```

---

## 🐛 Troubleshooting

### **Issue**: "Cannot find symbol"
```bash
# Compile in correct order:
javac -d bin -cp bin src/utils/*.java       # FIRST
javac -d bin -cp bin src/member1/*.java     # SECOND
javac -d bin -cp bin src/member2/*.java     # THIRD
javac -d bin -cp bin src/member3/*.java     # FOURTH
javac -d bin -cp bin src/TrustWorkApplication.java  # LAST
```

### **Issue**: "NoClassDefFoundError"
```bash
# Use correct classpath:
java -cp bin TrustWorkApplication
# NOT: java TrustWorkApplication
```

### **Issue**: Menu doesn't work
```bash
# Make sure bin folder has .class files:
ls bin/
# Should show many .class files
```

---

## 📚 File Descriptions

### Utils (Shared)
- **Validator.java**: Validates all inputs
- **DateTimeHelper.java**: Handles dates and times
- **DisplayFormatter.java**: Formats console output
- **FileManager.java**: Saves/loads data

### Member 1 (AVL Tree)
- **AVLTree.java**: Complete AVL Tree implementation
- **WorkerProfile.java**: Worker data class
- **WorkerProfileManager.java**: Manages workers using AVL Tree

### Member 2 (DLL)
- **DoublyLinkedList.java**: Complete DLL implementation
- **JobEntry.java**: Job data class
- **JobHistoryManager.java**: Manages jobs using DLL

### Member 3 (Graph)
- **Graph.java**: Complete Graph implementation
- **VouchRecord.java**: Vouch data class
- **TrustNetworkManager.java**: Manages trust network using Graph

### Main
- **TrustWorkApplication.java**: Menu and orchestration

---

## ✅ Ready to Use!

This complete package includes:
✅ All source code (14 Java files)
✅ All 3 data structures
✅ Working application
✅ No external dependencies
✅ Ready to compile
✅ Ready to run
✅ Fully functional

Just extract, compile, and run!

---

## 🎉 Next Steps

1. Extract ZIP
2. Open in VS Code
3. Compile with javac commands
4. Run with java command
5. See the interactive tool!
6. Test all features
7. Explore the code
8. Understand the data structures

**Enjoy using TrustWork!** 🚀

---

**Questions?** Check the code comments or README files.

**Version**: 1.0 Complete  
**Status**: Ready for Use ✅  
**Total Lines**: 2000+ lines of Java code  
**Data Structures**: 3 (AVL Tree, DLL, Graph)
