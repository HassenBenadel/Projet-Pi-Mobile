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
import java.util.List;
import tn.esprit.pidev.Entity.Depot;
import tn.esprit.pidev.Entity.Livraison;
import tn.esprit.pidev.Services.ServiceDepot;
import tn.esprit.pidev.Services.ServiceLivraison;

/**
 *
 * @author Ibtihel
 */
public class ModifierDepotForm extends Form{
    Form current;
    
    ServiceDepot dS = new ServiceDepot();
    ServiceLivraison lS = new ServiceLivraison();

    public ModifierDepotForm(Form previous, Depot dep){
        
        
         setTitle("Modifier Depot");
        setLayout(BoxLayout.y());
        
        
        
         //add(cnt_adresse);
        Container cnt_adresse = new Container(new BorderLayout());
        TextField adresse_field = new TextField("");
        adresse_field.setText(dep.getAdresse());
        cnt_adresse.add(BorderLayout.WEST, new Label("Adresse"));
        cnt_adresse.add(BorderLayout.CENTER, adresse_field);
        
        
        //add(cnt_quantite);
        Container cnt_quantite = new Container(new BorderLayout());
        TextField quantite_field = new TextField("");
        quantite_field.setText(String.valueOf(dep.getQuantite()));
        cnt_quantite.add(BorderLayout.WEST, new Label("Quantite"));
        cnt_quantite.add(BorderLayout.CENTER, quantite_field);
        
        
         //add(cnt_disponibilite);
        Container cnt_disponibilite = new Container(new BorderLayout());
        ComboBox disponibilite_field = new ComboBox();
        disponibilite_field.setSelectCommandText(dep.getDisponibilite());
        disponibilite_field.addItem("Disponible");
        disponibilite_field.addItem("Non Disponible");
        cnt_disponibilite.add(BorderLayout.WEST, new Label("Disponibilite"));
        cnt_disponibilite.add(BorderLayout.CENTER, disponibilite_field);
        
        
        
         //add(cnt_idProduit);
        Container cnt_idProduit = new Container(new BorderLayout());
        TextField idProduit_field = new TextField("");
         idProduit_field.setText(String.valueOf(dep.getId_produit()));
        cnt_idProduit.add(BorderLayout.WEST, new Label("Id Produit"));
        cnt_idProduit.add(BorderLayout.CENTER,  idProduit_field);
        
        
        
         List<Livraison> listL = lS.getLivraisons();
         ComboBox livraison = new ComboBox();
          livraison.setHint(String.valueOf(dep.getId_livraison().getId_livraison()));
          for(Livraison ll: listL){
         livraison.addItem(ll.getId_livraison());
              System.out.println("****************"+ll.getId_livraison());
        
            }
          
          
         Container cnt_livraison = new Container(new BorderLayout());
        cnt_livraison.add(BorderLayout.WEST, new Label("Livraison"));
        cnt_livraison.add(BorderLayout.CENTER, livraison);
        
        Button btn_retour = new Button("Retour");
        btn_retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AfficherDepotForm(current).show();
            }
     });
        
        
        
        Button btn_updateDepot = new Button("Modifier");
        btn_updateDepot.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent evt) {
            Depot d = new Depot();
            d.setId_depot(dep.getId_depot());
            d.setAdresse(adresse_field.getText());
            d.setQuantite((int) Float.parseFloat(quantite_field.getText()));
            d.setDisponibilite(disponibilite_field.getSelectedItem().toString());
            d.setId_produit((int) Float.parseFloat(idProduit_field.getText()));
            
            Livraison li = new Livraison();
            li.setId_livraison((int) Float.parseFloat(livraison.getSelectedItem().toString()));
            d.setId_livraison(li);
            
            dS.ModifierDepot(d);  
            new AfficherDepotForm(current).show();
            }

            
        });

    
       Container cnt_button = new Container(new BorderLayout());
       
        cnt_button.add(BorderLayout.WEST,btn_retour);
        cnt_button.add(BorderLayout.EAST,btn_updateDepot);
        addAll(cnt_adresse, cnt_quantite, cnt_disponibilite, cnt_idProduit, cnt_livraison, cnt_button); 
        
        
        
    }
    
}
