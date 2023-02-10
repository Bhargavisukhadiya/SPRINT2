package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class drawingCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintedCanvas;
    private IApplicationState appState;
    ArrayList<Shape> redo= new ArrayList<Shape>();

    public drawingCommand(Point startPoint, Point endPoint, PaintCanvasBase paintedCanvas, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintedCanvas = paintedCanvas;
        this.appState=appState;

    }
    @Override
    public void run() {
        CommandStorys.add(this);
        getShapeGoFactorys get = new getShapeGoFactorys();
        get.getShape(appState, startPoint, endPoint, paintedCanvas);
    }

    @Override
    public void undo() {
        System.out.println("drawCommand");
        appState.getShapelist();
        for(int i=appState.getShapelist().size()-1;i>=0;i--){
            appState.getShapelist().get(i).clearShape();
            redo.add(appState.getShapelist().get(i));
            appState.getShapelist().remove(appState.getShapelist().get(i));
            break;

        }





    }


    @Override
    public void redo() {

       for(Shape s: redo){
           s.drawShape();
           redo.remove(s);
           appState.getShapelist().add(s);
        }


    }
}
