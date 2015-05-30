package game.component;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import game.model.Circle;
import game.util.Vector2;

public class BallActor extends CircleComponent {
	private final int SPEED = 5;
	private Point _speed;
	private Rectangle _boundries;
	private game.model.Rectangle _leftPlayerModel;
	private game.model.Rectangle _rightPlayerModel;
	
	public BallActor(Circle model, Rectangle boundries, game.model.Rectangle leftPlayerModel, game.model.Rectangle rightPlayerModel) {
		super(model);
		_leftPlayerModel = leftPlayerModel;
		_rightPlayerModel = rightPlayerModel;
		_boundries = boundries;
		setBasePositionAndRandomSpeed();
	}
	
	public void doUpdate() {
		Vector2 destinPosition = new Vector2(_speed.x + _model.getX(), _speed.y + _model.getY());

		if (_boundries.contains(destinPosition.x, destinPosition.y, _model.getRadius(), _model.getRadius())) {
			_model.setPosition(destinPosition);
		}
		else {
			if (destinPosition.y <= 0.0f) {
				_speed.y = -_speed.y;
				destinPosition.y = _speed.y + _model.getY();
				_model.setPosition(destinPosition);
			}
			else if (destinPosition.y + _model.getRadius() >= _boundries.height) {
				_speed.y = -_speed.y;
				destinPosition.y = _speed.y + _model.getY();
				_model.setPosition(destinPosition);
			}
			else if (destinPosition.x <= 0.0f) {
				if ((destinPosition.y >= _leftPlayerModel.getY() && destinPosition.y <= _leftPlayerModel.getY() + _leftPlayerModel.getHeight())) {
					_speed.x = -_speed.x;
					destinPosition.x = _speed.x + _model.getX();
					_model.setPosition(destinPosition);
				}
				else {
					setBasePositionAndRandomSpeed();
				}
			}
			else if (destinPosition.x + _model.getRadius() >= _boundries.width) {
				if ((destinPosition.y >= _rightPlayerModel.getY() && destinPosition.y <= _rightPlayerModel.getY() + _rightPlayerModel.getHeight())) {
					_speed.x = -_speed.x;
					destinPosition.x = _speed.x + _model.getX();
					_model.setPosition(destinPosition);
				}
				else {
					setBasePositionAndRandomSpeed();
				}
			}
		}
	}
	
	public void setBasePositionAndRandomSpeed() {
		_model.setPosition((float)_boundries.getWidth() / 2, (float)_boundries.getHeight() / 2);
		Random rand = new Random();
		_speed = new Point(rand.nextInt(2) == 1 ? rand.nextInt(SPEED) + 1 : - rand.nextInt(SPEED) - 1, rand.nextInt(2) == 1 ? rand.nextInt(SPEED) + 1 : - rand.nextInt(SPEED) - 1);
	}
}
