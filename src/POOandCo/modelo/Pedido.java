/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POOandCo.modelo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Pedido {
    private int numPedido;
    private Articulo articulo;
    private int cantidad;
    private Cliente cliente;    
    private LocalDateTime fechaYhora;

    public Pedido(int numPedido, Articulo articulo, int cantidad, Cliente cliente) {
        this.numPedido = numPedido;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.fechaYhora = LocalDateTime.now();        
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

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public boolean pedidoEnviado(){
        LocalDateTime ahora = LocalDateTime.now();
        return ((fechaYhora.plusMinutes(articulo.getTiempoPreparacion())).isBefore(ahora)); 
    }
    
    public float precioEnvio(){
        float temp;
        temp = articulo.getGastosEnvio();
        temp = temp* cliente.descuentoEnv();
        return temp;
    }
    
    @Override
    public String toString(){
        return "Numero de Pedido: " + this.numPedido + "\n"
             + "Fecha y hora: " + this.fechaYhora  + "\n"            
             + "NIF del Cliente: " + this.cliente.getNif() + "\n"
             + "Nombre Cliente: " + this.cliente.getNombre() + "\n"
             + "Codigo Articulo: " + this.articulo.getCodigo() + "\n" 
             + "Descripcion Articulo: " + this.articulo.getDescripcion() + "\n"
             + "Cantidad: " + this.cantidad + "\n" 
             + "Pvp Articulo: " + String.valueOf(this.articulo.getPvpVenta())  + "\n"
             + "Coste envio: " + String.valueOf(this.articulo.getGastosEnvio()) + "\n"
             + "Pvp Total: " + String.valueOf(cantidad*this.articulo.getPvpVenta());           
             
             
            
    }   
}
