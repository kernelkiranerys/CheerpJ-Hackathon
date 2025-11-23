package entities;

import entities.armours.Armour;
import entities.armours.SquirrelArmour;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    private Parachute parachute = null;
    private Armour armour = new SquirrelArmour();
    private String playerGlideSpritePath = armour.getGlideSpritePath();
    private String playerDiveSpritePath  = armour.getDiveSpritePath();
    private double playerWeight = 0.6;
    private double playerDragCoefficient = 1.0;
    private double playerFrontalArea = 0.025;

    public  Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize * 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize * 2);

        solidArea = new Rectangle();
        solidArea.x = gp.tileSize;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize * 2;
        solidArea.height = gp.tileSize * 2;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize * 14;
        worldY = gp.tileSize * 3;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage(){
        try{
            up = javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(getPlayerGlideSpritePath())));
            down = javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(getPlayerDiveSpritePath())));
            left = javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(getPlayerGlideSpritePath())));
            right = javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(getPlayerGlideSpritePath())));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void update(){
        boolean moving = false;

        if(keyH.upPressed == true){
            direction = "up";
            moving = true;
        }
        else if(keyH.downPressed == true){
            direction = "down";
            moving = true;
        }
        else if(keyH.leftPressed == true){
            direction = "left";
            moving = true;
        }
        else if(keyH.rightPressed == true){
            direction = "right";
            moving = true;
        }

        if(keyH.pPressed == true){
            if (parachute != null && !parachute.isDeployed()){
                parachute.deploy();
            }
        }

        //check tile collision only if moving
        if(moving){
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //if collision is false, player can move
            if(collisionOn == false){
                switch (direction) {
                    case "up":
                        movePlayerUp();
                        break;
                    case "down":
                        movePlayerDown();
                        break;
                    case "left":
                        movePlayerLeft();
                        break;
                    case "right":
                        movePlayerRight();
                        break;
                }
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
            case "left":
                image = left;
                playerDragCoefficient = 1.0;
                playerFrontalArea = 0.04;
                break;
            case "right":
                image = right;
                playerDragCoefficient = 1.0;
                playerFrontalArea = 0.04;
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize * 4, gp.tileSize * 4, null);
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
        worldX -= speed;
    }

    public void movePlayerRight() {
        worldX += speed;
    }

    public void movePlayerUp() {
        worldY -= speed;
    }

    public void movePlayerDown() {
        worldY += speed;
    }

    public void setPlayerArmour(Armour armour){
        this.armour = armour;
    }

    public void setPlayerGlideSpritePath(String path){
        this.playerGlideSpritePath = path;
    }

    public String getPlayerGlideSpritePath(){
        return this.playerGlideSpritePath;
    }

    public void setPlayerDiveSpritePath(String path){
        this.playerDiveSpritePath = path;
    }

    public String getPlayerDiveSpritePath() {
        return this.playerDiveSpritePath;
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
