package uz.group.mppguiproject.ui;

import javax.swing.*;

public class Router {
    private static final Router INSTANCE = new Router();

    private LoginWindow loginWindow;

    private MainMenuWindow mainMenuWindow;

    private AddMemberWindow addMemberWindow;

    private Router() {}

    public static Router getInstance() {
        return INSTANCE;
    }

    public void openLoginWindow(JFrame currentWindow) {
        currentWindow.dispose();
        loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
        loginWindow.draw();
    }

    public void openMainWindow(JFrame currentWindow) {
        currentWindow.dispose();
        mainMenuWindow = new MainMenuWindow();
        mainMenuWindow.setVisible(true);
        mainMenuWindow.draw();
    }

    public void openAddMemberWindow(JFrame currentWindow) {
        currentWindow.dispose();
        addMemberWindow = new AddMemberWindow();
        addMemberWindow.setVisible(true);
        addMemberWindow.draw();
    }
}
