package viewmodel;

import characters.Person;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import org.apache.commons.lang3.tuple.Pair;
import view.CharacterDrawable;

public class SupplierForCharacters {
    /*
    TODO: make a Absctract Factory in future
     */

    protected CharacterDrawable createActor(Character presenter, TextureRegion texture) {
        return new CharacterDrawable(presenter, texture);
    }

    protected Character createVMPresenter(Person entity, TextureRegion texture) {
        return new Character(entity, new Rectangle(entity.getxCenterCoordinate(), entity.getyCenterCoordinate(), texture.getRegionWidth(), texture.getRegionHeight()));
    }

    public Pair<Character, CharacterDrawable> createPair(Person entity, TextureRegion texture){
        Character presenter = createVMPresenter(entity, texture);
        CharacterDrawable actor = createActor(presenter, texture);
        return Pair.of(presenter, actor);
    }
}
