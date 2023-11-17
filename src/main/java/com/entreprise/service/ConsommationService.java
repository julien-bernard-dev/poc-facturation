package main.java.com.entreprise.service;

import main.java.com.entreprise.dto.ClientDto;
import main.java.com.entreprise.dto.ClientPartDto;
import main.java.com.entreprise.dto.ClientProDto;

import java.util.HashMap;
import java.util.Random;

public class ConsommationService {

    private HashMap<String,Double> consommationsClients;

    public ConsommationService(){
        consommationsClients = new HashMap<>();

        consommationsClients.put("1234", genererConsommationClient());
        consommationsClients.put("1235", genererConsommationClient());
        consommationsClients.put("1236", genererConsommationClient());
        consommationsClients.put("1237", genererConsommationClient());
        consommationsClients.put("1238", genererConsommationClient());
        consommationsClients.put("1239", genererConsommationClient());
    }

    public double rechercherConsommationClient(ClientDto client){
        return switch(client){
            case ClientPartDto clientPart   -> consommationsClients.get(clientPart.referenceClient());
            case ClientProDto clientPro     -> consommationsClients.get(clientPro.referenceClient());
        };
    }

    private double genererConsommationClient(){
        Random ran = new Random();
        return ran.nextInt(1000) + 1000;
    }
}
