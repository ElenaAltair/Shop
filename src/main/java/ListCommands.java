
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCommands {


    protected static List<String> listCommands = Stream.of(
                    "1. Вывести список доступных товаров",
                    "2. Вывести список категорий товаров",
                    "3. Вывести список товаров из определённой категории",
                    "4. Вывести список товаров по цене ниже выбранной",
                    "5. Вывести список товаров по цене выше выбранной",
                    "6. Вывести список товаров по цене равной выбранной",
                    "7. Вывести список товаров по определённому названию",
                    "8. Вывести список товаров определённого производителя",
                    "9. Вывести список товаров отсортированный по рейтингу от большего к меньшему",
                    "10. Добавить товар в корзину",
                    "11. Показать товары в корзине",
                    "12. Удалить товар из корзины",
                    "13. Оформить заказ",
                    "100. Завершить программу"
            )
            .collect(Collectors.toList());

    public static void showListCommands() {
        for (String command : listCommands) {
            System.out.println(command);
        }
    }

    public static void executeCommand(String index) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        switch (index) {
            case "1":
                ListGoods.printList("Список доступных товаров", ListGoods.getListGoods());
                break;
            case "2":
                Set<String> categories = GoodsCategories.getCategories();
                System.out.println("Категории товаров:");
                for (String category : categories) {
                    System.out.println(category);
                }
                break;
            case "3":
                System.out.println("Введите название категории товара: ");
                str = scanner.nextLine();
                ListGoods.printList("Список товаров из категории " + str, ListGoods.getNeedCategory(str));
                break;
            case "4":
                System.out.println("Укажите максимальную цену: ");
                str = scanner.nextLine();
                try {
                    int price = Integer.parseInt(str);
                    ListGoods.printList("Список товаров по цене ниже " + price, ListGoods.getPriceLessThan(price));
                } catch (Exception e) {
                    System.out.println("Вы ввели не число или некорректное число!");
                }
                break;
            case "5":
                System.out.println("Укажите минимальную цену: ");
                str = scanner.nextLine();
                try {
                    int price = Integer.parseInt(str);
                    ListGoods.printList("Список товаров по цене выше " + price, ListGoods.getPriceMoreThan(price));
                } catch (Exception e) {
                    System.out.println("Вы ввели не число или некорректное число!");
                }
                break;
            case "6":
                System.out.println("Укажите цену: ");
                str = scanner.nextLine();
                try {
                    int price = Integer.parseInt(str);
                    ListGoods.printList("Список товаров с ценой = " + price, ListGoods.getPriceEqual(price));
                } catch (Exception e) {
                    System.out.println("Вы ввели не число или некорректное число!");
                }
                break;
            case "7":
                System.out.println("Введите название товара (например: молоко): ");
                str = scanner.nextLine();
                ListGoods.printList("Товары с названием " + str, ListGoods.getNeedName(str));
                break;
            case "8":
                System.out.println("Введите название производителя товара (например: rrr): ");
                str = scanner.nextLine();
                ListGoods.printList("Товары производителя " + str, ListGoods.getNeedManufacturer(str));
                break;
            case "9":
                ListGoods.printList("Список товаров отсортированный по рейтингу от большего к меньшему", ListGoods.getMaxRating());
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                break;
            case "13":
                break;
            case "100":
                break;
            case "end":
                break;
            default:
                System.out.println("Неверная команда");
        }
    }
}
