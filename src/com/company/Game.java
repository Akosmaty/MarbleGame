package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

  ArrayList<Integer> list = new ArrayList<>();
  Logic logic = new Logic();
  Turn playerOne;
  Turn playerTwo;

  public Game(Turn player1, Turn player2) {
    this.playerOne = player1;
    this.playerTwo = player2;
  }

  public void startGame() {

    while (true) {
      gameTurn(playerOne, playerTwo);

      gameTurn(playerTwo, playerOne);
    }
  }

  public void gameTurn(Turn player1, Turn player2) {
    {
      System.out.println(
          player1.getName() + " podsiada " + player1.getBallsInStack() + " kulek w worku");
      System.out.println(
          player2.getName() + " podsiada " + player2.getBallsInStack() + " kulek w worku");
      player1.setBallsInHands();
      player2.setBallsInHands();
      player1.setGuessIsPairedOrNot();

      boolean activePlayerGuess = player1.isGuessIsPairedOrNot();
      System.out.println(
          player1.getName()
              + " Ustalil  '"
              + player1.isGuessIsPairedOrNot()
              + "' ze gracz "
              + player2.getName()
              + " ma  parzysta liczbe kulek w reku");
      System.out.println(player1.getName() + " obstawil " + player1.getBallsInHands() + " kulek");
      System.out.println(player2.getName() + " obstawil " + player2.getBallsInHands() + " kulek");
      list.add(player1.getBallsInHands());
      list.add(player2.getBallsInHands());
      list.add(player1.getBallsInStack());
      list.add(player2.getBallsInStack());

      logic.setParameters(list, activePlayerGuess);
      logic.turnLogic();
      player1.setBallsInStack(logic.activePlayerBallsInStack);
      player2.setBallsInStack(logic.passivePlayerBallsInStack);
      list.clear();
      endGameCheck();
    }
  }

  void endGameCheck() {
    if (playerTwo.getBallsInStack() >= 40 || playerTwo.getBallsInStack() <= 0) {
      System.out.println(
          "\n Gra zakonczona \n "
              + playerOne.getName()
              + " posiada "
              + playerOne.getBallsInStack()
              + " kulek");
      System.out.println(playerTwo.getName() + " posiada " + playerTwo.getBallsInStack() + " kulek");
      Scanner scanner = new Scanner(System.in);
      System.out.println(
          "Kliknij Y jesli chcesz zaczac nowa gre \n jesli chcesz zamknac kilknij dowolny przycisk");

      if (scanner.nextLine().equalsIgnoreCase("Y")) {
        System.out.println(" \n zaczynamy nowa gre \n ");
        playerTwo.setBallsInStack(20);
        playerOne.setBallsInStack(20);
        startGame();
      }
      System.out.println("Dziekuje za gre, dowidzenia");
      System.exit(2);
    }
  }
}












