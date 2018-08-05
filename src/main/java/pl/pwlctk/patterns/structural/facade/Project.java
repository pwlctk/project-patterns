package pl.pwlctk.patterns.structural.facade;

import java.util.ArrayList;
import java.util.List;

class Project implements Viewable {
    private String title;
    private List<Viewable> todos = new ArrayList<>();


    public Project(String title) {
        this.title = title;
    }

    public void addTodo(Viewable todo) {
        this.todos.add(todo);
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>");

        stringBuilder.append(title);
        for (Viewable todo : todos) {
            stringBuilder.append("<li>");
            stringBuilder.append(todo.getContent());
            stringBuilder.append("</li>");

        }

        stringBuilder.append("</ul>");
        return stringBuilder.toString();
    }
}
