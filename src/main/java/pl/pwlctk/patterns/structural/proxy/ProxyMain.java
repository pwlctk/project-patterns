package pl.pwlctk.patterns.structural.proxy;

public class ProxyMain {
    public static void main(String[] args) {
        RealBasket realBasket = new RealBasket();
        Client client = new Client(new BasketLoggerProxy(realBasket));
        client.doActions();
        System.out.println("Wszystkie produtkty w koszyku klienta:");
        //realBasket.getProducts().forEach(System.out::println);
        realBasket.getProducts().forEach(product -> System.out.println(product));

    }
}
