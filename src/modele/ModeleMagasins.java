package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Magasin;
import controleur.Profil;

public class ModeleMagasins {

	public static ArrayList<Magasin> selectAll()
	{
		ArrayList<Magasin> lesMagasins = new ArrayList<Magasin>();
		String requete	= "SELECT * FROM boutique";
		try
		{
			// host, database, user, pass
			// Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "Midou1405");
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next())
			{
				String idB					= unRes.getString("idB");
				String nomB				= unRes.getString("nomB");
				String descB			= unRes.getString("descB");
				String adresseB			= unRes.getString("adresseB");
				String villeB			= unRes.getString("villeB");
				String cpB				= unRes.getString("cpB");
				String eligible			= unRes.getString("eligible");
				
				// instanciation de la classe Produit
				Magasin unMagasin = new Magasin(idB, nomB, descB, adresseB, villeB, cpB, eligible);
				lesMagasins.add(unMagasin);
			}
			// fermer la connexion après la boucle
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete + "\n SQLException: " + exp);
		}
		return lesMagasins;
	}
	
	public static void update(String id, String nom, String desc, String adresse, String cp, String ville, String eligible)
	{
		String requete = "UPDATE boutique SET nomB = '" + nom + "', descB = '" + desc + "', adresseB = '" + 
				adresse + "', cpB = '" + cp + "', villeB = '" + ville + "', eligible = '" +
				eligible + "' WHERE idB = " + id + ";";
		try
		{
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			// Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			int unRes = unStat.executeUpdate(requete);
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Impossible de mettre à jour le magasin\n\n"+exp);
		}
	}
	
	public static void insert(String nom, String desc, String adresse, String cp, String ville, String eligible)
	{
		String requete = "INSERT INTO boutique (nomB, descB, adresseB, cpB, villeB, eligible) VALUES"
				+ "('"+ nom + "', '" + desc + "', '" + adresse + "', '" + cp + "', '" + ville + "', '" + eligible + "' ;";
		try
		{
			Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			// Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Impossible d'ajouter un magasin\n\n"+exp);
		}
	}

}
