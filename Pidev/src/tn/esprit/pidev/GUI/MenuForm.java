/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Ibtihel
 */
public class MenuForm extends Form{
    Form current;
     public MenuForm(Form previous) {
         
          Button livraison = new Button("Gestion Livraison");
        livraison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AfficherLivraisonForm(current).show();
            }
     });
         Button depot = new Button("Gestion Depot");
        depot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AfficherDepotForm(current).show();
            }
     });
        
 Container item = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 item.add(livraison);
        item.add(depot);
         addAll(item);
         
     }
    
}
