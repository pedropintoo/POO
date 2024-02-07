package test.TestePratico;

public class StandardShippingCostCalculator implements ShippingCostCalculator{

    @Override
    public double calculateShippingCost(Package pkg) {
        if(pkg.getWeight() < 5){
            return pkg.getWeight();
        }
        else if(pkg.getWeight() > 10){
            return pkg.getWeight() * 3;
        }
        else return pkg.getWeight() * 2;
    }
}
