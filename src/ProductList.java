import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> products;
    private static ProductList productList;

    private ProductList() {
        products = new LinkedList<>();
    }

    public static ProductList instance() {
        if (productList == null) {
            productList = new ProductList();
        }
        return productList;
    }

    public Product addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        products.add(product);
        return product;
    }

    public Product findProduct(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> getProducts() {
        return products.iterator();
    }

    public void clear() {
        products.clear();
    }

    public String toString() {
        return products.toString();
    }

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        if (products == null) {
            products = new LinkedList<>();
        }
    }
}
