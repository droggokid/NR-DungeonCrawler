package nr.dungeoncrawler.services;

import java.util.Scanner;

import nr.dungeoncrawler.entities.Monster;
import nr.dungeoncrawler.entities.Player;
import nr.dungeoncrawler.interfaces.Item;;

public class BattleService {
    Monster enemy;
    Player player;
    public BattleService() {
    }

    public void startBattle(){

        System.out.println("You encounter a monster!");
        System.out.println("GRAGAS THE DRUNKEN");
        System.out.println("MONSTER ATTACKS YOU!");

        enemy.attack(player);
        // need CommunicationService to handle text flow of the game
        System.out.println();
        System.out.println("Health before attack: " + player.getHealth());
        System.out.println("You lose " + enemy.getDamage() + " health!");
        player.setHealth(player.getHealth() - enemy.getDamage());
        System.out.println("Health after attack: " + player.getHealth());
        System.out.println();
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("1. Attack");
        System.out.println("2. Open inventory - NOT IMPLEMENTED");
        System.out.println("3. Block next attack - NOT IMPLEMENTED");

    }

    public void endBattle(){
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

}
