/**
 * Feb 24, 2010
 * ClientWindow.java
 */
package hci;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
public class AccountingWindow extends JPanel implements ActionListener, FocusListener, ListSelectionListener {
	private static final long serialVersionUID = -8789755933554786836L;
	
	private ClientBroker cb;
	private DefaultListModel lm;	
	private JList invoiceList;
	private JButton searchButton;	
	private JButton saveButton;
	private JLabel clientLabel;
	private JTextField clientField;
	private JButton paymentButton;
	private JButton addBookingButton;
	private JButton removeBookingButton;
	private JList bookingList;
	private JTextArea infoTextBox;
	private JCheckBox emailCheckBox;
	private JCheckBox printCheckBox;
	private JCheckBox excelCheckBox;
	private JButton reportButton;
	
	/**
	 * Default Constructor
	 */
	public AccountingWindow() {
		try {
			cb = ClientBroker.getBroker();
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		}
		lm = new DefaultListModel();
		
		this.add(this.createListPanel(), BorderLayout.WEST);
		this.add(this.createDetailsPanel(), BorderLayout.EAST);
	}

	private JPanel createListPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel searchPanel = new JPanel(new GridLayout());
		clientLabel = new JLabel("Client: ");
		clientLabel.setHorizontalAlignment(JLabel.TRAILING);
		clientField = new JTextField();
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchPanel.add(clientLabel);
		searchPanel.add(clientField);
		searchPanel.add(searchButton);
		
		JPanel invoicePanel = new JPanel();
		invoicePanel.setBorder(new TitledBorder(new EtchedBorder(), "Invoices"));		
		invoiceList = new JList();
		invoiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invoiceList.setLayoutOrientation(JList.VERTICAL);
		invoiceList.setVisibleRowCount(-1);
		invoiceList.addListSelectionListener(this);		
		JScrollPane listScroller = new JScrollPane(invoiceList);
		listScroller.setPreferredSize(new Dimension(200, 400));
		invoicePanel.add(listScroller);
		
		paymentButton = new JButton("Payment");
		paymentButton.addActionListener(this);

		panel.add(searchPanel, BorderLayout.NORTH);
		panel.add(invoicePanel, BorderLayout.CENTER);
		panel.add(paymentButton, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel createDetailsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Invoice Information"));
		
		JPanel bookingPanel = new JPanel(new BorderLayout());
		bookingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Bookings"));
		
		bookingList = new JList();
		bookingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookingList.setLayoutOrientation(JList.VERTICAL);
		bookingList.setVisibleRowCount(-1);
		bookingList.addListSelectionListener(this);		
		JScrollPane listScroller = new JScrollPane(bookingList);
		listScroller.setPreferredSize(new Dimension(200, 150));

		JPanel bookingButtonPanel = new JPanel(new GridLayout());
		addBookingButton = new JButton("Add Bookings");
		addBookingButton.addActionListener(this);
		removeBookingButton = new JButton("Remove Bookings");
		removeBookingButton.addActionListener(this);
		bookingButtonPanel.add(addBookingButton);
		bookingButtonPanel.add(removeBookingButton);
		
		bookingPanel.add(listScroller, BorderLayout.NORTH);
		bookingPanel.add(bookingButtonPanel, BorderLayout.SOUTH);
		
		JPanel infoPanel = new JPanel(new BorderLayout());
		JPanel infoPanel2 = new JPanel();
		infoPanel2.setBorder(new TitledBorder(new EtchedBorder(), "Additional Information"));
		infoTextBox = new JTextArea(7,20);
		JScrollPane scrollPane = new JScrollPane(infoTextBox);
		infoPanel2.add(scrollPane);
		saveButton = new JButton("Save Invoice");
		saveButton.addActionListener(this);
		infoPanel.add(infoPanel2, BorderLayout.NORTH);
		infoPanel.add(saveButton,  BorderLayout.CENTER);
		
		JPanel reportPanel = new JPanel(new GridLayout(2,4));
		reportPanel.setBorder(new TitledBorder(new EtchedBorder(), "Report To"));
		emailCheckBox = new JCheckBox("Email");
		printCheckBox = new JCheckBox("Report");
		excelCheckBox = new JCheckBox("Excel");
		reportButton =  new JButton("Report");
		reportButton.addActionListener(this);
		reportPanel.add(emailCheckBox);
		reportPanel.add(printCheckBox);
		reportPanel.add(excelCheckBox);
		reportPanel.add(reportButton);

		panel.add(bookingPanel, BorderLayout.NORTH);
		panel.add(infoPanel, BorderLayout.CENTER);
		panel.add(reportPanel, BorderLayout.SOUTH);
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
