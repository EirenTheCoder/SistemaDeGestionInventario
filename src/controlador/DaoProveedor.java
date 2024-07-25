
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Proveedor;
import modelo.conexion;


public class DaoProveedor {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Proveedor p){
        String SQL="insert into proveedor (nombre,apellido,ruc,razonSocial,direccion,telefono,correo) VALUES (?,?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getRuc());
            ps.setString(4, p.getRazonSocial());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefono());
            ps.setString(7, p.getCorreo());
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
        List<Proveedor> lista=new ArrayList<>();
        String SQL="select * from proveedor";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Proveedor p=new Proveedor();
               p.setIdProveedor(rs.getInt(1));
               p.setNombre(rs.getString(2));
               p.setApellido(rs.getString(3));
               p.setRuc(rs.getString(4));
               p.setRazonSocial(rs.getString(5));
               p.setDireccion(rs.getString(6));
               p.setTelefono(rs.getString(7));
               p.setCorreo(rs.getString(8));
               lista.add(p);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public boolean buscar(Proveedor p){
        String SQL="select * from proveedor where idProveedor=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, p.getIdProveedor());
            rs=ps.executeQuery();
            if(rs.next()){
                p.setIdProveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setRuc(rs.getString(4));
                p.setRazonSocial(rs.getString(5));
                p.setDireccion(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(Proveedor p){
        String SQL="update proveedor set nombre=?,apellido=?,ruc=?,razonSocial=?,direccion=?,telefono=?,correo=? where idProveedor=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getRuc());
            ps.setString(4, p.getRazonSocial());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefono());
            ps.setString(7, p.getCorreo());
            ps.setInt(8, p.getIdProveedor());
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
    
    public boolean eliminar(Proveedor p){
        String SQL="delete from proveedor where idProveedor=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, p.getIdProveedor());
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
    
    public int CantProvs(){
        String SQL="SELECT COUNT(idProveedor) FROM proveedor";
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
    
    public boolean buscarRuc(Proveedor p){
        String SQL="select * from proveedor where ruc=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, p.getRuc());
            rs=ps.executeQuery();
            if(rs.next()){
                p.setIdProveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setRuc(rs.getString(4));
                p.setRazonSocial(rs.getString(5));
                p.setDireccion(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
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
