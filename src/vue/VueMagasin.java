package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

import controleur.Client;
import controleur.Magasin;
import controleur.Main;
import controleur.Profil;
import modele.Modele;
import modele.ModeleClient;
import modele.ModeleMagasins;

public class VueMagasin extends JPanel implements ActionListener {

	private JPanel panneau	= new JPanel();
	private JPanel edition	= new JPanel();
	private JPanel actions	= new JPanel();
	private JLabel lbTitre	= new JLabel("Liste des magasins\n");
	private JTable tableMagasins;
	private VueAccueil uneVueAccueil;

	private JLabel labelID		= new JLabel("ID");
	private JTextArea magID		= new JTextArea("");
	private JLabel labelNom		= new JLabel("Nom");
	private JTextArea magNom	= new JTextArea("");
	private JLabel labelDesc	= new JLabel("Détails");
	private JTextArea magDesc	= new JTextArea("");
	private JLabel labelAdres	= new JLabel("Adresse");
	private JTextArea magAdres	= new JTextArea("");
	private JLabel labelVille	= new JLabel("Ville");
	private JTextArea magVille	= new JTextArea("");
	private JLabel labelCP		= new JLabel("Code postal");
	private JTextArea magCP		= new JTextArea("");
	private JLabel labelElig	= new JLabel("Éligible");
	private JComboBox magElig	= new JComboBox();
	private JButton btnAjout	= new JButton("Nouveau magasin");
	private JButton btnModif	= new JButton("Mettre à jour");	
	
