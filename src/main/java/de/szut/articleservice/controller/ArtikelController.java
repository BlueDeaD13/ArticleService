package de.szut.articleservice.controller;

import de.szut.articleservice.model.Artikel;
import de.szut.articleservice.service.ArtikelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myappdata/articles")
public class ArtikelController {

    private ArtikelService artikelService;

    public ArtikelController() {
        artikelService = new ArtikelService();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artikel> getArtikel(@PathVariable long id) {
        Artikel artikel = artikelService.read(id);
        return new ResponseEntity<>(artikel, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Artikel> addArtikel(@RequestBody Artikel request) {
        Artikel artikel = artikelService.add(request);
        return new ResponseEntity<>(artikel, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateArtikel(@RequestBody Artikel request) {
        artikelService.update(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Artikel> deleteArtikel(@PathVariable long id) {
        artikelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
