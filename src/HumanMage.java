public class HumanMage extends Player{
    //max energy 30
    //fast descend cost 13
    //ultimate cost 15
    //add ultimate description = "Если на уровне ниже есть персонаж,
    //то меняется с ним местами, иначе спускается на один уровень".

    public HumanMage(String playerName, int InitialPower, int maxPower, int descendCost, int fastDescentCost, int ultimateCost, int currentLevel){
        super(playerName, InitialPower, maxPower, descendCost, fastDescentCost, ultimateCost, currentLevel);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(this.getName() + " has picked Human Mage!");
            System.out.println("Human Mage has following characteristics: ");
            System.out.println("Energy = " + this.getCurrentPower());
            System.out.println("Fast Descend Cost = " + this.getFastDescendCost());
            System.out.println("Ultimate Cost = " + this.getUltimateCost());
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

            return 1;
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
            System.out.println("~~~~~~~~~~~~~~");
            System.out.println("You're playing as a Human Mage");
            System.out.println("Your maximum power is 30 " + "Your current power is " + getCurrentPower());
            System.out.println("Your abilities:");
            System.out.println("Rest: gain 3 power");
            System.out.println("Descend: move one level down");
            System.out.println("Fast descend: move 3 levels down");
            System.out.println("Ultimate: Switch places with the player one level lower if there is one");
            System.out.println("otherwise moves 1 level down");
            System.out.println("~~~~~~~~~~~~~~");
        }
}
