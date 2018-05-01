import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Test {
    static int a1, a2, a3, a4;
    static double x, y, z, t;
    static HashMap<ArrayList<Double>, Integer> result;
    private static final double nums[][] = {
            {13.6667,11.75,10,9.5},
            {12,10.75,9,12.5},
            {12.6667, 15.75,12.5,12},
            {7.666666667,9,5,15.5},
            {11,10.25,12.25,6.5},
            {11.3333,10.75,8,10},
            {11,11.5,10,5.5},
            {9.6667,5.75,3.5,1.5},
            {10.6667,4.5,6.25,4},
            {11,11.75,7.5,9.5},
            {9.66667,8.25,8,14.5},
            {4,5.25,9.75,1.5},
            {9.6667,6.5,12,14},
            {6,2.75,4.25,6.5},
            {9.66667,6.75,11.75,3},
            {3,4.75,6.25,10}};
    public static void main(String []args){
        result = new HashMap<>();
        for (a1 = 1; a1 <= 100; a1++){
            for (a2 = 1; a2 <= 100 ;a2++){
                for (a3 = 1; a3 <= 100; a3++){
                    a4 = 100 - a1 - a2 - a3;
                    x = ((double) a1)/100;
                    y = ((double) a2)/100;
                    z = ((double) a3)/100;
                    t = ((double) a4)/100;
                    int result_value = 0;
                    for (int i =0; i < 15; i++){
                        double m1 = x*nums[i][0] + y*nums[i][1] + z*nums[i][2] + t*nums[i][3];
                        double m2 = x*nums[i+1][0] + y*nums[i+1][1] + z*nums[i+1][2] + t*nums[i+1][3];
                        if (m1 - m2 > 0){
                            result_value++;
                        }
                    }
                    ArrayList<Double> arrayList = new ArrayList<>();
                    arrayList.add(x);
                    arrayList.add(y);
                    arrayList.add(z);
                    arrayList.add(t);
                    if (result_value >= 10 && t > 0)
                        result.put(arrayList, result_value);
                }
            }
        }
        System.out.println(result);
        Iterator<HashMap.Entry<ArrayList<Double>, Integer>> it = result.entrySet().iterator();
//        ArrayList<Double> arrayList = new ArrayList<>();
        double max = 0;
        ArrayList<Double> arrayList = new ArrayList<>();
        while (it.hasNext()){
            HashMap.Entry<ArrayList<Double>, Integer> entry = it.next();
            System.out.println("系数取值：" + entry.getKey() + ", 不等式成立数：" + entry.getValue());
            if (entry.getKey().get(0) > max){
                max = entry.getKey().get(0);
                arrayList.clear();
                arrayList = new ArrayList<>(entry.getKey());
            }
//            arrayList.add(entry.getKey().get(0));
        }
//        int flag = 0;
//        double max = arrayList.get(0);
//        for (Double ele:arrayList) {
//            flag++;
//            if (ele > max){
//                max = ele;
//            }
//        }
        System.out.println("最大值："+max + "，序列："+ arrayList);



    }
}
