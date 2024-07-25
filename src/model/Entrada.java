/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

public class Entrada {
    int idEntrada;
    String numEntrada;
    int idProveedor;
    Date fecha;
    double subtotal;
    double igv;
    double total;

    public Entrada() {
    }

    public Entrada(int idEntrada, String numEntrada, int idProveedor, Date fecha, double subtotal, double igv, double total) {
        this.idEntrada = idEntrada;
        this.numEntrada = numEntrada;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getNumEntrada() {
        return numEntrada;
    }

    public void setNumEntrada(String numEntrada) {
        this.numEntrada = numEntrada;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
     
}
