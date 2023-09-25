package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
    @Id
    private Integer id;
    private String denominacion;
    private String marca;
    private float precio;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
