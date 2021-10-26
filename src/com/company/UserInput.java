package com.company;

import java.util.Scanner;

public class UserInput {
  final Scanner scanner = new Scanner(System.in);

  int userBallInHand() {
    System.out.println("podja liczbe kulek jakie chcesz wlozyc do reki");

    return scanner.nextInt();
  }

}
