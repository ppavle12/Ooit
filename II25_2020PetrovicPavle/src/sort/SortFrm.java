package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Circle;
import drawing.Point;
import stack.StackDlg;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class SortFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Circle> arrayCircle = new ArrayList<>();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SortFrm() {
		setTitle("II 25/2020 Petrovic Pavle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addContainerGap()));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE).addContainerGap()));

		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);

		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
		    @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
		        SortDlg sortDlg = new SortDlg();
		        sortDlg.setVisible(true);
		        if (sortDlg.isOk) {
		            Circle c = new Circle(
		                new Point(Integer.parseInt(sortDlg.getxCoord().getText()),
		                          Integer.parseInt(sortDlg.getyCoord().getText())),
		                          Integer.parseInt(sortDlg.getrValue().getText()));
		            arrayCircle.add(c);	
		            Collections.sort(arrayCircle);		            
		            dlm.clear();		            
		            for (Circle circle : arrayCircle) {
		                dlm.addElement("X: " + circle.getCenter().getX() + " , Y: " + circle.getCenter().getY()
		                                    + " , Radius " + circle.getRadius());
		            }
		        }
		    }
		});


		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (dlm.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Nothing to remove", "Error", JOptionPane.ERROR_MESSAGE);
		            getToolkit().beep();
		            return;
		        }

		   
		        int selectedIndex = list.getSelectedIndex(); 

		        if (selectedIndex == -1) {
		            JOptionPane.showMessageDialog(null, "Please select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
		            getToolkit().beep();
		            return; 
		        }

		   
		        String selectedItem = dlm.getElementAt(selectedIndex).toString();
		        String[] split = selectedItem.split(" ");

		    
		        int x = Integer.parseInt(split[1]);
		        int y = Integer.parseInt(split[4]);
		        int r = Integer.parseInt(split[7]);

		        StackDlg stackDlgDelete = new StackDlg();
		        stackDlgDelete.getxCoord().setText(String.valueOf(x));
		        stackDlgDelete.getyCoord().setText(String.valueOf(y));
		        stackDlgDelete.getrValue().setText(String.valueOf(r));
		        stackDlgDelete.getxCoord().setEditable(false);
		        stackDlgDelete.getyCoord().setEditable(false);
		        stackDlgDelete.getrValue().setEditable(false);
		        stackDlgDelete.setVisible(true);

		  
		        if (stackDlgDelete.isDelete()) {
		        
		            arrayCircle.remove(selectedIndex);
		            dlm.removeElementAt(selectedIndex);
		        }
		    }
		});

		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(133)
					.addComponent(btnAdd)
					.addGap(55)
					.addComponent(btnRemove)
					.addGap(143))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove)))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}