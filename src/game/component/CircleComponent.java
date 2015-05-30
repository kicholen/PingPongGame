package game.component;

import game.model.Circle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CircleComponent extends JComponent {
	protected Circle _model;
	private Color _color;
	
	public CircleComponent(Circle model) {
		_model = model;
		Random rand = new Random();
		_color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

	 @Override
     public Dimension getPreferredSize() {
         return new Dimension((int)_model.getX() + (int)_model.getRadius(), (int)_model.getY() + (int)_model.getRadius());
     }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(_color);
        g.fillOval((int)_model.getX(), (int)_model.getY(), (int)_model.getRadius(), (int)_model.getRadius());
    }
}
