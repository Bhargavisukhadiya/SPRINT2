package main;

public class redoTheCommands implements ICommand {

    @Override
    public void run() {
        CommandStorys.redo();
    }
}
