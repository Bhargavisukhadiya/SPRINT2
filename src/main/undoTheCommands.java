package main;

public class undoTheCommands implements ICommand{
    @Override
    public void run() {
        CommandStorys.undo();
    }
}
