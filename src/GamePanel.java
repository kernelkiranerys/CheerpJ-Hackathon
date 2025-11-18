import javax.swing.*;
import java.awt.*;

/**
 * Primary game drawing surface and main loop controller.
 *
 * <p>This JPanel subclass owns the game's timing thread and is responsible for:
 * - maintaining tile and screen size constants used by the renderer,
 * - starting the game loop thread,
 * - performing per-frame updates, and
 * - rendering the game to the panel.</p>
 *
 * <p>It implements Runnable so the game loop can run on a dedicated thread
 * started via startGameThread().</p>
 */
public class GamePanel extends JPanel implements Runnable {

    /**
     * Base size of a single tile in pixels before scaling.
     */
    final int originalTileSize = 16;

    /**
     * Scaling factor applied to the original tile size.
     */
    final int scale = 3;

    /**
     * Size of one tile in pixels after scaling (originalTileSize * scale).
     */
    final int tileSize = originalTileSize * scale;

    /**
     * Number of horizontal tiles visible on the screen.
     */
    final int maxScreenCol = 16;

    /**
     * Number of vertical tiles visible on the screen.
     */
    final int maxScreenRow = 12;

    /**
     * Screen width in pixels (tileSize * number of columns).
     */
    final int screenWidth = tileSize * maxScreenRow;

    /**
     * Screen height in pixels (tileSize * number of rows).
     */
    final int screenHeight = tileSize * maxScreenRow;

    /**
     * Thread that runs the main game loop. Null when not running.
     */
    Thread gameThread;


    /**
     * Construct a GamePanel configured for the calculated screen size and
     * basic double buffering. The background is initialized to blue.
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true);
    }

    /**
     * Start the game loop on a dedicated thread.
     *
     * <p>If the thread is already running, this will replace it with a new one
     * and start that new game loop.</p>
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Main game loop. Runs while gameThread is non-null.
     *
     * <p>The loop calls update() to change game state and repaint() to schedule
     * a new frame render via paintComponent.</p>
     */
    @Override
    public void run() {
        while(gameThread != null){
            System.out.println("Running");
            // this loop will update data to rernder screen sprites and other game info
            update();
            // render
            repaint();
        }
    }

    /**
     * Update game logic for the next frame.
     *
     * <p>Currently a placeholder intended to be filled with game update logic
     * such as moving sprites, processing input, and handling collisions.</p>
     */
    public void update(){

    }

    /**
     * Render the current game state to the panel.
     *
     * @param g the Graphics context provided by Swing; never null when called by the paint system
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();

    }
}
