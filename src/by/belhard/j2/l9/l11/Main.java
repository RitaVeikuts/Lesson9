package by.belhard.j2.l9.l11;

import java.sql.*;

public class Main {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot1";
    private static final String URL = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";


    public static void main(String[] args) {

        try{
            Class.forName(DRIVER_NAME);
            } catch (ClassNotFoundException e) {
            System.out.println(DRIVER_NAME + " loading failure");
            return;
        }

        Connection connection;

        try {
             connection = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement statement = connection.createStatement();

            String query = "select * from employees e" +
                            "left join specialties s on (e.specialty_id = s.id;)";
            statement.executeQuery(query);



          // statement.execute("insert into employees values (null, 'Bruce', null, 150, current_date)");
          /*int result = statement.executeUpdate("delete from employees where name = 'Bruce'");*/

         /*   ResultSet result = statement.executeQuery(
                    "select e.id as id, name, specialty, salary, date_of_employment as date from employees e join specialties s on (e.specialty_id = s.id) order by e.id;");
            System.out.println(result + "row(s) affected");
            statement.execute("insert into employees values (null, 'Bruce', null, 150, current_date)");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
