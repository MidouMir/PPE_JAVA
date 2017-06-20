package controleur;

public class Produits {

	// private int idP;
	private String idP, nomP, descP, prixP, photoP;

	public Produits (String idP, String nomP, String descP, String prixP, String photoP){
		this.idP				= idP;
		this.nomP				= nomP;
		this.descP				= descP;
		this.prixP				= prixP;
		this.photoP				= photoP;
	}

	public String getIdP() {
		return idP;
	}

	public void setIdP(String idP) {
		this.idP = idP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getDescP() {
		return descP;
	}

	public void setDescP(String descP) {
		this.descP = descP;
	}

	public String getPrixP() {
		return prixP;
	}

	public void setPrixP(String prixP) {
		this.prixP = prixP;
	}

	public String getPhotoP() {
		return photoP;
	}

	public void setPhotoP(String photoP) {
		this.photoP = photoP;
	}
}
