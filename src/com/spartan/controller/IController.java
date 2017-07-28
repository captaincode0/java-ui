package com.spartan.controller;

import com.spartan.model.IModel;

public interface IController {
    public IModel getModel();
    public void setModel(IModel model);
}
