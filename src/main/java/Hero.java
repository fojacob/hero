import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position = new Position();
    Hero(int x, int y){
        position.setX(x);
        position.setY(y);

    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }


    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
