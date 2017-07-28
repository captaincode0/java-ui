package com.spartan.view;

import com.spartan.controller.Controller;

public interface IView {
    public Controller getController();
    public void setController(Controller controller);
}
