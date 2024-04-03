package com.agriconnect.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource ds = null;

	public static Connection getConnection() {
		if (ds == null) {
			try {
				FileInputStream fis = new FileInputStream(new File(
						"C:\\Users\\DELL\\eclipse-workspace\\AgriConnect\\src\\main\\java\\config.properties"));

				Properties p = new Properties();
				p.load(fis);

				HikariConfig config = new HikariConfig();
				config.setUsername(p.getProperty("db.username"));
				config.setPassword(p.getProperty("db.password"));
				config.setJdbcUrl(p.getProperty("db.url"));
				config.setDriverClassName(p.getProperty("db.driver"));
				ds = new HikariDataSource(config);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
