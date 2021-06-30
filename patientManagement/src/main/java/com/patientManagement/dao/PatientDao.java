package com.patientManagement.dao;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.patientManagement.beans.Patient;

public class PatientDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/mydb1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "test123";

	private static final String INSERT_PATIENTS_SQL = "INSERT INTO patients" + "  (nom, prenom, addresse,sexe,numTel,dateNaissance) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_PATIENTS_BY_ID = "select id,nom,prenom,addresse,sexe,numTel,dateNaissance from patients where id =?";
	private static final String SELECT_ALL_PATIENTS = "select * from patients";
	private static final String DELETE_PATIENTS_SQL = "delete from patients where id = ?;";
	private static final String UPDATE_PATIENTS_SQL = "update patients set nom = ?,addresse= ?, prenom=? , sexe=? ,numTel=? ,dateNaissance=? where id = ?;";
	public PatientDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void insertPatient(Patient patient) throws SQLException {
		System.out.println(INSERT_PATIENTS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENTS_SQL)) {
			preparedStatement.setString(1, patient.getNom());
			preparedStatement.setString(2, patient.getPrenom());
			preparedStatement.setString(3, patient.getAddresse());
			preparedStatement.setString(4, patient.getSexe());
			preparedStatement.setString(5, patient.getNumTel());
			preparedStatement.setObject(6, patient.getDateNaissance());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Patient selectPatient(int id) {
		Patient patient = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENTS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String addresse = rs.getString("addresse");
				String sexe = rs.getString("sexe");
				String numTel = rs.getString("numTel");
				Date dateNaissance = rs.getDate("dateNaissance");
				patient = new Patient(id, nom , prenom , addresse,sexe, numTel ,dateNaissance);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patient;
	}
	

	public List<Patient> selectAllPatients() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Patient> patients = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String addresse = rs.getString("addresse");
				String sexe = rs.getString("sexe");
				int numTel = rs.getInt("numTel");
				Date dateNaissance = rs.getDate("dateNaissance");
				patients.add(new Patient(id, nom, prenom, addresse,sexe,Integer.toString(numTel),dateNaissance));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patients;
	}
	
	public boolean deletePatient(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PATIENTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updatePatient(Patient patient) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PATIENTS_SQL);) {
			System.out.println("updated Patient:"+statement);
			statement.setString(1, patient.getNom());
			statement.setString(2, patient.getPrenom());
			statement.setString(3, patient.getAddresse());
			statement.setString(4, patient.getSexe());
			statement.setString(5, patient.getNumTel());
			statement.setObject(6, patient.getDateNaissance());
			statement.setInt(7, patient.getid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
