
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class DatabaseManager{

       DatabaseManager(){}
       public  static Connection con=null;

      public static Connection create () {
           try {


               if (con == null) {

                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital" , "root" ,"22558800");
                   System.out.println("Connection is created  successfully");

               }
           } catch (Exception e) {
               System.out.println("Unable to create a connection at this moment...."+e);
           }

           return  con;
       }




}




class Management {

    Connection con=DatabaseManager.create();
    Scanner input=new Scanner(System.in);


    void addPatient(){


        String pname;
        String add;
        int phone;
        String disease;
        String dt;
        System.out.println("Enter name of patient");
        pname=input.nextLine();
        System.out.println("Enter address of patient");
        add=input.nextLine();
        System.out.println("Enter reason of admit");
        disease=input.nextLine();
        System.out.println("Enter phone number of patient");
        phone=input.nextInt();

        LocalDate d=LocalDate.now();
        dt=d.toString();

        try {

            String q="insert into patient (pname,address , phone , disease , adm_date) values(?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(q);
            st.setString(1,pname);
            st.setString(2,add);
            st.setInt(3,phone);
            st.setString(4,disease);
            st.setString(5,dt);
            st.executeUpdate();
            System.out.println("Data has been recorded");


        }
        catch (Exception e){
            System.out.println("Failed to insert data "+e);
        }



    }


    void showPatients(){


        try {

            String q="select * from patient";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(q);
            System.out.println("\n\t\tPatient's Data");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Pid\t\t\tPname\t\t\taddress\t\t\tphone\t\t\tdisease\t\t\tadm_date\t\tdischarge_date");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            while (res.next()){
                int id=res.getInt("pid");
                String name=res.getString("pname");
                String add=res.getString("address");
                int phone=res.getInt("phone");
                String dis=res.getString("disease");
                String dt= res.getString("adm_date");
                String dt2=res.getString("discharge_date");
                System.out.println(id+"\t\t\t"+name+"\t\t\t"+add+"\t\t\t"+phone+"\t\t"+dis+"\t\t\t"+dt+"\t\t"+dt2);

            }



        }
        catch (Exception e){
            System.out.println("Unable to fecth details "+e);
        }


    }

    void updateDoctor(){
        String dname;
        String city;
        int phone;
        String specialization;
        System.out.println("Enter name of doctor");
        dname=input.nextLine();
        System.out.println("Enter city of doctor");
        city=input.next();
        System.out.println("Enter phone number of doctor");
        phone=input.nextInt();
        System.out.println("Enter Specialization");
        specialization=input.next();
        try {

            String q="insert into doctors (dname,city , phone , specialization) values(?,?,?,?)";
            PreparedStatement st=con.prepareStatement(q);
            st.setString(1,dname);
            st.setString(2,city);
            st.setInt(3,phone);
            st.setString(4,specialization);
            st.executeUpdate();
            System.out.println("Data has been recorded");


        }
        catch (Exception e){
            System.out.println("Failed to insert data "+e);
        }




    }


    void showDoctors(){
        try {

            String q="select * from doctors";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(q);
            System.out.println("\n\t\tDoctor's Data");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Did\t\t\tDname\t\t\t\t\t\tcity\t\t\tphone\t\t\tSpecialization");
            System.out.println("--------------------------------------------------------------------------------------");
            while (res.next()){
                int id=res.getInt("did");
                String name=res.getString("dname");
                String city =res.getString("city");
                int phone=res.getInt("phone");
                String sp=res.getString("specialization");
                System.out.println(id+"\t\t\t"+name+"\t\t\t\t"+city+"\t\t"+phone+"\t\t\t"+sp);

            }



        }
        catch (Exception e){
            System.out.println("Unable to fecth details "+e);
        }

    }


    void DischargePatient(){
        int id;
        System.out.println("Enter id of patient:");
        id=input.nextInt();
        LocalDate d=LocalDate.now();
        String dt=d.toString();
        try {

            String q="update patient set discharge_date= ? where pid = ?";
            PreparedStatement st=con.prepareStatement(q);
            st.setString(1,dt);
            st.setInt(2,id);

            st.executeUpdate();
            System.out.println("Patient is Discharged on "+ LocalTime.now());


        }
        catch (Exception e){
            System.out.println("Failed to insert data "+e);
        }

    }





}

public class ManageData {


    public static void main(String[] args) {

           Management m=new Management();
//           m.DischargePatient();
           m.addPatient();


    }
}
