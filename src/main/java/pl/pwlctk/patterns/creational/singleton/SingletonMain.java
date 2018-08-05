package pl.pwlctk.patterns.creational.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        EagerSingleton instance = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        System.out.println(instance == instance2); //będzie true, bo to jest ta sama referencja

        EnumSingleton instanceEnum = EnumSingleton.INSTANCE;
        EnumSingleton instanceEnum2 = EnumSingleton.INSTANCE;

        System.out.println(instanceEnum == instanceEnum2);
        System.out.println(instanceEnum.getValue());
    }
}
