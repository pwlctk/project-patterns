package pl.pwlctk.tasks.zoo;

import java.time.LocalDateTime;

public abstract class Animal {
    int life;
    private LocalDateTime lastEatTime;

    LocalDateTime getLastEatTime() {
        return lastEatTime;
    }

    public Animal() {
        this.lastEatTime = LocalDateTime.now();
    }

    boolean isAlive() {
        if (life > 0) {
            LocalDateTime tenDaysBeforeNow = LocalDateTime.now().minusDays(10);
            return getLastEatTime().isAfter(tenDaysBeforeNow);
        } else {
            return false;
        }
    }

    void eat() {
        this.lastEatTime = LocalDateTime.now();
    }

    void display() {
        System.out.println("Gatunek zwierzęcia: " + getClass().getSimpleName());
        System.out.println("Waga: " + getWeight());
    }

    void injuries(int damage) {
        life -= damage;
    }

    int getLife() {
        return life;
    }

    abstract int getWeight();

    abstract String getName();


}
