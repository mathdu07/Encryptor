package fr.mathdu07.crypteur.gui;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import fr.mathdu07.crypteur.mode.CrypteurEnum;

public class CrypteurComboBox<E> extends JComboBox implements CrypteurChooserMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 651016237737710178L;

	public CrypteurComboBox() {
		super();
	}

	public CrypteurComboBox(ComboBoxModel aModel) {
		super(aModel);
	}

	public CrypteurComboBox(E[] items) {
		super(items);
	}

	public CrypteurComboBox(Vector<E> items) {
		super(items);
	}

	@Override
	public CrypteurEnum getCrypteurMethod() {
		String selected = this.getSelectedItem().toString();
		
		return CrypteurEnum.byName(selected);
	}

}
