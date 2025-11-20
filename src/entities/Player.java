package entities;

import entities.armours.Armour;
import entities.armours.SquirrelArmour;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    private Parachute parachute = null;
    private Armour armour = new SquirrelArmour();
    private double playerWeight = 0.6;
    private double playerDragCoefficient = 1.0;
    private double playerFrontalArea = 0.025;

    public  Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage(){
        try{
            up = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/squirrel_knight.png"));
            down = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/squirrel_mech.png"));
            left = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/squirrel_skeletal.png"));
            right = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/squirrel_sky_dive.png"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void update(){
        if(keyH.upPressed == true){
            direction = "up";

        }
        if(keyH.downPressed == true){
            direction = "down";

        }
        if(keyH.leftPressed == true){

            movePlayerLeft();
        }
        if(keyH.rightPressed == true){

            movePlayerRight();
        }
        if(keyH.pPressed == true){
            if (parachute != null && !parachute.isDeployed()){
                parachute.deploy();
            }
        }
    }
    public void draw(Graphics2D g2){
        //g2.setColor(java.awt.Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up;
                playerDragCoefficient = 1.0;
                playerFrontalArea = 0.04;
                break;
            case "down":
                image = down;
                playerDragCoefficient = 0.5;
                playerFrontalArea = 0.008;
                break;

        }
        g2.drawImage(image, x, y, gp.tileSize * 4, gp.tileSize * 4, null);
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

    public void movePlayerLeft() {
        x -= speed;
    }

    public void movePlayerRight() {
        x += speed;
    }

    public void movePlayerUp() {
        y -= speed;
    }

    public void movePlayerDown() {
        y += speed;
    }

    public void setPlayerArmour(Armour armour){
        this.armour = armour;
    }

    public Armour GetPlayerArmour(){
        return this.armour;
    }

    public double getPlayerWeight(){
        return this.armour.getWeight() + this.playerWeight;
    }

    public double getPlayerDragCoefficient(){
        if(this.parachute != null && this.parachute.isDeployed()){
            return this.parachute.getDragFactor() * this.playerDragCoefficient;
        }
        else {
            return this.playerDragCoefficient;
        }
    }

    public double getPlayerFrontalArea(){
        if(this.parachute != null && this.parachute.isDeployed()){
            return this.parachute.getParachuteFrontalArea() + this.playerFrontalArea;
        }
        else {
            return this.playerFrontalArea;
        }
    }
}
