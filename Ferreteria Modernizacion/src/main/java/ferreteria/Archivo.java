/* 
 * Copyright (C) 2017 Carlos Olivo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ferreteria;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ferreteria.Modelo.Producto;
import ferreteria.Modelo.Venta;
import ferreteria.Persistencia.Producto.ProductoRepositorio;
import ferreteria.Persistencia.Venta.VentaRepositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase que lleva el control de Archivos.
 * 
 * @author Carlos Olivo
 * @version 0.1
 * @param <T> Tipo de elementos a guardar.
 */
public class Archivo<T> {
  
  private ProductoRepositorio productoRepositorio;
  private VentaRepositorio ventaRepositorio;


  public Archivo() {
    productoRepositorio = new ProductoRepositorio();
    ventaRepositorio = new VentaRepositorio();
  }
  

  public void guardarProductos(ObservableList<Producto> lista) {
    try {
      productoRepositorio.guardar(lista);
    } catch(Exception e) {
      System.err.println("ERROR: " + e.getLocalizedMessage());
    }
  }

  public void guardarVentas(ObservableList<Venta> lista) {
    try {
      ventaRepositorio.guardar(lista);
    } catch(Exception e) {
      System.err.println("ERROR: " + e.getLocalizedMessage());
    }
  }
  

  public ObservableList<Producto> cargarProductos() {
    ObservableList<Producto> productos = FXCollections.observableArrayList();
    try {
      productos = productoRepositorio.obtenerTodos();
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getLocalizedMessage());
    }
    return productos;
  }


  public ObservableList<Venta> cargarVentas() {
    ObservableList<Venta> ventas = FXCollections.observableArrayList();
    try {
      ventas = ventaRepositorio.obtenerTodos();
    } catch (Exception e) {
      System.err.println("ERROR: " + e.getLocalizedMessage());
    }
    return ventas;
  }
}
