import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDad implements InterfazDad{
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO libros (titulo, autor) VALUES(?, ?)";

        int rowCont = 0;
        preparedStatem pstm = ConexionSignleton.getInstance("librosDb.db").getConnetion().prepareStatement(sqlInsert);
        pstm.setString(1, ((libro)obj).getTitulo());
        pstm.setString(2, ((libro)obj).getTitulo());
        rowCont = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE libros SET titulo = ?, autor = ? where id = ?; ";

        int rowCont = 0;
        preparedStatem pstm = ConexionSignleton.getInstance("librosDb.db").getConnetion().prepareStatement(sqlUpdate);
        pstm.setString(1, ((libro)obj).getTitulo());
        pstm.setString(2, ((libro)obj).getTitulo());
        pstm.setInt(3, (libro(obj).getId));
        rowCont = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM libros WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnetion().prepareStatemen(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * From libros WHERE id = ? ;";
        ArrayList<libro> resultado = new ArrayList<libro>();


        Statement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        while (rst.next()) {
            libro = new Libro(rst.getInt(1), rst.getString(2), rst.getString(3));

        }
        return resultado;
    }

    @Override
    public Object buscarId(String id) throws SQLException {
        String sql = "SELECT * From libros WHERE id = ? ;";
        Libro libro = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            libro = new Libro(rst.getInt(1), rst.getString(2), rst.getString(3));

        }
            return libro;
        }
    }

