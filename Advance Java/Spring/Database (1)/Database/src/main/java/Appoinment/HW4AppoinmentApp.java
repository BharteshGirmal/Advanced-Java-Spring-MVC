package Appoinment;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Beans.DAOJdbcTemplate;

public class HW4AppoinmentApp 
{
	public static void main(String[] args)
	{

		Scanner sc= new Scanner(System.in);

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("Beans","Config");
		context.refresh();

		DAOJdbcTemplate bean=context.getBean(DAOJdbcTemplate.class);

		int ch;
		do
		{
			System.out.println("1.Add Appointment\n"
					+ "2.Update Appointments\n"
					+ "3.Show All Appointments\n"
					+ "4.Show Appointments Of Given User\n"
					+ "5.Quit");
			System.out.println("Enter Your choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
			case 1:
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter the Date(YY-MM-DD)");
				String date = sc.next();
				System.out.println("Enter the Purpose");
				String purpose = sc.next();
				System.out.println("Enter the Reason (Official / Personal)");
				String reason = sc.next();
				System.out.println("Enter the Time");
				String time = sc.next();
				bean.addAppoint(name, date, purpose, reason, time);
				System.out.println("Your Appointment Saved");
				break;
			case 2:
				System.out.println("Enter Name ");
				String name1 = sc.next();
				System.out.println("Enter the Purpose");
				String purpose1 = sc.next();
				bean.updateAppoint(name1, purpose1);
				break;
			case 3:
				bean.showAllAppoint().stream().forEach((p)->{System.out.println(p);});
				break;
			case 4:
				System.out.println("Enter Name : ");
				String name2 = sc.next();
				bean.showAppoint(name2).stream().forEach((p)->{System.out.println(p);});;
				break;
			case 5:
				break;
			default:
				System.out.println("Enter the Valid choice");
				break;

			}
		}while(true);

	}

}
