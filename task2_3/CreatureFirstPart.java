package task2_3;

public class CreatureFirstPart implements ILineStep{
    public IProductPart buildProductPart() {
        System.out.println("����� ������");
        return new ProductBody("�����");
    }
    }
