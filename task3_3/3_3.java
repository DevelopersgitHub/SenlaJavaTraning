package task3;

import java.util.*;

public class Flower{
    private int flowerPrice = 0;    
    private String flowerName = "rose";
    
    Flower(String fName, int price){
        this.setPrice(price);
        this.setName(fName);
    }
    
    public void setName(String name){
        flowerName = name;
    }
    
    public String getName(){
        return flowerName;
    }
    
    public void setPrice(int price){
        flowerPrice = price;
    }
    
    public int getPrice(){
        return flowerPrice;
    }
    
    public static void main(String[] args){
        Bouquet bouquet = new Bouquet();
        
        Flower rose = new Flower("rose", 100);
        bouquet.addBouquet(rose);
        
        Flower tulip = new Flower("tulip", 50);
        bouquet.addBouquet(tulip);
        
        Flower rose_2 = new Flower("rose", 200);
        bouquet.addBouquet(rose_2);
        
        bouquet.printChecks();
    }
}

class Bouquet{
    public int totalPrice = 0;
    private List<Flower> objectArray = new ArrayList<Flower>();
    
    Bouquet(){
        
    }
       
    void addBouquet(Flower object){
        objectArray.add(object);  
    }
    
    void printChecks(){
        System.out.println("Value \t Price");
        
        for(int i = 0; i < objectArray.size(); i++){
            Flower object = objectArray.get(i);
            String name = object.getName();
            int price = object.getPrice();
            System.out.println(name + " \t " + price);
            totalPrice += price;                        
        }
        
        System.out.println("Total \t " + totalPrice);
        
    }
}