package com.resatoAPI.com.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("Prêt")
    PRET,

    @JsonProperty("Servi")
    SERVI,

    @JsonProperty("En attente")
    EN_ATTENTE,

    @JsonProperty("En préparation")
    EN_PREPARATION;


    // Ajout d'un JsonCreator pour les valeurs inattendues
    @JsonCreator
    public static Status fromValue(String value) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(value) || status.toString().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + value);
    }
}
