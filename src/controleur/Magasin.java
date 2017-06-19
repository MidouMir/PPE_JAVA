package controleur;

public class Magasin {

	private int idB;
	private String nomB, descB, adresseB, villeB, cpB, eligible;
	
	public Magasin (int idB, String nomB, String descB, String adresseB,
			String villeB, String cpB, String eligible){
		this.idB			= idB;
		this.nomB			= nomB;
		this.descB			= descB;
		this.adresseB		= adresseB;
		this.villeB			= villeB;
		this.cpB			= cpB;
		this.eligible		= eligible;
	}

	public int getIdB() {
		return idB;
	}

	public void setIdB(int idB) {
		this.idB = idB;
	}

	public String getNomB() {
		return nomB;
	}

	public void setNomB(String nomB) {
		this.nomB = nomB;
	}

	public String getDescB() {
		return descB;
	}

	public void setDescB(String descB) {
		this.descB = descB;
	}

	public String getAdresseB() {
		return adresseB;
	}

	public void setAdresseB(String adresseB) {
		this.adresseB = adresseB;
	}

	public String getVilleB() {
		return villeB;
	}

	public void setVilleB(String villeB) {
		this.villeB = villeB;
	}

	public String getCpB() {
		return cpB;
	}

	public void setCpB(String cpB) {
		this.cpB = cpB;
	}

	public String getEligible() {
		return eligible;
	}

	public void setEligible(String eligible) {
		this.eligible = eligible;
	}
}
