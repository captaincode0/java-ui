package com.spartan.ui;

import com.spartan.controller.Controller;
import com.spartan.controller.UserAuthController;
import com.spartan.entity.User;
import com.spartan.exception.UserAuthFailException;
import com.spartan.logger.LoggerSingleton;
import com.spartan.view.IView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView extends JDialog implements IView{
    private JPanel viewPanel;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JButton btnLogin;
    private User user;
    private UserAuthController controller;

    public LogInView(){
        this.initializeComponents();
        this.addListeners();
        this.setController(new UserAuthController());
        this.user = new User();
    }

    private void initializeComponents(){
        this.setContentPane(this.viewPanel);
        this.setModal(false);
        this.setSize(150,150);
    }

    private void addListeners(){
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
    }

    private void onLogin(){
        user.setName(txtUserName.getText());
        user.setPass(txtPassword.getText());
        try {
            if (this.controller.logIn(this.user)) {
                JOptionPane.showMessageDialog(null,"Logged in", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (UserAuthFailException e) {
            JOptionPane.showMessageDialog(null,"Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            LoggerSingleton.getLogger().logStackTrace(e);
        }
    }

    @Override
    public Controller getController() {
        return this.controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (UserAuthController) controller;
    }

    public static void main(String[] args) {
        LogInView logInView = new LogInView();
        logInView.setVisible(true);
    }
}
