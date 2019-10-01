public class DwarfWarrior extends Player{
    //max energy 50
    //fast descend cost 15
    //ultimate cost 20
    //add ultimate description = Перемещает персонажа на уровень ниже.
    //До следующего хода никакой персонаж не может ни обогнать его, ни оказаться на одном этаже с ним

    public DwarfWarrior(String playerName, int InitialPower, int maxPower, int descendCost, int fastDescentCost, int ultimateCost, int currentLevel){
        super(playerName, InitialPower, maxPower, descendCost, fastDescentCost,ultimateCost, currentLevel);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(playerName + " has picked Dwarf Warrior!");
            System.out.println("Dwarf Warrior has following characteristics: ");
            System.out.println("Maximum stamina = " + this.getCurrentPower());
            System.out.println("Fast Descend Cost = " + this.getFastDescendCost());
            System.out.println("Ulitmate Cost = " + this.getUltimateCost());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

        @Override
        public int ultimate(){
            return 2;
        }

}
