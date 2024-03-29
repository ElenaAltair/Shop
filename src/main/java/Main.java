import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ListGoods listGoods = null;
        try {
            listGoods = new ListGoods()
                    .addGoods(new Furniture("кровать", 100, "rrr"))
                    .addGoods(new Furniture("диван", 120, "www"))
                    .addGoods(new Furniture("кресло", 50, "rrr"))
                    .addGoods(new FoodProducts("молоко", 34, "aaa", "10.2024"))
                    .addGoods(new FoodProducts("хлеб", 10, "ppp", "06.2024"));
        } catch (Exception e) {
            System.out.println("Некорректные данные!");
        }
        if (listGoods != null) {

            // Два заказа ниже созданы для теста рейтинга товаров
            // Для общей логики они не нужны
            Basket basket1 = new Basket()
                    .addGoods(ListGoods.getGoods(2))
                    .addGoods(ListGoods.getGoods(3))
                    .addGoods(ListGoods.getGoods(2))
                    .addGoods(ListGoods.getGoods(2));
            Order order1 = new Order("Вася", "Петров", basket1, "");
            Basket basket2 = new Basket()
                    .addGoods(ListGoods.getGoods(4))
                    .addGoods(ListGoods.getGoods(5))
                    .addGoods(ListGoods.getGoods(4))
                    .addGoods(ListGoods.getGoods(4))
                    .addGoods(ListGoods.getGoods(4))
                    .addGoods(ListGoods.getGoods(2));
            Order order2 = new Order("Вася", "Петров", basket2, "");


            Basket basket = new Basket();
            boolean isTrue = true;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Список команд: ");
            ListCommands.showListCommands();
            while (isTrue) {

                System.out.println("Введите номер команды или end: ");
                String numComm = scanner.nextLine();
                switch (numComm) {
                    case "end", "100" -> isTrue = false;
                    case "10" -> {
                        System.out.println("Введите id товара: ");
                        numComm = scanner.nextLine();
                        try {
                            int id = Integer.parseInt(numComm);
                            basket.addGoods(ListGoods.getGoods(id));
                            System.out.println("Товар был добавлен в корзину!");
                            basket.printListBasket();
                        } catch (Exception e) {
                            System.out.println("Вы ввели не число!");
                        }
                    }
                    case "11" -> basket.printListBasket();
                    case "12" -> {
                        System.out.println("Введите id товара, который хотите удалить: ");
                        numComm = scanner.nextLine();
                        try {
                            int id = Integer.parseInt(numComm);
                            int i = basket.removeGoods(id);
                            if (i == 1) System.out.println("Товар был удалён из корзины!");
                            basket.printListBasket();
                        } catch (Exception e) {
                            System.out.println("Вы ввели не число!");
                        }
                    }
                    case "13" -> {
                        System.out.println("Введите ваше имя:");
                        String name = scanner.nextLine();
                        System.out.println("Введите вашу фамилию:");
                        String lastname = scanner.nextLine();
                        System.out.println("Введите телефон:");
                        String phone = scanner.nextLine();
                        Order order = new Order(name, lastname, basket, phone);
                        System.out.println("Заказ оформлен и принят на обработку!");
                        System.out.println(order);
                        order.basket.printListBasket();
                    }
                    default -> ListCommands.executeCommand(numComm);
                }
                System.out.println();
                if (isTrue) {
                    System.out.println("Показать список команд? (y/n): ");
                    numComm = scanner.nextLine();
                    if (numComm.equalsIgnoreCase("y") || numComm.equalsIgnoreCase("н")) {
                        System.out.println("Список команд: ");
                        ListCommands.showListCommands();
                    }
                    System.out.println();
                }
            }
            System.out.println("Программа завершена. До свидания!");

        }
    }
}
