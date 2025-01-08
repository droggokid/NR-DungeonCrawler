package nr.dungeoncrawler.services;

import java.util.Scanner;

import nr.dungeoncrawler.entities.Monster;
import nr.dungeoncrawler.entities.Player;
import nr.dungeoncrawler.interfaces.Item;
import nr.dungeoncrawler.utils.Dice;;

public class BattleService {
    Monster enemy;
    Player player;
    CommunicationService communicationService;
    public BattleService() {
    }

    public void battle(){ // should maybe be boolean? to return if player won or not

        communicationService.displayEncounterMonster(enemy);
        communicationService.displayPlayerActingFirstText();
        System.out.println();
        if(isPlayerActingFirst()){
            System.out.println("You act first!");
            String input = communicationService.displayBattleChoicesAndReturnInput();
            actOnBattleInput(input);
        }
        else{
            System.out.println("Monster attacks first!");
            System.out.println("Health before attack: " + player.getHealth());
            System.out.println("You lose " + enemy.getDamage() + " health!");
            player.setHealth(player.getHealth() - enemy.getDamage());
            System.out.println("Health after attack: " + player.getHealth());
            enemy.attack(player);
        }
        // need CommunicationService to handle text flow of the game

    }

    private void endBattleWon(){
        System.out.println("You killed the monster!");
        for(Item item : enemy.getMonsterDrops()){
            System.out.println("You found a " + item.getName());
            System.out.println("Add " + item.getName() + " to inventory?");
            System.out.println("yes/no?");
            // need CommunicationService to handle text flow of the game
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            ValidationService validationService = new ValidationService(scanner);
            input = validationService.validateYesNoInput(input);
            if(input.equals("yes")){
                player.getInventory().add(item);
            }
        }
    }

    public void setEnemy(Monster enemy){
        this.enemy = enemy;
    }
    public Monster getEnemy(){
        return enemy;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }
    private boolean isPlayerActingFirst(){
        Dice dice = new Dice();
        return dice.rollDice() > 3;
    }

    public void setCommunicationService(CommunicationService communicationService){
        this.communicationService = communicationService;
    }
    public CommunicationService getCommunicationService(){
        return communicationService;
    }
    private void actOnBattleInput(String input){
        if(input.equals("1")){
            player.attack(enemy);
            if(isEnemeyDead()){
                endBattleWon();
            }
        }
        else if(input.equals("2")){
            // open inventory
        }
        else if(input.equals("3")){
            // block next attack
        }
    }
    private boolean isEnemeyDead(){
        return enemy.getHealth() <= 0;
    }

}
