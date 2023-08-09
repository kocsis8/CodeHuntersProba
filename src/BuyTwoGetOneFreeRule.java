import java.util.ArrayList;

/**
 * @author Kocsis
 * 2 fizet 3 vihet szabály megvalósítása priceing interface inplemetálása
 */
public class BuyTwoGetOneFreeRule implements PricingRule {
    // változó ami a termék amire a szabály vonatkozik
    private String targetedProduct;
    //A "kosárban" lévá termékek listáját tárolja
    private ArrayList<String> shopList;

    public BuyTwoGetOneFreeRule(String product) {
        this.targetedProduct = product;

    }

    //teljesülnek e a vásárlási szabály feltétleit
    @Override
    public boolean isAvailable(ArrayList<String> shopList) {
        this.shopList = new ArrayList<>(shopList);
        int count = 0;
        for (String element : shopList) {
            if (element.equals(targetedProduct)) {
                count++;
            }
        }

        return count >= 3;
    }

    // a szabály végrahelytása
    @Override
    public void action(ShoppingCart obj) {
        for (int i = 0; i < 3; i++) {
            shopList.remove(targetedProduct);
        }

        obj.setSum(obj.getSum() + obj.getProductMap().get(targetedProduct) * 2);
        obj.setShopList(shopList);

    }


}
