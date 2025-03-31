package com.example.ikkunat;

import java.awt.Point;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Ikkuna millä tunnusluku, numero, avausaika ja sijainti
 * @author justus
 *
 */
public class IkkunaOlio implements Serializable {

    private String tunnusluku;
    private int numero;
    private Point sijainti;
    private LocalDateTime avausaika;

    /**Palauttaa tunnusluvun
     * @return tunnusluku merkkijonona
     */
    public String getTunnusluku() {
        return tunnusluku;
    }

    /**
     * Asettaa tunnusluvun
     * @param tunnusluku merkkijonona
     */
    public void setTunnusluku(String tunnusluku) {
        this.tunnusluku = tunnusluku;
    }

    /**
     * Palauttaa ikkunan numeron
     * @return numero kokonaislukuna
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Asettaa numeron
     * @param numero kokonaislukuna
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Palauttaa ikkunan sijainnin
     * @return koordinaatit Pointtina
     */
    public Point getSijainti() {
        return sijainti;
    }

    /**
     * Asettaa sijainnin
     * @param sijainti Pointtina
     */
    public void setSijainti(Point sijainti) {
        this.sijainti = sijainti;
    }

    /**
     * Palauttaa avaamisajan
     * @return avaamisaika LocalDateTimena
     */
    public LocalDateTime getAvausaika() {
        return avausaika;
    }

    /**
     * Asettaa avaamisajan
     * @param avausaika LocalDateTimena
     */
    public void setAvausaika(LocalDateTime avausaika) {
        this.avausaika = avausaika;
    }

    /**
     * Luo ikkunaolion annetulla numerolla ja paikalla
     * avausajaksi tulee tietokoneen senhetkinen aika ja luo tunnusluvun
     * @param numero kokonaislukuna
     * @param sijainti Pointtina
     */
    public IkkunaOlio(int numero, Point sijainti){
        this.numero = numero;
        this.sijainti = sijainti;
        this.avausaika = LocalDateTime.now();
        this.tunnusluku = UUID.randomUUID().toString();
    }
}
