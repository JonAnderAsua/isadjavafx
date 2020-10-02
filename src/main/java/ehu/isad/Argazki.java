package ehu.isad;


import java.io.IOException;

public class Argazki {
    String izena;
    String argazkia;

    public Argazki(String pIzena, String pArgazkia) throws IOException {
        this.izena = pIzena;
        argazkia = pArgazkia;
    }

    @Override
    public String toString() { //Objektuaren id-a ez agertzeko
        return izena;
    }

    public String getArgazkia() {
        return argazkia;
    }
}
