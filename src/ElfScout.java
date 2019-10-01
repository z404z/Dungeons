public class ElfScout extends Player{
        //max energy 40
        //fast descend cost 12
        //ultimate cost 24
        //add ultimate description = Спускается на 3 уровня ниже


    public ElfScout(String playerName, int InitialPower, int maxPower, int descendCost, int fastDescentCost, int ultimateCost, int currentLevel){
        super(playerName, InitialPower, maxPower, descendCost, fastDescentCost,ultimateCost, currentLevel);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(playerName + " has picked Elf Scout!");
            System.out.println("Elf Scout has following characteristics: ");
            System.out.println("Energy = " + this.getCurrentPower());
            System.out.println("Fast Descend Cost = " + this.getFastDescendCost());
            System.out.println("Energy = " + this.getUltimateCost());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        @Override
        public int ultimate(){
            return 3;
        }

    }

