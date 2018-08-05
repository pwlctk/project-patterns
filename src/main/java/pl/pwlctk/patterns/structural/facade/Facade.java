package pl.pwlctk.patterns.structural.facade;

public class Facade {
    public String showProject(String title, String ... todos){
        Project project = new Project(title);

        for (String todo :todos){
            project.addTodo(new Todo(todo));
        }
        return project.getContent();
    }
}
