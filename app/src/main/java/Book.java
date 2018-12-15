/**
 * Created by smallLee on 2018/12/8.
 */

public class Book {
    static Book book = new Book();
    static {
        System.out.println("书的静态代码块");
    }
    {
        System.out.println("书的普通代码块");
//        System.out.println("price = " + price + "amount" + amout);
    }
    Book(){
        System.out.println("书的构造代码块");
        System.out.println("price = " + price + "amount" + amout);
    }

    public static void main(String[] args) {
        function();
    }
    private int price = 110;
    public static  int amout = 200;

    public static void function(){
        System.out.println("书的静态方法");
    }
}
