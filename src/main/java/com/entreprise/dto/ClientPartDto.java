package main.java.com.entreprise.dto;

import main.java.com.entreprise.enums.Civilite;
import main.java.com.entreprise.enums.Energie;

public record ClientPartDto(
        String nom,
        String prenom,
        Civilite civilite,
        Energie energie,
        String referenceClient

) implements ClientDto {}
