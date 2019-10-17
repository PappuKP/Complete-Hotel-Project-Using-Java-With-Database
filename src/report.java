
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class report extends javax.swing.JFrame {

    Connection conn=null;
   PreparedStatement pst= null;
   ResultSet rs=null;
   
   int pos;
   
    public report() {
        initComponents();
        showTable();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //----------------------------------------------------------------------------------------filtering tbl_checkout for search
    private void filter(String sql){
        DefaultTableModel model=(DefaultTableModel)checkoutTable.getModel();
        TableRowSorter<DefaultTableModel>tr=new TableRowSorter
                <DefaultTableModel>(model);
                checkoutTable.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(sql));
    }
    
    //_____________________________________________________________________________________________Populating Array List Check out Records
    
    public ArrayList<ClassCheckOut> dataList2()
   {
       ArrayList<ClassCheckOut> dataList = new ArrayList<ClassCheckOut>(); 
       conn=mySqlConnection.ConnectDB();
       String sql="select * from checkout";
       try{
           Statement st = conn.createStatement();
           rs=st.executeQuery(sql);
           
           ClassCheckOut Data;
           while(rs.next()){
               Data = new ClassCheckOut(rs.getInt("id"),rs.getString("cus_name"),rs.getString("cus_father"),rs.getString("address"),rs.getLong("cus_nic"),rs.getString("cus_date"),rs.getString("out_date"),rs.getLong("phone"),rs.getString("cus_country"),rs.getString("cus_city"),rs.getInt("cus_adult"),rs.getInt("cus_child"),rs.getString("room_type"),rs.getInt("room_no"),rs.getFloat("room_cost"),rs.getFloat("taxes"),rs.getFloat("total"));
               
               dataList.add(Data);
           }
           
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
       return dataList;
   }

    //_________________________________________________________________________________________Display data in checkin table
    public void showTable(){
        ArrayList<ClassCheckOut> list = dataList2();
       DefaultTableModel model = (DefaultTableModel)checkoutTable.getModel();
       while(checkoutTable.getRowCount()>0)
       {
           ((DefaultTableModel)checkoutTable.getModel()).removeRow(0);
       }
       Object[]row = new Object[14];
       
       for (int i = 0; i <list.size(); i++) {
           row[0]=list.get(i).getid();
           row[1]=list.get(i).getname();
           row[2]=list.get(i).getfather();
           row[3]=list.get(i).getnic();
           row[4]=list.get(i).getaddress();
           row[5]=list.get(i).getdate();
           row[6]=list.get(i).getodate();
           row[7]=list.get(i).getphone();
           row[8]=list.get(i).getcountry();
           row[9]=list.get(i).getcity();
           row[10]=list.get(i).getadult();
           row[11]=list.get(i).getchildren();
           row[12]=list.get(i).getroomtype();
           row[13]=list.get(i).getroomno();
           
          
           model.addRow(row);
       }
    
    }
    
     //_____________________________________________________________________________________________Show Items
    public void showItems(int index){
        
        lblname.setText(dataList2().get(index).getname());
        lblfather.setText(dataList2().get(index).getfather());
        lbladdress.setText(dataList2().get(index).getaddress());
        lblnic.setText(Long.toString(dataList2().get(index).getnic()));
        lblphone.setText(Long.toString(dataList2().get(index).getphone()));
        lblcheckin.setText(dataList2().get(index).getdate());
        lblcheckout.setText(dataList2().get(index).getodate());
        lblcountry.setText(dataList2().get(index).getcountry());
        lblcity.setText(dataList2().get(index).getcity());
        lbladult.setText(Integer.toString(dataList2().get(index).getadult()));
        lblchildren.setText(Integer.toString(dataList2().get(index).getchildren()));
        lblroomtype.setText(dataList2().get(index).getroomtype());
        lblroomno.setText(Integer.toString(dataList2().get(index).getroomno()));
        lblroomcost.setText(Float.toString(dataList2().get(index).getroomcost()));
        lbltaxes.setText(Float.toString(dataList2().get(index).gettaxes()));
        lbltotal.setText(Float.toString(dataList2().get(index).gettotal()));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRecord = new javax.swing.JPanel();
        top1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        top2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblcity = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lbladdress = new javax.swing.JLabel();
        lblnic = new javax.swing.JLabel();
        lblcheckin = new javax.swing.JLabel();
        lblcountry = new javax.swing.JLabel();
        lbladult = new javax.swing.JLabel();
        lblroomtype = new javax.swing.JLabel();
        lblroomcost = new javax.swing.JLabel();
        lbltaxes = new javax.swing.JLabel();
        lblroomno = new javax.swing.JLabel();
        lblchildren = new javax.swing.JLabel();
        lblcity1 = new javax.swing.JLabel();
        lblcheckout = new javax.swing.JLabel();
        lblphone = new javax.swing.JLabel();
        lblfather = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        fromDate = new com.toedter.calendar.JDateChooser();
        toDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnfilter = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btn_backward1 = new javax.swing.JButton();
        btn_forward1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(43, 70, 139));

        top.setBackground(new java.awt.Color(33, 55, 116));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shs.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("| Customer Report Panel");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelRecord.setBackground(new java.awt.Color(204, 255, 204));

        top1.setBackground(new java.awt.Color(33, 55, 116));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shs.jpg"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 255));
        jLabel23.setText("| Record");

        javax.swing.GroupLayout top1Layout = new javax.swing.GroupLayout(top1);
        top1.setLayout(top1Layout);
        top1Layout.setHorizontalGroup(
            top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        top1Layout.setVerticalGroup(
            top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        top2.setBackground(new java.awt.Color(33, 55, 116));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("Smart Hotel  Contact: 0555145917 | info@smarthotel.com");

        javax.swing.GroupLayout top2Layout = new javax.swing.GroupLayout(top2);
        top2.setLayout(top2Layout);
        top2Layout.setHorizontalGroup(
            top2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        top2Layout.setVerticalGroup(
            top2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Father:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Address:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NIC/Passport:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("CheckIN Date:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Phone:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Country:");

        lblcity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcity.setText("Null");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Adults:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Children:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Check Out Date:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Room Type:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("RoomNo:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Room Cost:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Taxes:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Total:");

        lblname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblname.setText("Null");

        lbladdress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbladdress.setText("Null");

        lblnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblnic.setText("Null");

        lblcheckin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcheckin.setText("Null");

        lblcountry.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcountry.setText("Null");

        lbladult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbladult.setText("Null");

        lblroomtype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblroomtype.setText("Null");

        lblroomcost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblroomcost.setText("Null");

        lbltaxes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltaxes.setText("Null");

        lblroomno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblroomno.setText("Null");

        lblchildren.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblchildren.setText("Null");

        lblcity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcity1.setText("City:");

        lblcheckout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcheckout.setText("Null");

        lblphone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblphone.setText("Null");

        lblfather.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblfather.setText("Null");

        lbltotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltotal.setText("Null");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Manager Signature____________________");

        javax.swing.GroupLayout panelRecordLayout = new javax.swing.GroupLayout(panelRecord);
        panelRecord.setLayout(panelRecordLayout);
        panelRecordLayout.setHorizontalGroup(
            panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(top2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRecordLayout.createSequentialGroup()
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbladult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblroomtype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblroomcost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(lblcity1)
                            .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel20)))
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblphone, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(lblcheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblchildren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblroomno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltaxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRecordLayout.createSequentialGroup()
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblfather, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbladdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRecordLayout.setVerticalGroup(
            panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecordLayout.createSequentialGroup()
                .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRecordLayout.createSequentialGroup()
                        .addComponent(top1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRecordLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(panelRecordLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)))
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lblcity1))
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)))
                    .addGroup(panelRecordLayout.createSequentialGroup()
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname)
                            .addComponent(jLabel8)
                            .addComponent(lblfather))
                        .addGap(18, 18, 18)
                        .addComponent(lbladdress)
                        .addGap(18, 18, 18)
                        .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRecordLayout.createSequentialGroup()
                                .addComponent(lblphone)
                                .addGap(18, 18, 18)
                                .addComponent(lblcheckout)
                                .addGap(18, 18, 18)
                                .addComponent(lblcity)
                                .addGap(18, 18, 18)
                                .addComponent(lblchildren)
                                .addGap(18, 18, 18)
                                .addComponent(lblroomno)
                                .addGap(18, 18, 18)
                                .addComponent(lbltaxes))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordLayout.createSequentialGroup()
                                .addComponent(lblnic)
                                .addGap(18, 18, 18)
                                .addComponent(lblcheckin)
                                .addGap(18, 18, 18)
                                .addComponent(lblcountry)
                                .addGap(18, 18, 18)
                                .addComponent(lbladult)
                                .addGap(18, 18, 18)
                                .addComponent(lblroomtype)
                                .addGap(18, 18, 18)
                                .addComponent(lblroomcost)))))
                .addGap(33, 33, 33)
                .addGroup(panelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbltotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(33, 33, 33)
                .addComponent(top2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        checkoutTable.setBackground(new java.awt.Color(43, 70, 137));
        checkoutTable.setForeground(new java.awt.Color(153, 255, 255));
        checkoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Father", "NIC/Passport", "Address", "IN Date", "OUT Date", "Phone", "Country", "City", "Adult", "Children", "Room Type", "Room No"
            }
        ));
        checkoutTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(checkoutTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("From:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("To:");

        btnfilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnfilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-find-user-male-35.png"))); // NOI18N
        btnfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(33, 55, 116));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(204, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnSave.setText("Print Customer Report");
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSave1.setBackground(new java.awt.Color(33, 55, 116));
        btnSave1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave1.setForeground(new java.awt.Color(204, 255, 255));
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnSave1.setText("Print Customer Table Report");
        btnSave1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        txtsearch.setBackground(new java.awt.Color(33, 55, 116));
        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(153, 255, 255));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        btn_backward1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-go-back-35.png"))); // NOI18N
        btn_backward1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_backward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backward1ActionPerformed(evt);
            }
        });

        btn_forward1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-circled-right-35.png"))); // NOI18N
        btn_forward1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_forward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forward1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnfilter)
                                .addGap(22, 22, 22)
                                .addComponent(btn_backward1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_forward1))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(btnSave1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsearch))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnfilter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_backward1)
                            .addComponent(btn_forward1))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                    .addComponent(panelRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutTableMouseClicked

        int index=checkoutTable.getSelectedRow();
        showItems(index);
        
    }//GEN-LAST:event_checkoutTableMouseClicked

    private void btnfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterActionPerformed
       
        ArrayList<ClassCheckOut> dataList = new ArrayList<ClassCheckOut>(); 
       conn=mySqlConnection.ConnectDB();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String frmDate = dateFormat.format(this.fromDate.getDate());
            String tDate = dateFormat.format(this.fromDate.getDate());
       String sql= "select * from checkout where cus_date between '"+frmDate+"' and '"+tDate+"'";
       try{
           Statement st = conn.createStatement();
           rs=st.executeQuery(sql);
           
           ClassCheckOut Data;
           while(rs.next()){
               Data = new ClassCheckOut(rs.getInt("id"),rs.getString("cus_name"),rs.getString("cus_father"),rs.getString("address"),rs.getLong("cus_nic"),rs.getString("cus_date"),rs.getString("out_date"),rs.getLong("phone"),rs.getString("cus_country"),rs.getString("cus_city"),rs.getInt("cus_adult"),rs.getInt("cus_child"),rs.getString("room_type"),rs.getInt("room_no"),rs.getFloat("room_cost"),rs.getFloat("taxes"),rs.getFloat("total"));
               
               dataList.add(Data);
           }
           
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
       
       DefaultTableModel model = (DefaultTableModel)checkoutTable.getModel();
       while(checkoutTable.getRowCount()>0)
       {
           ((DefaultTableModel)checkoutTable.getModel()).removeRow(0);
       }
       Object[]row = new Object[13];
       
       for (int i = 0; i <dataList.size(); i++) {
           row[0]=dataList.get(i).getid();
           row[1]=dataList.get(i).getname();
           row[2]=dataList.get(i).getfather();
           row[3]=dataList.get(i).getnic();
           row[4]=dataList.get(i).getaddress();
           row[5]=dataList.get(i).getdate();
           row[6]=dataList.get(i).getodate();
           row[6]=dataList.get(i).getphone();
           row[7]=dataList.get(i).getcountry();
           row[8]=dataList.get(i).getcity();
           row[9]=dataList.get(i).getadult();
           row[10]=dataList.get(i).getchildren();
           row[11]=dataList.get(i).getroomtype();
           row[12]=dataList.get(i).getroomno();
           
          
           model.addRow(row);
       }
        
    }//GEN-LAST:event_btnfilterActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        Toolkit tk = panelRecord.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics g=pj.getGraphics();
        panelRecord.paintAll(g);
        g.dispose();
        pj.end();
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
       
        MessageFormat header = new MessageFormat("Smart Hotel  Customer Report ");
        MessageFormat footer = new MessageFormat("Smart Hotel Software Generated Record");
        try{
            checkoutTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,"Cannot be Print !"+e.getMessage());
        }
        
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        
        String txt=txtsearch.getText();
        filter(txt);
        
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btn_forward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forward1ActionPerformed
        
         pos++;
        
        if(pos >=dataList2().size())
        {
            pos =dataList2().size()-1;
        }
        showItems(pos);
        
    }//GEN-LAST:event_btn_forward1ActionPerformed

    private void btn_backward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backward1ActionPerformed
        
         pos--;
        if(pos <0)
        {
            pos=0;
            
        }
        showItems(pos);
        
    }//GEN-LAST:event_btn_backward1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btn_backward1;
    private javax.swing.JButton btn_forward1;
    private javax.swing.JButton btnfilter;
    private javax.swing.JTable checkoutTable;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lbladult;
    private javax.swing.JLabel lblcheckin;
    private javax.swing.JLabel lblcheckout;
    private javax.swing.JLabel lblchildren;
    private javax.swing.JLabel lblcity;
    private javax.swing.JLabel lblcity1;
    private javax.swing.JLabel lblcountry;
    private javax.swing.JLabel lblfather;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnic;
    private javax.swing.JLabel lblphone;
    private javax.swing.JLabel lblroomcost;
    private javax.swing.JLabel lblroomno;
    private javax.swing.JLabel lblroomtype;
    private javax.swing.JLabel lbltaxes;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JPanel panelRecord;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JPanel top;
    private javax.swing.JPanel top1;
    private javax.swing.JPanel top2;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
