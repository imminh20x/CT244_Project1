
package ConnectDB;

import DT.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AccountDAO {
    ConnectMCSQL db = new ConnectMCSQL();
    Connection connect = db.getConnection();
    PreparedStatement pr;
    ResultSet rs;
    
    public Account findAccountDAO(String username){
        try {
            pr = connect.prepareStatement("select * from ACCOUNT where UserName=?");
            pr.setString(1, username);
            rs = pr.executeQuery();
            if(rs.next()){
                    Account act = new Account(rs.getNString(1), rs.getNString(2),rs.getNString(3));
                    return act;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean saveAccountDAO(Account acc){
        try {
            pr = connect.prepareStatement("insert into ACCOUNT values(?,?,?)");
            pr.setNString(1, acc.getUserName());
            pr.setNString(2, acc.getPassword());
            pr.setString(3, acc.getAvatar());
            if(pr.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateAccountDAO(Account acc){
        try {
            pr = connect.prepareStatement("update ACCOUNT set Password=?, Avatar=? where UserName=?");
            pr.setString(1, acc.getPassword());
            pr.setString(2, acc.getAvatar());
            pr.setString(3, acc.getUserName());
            if(pr.executeUpdate()>0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
