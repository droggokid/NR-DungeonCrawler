package nr.dungeoncrawler.services;

import java.util.List;
import java.util.Scanner;

import nr.dungeoncrawler.enums.InputChoices;
import nr.dungeoncrawler.interfaces.Node;

public class ValidationService {

    Scanner scanner;

    public ValidationService(Scanner scanner) {
        this.scanner = scanner;
    }
    public String validateChooseLevelInput(String input, DungeonService dungeonService) {
        Node[][] level = dungeonService.getLevel();
        int currentDungeonRow = dungeonService.getCurrentPlayerLevel();
        while (true) {
            if (input.length() == 2) {
                try {
                    int levelDigit = Integer.parseInt(input.substring(0, 1));
                    int roomDigit = Integer.parseInt(input.substring(1, 2));

                    if (levelDigit == currentDungeonRow
                            && roomDigit >= 1
                            && roomDigit <= level[currentDungeonRow].length) {
                        return input;
                    }
                } catch (NumberFormatException e) {
                    System.out.printf("Invalid input. Please enter a valid room (e.g. %s1, %s2, %s3...).", currentDungeonRow+"", currentDungeonRow+"", currentDungeonRow+"");
                    input = scanner.nextLine();
                    // Do nothing
                }
            }
            System.out.printf("Invalid input. Please enter a valid room (e.g. %s1, %s2, %s3...).", currentDungeonRow+"", currentDungeonRow+"", currentDungeonRow+"");
            input = scanner.nextLine();
        }
    }

    public String validateChoiceInBattleInput(String input, DungeonService dungeonService) {
        boolean inputValid = false;
        while (!inputValid) {
            if (InputChoices.BATTLE_CHOICES.contains(input)) {
                inputValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
                input = scanner.nextLine();
            }
        }
        return input;
    }

    public String validateYesNoInput(String input) {
        boolean inputValid = false;

        while (!inputValid) {
            if (InputChoices.YES_NO_CHOICES.contains(input.toLowerCase())) {
                inputValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid choice: yes/no/y/n");
                input = scanner.nextLine();
            }
        }
        return input;
    }
}
