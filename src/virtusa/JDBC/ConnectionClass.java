package virtusa.JDBC;
import java.sql.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection on = DriverManager.getConnection("jdbc:mysql://localhost/ri_db", "test", "test123");
            Statement st = on.createStatement();
            String sql = "insert into STUDENT(id,name,average-marks) values(?,?,?)";
            PreparedStatement pst = on.prepareStatement(sql);
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= n; i++) {
                pst.setInt(1, in.nextInt());
                in.nextLine();
                pst.setString(2, in.nextLine());
                pst.setInt(3, in.nextInt());
                pst.executeUpdate();
            }
            sql = "select * from STUDENT";
            ResultSet r = st.executeQuery(sql);
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                int average_marks = r.getInt("average_marks");
                System.out.println(id + " " + name + " " + average_marks);
            }
            r.close();
            st.close();
            on.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}