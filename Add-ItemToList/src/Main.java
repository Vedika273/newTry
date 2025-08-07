import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
   ArrayList <Double> expenses = new ArrayList<>();
   expenses.add(74.46);
   expenses.add(63.99);
   expenses.add(10.57);
   expenses.add(81.73);

   double total =0;

   //illiterate over expenses
        for (int i =0; i < expenses.size(); i++){
            total += expenses.get(i);
        }
        System.out.println(total);
    }
}