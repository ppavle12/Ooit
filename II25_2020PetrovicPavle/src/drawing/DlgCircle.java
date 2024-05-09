package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField xCoord;
	private JTextField yCoord;
	private JTextField rValue;
	public boolean isOk;
	private Color outline = Color.BLACK;
	private Color fill = Color.WHITE;
	public boolean OutLineBoolean;
	public boolean FillBoolean;

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public boolean isOutLineBoolean() {
		return OutLineBoolean;
	}

	public void setOutLineBoolean(boolean outLineBoolean) {
		OutLineBoolean = outLineBoolean;
	}

	public boolean isFillBoolean() {
		return FillBoolean;
	}

	public void setFillBoolean(boolean fillBoolean) {
		FillBoolean = fillBoolean;
	}

	public JTextField getxCoord() {
		return xCoord;
	}

	public void setxCoord(JTextField xCoord) {
		this.xCoord = xCoord;
	}

	public JTextField getyCoord() {
		return yCoord;
	}

	public void setyCoord(JTextField yCoord) {
		this.yCoord = yCoord;
	}

	public JTextField getrValue() {
		return rValue;
	}

	public void setrValue(JTextField rValue) {
		this.rValue = rValue;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("II 25/2020 Petrovic Pavle");
		setModal(true);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);

		xCoord = new JTextField();
		xCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		xCoord.setColumns(10);

		yCoord = new JTextField();
		yCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		yCoord.setColumns(10);

		rValue = new JTextField();
		rValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		rValue.setColumns(10);

		JLabel lblNewLabel3 = new JLabel("X coordinate:");

		JLabel lblNewLabel_2 = new JLabel("Radius:");

		JLabel lblNewLabel = new JLabel("Y coordinate:");
		
		JButton btnOutLineColor = new JButton("Choose outline color");
		btnOutLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				OutLineBoolean = true;
			}
		});
		
		JButton btnNewButton = new JButton("Choose area color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				FillBoolean = true;
			}
		});
			
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(yCoord, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(xCoord)
								.addComponent(rValue)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(47)
							.addComponent(btnOutLineColor)
							.addGap(18)
							.addComponent(btnNewButton)))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(xCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel3))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(yCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(rValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOutLineColor)
						.addComponent(btnNewButton))
					.addGap(35))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			pnlBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (xCoord.getText().trim().isEmpty() || yCoord.getText().trim().isEmpty()
								|| rValue.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "You need to fill all the blank spaces", "Error",
									JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							for (Shape shape : PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									shape.moveTo(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()));
									try {
										((Circle) shape).setRadius(Integer.parseInt(rValue.getText()));
									} catch (NumberFormatException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if (isOutLineBoolean() == true) {
										shape.setOutline(outline);
										setOutLineBoolean(false);
									}
									if (isFillBoolean() == true) {
										shape.setFill(fill);
										setFillBoolean(false);
									}
								}
							}
							isOk = true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				pnlBtn.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				pnlBtn.add(cancelButton);
			}
		}
	}
}