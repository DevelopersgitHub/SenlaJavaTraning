package task2_3;

public class Car implements IAssemblyLine{
    public IProduct assembleProduct(IProduct iProduct) {

        ProductBody body = (ProductBody) new CreatureFirstPart().buildProductPart();
        iProduct.installFirstPart(body);

        ProductEngine �hassis = (ProductEngine) new CreatureSecondPart().buildProductPart();
        iProduct.installSecondPart(�hassis);

        ProductTower engine = (ProductTower) new CreatureThirdPart().buildProductPart();
        iProduct.installThirdPart(engine);

        InstalationProducts instalation = new InstalationProducts(body, �hassis, engine);
        System.out.println("Car complete!");

        return instalation;
    }
}