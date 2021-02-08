package reflect;

/**
 * Created by hyq on 2021/2/8 10:54.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Employee employee = (Employee) Class.forName("reflect.Employee").newInstance();
            System.out.println(employee);
//            System.out.println(employee.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
