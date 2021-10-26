package com.company;

import java.util.ArrayList;

public class Game {

  ArrayList<Integer> list = new ArrayList<>();
  Logic logic = new Logic();
  PlayerTurn playerTurn = new PlayerTurn(20);
  NpcTurn npcTurn = new NpcTurn(20, "Radoslaw");

  public void startGame() {
    while(true){
    gameTurn(playerTurn, npcTurn);

    gameTurn(npcTurn, playerTurn);
}
  }

  public void gameTurn(Turn player1, Turn player2) {
    {
      System.out.println(player1.getName()  + " podsiada " + player1.getBallsInStack() + " kulek w worku");
      System.out.println(player2.getName()  + " podsiada " + player2.getBallsInStack() + " kulek w worku");
      player1.setBallsInHands();
      player2.setBallsInHands();
      player1.setGuessIsPairedOrNot();


      boolean activePlayerGuess = player1.isGuessIsPairedOrNot();
      System.out.println(player1.getName() + " Ustalil  '" + player1.isGuessIsPairedOrNot() + "' ze gracz " + player2.getName() + " ma  parzysta liczbe kulek w reku");
      System.out.println(player1.getName()+ " obstawil " + player1.getBallsInHands() +" kulek");
      System.out.println(player2.getName() + " obstawil " + player2.getBallsInHands() +" kulek");
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
  void endGameCheck(){
    if (npcTurn.getBallsInStack()>=40 || npcTurn.getBallsInStack()<=0){
      System.out.println("\n Gra zakonczona \n "+playerTurn.getName() + " posiada " + playerTurn.getBallsInStack() +" kulek");
      System.out.println(npcTurn.getName() + " posiada " + npcTurn.getBallsInStack() +" kulek");
      System.out.println(" \n zaczynamy nowa gre \n ");
      npcTurn.setBallsInStack(20);
    playerTurn.setBallsInStack(20);
      startGame();}
  }
}












