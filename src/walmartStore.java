import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class walmartStore {
    private HashMap<String, Double> shoppingCart;
    private Double totalCost = 0.00;
    private ArrayList<String> list;


    public HashMap<String, Double> getShoppingCart() {
        return shoppingCart;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    walmartStore(ArrayList<String> list){
        this.list = list;

    }

    public void createCart() throws IOException {

        String walmartUrl ="https://www.walmart.com/search/?query=";
        String walmartEndTag = "&cat_id=0";
        shoppingCart = new HashMap();

        for(String str : list){
            String url;
            StringBuilder urlCreate = new StringBuilder();
            urlCreate.append(walmartUrl).append(str).append(walmartEndTag);
            url  = urlCreate.toString();
            url = url.replaceAll(" ", "%20");

            System.out.println("**** " + url + " ****");
            Document doc = Jsoup.connect(url).userAgent("Chrome/65.0.3325.181").get();
            Double price = Double.parseDouble(doc.select("span.Price-group").attr("aria-label").replace("$",""));
            System.out.println(price);
            shoppingCart.put(str, price);
            totalCost +=price;

        }

    }
}
