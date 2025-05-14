import java.io.File;
import java.io.IOException;
public class ShellCommandHandler{

        private File currentDirectory; //תיקייה נוכחית שהמשתמש נמצא בה כרגע
        public ShellCommandHandler(){ //קובע את התיקייה הנוכחית לתיקיית העבודה
            this.currentDirectory= new File(System.getProperty("user.dir"));
        }

        public void printWorkingDirectory(){//מציג את הנתיב המלא של התיקייה הנוכחית
            System.out.println("Current Directory: "+currentDirectory.getAbsolutePath());
        }

        public void listDirectory(){ //מציג את כל הקבצים והתיקיות בתיקייה הנוכחית
            String[] files =currentDirectory.list();
            if (files != null) {
                System.out.println("Files and directories in "+currentDirectory.getAbsolutePath()+":");
                for (String file : files) {
                    System.out.println(file);
                }
            }else{
                System.out.println("The directory is empty or an error occurred");
            }
        }
        public void changeDirectory(String name){ //משנה תיקייה נוכחית(cd(
            File newDirectory=new File(currentDirectory, name);
            if (newDirectory.isDirectory()) {
                currentDirectory=newDirectory;
                System.out.println("Changed directory to:" +currentDirectory.getAbsolutePath());
            } else {
                System.out.println("No such directory:" + name);
            }
        }

        public void makeDirectory(String name){ // יוצרת תיקייה חדשה
            File newDir=new File(currentDirectory, name);
            if (newDir.mkdir()){
                System.out.println("Directory created: " + newDir.getAbsolutePath());
            }else{
                System.out.println("Failed to create directory: " + name);
            }
        }

        public void createFile(String name){ //יוצת קובץ חדש
            File newFile=new File(currentDirectory, name);
            try{
                if (newFile.createNewFile()){
                    System.out.println("File created: "+newFile.getAbsolutePath());
                }else{
                    System.out.println("File already exists:" + name);
                }
            }catch (IOException e) {
                System.out.println("Error creating file:" + e.getMessage());
            }
        }
        public void printHelp() {//מציגה את הפקודות הנתמכות
            System.out.println("Supported commands:");
            System.out.println("pwd- Print working directory");
            System.out.println("ls- List directory contents");
            System.out.println("cd <directory> - Change directory");
            System.out.println("mkdir <directory> - Create a new directory");
            System.out.println("touch <file> - Create a new file");
            System.out.println("help- Show this help message");
            System.out.println("exit- Exit the shell");
        }
        public File getCurrentDirectory() {//מחזירה את התיקייה הנוכחית
            return currentDirectory;
        }
    }

