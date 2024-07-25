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
import modelo.conexion;
import modelo.detalleEntrada;

/**
 *
 * @author Rafael
 */
public class DaoDetalleEntrada {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(int idEntrada, int idProducto, int cantidad, double importe){
        String SQL="insert into detalleentrada (idEntrada,idProducto,cantidad,importe) VALUES ("+idEntrada+","
                + ""+idProducto+","+cantidad+","+importe+")";
        
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
    
    public List buscar(int idEntrada){
        List<detalleEntrada> lista=new ArrayList<>();
        String SQL="select * from detalleentrada where idEntrada="+idEntrada;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                detalleEntrada de=new detalleEntrada();
                de.setIdDetalleEntrada(rs.getInt(1));
                de.setIdEntrada(rs.getInt(2));
                de.setIdProducto(rs.getInt(3));
                de.setCantidad(rs.getInt(4));
                de.setImporte(rs.getInt(5));
                lista.add(de);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
}
