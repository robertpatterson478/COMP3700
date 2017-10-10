import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class SystemGUI {

	public int promptForProductID() {
		PromptDialog window = new PromptDialog("######", "Enter product ID", "000000");
		int i = Integer.parseInt(window.field.getText());
		if (window.isCanceled) {
			return -1;
		}
		return i;
	}

	public double promptForWeight() {
		PromptDialog window = new PromptDialog("#####.###", "Enter weight of item", "00000.000");
		double d = Double.parseDouble(window.field.getText());
		if (window.isCanceled) {
			return -1;
		}
		return d;
	}

	public double promptForPrice() {
		PromptDialog window = new PromptDialog("#####.##", "Enter weight of item", "00000.00");
		double d = Double.parseDouble(window.field.getText());
		if (window.isCanceled) {
			return -1;
		}
		return d;
	}

	public void managementEditProduct(boolean editing) {

		EditWindow ew = new EditWindow();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		ew.setPreferredSize(screen);

		ew.setUndecorated(true);

		ew.setModal(true);

		ew.pack();

		ew.setVisible(true);
	}

	private class EditWindow extends JDialog {
		private JLabel nameLabel;
		private JLabel productIdLabel;
		private JLabel priceLabel;
		private JLabel providerInfoLabel;
		private JLabel providerLabel;
		private JLabel metricOfMeasLabel;
		private JLabel quantityLabel;
		private JLabel taxRateLabel;

		MaskFormatter maskPrice;
		MaskFormatter maskID;
		MaskFormatter taxMask;
		MaskFormatter quantityRemainingMask;

		private JFormattedTextField nameField;
		private JCheckBox metricOfMeasureBox;
		private JFormattedTextField priceField;
		private JFormattedTextField quantityRemainingField;
		private JFormattedTextField productIdField;
		private JFormattedTextField providerNameField;
		private JFormattedTextField providerInfoField;
		private JFormattedTextField taxRateField;

		private Product currentProduct;

		GridLayout gl;

		private JPanel container;

		private Dimension screen;

		JButton cancel;
		JButton submit;

		public EditWindow() {
			// super("Edit a product");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			Font font = new Font("SansSerif Bold", Font.BOLD, 72);
			setFont(font);
			screen = Toolkit.getDefaultToolkit().getScreenSize();

			setSize((int) screen.getWidth(), (int) screen.getHeight());
			setResizable(false);

			container = new JPanel();
			container.setSize(screen.width, screen.height);

			// make labels

			nameLabel = new JLabel("Product Name: ");
			productIdLabel = new JLabel("Product ID: ");
			priceLabel = new JLabel("Price: ");
			providerInfoLabel = new JLabel("Provider Information: ");
			providerLabel = new JLabel("Provider: ");
			metricOfMeasLabel = new JLabel("Measured by Weight: ");
			quantityLabel = new JLabel("Quantity Remaining: ");
			taxRateLabel = new JLabel("Tax Rate: ");

			nameLabel.setFont(font);
			productIdLabel.setFont(font);
			priceLabel.setFont(font);
			providerInfoLabel.setFont(font);
			metricOfMeasLabel.setFont(font);
			quantityLabel.setFont(font);
			taxRateLabel.setFont(font);
			providerLabel.setFont(font);
			// make fields
			try {
				maskPrice = new MaskFormatter("$####.##");
				maskID = new MaskFormatter("######");
				taxMask = new MaskFormatter("##.## %");
				quantityRemainingMask = new MaskFormatter("#####.### units");
				nameField = new JFormattedTextField();
				priceField = new JFormattedTextField(maskPrice);
				quantityRemainingField = new JFormattedTextField(quantityRemainingMask);
				productIdField = new JFormattedTextField(maskID);
				metricOfMeasureBox = new JCheckBox();
				providerNameField = new JFormattedTextField();
				providerInfoField = new JFormattedTextField();
				taxRateField = new JFormattedTextField(taxMask);
				priceField.setText("$0000.00");
				productIdField.setText("000000");
				taxRateField.setText("00.00%");
				quantityRemainingField.setText("00000.000 units");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			metricOfMeasureBox.setSize(screen);

			nameField.setFont(font);
			priceField.setFont(font);
			quantityRemainingField.setFont(font);
			productIdField.setFont(font);
			providerNameField.setFont(font);
			providerInfoField.setFont(font);
			taxRateField.setFont(font);

			// add to container

			container.add(nameLabel);
			container.add(nameField);
			container.add(productIdLabel);
			container.add(productIdField);
			container.add(priceLabel);
			container.add(priceField);
			container.add(metricOfMeasLabel);
			container.add(metricOfMeasureBox);
			container.add(taxRateLabel);
			container.add(taxRateField);
			container.add(quantityLabel);
			container.add(quantityRemainingField);
			container.add(providerLabel);
			container.add(providerNameField);
			container.add(providerInfoLabel);
			container.add(providerInfoField);

			// define buttons
			cancel = new JButton("Cancel");
			submit = new JButton("Submit");

			cancel.setFont(font);
			submit.setFont(font);

			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// called when cancel button Pressed

					dispose();
					// TODO Auto-generated method stub
				}
			});
			submit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// called when submit button Pressed
					createProduct();
					// TODO Auto-generated method stub
					dispose();
				}
			});
			container.add(cancel);
			container.add(submit);

			// define layout

			gl = new GridLayout(9, 2);
			container.setLayout(gl);

			// show window

			getContentPane().add(container);

		}

		private void createProduct() {

			currentProduct = new Product(Integer.parseInt(productIdField.getText()),
					Double.parseDouble(priceField.getText().substring(1, 7)),
					Double.parseDouble(taxRateField.getText().substring(0, 4)),
					Double.parseDouble(quantityRemainingField.getText().substring(0, 8)),
					metricOfMeasureBox.isSelected(), nameField.getText(), providerInfoField.getText(),
					providerNameField.getText());

		}

	}
}

class PromptDialog extends JDialog {
	JButton accept;
	JButton cancel;
	MaskFormatter format;
	JPanel jp;
	Font windowFont;
	Dimension screen;
	JFormattedTextField field;
	boolean isCanceled;

	public PromptDialog(String formatString, String title, String defaultText) {
		super();
		isCanceled = false;
		setTitle(title);

		windowFont = new Font("SansSerif", Font.BOLD, 28);

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		accept = new JButton("Accept");
		accept.setFont(windowFont);
		cancel = new JButton("Cancel");
		cancel.setFont(windowFont);

		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				isCanceled = true;
				// TODO Auto-generated method stub
				dispose();
			}

		});
		field = new JFormattedTextField();
		try {
			format = new MaskFormatter(formatString);
			field = new JFormattedTextField(format);
			field.setText(defaultText);
			field.setFont(windowFont);
		} catch (Exception e) {

		}
		setLocationRelativeTo(null);
		screen.setSize(screen.width * 22 / 100, screen.height / 10);

		setPreferredSize(screen);
		jp = new JPanel();
		jp.add(field);
		jp.add(accept);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jp.add(cancel);
		setLayout(new SpringLayout());
		getContentPane().add(jp);
		setModal(true);
		pack();
		setVisible(true);

	}

}