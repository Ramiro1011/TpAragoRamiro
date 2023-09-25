package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/producto")
public class ProductoController {

    @Autowired
    private ProductoService ps;
    @GetMapping("")
    public List<Producto> getAll() {
        return ps.getAll();
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody Producto p){return ps.add(p);}

    @PostMapping("/{id}/update")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Producto p){
        return ps.update(id,p);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Integer id){
        return ps.delete(id);
    }

}
