package game.model;

public class Rectangle extends Figure {
	private float _width;
	private float _height;
	
	public Rectangle(float width, float height, float x, float y) {
		super(x, y);
		_width = width;
		_height = height;
	}
	
	public float getWidth() {
		return _width;
	}
	
	public float getHeight() {
		return _height;
	}
	
}
