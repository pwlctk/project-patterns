package pl.pwlctk.patterns.behavior.visitor;

public class Taxi {
//    void handleCustomer(Customer customer){
//        if(customer instanceof RichCustomer){
//            System.out.println("zapłaci dodatkowo 500zł");
//        } else if (customer instanceof PoorCustomer){
//            System.out.println("Bieda, zasra pewnie fotele");
//        }
//    }

    void handleCustomer(PoorCustomer customer){
        System.out.println("Bieda, zasra pewnie fotele");
    }

    void handleCustomer(RichCustomer customer){
        System.out.println("zapłaci dodatkowo 500zł");
    }
}
