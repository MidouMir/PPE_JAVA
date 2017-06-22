package vue;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

import controleur.Client;
import controleur.Magasin;
import controleur.Produits;
import controleur.Tableau;
import modele.ModeleClient;
import modele.ModeleMagasins;
import modele.ModeleProduits;

public class VueProduits extends JPanel implements ActionListener, MouseListener {

	private JPanel panneau	= new JPanel();
	private JPanel edition	= new JPanel();
	private JPanel actions	= new JPanel();
	private JLabel lbTitre	= new JLabel("Liste des produits\n");
	private JTable tableProduits;
	
	private static Tableau contenu;

	private JLabel labelID		= new JLabel("ID");
	private JTextArea prodID	= new JTextArea("");
	private JLabel labelNom		= new JLabel("Nom");
	private JTextArea prodNom	= new JTextArea("");
	private JLabel labelDesc	= new JLabel("Description");
	private JTextArea prodDesc	= new JTextArea("");
	private JLabel labelPrix	= new JLabel("Prix");
	private JTextArea prodPrix	= new JTextArea("");
	private JLabel labelPhoto	= new JLabel("Photo");
	private JTextArea prodPhoto	= new JTextArea("");
	private JLabel labelCat		= new JLabel("Photo");
	private JTextArea prodCat	= new JTextArea("");
	private JButton btnPhoto	= new JButton("+");
	private JButton btnAjout	= new JButton("Nouveau produit");
	private JButton btnModif	= new JButton("Mettre à jour");
	
