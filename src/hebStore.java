import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hebStore {
    private HashMap<String, Double> shoppingCart;
    private Double totalCost = 0.00;
    private ArrayList<String> list;

    public HashMap<String, Double> getShoppingCart() {
        return shoppingCart;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    hebStore(ArrayList<String> list){
        this.list = list;
    }

    public void createCart() throws IOException {

        String hebUrl ="https://www.heb.com/search/?q=";
        String hebEndTag = "";
        shoppingCart = new HashMap();

        for(String str : list){
            String url;
            StringBuilder urlCreate = new StringBuilder();
            urlCreate.append(hebUrl).append(str).append(hebEndTag);
            url  = urlCreate.toString();
            url = url.replaceAll(" ", "+");

            System.out.println("**** " + url + " ****");
            Document doc = Jsoup.connect(url).userAgent("Chrome/65.0.3325.181").get();
           // Element price =doc.select(".responsivegriditem__price-label");
            String price2= doc.select(".cat-price").text();

//            Double price = Double.parseDouble(String.valueOf(doc.select(".cat-price").get(0).nextElementSibling().text()));
            System.out.println(price2);
//            shoppingCart.put(str, price);
//            totalCost +=price;

        }

    }
}
