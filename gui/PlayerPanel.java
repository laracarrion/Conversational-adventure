package tp.pr4.gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PlayerPanel extends javax.swing.JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public PlayerPanel() {
	
	JPanel panel_4 = new JPanel();
	panel_4.setPreferredSize(new Dimension(390, 50));
	GridBagLayout gbl_panel_4 = new GridBagLayout();
	gbl_panel_4.columnWidths = new int[]{159, 71, 0};
	gbl_panel_4.rowHeights = new int[]{15, 0, 0, 0};
	gbl_panel_4.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	panel_4.setLayout(gbl_panel_4);
	
	JLabel lblPlayerInfo = new JLabel("Player info");
	lblPlayerInfo.setHorizontalAlignment(SwingConstants.CENTER);
	lblPlayerInfo.setFont(new Font("Verdana", Font.BOLD, 11));
	GridBagConstraints gbc_lblPlayerInfo = new GridBagConstraints();
	gbc_lblPlayerInfo.anchor = GridBagConstraints.NORTHWEST;
	gbc_lblPlayerInfo.insets = new Insets(0, 0, 5, 5);
	gbc_lblPlayerInfo.gridx = 0;
	gbc_lblPlayerInfo.gridy = 0;
	panel_4.add(lblPlayerInfo, gbc_lblPlayerInfo);
	
	JLabel lblNewLabel = new JLabel("Health");
	lblNewLabel.setForeground(new Color(255, 0, 255));
	lblNewLabel.setBackground(new Color(154, 205, 50));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 1;
	panel_4.add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Score");
	lblNewLabel_1.setForeground(new Color(255, 0, 255));
	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
	gbc_lblNewLabel_1.gridx = 1;
	gbc_lblNewLabel_1.gridy = 1;
	panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
	
	table = new JTable(new DefaultTableModel(
		new Object[][] {
			{"Id", "Description"},
			{null, null},
			{null, null},
		},
		new String[] {
			"Id", "Description"
		}) {
		
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] {
			false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	table.setBackground(new Color(255, 105, 180));
	GridBagConstraints gbc_table = new GridBagConstraints();
	gbc_table.insets = new Insets(0, 0, 0, 5);
	gbc_table.fill = GridBagConstraints.BOTH;
	gbc_table.gridx = 0;
	gbc_table.gridy = 2;
	panel_4.add(table, gbc_table);
	

	

}
}
