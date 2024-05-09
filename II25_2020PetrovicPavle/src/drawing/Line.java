package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(),
				this.getEndPoint().getX(), this.getEndPoint().getY());
		if (isSelected()==true) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX()-3, this.getStartPoint().getY()-3,6,6);
			g.drawRect(this.getEndPoint().getX()-3, this.getEndPoint().getY()-3,6,6);
			g.drawRect(this.middleOfLine().getX()-3,
					this.middleOfLine().getY()-3,6,6);
		}
	}
	
	public Point middleOfLine () {
		int middleX = (this.getStartPoint().getX() + this.getEndPoint().getX())/2;
		int middleY = (this.getStartPoint().getY() + this.getEndPoint().getY())/2;
		Point middle = new Point (middleX, middleY);
		return middle;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);	
	}

	@Override
	public void moveTo(int x, int y) {
			
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line) o;
			return (int)(length() - temp.length());
		}
		return 0;
	}
	

	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	public boolean contains(int x, int y) {
		Point click = new Point (x,y);
		return length() - (startPoint.distance(click) + endPoint.distance(click)) <=3;
	}
	
	public String toString() {
		return startPoint + "-->" + endPoint;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			if(startPoint.equals(temp.getStartPoint())
					&& endPoint.equals(temp.getEndPoint()));
				return true;
		}
		return false;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public void DialogEdit() {
	    DlgLine dlgLine = new DlgLine();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected() && shape instanceof Line) {
	            Line line = (Line) shape;
	            String[] split = shape.toString().split("-->");
	            if (split.length == 2) {
	                String[] startCoords = split[0].trim().split(" "); 
	                String[] endCoords = split[1].trim().split(" "); 
	                if (startCoords.length == 2 && endCoords.length == 2) {
	                    dlgLine.getSxValue().setText(startCoords[0]); 
	                    dlgLine.getSyValue().setText(startCoords[1]); 
	                    dlgLine.getExValue().setText(endCoords[0]); 
	                    dlgLine.getEyValue().setText(endCoords[1]); 
	                }
	            }
	        }
	    }
	    dlgLine.setVisible(true);
	}



	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	}