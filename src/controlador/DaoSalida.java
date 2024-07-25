
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Salida;
import modelo.conexion;

public class DaoSalida {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Salida s){
        String SQL="insert into salida (numSalida,idCliente,fecha,subtotal,igv,total) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, s.getNumSalida());
            ps.setInt(2, s.getIdCliente());
            ps.setDate(3, s.getFecha());
            ps.setDouble(4, s.getSubttotal());
            ps.setDouble(5, s.getIgv());
            ps.setDouble(6, s.getTotal());
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
    
    public List ListarFechas(String fecha1, String fecha2){
        List<Salida> lista=new ArrayList<>();
        String SQL="SELECT * FROM salida WHERE fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Salida s=new Salida();
               s.setIdSalida(rs.getInt(1));
               s.setNumSalida(rs.getString(2));
               s.setIdCliente(rs.getInt(3));
               s.setFecha(rs.getDate(4));
               s.setSubttotal(rs.getInt(5));
               s.setIgv(rs.getDouble(6));
               s.setTotal(rs.getDouble(7));
               lista.add(s);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public List Listar(){
        List<Salida> lista=new ArrayList<>();
        String SQL="select * from salida";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Salida s=new Salida();
               s.setIdSalida(rs.getInt(1));
               s.setNumSalida(rs.getString(2));
               s.setIdCliente(rs.getInt(3));
               s.setFecha(rs.getDate(4));
               s.setSubttotal(rs.getInt(5));
               s.setIgv(rs.getDouble(6));
               s.setTotal(rs.getDouble(7));
               lista.add(s);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
    
    public int CantSlds(){
        String SQL="SELECT COUNT(idSalida) FROM salida";
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
    
    public String numSalida(){
        String numero="";
        String SQL="select max(idSalida) from salida";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                numero=rs.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return numero;
    }
    
    
}
