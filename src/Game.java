import java.util.*;
import java.util.Random;

public class Game {
    Scanner scannerPlayerOne = new Scanner(System.in);
    Scanner scannerPlayerTwo = new Scanner(System.in);
    Scanner action = new Scanner(System.in);

    boolean gameFinished = false;

    private String playerOneName;
    void setPlayerOneName(String name) {
        playerOneName = name;
    }
    String getPlayerOneName(){ return playerOneName; }

    private String playerTwoName;
    void setPlayerTwoName(String name) { playerTwoName = name; }
    String getPlayerTwoName(){ return playerTwoName; }

    private String classPlayerOne;
    void setClassPlayerOne(String input){ classPlayerOne = input; }
    String getClassPlayerOne(){ return classPlayerOne; }

    private String classPlayerTwo;
    void setClassPlayerTwo(String input){ classPlayerTwo = input; }
    String getClassPlayerTwo(){ return classPlayerTwo; }

    private String currentMove;
    void setCurrentMove(String move){ currentMove = move; }
    String getCurrentMove(){ return currentMove; }

    List<Player> playersBeforeTheStart = new ArrayList<Player>();//Before random choice of player on the start
    List<Player> players = new ArrayList<Player>();              //After random choice of player on the start
    List<Player> playersCopy = new ArrayList<Player>();
    String[] classes = {"1) Human-Mage", "2) Dwarf-Warrior", "3) Elf-Scout"};
    ArrayList<Boolean> dwarfUltimates = new ArrayList<Boolean>();

    ///методы, вызываемые из startGame()
    void selectClass(){
        //Проверяю ввод, вызываю отдельные методы для создания объектов классов
        System.out.println("Player one choose your name: ");
            setPlayerOneName(scannerPlayerOne.nextLine());                  //name for player 1
        System.out.println("Player one choose your class!");
        System.out.println("Available classes:");
        System.out.println(Arrays.toString(classes));
        System.out.println("Choose your class (1-3): ");
            checkInputPlayerOne();
        System.out.println("Player two choose your name: ");
            setPlayerTwoName(scannerPlayerTwo.nextLine());                  //name for player 2
        System.out.println("Player two choose your class!");
        System.out.println("Available classes:");
        System.out.println(Arrays.toString(classes));
        System.out.println("Choose your class (1-3): ");
        checkInputPlayerTwo();
    }

    void checkInputPlayerOne(){
        //ожидаем ввода числа 1-3, иначе повторяем
        //создаем объекты классов
        //персонализируем объекты именами игроков
        setClassPlayerOne(scannerPlayerOne.nextLine());

        while (getClassPlayerOne().equals("1") | getClassPlayerOne().equals("2") | getClassPlayerOne().equals("3")) {
            if (getClassPlayerOne().equals("1")) {
                if (!classes[0].equals("taken")){
                    classes[0] = "taken";
                    HumanMage playerOne = new HumanMage(getPlayerOneName(), 30, 30, 5, 13, 15, 1);
                    playersBeforeTheStart.add(playerOne);
                    break;
                }
                else{
                    System.out.println("Human Mage is taken. Choose another class.");
                    checkInputPlayerOne();
                }
            }
            if (getClassPlayerOne().equals("2")) {
                if (!classes[1].equals("taken")){
                    classes[1] = "taken";
                    DwarfWarrior playerOne = new DwarfWarrior(getPlayerOneName(), 50, 50, 5, 15, 20, 1);
                    playersBeforeTheStart.add(playerOne);
                    break;
                }
                else{
                    System.out.println("Dwarf Warrior is taken. Choose another class.");
                    checkInputPlayerOne();
                }
            }
            if (getClassPlayerOne().equals("3")) {
                if (!classes[2].equals("taken")){
                    classes[2] = "taken";
                    ElfScout playerOne = new ElfScout(getPlayerOneName(), 40, 40, 5, 12, 24, 1);
                    playersBeforeTheStart.add(playerOne);
                    break;
                }
                else{
                    System.out.println("Elf Scout is taken. Choose another class.");
                    checkInputPlayerOne();
                }
            }
        }
        if (!getClassPlayerOne().equals("1") & !getClassPlayerOne().equals("2") & !getClassPlayerOne().equals("3")) {
            System.out.println("Wrong input.");
            System.out.println("Choose your class (1-3): ");
            checkInputPlayerOne();
        }
        scannerPlayerOne.reset();
    }//input check for p1 class

