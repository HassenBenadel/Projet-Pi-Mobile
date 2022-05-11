/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.Entity;

import java.util.Date;

/**
 *
 * @author Ibtihel
 */
public class Livraison {
    private int Id_livraison;
    private Date Date_livraison;
    private String Mode_paiement;
    private int Id_commande;
    private int Id_client;
    private String Prix_total;


    public String getPrix_total() {
        return Prix_total;
    }

    public void setPrix_total(String Prix_total) {
        this.Prix_total = Prix_total;
    }
 
    private Livreur  Id_livreur;



    public Livraison() {
    }

    
    public int getId_livraison() {
        return Id_livraison;
    }

    public void setId_livraison(int Id_livraison) {
        this.Id_livraison = Id_livraison;
    }

    public Date getDate_livraison() {
        return Date_livraison;
    }

    public void setDate_livraison(Date Date_livraison) {
        this.Date_livraison = Date_livraison;
    }

    public String getMode_paiement() {
        return Mode_paiement;
    }

    public void setMode_paiement(String Mode_paiement) {
        this.Mode_paiement = Mode_paiement;
    }

    public Livraison(int Id_livraison, Date Date_livraison, String Mode_paiement, String Prix_total, int Id_commande, int Id_client, Livreur Id_livreur) {
        this.Id_livraison = Id_livraison;
        this.Date_livraison = Date_livraison;
        this.Mode_paiement = Mode_paiement;
        this.Id_commande = Id_commande;
        this.Id_client = Id_client;
        this.Id_livreur = Id_livreur;
         this.Prix_total = Prix_total;
    }

    public Livraison(Date Date_livraison, String Mode_paiement, String Prix_total, int Id_commande, int Id_client, Livreur Id_livreur) {
        this.Date_livraison = Date_livraison;
        this.Mode_paiement = Mode_paiement;
        this.Id_commande = Id_commande;
        this.Id_client = Id_client;
        this.Id_livreur = Id_livreur;
         this.Prix_total = Prix_total;
    }
    public Livraison(Date Date_livraison, String Mode_paiement, String Prix_total, int Id_commande, int Id_client) {
        this.Date_livraison = Date_livraison;
        this.Mode_paiement = Mode_paiement;
        this.Id_commande = Id_commande;
        this.Id_client = Id_client;
       
         this.Prix_total = Prix_total;
    }

    public Livreur getId_livreur() {
        return Id_livreur;
    }

    public void setId_livreur(Livreur Id_livreur) {
        this.Id_livreur = Id_livreur;
    }

    

    public int getId_commande() {
        return Id_commande;
    }

    public void setId_commande(int Id_commande) {
        this.Id_commande = Id_commande;
    }

    public int getId_client() {
        return Id_client;
    }

    public void setId_client(int Id_client) {
        this.Id_client = Id_client;
    }

   
    
    
    
}
