package game.component;

import game.core.Root;
import game.enums.SideEnum;
import game.model.Circle;
import game.model.Rectangle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class PingPongRoot extends Root {
	private BallActor _ballActor;
	private PlayerActor _leftPlayerActor;
	private PlayerActor _rightPlayerActor;
	private TouchQuad _touchQuadListener;
	
	public PingPongRoot(Object updateLock, int width, int height) {
		super(updateLock, width, height);

		addListeners();
		setFocusable(true);
        requestFocusInWindow();
	}

	public void setData(SideEnum playerSide) {
		java.awt.Rectangle boundries = new java.awt.Rectangle(0, 0, getWidth(), getHeight());
		
		float circleRadius = getWidth() < getHeight() ? getWidth() * 0.05f : getHeight() * 0.05f;
		
		Rectangle leftPlayerModel = new Rectangle(10, getHeight() * 0.2f, 0, getHeight() / 2.0f);
		_leftPlayerActor = new PlayerActor(leftPlayerModel, boundries);
		addComponent(_leftPlayerActor);
		
		Rectangle rightPlayerModel = new Rectangle(10, getHeight() * 0.2f, getWidth() - 10, getHeight() / 2);
		_rightPlayerActor = new PlayerActor(rightPlayerModel, boundries);
		addComponent(_rightPlayerActor);
		
		_ballActor = new BallActor(new Circle(circleRadius, (getWidth() - circleRadius) / 2.0f, (getHeight() - circleRadius) / 2.0f), boundries, _leftPlayerActor.getModel(), _rightPlayerActor.getModel());
		addComponent(_ballActor);
		
		List<PlayerActor> draggableActors = new ArrayList<PlayerActor>();
		if (playerSide == SideEnum.LEFT) {
			draggableActors.add(_leftPlayerActor);
		}
		else if (playerSide == SideEnum.RIGHT) {
			draggableActors.add(_rightPlayerActor);
		}
		else if (playerSide == SideEnum.BOTH) {
			draggableActors.add(_leftPlayerActor);
			draggableActors.add(_rightPlayerActor);
		}
		_touchQuadListener = new TouchQuad(new Rectangle(1, 1, 1, 1), draggableActors);
		
		addComponent(_touchQuadListener);
		
		_touchQuadListener.createMouseListener();
	}
	
	@Override
	public void doUpdate() {
		_ballActor.doUpdate();
		_leftPlayerActor.doUpdate();
		_rightPlayerActor.doUpdate();
	}
	
	private void addListeners() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.print("typed: " + e.getKeyCode());

				switch (e.getKeyCode()) {
			    case 83:
			    	_leftPlayerActor.setDownKey(true);
			    	break;
		    	case 87:
		    		_leftPlayerActor.setUpKey(true);
			    	break;
		    	case 40:
		    		_rightPlayerActor.setDownKey(true);
			    	break;
		    	case 38:
		    		_rightPlayerActor.setUpKey(true);
			    	break;
			    }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
			    case 83:
			    	_leftPlayerActor.setDownKey(false);
			    	break;
		    	case 87:
		    		_leftPlayerActor.setUpKey(false);
			    	break;
		    	case 40:
		    		_rightPlayerActor.setDownKey(false);
			    	break;
		    	case 38:
		    		_rightPlayerActor.setUpKey(false);
			    	break;
			    }
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
	}
}
