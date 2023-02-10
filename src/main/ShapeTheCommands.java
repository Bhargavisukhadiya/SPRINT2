package main;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeTheCommands implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;

    public ShapeTheCommands(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void run() {

        if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
            commandingStrategys draw= new drawCommandingStrategyss(startPoint, endPoint,paintCanvas,appState);
            draw.executeCommand();
        }






    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}



