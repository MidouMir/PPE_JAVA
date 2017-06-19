package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Profil;

public class Modele {

	public static ArrayList<Profil> selectAll()
	{
		ArrayList<Profil> lesProfils = new ArrayList<Profil>();
		String requete	= "SELECT * FROM admin";
		try
		{
			// host, database, user, pass
			/* 
			Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			*/
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next())
			{
				String login		= unRes.getString("login");
				String pass			= unRes.getString("pass");
				String mail			= unRes.getString("mail");
				String telephone	= unRes.getString("telephone");
				String nomComplet	= unRes.getString("nomComplet");
				int droits			= unRes.getInt("droits");
				
				// instanciation de la classe Produit
				Profil unProfil = new Profil(login, pass, mail, telephone, nomComplet, droits);
				lesProfils.add(unProfil);
			}
			// fermer la connexion après la boucle
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return lesProfils;
	}
	
	public static void insert(Profil unProfil)
	{
		String requete = "INSERT INTO admin VALUES ("
				+ "'" + unProfil.getLogin() + "',"
				+ "'" + unProfil.getPass() + "',"
				+ "'" + unProfil.getMail() + "',"
				+ "'" + unProfil.getTelephone() + "',"
				+ "'" + unProfil.getNomComplet() + "',"
				+ "'" + unProfil.getDroits() + "'"
				+ ");";
		try
		{
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static void delete (String login)
	{
		String requete = "DELETE FROM admin WHERE login = '" + login + "';";
		try
		{
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	 
	
	public static Profil selectWhere(String login, String pass)
	{
		String requete = "SELECT * FROM admin WHERE login = '" + login + "' AND pass = '" + pass + "';";
		Profil unProfil	= null;
		try
		{
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				String mail			= unRes.getString("mail");
				String telephone	= unRes.getString("telephone");
				String nomComplet	= unRes.getString("nomComplet");
				int droits			= unRes.getInt("droits");
				
				unProfil			= new Profil(login, pass, mail, telephone, nomComplet, droits);
			}
			unRes.close();
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return unProfil;
	}
}
