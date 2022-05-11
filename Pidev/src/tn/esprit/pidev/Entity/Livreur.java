/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.Entity;

/**
 *
 * @author Ibtihel
 */
public class Livreur {
    private int Id_livreur;
    private String secteuractivite;

    public int getId_livreur() {
        return Id_livreur;
    }

    public void setId_livreur(int Id_livreur) {
        this.Id_livreur = Id_livreur;
    }

    public String getSecteuractivite() {
        return secteuractivite;
    }

    public void setSecteuractivite(String secteuractivite) {
        this.secteuractivite = secteuractivite;
    }

    public Livreur(int Id_livreur, String secteuractivite) {
        this.Id_livreur = Id_livreur;
        this.secteuractivite = secteuractivite;
    }

    public Livreur(String secteuractivite) {
        this.secteuractivite = secteuractivite;
    }

    public Livreur() {
    }
    
    
    
}
