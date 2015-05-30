import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.PingPongGame;


public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShow();
            }
        });
	}
	
	public static void createAndShow() {
		PingPongGame game = new PingPongGame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setData(900, 700);
		game.start();
	}
}
