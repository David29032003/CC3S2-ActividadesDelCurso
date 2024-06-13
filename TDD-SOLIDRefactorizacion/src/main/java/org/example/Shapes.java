package org.example;
import java.util.ArrayList;
import java.util.List;

public class Shapes {
    public final List<Shape> all = new ArrayList<>();
    private final Graphics graphics;
    public Shapes(Graphics graphics){
        this.graphics = graphics;
    }

    public void add(Shape s){
        all.add(s);
    }
    public void draw(){
        for(Shape shape: all){
            if(shape instanceof DrawingStrategy){
                ((DrawingStrategy) shape).draw(graphics);
            }
        }
    }
//    public void draw(){
//        all.forEach(shape->shape.draw(graphics));
//    }
//
//        public static void main(String[] args){
//        System.out.println("aplicando el principio de inversion de dependencias DIP");
//        Shapes shapes = new Shapes(new Graphics());
//        shapes.add(new TextBoxes("nuevotexto"));
//        shapes.add(new RightArrow());
//        shapes.add(new Rectangle(3, 5));
//        shapes.draw();
//    }

}
