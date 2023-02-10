package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class drawCommandingStrategyss implements commandingStrategys {

    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintedCanvas;
    private IApplicationState applicationState;
    private ICommand drawings;
    public drawCommandingStrategyss(Point startPoint, Point endPoint, PaintCanvasBase paintedCanvas, IApplicationState applicationState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintedCanvas = paintedCanvas;
        this.applicationState = applicationState;
    }

    public void executeCommand() {
        drawings = new drawingCommand(startPoint, endPoint, paintedCanvas, applicationState);
        drawings.run();
    }
}
