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
import modelo.detalleSalida;

public class DaoDetalleSalida {
    
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(int idSalida, int idEntrada, int cantidad, double importe){
        String SQL="insert into detallesalida (idSalida,idProducto,cantidad,importe) VALUES ("+idSalida+","
                + ""+idEntrada+","+cantidad+","+importe+")";
        
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
    
    public List buscar(int idSalida){
        List<detalleSalida> lista=new ArrayList<>();
        String SQL="select * from detallesalida where idSalida="+idSalida;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()){
                detalleSalida ds=new detalleSalida();
                ds.setIdDetalleSalida(rs.getInt(1));
                ds.setIdSalida(rs.getInt(2));
                ds.setIdEntrada(rs.getInt(3));
                ds.setCantidad(rs.getInt(4));
                ds.setImporte(rs.getInt(5));
                lista.add(ds);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }
}
