package com.example.demo.controller;


import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService cs;
    @GetMapping("")
    public List<Categoria> getAll() {
        return cs.getAll();
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody Categoria c){return cs.add(c);}

    @PostMapping("/{id}/update")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Categoria c){
        return cs.update(id,c);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Integer id){
        return cs.delete(id);
    }
}
