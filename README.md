## 🚀 How to Build
This is a Maven project. To build:

```bash
mvn clean install

**Running the Program**

There are two entry points provided:

1. Run with Console Input (Main2.java)

This version reads input from standard input (stdin).

Run:

mvn compile
mvn exec:java -Dexec.mainClass="Main"


Then type/paste the input followed by Enter + Ctrl+D (Linux/Mac) or Enter + Ctrl+Z (Windows) to signal EOF.

**Example:**

5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL

**Output:**

1 1 E
3 3 N LOST
2 3 S

**2. Run with File Input (MainFromFile.java)**

This version reads input from a text file (helpful if console input is problematic).

Create an input file, e.g. input.txt:

5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL


Run the program by passing the file path as an argument:

mvn compile
mvn exec:java -Dexec.mainClass="MainFromFile" -Dexec.args="input.txt"
