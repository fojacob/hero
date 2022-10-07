import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int x=10;
    private int y=10;

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
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    public void run(){
        try {
            while (true){
                draw(screen);
                KeyStroke key = screen.readInput();
                processKey(key);
                if(key.getKeyType() == KeyType.EOF) break;
            }
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
    private void processKey (KeyStroke key) throws IOException {
        switch (key.getKeyType()){
            case ArrowDown: y+=1; break;
            case ArrowUp: y -=1; break;
            case ArrowLeft: x-=1; break;
            case ArrowRight: x+=1; break;
            case Character: if(key.getCharacter() == 'q'){screen.close();} break;
        }
        System.out.println(key);
    }
}
