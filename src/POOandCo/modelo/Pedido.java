/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POOandCo.modelo;


import java.time.LocalDate;
import java.time.LocalTime;


public class Pedido {
    private int numPedido;
    private Articulo articulo;
    private int cantidad;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime hora;

    public Pedido(int numPedido, Articulo articulo, int cantidad, Cliente cliente) {
        this.numPedido = numPedido;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    
    @Override
    public String toString(){
        return "Numero de Pedido: " + this.numPedido + "\n"
             + "Articulo: " + this.articulo + "\n"              
             + "Cantidad: " + this.cantidad + "\n" 
             + "Cliente: " + this.cliente + "\n"
             + "Fecha del pedido: " + this.fecha  + "\n"
             + "Hora del pedido: " + this.hora + "\n";
    }
    
    
}
