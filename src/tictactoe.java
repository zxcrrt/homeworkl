import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;


import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {
        char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("добро пожаловать");
        printField(chars);

        boolean isFirstPlayer=true;



        while (!isFieldFull(chars)){
            System.out.println("введите куда вы хотите поставить крестик");
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
        System.out.println("|");
        for (int i = 0; i < 23 ; i++) {
            System.out.println("-");
        }
        System.out.println("|");
    }






   public static void printFieldRow (int countFieldRows,char[] chars) {
       System.out.println("|");
       int countCells = 1 * countFieldRows;
       int countSpaces = 0;
       for(int i = 0;i < 21;i++){
           if (i % 7 ==0 && i !=0  ) {
               System.out.println("|");
               countSpaces = 0;
       }
         if (countSpaces == 3){
             System.out.println(chars[countCells]);
             countSpaces=0;
             countCells++;
         }else {
             System.out.println(" ");
             countSpaces++;}


       }

   }













}













}



