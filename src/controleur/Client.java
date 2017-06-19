package controleur;

public class Client {

	private int idU, cpU, nbCommande;
	private String nomU, prenomU, siret, commentaires, adresse, mailU, typeCompte;
	
	public Client (int idU, int cpU, int nbCommande,
			String nomU, String prenomU, String siret,
			String commentaires, String adresse,
			String mailU, String typeCompte){
		this.idU				= idU;
		this.nomU				= nomU;
		this.prenomU			= prenomU;
		this.siret				= siret;
		this.commentaires		= commentaires;
		this.adresse			= adresse;
		this.typeCompte			= typeCompte;
		this.mailU				= mailU;
		this.cpU				= cpU;
		this.nbCommande			= nbCommande;
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	public int getCpU() {
		return cpU;
	}

	public void setCpU(int cpU) {
		this.cpU = cpU;
	}

	public int getNbCommande() {
		return nbCommande;
	}

	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public String getPrenomU() {
		return prenomU;
	}

	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse= adresse;
	}

	public String getMailU() {
		return mailU;
	}

	public void setMailU(String mailU) {
		this.mailU = mailU;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
}
