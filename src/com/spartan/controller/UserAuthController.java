package com.spartan.controller;

import com.spartan.entity.User;
import com.spartan.model.QueryModel;
import com.spartan.exception.UserAuthFailException;

public class UserAuthController extends Controller {
    public UserAuthController(){
        this.setModel(new QueryModel());
    }

    public final QueryModel castModel(){
        return (QueryModel) this.getModel();
    }

    public final boolean logIn(User user) throws UserAuthFailException{
        final QueryModel model = this.castModel();

        if(user.getName().equals(model.name) & user.getPass().equals(model.pass))
            return true;

        throw new UserAuthFailException(model.name);
    }
}
