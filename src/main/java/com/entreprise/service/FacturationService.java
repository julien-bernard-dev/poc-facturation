package main.java.com.entreprise.service;

import main.java.com.entreprise.dto.ClientDto;
import main.java.com.entreprise.dto.ClientPartDto;
import main.java.com.entreprise.dto.ClientProDto;
import main.java.com.entreprise.dto.FactureDto;

public class FacturationService {

    public static FactureDto calculeFacturation(ClientDto client){

        ConsommationService consommationService = new ConsommationService();
        double consommation = consommationService.rechercherConsommationClient(client);

        return switch(client){
            case ClientPartDto clientPart   -> new FactureDto(
                    clientPart.referenceClient(),
                    consommation,
                    calculeFactuClientPart(clientPart,consommation));
            case ClientProDto clientPro     -> new FactureDto(
                    clientPro.referenceClient(),
                    consommation,
                    calculeFactuClientPro(clientPro,consommation));
        };
    }

    private static double calculeFactuClientPart(ClientPartDto clientPart, double consommation){

        return switch(clientPart.energie()){
            case ELECTRICITE -> consommation * 0.133;
            case GAZ -> consommation * 0.108;
        };
    }

    private static double calculeFactuClientPro(ClientProDto clientPro, double consommation){

        double facture = 0;

        if(clientPro.chiffreAffaire()>1_000_000){
            switch (clientPro.energie()){
                case ELECTRICITE -> facture = consommation * 0.110;
                case GAZ -> facture = consommation * 0.123;
            }
        } else {
            switch (clientPro.energie()){
                case ELECTRICITE -> facture = consommation * 0.112;
                case GAZ -> facture = consommation * 0.117;
            }
        }

        return facture;
    }
}
