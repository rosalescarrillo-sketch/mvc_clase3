package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.CategoriaTrip;
import com.example.demo.service.CategoriaTripService;

@Controller
public class CategoriaTripController {

    @Autowired
    private CategoriaTripService categoriaTripService;

    // A) Mostrar formulario
    @GetMapping("/categorias/new")
    public String mostrarFormulario(Model model) {
        model.addAttribute("categoria", new CategoriaTrip());
        return "categoriasTrip/formCategoria";
    }

    // B) Guardar categoria (POST)
    @PostMapping("/categorias/save")
    public String guardar(@ModelAttribute("categoria") CategoriaTrip categoria, Model model) {
        categoriaTripService.save(categoria);

        model.addAttribute("mensaje", "Categoría guardada: " + categoria.getNombre());
        return "mensaje"; // tu mensaje.html
    }
    
    @GetMapping("/categorias/list")
    public String list(Model model) {
        model.addAttribute("categorias", categoriaTripService.findAll());
        return "categoriasTrip/listCategoria";
    }
}