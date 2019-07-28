abstract class Player {
    private String name;
    public String getName(){ return  name; }

    private int currentPower;
    public int getCurrentPower(){ return currentPower; }
    public void setCurrentPower(int num){ currentPower = num; }

    private int maxPower ;
    public int getMaxPower(){ return maxPower; }

    private int descendCost;
    public int getDescendCost(){ return descendCost; }

    private int fastDescendCost;
    public int getFastDescendCost(){ return fastDescendCost; }

    private int ultimateCost;
    public int getUltimateCost(){ return ultimateCost;}

    private int currentLevel;
    public void setCurrentLevel(int level){ currentLevel = level; }
    public int getCurrentLevel(){ return currentLevel; }


    public Player(String playerName, int currentPower, int maxPower, int descendCost, int fastDescent, int ultimateCost, int currentLevel){
        this.name = playerName;
        this.currentPower = currentPower;
        this.maxPower = maxPower;
        this.descendCost = descendCost;
        this.fastDescendCost = fastDescent;
        this.ultimateCost = ultimateCost;
        this.currentLevel = currentLevel;
    }

    //public abstract void rest();
    public void rest(){
        int currentPower = this.getCurrentPower();
        this.setCurrentPower(currentPower+3);
    }
    //public abstract void descend();
    public void descend(){
        int currentPower = this.getCurrentPower();
        this.setCurrentLevel(getCurrentLevel() + 1);
        this.setCurrentPower(currentPower-getDescendCost());
    }
    //public abstract void fastDescend();
    public void fastDescend(){
        int currentPower = this.getCurrentPower();
        this.setCurrentLevel(getCurrentLevel() + 3);
        this.setCurrentPower(currentPower-getFastDescendCost());
    }
    //единственный абстрактный метод, т.к. полиморфизм
    public abstract int ultimate();
    //public abstract void ultimateUse();
    public void ultimateUse(){
        int currentPower = this.getCurrentPower();
        this.setCurrentPower(currentPower-getUltimateCost());
    }
    //public abstract void endOfTheMove();
    public void endOfTheMove(){
        int currentPower = this.getCurrentPower();
        this.setCurrentPower(currentPower + 2);
    }
}
