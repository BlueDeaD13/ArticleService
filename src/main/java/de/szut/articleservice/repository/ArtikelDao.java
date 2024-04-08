package de.szut.articleservice.repository;

import de.szut.articleservice.model.Artikel;

import java.util.List;
import java.util.Map;

public class ArtikelDao {
    Map<Long, Artikel> artikelListe;

    public ArtikelDao() {
        initHashMap();
    }
    public void initHashMap() {

    }
    public void insert(Artikel artikel) {
        if (artikel != artikelListe.get(artikel)) {
            artikelListe.put(artikel.getId(), artikel);
        }
        System.out.println("Den Artikel mit der ID: " + artikel.getId() + " gibt es schon!");
    }
    public Artikel findbyId(long id) {
        if (!artikelListe.containsKey(id)) {
            System.out.println("Den Artikel mit der ID: " + id + " gibt es noch nicht!");
        }
        return artikelListe.get(id);
    }

    public List<Artikel> findAll() {
        return artikelListe.values().stream().toList();
    }

    public void update(Artikel artikel) {
        if (!artikelListe.containsKey(artikel.getId())) {
        System.out.println("Den Artikel mit der ID: " + artikel.getId() + " gibt es noch nicht!");
    }
        artikelListe.replace(artikel.getId(), artikel);
    }

    public void delete(long id) {
        if (!artikelListe.containsKey(id)) {
            System.out.println("Den Artikel mit der ID: " + id + " gibt es noch nicht!");
        }
        artikelListe.remove(id);
    }
}
