package com.pack.cfp;

public class Userhelperclass {
    String nom,prenom,numrc,idf,nuart,numtel,cert;

    public Userhelperclass() {

    }

    public Userhelperclass(String nom, String prenom, String numrc, String idf, String nuart, String numtel, String cert) {
        this.nom = nom;
        this.prenom = prenom;
        this.numrc = numrc;
        this.idf = idf;
        this.nuart = nuart;
        this.numtel = numtel;
        this.cert = cert;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumrc() {
        return numrc;
    }

    public void setNumrc(String numrc) {
        this.numrc = numrc;
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public String getNuart() {
        return nuart;
    }

    public void setNuart(String nuart) {
        this.nuart = nuart;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }
}
