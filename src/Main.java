
import javax.swing.*;
import java.awt.*;

class Main {
    //GLOBAL VARIABLES
    static double WIDTH = 400;
    static double HEIGHT = 400;
    static double RADIUS = 100;
    //

    static double INITIAL_X = (WIDTH * 0.5) - RADIUS;
    static double INITIAL_Y = HEIGHT * 0.5;

    static JFrame FRAME;
    static Drawing_panel PANEL;

    public static void main(String[] args) {

        FRAME = new JFrame("ROTATING CIRCLE");  //MAKE A FRAME FOR THE ANIMATION WITH A NAME 'ROTATING CIRCLE'
        FRAME.setSize((int) WIDTH, (int) HEIGHT);  //SET THE FRAME SIZE
        PANEL = new Drawing_panel(INITIAL_X, INITIAL_Y);  //MAKE THE PANEL OBJECT IN THE CLASS 'Drawing_paneL'
        FRAME.add(PANEL);  //ADD THE PANEL TO THR FRAME
        FRAME.setVisible(true);  //MAKE THE FRAME VISIBLE

        ROTATING_CIRCLE();  //CALL THE FUNCTION ROTATING_CIRCLE

    }


    public static void ROTATING_CIRCLE() {
        double X, Y;  //MAKE STATIC VARIABLE FOR X AND Y
        while (true) {  //MAKE A NEVER ENDING LOOP
            for (double ANGLE_DEGREE = 0; ANGLE_DEGREE < 360; ANGLE_DEGREE++) {
                double ANGLE_RADIAN = Math.toRadians(ANGLE_DEGREE);  //CONVERT THE ANGLE INTO RADIANS
                //PAUSE FOR 10ms
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //
                //RUN THE MATHS FUNCTION AND UPDATE THE COORDINATE
                X = RADIUS - (RADIUS * Math.cos(ANGLE_RADIAN)) + INITIAL_X;
                Y = INITIAL_Y - (RADIUS * Math.sin(ANGLE_RADIAN));
                //
                PANEL.UPDATE_COORDINATE(X, Y);  //CALL 'UPDATE_COORDINATE'
            }
        }
    }


}


class Drawing_panel extends JPanel {
    private double X_COORDINATE, Y_COORDINATE; //ASSIGN THE X_COORDINATE AND Y_COORDINATE VARIABLES


    //MAKE A CONSTRUCTOR
    public Drawing_panel(double X, double Y) {
        this.X_COORDINATE = X;
        this.Y_COORDINATE = Y;
    }
    //

    protected void paintComponent(Graphics object) {
        float DOT_RADIUS = 4;
        super.paintComponent(object);  //CALL THE SUPER CLASS
        //MAKE A CIRCLE AND GIVE THE COLOUR AS BLACK,X AND Y COORDINATE COORDINATES, RADIUS OF 10 PIXELS
        object.setColor(Color.red);
        object.fillOval((int) X_COORDINATE, (int) Y_COORDINATE, (int) (2 * DOT_RADIUS), (int) (2 * DOT_RADIUS));
        //
        //MAKE A VERTICAL AND HORIZONTAL AXIS THAT PASSES THROUGH THE CENTER
        object.setColor(Color.black);
        object.drawLine(0, 200, 400, 200);
        object.setColor(Color.blue);
        object.drawLine(200, 0, 200, 400);
        //


    }

    public void UPDATE_COORDINATE(double X, double Y) {
        this.X_COORDINATE = X;
        this.Y_COORDINATE = Y;  //ASSIGN THE VALUES OF X TO X_COORDINATE AND Y TO Y_COORDINATE
        repaint();  //CALL THE REPAINT FUNCTION TO UPDATE THE PANEL
    }


}


