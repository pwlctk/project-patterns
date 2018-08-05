package pl.pwlctk.patterns.structural.facade;

class Todo implements Viewable {
    private final String value;

    public Todo(String value) {
        this.value = value;
    }

    @Override
    public String getContent() {
        return this.value;
    }

}
