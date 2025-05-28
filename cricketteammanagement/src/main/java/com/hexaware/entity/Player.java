package com.hexaware.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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
    @Pattern(
        regexp = "Sunrisers Hyderabad|Delhi Capitals|MI|RCB",
        message = "Invalid team name. Allowed values: Sunrisers Hyderabad, Delhi Capitals, MI, RCB"
    )
    private String teamName;

    @NotBlank
    private String countryOrState;

    private String description;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryOrState() {
		return countryOrState;
	}

	public void setCountryOrState(String countryOrState) {
		this.countryOrState = countryOrState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    // getters and setters...
}
