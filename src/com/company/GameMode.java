package com.company;

import java.util.Scanner;

public class GameMode {
    Scanner scanner=  new Scanner(System.in);

    void chooseGameMode(){
        System.out.println("Jeśli chcesz obejrzec pokazowa gre kliknij Y\nJesli chcesz zagrac przecwikwo komputerowi kliknij dowolny klawisz");
        String playersChoice = scanner.nextLine();
        if (playersChoice.equalsIgnoreCase("Y")){
          System.out.println("Wybierz imie bota nr 1");
            String nameBotOne = scanner.nextLine();
            System.out.println("Wybierz imie bota nr 2");
            String nameBotTwo = scanner.nextLine();
            Game game = new Game(new NpcTurn(20, nameBotOne),new NpcTurn(20, nameBotTwo) );
            game.startGame();
        }
        else{
            System.out.println("Wpisz Swoje imie");
            String nameBotOne = scanner.nextLine();
            System.out.println("Wpisz imie bota");
            String nameBotTwo = scanner.nextLine();
            Game game = new Game(new PlayerTurn(20, nameBotOne),new NpcTurn(20, nameBotTwo) );
            game.startGame();

        }
    }


}
