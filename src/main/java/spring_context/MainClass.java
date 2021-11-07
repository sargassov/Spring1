package spring_context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainClass {

    private static Scanner scanner;
    private static Cart cart;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("spring_context");

        while (true){
            System.out.print("Запросить корзину - 1\nВыйти - 0: ");
            int press = writeNextInt(0, 1);
            if(press == 0) break;

            cart = ctx.getBean(Cart.class);

            while(press != 0) {

                System.out.print("\nДобавить продукт по ID - 1\nДобавить все продукты - 2\n" +
                        "Удалить продукт по ID - 3\nПосмотреть корзину - 4\nОчистить корзину - 5\nВыйти - 0: ");

                press = writeNextInt(0, 5);

                if (press == 0) break;


                if (press == 1) {
                    System.out.print("\n\nНапишите ID продукта: ");
                    press = writeNextInt(1, 5);
                    cart.addProductById(press);
                } else if (press == 2) {
                    cart.addAllProducts();
                } else if (press == 3) {
                    System.out.print("\n\nНапишите ID продукта: ");
                    press = writeNextInt(1, 5);
                    cart.deleteProductById(press);
                } else if (press == 4) {
                    cart.writeCartContains();
                } else {
                    cart.deleteAllProducts();
                }

                System.out.println("\n\nПродолжить - 1\nСменить пользователя - 0: ");
                press = writeNextInt(0, 1);
            }
        }
    }

    private static int writeNextInt(int min, int max){
        while(true){
            int press = scanner.nextInt();
            if(press < min || press > max){
                System.out.println("\n\nВвод должен быть между " + min + " и " + max + ". Выберите еще раз: ");
            }
            else return press;
        }

    }
}
