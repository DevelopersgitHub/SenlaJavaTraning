package task3_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
	 public static void sortList(String line) {
	        ArrayList<String> alphabet = new ArrayList<String>();          
	        
	        String[] mas = line.split(" ");
	        for(int i = 0; i < mas.length; ++i)
	            alphabet.add(mas[i]);                                       
	        
	        Collections.sort(alphabet);                                          
	        
	        System.out.print("Sorted array:\n");
	        for(String str : alphabet)                                         
	            System.out.println(str); 
	        String max = Collections.max(alphabet, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.length() - o2.length();
	            }
	        });

	        System.out.println("Element with maximum length: " + max);
	        }
	 }
