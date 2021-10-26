package com.company;

import java.util.Scanner;

public class PlayerTurn implements Turn {
  private int ballsInHands;
  private int ballsInStack;
  private boolean guessIsPairedOrNot;
  UserInput userInput = new UserInput();
  private final String name;
  Scanner scanner = new Scanner(System.in);

  public int getBallsInHands() {
    return ballsInHands;
  }

  public PlayerTurn(int ballsInStack, String name) {
    this.ballsInStack = ballsInStack;
    this.name = name;
  }

  public void setBallsInHands() {

    this.ballsInHands = userInput.userBallInHand();
    antycheat();
  }

  public int getBallsInStack() {
    return ballsInStack;
  }

  public void setBallsInStack(int ballsInStack) {
    this.ballsInStack = ballsInStack;
  }

  public boolean isGuessIsPairedOrNot() {
    return guessIsPairedOrNot;

  }

  public void setGuessIsPairedOrNot() {
  System.out.println("zgadnij czy przeciwnik postawił parzysta liczbe kulek \n parzysta  - kilknij P, nieparzysta - reszta przyciskow");
   String guess = scanner.nextLine();
  if (guess.equalsIgnoreCase("p")){this.guessIsPairedOrNot = false;}
  this.guessIsPairedOrNot = true;

  }

  private void antycheat() {
    while (ballsInHands > ballsInStack) {
      System.out.println("Nie mozesz postawic wiecej kulek niz masz!!!!!");
      System.out.println("Pozostalo Ci " + ballsInStack + " kulek");
      this.ballsInHands = userInput.userBallInHand();
    }

  }

    public String getName() {
        return name;
    }
}

