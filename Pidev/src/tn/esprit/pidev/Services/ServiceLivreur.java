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
import tn.esprit.pidev.Entity.Livreur;

/**
 *
 * @author Ibtihel
 */
public class ServiceLivreur {
    //************************************************************
       public ArrayList<Livreur> getListLivreur(String json) {

        ArrayList<Livreur> listlivreurs = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> livreurs = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) livreurs .get("root");

            for (Map<String, Object> obj : list) {
                Livreur livreur = new Livreur();
                livreur.setId_livreur((int) Float.parseFloat(obj.get("idLivreur").toString()));
                livreur.setSecteuractivite(obj.get("secteuractivite").toString());                  
                listlivreurs.add(livreur);
            }

        } catch (IOException ex) {
        }

        return listlivreurs;

    }
       
    ArrayList<Livreur> listDepots = new ArrayList<>();

    public ArrayList<Livreur> getLivreurs() {
        ConnectionRequest con = new ConnectionRequest();
        
                        con.setUrl("http://127.0.0.1:8000/showlivreur");
                        
            
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                listDepots= getListLivreur(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listDepots;
    }

    
}
