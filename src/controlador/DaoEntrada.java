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
import modelo.Entrada;
import modelo.conexion;

public class DaoEntrada {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Entrada et){
        String SQL="insert into entrada (numEntrada,idProveedor,fecha,subtotal,igv,total) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            ps.setString(1, et.getNumEntrada());
            ps.setInt(2, et.getIdProveedor());
            ps.setDate(3, et.getFecha());
            ps.setDouble(4, et.getSubtotal());
            ps.setDouble(5, et.getIgv());
            ps.setDouble(6, et.getTotal());
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
    
    public int CantEtds(){
        String SQL="SELECT COUNT(idEntrada) FROM entrada";
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
    
    public String numEntrada(){
        String numero="";
        String SQL="select max(idEntrada) from entrada";
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
    
    public List Listar(){
        List<Entrada> lista=new ArrayList<>();
        String SQL="select * from entrada";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
               Entrada e=new Entrada();
               e.setIdEntrada(rs.getInt(1));
               e.setNumEntrada(rs.getString(2));
               e.setIdProveedor(rs.getInt(3));
               e.setFecha(rs.getDate(4));
               e.setSubtotal(rs.getInt(5));
               e.setIgv(rs.getDouble(6));
               e.setTotal(rs.getDouble(7));
               lista.add(e);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);    
        }
        return lista;
    }
}