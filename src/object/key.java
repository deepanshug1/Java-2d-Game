package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class key extends SuperObject {

    public key() {

        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/key.png"));

        }catch(IOException e) {

            e.printStackTrace();
        }
        collision=true;
    }
}
