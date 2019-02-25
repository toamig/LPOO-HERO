import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {

    }

    private Terminal terminal = new DefaultTerminalFactory().createTerminal();

    private Screen screen = new TerminalScreen(terminal);

    public Game() throws IOException {
        try {
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(10, 10, new TextCharacter('X'));
        screen.refresh();
    }

    public void run() throws IOException {
        draw();
    }
}