    void checkInputPlayerTwo() {
        //ожидаем ввода числа 1-3, иначе повторяем
        //создаем объекты классов
        //персонализируем объекты именами игроков
        setClassPlayerTwo(scannerPlayerTwo.next());

        while (getClassPlayerTwo().equals("1") | getClassPlayerTwo().equals("2") | getClassPlayerTwo().equals("3")) {
            if (getClassPlayerTwo().equals("1")) {
                if (!classes[0].equals("taken")) {
                    classes[0] = "taken";
                    HumanMage playerTwo = new HumanMage(getPlayerTwoName(), 30, 30, 5, 13, 15, 1);
                    playersBeforeTheStart.add(playerTwo);
                } else {
                    System.out.println("Human Mage is taken. Choose another class.");
                    checkInputPlayerTwo();
                }
                break;
            }

            if (getClassPlayerTwo().equals("2")) {
                if (!classes[1].equals("taken")) {
                    classes[1] = "taken";
                    DwarfWarrior playerTwo = new DwarfWarrior(getPlayerTwoName(), 50, 50, 5, 15, 20, 1);
                    playersBeforeTheStart.add(playerTwo);
                } else {
                    System.out.println("Dwarf Warrior is taken. Choose another class.");
                    checkInputPlayerTwo();
                }
                break;
            }
            if (getClassPlayerTwo().equals("3")) {
                if (!classes[2].equals("taken")) {
                    classes[2] = "taken";
                    ElfScout playerTwo = new ElfScout(getPlayerTwoName(), 40, 40, 5, 12, 24, 1);
                    playersBeforeTheStart.add(playerTwo);
                } else {
                    System.out.println("Elf Scout is taken. Choose another class.");
                    checkInputPlayerTwo();
                }
                break;
            }
        } if (!getClassPlayerTwo().equals("1") & !getClassPlayerTwo().equals("2") & !getClassPlayerTwo().equals("3")){
            System.out.println("Wrong input.");
            System.out.println("Choose your class (1-3): ");
            checkInputPlayerTwo();
        }
        scannerPlayerTwo.reset();
    }//input check for p2 class

    public void startGame(){
        //выбираем класс, формируем массив,
        // где первым игроком будет объект,
        // выбранный случайно
        // делаем ходы, пока игра не закончится
        System.out.println("######################################################################");
        System.out.println("You're playing Dungeons!");
        System.out.println("######################################################################");
            selectClass();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Game begins!");
        //Choosing random player
        Random random = new Random();
        int randomNum = random.nextInt(2);
        //в список игроков добавляем согласно случайному числу первого игрока
        players.add(playersBeforeTheStart.get(randomNum));
        if (randomNum == 1){
            players.add(playersBeforeTheStart.get(0));
        }
        else {
            players.add(playersBeforeTheStart.get(1));
        }
        System.out.println(players.get(0).getName() + " is the first to make a move!");
        while (!gameFinished){
            move();
        }

    }//Main method

