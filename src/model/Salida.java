
package modelo;

import java.sql.Date;

public class Salida {
    
    int idSalida;
    String numSalida;
    int idCliente;
    Date fecha;
    double subttotal;
    double igv;
    double total;

    public Salida() {
    }

    public Salida(int idSalida, String numSalida, int idCliente, Date fecha, double subttotal, double igv, double total) {
        this.idSalida = idSalida;
        this.numSalida = numSalida;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subttotal = subttotal;
        this.igv = igv;
        this.total = total;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubttotal() {
        return subttotal;
    }

    public void setSubttotal(double subttotal) {
        this.subttotal = subttotal;
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