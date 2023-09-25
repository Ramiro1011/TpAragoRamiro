package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository pr;

    public ProductoService(ProductoRepository pr) {
        this.pr = pr;
    }

    public List<Producto> getAll() {
        return pr.findAll();
    }

    public ResponseEntity add(Producto p) {
        try {
            pr.save(p);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity update(Integer id, Producto p) {
        try {
            Producto p2 = pr.findById(id).get();
            p2.setDenominacion(p.getDenominacion());
            p2.setCategoria(p.getCategoria());
            p2.setMarca(p.getMarca());
            p2.setPrecio(p.getPrecio());
            p2.setDescripcion(p.getDescripcion());
            pr.save(p2);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity delete(Integer id) {
        try {
            pr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}
