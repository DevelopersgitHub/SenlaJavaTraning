package task2_3;

public class Car implements IAssemblyLine{
    public IProduct assembleProduct(IProduct iProduct) {

        ProductBody body = (ProductBody) new CreatureFirstPart().buildProductPart();
        iProduct.installFirstPart(body);

        ProductEngine ñhassis = (ProductEngine) new CreatureSecondPart().buildProductPart();
        iProduct.installSecondPart(ñhassis);

        ProductTower engine = (ProductTower) new CreatureThirdPart().buildProductPart();
        iProduct.installThirdPart(engine);

        InstalationProducts instalation = new InstalationProducts(body, ñhassis, engine);
        System.out.println("Car complete!");

        return instalation;
    }
}