package game;

import game.component.PingPongRoot;
import game.core.Game;
import game.core.Root;
import game.enums.SideEnum;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PingPongGame extends Game {
	public static final String[] OPTIONS = { "left", "right", "both" };
	private SideEnum _playerSide;
	
	public void setData(int width, int height) {
		showChooseSidePane();
		showInfoPane();
		super.setData(width, height);
	}
	
	private void showChooseSidePane() {
		JOptionPane optionPane = new JOptionPane("Which side you want to drag?", JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptions(OPTIONS);
		JDialog dialog = optionPane.createDialog(null, "Choose");
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		dialog.pack();
		dialog.setVisible(true);
		
		
		switch ((String) optionPane.getValue()) {
		case "left":
			_playerSide = SideEnum.LEFT;
			break;
		case "right":
			_playerSide = SideEnum.RIGHT;
			break;
		case "both":
			_playerSide = SideEnum.BOTH;
			break;
		}
	}
	
	private void showInfoPane() {
		JOptionPane infoPane = new JOptionPane("Control: \n  leftPlayer: w/s,\n  rightPlayer: up/down arrow", JOptionPane.OK_OPTION);
		JDialog dialog = infoPane.createDialog(null, "Choose");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		dialog.pack();
		dialog.setVisible(true);
	}
	
	@Override
	protected Root createRoot() {
		PingPongRoot root = new PingPongRoot(_updateLock, getWidth() * 9 / 10, getHeight() * 9 / 10); // hack to not resize window every time
		root.setData(_playerSide);
		_root = root;
		
		return _root;
	}
	

}
