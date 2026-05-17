package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CategoriaTrip;
import com.example.demo.model.Trip;
import com.example.demo.service.CategoriaTripService;
import com.example.demo.service.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private CategoriaTripService categoriaTripService;

    // DETALLE
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable int id, Model model) {

        Trip trip = tripService.findById(id);

        if (trip == null) {
            model.addAttribute("mensaje", "No se encontró el trip con id: " + id);
            return "mensaje";
        }

        model.addAttribute("trip", trip);
        return "trips/detalle";
    }

    // BORRAR (RequestParam GET)
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int id, Model model) {

        boolean eliminado = tripService.deleteById(id);

        if (eliminado) {
            model.addAttribute("mensaje", "Trip eliminado correctamente. ID: " + id);
        } else {
            model.addAttribute("mensaje", "No se pudo eliminar. No existe trip con ID: " + id);
        }

        return "mensaje";
    }

    // ✅ FORMULARIO NUEVO TRIP
    @GetMapping("/new")
    public String nuevoTrip(Model model) {

        model.addAttribute("trip", new Trip());
        model.addAttribute("categorias", categoriaTripService.findAll());

        return "trips/formTrip";
    }

    // ✅ GUARDAR TRIP (POST)
    @PostMapping("/save")
    public String guardarTrip(
            @RequestParam String destination,
            @RequestParam double price,
            @RequestParam int duration,
            @RequestParam boolean destacado,
            @RequestParam int calificacion,
            @RequestParam String fotoUrl,
            @RequestParam String descripcion,
            @RequestParam String fechaPublicacion,
            @RequestParam String tipo,
            @RequestParam int categoriaId,
            Model model) {

        // Buscar categoría seleccionada
        CategoriaTrip categoria = categoriaTripService.findById(categoriaId);

        Trip trip = new Trip(destination, price, duration, destacado, calificacion,
                fotoUrl, descripcion, fechaPublicacion, tipo);

        trip.setCategoria(categoria);

        tripService.save(trip);

        model.addAttribute("mensaje", "Trip guardado correctamente: " + trip.getDestination());
        return "mensaje";
    }
}