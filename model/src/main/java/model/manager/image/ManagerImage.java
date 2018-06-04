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

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class ManagerImage {
	private HashMap<Integer, Image> imagesElements;
	private HashMap<String, Image> imagesEntities;
	private HashMap<String, Image> imagesParticules;
	private HashMap<String, InputStream> ressources;
	//private HashMap<String, String> sound;
	
	private BDD bdd;
	/**
	 Initialize the object for ManagerImage
	 @param bdd It's a connection of database
	 @param path It's a path
	 */
	public ManagerImage(BDD bdd){
		this.bdd = bdd;
		initElement();
		initEntitie();
		initParticule();
		initRessource();
	}
	private void initRessource(){
		ressources = new HashMap<String, InputStream>();
		//sound = new HashMap<String, String>();
		try{
			ResultSet result = bdd.query("{call selectRessourceAll()}");
			while(result.next()){
				if(result.getString("type").equals("IMG")){
					ressources.put(result.getString("name"), this.getClass().getResourceAsStream(result.getString("url")));
				}//else{
					//sound.put(result.getString("name"), result.getString("url"));
//				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 Initialize images in multiple Particule
	 */
	private void initParticule() {
		imagesParticules = new HashMap<String, Image>();
		try {
			ResultSet result = bdd.query("{call selectParticuleAll()}");
			while(result.next()){
				imagesParticules.put(result.getString("name"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 Initialize images in multiple Element with connection at database
	 */
	private void initElement() {
		imagesElements = new HashMap<Integer, Image>();
		try {
			ResultSet result = bdd.query("{call selectElementAll()}");
			while(result.next()){
				imagesElements.put(result.getInt("id"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 Initialize images in multiple Entitie with connection at database
	 */
	private void initEntitie() {
		imagesEntities = new HashMap<String, Image>();
		try {
			ResultSet result = bdd.query("{call selectEntitiesAll()}");
			while(result.next()){
				imagesEntities.put(result.getString("name"), ImageIO.read(new BufferedInputStream(this.getClass().getResourceAsStream(result.getString("url")))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 Return the images of Elements
	 @return HashMap It's a table of image with key
	 */
	public HashMap<Integer, Image> getImagesElements(){
		return imagesElements;
	}
	/**
	 Return the images of Entities
	 @return HashMap It's a table of image with key
	 */
	public HashMap<String, Image> getImagesEntities(){
		return imagesEntities;
	}
	/**
	 Return the images of Particle
	 @return HashMap It's a table of image with key
	 */
	public HashMap<String, Image> getImagesParticules(){
		return imagesParticules;
	}
	/**
	 * Return all image in project
	 * @return It's a table of InpuStream with key
	 */
	public HashMap<String, InputStream> getRessource(){
		return ressources;
	}
	/**
	 * Return all sound in project
	 * @return It's a table of String with key
	 */
	/*public HashMap<String, String> getSound() {
		return sound;
	}*/
}
