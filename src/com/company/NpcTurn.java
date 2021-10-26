package com.company;

public class NpcTurn implements Turn{
    private int ballsInHands;
    private int ballsInStack;
    private boolean guessIsPairedOrNot;
    private final String name;
    NpcInput npcInput = new NpcInput();

    public NpcTurn(int ballsInStack, String name) {
        this.ballsInStack = ballsInStack;
        this.name = name;
    }

    public int getBallsInHands() {
        return ballsInHands;
    }

    public void setBallsInHands() {
        this.ballsInHands = npcInput.ballsInHand(ballsInStack);
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
        this.guessIsPairedOrNot = npcInput.npcGuess();
    }

    @Override
    public String toString() {
        return "NpcTurn{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}



