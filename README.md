This project is a simple shell simulation written in java.
It simulates basic shell functionality by supporting common file system commands like navigating directories, creating files/folders, and listing contents.
## How to compile
javac src/MiniShell.java src/ShellCommandHandler.java
## 💡 Example 

> pwd  
Current Directory: ...  

> mkdir test  
Directory created: ...

> cd test  
Changed directory to: ...

> touch file.txt  
File created: ...

> ls  
file.txt

> help  
Supported commands:
pwd, ls, cd, mkdir, touch, help, exit