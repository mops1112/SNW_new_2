
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import project_sanwa_new.DBRoom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yotsathon
 */
public class RoomManagement extends JPanel implements MouseListener, ActionListener {

    /**
     * Creates new form RoomManagement
     */
    JTable table;
    JTextField roomNumber;
    JTextField floor;
    JTextField w_limit;
    JButton saveButton;
    JButton updateButton;
    JPanel showTable;
    JPanel edit;
    DefaultTableModel model;
    DBRoom dbR;
    int rowTable;
    JPopupMenu popupMenu;
    JMenuItem menuItemSetFloor;
    int[] multiRows;

    public RoomManagement() {
        initComponents();
        dbR = new DBRoom();

        table = new JTable() {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                if (rowIndex % 2 == 0 && !isCellSelected(rowIndex, vColIndex)) {
                    c.setBackground(new Color(107, 184, 245));
                } else if (isCellSelected(rowIndex, vColIndex)) {
                    c.setBackground(new Color(0, 176, 255));
                } else {
                    c.setBackground(getBackground());
                }
                return c;
            }

        };

        table.setPreferredScrollableViewportSize(new Dimension(600, 500));
        table.setFillsViewportHeight(true);
        table.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        roomNumber = new JTextField("room number", 20);
        floor = new JTextField("floor", 20);
        w_limit = new JTextField("HighTreshold", 20);
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        saveButton.addMouseListener(this);
        updateButton = new JButton("Update");
        updateButton.addMouseListener(this);
        

        edit = new JPanel();
        edit.add(roomNumber);
        edit.add(w_limit);
        edit.add(floor);
        edit.add(saveButton);
        getDataToTable();
        showTable = new JPanel(new BorderLayout());
        showTable.add(updateButton, BorderLayout.NORTH);
        showTable.add(scrollPane, BorderLayout.CENTER);
         
        add(showTable, BorderLayout.LINE_START);
        add(edit, BorderLayout.CENTER);
    }

    private void getDataToTable() {
        String columnNames[] = {"roomID", "DragoConnex", "Room Number", "Meter", "HighTreshold", "Floor"};
        model = new DefaultTableModel(new Object[0][0], columnNames);
        dbR.connect();
        ResultSet rs = dbR.selectAllRoomDragoConnex();
        try {
            while (rs.next()) {
                Object[] obj = {rs.getString("room_ID"), rs.getString("description"), rs.getString("roomNumber"), rs.getString("w_mBusID"), rs.getString("w_limit"), rs.getString("floor")};
                model.addRow(obj);
            }
//            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
//            table.setRowSorter(sorter);
            table.setModel(model);
            table.removeColumn(table.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            Logger.getLogger(SiteManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                saveButton.setEnabled(true);
                rowTable = table.rowAtPoint(e.getPoint());
                roomNumber.setText(model.getValueAt(rowTable, 2).toString());
                w_limit.setText(model.getValueAt(rowTable, 4).toString());
                floor.setText(model.getValueAt(rowTable, 5).toString());
            } else {
                
                popupMenu = new JPopupMenu();
                menuItemSetFloor = new JMenuItem("set floor");
                menuItemSetFloor.addActionListener(this);
                popupMenu.add(menuItemSetFloor);
                popupMenu.show(e.getComponent(), e.getX(), e.getY());

            }

        } else if (e.getSource() == saveButton) {
            int rs = dbR.updateRoom(model.getValueAt(rowTable, 0).toString(), roomNumber.getText(), w_limit.getText(), floor.getText());
            if (rs != 0) {
                getDataToTable();
                roomNumber.setText("");
                w_limit.setText("");
                floor.setText("");
                saveButton.setEnabled(false);
            }
        }else if(e.getSource() == updateButton){
            getDataToTable();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemSetFloor) {
                multiRows = table.getSelectedRows();
                ArrayList updateFloor = new ArrayList();
                for(int i=0;i<multiRows.length;i++){
                    updateFloor.add(model.getValueAt(multiRows[i], 0));
                }
                DialogSetFloor dialogSetFloor = new DialogSetFloor(updateFloor);
                dialogSetFloor.setPreferredSize(new Dimension(200, 100));
                dialogSetFloor.setLocationRelativeTo(null);
                dialogSetFloor.setVisible(true);
            

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
