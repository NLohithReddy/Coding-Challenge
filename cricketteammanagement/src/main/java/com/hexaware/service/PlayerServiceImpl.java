package com.hexaware.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.hexaware.entity.Player;
import com.hexaware.exception.PlayerNotFoundException;
import com.hexaware.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repo;

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayerById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
    }

    public Player createPlayer(Player player) {
        return repo.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player existing = getPlayerById(id);
        BeanUtils.copyProperties(updatedPlayer, existing, "playerId");
        return repo.save(existing);
    }

    public void deletePlayer(Long id) {
        repo.deleteById(id);
    }
}
