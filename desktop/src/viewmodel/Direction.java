package viewmodel;

import characters.Player;
import static com.badlogic.gdx.Input.Keys.*;
import java.util.Set;

public enum Direction {

    NORTH(Set.of(W, UP)), SOUTH(Set.of(S, DOWN)), WEST(Set.of(A, LEFT)),
    EAST(Set.of(D, RIGHT));

    public Set<Integer> keyCodes;

    private Direction(Set<Integer> keyCodes) {
        this.keyCodes = keyCodes;
    }

    public void movePlayer(Player player) {
        switch (this) {
            case NORTH ->
                    player.setyCenterCoordinate(player.getyCenterCoordinate() +
                            player.getSpeed());
            case SOUTH ->
                    player.setyCenterCoordinate(player.getyCenterCoordinate() -
                            player.getSpeed());
            case EAST ->
                    player.setxCenterCoordinate(player.getxCenterCoordinate() +
                            player.getSpeed());
            case WEST ->
                    player.setxCenterCoordinate(player.getxCenterCoordinate() -
                            player.getSpeed());
            default -> throw new AssertionError();
        }
    }

}