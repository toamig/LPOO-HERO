import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {

    }
    //Class fields

    private Terminal terminal = new DefaultTerminalFactory().createTerminal();
    private Screen screen;

    private int x = 10;
    private int y = 10;

    //Class methods
    public Game() throws IOException {
        screen = new TerminalScreen(terminal);
        try {
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }


    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, new TextCharacter('X'));
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
        if(key.getKeyType() != KeyType.Character){
            switch (key.getKeyType()){
                case ArrowDown: y++; break;
                case ArrowUp: y--; break;
                case ArrowRight: x++; break;
                case ArrowLeft: x--; break;
            }
        }
    }

}