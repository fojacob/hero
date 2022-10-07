import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    Hero(int x, int y){super(x,y);}

    public Position moveUp(){
        return new Position(getX(), getY()-1);
    }

    public Position moveDown(){
        return new Position(getX(), getY()+1);
    }

    public Position moveRight(){
        return new Position(getX()+1, getY());
    }

    public Position moveLeft(){
        return new Position(getX()-1, getY());
    }

    public void draw(TextGraphics graphics){
        //graphics.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "X");
    }


}
