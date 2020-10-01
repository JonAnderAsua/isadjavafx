package ehu.isad;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Txanpona {
    int trade_id;
    String price;
    float size;
    String time;
    String bid;
    String ask;
    String volume;

    @Override
    public String toString() {
        return "Txanpona{" +
                "trade_id=" + trade_id +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                '}';
    }
/*
    public Txanpona txanponaSortu(String s) throws Exception {
        Gson gson = new Gson();
        String moneta = URLReader.URLlortu(s);
        Txanpona t = gson.fromJson(moneta,Txanpona.class); //s = txanpon mota
        System.out.println(t);
        return t;
    }
*/
    public String getPrice(){
        return price;
    }
}
