package game.core;

import game.component.CircleComponent;
import game.model.Rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Root extends JPanel {
	private final Object _updateLock;
	
	public Root(Object updateLock, int width, int height) {
		_updateLock = updateLock;
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		setSize(width, height);
		setVisible(true);
	}
	
	public void doUpdate() {
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		onRepaintFinished();
    }
	
	private void onRepaintFinished() {
        synchronized (_updateLock) {
        	_updateLock.notify();
        }
	}
	
	protected void addComponent(JComponent component) {
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.weightx = 1;
	    constraints.weighty = 1;
	    constraints.fill = GridBagConstraints.BOTH;
	
	    add(component, constraints);
	}
}
