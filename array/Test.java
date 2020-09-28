/**
 * @Description:
 * @Author: wz
 * @Date: 2020-09-22
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        System.out.println(System.identityHashCode(s.intern()));
    }
}
