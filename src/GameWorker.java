import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWorker implements Runnable{
	JFrame f;
	Player mediaPlayer;
	JPanel p;
	GamePane gp;
	
	public GameWorker(JFrame f, Player mediaPlayer){
		this.f = f;
		this.mediaPlayer = mediaPlayer;
	}
	
	public void run(){
		mediaPlayer.stop();
		
		p = new JPanel();
		f.setContentPane(p);
		f.setSize(300, 800);
		//f.setResizable(false);
		
		Row[] rows = new Row[9];
		for(int i = 0; i < 9; i++)	rows[i] = Row.emptyRow();
		
		try {
			gp = new GamePane(rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		p.add(gp);
		f.validate();
	}
	
	public Row generateRow(){
		int a,b,c;
		
		double dice = Math.random();
		if(dice < 0.1) a = 1;
		else if(dice < 0.5) a = 2;
		else a = 0;
		
		dice = Math.random();
		if(dice < 0.1) b = 1;
		else if(dice < 0.5) b = 2;
		else b = 0;
		
		dice = Math.random();
		if(dice < 0.1) c = 1;
		else if(dice < 0.5) c = 2;
		else c = 0;
		
		return new Row(a,b,c);
	}
	
	public void scrollRow(){
		
	}
	
	public void addRow(){
		
	}
}
