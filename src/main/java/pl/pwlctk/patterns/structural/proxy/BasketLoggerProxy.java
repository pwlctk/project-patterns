package pl.pwlctk.patterns.structural.proxy;

import java.util.List;

public class BasketLoggerProxy implements Basket {
    private final RealBasket realBasket;

    public BasketLoggerProxy(RealBasket realBasket) {
        this.realBasket = realBasket;
    }

    @Override
    public void addProduct(Product product) {
        realBasket.addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        System.out.println("Użytkownik usunął produkt: " + product);
        realBasket.removeProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return realBasket.getProducts();
    }
}
