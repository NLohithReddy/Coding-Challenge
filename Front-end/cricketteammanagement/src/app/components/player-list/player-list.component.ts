import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../services/player.service';
import { Player } from '../../models/player.model';

@Component({ selector: 'app-player-list', templateUrl: './player-list.component.html' })
export class PlayerListComponent implements OnInit {
  players: Player[] = [];

  constructor(private playerService: PlayerService) {}

  ngOnInit(): void {
    this.loadPlayers();
  }

  loadPlayers(): void {
    this.playerService.getAllPlayers().subscribe(data => this.players = data);
  }

  deletePlayer(id: number): void {
    if (confirm('Delete this player?')) {
      this.playerService.deletePlayer(id).subscribe(() => this.loadPlayers());
    }
  }
}