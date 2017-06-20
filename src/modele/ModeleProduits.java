package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Magasin;
import controleur.Produits;

public class ModeleProduits {

	public static ArrayList<Produits> selectAll()
	{
		ArrayList<Produits> lesProduits = new ArrayList<Produits>();
		String requete	= "SELECT * FROM produitDispo";
		try
		{
			// host, database, user, pass
			Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			// Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next())
			{
				String idP				= unRes.getString("idP");
				String nomP				= unRes.getString("nomP");
				String descP			= unRes.getString("descP");
				String prixP			= unRes.getString("prixP");
				String photoP			= unRes.getString("photoP");
				
				// instanciation de la classe Produit
				Produits unProduit = new Produits(idP, nomP, descP, prixP, photoP);
				lesProduits.add(unProduit);
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
		return lesProduits;
	}
	
	public static void update(String id, String nom, String desc, String prix, String photo)
	{
		nom.replace("'", "\'");
		desc.replace("'", "\'");
		String requete = "UPDATE produitfini SET nomP = '" + nom + "', prixP = '" + prix + "' WHERE idP = " + id + ";";
		String requete2 = "UPDATE photoproduit SET descPhoto = '" + desc + "', urlPhoto = '" + photo + "' WHERE idP = " + id + ";";
		System.out.println(requete);
		try
		{
			// Bdd uneBdd = new Bdd("localhost", "ppe_food", "root", "");
			Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.execute(requete2);
			unStat.close();
			uneBdd.seConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Impossible de mettre à jour le produit\n\n"+exp);
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
			System.out.println("Impossible d'ajouter un Produit\n\n"+exp);
		}
	}

}
