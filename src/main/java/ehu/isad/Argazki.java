package ehu.isad;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Argazki {
    String izena;
    String argazkia;

    public Argazki(String pIzena, String pArgazkia) throws IOException {
        this.izena = pIzena;

        argazkia = pArgazkia;
    }
}
