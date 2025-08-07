import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       int[][] array = {
               {10,20,30},
               {40,50,60},
               {70,80,90}
       };
       for (int i = 0; i < array.length; i++){
           for(int j = 0 ; j < array[i].length; j++){
               System.out.print(array[i][j]+ " "); //add a space between elements
           }
           System.out.println();   //move to the next line after printing a row
       }
    }
}