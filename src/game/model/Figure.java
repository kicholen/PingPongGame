package game.model;

import game.util.Vector2;


public abstract class Figure {
	protected float _x;
	protected float _y;
	
	public Figure(float x, float y) {
		_x = x;
		_y = y;
	}
	
	public float getX() {
		return _x;
	}
	
	public float getY() {
		return _y;
	}
	
	public void setX(float value) {
		_x = value;
	}
	
	public void setY(float value) {
		_y = value;
	}
	
	public void setPosition(Vector2 position) {
		_x = position.x;
		_y = position.y;
	}
	
	public void setPosition(float x, float y) {
		_x = x;
		_y = y;
	}
	
	public Vector2 getPosition() {
		return new Vector2(_x, _y);
	}
}
