package tile;

import main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }
    // add other tile types as needed
    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/sky_blue.png"));

            tile[1] = new Tile();
            tile[1].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/bark_brown.png"));

            /*
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

    public void loadMap(){
        try {
           InputStream is = getClass().getResourceAsStream("/maps/tile_map_1.txt");
           BufferedReader br = new BufferedReader(new java.io.InputStreamReader(is));
              int col = 0;
              int row = 0;

              while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                  String line = br.readLine();
                  while (col < gp.maxScreenCol){
                      String numbers[] = line.split(" ");
                      int num = Integer.parseInt(numbers[col]);
                      mapTileNum[col][row] = num;
                      col++;
                  }
                  if (col == gp.maxScreenCol){
                      col = 0;
                      row++;
                  }
              }
              br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics g2){


        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
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
