package fr.mathdu07.crypteur.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.mathdu07.crypteur.Crypteur;
import fr.mathdu07.crypteur.CrypteurInput;
import fr.mathdu07.crypteur.CrypteurOutput;

public class CrypteurInvocatorListener implements ActionListener {
	
	private CrypteurInput input;
	private CrypteurOutput output;

	public CrypteurInvocatorListener(CrypteurInput input, CrypteurOutput output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof CrypteurInvocator){
			CrypteurInvocator inv = (CrypteurInvocator) e.getSource();
			
			if (inv.getToggleCrypte())
				Crypteur.encrypte(input, output);
			else
				Crypteur.decrypte(input, output);
		}
			
	}

}
