package com.example.ikkunat;

import java.io.*;
import java.util.List;

/**
 * Luokka ikkunoiden tallentamiseen ja lukemiseen
 * Metodit ikkunoiden kirjoittamiseen ja lukemiseen
 * @author justus
 */
public class IkkunaTiedosto {
    private static final String TIEDOSTO = "ikkunat.dat";

    /**
     *@throws RuntimeException jos kirjoittaminen epäonnistuu
     * @param ikkunat lista IkkunaOlio olioita
     */
    public static void tallennaIkkuna(List<IkkunaOlio> ikkunat){
        try (ObjectOutputStream kirjotaIkkunanTiedot = new ObjectOutputStream(new FileOutputStream(TIEDOSTO))){
            kirjotaIkkunanTiedot.writeObject(ikkunat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lukee ikkunoiden tiedot tiedostosta
     * @throws RuntimeException jos lataaminen epäonnistuu tai lukeminen epäonnistuu
     */
    public static List<IkkunaOlio> lueIkkuna(){
        try (ObjectInputStream lueIkkunanTiedot = new ObjectInputStream(new FileInputStream(TIEDOSTO))) {
            return (List<IkkunaOlio>) lueIkkunanTiedot.readObject();
        } catch (FileNotFoundException e){
            System.err.println("Tiedostoa ei löytynyt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }
}
