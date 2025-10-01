package org.rhworkstation.app;

import org.rhworkstation.controller.RhWorkstation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        RhWorkstation rhworkstation = new RhWorkstation();

        rhworkstation.Application();
    }
}