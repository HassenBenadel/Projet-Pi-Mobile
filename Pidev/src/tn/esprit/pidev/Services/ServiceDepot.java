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
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tn.esprit.pidev.Entity.Depot;
import tn.esprit.pidev.Entity.Livraison;

/**
 *
 * @author Ibtihel
 */
public class ServiceDepot {
    
    
    
    public Depot Showdepotbyid(int x) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false); //post type de méth http
        con.setUrl("http://127.0.0.1:8000/showdepotbyid?IdDepot="+x);
        con.addArgument("IdDepot", String.valueOf(x));

        Depot depot = new Depot();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();

                Map<String, Object> d;
                try {
                
                    d = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    
                     depot.setId_depot((int) Float.parseFloat(d.get("Id_depot").toString()));
                     depot.setAdresse(d.get("adresse").toString());
                     depot.setQuantite((int) Float.parseFloat(d.get("quantite").toString()));
                     depot.setDisponibilite(d.get("disponibilite").toString());
                     depot.setId_produit((int) Float.parseFloat(d.get("Id_produit").toString()));
                     
                     String li =  d.get("Id_livraison").toString();
                    li = li.substring(li.indexOf("=") + 1, li.indexOf("."));
                    
                    Livraison l1 = new Livraison();
                    l1.setId_livraison((int) Float.parseFloat(li));
                    depot.setId_livraison(l1);

                     
                 
          
                   System.err.println("*****"+depot.getId_depot()+"*****"+ depot.getAdresse()+"******"+depot.getQuantite()+ "*****"+depot.getDisponibilite()+ "***" +depot.getId_produit() );

                  } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return depot;
    }
    
    
    
    public void AjouterDepot(Depot d) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/adddepot");
        con.addArgument("IdLivraison", String.valueOf(d.getId_livraison().getId_livraison()));
        con.addArgument("Adresse", d.getAdresse());
        con.addArgument("Quantite", String.valueOf(d.getQuantite()));
        con.addArgument("Disponibilite", d.getDisponibilite());
        
        con.addArgument("IdProduit", String.valueOf(d.getId_produit()));

        NetworkManager.getInstance().addToQueueAndWait(con);
        

    }
    
    
    
    
     public void SupprimerDepot(int x) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/deletedepot");
        con.addArgument("IdDepot", String.valueOf(x));
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
     
     
     
     
     
    public void ModifierDepot(Depot d) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/updatedepot");
        con.addArgument("IdDepot", String.valueOf(d.getId_depot()));
        con.addArgument("IdLivraison", String.valueOf(d.getId_livraison().getId_livraison()));
        con.addArgument("Adresse", d.getAdresse());
        con.addArgument("Quantite", String.valueOf(d.getQuantite()));
        con.addArgument("Disponibilite", d.getDisponibilite());
        
        con.addArgument("IdProduit", String.valueOf(d.getId_produit()));

        NetworkManager.getInstance().addToQueueAndWait(con);
        

    }
    
    
    
    
    
    
    
       //************************************************************
       public ArrayList<Depot> getListDepot(String json) {

        ArrayList<Depot> listdepots = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> depots = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) depots .get("root");

            for (Map<String, Object> obj : list) {
                Depot depot = new Depot();
                depot.setId_depot((int) Float.parseFloat(obj.get("Id_depot").toString()));
                depot.setAdresse(obj.get("adresse").toString());
                depot.setQuantite((int) Float.parseFloat(obj.get("quantite").toString()));
                depot.setDisponibilite(obj.get("disponibilite").toString());
                depot.setId_produit((int) Float.parseFloat(obj.get("Id_produit").toString()));
                    String liv =  obj.get("Id_livraison").toString();
                    liv = liv.substring(liv.indexOf("=") + 1, liv.indexOf("."));
                    
                    Livraison l = new Livraison();
                    l.setId_livraison((int) Float.parseFloat(liv));
                    depot.setId_livraison(l);
                listdepots.add(depot);

            }

        } catch (IOException ex) {
        }

        return listdepots;

    }
       
    ArrayList<Depot> listDepots = new ArrayList<>();

    public ArrayList<Depot> getDepots() {
        ConnectionRequest con = new ConnectionRequest();
        
                        con.setUrl("http://127.0.0.1:8000/showdepot");
                        
            
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
           
                listDepots= getListDepot(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listDepots;
    }

}
