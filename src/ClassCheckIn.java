
public class ClassCheckIn {
    private int id;
    private String name;
    private String father;
    private String address;
    private long nic;
    private String date;
    private long phone;
    private String country;
    private String city;
    private int adult;
    private int children;
    private String roomtype;
    private int roomno;
    private float roomcost;
    private float taxes;
    private float total;
    
    public ClassCheckIn(int id, String name, String father, String address, long nic,String date, long phone, String country, String city, int adult, int children, String roomtype, int roomno, float roomcost, float taxes, float total)
    {
        this.id=id;
        this.name=name;
        this.father=father;
        this.address=address;
        this.nic=nic;
        this.phone=phone;
        this.date=date;
        this.country=country;
        this.city=city;
        this.adult=adult;
        this.children=children;
        this.roomtype=roomtype;
        this.roomno=roomno;
        this.taxes=taxes;
        this.total=total;
    }
    public int getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
    public String getfather()
    {
        return father;
    }
    public String getaddress()
    {
        return address;
    }
    public long getnic()
    {
        return nic;
    }
    public long getphone()
    {
        return phone;
    }
    public String getdate(){
        return date;
    }
    
    public String getcountry()
    {
        return country;
        
    }
    public String getcity()
    {
        return city;
        
    }
    public int getadult()
    {
        return adult;
    }
    public int getchildren()
    {
        return children;
    }
    public String getroomtype()
    {
        return roomtype;
    }
    public int getroomno()
    {
        return roomno;
    }
    public float getroomcost()
    {
        return roomcost;
    }
    public float gettaxes()
    {
        return taxes;
    }
    public float gettotal()
    {
        return total;
    }
}
