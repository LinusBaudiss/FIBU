package de.linus.fibu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Queries {

	private DatabaseConnection db;
	private Connection con;
	private static final Logger LOGGER = Logger.getLogger("Queries");

	public Queries(String dbpath) {
		try {
			db = new DatabaseConnection(dbpath);
			con = db.getConnection();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "SQL Exception im Queries Konstruktor - Fehler beim Erstellen der DB Connection!",
					e);
		}

	}

	public double selectTable(String[] info) {
		boolean all = false;
		if (info[0].equals("Gesamtes") && info[1].equals("Erspartes")) {
			all = true;
		}
		double betrag = 0;
		String query = "SELECT SUM(Betrag) AS Gespartes FROM FIBU.TGEHALT;";
		if (!all) {
			query = query.substring(0, query.length() - 1) + " WHERE Gehaltsmonat=? AND Jahr=?;";

		}
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			if (!all) {
				pstmt.setString(1, info[0]);
				pstmt.setString(2, info[1]);
			}
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					betrag = rs.getDouble(1);
				}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "SQL Exception bei Select Statement!", e);
		}
		return betrag;
	}
}