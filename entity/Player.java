package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

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
        getPlayerImage();
    }

    public void setDefaultValues() {

        xPos = 100;
        yPos = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(new FileInputStream("res/player/mage_back_1.png"));
            up2 = ImageIO.read(new FileInputStream("res/player/mage_back_2.png"));
            right1 = ImageIO.read(new FileInputStream("res/player/mage_right_1.png"));
            right2 = ImageIO.read(new FileInputStream("res/player/mage_right_2.png"));
            down1 = ImageIO.read(new FileInputStream("res/player/mage_front_1.png"));
            down2 = ImageIO.read(new FileInputStream("res/player/mage_front_2.png"));
            left1 = ImageIO.read(new FileInputStream("res/player/mage_left_1.png"));
            left2 = ImageIO.read(new FileInputStream("res/player/mage_left_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.leftPressed || keyHandler.rightPressed ||
                keyHandler.upPressed || keyHandler.downPressed) {

            if (keyHandler.upPressed) {
                direction = "up";
                yPos -= speed;
            }
            else if (keyHandler.downPressed) {
                direction = "down";
                yPos += speed;
            }
            else if (keyHandler.rightPressed) {
                direction = "right";
                xPos += speed;
            }
            else if (keyHandler.leftPressed) {
                direction = "left";
                xPos -= speed;
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g) {

//        g.setColor(Color.WHITE);
//        g.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                else if (spriteNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                else if (spriteNum == 2) {
                    image = down2;
                }
                break;

            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                else if (spriteNum == 2) {
                    image = left2;
                }
                break;

            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);
    }
}
