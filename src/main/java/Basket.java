import java.util.ArrayList;
import java.util.List;

public class Basket {
    protected List<Goods> basket = new ArrayList<>();
    protected List<Integer> count = new ArrayList<>();
    protected int price = 0;

    public Basket addGoods(Goods goods) {

        if (basket.contains(goods)) {
            int index = basket.indexOf(goods);
            count.set(index, count.get(index) + 1);
        } else {
            basket.add(goods);
            int index = basket.indexOf(goods);
            count.add(index, 1);
        }
        price = price + goods.price;
        ++goods.rating;
        return this;
    }

    public int removeGoods(int id) {
        int index = getIndex(id);
        if (index != -1) {
            int priceGood = basket.get(index).price;
            price = price - priceGood;
            count.set(index, count.get(index) - 1);
            --basket.get(index).rating;
            if (count.get(index) == 0) {
                basket.remove(index);
            }
            return 1;
        }

        return -1;
    }

    public int getIndex(int id) {
        for (Goods good : basket) {
            if (good.id == id) {
                return basket.indexOf(good);
            }

        }
        return -1;
    }

    public List<Goods> getListBasket() {
        return basket;
    }

    public void printListBasket() {
        if (!basket.isEmpty()) {
            System.out.println("Товары в корзине: ");
            for (Goods good : basket) {

                System.out.println(good + " Количество: " + count.get(basket.indexOf(good)));
            }
            System.out.println("Общая стоимость товаров в корзине: " + price);
        } else {
            System.out.println("Корзина пуста!");
        }
    }

    public int getPriceBasket() {
        return price;
    }
}
