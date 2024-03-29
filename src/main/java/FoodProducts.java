
public class FoodProducts extends Goods {
    protected String category = "Продукты питания";
    protected String validUntil;

    public FoodProducts(String name, int price, String manufacturer, String validUntil) throws Exception {
        super(name, price, manufacturer);
        addCategory(category);
        setValidUntil(validUntil);
    }

    public void setValidUntil(String validUntil) throws Exception {
        if (!validUntil.isEmpty()) {
            this.validUntil = validUntil;
        } else {
            throw new Exception("Некорректные данные.");
        }
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", Категория='" + category + '\'' +
                ", Название='" + name + '\'' +
                ", Цена=" + price +
                ", Производитель='" + manufacturer + '\'' +
                ", Годен до='" + validUntil + '\'' +
                ", Рейтинг='" + rating + '\'' +
                "} ";

    }
}
