package sort;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JPanel pnlBtn;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField xCoord;
	private JTextField yCoord;
	private JTextField rValue;
	public boolean isOk;
	private boolean delete;

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

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	
	public static void main(String[] args) {
		try {
			SortDlg dialog = new SortDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public SortDlg() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			pnlBtn = new JPanel();
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (xCoord.getText().trim().isEmpty() || yCoord.getText().trim().isEmpty()
								|| rValue.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "You need to fill all the blank spaces", "Error",
									JOptionPane.ERROR_MESSAGE);
							
						}
						else if(xCoord.getText().trim().equals("0")|| yCoord.getText().trim().equals("0")||rValue.getText().trim().equals("0")){
							isOk=false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "You must pass values ​​greater than zero", "Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
							isOk = true;
							setDelete(true);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						setDelete(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(pnlBtn, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		GroupLayout gl_pnlBtn = new GroupLayout(pnlBtn);
		gl_pnlBtn.setHorizontalGroup(gl_pnlBtn.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlBtn
				.createSequentialGroup().addGap(312).addComponent(okButton).addGap(5).addComponent(cancelButton)));
		gl_pnlBtn.setVerticalGroup(gl_pnlBtn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBtn.createSequentialGroup().addGap(5).addGroup(gl_pnlBtn
						.createParallelGroup(Alignment.LEADING).addComponent(okButton).addComponent(cancelButton))));
		pnlBtn.setLayout(gl_pnlBtn);
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

		JLabel lblNewLabel = new JLabel("X coordinate:");

		JLabel lblNewLabel_1 = new JLabel("Y coordinate:");

		JLabel lblNewLabel_2 = new JLabel("Radius:");
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(61)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2))
						.addGap(41)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(xCoord, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(yCoord).addComponent(rValue))
						.addContainerGap(82, Short.MAX_VALUE)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(41)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(xCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(yCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(rValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addContainerGap(81, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_pnlCenter);
		getContentPane().setLayout(groupLayout);
	}
}