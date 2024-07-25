/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Rafael
 */
public class detalleEntrada {
    
    int idDetalleEntrada;
    int idEntrada;
    int idProducto;
    int cantidad;
    double importe;

    public detalleEntrada() {
    }

    public detalleEntrada(int idDetalleEntrada, int idEntrada, int idProducto, int cantidad, double importe) {
        this.idDetalleEntrada = idDetalleEntrada;
        this.idEntrada = idEntrada;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(int idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
}
