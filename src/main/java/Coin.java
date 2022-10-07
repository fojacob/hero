import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    Coin(int x, int y){super(x,y);}
    public void draw(TextGraphics graphics){
            //graphics.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
            graphics.setForegroundColor(TextColor.Factory.fromString("#e6ab09"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(getX(), getY()), "O");
    }
}
