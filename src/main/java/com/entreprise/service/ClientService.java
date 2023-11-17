package main.java.com.entreprise.service;

import main.java.com.entreprise.dto.ClientDto;
import main.java.com.entreprise.dto.ClientPartDto;
import main.java.com.entreprise.dto.ClientProDto;
import main.java.com.entreprise.enums.Civilite;
import main.java.com.entreprise.enums.Energie;

import java.util.HashMap;
import java.util.List;

public class ClientService {

    private HashMap<String,ClientDto> mapClients;

    public ClientService(){
        mapClients = new HashMap<>();
        mapClients.put("1234", new ClientPartDto("Gray","Lola",Civilite.FEMME, Energie.GAZ, "1234"));
        mapClients.put("1235", new ClientPartDto("Bond", "James", Civilite.HOMME, Energie.ELECTRICITE, "1235"));
        mapClients.put("1236", new ClientProDto("12345678901236","LittleFishCompany", 400_000, Energie.GAZ, "1236"));
        mapClients.put("1237", new ClientProDto("12345678901237","BigFishCompany",1_300_000, Energie.GAZ, "1237"));
        mapClients.put("1238", new ClientProDto("12345678901238","LittleFoxCompany",100_000, Energie.ELECTRICITE, "1238"));
        mapClients.put("1239", new ClientProDto("12345678901239", "BigFoxCompany", 12_000_000, Energie.ELECTRICITE, "1239"));
    }

    public List<ClientDto> rechercherClients(){
        return this.mapClients.values().stream().toList();
    }

    public ClientDto rechercherClient(String referenceClient){
        return this.mapClients.get(referenceClient);
    }
}
