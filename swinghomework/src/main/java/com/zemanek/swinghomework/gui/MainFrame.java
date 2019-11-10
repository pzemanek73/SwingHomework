package com.zemanek.swinghomework.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.zemanek.swinghomework.gui.datamodel.TableModel;
import com.zemanek.swinghomework.gui.datamodel.TableRow;
import com.zemanek.swinghomework.gui.logic.BusinessLogic;

/**
 * Main app frame
 * @author Petr Zemanek
 *
 */
public class MainFrame extends JFrame {

	// GUI components
	private JPanel contentPane;
	private JTextField txtURL;
	private JTable tblRes;

	// Table data model
	private TableModel tblModel = new TableModel();
	
	// BL module
	private BusinessLogic bl = new BusinessLogic();

	/**
	 * Creates the frame.
	 */
	public MainFrame() {
		init();
	}
	
	/**
	 * Initializes the GUI components and layout
	 */
	public void init() {
		setTitle("PZ Swing Homework");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlURL = new JPanel();
		pnlURL.setBorder(new TitledBorder(null, "URL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlURL, BorderLayout.NORTH);
		pnlURL.setLayout(new BorderLayout(0, 0));

		txtURL = new JTextField();
		txtURL.setText("www.cgi.cz");
		pnlURL.add(txtURL, BorderLayout.CENTER);

		JButton btnScan = new JButton("Scan");
		pnlURL.add(btnScan, BorderLayout.EAST);
		btnScan.addActionListener(e -> scan());

		JPanel pnlRes = new JPanel();
		pnlRes.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlRes, BorderLayout.CENTER);
		pnlRes.setLayout(new BorderLayout(0, 0));

		tblRes = new JTable(tblModel);
		JScrollPane scrollPane = new JScrollPane(tblRes);
		pnlRes.add(scrollPane, BorderLayout.CENTER);

	}

	/** 
	 * Scan button action
	 */
	public void scan() {

		String urlText = txtURL.getText();
		if (!urlText.startsWith("http://")) {
			urlText = "http://" + urlText;
		}

		TableRow res = bl.openURL(urlText);		
		tblModel.addRow(res);
		tblModel.fireTableDataChanged();
	}

}

