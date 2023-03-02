package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class chest extends SuperObject {

    public chest() {

        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));

        }catch(IOException e) {

            e.printStackTrace();
        }
        collision=true;
    }
}
