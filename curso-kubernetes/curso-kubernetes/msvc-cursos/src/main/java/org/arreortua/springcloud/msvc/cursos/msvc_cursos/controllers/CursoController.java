package org.arreortua.springcloud.msvc.cursos.msvc_cursos.controllers;

import org.arreortua.springcloud.msvc.cursos.msvc_cursos.entity.Curso;
import org.arreortua.springcloud.msvc.cursos.msvc_cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;


    //listar
    @GetMapping
    public ResponseEntity<List<Curso>> listar(){
        return ResponseEntity.ok(service.listar());
    }


    //por id
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){

        Optional<Curso> o = service.porId(id);
        if(o.isPresent()){
            return ResponseEntity.ok(o.get());

        }
        return  ResponseEntity.notFound().build();

    }


    //post insertar un curso
    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Curso curso){
        Curso cursoDb = service.guardar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDb);

    }

    //put editar un curso
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
        Optional <Curso> o = service.porId(id);
        if(o.isPresent()){
            Curso cursoDb= o.get();
            cursoDb.setNombre(curso.getNombre());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cursoDb));
        }
            return ResponseEntity.notFound().build();
    }

    // delete eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> o = service.porId(id);
        if(o.isPresent()){
            service.eliminar(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
