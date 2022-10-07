import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    Hero hero = new Hero (1,1);

    private List<Wall> walls;

    Arena(int width, int height){
        this.height = height;
        this.width = width;
        this.walls = createWalls();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
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
        return position.getX() < getWidth()-1 && position.getY() < getHeight()-1 && position.getX() > 0 && position.getY() > 0;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
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
