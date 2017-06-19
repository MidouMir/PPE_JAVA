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
import controleur.Magasin;
import modele.ModeleClient;
import modele.ModeleMagasins;

public class VueMagasin extends JPanel implements ActionListener {

	private JLabel lbTitre	= new JLabel("Liste des magasins\n");
	private JTable tableMagasins;
	
	public VueMagasin() {
		this.setBounds(50, 50, 700, 300);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK, 1, 16, 0);
		this.setBorder(brdr);
		this.setLayout(null);
		this.setBackground( new Color (255, 255, 255) );
		this.lbTitre.setBounds(30, 20, 200, 20);
		this.add(this.lbTitre);
		
		//construction de la JTable
		String entete[]		= {"Nom", "Adresse", "Participant"};
		this.tableMagasins	= new JTable(this.extraireMagasins(), entete);
		JScrollPane uneScroll	= new JScrollPane(tableMagasins);
		uneScroll.setBounds(40, 50, 650, 190);
		this.add(uneScroll);
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
	}
	public Object [][] extraireMagasins()
	{
		ArrayList<Magasin> lesMagasins	= ModeleMagasins.selectAll();
		Object [][]donnees	= new Object[lesMagasins.size()][3];
		int i=0;
		for(Magasin unMagasin : lesMagasins)
		{
			donnees [i][0]	= unMagasin.getNomB();
			donnees [i][1]	= unMagasin.getAdresseB() + " " + unMagasin.getCpB() + " " + unMagasin.getVilleB();
			if(unMagasin.getEligible().equals("non")){
				donnees [i][2]	= "Inactif";
			}else{
				donnees [i][2]	= "Actif";
			}
			i++;
		}
		return donnees;
	}
}
