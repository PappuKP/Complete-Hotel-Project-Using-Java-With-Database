
public class classExpens {
    int id;
    String name;
    String nature;
    float Expens;
    String date;
    
    
    public classExpens(int id, String name, String nature, float Expens, String date){
        this.id=id;
        this.name=name;
        this.nature=nature;
        this.Expens=Expens;
        this.date=date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getname(){
        return name;
        }
    
    public String getnature()
    {
        return nature;
        
    }
    
    public float getexpens()
            {
                return Expens;
            }
    
    public String getdate()
    {
        return date;
    }
}
