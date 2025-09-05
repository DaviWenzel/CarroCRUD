package maven;

import java.sql.*;
import java.util.*;

public class CarroDAO extends DAO {

    public CarroDAO() {
        super();
        conectar();
    }

    public boolean insert(Carro carro) {
        String sql = "INSERT INTO carro (ano, potencia, modelo, placa, marca) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, carro.getAno());
            ps.setInt(2, carro.getPotencia());
            ps.setString(3, carro.getModelo());
            ps.setString(4, carro.getPlaca());
            ps.setString(5, carro.getMarca());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Carro selectByPlaca(String placa) {
        String sql = "SELECT * FROM carro WHERE placa = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Carro(
                        rs.getInt("ano"),
                        rs.getInt("potencia"),
                        rs.getString("modelo"),
                        rs.getString("placa"),
                        rs.getString("marca")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Carro> selectByModelo(String modelo) {
        String sql = "SELECT * FROM carro WHERE modelo = ?";
        List<Carro> carros = new LinkedList<>();
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, modelo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               carros.add(new Carro(
                        rs.getInt("ano"),
                        rs.getInt("potencia"),
                        rs.getString("modelo"),
                        rs.getString("placa"),
                        rs.getString("marca")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }
    
    public List<Carro> selectByMarca(String marca) {
        String sql = "SELECT * FROM carro WHERE marca = ?";
        List<Carro> carros = new LinkedList<>();
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, marca);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               carros.add(new Carro(
                        rs.getInt("ano"),
                        rs.getInt("potencia"),
                        rs.getString("modelo"),
                        rs.getString("placa"),
                        rs.getString("marca")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }

    public List<Carro> getAll() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        try (Statement st = conexao.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                carros.add(new Carro(
                        rs.getInt("ano"),
                        rs.getInt("potencia"),
                        rs.getString("modelo"),
                        rs.getString("placa"),
                        rs.getString("marca")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }

    public boolean update(Carro carro) {
        String sql = "UPDATE carro SET ano = ?, potencia = ?, modelo = ?, marca = ? WHERE placa = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, carro.getAno());
            ps.setInt(2, carro.getPotencia());
            ps.setString(3, carro.getModelo());
            ps.setString(4, carro.getMarca());
            ps.setString(5, carro.getPlaca());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String placa) {
        String sql = "DELETE FROM carro WHERE placa = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, placa);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
