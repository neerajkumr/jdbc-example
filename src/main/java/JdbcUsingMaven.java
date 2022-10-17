import java.sql.*;
import java.util.Scanner;

public class JdbcUsingMaven {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		
		PreparedStatement ps=conn.prepareStatement("insert into student_details values(?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter which to execute ");
		int select =sc.nextInt();
		String name;
		int age,id;
	while(select==1) {
		System.out.println("Enter name, age, id");
		name=sc.next();
		age=sc.nextInt();
		id=sc.nextInt();
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, id);
		ps.execute();
		System.out.println("Data inserted!!!");
		break;
	}
	while(select==2) {
		System.out.println("Enter name for which to update the age");
		name=sc.next();
		System.out.println("Enter age to update");
		age=sc.nextInt();
		PreparedStatement ps1=conn.prepareStatement("update student_details set age=? where stu_name=?");
		ps1.setInt(1,age);
		ps1.setString(2,name);
		ps1.execute();
		break;
	}
	
		ResultSet rt=ps.executeQuery("SELECT * FROM STUDENT_DETAILS");
		while(rt.next()) {
			System.out.println(rt.getString(1)+" "+rt.getInt(2)+" "+rt.getInt(3));
		}
		conn.close();
		sc.close();
	}

}
