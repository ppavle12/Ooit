package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	static Color outline = Color.BLACK;
	static Color area = Color.WHITE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrm() {
		setTitle("II 25/2020 Petrovic Pavle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setBorder(null);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);

		JPanel pnlButton = new JPanel();
		contentPane.add(pnlButton, BorderLayout.WEST);

		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to select!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					PnlDrawing.obj = 6;
				}
			}
		});

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Shape shape : PnlDrawing.shapesArrList) {
					if (shape.isSelected()) {
						if (shape instanceof Circle) {
							Circle circle = (Circle) shape;
							circle.DialogEdit();
							repaint();
						} else if (shape instanceof Rectangle) {
							Rectangle rectangle = (Rectangle) shape;
							rectangle.DialogEdit();
							repaint();
						} else if (shape instanceof Point) {
							Point point = (Point) shape;
							point.DialogEdit();
							repaint();
						} else if (shape instanceof Line) {
							Line line = (Line) shape;
							line.DialogEdit();
							repaint();
						} else if (shape instanceof Donut) {
							Donut donut = (Donut) shape;
							donut.DialogEdit();
							repaint();
						}
					}
				}
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to delete!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Shape shape : PnlDrawing.shapesArrList) {
					if (shape.isSelected()) {
						int ans = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete selected object?", "Warning",
								JOptionPane.YES_NO_OPTION);
						if (ans == 0) {
							PnlDrawing.shapesArrList.remove(shape);
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Please select an object", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton btnOutline = new JButton("Outline color");
		btnOutline.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        outline = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
		        if (outline == null) {
		            outline = Color.BLACK;
		        }
		 
		    }
		});

		JButton btnArea = new JButton("Area color");
		btnArea.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        area = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
		        if (area == null) {
		            area = Color.WHITE;
		        }
		        
		    }
		});
		GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
		gl_pnlButton.setHorizontalGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlButton
				.createSequentialGroup().addGap(5)
				.addGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnArea, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnOutline, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnCircle, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnRectangle, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPoint, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(20)));
		gl_pnlButton.setVerticalGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup().addGap(5).addComponent(btnPoint)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLine)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnRectangle)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCircle)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnDonut)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSelect)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnModify)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnDelete)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnOutline)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnArea)
						.addContainerGap(47, Short.MAX_VALUE)));
		pnlButton.setLayout(gl_pnlButton);
	}
}