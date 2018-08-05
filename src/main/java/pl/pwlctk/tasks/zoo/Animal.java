package pl.pwlctk.tasks.zoo;

import java.time.LocalDateTime;

public abstract class Animal {
    private LocalDateTime lastEatTime;

    LocalDateTime getLastEatTime() {
        return lastEatTime;
    }

    public Animal() throws IdontEatException {
        this.lastEatTime = LocalDateTime.now();
    }

    boolean isAlive() {
        LocalDateTime tenDaysBeforeNow = LocalDateTime.now().minusDays(10);
        return getLastEatTime().isAfter(tenDaysBeforeNow);

    }

    void eat() {
        this.lastEatTime = LocalDateTime.now();
    }

    void display(){
        System.out.println("Gatunek zwierzęcia: " + getClass().getSimpleName());
        System.out.println("Waga: " + getWeight());
    }

    abstract int getWeight();

    abstract String getName();

}
