import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    //Class fields
    private Position position;

    //Class constructor
    public Wall(int x, int y) {
        position = new Position(x, y);
    }

    //Class methods
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#646464"));
        //graphics.enableModifiers(SGR.BOLD);
        graphics.putString(position.getX(), position.getY(), "W");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
