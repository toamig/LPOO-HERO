import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    //Class fields

    //Class constructor
    public Coin(int x, int y) {
        super(x, y);
    }

    //Class methods
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.putString(position.getX(), position.getY(), "C");
    }
}
