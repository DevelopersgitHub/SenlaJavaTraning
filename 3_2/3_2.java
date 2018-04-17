package task3;

import java.util.Random;

public class Main {
 
    public static void main(String[] args) {
    	Random rnd = new Random(System.currentTimeMillis());
    	
    	int number = 100 + rnd.nextInt(999-100);
    	System.out.println("—èñëî: " + number);
    	
    	int sum = 0;
    	
    	int currentDigit;
    	
    	currentDigit = number % 10;
    	sum = sum + currentDigit;
    	
    	number = number / 10;
    	
    	currentDigit = number % 10;
    	sum = sum + currentDigit;
    	
    	number = number / 10;
    	
    	sum = sum + number;
    	
    	System.out.println("‘óììà: " + sum);
    }
      
}