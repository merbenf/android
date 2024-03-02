package com.pack.cfp;

import java.io.Serializable;

public class Userhelperclass implements Serializable {
    String id_user;
    String nom;
    String prenom;
    String numrc;
    String idf;
    String nuart;
    String numtel;
    String cert;
    String image;
    boolean reel_physique = false ;
    boolean reel_moral = false ;
    boolean Forfitaire = false ;
    boolean employes_plus_10 = false ;
    boolean Employes_mains_10 = false ;
    boolean entrepreneur = false ;


    public Userhelperclass()  {

    }

    public Userhelperclass(String id_user,String nom, String prenom, String numrc, String idf, String nuart, String numtel, String cert /*,String cx1,String cx2,String cx3,String cx4,String cx5,String cx6*/) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.numrc = numrc;
        this.idf = idf;
        this.nuart = nuart;
        this.numtel = numtel;
        this.cert = cert;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public boolean isReel_physique() {
        return reel_physique;
    }

    public void setReel_physique(boolean reel_physique) {
        this.reel_physique = reel_physique;
    }

    public boolean isReel_moral() {
        return reel_moral;
    }

    public void setReel_moral(boolean reel_moral) {
        this.reel_moral = reel_moral;
    }

    public boolean isForfitaire() {
        return Forfitaire;
    }

    public void setForfitaire(boolean forfitaire) {
        Forfitaire = forfitaire;
    }

    public boolean isEmployes_plus_10() {
        return employes_plus_10;
    }

    public void setEmployes_plus_10(boolean employes_plus_10) {
        this.employes_plus_10 = employes_plus_10;
    }

    public boolean isEmployes_mains_10() {
        return Employes_mains_10;
    }

    public void setEmployes_mains_10(boolean employes_mains_10) {
        Employes_mains_10 = employes_mains_10;
    }

    public boolean isEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(boolean entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id){this.id_user = id;}

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
