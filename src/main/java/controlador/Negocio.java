package controlador;

import modelo.*;
import java.util.*;
import java.sql.*;
import INterfaces.InterFac;
import util.MySQLConexion;

public class Negocio implements InterFac {

    @Override
    public List<Articulo> lisArt() {
        List<Articulo> lis = new ArrayList<>();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT Art_cod, art_nom,Art_pre from articulos";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Articulo a = new Articulo();
                a.setCoda(rs.getString(1));
                a.setNoma(rs.getString(2));
                a.setPuni(rs.getDouble(3));
                lis.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;

    }

    @Override
    public List<Resumen> lisMes(int an) {
        List<Resumen> lis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call spmes(?)} ";
            CallableStatement st = conn.prepareCall(sql);
            st.setInt(1, an);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Resumen a = new Resumen();
                a.setMes(rs.getInt(1));
                a.setCantidad(rs.getInt(2));
                a.setTotal(rs.getDouble(3));
                lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e2) {

            }
        }

        return lis;

    }
}
