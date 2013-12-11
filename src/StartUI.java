import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URL;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUI implements KeyListener, WindowListener{
	JFrame f;
	JPanel p;
	Player mediaPlayer;
	
	public StartUI() throws Exception{
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBackground(Color.BLUE);
		
		Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
		
		URL url = new File("resources/intro.aif").toURI().toURL();
		mediaPlayer = Manager.createRealizedPlayer(url);
		
		JLabel img = new JLabel(new ImageIcon("resources/start.png"));
		JLabel startMessage = new JLabel("- PRESS ANY KEY TO START -");
		startMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		img.setAlignmentX(Component.CENTER_ALIGNMENT);
		startMessage.setFont(new Font("SansSerif", Font.BOLD, 20));
		startMessage.setForeground(Color.WHITE);
		
		p.add(img);
		p.add(startMessage);
		
		f = new JFrame("Video Test");
		f.setContentPane(p);
		f.pack();
		f.setVisible(true);
		
		mediaPlayer.start();
		
		f.addKeyListener(this);
		f.addWindowListener(this);
	}

	//Methoden von KeyListener
	public void keyPressed(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }
	
	public void keyTyped(KeyEvent e) {
		new Thread(new GameWorker(f, mediaPlayer)).run();
	}

	//Methoden von WindowListener
	public void windowActivated(WindowEvent e) { }
	public void windowClosed(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }
	
	public void windowClosing(WindowEvent e) {
		mediaPlayer.stop();
		System.exit(0);
	}
}
