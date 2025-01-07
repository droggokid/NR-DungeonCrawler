package nr.dungeoncrawler.services;

import java.util.Scanner;

public class CommunicationService {
    private Scanner scanner;
    private String input;
    ValidationService validationService;

    public CommunicationService(){
        scanner = new Scanner(System.in);
        validationService = new ValidationService(scanner);
    }
    public Scanner getScanner(){
        return scanner;
    }
    public String getInput(){
        return input;
    }
    public void setInput(String input){
        this.input = input;
    }
    public void displayPlayerActingFirstText(){
        System.out.println("Rolling dice to see who acts first...");
        System.out.println("1-3 Player acts first, 4-6 Monster acts first");
        System.out.println("Rolling dice...");
    }
    public String displayBattleChoicesAndReturnInput(){
        System.out.println("What do you want to do?");
        System.out.println("1. Attack");
        System.out.println("2. Open inventory - NOT IMPLEMENTED");
        System.out.println("3. Block next attack - NOT IMPLEMENTED");
        String input = scanner.nextLine();
        input = validationService.validateChoiceInBattleInput(input);
        return input;
    }


}
