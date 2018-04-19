package task3_3;

public class MainClass {
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
