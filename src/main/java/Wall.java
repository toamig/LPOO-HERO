import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    //Class fields

    //Class constructor
    public Wall(int x, int y) {
        super(x, y);
    }

    //Class methods
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#1EC3FF"));
        graphics.putString(position.getX(), position.getY(), "W");
    }
}
