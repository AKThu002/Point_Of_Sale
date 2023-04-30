/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
    private final String url = "jdbc:postgresql://localhost/POS_DB";
    private final String user = "postgres";
    private final String password = "postgre";
	
	private static final String insertCompanySQL = "INSERT INTO \"COM_TBL\" (\"COM_ID\",\"COM_NAME\")\r\n"
			+ "VALUES (2, 'Wisdom Valley TECH Batch-1');";
	private static final String updateCompanySQL = "UPDATE public.\"COM_TBL\"\n" +
"	SET \"COM_NAME\"='Wisdom Valley TECH'\n" +
"	WHERE \"COM_ID\"=2;";
	private static final String deleteCompanySQL = "DELETE FROM \"COM_TBL\"\r\n"
			+ "        WHERE  \"COM_ID\"=1";
	private static final String selectCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\"\r\n"
			+ "	FROM public.\"COM_TBL\";";
	
public static void main(String[] args) throws SQLException {
	TestConnection company = new TestConnection();
	
//	System.out.println("Hello testing Company");
//	company.insertCompany();
	company.updateCompany();
//	company.deleteCompany();
//	company.selectCompany();
	System.out.println("successful testing");

	}
	
	public void insertCompany() throws SQLException {

	    System.out.println(insertCompanySQL);
	    // Step 1: Establishing a Connection
	    try (Connection connection = DriverManager.getConnection(url , user , password);

	        // Step 2:Create a statement using connection object
	        Statement statement = connection.createStatement();) {

	        // Step 3: Execute the query or update query
	        statement.execute(insertCompanySQL);
	    } catch (SQLException e) {

	        // print SQL exception information
	        printSQLException(e);
	    }
	}
	
	public void updateCompany() throws SQLException {

	    System.out.println(updateCompanySQL);
	    // Step 1: Establishing a Connection
	    try (Connection connection = DriverManager.getConnection(url , user , password);

	        // Step 2:Create a statement using connection object
	        Statement statement = connection.createStatement();) {

	        // Step 3: Execute the query or update query
	        statement.execute(updateCompanySQL);
	    } catch (SQLException e) {

	        // print SQL exception information
	        printSQLException(e);
	    }
	}

	public void deleteCompany() throws SQLException {

	    System.out.println(deleteCompanySQL);
	    // Step 1: Establishing a Connection
	    try (Connection connection = DriverManager.getConnection(url , user , password);

	        // Step 2:Create a statement using connection object
	        Statement statement = connection.createStatement();) {

	        // Step 3: Execute the query or update query
	        statement.execute(deleteCompanySQL);
	    } catch (SQLException e) {

	        // print SQL exception information
	        printSQLException(e);
	    }
	}
	
	public void selectCompany() throws SQLException {

	    System.out.println(selectCompanySQL);
	    // Step 1: Establishing a Connection
	    try (Connection connection = DriverManager.getConnection(url , user , password);

	        // Step 2:Create a statement using connection object
	        Statement statement = connection.createStatement();) {

	        // Step 3: Execute the query or update query
	        statement.execute(selectCompanySQL);
	    } catch (SQLException e) {

	        // print SQL exception information
	        printSQLException(e);
	    }
	}
	
	public static void printSQLException(SQLException ex) {
	    for (Throwable e: ex) {
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
