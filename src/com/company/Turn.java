package com.company;

public interface Turn {
    public int getBallsInHands();



     void setBallsInHands();
    int getBallsInStack();
     void setBallsInStack(int ballsInStack);

     boolean isGuessIsPairedOrNot();
     String getName();
    void setGuessIsPairedOrNot();}

