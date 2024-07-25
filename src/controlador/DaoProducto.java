/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.conexion;

public class DaoProducto {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Producto p){
        String SQL="insert into producto (idProducto,nombre,stock,idCategoria,precioVenta) VALUES (?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNomProd());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getIdCategoria());
            ps.setDouble(5, p.getPrecioVenta());
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
    
    public int numeroProducto(){
        int numero=0;
        String SQL="select max(idProducto) from producto";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                numero=rs.getInt(1);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return numero;
    }
    
    public List Listar(){
        List<Producto> lista=new ArrayList<>();
        String SQL="select * from producto";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Producto p=new Producto();
               p.setIdProducto(rs.getInt(1));
               p.setNomProd(rs.getString(2));
               p.setStock(rs.getInt(3));
               p.setIdCategoria(rs.getInt(4));
               p.setPrecioVenta(rs.getDouble(5));
               lista.add(p);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public boolean buscar(Producto p){
        String SQL="select * from producto where idProducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, p.getIdProducto());
            rs=ps.executeQuery();
            if(rs.next()){
               p.setIdProducto(rs.getInt(1));
               p.setNomProd(rs.getString(2));
               p.setStock(rs.getInt(3));
               p.setIdCategoria(rs.getInt(4));
               p.setPrecioVenta(rs.getDouble(5));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean calcularStock(int idProducto, int cantidad){
        String SQL="UPDATE producto set stock=stock+"+cantidad+" WHERE idProducto="+idProducto;
        
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
    
    public boolean editar(Producto p){
        String SQL="update producto set nombre=?,stock=?,idCategoria=?,precioVenta=? where idProducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, p.getNomProd());
            ps.setInt(2, p.getStock());
            ps.setInt(3, p.getIdCategoria());
            ps.setDouble(4, p.getPrecioVenta());
            ps.setDouble(5, p.getIdProducto());
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
    
    public boolean restarStock(int idp,int cant){
        String SQL="UPDATE producto set stock=stock-"+cant+" WHERE idProducto="+idp;
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
    
    public boolean eliminar(Producto p){
        String SQL="delete from producto WHERE idProducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setInt(1, p.getIdProducto());
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
    
    public boolean editarPrecioVenta(Producto p){
        String SQL="update producto set precioVenta=? where idProducto=?";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setDouble(1, p.getPrecioVenta());
            ps.setInt(2, p.getIdProducto());
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
    
    public int CantPrds(){
        String SQL="SELECT COUNT(idProducto) FROM producto";
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
