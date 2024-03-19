package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.dto.PersonDto;
import org.prog.util.DataHolder;
import org.testng.Assert;

import java.sql.*;

public class SQLSteps {

    private Connection connection;
    private Statement statement;

    @Given("I store user {string} in DB")
    public void storeUserInDB(String alias) throws SQLException {
        PersonDto dto = (PersonDto) DataHolder.getInstance().get(alias);
        String sqlBase =
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('%s', '%s', '%s', '%s', '%s')";
        String sql = String.format(sqlBase,
                dto.getName().getFirst(),
                dto.getName().getLast(),
                dto.getGender(),
                dto.getName().getTitle(),
                dto.getNat());
        try {
            setupDbConnection();
            statement.execute(sql);
        } catch (Exception e) {
            System.out.println("Failed to store user to DB");
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Given("I pick a random user from DB as {string}")
    public void pickRandomUser(String alias) throws SQLException, ClassNotFoundException {
        try {
            setupDbConnection();
            String sql = "SELECT * FROM Persons ORDER BY RAND() LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                DataHolder.getInstance().put(alias, firstName + " " + lastName);
            } else {
                Assert.fail("No records from DB were picked! Check DB!");
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void setupDbConnection() throws ClassNotFoundException, SQLException {
        //WARN: SQL connections wont work without this!
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }
}
