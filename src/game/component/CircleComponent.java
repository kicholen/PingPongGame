package game.component;

import game.model.Circle;

import java.awt.Graphics;

import javax.swing.JPanel;

public class CircleComponent extends JPanel {
	private Circle _model;

	public CircleComponent(Circle model) {
		_model = model;
	}

	public void update() {
		
	}
	
	public void paintComponent(Graphics g){

        //x, y, width, height
        g.drawRect(25, 50, 100, 75);

        //x, y, width, height
        g.fillOval(75, 60, 20, 20);
    }
}
