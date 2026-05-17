package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.CategoriaTrip;

@Service
public class CategoriaTripService {

    private final List<CategoriaTrip> categorias = new ArrayList<>();
    private int autoId = 1;

    public List<CategoriaTrip> findAll() {
        return categorias;
    }

    public void save(CategoriaTrip categoria) {
        if (categoria.getId() == 0) {
            categoria.setId(autoId++);
            categorias.add(categoria);
        }
    }
    
    public CategoriaTrip findById(int id) {
        for (CategoriaTrip c : categorias) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}