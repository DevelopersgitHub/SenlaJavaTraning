package task3_3;

import java.util.ArrayList;
import java.util.List;

public class Bouquet{
    public int totalPrice = 0;
    private List<Flower> objectArray = new ArrayList<Flower>();
    
    Bouquet(){}
       
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