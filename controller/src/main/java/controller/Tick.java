package controller;

public class Tick implements Runnable{
	private Controller controller;
	private long clock;
		
	public Tick(Controller controller){
		this.controller = controller;
		clock = 0;
		}
	
	public void run() {
		while(true && controller != null)
		{
			try
			{
				Thread.sleep(100);
				clock++;
				controller.update(clock);
			}catch(Exception e){e.printStackTrace();}
		}
	
	}
		
		
}
