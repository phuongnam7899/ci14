import game.Vector2D;

public class Retangle {
    Vector2D position;
    int width;
    int height;

    public Retangle(float x,float y,int width,int height){
        this.position = new Vector2D(x,y);
        this.width = width;
        this.height = height;
    }

    public  boolean intersect(Retangle other){

        if ( (this.position.x > (other.position.x - this.width) && (this.position.x <(other.position.x +other.width)) ) && ( (this.position.y > (other.position.y - this.height)) && (this.position.y <(other.position.y +other.height)) )){
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        Retangle rec1 = new Retangle(0,0,4,4);
        Retangle rec2 = new Retangle(5,5,4,4);
        Retangle rec3 = new Retangle(2,2,4,4);
        System.out.println(rec1.intersect(rec2));
        System.out.println(rec2.intersect(rec3));
        System.out.println(rec1.intersect(rec3));
    }
}