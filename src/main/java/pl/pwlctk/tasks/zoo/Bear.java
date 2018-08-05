package pl.pwlctk.tasks.zoo;

abstract class Bear extends Animal implements Attackable {
    private Arena arena;
    int life;

    void setArena(Arena arena) {
        this.arena = arena;
    }

    public void attack(String animalName) {
        arena.attack(this, animalName);
    }
}
