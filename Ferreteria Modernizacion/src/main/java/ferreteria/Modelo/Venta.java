package ferreteria.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import static ferreteria.Util.obtenerFechaActual;
import static ferreteria.Util.redondear;

@Entity
@Table(name = "venta")
public class Venta {

  @Id
  @Column(name = "folio")
  private Integer folio;

  @Column(name = "fecha")
  private String fecha;

  @Column(name = "productos")
  private String productos;

  @Column(name = "cantidad")
  private Integer cantidad;

  @Column(name = "subtotal")
  private Double subtotal;

  @Column(name = "iva")
  private Double iva;

  @Column(name = "total")
  private Double total;

  public Venta() {
    this.folio = 0;
    this.fecha = obtenerFechaActual();
    this.productos = "";
    this.cantidad = 0;
    this.subtotal = 0.0;
    this.iva = 0.0;
    this.total = 0.0;
  }

  public Venta(int folio, String productos, int cantidad, double subtotal, double iva) {
    this.folio = folio;
    this.fecha = obtenerFechaActual();
    this.productos = productos;
    this.cantidad = cantidad;
    this.subtotal = subtotal;
    this.iva = redondear(subtotal * iva);
    this.total = redondear(subtotal + this.iva);
  }

  public int getFolio() {
    return folio;
  }

  public void setFolio(int folio) {
    this.folio = folio;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getProductos() {
    return productos;
  }

  public void setProductos(String productos) {
    this.productos = productos;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public double getIVA() {
    return iva;
  }

  public void setIVA(double iva) {
    this.iva = iva;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
