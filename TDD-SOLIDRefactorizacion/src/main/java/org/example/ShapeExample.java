package org.example;

public class ShapeExample {

    public static void main(String[] args) {
        new ShapeExample().run();}
        private void run() {
            Graphics console = new ConsoleGraphics();
            //dip : inyectar dependencia shapes en graphics
            var shapes = new Shapes(console);
            //a la clase shapes ocp se le puede agregar cualquier tipo de shape
        //srp cada subclase de forma , por ejemplo rectangle sabe como dibujar solo un faorma
        //lsp subcalses de fomra se puede usar donde sea que se necesite una interfaz de form
        shapes.add(new TextBoxes("nuevotexto"));
        shapes.add(new Rectangle(3, 5));
        shapes.add(new RightArrow());
        shapes.add(new Circle(6));

        shapes.draw();
        }

}
