import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class unitedStore {
    private HashMap<String, Double> shoppingCart;
    private Double totalCost = 0.00;
    private ArrayList<String> list;

    public HashMap<String, Double> getShoppingCart() {
        return shoppingCart;
    }

    public Double getTotalCost() {
        return totalCost;
    }

   unitedStore(ArrayList<String> list){
        this.list = list;
    }

    public void createCart() throws IOException {

        String unitedUrl ="https://storefront.shop.theunitedfamily.com/store/7CD8127082/#/search/";
        String unitedEndTag = "";
        shoppingCart = new HashMap();

        for(String str : list){
            String url;
            StringBuilder urlCreate = new StringBuilder();
            urlCreate.append(unitedUrl).append(str).append(unitedEndTag);
            url  = urlCreate.toString();
            url = url.replaceAll(" ", "%20");

            System.out.println("**** " + url + " ****");
            Document doc = Jsoup.connect(url).userAgent("Chrome/65.0.3325.181").get();
            Element el = doc.select("#content > div > div.main > ul > li:nth-child(1) > div.product__itemContent > div.priceInfo > span.priceInfo__price.priceInfo__price--current").first();
            String el2 = el.html().replace("<!--", "").replace("-->", "");

            Document elWithoutComments = Jsoup.parse(el2);
            Element elem = elWithoutComments.select("div.priceInfo >span.priceInfo__price priceInfo__price--current").first();
            System.out.println(elem.text());

            //System.out.println(doc.select("div.priceInfo > span.priceInfo__price priceInfo__price--current").text());
//            System.out.println(price);
//            shoppingCart.put(str, price);
//            totalCost +=price;

        }

    }
}
