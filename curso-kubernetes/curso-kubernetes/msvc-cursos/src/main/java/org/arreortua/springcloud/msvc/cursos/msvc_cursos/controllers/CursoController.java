package org.arreortua.springcloud.msvc.cursos.msvc_cursos.controllers;

import org.arreortua.springcloud.msvc.cursos.msvc_cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;


}
