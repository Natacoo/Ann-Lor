package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import contract.ISound;

public class Sound extends Thread implements ISound {
	private File sound;
	private boolean loop;
	private Clip clip;

	public void load(String path) {

	}

	public void run() {

	}

	public void stopMusic() {
		clip.stop();
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

}
