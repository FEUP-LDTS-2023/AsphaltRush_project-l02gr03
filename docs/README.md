# LDTS_T02_G03 - AsphaltRush


The main objective of this game is to guide a car as far as possible, avoiding obstacles such as cars and holes, while accumulating points to climb the rankings.


This project was developed by:

*Bruno Ferreira* (up202207863@fe.up.pt)

*Eduardo Ferreira* (up202206628@fe.up.pt)

*Ricardo Parreira* (up202205091@fe.up.pt)

*Xavier Martins* (up202206632@fe.up.pt)

 for LDTS 23/24

## Game Demo

![GameDemo GIF](images/Demo.gif)


## IMPLEMENTED FEATURES

### Car Selection in Garage
Players can choose from a variety of cars available in the garage before starting the game.

![Garage GIF](images/Garage.gif)

### Scoring System
The game features a scoring system that increases as the player covers greater distances, accumulating points.

![Score GIF](images/Score.gif)

### Ranking Display
The best scores are showcased on a ranking screen, fostering healthy competition among players.

![Ranking GIF](images/Ranking.gif)

### Obstacle Variety
Various obstacles, including moving cars and holes in the track that challenges the player during gameplay.

![Obstacles GIF](images/Obstacles.gif)

### Power ups
Implemented two power ups:
  - ***Score Multiplier Power Up*** - Temporarily boosts the points earned by multiplying them by a specific factor.

    ![Multiplier GIF](images/Multiplier.gif)

  - ***Invincibility Power up*** - Grants temporary invulnerability, allowing the player to pass through obstacles without losing.
    
    ![Invincibility GIF](images/Invincibility.gif)

### Game Over Screen 
After colliding with an obstacle and losing, the game over screen displays the score and lets the player input their name for the best player's ranking.

![GameOver GIF](images/GameOver.gif)

### Game Sound
This game offers a audio experience with a background song playing throughout most of the game. There's also a special tune when the player loses to add some drama. Plus, there are various sound effects that kick in during specific moments, making the gaming experience even more immersive.

## PLANNED FEATURES

### Diverse Game Zones
Experience dynamic gameplay as the environment transforms, entering in different zones such as deserts or icy landscapes.

### Expanded Car Selection
More variety of cars in the garage.

### Obstacle Variety
Encounter new obstacles, such as barriers and oil spills.

### Diverse Power ups
Have a more distinct array of power-ups, such as time freezing, jumping or miniaturization.

### In-Game Shop
Introduce a in-game shop where players can utilize coins, collected during the game, to unlock new cars.

## DESIGN

### Architectural Pattern

#### Problem in Context

The way we set up the project is super important. It's the game's foundation, and picking the right way to do it early on is key. Changing it later in the game-making process can be a big challenge and create a lot of problems.


#### The Pattern

We have applied the **MVC (Model-View-Controller)** pattern. This pattern is important in order to promote a better organization to the project, having three components:
Model: Responsible for managing the data, processing user inputs, and enforcing the business rules of the application.
View: Responsible for representing the data to the user and capturing user input
Controller: Responsible for handling user interactions and updating the Model and View as necessary

#### Implementation

See the UML

#### Consequences

The use of the MVC Pattern in the current design allows the following benefits:

Modularity
Reusability
Testability
Scability


### Game mode

#### Problem in Context

The game can be either in a Menu, Ranking, Garage Menu, Game or in a Game Over state.

#### The Pattern

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass).

#### Implementation

See the UML


#### Consequences

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the different game states become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

### Images

#### Problem in Context

When considering the best way to store the image information of each element we encountered a problem. Having that information hard written inside each element object would be impractical, difficult to change. On the other hand, we could store the images as separate files that would be read once the objects were created, but this approach would also cause some unnecessary overhead since a lot of the elements have the same texture.


#### The Pattern

We have applied the **Flyweight** pattern. This pattern is used to minimize memory usage or computational expenses by sharing as much as possible with related objects. So, in a game like this one, where we have similar elements, it's a way of minimizing the memory usage. In this concrete case, different elements with the same texture would use the same Image Class, avoiding unnecessary loading of textures.

#### Implementation



#### Consequences

The use of the Flyweight Pattern in the current design allows the following benefits:

Memory Efficiency - By sharing common state, the Flyweight pattern reduces the memory footprint of an application, especially when dealing with a large number of instances.
Performance Improvement - Sharing common state can lead to performance improvements, as the overhead associated with managing redundant data is minimized.



### KNOWN CODE SMELLS

#### Lazy Class 

The [CrashSound](../app/src/main/java/com/ldts/asphaltrush/model/soundEffects/CrashSound.java), [PowerUpSound](../app/src/main/java/com/ldts/asphaltrush/model/soundEffects/PowerUpSound.java), [SelectCarSound](../app/src/main/java/com/ldts/asphaltrush/model/soundEffects/SelectCarSound.java) and [SelectOptionSound](../app/src/main/java/com/ldts/asphaltrush/model/soundEffects/SelectOptionSound.java) classes can be considered lazy classes, because the only difference between them is the value passed in the constructor, not having significant methods. However, we created them considering the use of the template pattern, in order to, in the future, be able to change easily the sound effects volume with a specific method.

#### Large Class

The [LanternaGUI](../app/src/main/java/com/ldts/asphaltrush/gui/LanternaGUI.java) class has many methods, so it can be considered a large class. In our perspective, this methods dont make sense in other place, since that they are extremely correlated with the class.

#### Duplicate Code

The [Ranking](../app/src/main/java/com/ldts/asphaltrush/model/ranking/Ranking.java) and [GameOver](../app/src/main/java/com/ldts/asphaltrush/model/gameOver/GameOver.java) classes can be a code smell of duplicate code type, since that both have a method to read the [ranking](../app/data/Rankings.txt) file that is, in part, very similar. In order to solve that, we could create a new class responsible to do that, and this classes only instantiate the new one.

#### Shotgun Surgery

The addition of new power ups can lead to the shotgun surgery code smell, considering that when added a new power up, depending of what is his purpose, we should change some little things in various places. An example is the [PowerUpController](../app/src/main/java/com/ldts/asphaltrush/controller/game/PowerUpController.java) class, where we need to adapt the addNewPowerUps method or the [StreetController](../app/src/main/java/com/ldts/asphaltrush/controller/game/StreetController.java) class, where the checkCollisions method could be different depending on the objective of the power up.


### TESTING
#### Coverage Report

![Coverage Report](images/Coverage.png)


#### Mutation Testing Report 

![Mutation Test](images/pitest.png)

[Mutation Test](pitest/pitest.html)


### SELF-EVALUATION

Bruno Ferreira: 25%

Eduardo Portugal: 25%

Ricardo Parreira: 25%

Xavier Martins: 25%



