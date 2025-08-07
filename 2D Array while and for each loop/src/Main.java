//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] numbers = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        int rows = 0;
        int columns = 0;
        while (rows < numbers.length) {
            columns = 0;
            while (columns < numbers[rows].length) {
                System.out.print(numbers[rows][columns] + " ");  //we add the " " to give space between the numbers in the output
                columns++;
            }
            System.out.println();
            rows++;
        }


        //the for-each loop
        char[][] charData = {
                {'a', 'b', 'c', 'd', 'e'},
                {'g', 'h', 'i', 'j', 'l'}
        };

        for (char[] charRow : charData) {
            for (char c : charRow) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
