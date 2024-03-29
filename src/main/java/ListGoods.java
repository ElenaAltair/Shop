import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListGoods {
    public static int id = 0;
    public static List<Goods> listGoods = new ArrayList<>();

    public ListGoods addGoods(Goods goods) {
        goods.setId(++id);
        listGoods.add(goods);
        return this;
    }

    public static List<Goods> getListGoods() {
        return listGoods;
    }

    // DRY - printList метод для вывода на экран различных списков
    // благодаря ему предотвращается повторение кода для вывода списков на экран
    public static void printList(String name, List<Goods> list) {
        if (!list.isEmpty()) {
            System.out.println(name + ": ");
            for (Goods good : list) {
                System.out.println(good);
            }
        } else {
            System.out.println("Список пуст!");
        }
    }

    public static List<Goods> getPriceLessThan(int a) {
        return listGoods.stream()
                .filter(p -> p.price < a)
                .collect(Collectors.toList());
    }

    public static List<Goods> getPriceMoreThan(int a) {
        return listGoods.stream()
                .filter(p -> p.price > a)
                .collect(Collectors.toList());
    }

    public static List<Goods> getPriceEqual(int a) {
        return listGoods.stream()
                .filter(p -> p.price == a)
                .collect(Collectors.toList());
    }

    public static List<Goods> getNeedCategory(String a) {
        return listGoods.stream()
                .filter(p -> a.equals(p.getCategory()))
                .collect(Collectors.toList());
    }

    public static List<Goods> getNeedManufacturer(String a) {
        return listGoods.stream()
                .filter(p -> a.equals(p.manufacturer))
                .collect(Collectors.toList());
    }

    public static List<Goods> getNeedName(String a) {
        return listGoods.stream()
                .filter(p -> a.equals(p.name))
                .collect(Collectors.toList());
    }


    public static Goods getGoods(int id) {

        return listGoods.stream()
                .filter(p -> p.id == id)
                .collect(Collectors.toList()).get(0); // .toList().get(0);
    }

    public static List<Goods> getMaxRating() {
        return listGoods.stream()
                .sorted(Comparator.comparingInt((Goods t) -> t.rating).reversed())
                //.limit(3)
                .collect(Collectors.toList());

    }
}
