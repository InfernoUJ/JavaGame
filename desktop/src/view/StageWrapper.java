package view;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class StageWrapper {
    protected Stage currentStage;

    public Stage getStage(){
        return currentStage;
    }
}
