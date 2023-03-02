package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class apple extends SuperObject {

        public apple() {

            name = "apple";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/player/apple.png"));

            }catch(IOException e) {

            e.printStackTrace();
            }
            collision=true;
        }
    }
