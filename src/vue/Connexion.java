package vue;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import vue.VueConnex;

public class Connexion extends JFrame {
	
	private static VueConnex uneVueConnex;
	
	
	public Connexion()
	{
		this.setTitle("Administration");
		this.setLayout(null);
		// this.getContentPane().setBackground(new Color(207, 216, 220));
		this.getContentPane().setBackground(new Color(0, 70, 18));
		this.setResizable(false);
		JLabel titre = new JLabel(new ImageIcon("src/img/logo.png"));
		this.add(titre);
		this.setBounds(100, 100, 800, 600);
		ImageIcon logo = new ImageIcon("src/img/logo.png");
		this.setIconImage(logo.getImage());
		JLabel unLogo = new JLabel(logo);
		unLogo.setBounds(300, 50, 150, 100);
		this.add(unLogo);
		
		
		AbstractBorder brdr = new TextBubbleBorder(Color.WHITE, 2, 16, 0);
		
		uneVueConnex = new VueConnex();
		this.add( uneVueConnex );
		this.setVisible(true);
	}

}
