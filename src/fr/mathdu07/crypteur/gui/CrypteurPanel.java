package fr.mathdu07.crypteur.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import fr.mathdu07.crypteur.Crypteur;
import fr.mathdu07.crypteur.CrypteurInput;
import fr.mathdu07.crypteur.CrypteurOutput;
import fr.mathdu07.crypteur.mode.CrypteurEnum;


/**
 * 
 * The panel which render input parameters and output informations
 */

public class CrypteurPanel extends JPanel implements CrypteurInput, CrypteurOutput {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5326786043879876156L;
	
	private JLabel title = new JLabel("Basic Crypteur");
	private JLabel about = new JLabel ("v" + Crypteur.version + " by mathdu07");
	
	private JPanel subPanel = new JPanel(new BorderLayout());
	private JPanel choosePanel = new JPanel();
	private JPanel actionPanel = new JPanel();
	private JPanel stringPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	
	private JLabel keyLabel = new JLabel("Clé de cryptage");
	private JComponent keyTextField = new JSpinner(new SpinnerNumberModel(1, 1, 25, 1));
	private JLabel modeLabel = new JLabel("Mode de cryptage");
	private CrypteurComboBox<String> modeList = new CrypteurComboBox<String>(Crypteur.list);
	
	private CrypteurButton encryptorButton = new CrypteurButton("Crypter");
	private CrypteurButton decryptorButton = new CrypteurButton("Décrypter");
	
	private JTextArea encryptedArea = new JTextArea("Phrase à crypter");
	private JTextArea decryptedArea = new JTextArea("Phrase à décrypter");

	/**
	 * Create a new EncryptorPanel
	 */
	protected CrypteurPanel() {
		super(new BorderLayout());
		
		initPanel();
	}
	
	private void initPanel(){
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 25));
		about.setHorizontalAlignment(SwingConstants.RIGHT);
		about.setForeground(Color.BLACK);
		
		modeList.setPreferredSize(new Dimension(100, 20));
		encryptorButton.setToggleCrypte(true);
		decryptorButton.setToggleCrypte(false);
		encryptorButton.addActionListener(new CrypteurInvocatorListener(this, this));
		decryptorButton.addActionListener(new CrypteurInvocatorListener(this, this));
		modeList.addItemListener(new CrypteurChooserListener(this));
		modeList.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeList.setPopupVisible(true);	
				
			}
		});
		
		encryptedArea.setBorder(new TitledBorder("A crypter"));
		decryptedArea.setBorder(new TitledBorder("A décrypter"));
		encryptedArea.setDragEnabled(true);
		decryptedArea.setDragEnabled(true);
		
		subPanel.setBackground(Color.WHITE);
		subPanel.add(choosePanel, BorderLayout.NORTH);
		subPanel.add(actionPanel, BorderLayout.SOUTH);
		subPanel.add(stringPanel);
		
		choosePanel.add(keyLabel);
		choosePanel.add(keyTextField);
		choosePanel.add(modeLabel);
		choosePanel.add(modeList);
		
		actionPanel.add(encryptorButton);
		actionPanel.add(decryptorButton);
		
		ScrollPane encryptedPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		encryptedPane.add(encryptedArea);
		stringPanel.add(encryptedPane);
		ScrollPane decryptedPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		decryptedPane.add(decryptedArea);
		stringPanel.add(decryptedPane);
		
		this.setBackground(new Color(150, 150, 150));
		this.add(title, BorderLayout.NORTH);
		this.add(about, BorderLayout.SOUTH);
		this.add(subPanel);
	}

	@Override
	public void setDecryptedStr(String str) {
		encryptedArea.setText(str);
	}

	@Override
	public void setCryptedStr(String str) {
		decryptedArea.setText(str);
	}

	@Override
	public void setKeyAsInteger(int max) {
		if (keyTextField instanceof JSpinner){
			if (((JSpinner)keyTextField).getModel() instanceof SpinnerNumberModel){
				SpinnerNumberModel mod = (SpinnerNumberModel)((JSpinner)keyTextField).getModel();
				if (!mod.getMaximum().equals(max))
					return;
			}
		}
		
		choosePanel.remove(keyTextField);
		keyTextField = new JSpinner(new SpinnerNumberModel(1, 1, max, 1));
		choosePanel.add(keyTextField, 1);
		
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void setKeyAsCharacter() {
		choosePanel.remove(keyTextField);
		try {
			keyTextField = new JFormattedTextField(new MaskFormatter("*"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		keyTextField.setPreferredSize(new Dimension(30, 30));
		choosePanel.add(keyTextField, 1);
		
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public int getKey() {
		int key;
		if (keyTextField instanceof JSpinner)
			key = (Integer) ((JSpinner)keyTextField).getValue();
		else{
			String text  = ((JTextField)keyTextField).getText();
			if (text == null || text == "")
				key = 0;
			else
				key = text.charAt(0);
		}
			
		return key;
	}

	@Override
	public CrypteurEnum getCrypteurMode() {
		return modeList.getCrypteurMethod();
	}

	@Override
	public String getStringToEncrypted() {
		return encryptedArea.getText();
	}

	@Override
	public String getStringToDecrypted() {
		return decryptedArea.getText();
	}

}
