import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    Hero hero = new Hero (0,0);

    Arena(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean canHeroMove(Position position){
        if(position.getX() < getWidth() && position.getY() < getHeight() && position.getX()>=0 && position.getY()>=0) return true;
        return false;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }

    private void moveHero (Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key, Screen screen) throws IOException {
        switch (key.getKeyType()){
            case ArrowDown: moveHero(hero.moveDown()); break;
            case ArrowUp: moveHero(hero.moveUp()); break;
            case ArrowLeft: moveHero(hero.moveLeft()); break;
            case ArrowRight: moveHero(hero.moveRight()); break;
            case Character: if(key.getCharacter() == 'q'){screen.close();} break;
            default: break;
        }
    }
}
