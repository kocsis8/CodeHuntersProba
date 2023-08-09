import java.util.*;

/**
 * @author Kocsis
 * "Bevárálókocsi"-t megvalósító osztály
 */
public class ShoppingCart {
    //termékek neve és árai tároló Map
    private final Map<String, Integer> productMap;
    // alkalmazandó vásárlási szabályok listálya
    private final List<PricingRule> pricingRules;
    // "kosárban" lévő termékek listálya
    private ArrayList<String> shopList = new ArrayList<>();
    // végösszeget tároló változó
    private double sum = 0;

    public ShoppingCart(Map<String, Integer> productMap, List<PricingRule> pricingRules, String[] shopList) {
        this.productMap = productMap;
        this.pricingRules = pricingRules;
        Collections.addAll(this.shopList, shopList);
    }

    //gettrek és setterek
    public void setShopList(ArrayList<String> shopList) {
        this.shopList = shopList;
    }

    public Map<String, Integer> getProductMap() {
        return productMap;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }


    //végösszeget visszaadó függvény
    public double ShoppingCartAmount() {
        boolean pusTax = pricingRules.get(pricingRules.size() - 1).isAvailable(shopList);

        for (int i = 0; i < pricingRules.size() - 1; i++) {
            while (pricingRules.get(i).isAvailable(shopList)) {
                System.out.println(pricingRules.get(i) + ": " + pricingRules.get(i).isAvailable(shopList));
                pricingRules.get(i).action(this);
            }

        }

        for (int i = 0; i < shopList.size(); i++) {
            sum += productMap.get(shopList.get(i));
        }


        if (pusTax) {
            pricingRules.get(pricingRules.size() - 1).action(this);
        }
        return sum;
    }
}
