package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;

public class TileManager {

    GamePanel gp;
    Tile[] tiles;
    int[][] tileMap;

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tiles = new Tile[10];
        tileMap = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {

            // Grass Tile Code = 0
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new FileInputStream("res/tiles/grass.png"));

            // Wall Tile Code = 1
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new FileInputStream("res/tiles/wall.png"));

            // Water Tile Code = 2
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new FileInputStream("res/tiles/water.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try {
            InputStream is = new FileInputStream("res/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gp.maxScreenRow; row++) {

                String line = br.readLine();
                String[] numbers = line.split(" ");

                for (int col = 0; col < gp.maxScreenCol; col++) {

                    int tileCode = Integer.parseInt(numbers[col]);

                    tileMap[col][row] = tileCode;
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Draws the tiles onto the screen.
    // Codes: 0 = Grass, 1 = Wall, 2 = Water
    public void draw(Graphics2D g) {

        // g.drawImage(tiles[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {

                int tileCode = tileMap[col][row];
                int xPos = col * gp.tileSize;
                int yPos = row * gp.tileSize;

                g.drawImage(tiles[tileCode].image, xPos, yPos, gp.tileSize, gp.tileSize, null);

            }
        }
    }
}
