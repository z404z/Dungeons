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
        //не вижу смысла переопределять методы абстрактного родителя, т.к. они все делают одно и то же.
        @Override
        public int ultimate(){
            return 1;
        }
}
