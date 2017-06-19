package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// import controleur.Client;
import controleur.Produits;

public class ModeleProduits {

	public static ArrayList<Produits> selectAll()
	{
		ArrayList<Produits> lesProduits = new ArrayList<Produits>();
		String requete	= "SELECT * FROM lesProduits";
		try
		{
			// host, database, user, pass
			Bdd uneBdd = new Bdd("db312014-sio2dev-food.sql-pro.online.net", "db312014_sio2dev_food", "db92998", "PPE_food");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next())
			{
				String nomU					= unRes.getString("nomU");
				String prenomU				= unRes.getString("prenomU");
				String siret				= unRes.getString("siret");
				String commentaires			= unRes.getString("commentaires");
				String adresseFacturation	= unRes.getString("adresseFacturation");
				String typeCompte			= unRes.getString("typeCompte");
				String mailU				= unRes.getString("mailU");
				int idU						= unRes.getInt("idU");
				int cpU						= unRes.getInt("cpU");
				int nbCommande				= unRes.getInt("nbCommande");
				
				// instanciation de la classe Produit
				Produits unProduit = new Produits(idU, cpU, nbCommande, nomU, prenomU, siret, commentaires, adresseFacturation, mailU, typeCompte);
				lesProduits.add(unProduit);
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
		return lesProduits;
	}

}
