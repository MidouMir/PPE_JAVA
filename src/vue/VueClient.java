package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

import controleur.Client;
import modele.ModeleClient;

public class VueClient extends JPanel implements ActionListener {

	private JLabel lbTitre	= new JLabel("Liste des clients\n");
	private JTable tableClients;
	
	public VueClient() {
		this.setBounds(50, 50, 700, 300);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK, 1, 16, 0);
		this.setBorder(brdr);
		this.setLayout(null);
		this.setBackground( new Color (255, 255, 255) );
		this.lbTitre.setBounds(30, 20, 200, 20);
		this.add(this.lbTitre);
		
		//construction de la JTable
		String entete[]		= {"Compte", "Nom", "Mail", "Commandes"};
		this.tableClients	= new JTable(this.extraireClients(), entete);
		JScrollPane uneScroll	= new JScrollPane(tableClients);
		uneScroll.setBounds(40, 50, 650, 190);
		this.add(uneScroll);
		
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
	}
	public Object [][] extraireClients()
	{
		ArrayList<Client> lesClients	= ModeleClient.selectAll();
		Object [][]donnees	= new Object[lesClients.size()][4];
		int i=0;
		for(Client unClient : lesClients)
		{
			donnees [i][0]	= unClient.getTypeCompte();
			if(unClient.getTypeCompte().equals("Entreprise")){
				donnees [i][1]	= unClient.getNomU();
			}else{
				donnees [i][1]	= unClient.getPrenomU()+" "+unClient.getNomU();
			}
			donnees [i][2]	= unClient.getMailU();
			donnees [i][3]	= unClient.getNbCommande();
			i++;
		}
		return donnees;
	}
}
