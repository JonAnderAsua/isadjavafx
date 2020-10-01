package ehu.isad;
import java.net.*;
import java.io.*;
import com.google.gson.Gson;

public class URLReader {
    public static String URLlortu(String s) throws Exception {
        Gson gson = new Gson();
        URL oracle = new URL("https://api.gdax.com/products/"+s+"-eur/ticker");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

        return inputLine;

    }
}
