import java.util.ArrayList;


public interface PricingRule {
    boolean isAvailable(ArrayList<String> shopList);

    void action(ShoppingCart obj);
}
