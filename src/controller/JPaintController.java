package controller;

import main.ICommand;
import main.redoTheCommands;
import main.undoTheCommands;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    public JPaintController(IUiModule uiModule, ApplicationState appState, IUiModule uiModule1, IApplicationState applicationState) {
        this.uiModule = uiModule1;
        this.applicationState = applicationState;
    }


    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        ICommand undo= new undoTheCommands();
        ICommand redo = new redoTheCommands();
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.REDO,()-> redo.run());
        uiModule.addEvent(EventName.UNDO,()-> undo.run());

    }
}
