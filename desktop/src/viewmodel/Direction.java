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

    public void movePlayer(Character player) {
        switch (this) {
            case NORTH -> {
                player.myEntity.setyCenterCoordinate(player.myEntity.getyCenterCoordinate() +
                        player.myPerson.getSpeed());
                player.updateBound();
            }
            case SOUTH -> {
                player.myEntity.setyCenterCoordinate(player.myEntity.getyCenterCoordinate() -
                        player.myPerson.getSpeed());
                player.updateBound();
            }
            case EAST -> {
                player.myEntity.setxCenterCoordinate(player.myEntity.getxCenterCoordinate() +
                        player.myPerson.getSpeed());
                player.updateBound();
            }
            case WEST -> {
                player.myEntity.setxCenterCoordinate(player.myEntity.getxCenterCoordinate() -
                        player.myPerson.getSpeed());
                player.updateBound();
            }
            default -> throw new AssertionError();
        }
    }

}