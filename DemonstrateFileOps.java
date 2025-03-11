package file_io;

import java.io.File;
import java.io.IOException;

public class DemonstrateFileOps {
    public static void main(String[] args) throws IOException {
        File f = new File("abc.txt");
        //checking existence of file without creating file
        System.out.print("existence of file without creating file: ");
        System.out.println(f.exists());
        //checking existence of file after creating file
        System.out.print("existence of file after creating file: ");
        f.createNewFile();
        System.out.println(f.exists());
        //checking existence of file after deleting file
        System.out.print("existence of file after deleting file: ");
        f.delete();
        System.out.println(f.exists());
        //creating a directory and an empty file
        File f1 = new File("/Users/topb/Desktop/Core-Java/src/file_io/iamdir");
        f1.mkdir();
        File f2 = new File("/Users/topb/Desktop/Core-Java/src/file_io/iamdir","apple.txt");
        f2.createNewFile();
        System.out.println("List of all files and folders in file_io dir");
        File f3 = new File("/Users/topb/Desktop/Core-Java/src/file_io");
        String[] allData = f3.list();
        for (String s : allData){
            System.out.println(s);
        }
    }
}
