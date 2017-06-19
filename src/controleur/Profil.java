package controleur;

public class Profil {

	private String login, pass, mail, telephone, nomComplet;
	private int droits;
	
	public Profil()
	{
		this.login		= ""; 
		this.pass		= ""; 
		this.mail		= ""; 
		this.telephone	= ""; 
		this.nomComplet	= ""; 
		this.droits		= 0; 
	}
	
	public Profil(String login, String pass, String mail, String telephone, String nomComplet, int droits)
	{
		this.login		= login;
		this.pass		= pass;
		this.mail		= mail;
		this.telephone	= telephone;
		this.nomComplet	= nomComplet;
		this.droits		= droits;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public int getDroits() {
		return droits;
	}

	public void setDroits(int droits) {
		this.droits = droits;
	}
}
