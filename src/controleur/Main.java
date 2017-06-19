package controleur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import vue.Connexion;

public class Main{
	
	private static Connexion uneConnexion;
	public Main ()
	{
		uneConnexion = new Connexion();
	}
	
	public static void rendreVisible (boolean valeur)
	{
		uneConnexion.setVisible(valeur);
	}
	public static String Sha1(String mdp)
	{
		StringBuffer sha = new StringBuffer();
		try
		{
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(mdp.getBytes());
			
			for(int i = 0; i < result.length; i++)
			{
				sha.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(i));
			}
		}
		catch(NoSuchAlgorithmException exp)
		{
			System.out.println("Erreur de codage");
		}
		return sha.toString();
	}
	public static void main(String args[])
	{
		new Main();
	}
	
}