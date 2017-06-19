package controleur;

public class Produits {

	private int idU, cpU, nbCommande;
	private String nomU, prenomU, siret, commentaires, adresseFacturation, mailU, typeCompte;

	public Produits (int idU, int cpU, int nbCommande,
			String nomU, String prenomU, String siret,
			String commentaires, String adresseFacturation,
			String mailU, String typeCompte){
		this.idU				= idU;
		this.nomU				= nomU;
		this.prenomU			= prenomU;
		this.siret				= siret;
		this.commentaires		= commentaires;
		this.adresseFacturation	= adresseFacturation;
		this.typeCompte			= typeCompte;
		this.mailU				= mailU;
		this.cpU				= cpU;
		this.nbCommande			= nbCommande;
	}
}
