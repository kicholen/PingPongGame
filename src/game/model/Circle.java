package game.model;

public class Circle extends Figure {
	private float _r;
	
	public Circle(float r, float x, float y) {
		super(x, y);
		_r = r;
	}
	
	public float getRadius() {
		return _r;
	}
}
