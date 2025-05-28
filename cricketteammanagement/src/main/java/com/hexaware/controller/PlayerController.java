package com.hexaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Player> create(@Valid @RequestBody Player player) {
        return new ResponseEntity<>(service.createPlayer(player), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @Valid @RequestBody Player player) {
        return service.updatePlayer(id, player);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
