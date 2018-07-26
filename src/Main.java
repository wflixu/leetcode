
public class Main {

    public static void main(String[] args) {
        Base1 base1 = new Base1();
        int [] arr=  {2, 7, 11, 15};
        int target=18;
        int[] res= base1.twoSum(arr,target);
        System.out.println("第一个结果："+res[0]);
        System.out.println("第二个结果："+res[1]);
    }
}
