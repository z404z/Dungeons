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
        public void rest(){
            int currentPower = this.getCurrentPower();
            this.setCurrentPower(currentPower+3);
        }
        @Override
        public void descend(){
            int currentPower = this.getCurrentPower();
            this.setCurrentLevel(getCurrentLevel() + 1);
            this.setCurrentPower(currentPower-getDescendCost());
        }
        @Override
        public void fastDescend(){
            int currentPower = this.getCurrentPower();
            this.setCurrentLevel(getCurrentLevel() + 3);
            this.setCurrentPower(currentPower-getFastDescendCost());
        }
        @Override
        public int ultimate(){

            return 2;
        }
        @Override
        public void ultimateUse(){
            int currentPower = this.getCurrentPower();
            this.setCurrentPower(currentPower-getUltimateCost());
        }
        @Override
        public void endOfTheMove(){
            int currentPower = this.getCurrentPower();
            this.setCurrentPower(currentPower + 2);
        }
        @Override
        public void showStats(){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("You're playing as a Gnome Warrior");
            System.out.println("Your maximum power is 50 " + "Your current power is " + getCurrentPower());
            System.out.println("Your abilities:");
            System.out.println("Rest: gain 3 power");
            System.out.println("Descend: move one level down");
            System.out.println("Fast descend: move 3 levels down");
            System.out.println("Ultimate: Moves player 1 level lower. Others aren't able to neither outrun him,");
            System.out.println("nor get one the same level with him");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
}
