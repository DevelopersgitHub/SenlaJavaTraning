package task3;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Sort {
 
    public static void main(String[] args) throws IOException{
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String string;
        System.out.print("¬ведите строку: ");
        string = buffer.readLine();
        
        string = cleanedLine(string);
        sortMas(string);
       
    }
    
    public static String cleanedLine(String line) {
        
        line = line.replaceAll("\\p{Punct}", "");        
        line = line.replaceAll("[0-9]", "");                    
        return line;
    }
    
    public static void sortMas(String line) {
        ArrayList<String> alphabet = new ArrayList<String>();          
        
        String[] mas = line.split(" ");
        for(int i = 0; i < mas.length; ++i)
            alphabet.add(mas[i]);                                       
        
        Collections.sort(alphabet);                                          
        
        System.out.print("ќтсортированный массив:\n");
        for(String str : alphabet)                                         
            System.out.println(str); 
        
        String max = Collections.max(alphabet, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println("Ёлемент с максимальной длинной: " + max);
        
    }
    
    
}