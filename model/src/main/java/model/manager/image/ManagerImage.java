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
		ressources = new HashMap<String, InputStream>();
		sound = new HashMap<String, String>();
		try{
			ResultSet result = bdd.query("{call selectRessourceAll()}");
			while(result.next()){
				if(result.getString("type").equals("IMG")){
					ressources.put(result.getString("name"), this.getClass().getResourceAsStream(path+result.getString("url")));
				}else{
					sound.put(result.getString("name"), result.getString("url"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	private void initParticule() {
		imagesParticules = new HashMap<String, Image>();
		try {
			ResultSet result = bdd.query("{call selectParticuleAll()}");
			while(result.next()){
				imagesParticules.put(result.getString("name"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(path+result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initElement() {
		imagesElements = new HashMap<Integer, Image>();
		try {
			ResultSet result = bdd.query("{call selectElementAll()}");
			while(result.next()){
				imagesElements.put(result.getInt("id"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(path+result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void initEntitie() {
		imagesEntities = new HashMap<String, Image>();
		try {
			ResultSet result = bdd.query("{call selectEntitiesAll()}");
			while(result.next()){
				imagesEntities.put(result.getString("name"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(path+result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
