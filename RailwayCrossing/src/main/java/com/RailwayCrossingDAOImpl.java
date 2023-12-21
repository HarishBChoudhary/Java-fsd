package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.*;

public class RailwayCrossingDAOImpl implements RailwayCrossing{
	
	Connection connection;
	
	public RailwayCrossingDAOImpl() {
		 connection=DatabaseConnection.getConnection();
		
	}

	@Override
	public List<RailwayCrossing1> getAllCrossings() {
		// Fetch all values from the database
		List<RailwayCrossing1> crossing=new ArrayList<RailwayCrossing1>();
		
		
		try {
			String query="SELECT *FROM crossing";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				RailwayCrossing1 crossings=new RailwayCrossing1();
				crossings.setId(rs.getInt("id"));
				crossings.setName(rs.getString("name"));
				crossings.setAddress(rs.getString("address"));
				crossings.setLandmark(rs.getString("landmark"));
				crossings.setSchedule(rs.getString("schedule"));
				crossings.setPerson(rs.getString("person"));
				crossings.setStatus(rs.getString("status"));
				crossing.add(crossings);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return crossing;
	}

	@Override
	public RailwayCrossing1 getCrossingById(int crossingId) {
		// Search values by id and display it from the database
		RailwayCrossing1 crossing = null;
		try {
			String query = "SELECT * FROM crossing WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, crossingId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				crossing = new RailwayCrossing1();
				crossing.setId(resultSet.getInt("id"));
				crossing.setName(resultSet.getString("name"));
				crossing.setAddress(resultSet.getString("address"));
				crossing.setLandmark(resultSet.getString("landmark"));
				crossing.setSchedule(resultSet.getString("schedule"));
				crossing.setPerson(resultSet.getString("person"));
				crossing.setStatus(resultSet.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crossing;
	
	}

	@Override
	public void updateCrossing(RailwayCrossing1 crossing) {
		// update the values in the database
		try {
			String query = "UPDATE crossing SET name=?, address=?, landmark=?, schedule=?, person=?, status=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, crossing.getName());
			statement.setString(2, crossing.getAddress());
			statement.setString(3, crossing.getLandmark());
			statement.setString(4, crossing.getSchedule());
			statement.setString(5, crossing.getPerson());
			statement.setString(6, crossing.getStatus());
			statement.setInt(7, crossing.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCrossing(int crossingId) {
		

		try {
			connection.setAutoCommit(false); // Start transaction

			// Delete associated favorite crossings
			String deleteFavoriteCrossingsQuery = "DELETE FROM favorite_crossing WHERE crossing_id = ?";
			try (PreparedStatement deleteFavoriteCrossingsStatement = connection
					.prepareStatement(deleteFavoriteCrossingsQuery)) {
				deleteFavoriteCrossingsStatement.setInt(1, crossingId);
				deleteFavoriteCrossingsStatement.executeUpdate();
			}

			// Delete the railway crossing
			String deleteRailwayCrossingQuery = "DELETE FROM crossing WHERE id = ?";
			try (PreparedStatement deleteRailwayCrossingStatement = connection
					.prepareStatement(deleteRailwayCrossingQuery)) {
				deleteRailwayCrossingStatement.setInt(1, crossingId);
				deleteRailwayCrossingStatement.executeUpdate();
			}

			connection.commit(); // Commit the transaction
			connection.setAutoCommit(true); // Reset auto-commit to true
		} catch (SQLException e) {
			try {
				connection.rollback(); // Rollback the transaction if an error occurs
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		}
	
	}

	@Override
	public void addCrossing(RailwayCrossing1 crossing) {
		// Add values to the database

		try {
			String query = "INSERT INTO crossing (name, address, landmark,schedule, person, status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, crossing.getName());
			statement.setString(2, crossing.getAddress());
			statement.setString(3, crossing.getLandmark());
			statement.setString(4, crossing.getSchedule());
			statement.setString(5, crossing.getPerson());
			statement.setString(6, crossing.getStatus());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<RailwayCrossing1> getFavoriteCrossings() {
		

		List<RailwayCrossing1> favoriteCrossings = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT rc.* FROM crossing rc "
					+ "JOIN favorite_crossing fc ON rc.id = fc.crossing_id";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RailwayCrossing1 crossing = new RailwayCrossing1();
				crossing.setId(resultSet.getInt("id"));
				crossing.setName(resultSet.getString("name"));
				crossing.setAddress(resultSet.getString("address"));
				crossing.setLandmark(resultSet.getString("landmark"));
				crossing.setSchedule(resultSet.getString("schedule"));
				crossing.setPerson(resultSet.getString("person"));
				crossing.setStatus(resultSet.getString("status"));

				favoriteCrossings.add(crossing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return favoriteCrossings;
	
	}

	@Override
	public void addToFavorites(int crossingId) {

		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "INSERT INTO favorite_crossing (crossing_id) VALUES (?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, crossingId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
	
		
	}

	@Override
	public void removeFromFavorites(int crossingId) {

		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "DELETE FROM favorite_crossing WHERE crossing_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, crossingId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
	
	}

	
}
