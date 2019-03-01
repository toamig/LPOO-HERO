import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    //Class fields
    private Position position;
    private TextCharacter classChar = new TextCharacter('X');


    //Class constructor
    public Hero(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Class methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Screen screen){
        screen.setCharacter(x, y, classChar);
    }
}
