package ferreteria.Persistencia.Producto;

import ferreteria.Modelo.Producto;
import ferreteria.Persistencia.ConexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoDAO {

    public void guardar(ObservableList<Producto> productos) {
        Transaction transaction = null;
        try (Session session = ConexionBD.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (Producto producto : productos) {
                // Verificar si el producto ya existe
                Producto existingProducto = session.get(Producto.class, producto.getClave());
                if (existingProducto != null) {
                    session.merge(producto);  // Actualizar el producto existente
                } else {
                    session.save(producto);  // Guardar el nuevo producto
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ObservableList<Producto> obtenerTodos() {
        List<Producto> listaProductos = null;
        try (Session session = ConexionBD.getSessionFactory().openSession()) {
            listaProductos = session.createQuery("from Producto", Producto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FXCollections.observableList(listaProductos);
    }

}
