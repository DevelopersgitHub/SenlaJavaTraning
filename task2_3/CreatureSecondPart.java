package task2_3;

public class CreatureSecondPart implements ILineStep {
    public IProductPart buildProductPart() {
        System.out.println("����� �������");
        return new ProductEngine("�����");
    }
}

