package pl.pwlctk.patterns.structural.composite;

class CompositeMain {
    public static void main(String[] args) {
        Project project = new Project("Main");
        project.addTodo(new Todo("kup jajka"));
        project.addTodo(new Todo("kup mleko"));

        Project homeWork = new Project("Praca domowa");
        homeWork.addTodo(new Todo("Zadanie 1"));
        homeWork.addTodo(new Todo("Zadanie 2"));

        project.addTodo(homeWork);
        project.addTodo(new Todo("kup chleb"));
        System.out.println(project.getContent());
    }
}
