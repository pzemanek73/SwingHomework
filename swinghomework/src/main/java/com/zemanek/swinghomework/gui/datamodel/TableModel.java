package com.zemanek.swinghomework.gui.datamodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * Table data model
 * @author Petr Zemanek
 *
 */
public class TableModel extends AbstractTableModel {

	// Data storage
	ArrayList<TableRow> data = new ArrayList<TableRow>();

	@Override
	public int getRowCount() {
		int ret = data.size();
		return ret;
	}

	@Override
	public int getColumnCount() {
		int ret = TableRow.attrCount;
		return ret;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String ret = null;

		TableRow row = data.get(rowIndex);
		if (row != null) {
			switch (columnIndex) {
			case 0:
				ret = row.getUrl();
				break;
			case 1:
				ret = row.getSize().toString();
				break;
			case 2:
				ret = row.getServer();
				break;
			default:
				ret = "";
			}
		}

		return ret;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String ret = null;

		switch (columnIndex) {
		case 0:
			ret = "URL";
			break;
		case 1:
			ret = "Response Size";
			break;
		case 2:
			ret = "Server";
			break;
		default:
			ret = "Col " + columnIndex;
		}
		
		return ret;
	}

	@Override
	public Class<String> getColumnClass(int columnIndex) {
		return String.class;
	}

	/**
	 * Adds a new row into the model
	 * 
	 * @param row
	 */
	synchronized public void addRow(TableRow row) {
		data.add(row);
	}

}
