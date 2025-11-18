package entities;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    private Parachute parachute = null;

    public  Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage(){
        try{
            up = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/squirrel.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void update(){
        if(keyH.upPressed == true){
            y -= speed;
        }
        else if(keyH.downPressed == true){
            y += speed;
        }
        else if(keyH.leftPressed == true){
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(java.awt.Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

    public Parachute getParachute() {
        return parachute;
    }

    public void equipParachute(Parachute parachute) {
        this.parachute = parachute;
    }

    public void unequipParachute(Parachute parachute) {
        this.parachute = null;
    }
}
