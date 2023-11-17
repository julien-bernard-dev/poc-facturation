package main.java.com.entreprise.dto;

import main.java.com.entreprise.enums.Energie;

public record ClientProDto(
        String siret,
        String raisonSociale,
        int chiffreAffaire,
        Energie energie,
        String referenceClient

) implements ClientDto {}
