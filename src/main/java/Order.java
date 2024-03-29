public class Order {
    protected static int id = 0;
    protected String nameBuyer;
    protected String nameLastBuyer;

    //D - принцип инверсии зависимостей (Dependency Inversion Principle)
    //Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга.
    //В данном случае был создан отдельный класс для корзины Basket(включающий себя список заказанных товаров)
    //и отдельный класс для заказа Order
    protected Basket basket;
    protected String status = "1"; //1 - принят, 2 - отменён, 3 - выполнен
    protected long date = System.currentTimeMillis();
    protected String phone;

    public Order(String nameBuyer, String nameLastBuyer, Basket basket, String phone) {
        ++id;
        this.nameBuyer = nameBuyer;
        this.nameLastBuyer = nameLastBuyer;
        this.basket = basket;
        this.phone = phone;
    }

    public String getStatus() {
        return switch (this.status) {
            case "1" -> "Заказ принят";
            case "2" -> "Заказ отменён";
            case "3" -> "Заказ выполнен";
            default -> "Некорректный статус";
        };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        if (status.equals("1") || status.equals("2") || status.equals("3")) {
            this.status = status;
            if (status.equals("2") && basket.basket != null) {
                for (Goods good : basket.basket) --good.rating;
            }
        } else {
            System.out.println("Некорректный статус!");
        }
    }


    @Override
    public String toString() {
        return "Заказ{" +
                "id='" + id + '\'' +
                ", Имя покупателя='" + nameBuyer + '\'' +
                ", Фамилия покупателя='" + nameLastBuyer + '\'' +
                ", basket=" + basket +
                ", Статус заказа='" + status + '\'' +
                ", Дата заказа=" + date +
                ", Телефон='" + phone + '\'' +
                '}';
    }
}
