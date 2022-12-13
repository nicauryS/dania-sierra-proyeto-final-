package clases;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagenes {
	
	
	public void Imagenes_Icono(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		ImageIcon icon = new ImageIcon(
		image.getImage().getScaledInstance(32, 32,Image.SCALE_SMOOTH));
		labelName.setIcon(icon);
		
	}
	public void Imagenes_IconoMedianos(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		ImageIcon icon = new ImageIcon(
		image.getImage().getScaledInstance(128, 128,Image.SCALE_SMOOTH));
		labelName.setIcon(icon);
		
	}
	public void Imagenes_IconoInicio(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		ImageIcon icon = new ImageIcon(
		image.getImage().getScaledInstance(64, 64,Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		
	}
	
	
	public void Imagenes_Grandes(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		ImageIcon icon = new ImageIcon(
		image.getImage().getScaledInstance(128, 128,Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		
	}
	public void Imagenes_Error(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		ImageIcon icon = new ImageIcon(
		image.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		labelName.setIcon(icon);
		
	}
}
