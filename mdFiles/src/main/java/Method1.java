import java.util.ArrayList;
import java.util.Arrays;

public class Method1 {
    public static double[] methodOne(double[] nums, double value) {
        double[] nums2 = new double[nums.length + 1];
        nums2[0] = value;
        for (int i = 0; i < nums.length; i++) {
            nums2[i + 1] = nums[i];
        }
        return nums2;
    }

    public static void main(String[] args) {
        double[] nums = {1, 2, 3, 4,};
        System.out.println(Arrays.toString(methodOne(nums, 10)));

        ArrayList<Double> numbers1 = new ArrayList<>();
        numbers1.add(8.0);
        numbers1.add(9.0);
        numbers1.add(-1.0);
        numbers1.add(-2.0);

        ArrayList<Double> numbers2 = new ArrayList<>();
        numbers2.add(8.0);
        numbers2.add(9.0);
        numbers2.add(-1.0);
        numbers2.add(-2.0);

        //first convert to array and then toString

        System.out.println(merge(numbers1, numbers2));

    }


    public static ArrayList<Double> merge(ArrayList<Double> nums1, ArrayList<Double> nums2) {
        ArrayList<Double> newArraylist = new ArrayList<>();

        for (int i = 0; i < nums1.size(); i++) {
            if (nums1.get(i) >= 0) {
                newArraylist.add(nums1.get(i));
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            if (nums2.get(i) >= 0) {
                newArraylist.add(nums2.get(i));
            }
        }
        return newArraylist;
    }


}
