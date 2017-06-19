package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {

	public static ArrayList<Client> selectAll()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete	= "SELECT * FROM lesComptes";
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
				String nomU					= unRes.getString("nomU");
				String prenomU				= unRes.getString("prenomU");
				String siret				= unRes.getString("siret");
				String commentaires			= unRes.getString("commentaires");
				String adresse				= unRes.getString("adresse");
				String typeCompte			= unRes.getString("typeCompte");
				String mailU				= unRes.getString("mailU");
				int idU						= unRes.getInt("idU");
				int cpU						= unRes.getInt("cpU");
				int nbCommande				= unRes.getInt("nbCommande");
				
				// instanciation de la classe Produit
				Client unClient = new Client(idU, cpU, nbCommande, nomU, prenomU, siret, commentaires, adresse, mailU, typeCompte);
				lesClients.add(unClient);
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
		return lesClients;
	}

}
