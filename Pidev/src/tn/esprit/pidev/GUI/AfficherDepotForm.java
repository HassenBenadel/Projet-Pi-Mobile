/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;
import tn.esprit.pidev.Entity.Depot;
import tn.esprit.pidev.Services.ServiceDepot;

/**
 *
 * @author Ibtihel
 */
public class AfficherDepotForm extends Form{
    Form current;
    ServiceDepot dS = new ServiceDepot();
    
     public AfficherDepotForm(Form previous) {
         
          setTitle("Liste Depots");
          setLayout(BoxLayout.y());
        
         Button btn_ajouter = new Button("Ajouter");
        btn_ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AjouterDepotForm(current).show();
            }
     });
          Button menu = new Button("Menu");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new MenuForm(current).show();
            }
     });
        Container cnt_button = new Container(new BorderLayout());
        cnt_button.add(BorderLayout.WEST,btn_ajouter);
        cnt_button.add(BorderLayout.EAST,menu);
        addAll(cnt_button);
        
         
     
        
        List<Depot> listD =dS.getDepots();
        
        for (Depot d: listD ){
          
        Container item = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container item1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container item2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

        
     
        Button btn_UpdateDepot = new Button("Modifier");
        Button btn_deleteDepot = new Button("Supprimer");

     btn_deleteDepot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                dS.SupprimerDepot(d.getId_depot());
                System.out.println(d.getId_depot());
                new AfficherDepotForm(current).show();
            }
     });
     btn_UpdateDepot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new ModifierDepotForm(current,d).show();
            }
     });
        item.add(new Label("Adresse:"));
        item.add(new Label(d.getAdresse()));
        item.add(new Label("Disponibilite:"));
        item.add(new Label(d.getDisponibilite()));
        item.add(new Label("Quantite:"));
        item.add(new Label((String.valueOf(d.getQuantite()))));
        item1.add(new Label("Produit:"));
        item1.add(new Label((String.valueOf(d.getId_produit()))));
        item1.add(new Label("Livraison:"));
        item1.add(new Label((String.valueOf(d.getId_livraison().getId_livraison()))));
        
       item2.add(btn_UpdateDepot);
       item2.add(btn_deleteDepot);
           
              
        addAll(item,item1,item2);
        }
    }
    
    
}
