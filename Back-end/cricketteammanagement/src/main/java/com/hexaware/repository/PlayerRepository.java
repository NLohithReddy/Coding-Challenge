package com.hexaware.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
