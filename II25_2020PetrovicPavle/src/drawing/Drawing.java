package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Drawing drawing = new Drawing();
		JFrame frame = new JFrame();
		frame.setContentPane(drawing);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Point p1 = new Point(500,500);
		//p1.draw(g);
		
		Line l1 = new Line(new Point(500,200), new Point(500, 400));
		//l1.draw(g);
		
		Rectangle r1 = new Rectangle(new Point(350,200), 50, 50);
		//r1.draw(g);
		
		Circle c1 = new Circle(new Point(300,200),40);
		//c1.draw(g);
		
		Donut d1 = new Donut(new Point(350+r1.getHeigth()/2,200+r1.getWidth()/2),80,(int)(r1.getWidth()*Math.sqrt(2))/2);
		//d1.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);
		
		g.setColor(Color.RED);
		for(Shape s: shapes) {
			if(s instanceof Circle || s instanceof Rectangle) {
				s.draw(g);
			}
		
		}
		
		shapes.get(2).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		g.setColor(Color.GREEN);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);
		g.setColor(Color.BLACK);
		shapes.get(3).draw(g);
		shapes.get(4).draw(g);
	}
}