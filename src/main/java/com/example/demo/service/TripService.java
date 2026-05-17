package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Trip;

@Service
public class TripService {

    private final List<Trip> trips = new ArrayList<>();
    private int autoId = 8; 
    public TripService() {

        // LOCALES (1-4)
        Trip t1 = new Trip("Rapel en Volcatenango", 5.0, 1, true, 5,
                "/img/volcatenango.jpg",
                "Hacer rapel en los circuitos de Volcatenango",
                "Mon Jan 10 00:05:00 CST 2022",
                "LOCAL");
        t1.setId(1);

        Trip t2 = new Trip("Deslizador en El Pícnic", 5.0, 1, true, 7,
                "/img/deslizadero.jpg",
                "Deslizarte en un divertido tobogán sobre la colina",
                "Mon Jan 10 00:05:00 CST 2022",
                "LOCAL");
        t2.setId(2);

        Trip t3 = new Trip("Caminata al mirador", 8.0, 2, false, 6,
                "/img/caminata.jpg",
                "Caminata guiada y vistas panorámicas",
                "Tue Feb 03 09:30:00 CST 2022",
                "LOCAL");
        t3.setId(3);

        Trip t4 = new Trip("Carnitas típicas", 3.0, 1, false, 4,
                "/img/carnitas.jpg",
                "Parada gastronómica: carnitas y antojitos",
                "Thu Feb 10 08:00:00 CST 2022",
                "LOCAL");
        t4.setId(4);

        // INTERNACIONALES (5-7)
        Trip t5 = new Trip("París", 1200.50, 7, true, 10,
                "/img/paris.jpg",
                "Tour por la ciudad y puntos icónicos",
                "Tue Mar 01 07:00:00 CST 2022",
                "INTERNACIONAL");
        t5.setId(5);

        Trip t6 = new Trip("Roma", 950.00, 5, true, 9,
                "/img/roma.jpg",
                "Recorrido histórico y cultural",
                "Sun Mar 20 06:30:00 CST 2022",
                "INTERNACIONAL");
        t6.setId(6);

        Trip t7 = new Trip("Nueva York", 1500.75, 10, true, 10,
                "/img/nuevayork.jpg",
                "Visita a Manhattan y lugares emblemáticos",
                "Tue Apr 05 10:00:00 CST 2022",
                "INTERNACIONAL");
        t7.setId(7);

        trips.add(t1); trips.add(t2); trips.add(t3); trips.add(t4);
        trips.add(t5); trips.add(t6); trips.add(t7);
    }

    public List<Trip> findByTipo(String tipo) {
        List<Trip> r = new ArrayList<>();
        for (Trip t : trips) {
            if (t.getTipo() != null && t.getTipo().equalsIgnoreCase(tipo)) {
                r.add(t);
            }
        }
        return r;
    }

    public Trip findById(int id) {
        for (Trip t : trips) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public boolean deleteById(int id) {
        return trips.removeIf(t -> t.getId() == id);
    }

    // ✅ NUEVO: guardar trip (crear)
    public void save(Trip trip) {
        trip.setId(autoId++);
        trips.add(trip);
    }
}