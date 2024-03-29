
public class Furniture extends Goods {
    protected String category = "Мебель";
    protected String color = "";

    public Furniture(String name, int price, String manufacturer) throws Exception {
        super(name, price, manufacturer);
        super.category = category;
        addCategory(category);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", Категория='" + category + '\'' +
                ", Название='" + name + '\'' +
                ", Цена=" + price +
                ", Производитель='" + manufacturer + '\'' +
                ", Цвет='" + color + '\'' +
                ", Рейтинг='" + rating + '\'' +
                "} "
                ;
    }
}
