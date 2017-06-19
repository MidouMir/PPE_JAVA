package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controleur.Main;
import controleur.Profil;
import vue.VueConnex;
import vue.VueAccueil;
import vue.VueClient;

public class General extends JFrame implements ActionListener {

	private JMenuBar uneBarre		= new JMenuBar();
	private JMenu mnMenu			= new JMenu("Menu");
	// private JMenu mnClients			= new JMenu("Clients");
	private JMenu mnProduits		= new JMenu("Produits");
	private JMenu mnMagasins		= new JMenu("Magasins");
	private JMenu mnAide			= new JMenu("Aide");

	private JMenuItem itemMonProfil	= new JMenuItem("Acceuil");
	private JMenuItem itemQuitter	= new JMenuItem("Déconnexion");
	private JMenuItem itemMagasins	= new JMenuItem("Lister les boutiques");
	private JMenuItem itemProduits	= new JMenuItem("Voir les produits");
	private JMenuItem itemAjouter	= new JMenuItem("Ajouter");
	private JMenuItem itemApropos	= new JMenuItem("À propos");
	
	private VueAccueil uneVueAccueil;
	private VueMagasin uneVueMagasin;
	// private VueClient uneVueClient;
	// private VueClientEdition uneVueClientEdition;
	
	public General(Profil unProfil) {
		this.setTitle("Gestion des stocks");
		this.setLayout(null);
		this.setBounds(200, 200, 800, 600);
		this.setResizable(false);

		this.getContentPane().setBackground(new Color(0, 70, 18));
		
		this.setBounds(100, 100, 800, 600);
		ImageIcon logo = new ImageIcon("src/img/logo.png");
		this.setIconImage(logo.getImage());
		
		this.uneVueAccueil	= new VueAccueil(unProfil);
		this.add(uneVueAccueil);
		
		this.uneVueMagasin	= new VueMagasin();
		this.add(uneVueMagasin);
		
		// this.setContentPane(this.uneVueAccueil);
		// this.uneVueClient	= new VueClient();
		// this.add(uneVueClient);
		
		// this.uneVueClientEdition	= new VueClientEdition();
		// this.add(uneVueClientEdition);
		
		this.uneBarre.add(mnMenu);
		this.mnMenu.add(itemMonProfil);
		this.mnMenu.add(itemQuitter);

		// this.uneBarre.add(mnClients);
		// this.mnClients.add(itemLister);
		
		this.uneBarre.add(mnMagasins);
		this.mnMagasins.add(itemMagasins);
		
		this.uneBarre.add(mnProduits);
		this.mnProduits.add(itemProduits);
		
		this.uneBarre.add(mnAide);
		this.mnAide.add(itemApropos);
		this.setJMenuBar(uneBarre);
		
		// this.itemLister.addActionListener(this);
		this.itemMagasins.addActionListener(this);
		this.itemProduits.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		this.itemMonProfil.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.itemQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Veux-tu vraiment te déconnecter ?", "Déconnexion", 
					JOptionPane.ERROR_MESSAGE);
			if(retour == 0)
			{
				this.dispose();
				Main.rendreVisible(true);
			}
		}
		else if(e.getSource()==this.itemMonProfil)
		{
			// this.uneVueClient.setVisible(false);
			this.uneVueMagasin.setVisible(false);
			this.uneVueAccueil.setVisible(true);
		}
		else if(e.getSource()==this.itemMagasins)
		{
			this.uneVueAccueil.setVisible(false);
			this.uneVueMagasin.setVisible(true);
			// this.uneVueClient.setVisible(true);
		}
		else if(e.getSource()==this.itemProduits)
		{
			this.uneVueAccueil.setVisible(false);
			this.uneVueMagasin.setVisible(true);
			// this.uneVueClient.setVisible(true);
		}
	}

}
