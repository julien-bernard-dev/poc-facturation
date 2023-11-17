package main.java.com.entreprise.runner;

import main.java.com.entreprise.dto.ClientDto;
import main.java.com.entreprise.service.ClientService;
import main.java.com.entreprise.service.FacturationService;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        System.out.println("""
        --------------------------------
        Init du programme de facturation
        --------------------------------
        """);

        ClientService clientService = new ClientService();
        List<ClientDto> listeClients = clientService.rechercherClients();

        System.out.println("Liste des clients :\n");
        listeClients.forEach(System.out::println);

        System.out.println("\nListe des factures :\n");
        listeClients.stream()
                .map(FacturationService::calculeFacturation)
                .forEach(facture -> System.out.printf("""
                    Facture de la reference client : %s
                    Total des consommations du mois = %s kWh
                    Montant à régler = %.2f euros \n
                    """.formatted(facture.referenceClient(),facture.consommation(),facture.montant())));

        System.out.println("""
        -------------------------------
        Fin du programme de facturation
        -------------------------------
        """);
    }
}