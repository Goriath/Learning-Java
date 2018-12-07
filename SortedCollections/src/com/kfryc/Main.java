package com.kfryc;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.89, 100);
        stockList.addStock(temp);

        temp = new StockItem("pie", 2.99, 8);
        stockList.addStock(temp);

        temp = new StockItem("car toy", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("hair", 49.99, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.59, 200);
        stockList.addStock(temp);

        temp = new StockItem("pot", 22.99, 8);
        stockList.addStock(temp);

        temp = new StockItem("pan", 25.99, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.99, 20);
        stockList.addStock(temp);

        temp = new StockItem("towel", 5.15, 14);
        stockList.addStock(temp);

        temp = new StockItem("vase", 9.99, 40);
        stockList.addStock(temp);

        temp = new StockItem("vase", 9.79, 40);
        stockList.addStock(temp);

        System.out.println(stockList);
        System.out.println();

        for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket myBasket = new Basket("Krzysiek");

        sellItem(myBasket, "car toy", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car toy", 1);
        System.out.println(myBasket);

        if (sellItem(myBasket, "car toy", 1) != 1) {   //should not add as there are only 2 in StockList
            System.out.println("There are no more Car toys in stock");
        }

        sellItem(myBasket, "wine", 5);
//        System.out.println(myBasket);

        sellItem(myBasket, "juice", 1);
        sellItem(myBasket, "vase", 2);
        sellItem(myBasket, "bread", 1);
//        System.out.println(myBasket);
//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket,"cup", 10);
        sellItem(basket, "juice", 3);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(myBasket,"car toy", 1);
        removeItem(myBasket,"vase", 2);
        removeItem(myBasket,"car toy", 1);
        System.out.println("Car toys removed: " + removeItem(myBasket, "car", 1)); //should not remove

        System.out.println(myBasket);

        removeItem(myBasket, "juice", 1);
        removeItem(myBasket, "vase", 2);
        removeItem(myBasket, "bread", 1);

        System.out.println(myBasket);
        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);


        StockItem car = stockList.Items().get("car");   //to add without NullPointerException error when no stock.
        if(car != null){
            car.adjustStock(2000);
        }
        if(car != null){
            car.adjustStock(2000);
        }
//        stockList.Items().get("car toy").adjustStock(2000);     //it will change. As the collection is
//                                                                        //unmodifiable but not the objects itself
//        stockList.Items().get("car toy").adjustStock(-1000);
        System.out.println(stockList);
//        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()){
//            System.out.println(price.getKey() + " costs $" + String.format("%.2f", price.getValue()));
//        }

        checkOut(myBasket);
        System.out.println(myBasket);




    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We do not sell "+ item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity)!= 0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We do not sell "+ item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
