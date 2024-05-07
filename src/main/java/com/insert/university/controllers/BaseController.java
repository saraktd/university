package com.insert.university.controllers;

import com.insert.university.converter.BaseConverter;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public abstract class BaseController<E,D,S extends BaseService<E,?>>  {
    @Autowired
    protected BaseConverter<E,D> converter;
    @Autowired
    protected S service;

}
