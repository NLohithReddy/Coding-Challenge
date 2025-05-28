package com.hexaware.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.dto.PlayerDTO;
import com.hexaware.entity.Player;
import com.hexaware.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public List<Player> getAll() {
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id) {
        return service.getPlayerById(id);
    }

    @PostMapping
    public ResponseEntity<Player> create(@Valid @RequestBody PlayerDTO dto) {
        Player player = dtoToEntity(dto);
        Player created = service.createPlayer(player);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @Valid @RequestBody PlayerDTO dto) {
        Player player = dtoToEntity(dto);
        Player updated = service.updatePlayer(id, player);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to map DTO to Entity
    private Player dtoToEntity(PlayerDTO dto) {
        Player p = new Player();
        p.setPlayerId(dto.getPlayerId());
        p.setPlayerName(dto.getPlayerName());
        p.setJerseyNumber(dto.getJerseyNumber());
        p.setRole(dto.getRole());
        p.setTotalMatches(dto.getTotalMatches());
        p.setTeamName(dto.getTeamName());
        p.setCountryOrState(dto.getCountryOrState());
        p.setDescription(dto.getDescription());
        return p;
    }
}
