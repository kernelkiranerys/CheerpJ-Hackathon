package main;


import entities.Entity;

public class Collision {

    private final int GROUND_TILE_INDEX = 2;

    GamePanel gp;
    public Collision(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;

                    if (tileNum1 == GROUND_TILE_INDEX || tileNum2 == GROUND_TILE_INDEX && !gp.tileM.endGameTriggered) {
                        gp.tileM.endGameTriggered = true;
                        gp.tileM.loadMap("/maps/end_game_3.txt");
                    }
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;

                    if (tileNum1 == GROUND_TILE_INDEX || tileNum2 == GROUND_TILE_INDEX && !gp.tileM.endGameTriggered) {
                        gp.tileM.endGameTriggered = true;
                        gp.tileM.loadMap("/maps/end_game_3.txt");
                    }
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;

                    if (tileNum1 == GROUND_TILE_INDEX || tileNum2 == GROUND_TILE_INDEX && !gp.tileM.endGameTriggered) {
                        gp.tileM.endGameTriggered = true;
                        gp.tileM.loadMap("/maps/end_game_3.txt");
                    }
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;

                    if (tileNum1 == GROUND_TILE_INDEX || tileNum2 == GROUND_TILE_INDEX && !gp.tileM.endGameTriggered) {
                        gp.tileM.endGameTriggered = true;
                        gp.tileM.loadMap("/maps/end_game_3.txt");
                    }
                }
                break;
        }
    }
}
