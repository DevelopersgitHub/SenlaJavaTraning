package task3_3;

public class Flower{
	private String flowerName;
    private int flowerPrice = 0;    
    
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
}