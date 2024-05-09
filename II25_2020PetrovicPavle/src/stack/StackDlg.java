package stack;

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

public class StackDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JPanel pnlBtn;
	private JTextField xCoord;
	private JTextField yCoord;
	private JTextField rValue;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton okButton;
	private JButton cancelButton;
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


	public static void main(String[] args) {
		try {
			StackDlg dialog = new StackDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public StackDlg() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			pnlBtn = new JPanel();
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (xCoord.getText().trim().isEmpty() || yCoord.getText().trim().isEmpty()|| rValue.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "You need to fill all the blank spaces", "Error",JOptionPane.ERROR_MESSAGE);
						} 
						else if(xCoord.getText().trim().equals("0")|| yCoord.getText().trim().equals("0")||rValue.getText().trim().equals("0")){
							isOk=false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "All entered values have to be greater than zero", "Error",JOptionPane.ERROR_MESSAGE);
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
		{
			lblNewLabel = new JLabel("X coordinate:");
		}
		{
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
		}

		{
			lblNewLabel_1 = new JLabel("Y coordinate:");
		}
		{
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
		}
		{
			lblNewLabel_2 = new JLabel("Radius:");
		}
		{
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
		}
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(59).addComponent(lblNewLabel).addGap(5)
						.addComponent(xCoord, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(59).addComponent(lblNewLabel_1).addGap(5)
						.addComponent(yCoord, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(87).addComponent(lblNewLabel_2).addGap(5)
						.addComponent(rValue, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(27)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup().addGap(3).addComponent(lblNewLabel))
								.addComponent(xCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup().addGap(3).addComponent(lblNewLabel_1))
								.addComponent(yCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup().addGap(3).addComponent(lblNewLabel_2))
								.addComponent(rValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))));
		pnlCenter.setLayout(gl_pnlCenter);
		getContentPane().setLayout(groupLayout);
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

}