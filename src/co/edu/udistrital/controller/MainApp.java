package co.edu.udistrital.controller;

import co.edu.udistrital.view.MainView;

public class MainApp {
    public static void main(String[] args) {
        MainView view = new MainView();
        new Controller(view);
    }
}
