package model.interfaces;

import main.Shape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

import java.util.ArrayList;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    void setShapelist(Shape shape);

    void setSelectedlist(Shape shape);


    public ArrayList<Shape> getShapelist();

    public ArrayList<Shape> getSelectedlist();

    public void remove(Shape s);

    public boolean check(Shape shape);

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();


}
