
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.Usuario;


public class DaoUsuario {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario login(String usuario,String pass){
        Usuario us=new Usuario();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"' and pass=aes_encrypt('"+pass+"','clave')";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        while(rs.next()){
            us.setIdUsuario(rs.getInt(1));
            us.setNombre(rs.getString(2));
            us.setApellido(rs.getString(3));
            us.setDni(rs.getString(4));
            us.setDireccion(rs.getString(5));
            us.setTelefono(rs.getString(6));
            us.setCorreo(rs.getString(7));
            us.setTipoUsuario(rs.getString(8));
            us.setUsuario(rs.getString(9));
            us.setPassword(rs.getString(10));
        }   
        } catch (SQLException ex){
            JOptionPane.showConfirmDialog(null, ex);
        }
        return us;
    }
    
    public boolean insertar(String nombre,String apellido,String dni,String direccion,String telefono,String correo,String tipoUsuario,String usuario,String pass){
        String SQL="insert into usuarios (nombre,apellido,dni,direccion,telefono,correo,tipoUsuario,usuario,pass) "
                + "VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+direccion+"','"+telefono+"','"+correo+"','"+tipoUsuario+"'"
                + ",'"+usuario+"',aes_encrypt('"+pass+"','clave'))";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public List Listar(){
        List<Usuario> lista=new ArrayList<>();
        String SQL="select * from usuarios";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Usuario us=new Usuario();
               us.setIdUsuario(rs.getInt(1));
               us.setNombre(rs.getString(2));
               us.setApellido(rs.getString(3));
               us.setDni(rs.getString(4));
               us.setDireccion(rs.getString(5));
               us.setTelefono(rs.getString(6));
               us.setCorreo(rs.getString(7));
               us.setTipoUsuario(rs.getString(8));
               lista.add(us);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public boolean buscar(Usuario us){
        String SQL="SELECT idUsuario,nombre,apellido,dni,direccion,telefono,correo,tipoUsuario,"
                + "usuario,aes_decrypt(usuarios.pass,'clave')as pass from usuarios WHERE dni=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, us.getDni());
            rs=ps.executeQuery();
            if(rs.next()){
                us.setIdUsuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setDni(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setTipoUsuario(rs.getString(8));
                us.setUsuario(rs.getString(9));
                us.setPassword(rs.getString(10));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(String nombre,String apellido,String dni,String direccion,
                            String telefono,String correo,String tipoUsuario,String usuario,String pass,int id){
        String SQL="update usuarios SET nombre='"+nombre+"',apellido='"+apellido+"',dni='"+dni+"',direccion='"+direccion+"',telefono='"+telefono+"'\n" +
                    ",correo='"+correo+"',tipoUsuario='"+tipoUsuario+"',usuario='"+usuario+"',pass=aes_encrypt('"+pass+"','clave') WHERE idUsuario="+id;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public int CantUsrs(){
        String SQL="SELECT COUNT(idUsuario) FROM usuarios";
        int cantidad=0;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
        
            rs=ps.executeQuery();
            if(rs.next()){
               cantidad=rs.getInt(1);
            }else{
               cantidad=0;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return cantidad;
    }
    
    public boolean eliminar(Usuario us){
        String SQL="delete from usuarios where idUsuario=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, us.getIdUsuario());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
}