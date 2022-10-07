import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Arena arena = new Arena(10, 10);
    Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void draw(Screen screen) throws IOException{
        //character creation
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run(){
        try {
            while (true){
                draw(screen);
                KeyStroke key = screen.readInput();
                processKey(key, screen);
                if(key.getKeyType() == KeyType.EOF) break;
            }
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    private void processKey (KeyStroke key, Screen screen) throws IOException {
        arena.processKey(key, screen);
    }

}
