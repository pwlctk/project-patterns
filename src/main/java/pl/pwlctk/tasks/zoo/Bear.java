package pl.pwlctk.tasks.zoo;

abstract class Bear extends Animal implements Attackable {
    private Arena arena;

    @Override
    boolean isAlive() {
        if (life > 0) {
            return super.isAlive();
        } else {
            return false;
        }
    }

    void setArena(Arena arena) {
        this.arena = arena;
    }

    public void attack(String animalName) {
        arena.attack(this, animalName);
    }
}
