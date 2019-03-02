import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Hero {
    //Class fields
    private Position position;

    //Class constructor
    public Hero(int x, int y){
        position = new Position(x, y);
    }

    //Class methods
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(position.getX(), position.getY(), "X");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
}
