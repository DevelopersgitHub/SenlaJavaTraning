package task2_3;

public class CreatureThirdPart implements ILineStep{
    public IProductPart buildProductPart() {
        System.out.println("Двигатель прибыл");
        return new ProductTower("двигатель") ;
    }
}
