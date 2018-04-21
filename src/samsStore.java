import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class samsStore {
    private HashMap<String, Double> shoppingCart;
    private Double totalCost = 0.00;
    private ArrayList<String> list;


    public HashMap<String, Double> getShoppingCart() {
        return shoppingCart;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    samsStore(ArrayList<String> list){
        this.list = list;

    }

    public void createCart() throws IOException {

        String samsUrl ="https://www.samsclub.com/sams/search/searchResults.jsp?clubId=8226&limit=48&offset=0&searchTerm=";
        String samsEndTag = "&selectedFilter=club&sortKey=relevance&sortOrder=1&viewMode=grid";
        shoppingCart = new HashMap();

        for(String str : list){
            String url;
            StringBuilder urlCreate = new StringBuilder();
            urlCreate.append(samsUrl).append(str).append(samsEndTag);
            url  = urlCreate.toString();
            url = url.replaceAll(" ", "%20");

            System.out.println("**** " + url + " ****");
            Document doc = Jsoup.connect(url).userAgent("Chrome/65.0.3325.181").get();
            String divContentAttr = doc.select("span.hubbleTrackRecord.collapse").attr("data-price");
            Double price = Double.parseDouble(divContentAttr);
            //System.out.println("price = " + divContentAttr);
            shoppingCart.put(str, price);
            totalCost += price;

        }

    }
}
