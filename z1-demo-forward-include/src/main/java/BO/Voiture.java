package BO;

public class Voiture {

	//attributs
	private String marque;
	private String model;
	private int vitesseMax;
	private String mat; //matricule de la voiture.
	
	//-----------------------------------------------------------------------//
	// getters et setters.
	
	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public int getVitesseMax() {
		return vitesseMax;
	}



	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}



	public String getMat() {
		return mat;
	}



	public void setMat(String mat) {
		this.mat = mat;
	}


	//-----------------------------------------------------------------------//

	//constructeur
	public Voiture(String marque, String model, int vitesseMax, String mat) {
		super();
		this.marque = marque;
		this.model = model;
		this.vitesseMax = vitesseMax;
		this.mat = mat;
	}



	public Voiture() {
		super();
	}
	
	//-----------------------------------------------------------------------//
	
	
	
	
	
	
}
