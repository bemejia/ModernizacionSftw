package ferreteria.Persistencia.Venta;

import ferreteria.Modelo.Producto;
import ferreteria.Modelo.Venta;
import ferreteria.Persistencia.Producto.ProductoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class VentaRepositorio {

    private VentaDAO ventaDAO;

    public VentaRepositorio() {
        ventaDAO = new VentaDAO();
    }
    public VentaDAO getVentaDAO() {
        return ventaDAO;
    }

    public ObservableList<Venta> obtenerTodos() {
        List<Venta> ventaList = ventaDAO.obtenerTodos();
        return FXCollections.observableList(ventaList);
    }

    public void guardar(ObservableList<Venta>  venta) {
        ventaDAO.guardar(venta);
    }
}
