package com.example.ikkunat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *Ikkunoiden luominen, tallentaminen, lataaminen ja poistaminen.
 * Pitää listaa ikkunoista ja niiden numeroista
 * @author justus 
 */
public class IkkunaHallinta {
    private static List<IkkunaOlio> ikkunat = new ArrayList<>();
    private static int seuraavaNum = 1;

    /**
     * Lataa tallenetut ikkunat.
     * Alustaa listan ja päivittää numeron
     */
    public static void lataaIkkuna(){
        ikkunat = new ArrayList<>(IkkunaTiedosto.lueIkkuna());
        for (IkkunaOlio ikkuna : ikkunat){
            new IkkunatLuokka(seuraavaNum, ikkuna.getSijainti().getX(), ikkuna.getSijainti().getY(),
                    ikkuna.getAvausaika());
        }
    }

    /**
     * Tallentaa ikkunalistan
     */
    public static void tallennaIkkuna(){
        IkkunaTiedosto.tallennaIkkuna(ikkunat);
    }

    /**
     * Palauttaa tallennetut ikkunat.
     */
    public static void palautaIkkunat(){
        List<IkkunaOlio> tallennetutIkkunat = IkkunaTiedosto.lueIkkuna();
        for (IkkunaOlio ikkuna : tallennetutIkkunat){
            new IkkunatLuokka(
                    ikkuna.getNumero(),
                    ikkuna.getSijainti().getX(),
                    ikkuna.getSijainti().getY(),
                    ikkuna.getAvausaika()
            );
        }
    }

    /**
     * Tekee uuden ikkunan annetuilla tiedoilla ja lisää listaan.
     * Asettaa avausajan ja numeron.
     * @param ikkuna lisättävä ikkuna
     */
    public static void teeIkkuna(IkkunaOlio ikkuna){
        ikkuna.setNumero(seuraavaNum++);
        if (ikkuna.getAvausaika() == null) {
            ikkuna.setAvausaika(LocalDateTime.now());
        }
        ikkunat.add(ikkuna);
        tallennaIkkuna();
    }

    /**
     * Poistaa ikkunan listasta
     * @param ikkuna poistettava ikkuna
     */
    public static void poistaIkkuna(IkkunaOlio ikkuna){
        ikkunat.removeIf(i -> i.getTunnusluku().equals(ikkuna.getTunnusluku()));
        tallennaIkkuna();
    }

}
