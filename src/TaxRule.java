import java.util.ArrayList;
import java.util.Collections;

/**
 * Extra adót megvalósítő osztályt
 * a PricingRule valósítja meg
 *
 * @author Kocsis
 */
public class TaxRule implements PricingRule {
    //termékek litályát tárolja ami mitt extra adót kell fizetni
    private ArrayList<String> conditionList = new ArrayList<>();
    //az adó mértékét tárolja
    private double tax;
    //A "kosárban" lévá termékek listáját tárolja
    private ArrayList<String> shopList = new ArrayList<>();

    public TaxRule(String[] conditionList, double tax) {
        Collections.addAll(this.conditionList, conditionList);
        this.tax = tax;

    }

    //teljesülnek e a vásárlási szabály feltétleit
    @Override
    public boolean isAvailable(ArrayList<String> shopList) {
        this.shopList = new ArrayList<>(shopList);
        return shopList.containsAll(conditionList);
    }

    // a szabály végrahelytása
    @Override
    public void action(ShoppingCart obj) {
        obj.setSum(obj.getSum() * (1 + (tax / 100)));
    }
}
