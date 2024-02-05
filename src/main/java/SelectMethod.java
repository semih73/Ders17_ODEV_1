import java.sql.*;

public class SelectMethod {
    public  void select () {
        String url = "jdbc:mysql://localhost:3306/sys";
        String kullaniciadi = "root";
        String sifre = "123456";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, kullaniciadi, sifre);
            String adi = "Semih";
            String soyadi = "Dinler";
            String sqlSorgusu = "SELECT * FROM tablo WHERE ad = ? AND soyad = ?";
            preparedStatement = connection.prepareStatement(sqlSorgusu);

            preparedStatement.setString(1, adi);
            preparedStatement.setString(2, soyadi);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");

                System.out.println("ID: " + id + ", Ad: " + ad + ", Soyad: " + soyad);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
