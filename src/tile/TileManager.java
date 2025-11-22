package tile;

import main.GamePanel;

import java.awt.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }
    // add other tile types as needed
    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/sky_blue.png"));
            /*
            tile[1] = new Tile();
            tile[1].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tile[3] = new Tile();
            tile[3].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g2){


        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
       // g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }
}
