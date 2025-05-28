package com.hexaware.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long playerId; // Optional for POST, useful in PUT/GET

    @NotBlank(message = "Player name is required")
    private String playerName;

    @Min(value = 0, message = "Jersey number must be positive")
    private int jerseyNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @Min(value = 0, message = "Total matches must be zero or more")
    private int totalMatches;

    @NotBlank(message = "Team name is required")
    private String teamName;

    @NotBlank(message = "Country/State name is required")
    private String countryOrState;

    private String description;

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
}