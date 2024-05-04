![logo](https://github.com/Kaya-Sem/Ugentopoly/assets/73200952/935a8bf4-17d0-4792-9ff6-4284ee30634e)


Monopoly is a board game aimed at buying, renting, and selling real estate to increase the wealth of the players. The player who is the richest at the end of the game becomes the winner. The game starts on the START square, after which players move their game piece around the board based on a roll of two dice. When a player lands on a property that is not yet owned, it can be purchased from the bank. Players who own property receive rent from other players who land on it. Instructions from the Community Chest or Chance cards must always be followed.

## Implementation

Ugentopoly was entirely created in java and JavaFX (without use of FXML). It utilises XML and properties files for loading game data.

### Rules

- The game is played with a minimum of two and a maximum of four players.

- At the start of the game, each token (player) is on the START square.

- Each turn begins with rolling two dice, after which the player's token is moved a corresponding number of spaces, except when the player is in jail.
After this, the actions corresponding to the square on which the player lands are executed (see squares).

- If the player rolls doubles, they may roll again; otherwise, it is the next player's turn.

- The game ends as soon as one of the players runs out of money.

- The winner of the game is the player who has the most money at that time.

### Tiles

#### start:

- The starting point for each player at the beginning of the game.

- Every time a player passes this square, they receive a starting amount. The exact amount is specified in the XML file under the settings element in the go attribute.

- If a player lands on this square, they receive double the amount.

#### jail:

- If a player lands on this square by moving their token, nothing happens. The player is just visiting.

- If a player rolls doubles three times in a row, they are sent to jail.

- If a player lands on the "Go Directly to Jail" square, they must go to jail. From the next turn, the player attempts to leave jail.

- If the player has a "Get Out of Jail Free" card, it must be used. Otherwise, the player must roll the dice and try to roll doubles to move their token the number of eyes thrown.

- It is not possible to pay to leave jail.


**free parking:**
        
- If a player lands on this square, they receive the amount present in the bonus pot. Afterwards, the amount in the bonus pot is reset to zero.

- go directly to jail: see jail


#### taxes:
        
- The player landing on this type of square must pay the associated amount as a fine. This amount is added to the bonus pot.
  
#### chance, community chest:
       
- The player draws a card and carries out what is stated on the card (see cards).

#### All other squares represent properties:
        
- If a player lands on such a square and it has no owner, the player can decide to purchase the square.
        
- If the player decides not to buy a property, nothing happens (it is not auctioned).
        
- Properties cannot be sold or mortgaged.
        
-  If a square is owned by someone other than the player themselves, rent must be paid to the owner.
        
**The rent calculation depends on the square.**

station:
                The base rent is set in the XML file.
                If the owner has multiple properties of this type, the rent doubles for each additional property. For example, with a base price of €25, the rent is €25 if the owner has one station, €50 if they have two, €100 for three, and €200 for four.
                
 utilities:
                The rent depends on the number of eyes the player last threw.
                If the owner has only one utility, the number of eyes thrown is multiplied by 4.
                If the player owns both utilities, the number of eyes thrown is multiplied by 10.
                
ordinary street:
                The base rent is indicated in the XML file.
                If the owner has all streets from the corresponding area, the rent doubles.
                No houses or hotels can be built.

### Cards

#### Get Out of Jail Free:

- Upon drawing the card, it is removed from the card pile. The player keeps the card until they are in jail, after which it is automatically used. After use, it is placed back into the correct card pile.

- Go (directly) to ...:
        Move the player's token to the indicated square. Direct movement does not pass go. Once the player arrives at their destination, any actions associated with that destination are carried out (possibility to buy, pay rent, etc.).
- Go x squares forward/back:
        Move the player's token the indicated number of squares forward or backward. Once the player arrives at their destination, any actions associated with that destination are carried out (possibility to buy, pay rent, etc.).
- You receive €x/Pay €x:
        The player receives money from the bank, or must pay this amount. If the player has to pay, the amount goes into the bonus pot.
- Receive from each player/Pay each player:
        The player receives the specified amount from every other player or must pay each of the other players this amount.

## How to run

![promougentopoly](https://github.com/Kaya-Sem/Ugentopoly/assets/73200952/4efe4c92-be94-4b7e-9ecb-d2eb042743b4)
