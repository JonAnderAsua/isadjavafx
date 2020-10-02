package ehu.isad;

public class Txanpona {
    int trade_id;
    String price;
    String size;
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
