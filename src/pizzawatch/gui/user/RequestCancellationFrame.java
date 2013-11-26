/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pizzawatch.gui.user;

import javax.swing.table.TableModel;
import pizzawatch.utils.UserUtils;

@SuppressWarnings("serial")
public class RequestCancellationFrame extends javax.swing.JFrame
{
    private final String[] userIDs;
    public RequestCancellationFrame(String[] userIDs)
    {
        this.userIDs = userIDs;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lbTitle = new javax.swing.JLabel();
        btRequestCancellation = new javax.swing.JButton();
        lbNotCancelRequested = new javax.swing.JLabel();
        spNotCancelRequested = new javax.swing.JScrollPane();
        jtNotCancelRequested = new javax.swing.JTable();
        lbCancelRequested = new javax.swing.JLabel();
        spCancelRequested = new javax.swing.JScrollPane();
        jtCancelRequested = new javax.swing.JTable();
        btUndoRequest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitle.setText("Request Cancellation");

        btRequestCancellation.setText("Request Cancellation");
        btRequestCancellation.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRequestCancellationActionPerformed(evt);
            }
        });

        lbNotCancelRequested.setText("Not Requested");

        jtNotCancelRequested.setModel(UserUtils.getNotCancelRequestedOrdersTableModel(userIDs));
        spNotCancelRequested.setViewportView(jtNotCancelRequested);

        lbCancelRequested.setText("Requested");

        jtCancelRequested.setModel(UserUtils.getCancelRequestedOrdersTableModel(userIDs));
        spCancelRequested.setViewportView(jtCancelRequested);

        btUndoRequest.setText("Undo Request Cancellation");
        btUndoRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btUndoRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btRequestCancellation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(193, 193, 193)
                        .addComponent(btUndoRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spNotCancelRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNotCancelRequested))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCancelRequested)
                                    .addComponent(spCancelRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNotCancelRequested)
                    .addComponent(lbCancelRequested))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spNotCancelRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCancelRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRequestCancellation)
                    .addComponent(btUndoRequest))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRequestCancellationActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRequestCancellationActionPerformed
    {//GEN-HEADEREND:event_btRequestCancellationActionPerformed
        //Loop through the column names and the one for the user ID
        //Have to do this every time as the columns can be rearranged
        TableModel tm = jtNotCancelRequested.getModel();
        int tableModelOrderIDColumnNum = -1;
        for(int x = 0; x < tm.getColumnCount(); x++)
        {
            if(tm.getColumnName(x).equals(UserUtils.ORDER_ID_COLUMN_NAME))
            {
                tableModelOrderIDColumnNum = x;
                break;
            }
        }

        int selectedRow = jtNotCancelRequested.getSelectedRow();
        if(selectedRow != -1 && tableModelOrderIDColumnNum != -1)
        {
            UserUtils.updateCancellationOrder(tm.getValueAt(selectedRow, tableModelOrderIDColumnNum),
                                              /*isCancellationRequested*/ true);
            //Set the models again to update the tables
            jtNotCancelRequested.setModel(UserUtils.getNotCancelRequestedOrdersTableModel(userIDs));
            jtCancelRequested.setModel(UserUtils.getCancelRequestedOrdersTableModel(userIDs));
        }
    }//GEN-LAST:event_btRequestCancellationActionPerformed

    private void btUndoRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btUndoRequestActionPerformed
    {//GEN-HEADEREND:event_btUndoRequestActionPerformed
        //Loop through the column names and the one for the user ID
        //Have to do this every time as the columns can be rearranged
        TableModel tm = jtCancelRequested.getModel();
        int tableModelOrderIDColumnNum = -1;
        for(int x = 0; x < tm.getColumnCount(); x++)
        {
            if(tm.getColumnName(x).equals(UserUtils.ORDER_ID_COLUMN_NAME))
            {
                tableModelOrderIDColumnNum = x;
                break;
            }
        }

        int selectedRow = jtCancelRequested.getSelectedRow();
        if(selectedRow != -1 && tableModelOrderIDColumnNum != -1)
        {
            UserUtils.updateCancellationOrder(tm.getValueAt(selectedRow, tableModelOrderIDColumnNum),
                                              /*isCancellationRequested*/ false);
            //Set the models again to update the tables
            jtNotCancelRequested.setModel(UserUtils.getNotCancelRequestedOrdersTableModel(userIDs));
            jtCancelRequested.setModel(UserUtils.getCancelRequestedOrdersTableModel(userIDs));
        }
    }//GEN-LAST:event_btUndoRequestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRequestCancellation;
    private javax.swing.JButton btUndoRequest;
    private javax.swing.JTable jtCancelRequested;
    private javax.swing.JTable jtNotCancelRequested;
    private javax.swing.JLabel lbCancelRequested;
    private javax.swing.JLabel lbNotCancelRequested;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JScrollPane spCancelRequested;
    private javax.swing.JScrollPane spNotCancelRequested;
    // End of variables declaration//GEN-END:variables

}
