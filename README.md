# PROJET PIRATERIE

Projet du cours MCR de la HEIG-VD ayant pour but l'illustration du pattern Mediator.

## Comportement des bateaux
### Pirate
Le pirate est caractérisé par :

- Une quantité de trésor
- Un seuil de trésor à atteindre

Le pirate essaie d'attaquer le bateau marchand le plus proche, tant que son seuil de trésor n'a pas été atteint. Sa quantité de trésor augmente à chaque fois qu'il détruit un bateau marchand.
Une fois le seuil de trésor atteint, le pirate ramène sa cargaison à sa base.
Cependant, le pirate peut à tout moment se faire détruire par un cosaire.

## Corsaire
Le corsaire est caractérisé par :

- Une quantité de trésor
- Un seuil de trésor à atteindre

Le corsaire essaie d'attaquer le pirate le plus proche, tant que son seuil de trésor n'a pas été atteint. Sa quantité de trésor augmente à chaque fois qu'il détruit un pirate.
Une fois le seuil de trésor atteint, le corsaire ramène sa cargaison à la base des marchands.

## Marchand
Le marchand est caractérisé par :

- Une quantité de trésor

Le marchand part de sa base et essaie d'amener son trésor à la base d'arrivée. Une fois arrivé, il dépose son trésor à la base d'arrivée.
Cependant, le marchand peut se faire détruire par un pirate avant d'arriver à destination.