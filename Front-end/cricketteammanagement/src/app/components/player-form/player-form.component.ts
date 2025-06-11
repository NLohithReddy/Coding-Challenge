// 8. player-form.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from '../../services/player.service';
import { Player } from '../../models/player.model';

@Component({
  selector: 'app-player-form',
  templateUrl: './player-form.component.html'
})
export class PlayerFormComponent implements OnInit {
  player: Player = {
    playerId: 0,
    playerName: '',
    jerseyNumber: 0,
    role: '',
    totalMatches: 0,
    teamName: '',
    countryOrState: '',
    description: ''
  };
  isEditMode = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private playerService: PlayerService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.playerService.getPlayerById(+id).subscribe(p => this.player = p);
    }
  }

  onSubmit(): void {
  if (this.isEditMode) {
    this.playerService.updatePlayer(this.player.playerId, this.player).subscribe(() => {
      alert('Player updated successfully');
      this.router.navigate(['/']);
    });
  } else {

    const { playerId, ...playerWithoutId } = this.player;
    this.playerService.addPlayer(playerWithoutId as Player).subscribe(() => {
      alert('Player added successfully');
      this.router.navigate(['/']);
    });
  }
}

}
