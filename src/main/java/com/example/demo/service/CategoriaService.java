package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Repository
public class CategoriaService {
    @Autowired
    private CategoriaRepository cr;

    public CategoriaService(CategoriaRepository cr){
        this.cr = cr;
    }

    public List<Categoria> getAll(){
        return cr.findAll();
    }

    public ResponseEntity add(Categoria c){
        try {
            cr.save(c);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();}
    }
    public ResponseEntity update(Integer id, Categoria c){
        try {
            Categoria c2 = cr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Categoria not found!"));
            c2.setDenominacion(c.getDenominacion());
            c2.setProductos(c.getProductos());
            cr.save(c2);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity delete(Integer id) {
        try {
            cr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();}
    }
}
