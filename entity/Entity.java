package entity;


import java.awt.image.BufferedImage;

/*
    Store various player, NPC, and mob entity information for the game.
 */
public class Entity {

    public int xPos, yPos;
    public int speed;

    public BufferedImage up1, up2, left1, left2, right1, right2, down1, down2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
