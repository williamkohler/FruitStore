import java.awt.Desktop;
import java.net.URI;

public class Hal9000 {

    Hal9000(){
        callHal();
    }


    public static void callHal(){
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://youtu.be/ARJ8cAGm6JE?t=1m3s");
            desktop.browse(oURL);


        } catch (Exception e) {
            System.out.println("sorry. goodbye");
            System.exit(0);
        }
    }
}