package ferreteria.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

  @Id
  @Column(name = "clave")
  private Integer clave;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "precio_compra")
  private Double precioCompra;

  @Column(name = "existencias")
  private Integer existencias;

  @Column(name = "tipo_unidad")
  private String tipoUnidad;

  public Producto() {
    // Constructor sin parámetros necesario para Hibernate
  }

  public Producto(Integer clave, String nombre, String descripcion, Double precioCompra, Integer existencias, String tipoUnidad) {
    this.clave = clave;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.existencias = existencias;
    this.tipoUnidad = tipoUnidad;
  }

  public Integer getClave() {
    return clave;
  }

  public void setClave(Integer clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(Double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public Integer getExistencias() {
    return existencias;
  }

  public void setExistencias(Integer existencias) {
    this.existencias = existencias;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }

  public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }

  public boolean venderProducto() {
    if(getExistencias() >= 1) {
      setExistencias(getExistencias() - 1);
      return true;
    }
    return false;
  }
}
