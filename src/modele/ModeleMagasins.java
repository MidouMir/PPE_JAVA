package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Magasin;

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
				int idB					= unRes.getInt("idB");
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

}
