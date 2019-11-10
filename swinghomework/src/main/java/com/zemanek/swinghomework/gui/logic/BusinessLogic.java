package com.zemanek.swinghomework.gui.logic;

import java.net.HttpURLConnection;
import java.net.URL;

import com.zemanek.swinghomework.gui.datamodel.TableRow;

public class BusinessLogic {

	/**
	 * Opens desired URL
	 * @param urlText
	 * @return new resulting table row
	 */
	public TableRow openURL(String urlText) {
		
		TableRow ret = new TableRow();
		
		URL url = null;
		HttpURLConnection conn = null;
		
		try {
			url = new URL(urlText);
			conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("HEAD");

			ret.setUrl(urlText);
			ret.setSize(conn.getContentLengthLong());
			ret.setServer(conn.getHeaderField("Server"));
			
			/*
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			
			ret.setSize(content.length());
			
			System.out.println(content);
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		
		return ret;
		
	}
	
}
