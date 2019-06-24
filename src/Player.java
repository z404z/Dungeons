abstract class Player {
    private String name;
    public String getName(){ return  name; }

    private int currentPower;
    public int getCurrentPower(){ return currentPower; }
    public void setCurrentPower(int num){ currentPower = num; }

    private int maxPower ;
    public int getMaxPower(){ return maxPower; }
    //public void setMaxPower(int power){ maxPower = power; }

    private int descendCost;
    public int getDescendCost(){ return descendCost; }

    private int fastDescendCost;
    public int getFastDescendCost(){ return fastDescendCost; }

    private int ultimateCost;
    public int getUltimateCost(){ return ultimateCost;}

    private int currentLevel;
    public void setCurrentLevel(int level){ currentLevel = level; }
    public int getCurrentLevel(){ return currentLevel; }

    private boolean ultimateUsed;
    public void setUltimateUsed(boolean used){ ultimateUsed = used; }
    public boolean getUltimateUsed(){ return ultimateUsed; }

    public Player(String playerName, int currentPower, int maxPower, int descendCost, int fastDescent, int ultimateCost, int currentLevel){
        this.name = playerName;
        this.currentPower = currentPower;
        this.maxPower = maxPower;
        this.descendCost = descendCost;
        this.fastDescendCost = fastDescent;
        this.ultimateCost = ultimateCost;
        this.currentLevel = currentLevel;
    }

    public abstract void rest();
    public abstract void descend();
    public abstract void fastDescend();
    public abstract int ultimate();
    public abstract void ultimateUse();
    public abstract void showStats();
    public abstract void endOfTheMove();
//////////////////////////////////////////////////////////////



}
