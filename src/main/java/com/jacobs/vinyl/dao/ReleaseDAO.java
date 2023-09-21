package com.jacobs.vinyl.dao;

import com.jacobs.vinyl.repository.Release;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReleaseDAO {


    //H2 will create DB if it does not exist
    //This will create db in memory
    //private static final String JDBC_URL ="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    //these jdbc strings will save to a file on disk
    //private static final String JDBC_URL ="jdbc:h2:~/test";
    private static final String JDBC_URL ="jdbc:h2:C:/dev/Records/recordsdb";


    // this jdbc string will NOT create DB if it does not exist
    //private static final String JDBC_URL ="jdbc:h2:C:/dev/Records/recordsdb2;IFEXISTS=TRUE";

    private static final String USERNAME ="";
    private static final String PASSWORD ="";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE Release (" +
            "id bigint auto_increment PRIMARY KEY," +
            "artist varchar(30)," +
            "title varchar(100)," +
            "label varchar(256)," +
            "releaseYear varchar(4)) ";

    private static final String CREATE_TABLE_SQL2 = "CREATE TABLE Customer (" +
            "id bigint auto_increment PRIMARY KEY," +
            "firstname varchar(20)," +
            "lastname varchar(256)," +
            "email varchar(256)" +
            ")";
    private static final String INSERT_SQL_RELEASE = "INSERT INTO Release(artist, title, label) VALUES (?,?,?)";
    private static final String SELECT_ALL_SQL = "SELECT * from Release";

    public void createTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }

    public void createRelease(Release release) throws SQLException{
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL_RELEASE);
            statement.setString(1, release.getArtist());
            statement.setString(2, release.getTitle());
            statement.setString(3, release.getLabel());
            statement.executeUpdate();
        }
    }

    public List<Release> getAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL);
            List<Release> releases = new ArrayList<>();
            while (resultSet.next()) {
                String artist = resultSet.getString("artist");
                String title = resultSet.getString("title");
                String label = resultSet.getString("label");
                releases.add(new Release(artist, title, label));
            }
            return releases;
        }
    }
}
