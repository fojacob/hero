public class Position {
    private int x;
    private int y;

    Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    Position(){
        this.setX(0);
        this.setY(0);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
