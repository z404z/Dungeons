public class HumanMage extends Player{
    //max energy 30
    //fast descend cost 13
    //ultimate cost 15
    //add ultimate description = "Если на уровне ниже есть персонаж,
    //то меняется с ним местами, иначе спускается на один уровень".

    public HumanMage(int InitialPower, int descendCost, int fastDescentCost, int ultimateCost){
        super(InitialPower, descendCost, fastDescentCost,ultimateCost);
        System.out.println("Energy = " + this.getPower());
        System.out.println("Fast Descend Cost = " + this.getFastDescendCost());
        System.out.println("Energy = " + this.getUltimateCost());
    }

    @Override
    public void rest(){
        int currentPower = this.getPower();
        this.setPower(currentPower+3);
        System.out.println("resting... current power is: " + getPower());
    }
    @Override
    public void descend(){
        int currentPower = this.getPower();
        this.setPower(currentPower-getDescendCost());
    }
    @Override
    public void fastDescend(){
        int currentPower = this.getPower();
        this.setPower(currentPower-getFastDescendCost());
    }
    @Override
    public void ultimate(){

    }
    @Override
    public void showStats(){
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("You're playing as a Human Mage");
        System.out.println("Your maximum power is 30 " + "Your current power is " + getPower());
        System.out.println("Your abilities:");
        System.out.println("Rest: gain 3 power");
        System.out.println("Descend: move one level down");
        System.out.println("Fast descend: move 3 levels down");
        System.out.println("Ultimate: Switch places with the player one level lower if there is one");
        System.out.println("otherwise moves 1 level down");
        System.out.println("~~~~~~~~~~~~~~");
    }
}
