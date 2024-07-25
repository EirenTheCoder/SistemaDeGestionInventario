/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class boletaPago {
    int numBO1;
    int Dni;
    int id_prod;
    int cant_prod_;

    public boletaPago() {
    }

    public boletaPago(int numBO1, int Dni, int id_prod, int cant_prod_) {
        this.numBO1 = numBO1;
        this.Dni = Dni;
        this.id_prod = id_prod;
        this.cant_prod_ = cant_prod_;
    }

    public int getNumBO1() {
        return numBO1;
    }

    public void setNumBO1(int numBO1) {
        this.numBO1 = numBO1;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getCant_prod_() {
        return cant_prod_;
    }

    public void setCant_prod_(int cant_prod_) {
        this.cant_prod_ = cant_prod_;
    }
    
}   
