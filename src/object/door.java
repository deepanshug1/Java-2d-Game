package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class door extends SuperObject {

    public door() {

        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/door.png"));

        }catch(IOException e) {

            e.printStackTrace();
        }
        collision=true;
    }
}
