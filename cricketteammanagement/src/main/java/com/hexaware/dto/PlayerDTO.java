package com.hexaware.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long playerId; 

    @NotBlank(message = "Player name is required")
    private String playerName;

    @Min(value = 0, message = "Jersey number must be positive")
    private int jerseyNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @Min(value = 0, message = "Total matches must be zero or more")
    private int totalMatches;

    @NotBlank(message = "Team name is required")
    @Pattern(
      regexp = "Sunrisers Hyderabad|Delhi Capitals|MI|RCB",
      message = "Invalid team name. Allowed values: Sunrisers Hyderabad, Delhi Capitals, MI, RCB"
    )
    private String teamName;

    @NotBlank(message = "Country/State name is required")
    private String countryOrState;

    private String description;

    // Lombok @Data already generates getters/setters, so these are redundant
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
}