	public VueProduits() {
		
		this.setBounds(50, 50, 700, 400);
		AbstractBorder brdr2 = new TextBubbleBorder(Color.BLACK, 1, 16, 0);
		this.setBorder(brdr2);
		this.setLayout(null);
		
		panneau.setBounds(25, 50, 650, 200);
		panneau.setLayout(null);		
		this.add(panneau);

		// labels
		labelID.setBounds(0, 0, 50, 20);
		labelNom.setBounds(60, 0, 100, 20);
		labelPrix.setBounds(310, 0, 150, 20);
		labelPhoto.setBounds(0, 35, 50, 20);
		labelDesc.setBounds(300, 35, 75, 20);
		btnAjout.setBounds(160, 105, 150, 25);
			btnAjout.setBackground( new Color (255, 195, 0) );
			btnAjout.addActionListener(this);
		btnModif.setBounds(0, 105, 150, 25);
			btnModif.setBackground( new Color (255, 195, 0) );
			btnModif.addActionListener(this);

		edition.add(labelID);
		edition.add(labelNom);
		edition.add(labelPrix);
		edition.add(labelPhoto);
		edition.add(labelDesc);
		edition.add(btnAjout);
		edition.add(btnModif);
		
		prodID.setBounds(25, 0, 25, 20);
		prodID.setBackground( new Color (255, 195, 0) );
		prodID.setDisabledTextColor(Color.BLACK);
		prodID.setEnabled(false);
		
		prodNom.setBounds(100, 0, 175, 20);
		prodNom.setBackground( new Color (255, 195, 0) );
		
		prodPrix.setBounds(370, 0, 75, 20);
		prodPrix.setBackground( new Color (255, 195, 0) );
		
		prodPhoto.setBounds(40, 35, 180, 50);
		prodPhoto.setBackground( new Color (255, 195, 0) );
		prodPhoto.setWrapStyleWord(true);
		prodPhoto.setLineWrap(true);
		
		btnPhoto.setBounds(240, 35, 50, 20);
		btnPhoto.setBackground( new Color (255, 195, 0) );
		btnPhoto.addActionListener(this);

		prodDesc.setBounds(370, 35, 275, 50);
		prodDesc.setBackground( new Color (255, 195, 0) );
		prodDesc.setWrapStyleWord(true);
		prodDesc.setLineWrap(true);

		edition.add(prodID);
		edition.add(prodNom);
		edition.add(prodPrix);
		edition.add(prodPhoto);
		edition.add(prodDesc);
		edition.add(btnPhoto);
		
		edition.setBounds(15, 250, 650, 145);
		edition.setLayout(null);		
		this.add(edition);
		
		this.setBackground( new Color (255, 255, 255) );
		panneau.setBackground( new Color (255, 255, 255) );
		edition.setBackground( new Color (255, 255, 255) );
		
		this.lbTitre.setBounds(20, 20, 200, 20);
		this.add(lbTitre);
		
		//construction de la JTable
		String entete[]		= {"ID", "Nom", "Desc", "Prix", "Photo", "Catégorie"};
		contenu = new Tableau(this.extraireProduits(), entete);
		this.tableProduits	= new JTable(contenu);
		JScrollPane uneScroll	= new JScrollPane(tableProduits);
		uneScroll.setBounds(0, 0, 650, 175);
		panneau.add(uneScroll);
		
		actions.setBounds(25, 400, 650, 200);
		actions.setLayout(null);		
		this.add(actions);
		actions.setBackground( new Color (255, 0, 0) );

		tableProduits.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int i = tableProduits.getSelectedRow();
				prodID.setText(tableProduits.getValueAt(i, 0).toString());
				prodNom.setText(tableProduits.getValueAt(i, 1).toString());
				prodDesc.setText(tableProduits.getValueAt(i, 2).toString());
				prodPrix.setText(tableProduits.getValueAt(i, 3).toString());
				prodPhoto.setText(tableProduits.getValueAt(i, 4).toString());
			}
			
		});
        
		btnPhoto.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JFileChooser fileChooser = new JFileChooser();
	 
	        // For Directory
	        // fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	 
	        // For File
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	 
	        fileChooser.setAcceptAllFileFilterUsed(false);
	        	 
	        int rVal = fileChooser.showOpenDialog(null);
	        if (rVal == JFileChooser.APPROVE_OPTION) {
	        	File selectedFile = fileChooser.getSelectedFile();
	        	String filePath = selectedFile.getAbsolutePath();
	        	InputStream inStream = null;
                OutputStream outStream = null;
                String titre	= "";
                int tailleTab	= tableProduits.getRowCount();
                String nouvelID	= String.valueOf(tailleTab + 1);
                
                if( prodID.getText().equals("") )
                {
                    titre = nouvelID;
                }
                else
                {
                    titre = prodID.getText();
                }
                
                DateFormat leFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                Date laDate = new Date();
                
                String extension = "";
                int i = selectedFile.getName().lastIndexOf('.');
                if (i > 0) {
                    extension = selectedFile.getName().substring(i+1);
                }
                
                try{
                    File source =new File(filePath);
                    File dest = new File( "C:\\wamp64\\www\\mcdeliver\\images\\produits\\" + titre + "-" + leFormat.format(laDate) + "." + extension );
                    // File dest = new File( System.getProperty("user.home") + "\\" + selectedFile.getName());
                    inStream = new FileInputStream(source);
                    outStream = new FileOutputStream(dest);

                    byte[] buffer = new byte[1024];

                    int length;
                    while ((length = inStream.read(buffer)) > 0){
                        outStream.write(buffer, 0, length);
                    }

                    if (inStream != null)inStream.close();
                    if (outStream != null)outStream.close();
                    System.out.println("File Copied !");
                }catch(IOException e1){
                    e1.printStackTrace();
                }
                // prodPhoto.setText(fileChooser.getSelectedFile().toString());
                prodPhoto.setText( "/images/produits/" + titre + "-" + leFormat.format(laDate) + "." + extension );
            }
            else System.out.println("Failed to Load");
	      }
	    });
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnModif)
		{
			majProduits();
		}
	}
	public Object [][] extraireProduits()
	{
		ArrayList<Produits> lesProduits	= ModeleProduits.selectAll();
		Object [][]donnees	= new Object[lesProduits.size()][6];
		int i=0;
		String laCat = "";
		for(Produits unProduit : lesProduits)
		{
			donnees [i][0]	= unProduit.getIdP();
			donnees [i][1]	= unProduit.getNomP();
			donnees [i][2]	= unProduit.getDescP();
			donnees [i][3]	= unProduit.getPrixP();
			donnees [i][4]	= unProduit.getPhotoP();
			if(unProduit.getCatP().equals("1")){
				laCat = "Sandwich";
			}
			else if(unProduit.getCatP().equals("2")){
				laCat = "Boissons";
			}
			else if(unProduit.getCatP().equals("3")){
				laCat = "Desserts";
			}
			// donnees [i][5]	= unProduit.getCatP();
			donnees [i][5]	= laCat;
			i++;
		}
		return donnees;
	}
	
	public void majProduits()
	{
		String id		= prodID.getText();
		String nom		= prodNom.getText();
		String desc		= prodDesc.getText();
		String prix		= prodPrix.getText();
		String photo	= prodPhoto.getText();
		String categ	= prodCat.getText();
		
		if(id.equals("") || nom.equals("") || desc.equals("") || prix.equals("") || photo.equals("") || categ.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Les champs doivent tous être renseignés");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Produit mis à jour !");
			ModeleProduits.update(id, nom, desc, prix, photo, categ);
			prodID.setText("");
			prodNom.setText("");
			prodDesc.setText("");
			prodPrix.setText("");
			prodPhoto.setText("");
			prodCat.setText("");
		}
	}
	
	public void ajoutProduits()
	{
		String id		= prodID.getText();
		String nom		= prodNom.getText();
		String desc		= prodDesc.getText();
		String prix		= prodPrix.getText();
		String photo	= prodPhoto.getText();
		String cat		= prodCat.getText();
		
		if(id.equals("") || nom.equals("") || desc.equals("") || prix.equals("") || photo.equals("") || cat.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Les champs doivent tous être renseignés");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Produit ajouté !");
			ModeleProduits.update(id, nom, desc, prix, photo, cat);
			prodID.setText("");
			prodNom.setText("");
			prodDesc.setText("");
			prodPrix.setText("");
			prodPhoto.setText("");
			prodCat.setText("");
			Produits unProduit = ModeleProduits.selectWhere(nom, prix);
			Object[] donnees = { unProduit.getIdP(), unProduit.getNomP(), unProduit.getDescP(),
					unProduit.getPrixP(), unProduit.getPhotoP(), unProduit.getCatP() };
			contenu.addRow(donnees);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
