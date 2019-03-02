import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    //Class fields
    private Terminal terminal;
    private Screen screen;
    private TextGraphics graphics;
    private Arena arena;

    //Class constructor
    public Game() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        arena = new Arena (80, 24);
        graphics = screen.newTextGraphics();

        try {
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Class methods
    public void run() throws IOException {
        while(true) {

            draw(graphics);
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            else if(key.getKeyType() == KeyType.EOF){
                break;
            }
            processKey(key);
        }
    }


    private void draw(TextGraphics graphics) throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
}