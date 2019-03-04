import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    //Class fields
    protected Position position;

    //Class constructor
    public Element(int x, int y) {
        position = new Position(x, y);
    }

    //Class methods
    public abstract void draw(TextGraphics graphics);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
