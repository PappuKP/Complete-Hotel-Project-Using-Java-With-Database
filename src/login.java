
public class login {
    int id;
    String user;
    String pass;
    String status;
    
    public login(int id, String user, String pass, String status)
    {
        this.id=id;
        this.user=user;
        this.pass=pass;
        this.status=status;
    }
    
    public int getid()
    {
        return id;
    }
    public String getuser()
    {
        return user;
    }
    public String getpass()
    {
        return pass;
    }
    public String getstatus()
    {
        return status;
    }
}
