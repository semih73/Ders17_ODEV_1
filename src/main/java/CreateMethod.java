import java.sql.*;

public class CreateMethod {
    public void create ()
    {
        String url = "jdbc:mysql://localhost:3306/sys";
        String kullaniciadi = "root";
        String sifre = "123456";
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        //ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, kullaniciadi, sifre);
            String ekle = "INSERT INTO tablo (id, Ad, Soyad) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(ekle);
            preparedStatement.setString(1, "3");
            preparedStatement.setString(2, "İrem");
            preparedStatement.setString(3, "Dinler");

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows>0) {
                System.out.println("Veri eklendi.");
            }else {
                System.out.println("Veri eklenemedi.");

                preparedStatement.close();
                connection.close();
            }
        } catch(
            SQLException e) {
        e.printStackTrace();
    }
    }
}

