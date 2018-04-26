import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.apache.commons.io.FileUtils;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        String fileName = "heb.html";
        BufferedWriter writer;
        String url;
        StringBuilder urlCreate = new StringBuilder();

        for(String str : list){

            urlCreate.append(hebUrl).append(str).append(hebEndTag);
            url = urlCreate.toString();
            url = url.replaceAll(" ", "+");

            System.out.println("**** " + url + " ****");

            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            writer = new BufferedWriter(new FileWriter(fileName));

            String inputLine;
            while((inputLine = in.readLine()) != null){
                try{
                    writer.write(inputLine);
                }catch(IOException e){
                    e.printStackTrace();
                    return;
                }
            }in.close();
            writer.close();




            //            final Connection.Response response = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36").execute();
//            final Document doc = response.parse();
//
//            final File f = new File(fileName);
//            FileUtils.writeStringToFile(f, doc.outerHtml(),"UTF-8");


            //Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36").get();



//            try{
//                writer = new BufferedWriter(new FileWriter("heb.html"));
//                writer.write(doc.toString());
//            }catch(IOException e){

            }
//
//            File file = new File(fileName);
//            try{
//                Scanner scan = new Scanner(file);
//
//                while(scan.hasNextLine()){
//                    String line = scan.nextLine();
//                    if(line.contains())
//                }
//            }
//

           // Element price =doc.select(".responsivegriditem__price-label");
           // String price2= doc.select(".cat-price").text();

//            Double price = Double.parseDouble(String.valueOf(doc.select(".cat-price").get(0).nextElementSibling().text()));
           // System.out.println(price2);
//            shoppingCart.put(str, price);
//            totalCost +=price;

        }

    }

