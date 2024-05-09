
package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeft;
	private int width;
	private int heigth;
	
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int heigth) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.heigth = heigth;
		
	}
	
	public Rectangle(Point upperLeft, int width, int heigth, boolean selected) {
		this(upperLeft, width, heigth);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawRect(this.getUpperLeft().getX(),
				this.getUpperLeft().getY(), this.getWidth(), this.getHeigth());
		if (isSelected () == true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getUpperLeft().getX()-3,
					this.getUpperLeft().getY()-3,6,6);
			g.drawRect(this.getUpperLeft().getX() + this.getWidth()-3,
					this.getUpperLeft().getY()-3,6,6);
			g.drawRect(this.getUpperLeft().getX() -3,
					this.getUpperLeft().getY()+ this.getHeigth()-3,6,6);
			g.drawRect(this.getUpperLeft().getX() + this.getWidth()-3,
					this.getUpperLeft().getY() + this.getHeigth()-3,6,6);
		}
		
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);	
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);	
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			return area() - temp.area();
		}
		return 0;
	}
	
	public int area() {
		return width*heigth;
		
	}
	
	public int circumference() {
		return 2*width + 2*heigth;
	}
	
	public boolean contains(int x, int y) {
		return ((x >= upperLeft.getX() && x<=upperLeft.getX() + width)
					&&
				(y>=upperLeft.getY() && y<=upperLeft.getY() + heigth));
	}
	
	public boolean contains(Point p) {
		return contains (p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "(" + upperLeft.getX() + "," + upperLeft.getY() +") --> (" + width + "," + heigth + ")";
	}
	@Override
	public boolean equals (Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			if(width == temp.getWidth() && heigth == temp.getHeigth()) ;
				return true;
		}
		return false;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public void DialogEdit() {
	    DlgRectangle dlgRectangle = new DlgRectangle();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected() && shape instanceof Rectangle) {
	            String[] split = shape.toString().split("[(),\\s]+");
	            if (split.length >= 10) {
	                dlgRectangle.getTxtX().setText(split[1]);
	                dlgRectangle.getTxtY().setText(split[2]);
	                dlgRectangle.getTxtWidth().setText(split[6]);
	                dlgRectangle.getTxtHeight().setText(split[9]);
	            } else {
	                // Ne može pristupiti indeksima ako nema dovoljno elemenata
	                System.out.println("Nedovoljan broj elemenata u nizu za oblik: " + shape);
	            }
	        }
	    }
	    dlgRectangle.setVisible(true);
	}


	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), 
				this.getWidth(), this.getHeigth());
		
	}


	

	

}
