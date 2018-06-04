package controller;


/**
 @author Hugo GERMAIN
 @version 06/04/2018
 */
public class Tick implements Runnable{
	private Controller controller;
	private long clock;
	
	/**
	 Initialize the object of Tick
	 @param controller It's a controller
	 */
	public Tick(Controller controller){
		this.controller = controller;
		clock = 0;
	}
	/**
	 @see java.lang.Runnable#run()
	 */
	public void run() 
	{
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
