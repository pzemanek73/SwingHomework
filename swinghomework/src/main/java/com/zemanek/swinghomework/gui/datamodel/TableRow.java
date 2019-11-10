package com.zemanek.swinghomework.gui.datamodel;

/**
 * Class representing table row data
 * @author Petr Zemanek
 *
 */
public class TableRow {

	// Attribute count
	public static final int attrCount = 3;
	
	// Attributes
	private String url = null;
	private Long size = null;
	private String server = null;

	/**
	 * Constructor
	 */
	public TableRow() {		
	}
	
	/**
	 * Constructor
	 * @param url
	 * @param size
	 * @param server
	 */
	public TableRow(String url, Long size, String server) {
		this.url = url;
		this.size = size;
		this.server = server;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(String server) {
		this.server = server;
	}
}
