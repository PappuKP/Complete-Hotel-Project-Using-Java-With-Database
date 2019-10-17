
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class checkout extends javax.swing.JFrame {

    Connection conn=null;
   PreparedStatement pst= null;
   ResultSet rs=null;
    public checkout() {
        initComponents();
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         showTable();
    }
    
    int pos = 0;
    

      //----------------------------------------------------------------------------------------filtering tbl_registered for search
    private void filter(String sql){
        DefaultTableModel model=(DefaultTableModel)checkoutTable.getModel();
        TableRowSorter<DefaultTableModel>tr=new TableRowSorter
                <DefaultTableModel>(model);
                checkoutTable.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(sql));
    }
    
    //_____________________________________________________________________________________________Populating Array List Registered Records
    
    public ArrayList<ClassCheckIn> dataList()
   {
       ArrayList<ClassCheckIn> dataList = new ArrayList<ClassCheckIn>(); 
       conn=mySqlConnection.ConnectDB();
       String sql="select * from guests";
       try{
           Statement st = conn.createStatement();
           rs=st.executeQuery(sql);
           
           ClassCheckIn Data;
           while(rs.next()){
               Data = new ClassCheckIn(rs.getInt("id"),rs.getString("cus_name"),rs.getString("cus_father"),rs.getString("address"),rs.getLong("cus_nic"),rs.getString("cus_date"),rs.getLong("phone"),rs.getString("cus_country"),rs.getString("cus_city"),rs.getInt("cus_adult"),rs.getInt("cus_child"),rs.getString("room_type"),rs.getInt("room_no"),rs.getFloat("room_cost"),rs.getFloat("taxes"),rs.getFloat("total"));
               
               dataList.add(Data);
           }
           
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
       return dataList;
   }
    
    //_________________________________________________________________________________________Display data in table
    public void showTable(){
        ArrayList<ClassCheckIn> list = dataList();
       DefaultTableModel model = (DefaultTableModel)checkoutTable.getModel();
       while(checkoutTable.getRowCount()>0)
       {
           ((DefaultTableModel)checkoutTable.getModel()).removeRow(0);
       }
       Object[]row = new Object[13];
       
       for (int i = 0; i <list.size(); i++) {
           row[0]=list.get(i).getid();
           row[1]=list.get(i).getname();
           row[2]=list.get(i).getfather();
           row[3]=list.get(i).getnic();
           row[4]=list.get(i).getaddress();
           row[5]=list.get(i).getdate();
           row[6]=list.get(i).getphone();
           row[7]=list.get(i).getcountry();
           row[8]=list.get(i).getcity();
           row[9]=list.get(i).getadult();
           row[10]=list.get(i).getchildren();
           row[11]=list.get(i).getroomtype();
           row[12]=list.get(i).getroomno();
           
          
           model.addRow(row);
       }
    
    }
     //_____________________________________________________________________________________________Show Items
    public void showItems(int index){
        lblid.setText(Integer.toString(dataList().get(index).getid()));
        txtname.setText(dataList().get(index).getname());
        txtfather.setText(dataList().get(index).getfather());
        txtaddress.setText(dataList().get(index).getaddress());
        txtnic.setText(Long.toString(dataList().get(index).getnic()));
        txtphone.setText(Long.toString(dataList().get(index).getphone()));
        try{
            Date addDate= null;
            addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)dataList().get(index).getdate());
            this.Date.setDate(addDate);
        }
        catch(ParseException e){
            JOptionPane.showMessageDialog(null,"Date and Time Error");
        }
        combocountry.setSelectedItem(dataList().get(index).getcountry());
        combocity.setSelectedItem(dataList().get(index).getcity());
        txtadult.setText(Integer.toString(dataList().get(index).getadult()));
        txtchildren.setText(Integer.toString(dataList().get(index).getchildren()));
        comboroomtype.setSelectedItem(dataList ().get(index).getroomtype());
        txtroomno.setText(Integer.toString(dataList().get(index).getroomno()));
        txtroomcost.setText(Float.toString(dataList().get(index).getroomcost()));
        txttax.setText(Float.toString(dataList().get(index).gettaxes()));
        lblTotal.setText(Float.toString(dataList().get(index).gettotal()));
        
    }
    //
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBox = new javax.swing.JTextField();
        btn_print = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_forward = new javax.swing.JButton();
        btn_backward = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        txtchildren = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblcity = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtfather = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtnic = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtadult = new javax.swing.JTextField();
        combocity = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboroomtype = new javax.swing.JComboBox<>();
        txtroomno = new javax.swing.JTextField();
        txtroomcost = new javax.swing.JTextField();
        txttax = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btn_print1 = new javax.swing.JButton();
        btn_refresh1 = new javax.swing.JButton();
        btn_forward1 = new javax.swing.JButton();
        btn_backward1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        combocountry = new javax.swing.JComboBox<>();
        outDate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();

        searchBox.setBackground(new java.awt.Color(33, 55, 116));
        searchBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchBox.setForeground(new java.awt.Color(153, 255, 255));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer (1).png"))); // NOI18N
        btn_print.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-35.png"))); // NOI18N
        btn_refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-circled-right-35.png"))); // NOI18N
        btn_forward.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_backward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-go-back-35.png"))); // NOI18N
        btn_backward.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 70, 139));

        top.setBackground(new java.awt.Color(33, 55, 116));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shs.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("| CheckOUT");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 255));
        jLabel12.setText("Customer ID:");

        lblid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblid.setForeground(new java.awt.Color(204, 255, 255));
        lblid.setText("00");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(lblid))
                .addContainerGap())
        );

        checkoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Father", "NIC/Passport", "Address", "Date", "Phone", "Country", "City", "Adult", "Children", "Room Type", "Room No"
            }
        ));
        checkoutTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(checkoutTable);

        txtchildren.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Name:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Room Type:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("RoomNo:");

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Phone:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Father:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Address:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("NIC/Passport:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 255));
        jLabel11.setText("Country:");

        lblcity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblcity.setForeground(new java.awt.Color(204, 255, 255));
        lblcity.setText("City:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 255));
        jLabel13.setText("Adults:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 255));
        jLabel14.setText("Children:");

        txtfather.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtnic.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtphone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtadult.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        combocity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "<Kashmir>", "Bagh", "Bhimber", "khuiratta", "Kotli", "Mangla", "Mirpur", "Muzaffarabad", "Plandri", "Rawalakot", "Punch", "<Balochistan>", "Amir Chah", "Bazdar", "Bela", "Bellpat", "Bagh", "Burj", "Chagai", "Chah Sandan", "Chakku", "Chaman", "Chhatr", "Dalbandin", "Dera Bugti", "Dhana Sar", "Diwana", "Duki", "Dushi", "Duzab", "Gajar", "Gandava", "Garhi Khairo", "Garruck", "Ghazluna", "Girdan", "Gulistan", "Gwadar", "Gwash", "Hab Chauki", "Hameedabad", "Harnai", "Hinglaj", "Hoshab", "Ispikan", "Jhal", "Jhal Jhao", "Jhatpat", "Jiwani", "Kalandi", "Kalat", "Kamararod", "Kanak", "Kandi", "Kanpur", "Kapip", "Kappar", "Karodi", "Katuri", "Kharan", "Khuzdar", "Kikki", "Kohan", "Kohlu", "Korak", "Lahri", "Lasbela", "Liari", "Loralai", "Mach", "Mand", "Manguchar", "Mashki Chah", "Maslti", "Mastung", "Mekhtar", "Merui", "Mianez", "Murgha Kibzai", "Musa Khel Bazar", "Nagha Kalat", "Nal", "Naseerabad", "Nauroz Kalat", "Nur Gamma", "Nushki", "Nuttal", "Ormara", "Palantuk", "Panjgur", "Pasni", "Piharak", "Pishin", "Qamruddin Karez", "Qila Abdullah", "Qila Ladgasht", "Qila Safed", "Qila Saifullah", "Quetta", "Rakhni", "Robat Thana", "Rodkhan", "Saindak", "Sanjawi", "Saruna", "Shabaz Kalat", "Shahpur", "Sharam Jogizai", "Shingar", "Shorap", "Sibi", "Sonmiani", "Spezand", "Spintangi", "Sui", "Suntsar", "Surab", "Thalo", "Tump", "Turbat", "Umarao", "pirMahal", "Uthal", "Vitakri", "Wadh", "Washap", "Wasjuk", "Yakmach", "Zhob", " ", "<Federally Administered Northern Areas/FANA>", "Astor", "Baramula", "Hunza", "Gilgit", "Nagar", "Skardu", "Shangrila", "Shandur", " ", "<Federally Administered Tribal Areas/FATA>", "Bajaur", "Hangu", "Malakand", "Miram Shah", "Mohmand", "Khyber", "Kurram", "North Waziristan", "South Waziristan", "Wana", " ", "<Khyber Pakhtonkhwa>", "Abbottabad", "Ayubia", "Adezai", "Banda Daud Shah", "Bannu", "Batagram", "Birote", "Buner", "Chakdara", "Charsadda", "Chitral", "Dargai", "Darya Khan", "Dera Ismail Khan", "Drasan", "Drosh", "Hangu", "Haripur", "Kalam", "Karak", "Khanaspur", "Kohat", "Kohistan", "Lakki Marwat", "Latamber", "Lower Dir", "Madyan", "Malakand", "Mansehra", "Mardan", "Mastuj", "Mongora", "Nowshera", "Paharpur", "Peshawar", "Saidu Sharif", "Shangla", "Sakesar", "Swabi", "Swat", "Tangi", "Tank", "Thall", "Tordher", "Upper Dir", " ", "<Punjab>", "Ahmedpur East", "Ahmed Nager Chatha", "Ali Pur", "Arifwala", "Attock", "Basti Malook", "Bhagalchur", "Bhalwal", "Bahawalnagar", "Bahawalpur", "Bhaipheru", "Bhakkar", "Burewala", "Chailianwala", "Chakwal", "Chichawatni", "Chiniot", "Chowk Azam", "Chowk Sarwar Shaheed", "Daska", "Darya Khan", "Dera Ghazi Khan", "Derawar Fort", "Dhaular", "Dina City", "Dinga", "Dipalpur", "Faisalabad", "Fateh Jang", "Gadar", "Ghakhar Mandi", "Gujranwala", "Gujrat", "Gujar Khan", "Hafizabad", "Haroonabad", "Hasilpur", "Haveli Lakha", "Jampur", "Jhang", "Jhelum", "Kalabagh", "Karor Lal Esan", "Kasur", "Kamalia", "Kamokey", "Khanewal", "Khanpur", "Kharian", "Khushab", "Kot Addu", "Jahania", "Jalla Araain", "Jauharabad", "Laar", "Lahore", "Lalamusa", "Layyah", "Lodhran", "Mamoori", "Mandi Bahauddin", "Makhdoom Aali", "Mandi Warburton", "Mailsi", "Mian Channu", "Minawala", "Mianwali", "Multan", "Murree", "Muridke", "Muzaffargarh", "Narowal", "Okara", "Renala Khurd", "Rajan Pur", "Pak Pattan", "Panjgur", "Pattoki", "Pirmahal", "Qila Didar Singh", "Rabwah", "Raiwind", "Rajan Pur", "Rahim Yar Khan", "Rawalpindi", "Rohri", "Sadiqabad", "Safdar Abad – (Dhaban Singh)", "Sahiwal", "Sangla Hill", "Samberial", "Sarai Alamgir", "Sargodha", "Shakargarh", "Shafqat Shaheed Chowk", "Sheikhupura", "Sialkot", "Sohawa", "Sooianwala", "Sundar (city)", "Talagang", "Tarbela", "Takhtbai", "Taxila", "Toba Tek Singh", "Vehari", "Wah Cantonment", "Wazirabad", " ", "<Sindh>", "Ali Bandar", "Baden", "Chachro", "Dadu", "Digri", "Diplo", "Dokri", "Gadra", "Ghanian", "Ghauspur", "Ghotki", "Hala", "Hyderabad", "Islamkot", "Jacobabad", "Jamesabad", "Jamshoro", "Janghar", "Jati (Mughalbhin)", "Jhudo", "Jungshahi", "Kandiaro", "Karachi", "Kashmor", "Keti Bandar", "Khairpur", "Khora", "Klupro", "Khokhropur", "Korangi", "Kotri", "Kot Sarae", "Larkana", "Lund", "Mathi", "Matiari", "Mehar", "Mirpur Batoro", "Mirpur Khas", "Mirpur Sakro", "Mithi", "Mithani", "Moro", "Nagar Parkar", "Naushara", "Naudero", "Noushero Feroz", "Nawabshah", "Nazimabad", "Naokot", "Pendoo", "Pokran", "Qambar", "Qazi Ahmad", "Ranipur", "Ratodero", "Rohri", "Saidu Sharif", "Sakrand", "Sanghar", "Shadadkhot", "Shahbandar", "Shahdadpur", "Shahpur Chakar", "Shikarpur", "Sujawal", "Sukkur", "Tando Adam", "Tando Allahyar", "Tando Bago", "Tar Ahamd Rind", "Thatta", "Tujal", "Umarkot", "Veirwaro", "Warah" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Room Cost:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 255, 255));
        jLabel16.setText("Taxes:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 255));
        jLabel17.setText("Total:");

        comboroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Single", "Double", "Luxury", "Delux", "Family" }));

        txtroomno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtroomno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomnoActionPerformed(evt);
            }
        });
        txtroomno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtroomnoKeyReleased(evt);
            }
        });

        txtroomcost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtroomcost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomcostActionPerformed(evt);
            }
        });
        txtroomcost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtroomcostKeyReleased(evt);
            }
        });

        txttax.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txttax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttaxActionPerformed(evt);
            }
        });
        txttax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttaxKeyReleased(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 255, 255));
        lblTotal.setText("0.00");

        txtsearch.setBackground(new java.awt.Color(33, 55, 116));
        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(153, 255, 255));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        btn_print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer (1).png"))); // NOI18N
        btn_print1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });

        btn_refresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-35.png"))); // NOI18N
        btn_refresh1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh1ActionPerformed(evt);
            }
        });

        btn_forward1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-circled-right-35.png"))); // NOI18N
        btn_forward1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_forward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forward1ActionPerformed(evt);
            }
        });

        btn_backward1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-go-back-35.png"))); // NOI18N
        btn_backward1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_backward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backward1ActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(33, 55, 116));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(204, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BACKUP.PNG"))); // NOI18N
        btnSave.setText("Check OUT");
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(33, 55, 116));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(204, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-35.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(33, 55, 116));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(204, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-trash-40.png"))); // NOI18N
        btndelete.setText("Delete ");
        btndelete.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        combocountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Afghanistan  ", "Albania  ", "Algeria  ", "Andorra  ", "Angola  ", "Antarctica  ", "Antigua and Barbuda  ", "Argentina  ", "Armenia  ", "Aruba  ", "Australia  ", "Austria  ", "Azerbaijan  ", "Bahamas  ", "Bahrain  ", "Bangladesh  ", "Barbados  ", "Belarus  ", "Belgium  ", "Belize  ", "Benin  ", "Bhutan  ", "Bolivia  ", "Bosnia and Herzegovina  ", "Botswana  ", "Brazil  ", "Brunei  ", "Bulgaria  ", "Burkina Faso  ", "Burundi  ", "Cambodia  ", "Cameroon  ", "Canada  ", "Canary Islands  ", "Cape Verde Islands  ", "Cayman islands  ", "Central African Republic  ", "Chad  ", "Chile  ", "China  ", "Colombia  ", "Comoros  ", "Congo  ", "Cook Islands  ", "Costa Rica  ", "Croatia  ", "Cuba  ", "Cyprus  ", "Czech Republic  ", "Democratic Republic of the Congo (Zaire)  ", "Denmark  ", "Djibouti  ", "Dominica  ", "Dominican Republic  ", "East Timor  ", "Ecuador  ", "Egypt  ", "El Salvador  ", "Equatorial Guinea  ", "Eritrea  ", "Estonia  ", "Ethiopia  ", "Federated States of Micronesia  ", "Fiji  ", "Finland  ", "France  ", "French Guyana  ", "French Polynesia  ", "Gabon  ", "Gambia  ", "Georgia  ", "Germany  ", "Ghana  ", "Greece  ", "Greenland  ", "Grenada  ", "Guatemala  ", "Guinea  ", "Guinea Bissau  ", "Guyana  ", "Haiti  ", "Honduras  ", "Hong Kong  ", "Hungary  ", "Iceland  ", "India  ", "Indonesia  ", "Iran  ", "Iraq  ", "Israel  ", "Italy  ", "Ivory Coast/Côte d’Ivoire  ", "Jamaica  ", "Japan  ", "Jordan  ", "Kazakhstan  ", "Kenya  ", "Kiribati  ", "Kosovo  ", "Kuwait  ", "Kyrgyzstan  ", "Laos  ", "Latvia  ", "Lebanon  ", "Lesotho  ", "Liberia  ", "Libya  ", "Liechtenstein  ", "Lithuania  ", "Luxembourg  ", "Macedonia  ", "Madagascar  ", "Malawi  ", "Malaysia  ", "Maldives  ", "Mali  ", "Malta  ", "Marshall Islands  ", "Martinique  ", "Mauritania  ", "Mauritius  ", "Mexico  ", "Moldova  ", "Monaco  ", "Mongolia  ", "Montenegro  ", "Morocco  ", "Mozambique  ", "Myanmar (Burma)  ", "Namibia  ", "Nauru  ", "Nepal  ", "New Caledonia  ", "New Zealand  ", "Nicaragua  ", "Niger  ", "Nigeria  ", "North Korea  ", "Norway  ", "Oman  ", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland", "Portugal  ", "Puerto Rico  ", "Qatar  ", "Republic of Ireland  ", "Republic of San Marino  ", "Romania  ", "Russia  ", "Rwanda  ", "Samoa  ", "Sao Tome  ", "Saudi Arabia  ", "Scotland  ", "Senegal  ", "Serbia  ", "Seychelles  ", "Sierra Leone  ", "Singapore  ", "Slovakia  ", "Slovenia  ", "Solomon Islands  ", "Somalia  ", "South Africa  ", "South Korea  ", "Spain  ", "Sri Lanka  ", "St. Kitts and Nevis  ", "St. Lucia  ", "St. Vincent and The Grenadines  ", "Sudan  ", "Suriname  ", "Swaziland  ", "Sweden  ", "Switzerland  ", "Syria  ", "Taiwan  ", "Tajikistan  ", "Tanzania  ", "Thailand  ", "The Netherlands  ", "The Vatican  ", "Togo  ", "Tonga  ", "Trinidad and Tobago  ", "Tunisia  ", "Turkey  ", "Turkmenistan  ", "Tuvalu  ", "Uganda  ", "Ukraine  ", "United Arab Emirates  ", "United Kingdom  ", "United States  ", "Uruguay  ", "Uzbekistan  ", "Vanuatu  ", "Venezuela  ", "Vietnam  ", "Wales  ", "West Bank and Gaza  ", "Western Sahara", "Yemen  ", "Zambia  ", "Zimbabwe  ", " " }));
        combocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocountryItemStateChanged(evt);
            }
        });
        combocountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocountryActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 255, 255));
        jLabel18.setText("Check Out Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfather, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel9)
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(63, 63, 63))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(txtnic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(Date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnSave)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(lblcity)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combocity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtadult, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtchildren, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combocountry, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(comboroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtroomcost, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotal)
                                    .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(outDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_backward1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_forward1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_refresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtfather, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel5)
                        .addComponent(txtroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combocountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblcity)
                        .addComponent(combocity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtroomcost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtadult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtchildren, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(lblTotal))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(outDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_backward1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_forward1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_refresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtsearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtroomnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomnoActionPerformed
        
    }//GEN-LAST:event_txtroomnoActionPerformed

    private void txtroomcostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomcostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomcostActionPerformed

    private void txttaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttaxActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        try{
            conn=mySqlConnection.ConnectDB();
            String str="insert into checkout(cus_name, cus_father, address, cus_nic, cus_date, out_date, phone, cus_country, cus_city, cus_adult, cus_child, room_type, room_no, room_cost, taxes, total)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pst = conn.prepareStatement(str);
            pst.setString(1, txtname.getText());
            pst.setString(2, txtfather.getText());
            pst.setString(3, txtaddress.getText());
            pst.setLong(4, Long.parseLong(txtnic.getText()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String regDate = dateFormat.format(this.Date.getDate());
            pst.setString(5, regDate);
            String regDate2 = dateFormat.format(this.outDate.getDate());
            pst.setString(6, regDate2);
            pst.setLong(7, Long.parseLong(txtphone.getText()));
            pst.setString(8, combocountry.getSelectedItem().toString());
            pst.setString(9, combocity.getSelectedItem().toString());
            pst.setString(10, txtadult.getText());
            pst.setString(11, txtchildren.getText());
            pst.setString(12, comboroomtype.getSelectedItem().toString());
            pst.setInt(13, Integer.parseInt(txtroomno.getText()));
            pst.setFloat(14, Float.parseFloat(txtroomcost.getText()));
            pst.setFloat(15, Float.parseFloat(txttax.getText()));
            pst.setFloat(16, Float.parseFloat(lblTotal.getText()));
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Customer "+txtname.getText()+" Has been Checked out");
            pst.close();
            
            String del="delete from guests where id='"+lblid.getText()+"'";
            pst=conn.prepareStatement(del);
            pst.executeUpdate();
            pst.close();
            showTable();
            txtname.setText(null);txtfather.setText(null);txtaddress.setText(null);txtnic.setText(null);Date.setDate(null);
            txtphone.setText(null);combocountry.setSelectedItem(null);combocity.setSelectedItem(null);txtphone.setText(null);
            txtadult.setText(null);txtchildren.setText(null);comboroomtype.setSelectedItem(null);txtroomno.setText(null);
            txttax.setText(null);txtroomcost.setText(null);lblTotal.setText("0.00");
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        try{
            conn=mySqlConnection.ConnectDB();
            String str="update guests set cus_name=?, cus_father=?, address=?, cus_nic=?, cus_date=?,phone=?, cus_country=?, cus_city=?, cus_adult=?, cus_child=?, room_type=?, room_no=?, room_cost=?, taxes=?, total=? where id=?";
                    
            
            pst = conn.prepareStatement(str);
            pst.setString(1, txtname.getText());
            pst.setString(2, txtfather.getText());
            pst.setString(3, txtaddress.getText());
            pst.setLong(4, Long.parseLong(txtnic.getText()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String regDate = dateFormat.format(this.Date.getDate());
            pst.setString(5, regDate);
            
            pst.setLong(6, Long.parseLong(txtphone.getText()));
            pst.setString(7, combocountry.getSelectedItem().toString());
            pst.setString(8, combocity.getSelectedItem().toString());
            pst.setString(9, txtadult.getText());
            pst.setString(10, txtchildren.getText());
            pst.setString(11, comboroomtype.getSelectedItem().toString());
            pst.setInt(12, Integer.parseInt(txtroomno.getText()));
            pst.setFloat(13, Float.parseFloat(txtroomcost.getText()));
            pst.setFloat(14, Float.parseFloat(txttax.getText()));
            pst.setFloat(15, Float.parseFloat(lblTotal.getText()));
            pst.setInt(16, Integer.parseInt(lblid.getText()));
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Record Has Been Updated");
            pst.close();
            
            
            pst.close();
            showTable();
            txtname.setText(null);txtfather.setText(null);txtaddress.setText(null);txtnic.setText(null);Date.setDate(null);
            txtphone.setText(null);combocountry.setSelectedItem(null);combocity.setSelectedItem(null);txtphone.setText(null);
            txtadult.setText(null);txtchildren.setText(null);comboroomtype.setSelectedItem(null);txtroomno.setText(null);
            txttax.setText(null);txtroomcost.setText(null);lblTotal.setText("0.00");
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       conn=mySqlConnection.ConnectDB();
       try{
        String del="delete from guests where id='"+lblid.getText()+"'";
            pst=conn.prepareStatement(del);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Has been Deleted!");
            showTable();
            pst.close();
            conn.close();
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
       }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        
        String txt=txtsearch.getText();
        filter(txt);
        
    }//GEN-LAST:event_txtsearchKeyReleased

    private void combocountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocountryItemStateChanged

    }//GEN-LAST:event_combocountryItemStateChanged

    private void combocountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocountryActionPerformed
        if(combocountry.getSelectedItem().toString().equals("Pakistan"))
        {
            
            combocity.setVisible(true);
            lblcity.setVisible(true);

        }
        else
        {
            
            combocity.setVisible(false);
            lblcity.setVisible(false);
        }

    }//GEN-LAST:event_combocountryActionPerformed

    private void checkoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutTableMouseClicked
        
        int index=checkoutTable.getSelectedRow();
        showItems(index);
    }//GEN-LAST:event_checkoutTableMouseClicked

    private void btn_forward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forward1ActionPerformed
        
        pos++;
        
        if(pos >=dataList().size())
        {
            pos =dataList().size()-1;
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

    private void txtroomnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtroomnoKeyReleased
        
    }//GEN-LAST:event_txtroomnoKeyReleased

    
    private void txtroomcostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtroomcostKeyReleased
        
        float rcost=Float.valueOf(txtroomcost.getText());
        lblTotal.setText(Float.toString(rcost));
        
    }//GEN-LAST:event_txtroomcostKeyReleased

    private void txttaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttaxKeyReleased
        
         
         float result;
        
        result= Float.valueOf(txtroomcost.getText())+Float.valueOf(txttax.getText());
        
        lblTotal.setText(Float.toString(result));
        
        
    }//GEN-LAST:event_txttaxKeyReleased

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed
        
        MessageFormat header = new MessageFormat("Smart Hotel CheckOUT Records ");
        MessageFormat footer = new MessageFormat("Smart Hotel Software Generated Record");
        try{
            checkoutTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,"Cannot be Print !"+e.getMessage());
        }
        
    }//GEN-LAST:event_btn_print1ActionPerformed

    private void btn_refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh1ActionPerformed
        showTable();
        txtname.setText(null);txtfather.setText(null);txtaddress.setText(null);txtnic.setText(null);Date.setDate(null);
            txtphone.setText(null);combocountry.setSelectedItem(null);combocity.setSelectedItem(null);txtphone.setText(null);
            txtadult.setText(null);txtchildren.setText(null);comboroomtype.setSelectedItem(null);txtroomno.setText(null);
            txttax.setText(null);txtroomcost.setText(null);lblTotal.setText("0.00");
    }//GEN-LAST:event_btn_refresh1ActionPerformed

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
            java.util.logging.Logger.getLogger(checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_backward;
    private javax.swing.JButton btn_backward1;
    private javax.swing.JButton btn_forward;
    private javax.swing.JButton btn_forward1;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_print1;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_refresh1;
    private javax.swing.JButton btndelete;
    private javax.swing.JTable checkoutTable;
    private javax.swing.JComboBox<String> combocity;
    private javax.swing.JComboBox<String> combocountry;
    private javax.swing.JComboBox<String> comboroomtype;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblcity;
    private javax.swing.JLabel lblid;
    private com.toedter.calendar.JDateChooser outDate;
    private javax.swing.JTextField searchBox;
    private javax.swing.JPanel top;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtadult;
    private javax.swing.JTextField txtchildren;
    private javax.swing.JTextField txtfather;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtroomcost;
    private javax.swing.JTextField txtroomno;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttax;
    // End of variables declaration//GEN-END:variables
}
