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
public class Depot {
   private int Id_depot;
   private String adresse;
   private int quantite;
   private String disponibilite ;
   private int Id_produit;
   private Livraison Id_livraison;

    public int getId_depot() {
        return Id_depot;
    }

    public void setId_depot(int Id_depot) {
        this.Id_depot = Id_depot;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getId_produit() {
        return Id_produit;
    }

    public void setId_produit(int Id_produit) {
        this.Id_produit = Id_produit;
    }

    public Livraison getId_livraison() {
        return Id_livraison;
    }

    public void setId_livraison(Livraison Id_livraison) {
        this.Id_livraison = Id_livraison;
    }

    public Depot(int Id_depot, String adresse, int quantite, String disponibilite, int Id_produit, Livraison Id_livraison) {
        this.Id_depot = Id_depot;
        this.adresse = adresse;
        this.quantite = quantite;
        this.disponibilite = disponibilite;
        this.Id_produit = Id_produit;
        this.Id_livraison = Id_livraison;
    }

    public Depot(String adresse, int quantite, String disponibilite, int Id_produit, Livraison Id_livraison) {
        this.adresse = adresse;
        this.quantite = quantite;
        this.disponibilite = disponibilite;
        this.Id_produit = Id_produit;
        this.Id_livraison = Id_livraison;
    }

    public Depot(String adresse, int quantite, String disponibilite, int Id_produit) {
        this.adresse = adresse;
        this.quantite = quantite;
        this.disponibilite = disponibilite;
        this.Id_produit = Id_produit;
    
    }
    public Depot() {
    }
   
   
    
}