	public VueMagasin() {
		
		this.setBounds(50, 50, 700, 400);
		AbstractBorder brdr2 = new TextBubbleBorder(Color.BLACK, 1, 16, 0);
		this.setBorder(brdr2);
		this.setLayout(null);
		
		panneau.setBounds(25, 50, 650, 200);
		panneau.setLayout(null);		
		this.add(panneau);
		
		Object[] elements = new Object[]{"", "oui", "non"};
		magElig = new JComboBox(elements);

		// labels
		labelID.setBounds(0, 0, 50, 20);
		labelNom.setBounds(60, 0, 50, 20);
		labelCP.setBounds(290, 0, 75, 20);
		labelVille.setBounds(430, 0, 50, 20);
		labelAdres.setBounds(0, 35, 50, 20);
		labelDesc.setBounds(270, 35, 75, 20);
		labelElig.setBounds(0, 70, 50, 20);
		btnAjout.setBounds(160, 105, 150, 25);
			btnAjout.setBackground( new Color (255, 195, 0) );
		btnModif.setBounds(0, 105, 150, 25);
			btnModif.setBackground( new Color (255, 195, 0) );
			btnModif.addActionListener(this);

		edition.add(labelID);
		edition.add(labelNom);
		edition.add(labelCP);
		edition.add(labelVille);
		edition.add(labelAdres);
		edition.add(labelDesc);
		edition.add(labelElig);
		edition.add(btnAjout);
		edition.add(btnModif);

		
		// Erreur d'execution de la requete : UPDATE boutique SET nomB = 
		// 'Paris Rue du Commerce', descB = 'Ouvert 7j/7 de 7H30 à 2H', 
		// adresseB = '1, rue du Commerce', cpB = '75015', villeB = 'Paris', eligible = 'oui' WHERE idB = 1;

		
		// champs
		magID.setBounds(25, 0, 25, 20);
		magID.setBackground( new Color (255, 195, 0) );
		
		magNom.setBounds(100, 0, 175, 20);
		magNom.setBackground( new Color (255, 195, 0) );
		
		magCP.setBounds(370, 0, 35, 20);
		magCP.setBackground( new Color (255, 195, 0) );
		
		magVille.setBounds(470, 0, 100, 20);
		magVille.setBackground( new Color (255, 195, 0) );
		
		magAdres.setBounds(60, 35, 200, 20);
		magAdres.setBackground( new Color (255, 195, 0) );
		
		magDesc.setBounds(320, 35, 300, 50);
		magDesc.setBackground( new Color (255, 195, 0) );
		magDesc.setWrapStyleWord(true);
		magDesc.setLineWrap(true);

		magElig.setBounds(60, 70, 100, 20);
		
		edition.add(magID);
		edition.add(magNom);
		edition.add(magCP);
		edition.add(magVille);
		edition.add(magAdres);
		edition.add(magDesc);
		edition.add(magElig);
		
		edition.setBounds(15, 250, 650, 145);
		edition.setLayout(null);		
		this.add(edition);
		
		this.setBackground( new Color (255, 255, 255) );
		panneau.setBackground( new Color (255, 255, 255) );
		edition.setBackground( new Color (255, 255, 255) );
		
		this.lbTitre.setBounds(20, 20, 200, 20);
		this.add(lbTitre);
		
		//construction de la JTable
		String entete[]		= {"ID", "Nom", "Détails", "Adresse", "Code postal", "Ville", "Participant"};
		this.tableMagasins	= new JTable(this.extraireMagasins(), entete);
		JScrollPane uneScroll	= new JScrollPane(tableMagasins);
		uneScroll.setBounds(0, 0, 650, 175);
		panneau.add(uneScroll);
		
		actions.setBounds(25, 400, 650, 200);
		actions.setLayout(null);		
		this.add(actions);
		actions.setBackground( new Color (255, 0, 0) );

		this.tableMagasins.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int i = tableMagasins.getSelectedRow();
				magID.setText(tableMagasins.getValueAt(i, 0).toString());
				magNom.setText(tableMagasins.getValueAt(i, 1).toString());
				magDesc.setText(tableMagasins.getValueAt(i, 2).toString());
				magAdres.setText(tableMagasins.getValueAt(i, 3).toString());
				magCP.setText(tableMagasins.getValueAt(i, 4).toString());
				magVille.setText(tableMagasins.getValueAt(i, 5).toString());
				magElig.setSelectedItem(tableMagasins.getValueAt(i, 6).toString());
			}
			
		});
		
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnModif)
		{
			majMagasin();
		}
	}
	
	public Object [][] extraireMagasins()
	{
		ArrayList<Magasin> lesMagasins	= ModeleMagasins.selectAll();
		Object [][]donnees	= new Object[lesMagasins.size()][7];
		int i=0;
		for(Magasin unMagasin : lesMagasins)
		{
			donnees [i][0]	= unMagasin.getIdB();
			donnees [i][1]	= unMagasin.getNomB();
			donnees [i][2]	= unMagasin.getDescB();
			donnees [i][3]	= unMagasin.getAdresseB();
			donnees [i][4]	= unMagasin.getCpB();
			donnees [i][5]	= unMagasin.getVilleB();
			donnees [i][6]	= unMagasin.getEligible();
			/*
			if(unMagasin.getEligible().equals("non")){
				donnees [i][6]	= "Inactif";
			}else{
				donnees [i][6]	= "Actif";
			}
			*/
			i++;
		}
		return donnees;
	}
	
	public void majMagasin()
	{
		String id		= magID.getText();
		String nom		= magNom.getText();
		String desc		= magDesc.getText();
		String adresse	= magAdres.getText();
		String cp		= magCP.getText();
		String ville	= magVille.getText();
		String eligible	= magElig.getSelectedItem().toString();
		
		if(id.equals("") || nom.equals("") || desc.equals("")
				|| adresse.equals("") || cp.equals("") || ville.equals("") || eligible.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Les champs doivent tous être renseignés");
		}
		else
		{
			ModeleMagasins.update(id, nom, desc, adresse, cp, ville, eligible);
			magID.setText("");
			magNom.setText("");
			magDesc.setText("");
			magAdres.setText("");
			magCP.setText("");
			magVille.setText("");
			magElig.setSelectedIndex(0);
		}
		
		/*
		if(unMagasin.getNomB().equals(""))
		{
			// this.txtPas.setText("");
			JOptionPane.showMessageDialog(this, "Erreur dans la mise à jour du magasin " + id);	
		}
		else
		{
			JOptionPane.showMessageDialog(this, "OK !");
			magID.setText("");
			magNom.setText("");
			magDesc.setText("");
			magAdres.setText("");
			magCP.setText("");
			magVille.setText("");
			magElig.setSelectedIndex(0);
		}
		*/
	}
}
