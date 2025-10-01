package org.rhworkstation.controller;

import org.rhworkstation.view.Menus;

import java.sql.SQLException;

public class RhWorkstation {

    public void Application() throws SQLException {
        var menu = new Menus();

        menu.mostrarMenu();

    }
}
