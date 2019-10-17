package bj.logic;



public class OneGameSet extends GeneralGameLogic {

    int id, idP;
    boolean endThisSet = false;
    boolean beginning=true;
    int playerCount;
    int dealerCount;

    private void updateSet() {
        beginning=false;

/*

 while (endThisSet) {

                if ((dealerCount > playerCount && dealerCount < 22) || playerCount > 21)
                    System.out.println("\nyou lose!\nyour money:" + money);
                else if (dealerCount == playerCount) {
                    money = money + beat / 2;
                    System.out.println("draw!\nyour money:" + money);
                } else {
                    money = money + beat;
                    System.out.println("\nyou win!\nyour money:" + money);
                }

                Scanner whatToDo = new Scanner(System.in);
                System.out.println("\nDo you want to keep playing?\n\nyes->y\t\tno->n");
                char quit = whatToDo.next().charAt(0);

                if (quit == 'n')
                    System.exit(0);
                else if (quit == 'y') {
                    if (money <= 0) {
                        System.out.println("you don't have enough money");
                        System.exit(0);
                    } else {
                        dealersHand.clear();
                        playersHand.clear();
                        playerCount = 0;
                        dealerCount = 0;
                        endThisSet = false;
                    }

                }
            }
        } while (money > 0);
    beginning=true;

        if (move == 'h') {
            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            System.out.print("your hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            if (playerCount > 21) {
                beat = 0;
                endThisSet = true;
            }
        } else if (move == 'd') {
            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            System.out.print("your hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            if (playerCount > 21) {
                beat = 0;
                endThisSet = true;
            }
            beat = beat * 2;

        } else if (move == 's') {
            endThisSet = true;
            while (dealerCount < 16) {
                id = draw(deck);
                dealersHand.add(id);
                dealerCount = countCard(id, dealerCount);
            }

            System.out.print("dealer's hand: ");
            for (Integer i : dealersHand)
                System.out.print(whichCard(i) + "\t");
            System.out.println("\ndealer's count: " + dealerCount);

            System.out.print("\nyour hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            System.out.println("\nyour score: " + playerCount);
            endThisSet = true;
            break;


            do {
            //--------------tira carta do dealer virada para baixo------------------------
            id = draw(deck);
            String dealerCard = whichCard(id);
            dealersHand.add(id);

            dealerCount = countCard(id, 0);
            //----------------------------------------------------------------------------

            id = draw(deck);
            dealersHand.add(id);
               System.out.println("\nyour beat: " + beat);


            System.out.print("\ndealer's hand: X\t" + whichCard(id) + "\t");
            dealerCount = countCard(id, dealerCount);

            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, 0);
            System.out.print("\tyour hand: ");

            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");



    }*/
}
}
