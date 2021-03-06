package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Blitz3_0 implements Time{
	
	private static int changer=0;
	private JLabel label;
	 Timer timer;
	 int totalTime=180;
	 static int whiteTime=180;
	 static int blackTime=180;
	
	public Blitz3_0(JLabel labelFromMain) {
		this.label= labelFromMain;
		timer = new Timer(1000, new timeCounting());
	}
	
	@Override
	public void start() {
		if(changer%2==0) {
			blackTime= totalTime;
			totalTime=whiteTime;
			timer.start();
		}
		else {
			whiteTime=totalTime;
			totalTime=blackTime;
			timer.start();
		}
		changer++;
	}
	
	@Override
	public void stop() {
		timer.stop();
		
	}
	
	class timeCounting implements ActionListener {
		
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int min,sec;
	     	 if (totalTime > 0)
	     	 {
	         	min=totalTime/60;
	         	sec=totalTime%60;
	          label.setText(String.valueOf(min)+":"+(sec>=10?String.valueOf(sec):"0"+String.valueOf(sec)));
	          totalTime--;
	       }
	     	if(totalTime==0) {
	     		label.setText("Time's up!");
	     	}
			
		}

	}
	
	
}

 