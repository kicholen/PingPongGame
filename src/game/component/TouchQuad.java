package game.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import game.model.Rectangle;

/**
 * Mouse listener was listening only on top component so this quad was made to propagate touch events to children.
 * Though, I'm pretty sure that there is better solution.
 * @author Zelek
 *
 */
public class TouchQuad extends RectangleComponent {
	List<PlayerActor> _touchPlayers;
	
	public TouchQuad(Rectangle model, List<PlayerActor> list) {
		super(model);
		_touchPlayers = list;
	}

	
	public void createMouseListener() {
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				for (PlayerActor actor : _touchPlayers) {
					if (actor.contains(e.getPoint())) {
						actor.onDragged(e.getY());
					}
				}
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
