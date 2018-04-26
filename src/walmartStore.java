import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        String url;
        StringBuilder urlCreate = new StringBuilder();
        BufferedWriter writer;



        // Iterate through each item in the list and add to shopping cart
        for(String str : list){

            urlCreate.append(walmartUrl).append(str).append(walmartEndTag);
            url = urlCreate.toString();
            url = url.replaceAll(" ", "%20");

            //Create HTML file
            System.out.println("**** " + url + " ****");
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                    .get();


            try{
                writer = new BufferedWriter( new FileWriter("walmart.html"));
                writer.write(doc.toString());
            }catch(IOException e){

            }

            //Get price from file

            File file = new File("walmart.html");
            try{
                Scanner scan = new Scanner(file);

                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    if(line.contains("offerPrice")){
                        String s = line.substring(line.indexOf("offerPrice\":"+1));
                        s = s.substring(s.indexOf(":")+1);
                        s = s.substring(0, s.indexOf(","));
                        Double price = Double.parseDouble(s);

                        shoppingCart.put(str, price);
                        totalCost += price;


                    }

                }
            }catch(FileNotFoundException e){
                System.out.println("No file found matching name...");
            }



            {
               // String test = doc.select("span.Price-group").attr("aria-label");
            }


        }

    }
}
