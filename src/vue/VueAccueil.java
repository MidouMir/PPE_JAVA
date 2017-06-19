package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

import com.mysql.fabric.xmlrpc.base.Params;

import controleur.Main;
import controleur.Profil;

public class VueAccueil extends JPanel implements ActionListener {

	private JTextArea txtInfos		= new JTextArea();
	private JButton blockMagasins	= new JButton("Magasins");
	private JButton blockProduits	= new JButton("Produits");
	private JButton blockAlerte		= new JButton("Alerte");
	
	public VueAccueil(Profil unProfil) {
		this.setBounds(50, 50, 700, 300);
		this.setLayout(null);
		this.setBackground(new Color(255, 255, 255));
		AbstractBorder brdr = new TextBubbleBorder(Color.WHITE, 1, 16, 0);
		this.setBorder(brdr);
		/*
		this.txtInfos.setBounds(30, 30, 150, 150);
		this.txtInfos.setEditable(false);
		String infos = "[Administrateur]\n"+ unProfil.getNomComplet();
		this.txtInfos.setText(infos);
		this.add(this.txtInfos);
		*/

		//Font JLW = new Font("/src/fonts/JusticeLeagueWeb.ttf");

		/*
		Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/src/fonts/JusticeLeagueWeb.ttf").openStream());   
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		//makesure to derive the size
		font = font.deriveFont(12f);
		*/

		//use the font
		//this.blockMagasins.setFont();
		// Font font = new Font("Courier", Font.BOLD,12);
        
        //set font for JTextField
		// this.blockMagasins.setFont(font);
        
		this.blockMagasins.setIcon(new ImageIcon("src/img/annuler.png"));
		
		this.txtInfos.setBounds(30, 30, 150, 20);
		this.txtInfos.setEditable(false);
		String infos = "[Connecté en tant que]\n"+ unProfil.getNomComplet();
		this.txtInfos.setText(infos);
		this.add(this.txtInfos);

		this.setLayout(new GridLayout (3, 2));
		
		this.add(this.blockMagasins);
		this.blockMagasins.setBackground( new Color (255, 195, 0) );
		
		this.add(this.blockProduits);
		this.blockProduits.setBackground( new Color (255, 195, 0) );
		
		/*
		this.add(this.blockAlerte);
		this.blockAlerte.setBackground( new Color (255, 195, 0) );
		*/
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
