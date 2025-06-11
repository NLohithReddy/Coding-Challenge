package com.hexaware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.entity.Player;
import com.hexaware.exception.PlayerNotFoundException;
import com.hexaware.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repo;

    private static final String TEAM_NAME_REGEX = "Sunrisers Hyderabad|Delhi Capitals|MI|RCB";

    private void validateTeamName(String teamName) {
        if (teamName == null || !teamName.matches(TEAM_NAME_REGEX)) {
            throw new IllegalArgumentException(
                "Invalid team name. Allowed values: Sunrisers Hyderabad, Delhi Capitals, MI, RCB");
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    @Override
    public Player getPlayerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
    }

    @Override
    public Player createPlayer(Player player) {
        validateTeamName(player.getTeamName());
        return repo.save(player);
    }

    @Override
    public Player updatePlayer(Long id, Player updatedPlayer) {
        validateTeamName(updatedPlayer.getTeamName());
        Player existing = getPlayerById(id);

        existing.setPlayerName(updatedPlayer.getPlayerName());
        existing.setJerseyNumber(updatedPlayer.getJerseyNumber());
        existing.setRole(updatedPlayer.getRole());
        existing.setTotalMatches(updatedPlayer.getTotalMatches());
        existing.setTeamName(updatedPlayer.getTeamName());
        existing.setCountryOrState(updatedPlayer.getCountryOrState());
        existing.setDescription(updatedPlayer.getDescription());

        return repo.save(existing);
    }

    @Override
    public void deletePlayer(Long id) {
        repo.deleteById(id);
    }
}
