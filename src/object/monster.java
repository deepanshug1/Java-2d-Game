package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class monster extends SuperObject {

    public monster() {

        name = "monster";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/monster.png"));

        }catch(IOException e) {

            e.printStackTrace();
        }
        collision=true;
    }
}
