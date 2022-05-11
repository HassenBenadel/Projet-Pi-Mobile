/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import tn.esprit.pidev.Entity.Depot;
import tn.esprit.pidev.Entity.Livraison;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;
import tn.esprit.pidev.Entity.Livreur;


/**
 *
 * @author Ibtihel
 */
public class ServiceLivraison {
    //bech n3aytou lel crud eli zednehom f symfony w yraj3ou JSONresult w nzidou code e5er 
    
    //ajout 
    public void AjouterLivraison(Livraison l) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/addlivraison");
        con.addArgument("Idlivreur", String.valueOf(l.getId_livreur().getId_livreur()));
        con.addArgument("Prixtotal", l.getPrix_total());
        con.addArgument("Modepaiement", l.getMode_paiement());
        con.addArgument("Idcommande", String.valueOf(l.getId_commande()));
        con.addArgument("Date", new SimpleDateFormat("dd-MM-yyyy").format(l.getDate_livraison()));
        con.addArgument("Idclient", String.valueOf(l.getId_client()));

        NetworkManager.getInstance().addToQueueAndWait(con);
        

    }
    
    
    
    
    
    
    public Livraison Showlivraisonbyid(int x) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false); //post type de méth http
        con.setUrl("http://127.0.0.1:8000/showlivraisonbyid?Idlivraison="+x);
        con.addArgument("Idlivraison", String.valueOf(x));

       Livraison livraison = new Livraison();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();

                Map<String, Object> l;
                try {
                    l = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    
                   livraison.setId_livraison((int) Float.parseFloat(l.get("Id_livraison").toString()));
		   String date_Livraison = l.get("Date_livraison").toString();
                    livraison.setMode_paiement(l.get("mode_paiement").toString());
                    livraison.setPrix_total(l.get("prix_total").toString());
                    livraison.setId_commande((int) Float.parseFloat(l.get("Id_commande").toString()));
                    livraison.setId_client((int) Float.parseFloat(l.get("Id_client").toString()));
                    
                    
                    
                    String li =  l.get("Id_livreur").toString();
                    li = li.substring(li.indexOf("=") + 1, li.indexOf("."));
                    
                    Livreur l1 = new Livreur();
                    l1.setId_livreur((int) Float.parseFloat(li));
                    livraison.setId_livreur(l1);
                    
                    
                    
                    
                    System.out.println(livraison.getId_livreur().getId_livreur());
                    try {  
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date d = sdf.parse(date_Livraison);
                         livraison.setDate_livraison(d);
                         String newDateString;
                        newDateString = sdf.format(d);
                         //System.err.println("*****"+livraison.getId_livreur().getId_livreur());
                    } catch (ParseException ex) {
                        //Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
                    }
          

                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return livraison;
    }
    
    
     public void SupprimerLivraison(int x) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/deletelivraison");
        con.addArgument("Idlivraison", String.valueOf(x));
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
     
     
     
       public void ModifierLivraison(Livraison l) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/updateLivraison");
        con.addArgument("Idlivraison", String.valueOf(l.getId_livraison()));
        con.addArgument("Idlivreur", String.valueOf(l.getId_livreur().getId_livreur()));
        con.addArgument("Prixtotal", l.getPrix_total());
        con.addArgument("Modepaiement", l.getMode_paiement());
        con.addArgument("Idcommande", String.valueOf(l.getId_client()));
        con.addArgument("Date", new SimpleDateFormat("dd-MM-yyyy").format(l.getDate_livraison()));
        con.addArgument("Idclient", String.valueOf(l.getId_client()));

        NetworkManager.getInstance().addToQueueAndWait(con);
        

    }
       
       
       
       
       
       
       
       
       //************************************************************
       public ArrayList<Livraison> getListLivraison(String json) {

        ArrayList<Livraison> listlivraisons = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> livraisons = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) livraisons.get("root");

            for (Map<String, Object> obj : list) {
                Livraison livraison = new Livraison();
                livraison.setId_livraison((int) Float.parseFloat(obj.get("Id_livraison").toString()));
		   String date_Livraison = obj.get("Date_livraison").toString();
try {  
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date d = sdf.parse(date_Livraison);
                         livraison.setDate_livraison(d);
                         String newDateString;
                        newDateString = sdf.format(d);
                    } catch (ParseException ex) {
                        //Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
                    }                    livraison.setMode_paiement(obj.get("mode_paiement").toString());
                    livraison.setPrix_total(obj.get("prix_total").toString());
                    livraison.setId_commande((int) Float.parseFloat(obj.get("Id_commande").toString()));
                    livraison.setId_client((int) Float.parseFloat(obj.get("Id_client").toString()));
                    String li =  obj.get("Id_livreur").toString();
                    li = li.substring(li.indexOf("=") + 1, li.indexOf("."));
                    
                    Livreur l1 = new Livreur();
                    l1.setId_livreur((int) Float.parseFloat(li));
                     livraison.setId_livreur(l1);
                     listlivraisons.add(livraison);

            }

        } catch (IOException ex) {
        }

        return listlivraisons;

    }
       
    ArrayList<Livraison> listLivraisons = new ArrayList<>();

    public ArrayList<Livraison> getLivraisons() {
        ConnectionRequest con = new ConnectionRequest();
        
                        con.setUrl("http://127.0.0.1:8000/showlivraison");
                        
            
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
           
                listLivraisons = getListLivraison(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivraisons;
    }

}
