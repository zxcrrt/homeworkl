import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;


import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {
        int [][] combinations = new int[8][];
        combinations[0] = new int[]{0,1,2};
        combinations[1] = new int[]{3,4,5};
        combinations[2] = new int[]{6,7,8};
        combinations[3] = new int[]{0,3,6};
        combinations[4] = new int[]{1,4,7};
        combinations[5] = new int[]{2,5,8};
        combinations[6] = new int[]{0,4,8};
        combinations[7] = new int[]{2,4,6};

        char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("добро пожаловать");
        printField(chars);

        boolean isFirstPlayer=true;



        while (!isFieldFull(chars)){
            if (hasWinner(combinations,chars)) {
                System.out.println("we have winner !!!!");
                break;
            }

            if (isFirstPlayer) {
                System.out.println("введите куда вы хотите поставить крестик ");
            } else {
                System.out.println("введите куда вы хотите поставить нолик  ");

            }



            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt() -1;

            if (chars[answer]== 'X' || chars[answer]== '0'){
                System.out.println("уже поставлено :)");
                continue;
            }



            if (isFirstPlayer){ chars[answer] = 'X'; }
            else { chars[answer] = '0';}
            isFirstPlayer=!isFirstPlayer;

            printField(chars);


        }



    }
    public static boolean hasWinner(int[][] combinations,char[] chars ) {
        for (int i = 0; i < combinations.length ; i++) {
            int[] combination = combinations [i];
            boolean zeroIsWinner = zeroIsWinner(combination, chars);
            boolean exIsWinner = exIsWinner (combination,chars);
            if (zeroIsWinner || exIsWinner) {
                return true;

            }
            return false;

            }


            
        }

        
    }
    public static boolean zeroIsWinner (int[] combination, char chars){
        int positionOne = combination[0];
        int positionTwo = combination[1];
        int positionThree = combination[2];
        return chars [positionOne] == '0' && chars [positionTwo] == '0' && chars [positionThree == '0'];
    }
    public static boolean exIsWinner (int[] combination, char chars){
        int positionOne = combination[0];
        int positionTwo = combination[1];
        int positionThree = combination[2];
        return chars [positionOne] == 'X' && chars [positionTwo] == 'X' && chars [positionThree == 'X'];
    }

    public static boolean isFieldFull(char[]chars){

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'X' && chars[i] != '0'){
                return false;
            }
        }
        return true;
        
        
        
    }






    public static void printField(char[] chars) {
        int countFilledRows = 0;
        for (int i = 1; i < 7; i++) {
            if (i % 2 == 0) {
                printFieldRow(countFilledRows, chars);
                countFilledRows = countFilledRows + 3;
            } else {
                printMinusRow();
            }
        }


    }

    public static void printMinusRow(){
        System.out.print("|");
        for (int i = 0; i < 23 ; i++) {
            System.out.print("-");
        }
        System.out.println("|");
    }






   public static void printFieldRow (int countFieldRows,char[] chars) {
       System.out.print("|");
       int countCells = 1 * countFieldRows;
       int countSpaces = 0;
       for(int i = 0;i < 21;i++){
           if (i % 7 ==0 && i !=0  ) {
               System.out.print("|");
               countSpaces = 0;
       }
         if (countSpaces == 3){
             System.out.print(chars[countCells]);
             countSpaces=0;
             countCells++;
         }else {
             System.out.print (" ");
             countSpaces++;}


       }
       System.out.println("|");

   }













}

















