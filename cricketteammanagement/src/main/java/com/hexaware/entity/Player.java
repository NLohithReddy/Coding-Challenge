package com.hexaware.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @NotBlank
    private String playerName;

    @Min(0)
    private int jerseyNumber;

    @NotBlank
    private String role; 

    @Min(0)
    private int totalMatches;

    @NotBlank
    private String teamName;

    @NotBlank
    private String countryOrState;

    private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