    void action(Player player, Player otherPlayer){
        //Приветствие и описание способностей
        //Контроль за ультой Дворфа.
        //Для этого создан лист. Каждый каст ульты добавляет в него элемент bool.
        //Каждый последующий ход(ход соперника Дворфа) удаляет элемент из списка.
        //При достижении >= 20 уровня, вызывается функция конца игры,
        //В нее передается объект, сделавший финальный ход.
        //Если Дворф догнал другого игрока,
        //Тот не сможет двигаться 1 ход.(провоцирует использование Rest ability)
        //В условии не описан подобный прецедент
        //Его можно было бы решить возвратом соперника Дворфа на этаж выше и запретом движения.
        //Но Дворф не разбойник, а воин.
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!New Move!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(player.getName() + ", your current stamina is: " + player.getCurrentPower() + "!");
        System.out.println("You're on " + player.getCurrentLevel() + " level!");
        System.out.println("Use your ability! Use numbers to perform input(1-4)");
        System.out.println("Available abilities: 1)Rest[+3 stamina], 2)Fast Descend[-" + player.getFastDescendCost() +
                " stamina]");
        System.out.println("3)Descend[-5 stamina], 4)Ultimate[-" + player.getUltimateCost() + " stamina]");

        setCurrentMove(action.nextLine());

        while (currentMove.equals("1") | currentMove.equals("2") | currentMove.equals("3") | currentMove.equals("4")){
            if (currentMove.equals("1")){//1 = rest
                player.rest();                                                      //power + 3 /// checking if higher than maxPower
                if(player.getCurrentPower() >= player.getMaxPower()){
                    player.setCurrentPower(player.getMaxPower());
                    System.out.println(player.getName() + " used Rest ability and his current power " +
                            "is back at maximum: " + player.getCurrentPower());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    if(!dwarfUltimates.isEmpty()){//каждый ход мы убираем из списка одно использование ульты
                        dwarfUltimates.remove(0);
                    }
                    break;
                }
                else {
                    player.endOfTheMove();
                    System.out.println(player.getName() + " used Rest ability.");
                    System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    if(!dwarfUltimates.isEmpty()){
                        dwarfUltimates.remove(0);
                    }
                    if(player.getCurrentPower() > player.getMaxPower()){
                        player.setCurrentPower(player.getMaxPower());
                    }
                    break;
                }

            }

            if (currentMove.equals("2")){
                if(player.getCurrentPower() < player.getFastDescendCost()) {
                    System.out.println("Not enough stamina. Choose other ability.");
                    action(player, otherPlayer);
                    break;
                }
                else {
                    if(player.getCurrentPower() >= player.getFastDescendCost() & dwarfUltimates.isEmpty()){
                        player.fastDescend();
                        System.out.println(player.getName() + " used Fast Descend ability.");
                        System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + "; stamina: " + player.getCurrentPower());
                        System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        player.endOfTheMove();
                        if (player.getCurrentLevel() >= 20){
                            System.out.println("You're on a level " + player.getCurrentLevel() + "!");
                            finishGame(player);
                            gameFinished = true;
                            break;
                        }
                    }

                    if(player.getCurrentPower() >= player.getFastDescendCost() & !dwarfUltimates.isEmpty()){
                        if((player.getCurrentLevel() + 3) >= otherPlayer.getCurrentLevel()){
                            System.out.println("You can't be further or on the same level with dwarf for 1 move");
                            System.out.println("Choose other ability.");
                            action(player, otherPlayer);
                            break;
                        }
                        else {
                            System.out.println(player.getName() + " used Fast Descend ability.");
                            System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                            System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            dwarfUltimates.remove(0);
                            break;
                        }
                    }
                    break;
                }

            }

            if (currentMove.equals("3")){
                if(player.getCurrentPower() < player.getDescendCost()) {
                    System.out.println("Not enough stamina. Choose other ability.");
                    action(player, otherPlayer);
                    break;
                }
                else{
                    if(player.getCurrentPower() >= player.getDescendCost() & dwarfUltimates.isEmpty()){
                        player.descend();
                        System.out.println(player.getName() + " used Descend ability.");
                        System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                        System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        player.endOfTheMove();
                        if (player.getCurrentLevel() >= 20){
                            System.out.println("You're on a level " + player.getCurrentLevel() + "!");
                            finishGame(player);
                            gameFinished = true;
                            break;
                        }
                    }

                    if(player.getCurrentPower() >= player.getDescendCost() & !dwarfUltimates.isEmpty()){
                        if((player.getCurrentLevel() + 1) >= otherPlayer.getCurrentLevel()){
                            System.out.println("You can't be further or on the same level with dwarf for 1 move");
                            System.out.println("Choose other ability.");
                            action(player, otherPlayer);
                            break;
                        }
                        else {
                            player.descend();
                            System.out.println(player.getName() + " used Descend ability.");
                            System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                            System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            dwarfUltimates.remove(0);
                            break;//пробую
                        }
                        //break;оставить или убрать
                    }
                    break;
                }

            }

            if(currentMove.equals("4")){
                if(player.ultimate() == 1){
                    System.out.println(player.getName() + " used Ultimate ability.");
                    if(player.getCurrentPower() < player.getUltimateCost()) {
                        System.out.println("Not enough stamina. Choose other ability.");
                        action(player, otherPlayer);
                        break;
                    }
                    else{
                        if(dwarfUltimates.isEmpty()){//если дворф не ультовал, меняемся со следующим игроком
                            if(otherPlayer.getCurrentLevel() - player.getCurrentLevel() == 1){
                                player.ultimateUse();                                   //тратим энергию
                                int playerLevel = player.getCurrentLevel();             //уровень игрока до замены
                                player.setCurrentLevel(otherPlayer.getCurrentLevel());  //уровень игрока после замены
                                otherPlayer.setCurrentLevel(playerLevel);               //уровень другого игрока = уровень игрока
                                System.out.println("Since there was other player below the " + player.getName() + ",");
                                System.out.println(player.getName() + " swaps places.");
                                player.endOfTheMove();
                                System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                                System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                break;
                            }
                            else {//если игрок на финальном уровне - завершаем
                                player.ultimateUse();
                                player.setCurrentLevel(player.getCurrentLevel()+1);
                                if(player.getCurrentLevel() >= 20){
                                    finishGame(player);
                                    break;
                                }
                                else {//или продолжаем
                                    System.out.println("Since there was nobody below the " + player.getName() + ",");
                                    System.out.println(player.getName() + " moves one level further.");
                                    System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                                    player.endOfTheMove();
                                    System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    break;
                                }
                            }
                        }
                        else {
                            if (otherPlayer.getCurrentLevel() - player.getCurrentLevel() > 1){
                                player.ultimateUse();
                                player.setCurrentLevel(player.getCurrentLevel()+1);
                                System.out.println("Since there was nobody below the " + player.getName() + ",");
                                System.out.println(player.getName() + " moves one level further.");
                                System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                                player.endOfTheMove();
                                System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                break;
                            }
                            else {
                                System.out.println("You can't be further or on the same level with dwarf for 1 move");
                                System.out.println("Choose other ability.");
                                action(player, otherPlayer);
                                break;
                            }
                        }
                    }
                }
                if(player.ultimate() == 2){
                    System.out.println(player.getName() + " used Ultimate ability.");
                    if(player.getCurrentPower() < player.getUltimateCost()) {
                        System.out.println("Not enough stamina. Choose other ability.");
                        action(player, otherPlayer);
                        break;
                    }
                    else {
                        player.ultimateUse();
                        boolean dwarfUltimate = true;
                        dwarfUltimates.add(dwarfUltimate);
                        player.setCurrentLevel(player.getCurrentLevel()+1);
                        if(player.getCurrentLevel() >= 20){
                            finishGame(player);
                            break;
                        }
                        else {
                            System.out.println(player.getName() + " moves one level further.");
                            System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                            player.endOfTheMove();
                            System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            break;
                        }
                    }
                }
                if(player.ultimate() == 3){
                    System.out.println(player.getName() + " used Ultimate ability.");
                    if(player.getCurrentPower() < player.getUltimateCost()) {
                        System.out.println("Not enough stamina. Choose other ability.");
                        action(player, otherPlayer);
                        break;
                    }
                    else {
                        if(dwarfUltimates.isEmpty()){
                            player.ultimateUse();
                            player.setCurrentLevel(player.getCurrentLevel()+3);
                            if(player.getCurrentLevel() >= 20){
                                finishGame(player);
                                break;
                            }
                            else {
                                player.endOfTheMove();
                                System.out.println(player.getName() + " moves 3 level further.");
                                System.out.println(player.getName() + "'s current level is: " + player.getCurrentLevel() + " and stamina: " + player.getCurrentPower());
                                System.out.println("End of the move. " + player.getName() + " regains 2 stamina points");
                                break;
                            }
                        }
                        else {
                            System.out.println("You can't be further or on the same level with dwarf for 1 move");
                            System.out.println("Choose other ability.");
                            action(player, otherPlayer);
                            break;
                        }
                    }
                }
            }
        }
        //coz while-else is impossible in java
        if(!getCurrentMove().equals("1") & !getCurrentMove().equals("2") & !getCurrentMove().equals("3")& !getCurrentMove().equals("4")){
            System.out.println("Wrong ability input. Please, repeat.");
            action(player, otherPlayer);
        }
    }//метод, вызываемый из move()

    void move(){
        if (!gameFinished){
            for (Player player : players){          //выбираем игроков поочереди
                if(!gameFinished){
                    playersCopy.addAll(players);    //Передам два объекта методу action для реализации ульты
                    playersCopy.remove(player);     //Сначала копирую список и удаляю из него текущий,
                    Player otherPlayer = playersCopy.get(0);//а после выну из копии другой объект
                    action(player, otherPlayer);    //выбираем игрока и ждем, пока он успешно осуществит действие
                }
            }
        }
    }

    void finishGame(Player player){
        gameFinished = true;
        System.out.println("Game over!");
        System.out.println("The winner is: " + player.getName() + " !");
    }
}
