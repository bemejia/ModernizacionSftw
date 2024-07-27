package ferreteria.Persistencia.Producto;

import ferreteria.Modelo.Producto;
import ferreteria.Persistencia.Producto.ProductoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductoRepositorio {
    private ProductoDAO productoDAO;

    public ProductoRepositorio() {
        productoDAO = new ProductoDAO();
    }
    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public ObservableList<Producto> obtenerTodos() {
        List<Producto> listaProductos = productoDAO.obtenerTodos();
        return FXCollections.observableList(listaProductos);
    }

    public void guardar(ObservableList<Producto>  producto) {
        productoDAO.guardar(producto);
    }

}