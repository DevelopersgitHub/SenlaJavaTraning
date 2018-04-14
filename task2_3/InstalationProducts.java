package task2_3;

public class InstalationProducts implements IProduct{

    IProductPart body;
    IProductPart tower;
    IProductPart engine;

    InstalationProducts(ProductBody body, ProductEngine engine, ProductTower tower){
        this.body = body;
        this.engine = engine;
        this.tower = tower;
    }

    public void installFirstPart(IProductPart productPart) {
        System.out.println("Кузов установлен");
        System.out.println();
    }

    public void installSecondPart(IProductPart productPart) {
        System.out.println("Шасси установлено");
        System.out.println();
    }

    public void installThirdPart(IProductPart productPart) {
        System.out.println("Двигатель установлен");
        System.out.println();
    }

    InstalationProducts(){}
}
