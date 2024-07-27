package ferreteria.Persistencia.Venta;

import ferreteria.Modelo.Producto;
import ferreteria.Modelo.Venta;
import ferreteria.Persistencia.ConexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VentaDAO {

    public void guardar(ObservableList<Venta> ventas) {
        Transaction transaction = null;
        try (Session session = ConexionBD.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (Venta venta : ventas) {
                // Verificar si la venta ya existe
                Venta existingVenta = session.get(Venta.class, venta.getFolio());
                if (existingVenta != null) {
                    session.merge(venta);  // Actualizar la venta existente
                } else {
                    session.save(venta);  // Guardar la nueva venta
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

    public ObservableList<Venta> obtenerTodos() {
        List<Venta> ventaList = null;
        try (Session session = ConexionBD.getSessionFactory().openSession()) {
            ventaList = session.createQuery("from Venta", Venta.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FXCollections.observableList(ventaList);
    }


}
