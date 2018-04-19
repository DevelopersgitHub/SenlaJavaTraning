package task3_2;

public class MainClass {
	    public static void main(String[] args) {
	    	int number = RandomNumber.getNumber();
	    	System.out.println("Number: " + number);
	    	int sum = 0;
	    	int currentDigit;
	    	currentDigit = number % 10;
	    	sum = sum + currentDigit;
	    	number = number / 10;
	    	currentDigit = number % 10;
	    	sum = sum + currentDigit;
	    	number = number / 10;
	    	sum = sum + number;
	    	System.out.println("Sum: " + sum);
	    }
	      
	}

