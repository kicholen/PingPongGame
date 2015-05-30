package game.component;

import game.model.Rectangle;

public class PlayerActor extends RectangleComponent {
	private static final int SPEED = 15;
	private Boolean _upkeyPressed;
	private Boolean _downKeyPressed;
	private java.awt.Rectangle _boundries;
	
	public PlayerActor(Rectangle model, java.awt.Rectangle boundries) {
		super(model);
		_upkeyPressed = false;
		_downKeyPressed = false;
		_boundries = boundries;
	}

	public void doUpdate() {
		if (_upkeyPressed && _downKeyPressed) {
			return;
		}
		
		if (_upkeyPressed) {
			float destPosition =  _model.getY() - SPEED;
			destPosition = Math.max(_boundries.x, destPosition);
			_model.setY(destPosition);
		}
		else if (_downKeyPressed) {
			float destPosition =  _model.getY() + SPEED;
			destPosition = Math.min(_boundries.x + _boundries.height - _model.getHeight(), destPosition);
			_model.setY(destPosition);
		}
	}
	
	public Rectangle getModel() {
		return _model;
	}
	
	public void setDownKey(Boolean isPressed) {
		_downKeyPressed = isPressed;
	}
	
	public void setUpKey(Boolean isPressed) {
		_upkeyPressed = isPressed;
	}
	
	public void onDragged(int y) {
		float destPosition = y - _model.getHeight() / 2;
		destPosition = Math.max(_boundries.x, Math.min(_boundries.x + _boundries.height - _model.getHeight(), destPosition));
		_model.setY(destPosition);
		
	}
}
