/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.util.Date;
import java.util.List;
import tn.esprit.pidev.Entity.Livraison;
import tn.esprit.pidev.Services.ServiceLivraison;

/**
 *
 * @author Ibtihel
 */
public class AfficherLivraisonForm extends Form{
    Form current;
    ServiceLivraison lS = new ServiceLivraison();
    public AfficherLivraisonForm(Form previous) {

        setTitle("Liste Livraisons");
        setLayout(BoxLayout.y());
        
        Button btn_ajouter = new Button("Ajouter");
        btn_ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new AjouterLivraisonForm(current).show();
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
        
        List<Livraison> listL =lS.getLivraisons();
        
        for (Livraison l: listL){
          //add(cnt_prix);
        Container item = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container item1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container item2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDateString;
        newDateString = sdf.format(l.getDate_livraison());
       
            Button btn_UpdateLivraison = new Button("Modifier");
        Button btn_deletLivraison = new Button("Supprimer");

     btn_deletLivraison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                lS.SupprimerLivraison(l.getId_livraison());
                System.out.println(l.getId_livraison());
                new AfficherLivraisonForm(current).show();
            }
     });
     btn_UpdateLivraison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                new ModifierLivraisonForm(current,l).show();
            }
     });
        item.add(new Label("Prix Total:"));
        item.add(new Label(l.getPrix_total()));
        item.add(new Label("Date:"));
        item.add(new Label(newDateString));
        item.add(new Label("commande:"));
        item.add(new Label((String.valueOf(l.getId_commande()))));
        item1.add(new Label("client:"));
        item1.add(new Label((String.valueOf(l.getId_client()))));
        item1.add(new Label("livreur:"));
        item1.add(new Label((String.valueOf(l.getId_livreur().getId_livreur()))));
        item1.add(new Label("Mode Paiement:"));
        item1.add(new Label(l.getMode_paiement()));
       item2.add(btn_UpdateLivraison);
       item2.add(btn_deletLivraison);
           
              
        addAll(item,item1,item2);
        }
    }
    
}
