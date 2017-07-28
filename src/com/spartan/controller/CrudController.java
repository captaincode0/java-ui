package com.spartan.controller;

import com.spartan.entity.EntityInterface;
import com.spartan.model.IModel;

public abstract class CrudController extends Controller{
    public abstract boolean add(EntityInterface entity);
    public abstract boolean edit(EntityInterface entity);
    public abstract boolean del(EntityInterface entity);
    public abstract boolean getById(EntityInterface entity);
}

