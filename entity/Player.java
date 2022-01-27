package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

/*
    Controls what the player can do and the controls for the player.
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {

        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {

        xPos = 100;
        yPos = 100;
        speed = 4;
    }

    public void update() {
        if (keyHandler.upPressed) {
            yPos -= speed;
        }
        else if (keyHandler.downPressed) {
            yPos += speed;
        }
        else if (keyHandler.rightPressed) {
            xPos += speed;
        }
        else if (keyHandler.leftPressed) {
            xPos -= speed;
        }
    }

    public void draw(Graphics2D g) {

        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);
    }
}
