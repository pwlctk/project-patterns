package pl.pwlctk.tasks.calendar.command;

public interface Command {
    void run();

    String getHelpMessage();

    String getCommandName();

    default String getHelpLine() {
        return getCommandName() + " - " + getHelpMessage();
    }
}
