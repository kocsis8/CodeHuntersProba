import java.util.ArrayList;

/**
 * @author Kocsis
 * ha kettőt fizet egy másik termék féláron van
 * a PricingRule valósítja meg
 */
public class BuyTwoNextHalfRule implements PricingRule {
    // változó ami a termék tárolja amiből legalább 2 kell
    String needTwo;

    // változó ami a termék ami féláron lesz ha teljesül
    String nextHalf;
    //A "kosárban" lévá termékek listáját tárolja
    private ArrayList<String> shopList;

    public BuyTwoNextHalfRule(String needTwo, String nextHalf) {
        this.needTwo = needTwo;
        this.nextHalf = nextHalf;

    }

    //teljesülnek e a vásárlási szabály feltétleit
    @Override
    public boolean isAvailable(ArrayList<String> shopList) {
        this.shopList = new ArrayList<>(shopList);
        int count1 = 0;
        int count2 = 0;
        for (String element : shopList) {
            if (element.equals(needTwo)) {
                count1++;
            }

            if (element.equals(nextHalf)) {
                count2++;
            }

        }
        return count1 >= 2 && count2 >= 1;
    }

    // a szabály végrahelytása
    @Override
    public void action(ShoppingCart obj) {
        for (int i = 0; i < 2; i++) {
            shopList.remove(needTwo);
        }
        shopList.remove(nextHalf);

        obj.setSum(obj.getSum() + obj.getProductMap().get(needTwo) * 2);
        obj.setSum(obj.getSum() + (double) (obj.getProductMap().get(nextHalf)) / 2);
        obj.setShopList(shopList);
    }
}
