package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private Point center;
	private int radius;
	
	public Circle() {
		
	}
	
	public Circle (Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle (Point center, int radius, boolean selected) {
		this (center, radius);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		if(selected) {
			g.setColor(Color.BLACK);
			g.drawRect(center.getX()-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()+radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()+radius-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-radius-3, 6, 6);
		}
	}
		
	
	
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);	
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);	
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle) o;
			return (int)(area() - temp.area());
		}
		return 0;
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(new Point(x,y)) <=radius;
	}
	
	//Overloading
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "(" + center.getX() + "," + center.getY() + ") --> (" + radius + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			if(radius == temp.getRadius() && center.equals(temp.getCenter()));
				return true;
		}
		return false;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		if(radius <=0) {
			throw new Exception ("Radius ne moze biti postavljen na 0");
		}else {
			this.radius = radius;
	}
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(),
				this.getRadius() * 2, this.getRadius() * 2);
	}
	@Override
	public void DialogEdit() {
	    DlgCircle dlgCircle = new DlgCircle();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected()) {
	            String[] split = shape.toString().split("[(),\\s]+");
	            dlgCircle.getxCoord().setText(split[1]); // Proveri koji indeksi odgovaraju koje vrednosti
	            dlgCircle.getyCoord().setText(split[2]);
	            dlgCircle.getrValue().setText(split[4]);
	        }
	    }
	    dlgCircle.setVisible(true);
	}


	
	
}