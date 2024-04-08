package de.szut.articleservice.controller;

import de.szut.articleservice.model.Artikel;
import de.szut.articleservice.service.ArtikelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myappdata/articles")
public class ArtikelController {

    private ArtikelService artikelService;

    public ArtikelController() {
        artikelService = new ArtikelService();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Artikel>> getArtikel(@PathVariable long id) {
        List<Artikel> artikelList = artikelService.read(id);
        return new ResponseEntity<>(artikelList, HttpStatus.OK);
    }
}
