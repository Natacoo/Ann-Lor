package model.manager.image;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import model.bdd.BDD;

public class ManagerImage {
	private HashMap<Integer, Image> imagesElements;
	private HashMap<String, Image> imagesEntities;
	private HashMap<String, Image> imagesParticules;
	private HashMap<String, InputStream> ressources;
	private HashMap<String, String> sound;
	
	private BDD bdd;
	private String path;
	
	public ManagerImage(BDD bdd, String path){
		this.bdd = bdd;
		this.path = path;
		initElement();
		initEntitie();
		initParticule();
		initRessource();
	} 
	
	private void initRessource(){
		
	}
	
	private void initParticule() {
		
	}
	
	private void initElement() {
		
	}
	
	private void initEntitie() {
		
	}
	
	public HashMap<Integer, Image> getImagesElements(){
		return imagesElements;
	}
	
	public HashMap<String, Image> getImagesEntities(){
		return imagesEntities;
	}
	
	public HashMap<String, Image> getImagesParticules(){
		return imagesParticules;
	}
	
	public HashMap<String, InputStream> getRessource(){
		return ressources;
	}
	
	public HashMap<String, String> getSound() {
		return sound;
	}
	
}
