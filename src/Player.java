abstract class Player {
    private int power;
    public int getPower(){ return power; }
    public void setPower(int num){
        power = num;
    }

    private int descendCost;
    public int getDescendCost(){ return descendCost; }

    private int fastDescendCost;
    public int getFastDescendCost(){ return fastDescendCost; }

    private int ultimateCost;
    public int getUltimateCost(){ return ultimateCost;}

    public Player(int newPower, int descendCost, int fastDescent, int ultimateCost){
        this.power = newPower;
        this.descendCost = descendCost;
        this.fastDescendCost = fastDescent;
        this.ultimateCost = ultimateCost;
    }
    public abstract void rest();
    public abstract void descend();
    public abstract void fastDescend();
    public abstract void ultimate();
    public abstract void showStats();
//////////////////////////////////////////////////////////////



}
