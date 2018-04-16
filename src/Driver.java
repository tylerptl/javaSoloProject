import java.util.ArrayList;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws Exception {
//        String url = "https://stackoverflow.com/questions/2835505";
//        Document document = Jsoup.connect(url).get();
//
//        String question = document.select("#question .post-text").text();
//        System.out.println("Question: " + question);
//
//        Elements answerers = document.select("#answers .user-details a");
//        for (Element answerer : answerers) {
//            System.out.println("Answerer: " + answerer.text());
//        }

        ////////////////////////
//        String url = "http://www.amazon.com/DJI-CP-PT-000498-Mavic-Drohne-grau/dp/B01M0AVO1P/";
//        Document document = Jsoup.connect(url).userAgent("Mozilla/49.0").get();
//        Elements question = document.select("#priceblock_ourprice");
//        System.out.println("Price is " + question.html());

//        StringBuilder url = new StringBuilder();
//        String walmartUrl ="https://www.walmart.com/search/?query=";
//        String walmartEndTag = "&cat_id=0";
//
//        //Get search term
//
//        System.out.println("Search for...");
//        Scanner input = new Scanner(System.in);
//        String searchTerm = input.nextLine();
//
//        //Replace blank spaces with %20
//        url.append(walmartUrl).append(searchTerm).append(walmartEndTag);
//        String urlSpaces = url.toString();
//        urlSpaces = urlSpaces.replaceAll(" ","%20");
//
//        System.out.println("**** " + urlSpaces + " ****");
//        Document doc = Jsoup.connect(urlSpaces).userAgent("Mozilla/49.0").get();
//        int count = 0;
//        System.out.println(doc.select(".Price-group").attr("aria-label"));


        Scanner kb = new Scanner(System.in);
        String input;
        ArrayList<String> list = new ArrayList<>();


        System.out.println("Enter what you would like to search for - be precise. Enter blank space to end search.");
        while ((input = kb.nextLine()).length() > 0) {
            list.add(input);

        }
        if(!list.isEmpty()) {
            walmartStore walmartStore = new walmartStore(list);
            walmartStore.createCart();
            System.out.println("Walmart: ");
            System.out.println("Total cost: " + walmartStore.getTotalCost());
            System.out.println("Shopping cart: " + walmartStore.getShoppingCart());
            System.out.println("\n\n");


            hebStore hebStore = new hebStore(list);
            hebStore.createCart();
            System.out.println("HEB: ");
            System.out.println("Total cost: " + hebStore.getTotalCost());
            System.out.println("Shopping cart: " + hebStore.getShoppingCart());
            System.out.println("\n\n");
//        unitedStore unitedStore = new unitedStore(list);
//        unitedStore.createCart();


//System.out.println("United: ");
//System.out.println("Total cost: " + unitedStore.getTotalCost());
//System.out.println("Shopping cart: " +unitedStore.getShoppingCart());

            samsStore samsStore = new samsStore(list);
            samsStore.createCart();
            System.out.println("Sams: ");
            System.out.println("Total cost: " + samsStore.getTotalCost());
            System.out.println("Shopping cart: " + samsStore.getShoppingCart());


//            String mStreet = "https://storefront.shop.theunitedfamily.com/store/7CD8127082/#/search/coke";
//            Document mStreetDoc = Jsoup.connect(mStreet).userAgent("Mozilla/49.0").get();
//            Elements question3 = mStreetDoc.select("div.priceInfo");
//            System.out.println("Market price is " + question3.html());

//
//        String webPage = "https://www.samsclub.com/sams/search/searchResults.jsp?searchTerm=coke%202%20liter&searchCategoryId=all&xid=hdr_search-typeahead_coke%202%20liter";
//        Document doc = Jsoup.connect(webPage).get();
//        Elements temp = doc.select(".body > div.js-content > div > div.sc-fixed-width > div > div > div:nth-child(2) > div.sc-pdp-col-2 > div.sc-moneybox-has-flag > div > div > div.sc-channel-container > div.sc-channel-container-channels > div > div:nth-child(1) > div > div > span > span");// Use # for id instead of . for class
//        Element temp2 = doc.select(".body > div.js-content > div > div.sc-fixed-width > div > div > div:nth-child(2) > div.sc-pdp-col-2 > div.sc-moneybox-has-flag > div > div > div.sc-channel-container > div.sc-channel-container-channels > div > div:nth-child(1) > div > div > span > span");
//
//        int i = 0;
//
//        for(Element e : temp){
//            i++;
//            System.out.println("#"+i );
            //*[@id="productCard-prod9600433"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/span/span
        }else{
            System.out.println("list is empty...");
        }
    }

}
