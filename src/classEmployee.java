
public class classEmployee {
    private int id;
    private String name;
    private String father;
    private long nic;
    private long phone;
    private String desig;
    private float salary;
    
    public classEmployee(int id, String name,String father,long nic, long phone, String desig, float salary)
    {
        this.id=id;
        this.name=name;
        this.father=father;
        this.nic=nic;
        this.phone=phone;
        this.desig=desig;
        this.salary=salary;
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
    
     public long getnic()
    {
        return nic;
    }
    
     public long getphone()
    {
        return phone;
    }
     
     
     public String getdesig(){
        return desig;
    }
     
    public float getsalary()
    {
        return salary;
    }
}
