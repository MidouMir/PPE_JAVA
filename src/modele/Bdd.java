package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {

	private String serveur, bdd, user, mdp;
	private Connection maConnexion;
	
	public Bdd (String serveur, String bdd, String user, String mdp)
	{
		this.serveur		= serveur;
		this.bdd			= bdd;
		this.user			= user;
		this.mdp			= mdp;
		this.maConnexion	= null;
	}
	
	public void chargerPilote()
	{
		// vérifie la présente du pilote mysql
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException exp)
		{
			System.out.println("Pilote MySQL Absent !");
		}
	}
	
	public void seConnecter()
	{
		// établi la connexion au serveur
		String url			= "jdbc:mysql://" + this.serveur + "/" + this.bdd;
		this.chargerPilote();
		try
		{
			this.maConnexion	= DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch (SQLException exp)
		{
			exp.printStackTrace();
			System.out.println("Erreur de connexion a : " + url);
		}
	}
	
	public void seDeconnecter()
	{
		// ferme la connexion au serveur
		try
		{
			if(this.maConnexion!= null) this.maConnexion.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de la fermeture de la connexion !");
		}
	}
	
	public Connection getMaConnexion()
	{
		return this.maConnexion;
	}
}
