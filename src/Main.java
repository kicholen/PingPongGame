import javax.swing.JFrame;

import game.PingPong;


public class Main {

	public static void main(String[] args) {
		PingPong game = new PingPong();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setData(500, 400);
		game.start();
	}

}
