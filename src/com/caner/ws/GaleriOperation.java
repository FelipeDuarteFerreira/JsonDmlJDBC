package com.caner.ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.caner.database.ConnectionDatabase;
import com.caner.entity.GaleriEntity;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GaleriOperation {
	Connection getConnect;
	PreparedStatement preparedStatement;

	public void insertDatabase(GaleriEntity galeriEntity) throws Throwable {

		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		getConnect = connectionDatabase.getConnection("Ogrenci_db", "root", "");
		try {
			String sqlInsert = "INSERT INTO galeri(carName,carModel,carColour) VALUES(?,?,?)";
			PreparedStatement statement = getConnect.prepareStatement(sqlInsert);
			statement.setString(1, galeriEntity.getCarName());
			statement.setInt(2, galeriEntity.getCarModel());
			statement.setString(3, galeriEntity.getCarColour());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0)
				System.out.println("insert operation succesful");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getConnect.close();
		}
	}

	public JsonArray selectDatabase() throws Throwable {

		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		getConnect = connectionDatabase.getConnection("Ogrenci_db", "root", "");
		try {
			System.out.println("Select Block");
			String sqlSelect = "SELECT * FROM galeri";
			preparedStatement = getConnect.prepareStatement(sqlSelect);
			ResultSet resultSet = preparedStatement.executeQuery();
			JsonArray jsonArray = new JsonArray();
			while (resultSet.next()) {

				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("carId", resultSet.getInt("carId"));
				jsonObject.addProperty("carName", resultSet.getString("carName"));
				jsonObject.addProperty("carColour", resultSet.getString("CarColour"));
				jsonObject.addProperty("carModel", resultSet.getInt("carModel"));
				jsonArray.add(jsonObject);
			}

			System.out.println("Array type : " + jsonArray);
			return jsonArray;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			getConnect.close();
		}
	}

	public void updateDatabase(GaleriEntity galeriEntity) throws SQLException {

		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		getConnect = connectionDatabase.getConnection("Ogrenci_db", "root", "");

		try {
			String sqlUpdate = "UPDATE galeri " + "SET carName = ?, carModel = ?, carColour = ? " + "WHERE carId = ?";
			preparedStatement = getConnect.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, galeriEntity.getCarName());
			preparedStatement.setInt(2, galeriEntity.getCarModel());
			preparedStatement.setString(3, galeriEntity.getCarColour());
			preparedStatement.setInt(4, galeriEntity.getCarId());
			preparedStatement.executeUpdate();

			System.out.println("Update Succesfully");
		} catch (Exception e) {
			System.err.println("Update ERROR : " + e);
		} finally {
			getConnect.close();
		}
	}
}