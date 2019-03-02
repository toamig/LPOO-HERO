import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Arena {
    //Class fields
    private int width;
    private int height;

    private Position heroPos;
    private Hero hero;

    //Class constructor
    public Arena(int width, int height) {
        heroPos = new Position(10, 10);
        hero = new Hero(heroPos);

        this.width = width;
        this.height = height;
    }

    //Class methods
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() > 0 && position.getX() < this.width-1 && position.getY() > 0 && position.getY() < this.height-1){
            return true;
        }
        else {
            return false;
        }
    }

    public void draw(TextGraphics graphics){
        hero.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        if(key.getKeyType() != KeyType.Character){
            switch (key.getKeyType()){
                case ArrowDown: moveHero(hero.moveDown()); break;
                case ArrowUp: moveHero(hero.moveUp()); break;
                case ArrowRight: moveHero(hero.moveRight()); break;
                case ArrowLeft: moveHero(hero.moveLeft()); break;
            }
        }
    }
}
