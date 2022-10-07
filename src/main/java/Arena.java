import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;

    private Screen screen;

    Hero hero = new Hero (10,10);
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
        if(position.getX()<=getWidth() && position.getY() <= getHeight()) return true;
        return false;
    }

    public void draw(Screen screen){
        hero.draw(screen);
    }

    private void moveHero (Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()){
            case ArrowDown: moveHero(hero.moveDown()); break;
            case ArrowUp: moveHero(hero.moveUp()); break;
            case ArrowLeft: moveHero(hero.moveLeft()); break;
            case ArrowRight: moveHero(hero.moveRight()); break;
            case Character: if(key.getCharacter() == 'q'){screen.close();} break;
        }
        System.out.println(key);
    }
}
