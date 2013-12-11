import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePane extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage ban, wall, capri;
	Row[] rows;
	int xBAN;
	int currentHeight;
	
	public GamePane(Row[] rows) throws Exception{
		this.rows = rows;
		
		ban = ImageIO.read(new File("resources/ban.png"));
		wall = ImageIO.read(new File("resources/wand.png"));
		capri = ImageIO.read(new File("resources/caprisun.png"));
	}
	
	public void paintComponent(Graphics g){		
		g.drawImage(ban, xBAN*100, 700, null);
		System.out.println(xBAN*100 + ", " + (700));
		
		for(int i = 0; i < 9; i++){
			int[] rowItems = rows[i].getItems();
			System.out.println(i);
			for(int j = 0; i<3; i++){
				switch(rowItems[j]){
				case 0:
					break;
				case 1:
					g.drawImage(wall, j*100, i*100 + currentHeight, null);
					break;
				case 2:
					g.drawImage(capri, j*100, i*100 + currentHeight, null);
				default: break;
				}
			}
		}
	}
	
	public void scrollPixel(){
		currentHeight++;
		paintComponent(getGraphics());
	}
	
}
