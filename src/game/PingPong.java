package game;

import game.component.CircleComponent;
import game.component.RectangleComponent;
import game.model.Circle;
import game.model.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PingPong extends JFrame {
	public static final String[] OPTIONS = { "left", "right" };
	private String _playerSide;
	
	public void setData(int width, int height) {
		chooseSide();
		setSize(width, height);
        setVisible(true);
        
		JPanel ball = createBall(new Circle(width * 5 / 100, 50, 50));
		add(ball);
		JPanel leftPaddle = createPaddle(new Rectangle(10, 20, 5, 50));
		add(leftPaddle);
		JPanel rightPaddle = createPaddle(new Rectangle(10, 20, 95, 50));
		add(rightPaddle);
		
		start();
	}
	
	public void start() {
		revalidate();
		repaint();
	}
	
	private void chooseSide() {
		JOptionPane optionPane = new JOptionPane("Which side?", JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptions(OPTIONS);
		/*JDialog dialog = optionPane.createDialog(null, "Choose");
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		dialog.pack();
		dialog.setVisible(true);
		*/
		
		_playerSide = (String) optionPane.getValue();
	}

}
