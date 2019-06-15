public class Game {
    public void startGame(){
        HumanMage humanMage = new HumanMage(30,5,13,15);
        GnomeWarrior gnomeWarrior = new GnomeWarrior(50,5,15,20);

        System.out.println("Game starts!");
        System.out.println("You are a Human Mage");
        System.out.println("You can rest(rest), descend(descend" +
                ", use fast descend(fastDescend) or cast your ultimate(ultimate)");

        humanMage.showStats();
        gnomeWarrior.showStats();
    }
}
