package com.spartan;


import com.spartan.controller.Controller;
import com.spartan.controller.UserAuthController;
import com.spartan.entity.User;
import com.spartan.exception.UserAuthFailException;
import com.spartan.logger.AppLogger;
import com.spartan.logger.LoggerSingleton;
import com.spartan.view.IView;

import java.util.Scanner;

public class LoginView implements IView{
    private UserAuthController controller;
    private User user;
    private Scanner scanner;

    public LoginView(){
        this.setController(new UserAuthController());
        this.user = new User();
        this.scanner = new Scanner(System.in);
    }

    public boolean makePrompt(){
        System.out.print("username: ");
        user.setName(scanner.nextLine());

        System.out.print("password: ");
        user.setPass(scanner.nextLine());

        try{
            boolean result = controller.logIn(user);
            return result;
        }catch(UserAuthFailException ex) {
            System.out.println(ex.getMessage());

            LoggerSingleton.getLogger().logStackTrace(ex);

            return false;
        }
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (UserAuthController) controller;
    }

    public static void main(String[] args){
        LoginView loginView = new LoginView();

        while(!loginView.makePrompt());

        System.out.println("WELCOME");

    }
}
