import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;

import javax.swing.*;

public class MainClass {
	
	public static void main(String args[]){
		JFrame window = new JFrame();
		SystemGUI sg = new SystemGUI();
		double ei = sg.promptForWeight();
		System.out.println(ei);
	}
}
