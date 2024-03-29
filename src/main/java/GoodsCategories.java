import java.util.HashSet;
import java.util.Set;

public class GoodsCategories {
    public static Set<String> categories = new HashSet<>();

    public static void addCategories(String category) {
        categories.add(category);
    }

    public static Set<String> getCategories() {
        return categories;
    }

}
