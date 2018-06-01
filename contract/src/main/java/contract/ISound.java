package contract;

public interface ISound {
	public void load(String path);

	public void run();

	public void stopMusic();

	public void setLoop(boolean loop);

}
