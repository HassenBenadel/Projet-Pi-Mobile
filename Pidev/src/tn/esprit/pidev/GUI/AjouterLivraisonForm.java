/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.util.Date;
import java.util.List;
import java.util.Map;
import tn.esprit.pidev.Entity.Livraison;
import tn.esprit.pidev.Entity.Livreur;
import tn.esprit.pidev.Services.ServiceLivraison;
import tn.esprit.pidev.Services.ServiceLivreur;

/**
 *
 * @author Ibtihel
 */
public class AjouterLivraisonForm extends Form {
    Form current;
    
        ServiceLivraison lS = new ServiceLivraison();
        ServiceLivreur liS = new ServiceLivreur();

     public AjouterLivraisonForm(Form previous) {

        setTitle("Ajouter Livraison");
        setLayout(BoxLayout.y());
        
        
        
        
          //add(cnt_prix);
        Container cnt_prix = new Container(new BorderLayout());
        TextField prix_field = new TextField("");
        prix_field.setHint("entrez le prix");
        cnt_prix.add(BorderLayout.WEST, new Label("Prix Total"));
        cnt_prix.add(BorderLayout.CENTER, prix_field);
      
         
           //add(cnt_modepaiement);
        Container cnt_modepaiement = new Container(new BorderLayout());
        ComboBox modepaiement_field = new ComboBox();
        modepaiement_field.setHint("Choisir votre Mode De Paiement");
        modepaiement_field.addItem("Carte Bancaire");
        modepaiement_field.addItem("Espéces");
        cnt_modepaiement.add(BorderLayout.WEST, new Label("Mode paiement"));
        cnt_modepaiement.add(BorderLayout.CENTER, modepaiement_field);
        
        
         //add(cnt_idCommande);
        Container cnt_idCommande = new Container(new BorderLayout());
        TextField idCommande_field = new TextField("");
        idCommande_field.setHint("entrez l'id de commande");
        cnt_idCommande.add(BorderLayout.WEST, new Label("Id Commande"));
        cnt_idCommande.add(BorderLayout.CENTER, idCommande_field);
        
        
         //add(cnt_idClient);
        Container cnt_idClient = new Container(new BorderLayout());
        TextField idClient_field = new TextField("");
        idClient_field.setHint("entrez l'id du client");
        cnt_idClient.add(BorderLayout.WEST, new Label("Id Client"));
        cnt_idClient.add(BorderLayout.CENTER, idClient_field);
        
         Date dt = new Date();
         Picker p = new Picker();
        p.setDate(dt);
        //Picker p1 = new Picker();
        //p.setDate(dt);
        
        
         List<Livreur> listL = liS.getLivreurs();
         ComboBox livreur = new ComboBox();
          livreur.setHint("Chosiir votre Livreur");
          for(Livreur ll: listL){
         livreur.addItem(ll.getId_livreur());
              System.out.println("****************"+ll.getSecteuractivite());
     }
         
      
        Container cnt_date = new Container(new BorderLayout());
        cnt_date.add(BorderLayout.WEST, new Label("Date Livraison"));
        cnt_date.add(BorderLayout.CENTER, p);
        
        Container cnt_livreur = new Container(new BorderLayout());
        cnt_livreur.add(BorderLayout.WEST, new Label("Livreur"));
        cnt_livreur.add(BorderLayout.CENTER, livreur);
        
        
        
        
        Button btn_ajouterLivraison = new Button("Ajouter");
        btn_ajouterLivraison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            Livraison l = new Livraison();
            l.setDate_livraison(p.getDate());
            l.setPrix_total(prix_field.getText());
            l.setId_client((int) Float.parseFloat(idClient_field.getText()));
            l.setId_commande((int) Float.parseFloat(idCommande_field.getText()));
            l.setMode_paiement(modepaiement_field.getSelectedItem().toString());
            Livreur li = new Livreur();
            li.setId_livreur((int) Float.parseFloat(livreur.getSelectedItem().toString()));
            l.setId_livreur(li);
            
            lS.AjouterLivraison(l);  
            new AfficherLivraisonForm(current).show();
            }
        });

        Button btn_retour = new Button("Retour");
        btn_retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AfficherLivraisonForm(current).show();
            }
     });
        Container cnt_button = new Container(new BorderLayout());
        cnt_button.add(BorderLayout.WEST,btn_retour);
        cnt_button.add(BorderLayout.EAST,btn_ajouterLivraison);
        addAll(cnt_prix,cnt_modepaiement,cnt_idCommande, cnt_idClient,cnt_date,cnt_livreur, cnt_button);
        
        
         

     }
     
     
     
}
