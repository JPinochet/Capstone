/**
 * Feb 24, 2010
 * ClientWindow.java
 */
package hci;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exceptions.DatabaseConnectionException;

import persistence.ClientBroker;

/**
 * @author Corey Cantley
 * @version 1.0
 */
public class ScheduleWindow extends JPanel implements ActionListener, FocusListener, ListSelectionListener {
	private static final long serialVersionUID = -8789755933554786836L;
	
	private ClientBroker cb;
	private DefaultListModel lm;
	
	private JList clientList;
	private JTextField searchField;
	private JButton searchButton;
	private JButton clearSearchButton;
	
	private JLabel givenNameLabel;
	private JTextField givenNameField;
	
	private JLabel surnameLabel;
	private JTextField surnameField;
	
	private JLabel emailLabel;
	private JTextField emailField;
	
	private JLabel streetLabel;
	private JTextField streetField;
	
	private JLabel postalCodeLabel;
	private JTextField postalCodeField;
	
	private JLabel cityLabel;
	private JTextField cityField;
	
	private JLabel provLabel;
	private JTextField provField;
	
	private JLabel countryLabel;
	private JTextField countryField;
	
	private JLabel discountLabel;
	private JTextField discountField;
	
	private JList phoneList;
	private JButton addPhoneButton;
	private JButton removePhoneButton;
	
	private JList orgList;
	
	private JButton saveButton;
	private JButton deleteButton;
	
	/**
	 * Default Constructor
	 */
	public ScheduleWindow() {
		try {
			cb = ClientBroker.getBroker();
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		}
		lm = new DefaultListModel();
		
		this.add(this.createListPanel(), BorderLayout.NORTH);
		this.add(this.createDetailsPanel(), BorderLayout.SOUTH);
	}

	private JPanel createListPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Availiable Clients"));
		
		clientList = new JList();
		clientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clientList.setLayoutOrientation(JList.VERTICAL);
		clientList.setVisibleRowCount(-1);
		clientList.addListSelectionListener(this);
		
		JScrollPane listScroller = new JScrollPane(clientList);
		listScroller.setPreferredSize(new Dimension(640, 110));
		panel.add(listScroller, BorderLayout.NORTH);
		
		panel.add(createSearchPanel(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createSearchPanel() {
		JPanel panel = new JPanel(new GridLayout(1,3));	
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Search Clients"));
		
		searchField = new JTextField("");
		searchField.addFocusListener(this);
		panel.add(searchField);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		clearSearchButton = new JButton("Clear Search");
		clearSearchButton.addActionListener(this);
		panel.add(clearSearchButton);
		
		return panel;
	}
	
	private JPanel createDetailsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Client Details"));
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(createPhonePanel(), BorderLayout.NORTH);
		panel2.add(createOrgPanel(), BorderLayout.CENTER);
		panel2.add(createControlPanel(), BorderLayout.SOUTH);
		
		panel.add(createInputPanel(), BorderLayout.WEST);		
		panel.add(panel2, BorderLayout.EAST);
		
		
		
		return panel;
	}
	
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new GridLayout(9,2));
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Client Details"));
		
		givenNameLabel = new JLabel("Given Name: ");
		givenNameLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(givenNameLabel);
		givenNameField = new JTextField();
		givenNameField.addFocusListener(this);
		panel.add(givenNameField);
		
		surnameLabel = new JLabel("Surname: ");
		surnameLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(surnameLabel);
		surnameField = new JTextField();
		surnameField.addFocusListener(this);
		panel.add(surnameField);
		
		emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(emailLabel);
		emailField = new JTextField();
		emailField.addFocusListener(this);
		panel.add(emailField);
		
		streetLabel = new JLabel("Street: ");
		streetLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(streetLabel);
		streetField = new JTextField();
		streetField.addFocusListener(this);
		panel.add(streetField);
		
		postalCodeLabel = new JLabel("Postal Code: ");
		postalCodeLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(postalCodeLabel);
		postalCodeField = new JTextField();
		postalCodeField.addFocusListener(this);
		panel.add(postalCodeField);
		
		cityLabel = new JLabel("City: ");
		cityLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(cityLabel);
		cityField = new JTextField();
		cityField.addFocusListener(this);
		panel.add(cityField);
		
		provLabel = new JLabel("Province/State: ");
		provLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(provLabel);
		provField = new JTextField();
		provField.addFocusListener(this);
		panel.add(provField);
		
		countryLabel = new JLabel("Country: ");
		countryLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(countryLabel);
		countryField = new JTextField();
		countryField.addFocusListener(this);
		panel.add(countryField);
		
		discountLabel = new JLabel("Discount: ");
		discountLabel.setHorizontalAlignment(JLabel.TRAILING);
		panel.add(discountLabel);
		discountField = new JTextField();
		discountField.addFocusListener(this);
		panel.add(discountField);
		
		return panel;
	}
	
	private JPanel createPhonePanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Phone Numbers"));
		
		phoneList = new JList();
		phoneList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		phoneList.setLayoutOrientation(JList.VERTICAL);
		phoneList.setVisibleRowCount(-1);
		phoneList.addListSelectionListener(this);		
		JScrollPane listScroller = new JScrollPane(phoneList);
		listScroller.setPreferredSize(new Dimension(200, 110));
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		panel.add(listScroller, c);
		
		addPhoneButton = new JButton("Add");
		addPhoneButton.addActionListener(this);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		panel.add(addPhoneButton, c);
		
		removePhoneButton = new JButton("Remove");
		removePhoneButton.addActionListener(this);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		panel.add(removePhoneButton, c);
		
		return panel;
	}
	
	private JPanel createOrgPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Organizations"));
		
		orgList = new JList();
		orgList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		orgList.setLayoutOrientation(JList.VERTICAL);
		orgList.setVisibleRowCount(-1);
		orgList.addListSelectionListener(this);		
		JScrollPane listScroller = new JScrollPane(orgList);
		listScroller.setPreferredSize(new Dimension(200, 110));
		panel.add(listScroller);
		
		return panel;
	}
	
	private JPanel createControlPanel() {
		JPanel panel = new JPanel(new GridLayout(1,2));	

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		return panel;		
	}

	/**
	 * Closes any resources related to the client window
	 */
	public void close() {
		cb.close();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent e) {
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
	}

}
