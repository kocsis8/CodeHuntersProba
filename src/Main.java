import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program belépési osztálya
 *
 * @author Kocsis
 */
public class Main {
    public static void main(String[] args) {


//Termékek map-ja név és ár kulcs értékpárosával, bővíthető
        Map<String, Integer> productMap = new HashMap<>();
        productMap.put("A", 55);
        productMap.put("B", 20);
        productMap.put("C", 60);
        productMap.put("D", 10);
        productMap.put("E", 45);

// Szabályok listája bővíthető tetszőlegesen
        List<PricingRule> pricingRules = new java.util.ArrayList<>(List.of(
                new BuyTwoNextHalfRule("A", "C"),
                new BuyTwoGetOneFreeRule("D")
        ));
//Extra adó szabály módosítható. Utolag a listáhos füzve, hogy ne akadjon üssze a rendes szabályokkal
        pricingRules.add(new TaxRule(new String[]{"E", "D"}, 30));

// "bevásárló kocsi" példányosítás
        ShoppingCart cart = new ShoppingCart(productMap, pricingRules, args);
//"kocsi"-ban lévő termékek összegének kiiratása
        System.out.println(cart.ShoppingCartAmount());

    }
}