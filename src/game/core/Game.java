package game.core;

import javax.swing.JFrame;

public class Game extends JFrame {
	protected Root _root;
	protected final Object _updateLock = new Object();
	
	private boolean _runGame;
	public static final long UPDATE_INTERVAL = 17;

	public void setData(int width, int height) {
		setSize(width, height);
		setBounds(0, 0, width, height);
		setLocationRelativeTo(null);
		setLayout(null);
        add(createRoot());
        setVisible(true);
        _runGame = true;
	}
	
	public void start() {
		revalidate();
		repaint();
		run();
	}
	
	protected Root createRoot() {
		_root = new Root(_updateLock, getWidth(), getHeight());
		
		return _root;
	}
	
	private void runGameLoop() {
		while (_runGame) {
			long durationMs = update();
            try {
                Thread.sleep(Math.max(0, UPDATE_INTERVAL - durationMs));
        	} 
            catch (InterruptedException e) {
            
            }
		}
	}
	
    private long update() {
        long loopTime = System.currentTimeMillis();

        _root.doUpdate();
        _root.repaint();
        
        waitForPaint();

        return System.currentTimeMillis() - loopTime;
    }
    
    private void waitForPaint() {
       /* try {
            synchronized (_updateLock) {
            	_updateLock.wait();
            }
        } 
        catch (InterruptedException e) {
        
        }*/
    }
	
	private void stopGame() {
		_runGame = false;
	}

	private void run() {
		_runGame = true;
		Thread thread = new Thread(new Runnable() {
            
			@Override
            public void run() {
                runGameLoop();
            }
        });
		
		thread.start();
	}
}
