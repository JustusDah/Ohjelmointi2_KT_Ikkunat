package com.example.ikkunat;

import java.awt.Point;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class IkkunaOlio implements Serializable {

    private String tunnusluku;
    private int numero;
    private Point sijainti;
    private LocalDateTime avausaika;

    public String getTunnusluku() {
        return tunnusluku;
    }

    public void setTunnusluku(String tunnusluku) {
        this.tunnusluku = tunnusluku;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Point getSijainti() {
        return sijainti;
    }

    public void setSijainti(Point sijainti) {
        this.sijainti = sijainti;
    }

    public LocalDateTime getAvausaika() {
        return avausaika;
    }

    public void setAvausaika(LocalDateTime avausaika) {
        this.avausaika = avausaika;
    }

    public IkkunaOlio(int numero, Point sijainti){
        this.numero = numero;
        this.sijainti = sijainti;
        this.avausaika = LocalDateTime.now();
        this.tunnusluku = UUID.randomUUID().toString();
    }
}
