/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.finpac14;

/**
 *
 * @author Patrick
 */
public class Anlagenverzeichnis {
    private String bezeichnung;
    private double anschaffungswert;
    private double inbetriebnahme;
    private double nutzungsdauer;
    private double bihNutzungsdauer;
    private double AfABisher;
    private double WertVorAfA;
    private double afAdJ;
    private double buchwert;

    public Anlagenverzeichnis(String bezeichnung, double anschaffungswert, double inbetriebnahme, double nutzungsdauer) {
        this.bezeichnung = bezeichnung;
        this.anschaffungswert = anschaffungswert;
        this.inbetriebnahme = inbetriebnahme;
        this.nutzungsdauer = nutzungsdauer;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getAnschaffungswert() {
        return anschaffungswert;
    }

    public double getInbetriebnahme() {
        return inbetriebnahme;
    }

    public double getNutzungsdauer() {
        return nutzungsdauer;
    }

    public double getBihNutzungsdauer() {
        return bihNutzungsdauer;
    }

    public double getAfABisher() {
        return AfABisher;
    }

    public double getWertVorAfA() {
        return WertVorAfA;
    }

    public double getAfAdJ() {
        return afAdJ;
    }

    public double getBuchwert() {
        return buchwert;
    }

    public void setBihNutzungsdauer(double bihNutzungsdauer) {
        this.bihNutzungsdauer = bihNutzungsdauer;
    }

    public void setAfABisher(double AfABisher) {
        this.AfABisher = AfABisher;
    }

    public void setWertVorAfA(double WertVorAfA) {
        this.WertVorAfA = WertVorAfA;
    }

    public void setAfAdJ(double afAdJ) {
        this.afAdJ = afAdJ;
    }
    
    
}
