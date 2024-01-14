package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "xyzcompany.com";

    public Email(String firstName, String lastName){
        
        this.firstName=firstName;
        this.lastName=lastName;
        
        //set department
        this.department=setDepartment();
        
        
        //generate password
        this.password=randomPassword(defaultPasswordLength);
        
        
        //generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
    }
    
    //set department
    private String setDepartment(){
        System.out.print("New Worker: "+ firstName +"\nDeaprtment Codes: \n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none \n Enter Code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if(deptChoice == 1){return "sales";}
        else if(deptChoice == 2){return "dev";}
        else if(deptChoice == 3){return "accounting";}
        else {return "";}
    }
    
    //generate a random password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password=new char[length];
        for (int i = 0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //set mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //returns mailbox capacity
    public int getMailBoxCapacity(){return mailboxCapacity;}


    //set the alternate email
    public void setAltEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    //returns alternate email
    public String getAlternateEmail(){return alternateEmail;}


    //change the password
    public void changePasssword(String password){
        this.password=password;
    }

    //returns password
    public String getPassword(){return password;}
 
    
    //displays info
    public String showInfo(){
        return "Display Name: "+ firstName + " " + lastName +
               "\nCompany Email: " + email +
               "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
