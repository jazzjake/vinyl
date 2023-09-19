package com.jacobs.vinyl.dao;

import java.sql.SQLException;
import java.util.List;

public class ReleaseTest {

    public static void main(String[] args) {
        ReleaseDAO releaseDAO = new ReleaseDAO();
        try {
            //releaseDAO.createTable();
            //releaseDAO.createRelease(new Release("Kind Of Blue", "Miles Davis", "Blue Note"));
            List releases = releaseDAO.getAll();
            releases.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
