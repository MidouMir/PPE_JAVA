package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.jws.WebParam.Mode;
import javax.swing.border.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vue.Connexion;
import vue.General;
import controleur.Main;
import controleur.Profil;
import modele.Modele;

public class VueConnex extends JPanel implements ActionListener, KeyListener {
	private JTextField txtLog		= new JTextField();
	private JPasswordField txtPas	= new JPasswordField();

	private JButton btAnnuler		= new JButton("Annuler");
	private JButton btValider		= new JButton("Connexion");
	private static General uneVueGenerale;
	
	public VueConnex()
	{
		this.setBounds(100, 150, 600, 300);
		this.setLayout(new GridLayout (1, 4));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		
		this.setLayout(new GridLayout (4, 4));
		this.add(new JLabel(""));
		this.add(new JLabel(" Login : "));
		this.add(this.txtLog);
		this.add(new JLabel(""));
		this.txtLog.addKeyListener(this);

		this.add(new JLabel(""));
		this.add(new JLabel(" Pass : "));
		this.add(this.txtPas);
		this.add(new JLabel(""));
		this.txtPas.addKeyListener(this);

		this.add(this.btValider);
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(this.btAnnuler);
		
		this.setBackground(new Color(255, 255, 255));
		
		this.btAnnuler.setIcon(new ImageIcon("src/img/annuler.png"));
		this.btAnnuler.setBackground( new Color (255, 195, 0) );
		this.btAnnuler.setForeground(Color.BLACK);
		this.btAnnuler.addActionListener(this);
		// this.btValider.setIcon(new ImageIcon("src/img/valider.png"));
		this.btValider.setBackground( new Color (255, 195, 0) );
		this.btValider.setForeground(Color.BLACK);
		this.btValider.addActionListener(this);
		AbstractBorder brdr = new TextBubbleBorder(Color.WHITE, 5, 16, 0);
		this.setBorder(brdr);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btAnnuler)
		{
			this.txtLog.setText("");
			this.txtPas.setText("");
		}
		else if(e.getSource() == this.btValider)
		{
			this.ActionConnexion();
		}
	}
	
	public void ActionConnexion()
	{
		String login		= this.txtLog.getText();
		String pass			= new String(this.txtPas.getPassword());
		/* String passSha 		= Main.Sha1(pass); */ 
		Profil unProfil 	= Modele.selectWhere(login, pass);
		if(unProfil==null)
		{
			this.txtPas.setText("");
			JOptionPane.showMessageDialog(this, "Verifiez les identifiants");	
		}
		else
		{
			this.txtLog.setText("");
			this.txtPas.setText("");
			//new General(unProfil);
			uneVueGenerale = new General(unProfil);
			Main.rendreVisible(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			this.ActionConnexion();	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static General getUneVueGenerale()
	{
		return uneVueGenerale;
	}
}
