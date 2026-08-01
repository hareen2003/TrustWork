# QUICK START GUIDE - TrustWork Complete

## ⚡ 5-Minute Setup

### **STEP 1: Extract ZIP** (30 seconds)

**Windows**:
```bash
Expand-Archive -Path trustwork_complete.zip -DestinationPath .
cd trustwork_complete
```

**Mac/Linux**:
```bash
unzip trustwork_complete.zip
cd trustwork_complete
```

---

### **STEP 2: Open VS Code** (30 seconds)

```bash
code .
```

This opens the folder in VS Code with all files visible.

---

### **STEP 3: Open Terminal in VS Code** (15 seconds)

**Keyboard**: Press `Ctrl + `` (backtick)

Or: **Menu** → Terminal → New Terminal

A terminal appears at the bottom.

---

### **STEP 4: Compile All Java** (1 minute)

**Copy and paste this ENTIRE command into VS Code terminal:**

**For Windows**:
```bash
javac -d bin -cp bin src\utils\*.java && javac -d bin -cp bin src\member1\*.java && javac -d bin -cp bin src\member2\*.java && javac -d bin -cp bin src\member3\*.java && javac -d bin -cp bin src\TrustWorkApplication.java
```

**For Mac/Linux**:
```bash
javac -d bin -cp bin src/utils/*.java && javac -d bin -cp bin src/member1/*.java && javac -d bin -cp bin src/member2/*.java && javac -d bin -cp bin src/member3/*.java && javac -d bin -cp bin src/TrustWorkApplication.java
```

**Wait for it to finish** (20-30 seconds). No errors = success!

---

### **STEP 5: Run Application** (15 seconds)

```bash
java -cp bin TrustWorkApplication
```

**You'll see**:
```
============================================================
        Welcome to TrustWork - Main Menu
============================================================

1. Worker Profile Management
2. Job History Management
3. Trust Network Management
4. View System Statistics
5. Exit

Select an option (1-5): 
```

**Tool is now RUNNING!** ✅

---

## 🎮 Now You Can Use It!

Type numbers and follow prompts:

```
Select an option (1-5): 1

--- Worker Profile Management ---
1. Add New Worker
2. Search Worker by ID
3. View All Workers
4. Back to Main Menu

Select an option (1-4): 1

--- Add New Worker ---
Enter Worker ID: W001
Enter Full Name: John Doe
Enter Email: john@example.com
Enter Contact Number: +94701234567
Enter Location: Colombo
Enter Skills (comma-separated): Carpentry, Welding
✓ Worker W001 added successfully
```

**The tool works!** 🎉

---

## 📋 What You Can Do

### Option 1: Add Workers
- Create worker profiles
- Store skills and location
- Track experience

### Option 2: Add Jobs
- Track job history
- Calculate experience
- View chronologically

### Option 3: Create Vouches
- Build trust network
- Rate workers
- See top workers

### Option 4: View Statistics
- See overall system stats
- Worker counts
- Network information

---

## ✨ Understanding What's Happening

When you run it:

```
1. Menu System Loads
   ↓
2. You Select Option (1-5)
   ↓
3. Submenu Appears
   ↓
4. You Enter Data
   ↓
5. Data Gets Processed (AVL Tree / DLL / Graph)
   ↓
6. Results Display
   ↓
7. Back to Main Menu
   ↓
8. Repeat or Exit
```

---

## 🎯 Test Workflow

Follow this to see everything work:

```
1. Menu → 1 (Worker Management)
   → Add New Worker
   → Enter: W001, John Doe, john@example.com, +94XXXXXXXXX, Colombo, Carpentry
   ✓ Stored in AVL Tree!

2. Menu → 2 (Job Management)
   → Add Job Entry
   → Enter: W001, ABC Construction, Carpenter, 2023-01-01, 2024-01-01, no
   ✓ Stored in Doubly Linked List!

3. Menu → 3 (Trust Network)
   → Add Employer → E001, ABC Construction
   → Create Vouch → W001, E001, "Great work", 4.5
   ✓ Stored in Graph!

4. Menu → 3
   → View Top Workers
   ✓ See your worker ranked!

5. Menu → 4
   ✓ See all statistics!
```

Done! You've used all 3 data structures! 🎉

---

## 💾 Data Storage

After you run the app and add data:

Files created automatically:
```
trustwork_complete/
├── worker_profiles.json    (Worker data)
├── job_histories.json      (Job data)
└── trust_network.json      (Vouch data)
```

Run the app again → **Your data is still there!**

---

## 🚨 If Something Goes Wrong

### Issue: "javac: command not found"
**Solution**: Java not installed
- Download from: https://adoptopenjdk.net/
- Verify: `java -version`

### Issue: "Cannot find symbol"
**Solution**: Compile in correct order
```bash
# Do this one by one:
javac -d bin -cp bin src\utils\*.java
javac -d bin -cp bin src\member1\*.java
javac -d bin -cp bin src\member2\*.java
javac -d bin -cp bin src\member3\*.java
javac -d bin -cp bin src\TrustWorkApplication.java
```

### Issue: Menu doesn't appear
**Solution**: Verify compilation
```bash
# Check if bin folder has files:
ls bin/
# Should show many .class files
```

---

## 🎓 What You're Learning

This tool teaches you:

1. **AVL Trees** (Worker Management)
   - Fast O(log n) lookups
   - Self-balancing trees
   - Rotations and rebalancing

2. **Doubly Linked Lists** (Job History)
   - Bidirectional traversal
   - O(1) head/tail operations
   - Chronological ordering

3. **Graphs** (Trust Network)
   - Network representation
   - BFS pathfinding
   - Rating aggregation

4. **Java Programming**
   - Object-oriented design
   - File I/O
   - Interactive applications

---

## ⏱️ Time Breakdown

| Task | Time |
|------|------|
| Extract | 30 seconds |
| Open VS Code | 30 seconds |
| Open Terminal | 15 seconds |
| Compile | 20-30 seconds |
| Run | 15 seconds |
| **TOTAL** | **~2 minutes** |

Less than 2 minutes from download to running tool!

---

## 📸 Expected Output

When running successfully:

```
javac -d bin -cp bin src\utils\*.java
(no errors, compiling...)

javac -d bin -cp bin src\member1\*.java
(no errors, compiling...)

javac -d bin -cp bin src\member2\*.java
(no errors, compiling...)

javac -d bin -cp bin src\member3\*.java
(no errors, compiling...)

javac -d bin -cp bin src\TrustWorkApplication.java
(no errors, compiling...)

java -cp bin TrustWorkApplication

============================================================
        Welcome to TrustWork - Main Menu
============================================================

1. Worker Profile Management
2. Job History Management
3. Trust Network Management
4. View System Statistics
5. Exit

Select an option (1-5): 
```

**If you see this menu, you're DONE!** ✅

---

## ✅ Checklist

- [ ] Extracted ZIP
- [ ] Opened VS Code
- [ ] Opened Terminal (Ctrl + `)
- [ ] Compiled all Java files (javac commands)
- [ ] Ran application (java command)
- [ ] Saw the menu
- [ ] Tested by adding a worker
- [ ] Tried all 3 sections

**All checked? You're a pro!** 🚀

---

## 🎉 Success!

You now have a fully working:
✅ Interactive menu application
✅ 3 integrated data structures
✅ Working demonstration
✅ Professional Java code
✅ Persistent data storage

**Enjoy exploring TrustWork!** 💻

---

## 📞 Help

1. **Check Terminal**: Look for error messages
2. **Read Comments**: Code has inline explanations
3. **Read README.md**: Full documentation
4. **Test Workflow**: Follow the example workflow

Everything works! You got this! 💪
