package task2_3;

public class CreatureThirdPart implements ILineStep{
    public IProductPart buildProductPart() {
        System.out.println("��������� ������");
        return new ProductTower("���������") ;
    }
}
