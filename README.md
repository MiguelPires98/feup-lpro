# FEUP_LPRO

This repository contains all the Side Projects and the Final ProjectLabs done in the course Laboratório de Programação, a **4th year course** in the Master in Electrical and Computers Engineering @ FEUP

## Course Content

All the course's information can be viewed [here](https://sigarra.up.pt/feup/pt/UCURR_GERAL.FICHA_UC_VIEW?pv_ocorrencia_id=436865).

## Authors

* **Beatriz Garrido** - [bgarrido7](https://github.com/bgarrido7)


## Side Project
The Dragon's Bane RPG game developed in Java [here](https://github.com/bgarrido7/FEUP_LPRO/tree/master/DungeonKeep)


## Final Project
BlackJack Casino Game [here](https://github.com/bgarrido7/FEUP_LPRO/tree/master/BlackJack)

**classes hierarchy first draft:**

<img src="https://github.com/bgarrido7/FEUP_LPRO/blob/master/BlackJack/UMLs/classes%20hierarchy" width="500"><br><br>

**Game Rules**

* at the begining of the game, the player has a default money (10 in this case)
* after placing a bet that isn't higher then his current money, a set begins
  - 2 cards are draw for the player and the dealer, but the dealer's first card is hidden (marked as an X)
  - the player can now make his move, he can either:
    - skip: the set ends
    - double: set ends, player's bet is doubled
    - hit: another card is drawn for the player, if his card count exceeds 21, the set ends with him loosing
    - exit: the game ends and system exits program
  - at the end of a set, the dealer draws cards for himself until he reaches at least 16 (already counting the hidden card)
  - if the player had a bigger count than the dealer, he wins the money that he had betted 
  
* after the set ending, if he still has any money left, the player can bet again and another set will begin

**(NOTE: in each game, the deck is not reseated, meaning that in each set the cards that have been drawn in previous sets, will not appear again)**

**Class Diagram**
<img src="https://github.com/bgarrido7/FEUP_LPRO/blob/master/BlackJack/UMLs/classDiagram.png" width="800"><br><br>
