public class GnomeWarrior extends Player{
    //max energy 30
    //fast descend cost 13
    //ultimate cost 15
    //add ultimate description = "Если на уровне ниже есть персонаж,
    //то меняется с ним местами, иначе спускается на один уровень".

    public GnomeWarrior(int InitialPower, int descendCost, int fastDescentCost, int ultimateCost){
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
        int currentPower = this.getPower();
        this.setPower(currentPower-getUltimateCost());
    }
    @Override
    public void showStats(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You're playing as a Gnome Warrior");
        System.out.println("Your maximum power is 50 " + "Your current power is " + getPower());
        System.out.println("Your abilities:");
        System.out.println("Rest: gain 3 power");
        System.out.println("Descend: move one level down");
        System.out.println("Fast descend: move 3 levels down");
        System.out.println("Ultimate: Moves player 1 level lower. Others can't neither outrun him,");
        System.out.println("nor get one the same level with him");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
