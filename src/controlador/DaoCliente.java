
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.conexion;

public class DaoCliente {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Cliente c){
        String SQL="insert into clientes (nombre,apellido,dni,direccion,telefono,correo) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getCorreo());
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
        List<Cliente> lista=new ArrayList<>();
        String SQL="select * from clientes";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Cliente c=new Cliente();
               c.setIdCliente(rs.getInt(1));
               c.setNombre(rs.getString(2));
               c.setApellido(rs.getString(3));
               c.setDni(rs.getString(4));
               c.setDireccion(rs.getString(5));
               c.setTelefono(rs.getString(6));
               c.setCorreo(rs.getString(7));
               lista.add(c);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public boolean editar(Cliente c){
        String SQL="update clientes set nombre=?,apellido=?,dni=?,direccion=?,telefono=?,correo=? where idCliente=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getCorreo());
            ps.setInt(7, c.getIdCliente());
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
    
    public boolean eliminar(Cliente c){
        String SQL="delete from clientes where idCliente=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, c.getIdCliente());
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
    
    public boolean buscar(Cliente c){
        String SQL="select * from clientes where dni=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, c.getDni());
            rs=ps.executeQuery();
            if(rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setCorreo(rs.getString(7));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public int CantClnts(){
        String SQL="SELECT COUNT(idCliente) FROM clientes";
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
}
