package tile;

import main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;

//16 left to right
//12 top to bottom

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/tile_map_2.txt");
    }
    // add other tile types as needed
    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/sky_blue.png"));
            System.out.println("Loaded tile[0]: " + (tile[0].image != null ? "SUCCESS" : "FAILED"));

            tile[1] = new Tile();
            tile[1].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/bark_brown.png"));
            System.out.println("Loaded tile[1]: " + (tile[1].image != null ? "SUCCESS" : "FAILED"));

            tile[2] = new Tile();
            tile[2].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/grass_green.png"));
            tile[2].collision = true;
            System.out.println("Loaded tile[2]: " + (tile[2].image != null ? "SUCCESS" : "FAILED"));

            tile[3] = new Tile();
            tile[3].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/images/tiles/sky_blue.png"));
            tile[3].collision = true;
            /*
            tile[4] = new Tile();
            tile[4].image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try {
           InputStream is = getClass().getResourceAsStream(filePath);
           BufferedReader br = new BufferedReader(new java.io.InputStreamReader(is));
              int col = 0;
              int row = 0;
              int tile1Count = 0;
              int tile2Count = 0;

              while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                  String line = br.readLine();
                  while (col < gp.maxWorldCol){
                      String numbers[] = line.split(" ");
                      int num = Integer.parseInt(numbers[col]);
                      mapTileNum[col][row] = num;
                      if (num == 1) tile1Count++;
                      if (num == 2) tile2Count++;
                      col++;
                  }
                  if (col == gp.maxWorldCol){
                      col = 0;
                      row++;
                  }
              }
              br.close();
              System.out.println("Map loaded. Tile 1 count: " + tile1Count + ", Tile 2 count: " + tile2Count);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics g2){


        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int wordlX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = wordlX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            //TODO: improve drawing efficiency by only drawing tiles within the visible screen area




            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;

            }
        }
       // g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }
}
