//S - принцип единственной ответственности (Single Responsibility Principle)
//Класс должен выполнять только те функции, для которых он логически предназначен.

//Принцип открытости-закрытости: класс должен быть закрыт для модификации, но открыт для расширения

//Для того чтобы следовать принципу подстановки Барбары Лисков
// необходимо в базовый (родительский) класс выносить только общую логику,
// характерную для классов наследников, которые будут ее реализовывать
public abstract class Goods {

    protected int id = 0;
    protected String category;
    protected String name;
    protected Integer price = 0;
    protected String manufacturer = "";

    protected int rating = 1;


    public Goods(String name, int price, String manufacturer) throws Exception {

        setName(name);
        setPrice(price);
        setManufacturer(manufacturer);
    }

    public String getCategory() {
        return category;
    }


    public String getName() {
        return name;
    }


    public Integer getPrice() {
        return price;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addCategory(String category) {
        GoodsCategories.addCategories(category);
    }


    public void setName(String name) throws Exception {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new Exception("Некорректные данные.");
        }

    }


    public void setPrice(Integer price) throws Exception {
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception("Некорректная цена.");
        }
    }


    public void setManufacturer(String manufacturer) throws Exception {
        if (!manufacturer.isEmpty()) {
            this.manufacturer = manufacturer;
        } else {
            throw new Exception("Некорректные данные.");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String toString() {
        return "{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
