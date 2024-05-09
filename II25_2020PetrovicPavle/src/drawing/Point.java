package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	
	private int x;
	private int y;
	
	
	public Point () {
		
	}
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point (int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());;
		g.drawLine(this.getX()-2, this.getY(), this.getX()+2, this.getY());
		g.drawLine(this.getX(), this.getY()-2, this.getX(), this.getY()+2);
		if (isSelected()==true) {
			g.setColor(Color.BLACK);
			g.drawRect (this.getX()-3, this.getY()-3, 6, 6);
		}
	}
	
	
	@Override
	public void moveBy(int byX, int byY) {
		x+=byX;
		y+=byY;
			
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
			
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point) o;
			return (int)(distance(new Point(0,0)) - temp.distance(new Point(0,0)));
		}
		return 0;
	}
	
	public double distance(Point p1) {
		int dx = this.x - p1.getX();
		int dy = this.y - p1.getY();
		return Math.sqrt(dx*dx + dy*dy);
		
	}
	
	public boolean contains(int x, int y) {
		return distance(new Point(x,y)) <= 3;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point temp = (Point) o;
			if(x == temp.getX() && y == temp.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public int getX () {
		return x;
		
	}
	
	public int getY () {
		return y;
		
	}
	
	
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void DialogEdit() {
	    DlgPoint dlgPoint = new DlgPoint();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected()) {
	            String[] split = shape.toString().split("[(),\\s]+"); // Promenjen delimiter
	            if (split.length >= 4) { // Provera dužine niza
	                dlgPoint.getxCoord().setText(split[1]);
	                dlgPoint.getyCoord().setText(split[3]); // Promenjen indeks
	            } else {
	                // Ne može pristupiti indeksima ako nema dovoljno elemenata
	                System.out.println("Nedovoljan broj elemenata u nizu za oblik: " + shape);
	            }
	        }
	    }
	    dlgPoint.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	



	
	}