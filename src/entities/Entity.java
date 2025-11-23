package entities;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int screenX, screenY;
    public  int speed;
    public BufferedImage up, down, left, right;
    public String direction = "down";
}
