package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

import controleur.Client;
import controleur.Produits;
import modele.ModeleClient;
import modele.ModeleProduits;

public class VueProduits extends JPanel implements ActionListener, MouseListener {

	private JLabel lbTitre	= new JLabel("Liste des produits\n");
	private JTable tableClients;
	
	public VueProduits() {
		this.setBounds(50, 50, 700, 300);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK, 1, 16, 0);
		this.setBorder(brdr);
		this.setLayout(null);
		this.setBackground( new Color (255, 255, 255) );
		this.lbTitre.setBounds(30, 20, 200, 20);
		this.add(this.lbTitre);
		
		//construction de la JTable
		String entete[]		= {"ID", "Nom", "Quantité", "Photo"};
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
		ArrayList<Produits> lesProduits	= ModeleProduits.selectAll();
		Object [][]donnees	= new Object[lesProduits.size()][3];
		int i=0;
		for(Produits unProduit : lesProduits)
		{
			/*
			donnees [i][0]	= unProduit.getTypeCompte();
			if(unProduit.getTypeCompte().equals("Entreprise")){
				donnees [i][1]	= unProduit.getNomU();
			}else{
				donnees [i][1]	= unProduit.getPrenomU()+" "+unProduit.getNomU();
			}
			donnees [i][2]	= unProduit.getMailU();
			*/
			
			i++;
		}
		return donnees;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int lng = this.tableClients.getSelectedRow();
		int lat	= this.tableClients.getSelectedColumn();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
