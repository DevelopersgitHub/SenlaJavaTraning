package com.senla.training.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class MainClass {

	public static void main(String s[]) throws Exception{
		
		
		
		/*Book book1 = new Book(1L, "Book1", "19/05/2009", 10.23,1L);
		Book book2 = new Book(2L, "Book2","19/05/2009", 10.23,0L);
		Book book3 = new Book(3L, "Book3","19/05/2009", 10.23,1L);
		Book book4 = new Book(4L, "Book4","19/05/2009", 10.23,1L);
		
	
		
		final Book[] persons = new Book[]{ book1, book2, book3, book4 };*/
		
		final FileUtil<Book> util = new BookFileUtil();
		
		/*util.writeToFile(persons);*/
		
		/*System.out.println("initial array");
		for (int i = 0; i < persons.length; i++ ){
			System.out.println(persons[i]);
		}
		*/
		final Book[] readedValues = util.readFromFile();
		
		System.out.println("Список книг: ");
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}
		
		/*System.out.println("Сортировка по алфавиту: ");
		

		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getNameBook().compareTo(o2.getNameBook());
		        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}
		
		System.out.println("Сортировка по дате издания: ");
		

		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getDatePublic().compareTo(o2.getDatePublic());
		        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}*/
	
		System.out.println("Сортировка по стоимости: ");
		Arrays.sort(Book.getCost());
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}	
		/*System.out.println("Сортировка по наличию: ");
		

		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getPresence().compareTo(o2.getPresence());
		        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}*/
	}
}
	
