package task3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
 
    public static void main(String[] args) throws IOException{
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String string;
        System.out.print("Enter string: ");
        string = buffer.readLine();
        string = CleanLine.cleanedLine(string);
        Sort.sortList(string);
    }
    
}
   