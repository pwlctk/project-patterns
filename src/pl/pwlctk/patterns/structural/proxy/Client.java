package pl.pwlctk.patterns.structural.proxy;

public class Client {
    private final Basket basket;

    public Client(Basket basket) {
        this.basket = basket;
    }

    public void doActions(){
        basket.addProduct(new Product("Szampon"));
        basket.addProduct(new Product("Piwo"));
        basket.addProduct(new Product("Piwo"));
        basket.addProduct(new Product("Samochód"));
        basket.removeProduct(new Product("Piwo"));
        basket.removeProduct(new Product("Piwo"));
    }
}
