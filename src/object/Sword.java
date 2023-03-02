package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword extends SuperObject {

        public Sword() {

            name = "Sword";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/player/sword.png"));

            }catch(IOException e) {

                e.printStackTrace();
            }
            collision=true;
        }
    }


