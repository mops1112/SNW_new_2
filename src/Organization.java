
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import project_sanwa_new.Building;
import project_sanwa_new.DBBuilding;
import project_sanwa_new.DBDetail;
import project_sanwa_new.DBRoom;
import project_sanwa_new.Database;
import project_sanwa_new.Floor;
import project_sanwa_new.Room;
import project_sanwa_new.Sanwa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yotsathon
 */
public class Organization extends javax.swing.JPanel {

    /**
     * Creates new form Organization
     */
    private String buildingID = null;
    private String floorNumber = null;

    public Organization() {
        initComponents();
        initialize();
    }

    public void initialize() {
//        jLabel11.setOpaque(true);
//        jLabel11.setBackground(new Color(2,119,189));
        try {
            // TODO add your handling code here:
            DBBuilding dbB = new DBBuilding();
            dbB.connect();
            ResultSet rs_building = dbB.selectBuilding();
            Building building;
            com_building.addItem(new Building(null, "None"));
            while (rs_building.next()) {
                building = new Building(rs_building.getString(1), rs_building.getString(2));
                com_building.addItem(building);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Organization.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        com_building = new javax.swing.JComboBox<Building>();
        jLabel2 = new javax.swing.JLabel();
        com_floor = new javax.swing.JComboBox<Floor>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(1, 87, 155));
        setPreferredSize(new java.awt.Dimension(824, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Building :");

        com_building.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_buildingActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Floor :");

        com_floor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_floorActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lorem ipsum dolor.(WATER)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(com_building, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(com_floor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(com_building, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(com_floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DBRoom dbR = new DBRoom();
        DBDetail dbD = new DBDetail();
        dbR.connect();
        dbD.connect();
        String columnNames[] = {"Building", "Floor", "Room", "Date", "Time", "wVo", "eAE", "wFw", "wRv", "wFl"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
        Sanwa sw = new Sanwa();
        List<Room> rooms = new ArrayList<Room>();
        Map<String, String> startDateTime = sw.getCurentDateTime();
        try {
            ResultSet rs = dbR.selectRoomByBuildingFloor(buildingID, floorNumber);
            //while (rs.next()) {
                //ResultSet roomID = dbR.selectRoomIDByBuildingFloor(rs.getString("building_ID"), rs.getString("floor"));// number of rooms in building and floor
                while (rs.next()) {
                    ResultSet result = dbR.selectAllWaterByRoomIDDateTime(rs.getString("room_ID"), startDateTime.get("dateTimeLocal"));
                    if (result.next()) {
                        Object[] obj = {rs.getString("building_name"), rs.getString("floor"), rs.getString("room_number"), result.getString("detail_date"), result.getString("detail_time"), result.getString("wVo"), result.getString("eAE"), result.getString("wFw"), result.getString("wRv"), result.getString("wFl")};
                        model.addRow(obj);
                    } else {
                        //dbD.insertDetailRoom(roomID.getString("room_ID"), startDateTime.get("dateTimeLocal"), result.getString("wFl"), result.getString("wFw"), result.getString("wRv"), result.getString("wVo"), result.getString("eAE"));
//                        rooms = sw.getCurentData(roomID.getString("e_meter"), rs.getString("building_ID"), roomID.getString("room_ID"), startDateTime);
//                        if (rooms != null) {
//                            for (int i = 0; i < rooms.size(); i++) {
//                                Object[] obj = {rs.getString("building_name"), rs.getString("floor"), roomID.getString("room_number"), rooms.get(i).getDate(), rooms.get(i).getTime(), rooms.get(i).getwVo(), rooms.get(i).geteAE(), rooms.get(i).getwFw(), rooms.get(i).getwRv(), rooms.get(i).getwFl()};
//                                model.addRow(obj);
//
//                            }
//                        }

                    }

                }
           // }
            dbR.close();
            dbD.close();
            jTable1.setModel(model);

        } catch (SQLException ex) {
            dbR.close();
            dbD.close();
            Logger.getLogger(Organization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void com_buildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_buildingActionPerformed
        // TODO add your handling code here:
        com_building.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DBRoom dbR = new DBRoom();
                    JComboBox comboBox = (JComboBox) e.getSource();
                    String building_ID = ((Building) comboBox.getSelectedItem()).getID();
                    buildingID = building_ID;

                    dbR.connect();
                    ResultSet rs_floor = dbR.selectFloorByBuilding(building_ID);
                    DefaultComboBoxModel<Floor> model_floor = new DefaultComboBoxModel();
                    model_floor.addElement(new Floor(null, "None"));
                    while (rs_floor.next()) {
                        model_floor.addElement(new Floor(rs_floor.getString("floor"), rs_floor.getString("floor")));
                    }

                    com_floor.setModel(model_floor);
                    floorNumber = null;

                } catch (SQLException ex) {
                    Logger.getLogger(Organization.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_com_buildingActionPerformed

    private void com_floorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_floorActionPerformed
        // TODO add your handling code here:
        try {
            DBRoom dbR = new DBRoom();
            JComboBox comboBox = (JComboBox) evt.getSource();
            String floor_ID = ((Floor) comboBox.getSelectedItem()).getFloorID();
            floorNumber = floor_ID;
            dbR.connect();
            ResultSet rs_room = dbR.selectRoomByBuildingFloor(buildingID, floorNumber);
            while (rs_room.next()) {
                System.out.println(rs_room.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Organization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_com_floorActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        int row = jTable1.rowAtPoint(evt.getPoint());
//         System.out.println(row);

//        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                int row = jTable1.rowAtPoint(evt.getPoint());
//                int col = jTable1.columnAtPoint(evt.getPoint());
//                if (row >= 0 && col >= 0) {
//                   System.out.println(row);
//                }
//            }
//        });
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Building> com_building;
    private javax.swing.JComboBox<Floor> com_floor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
