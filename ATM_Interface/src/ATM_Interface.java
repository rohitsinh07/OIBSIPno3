import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM_Interface{
    static int userId = 7319;
    static int userPin = 7319;
    static int noTrial = 5;
    static int TotalBalance=400000;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> arr=new ArrayList<String>();
    static String Str;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();
    //Adding transaction record to arrayList

    public static void record(String str){

        arr.add(str);
    }
    //Show transaction record from arrayList by foreach loop

    public static void Transactionrecord(){
        for(String his:arr){
            System.out.println(his);
        }
        System.out.println();
    }
    //check user details and give them maximum trials

    public static void verifyingUserPinAndId() {
        if (noTrial >= 0) {

            System.out.print("Enter your user id -- :");
            int cUserId = sc.nextInt();


            if (userId == cUserId) {
                System.out.print("Enter your user pin --");
                int cUserPin = sc.nextInt();
                if (userPin == cUserPin) {
                    Main();
                } else {
                    System.out.println("Entered pin is wrong");
                    noTrial--;
                    verifyingUserPinAndId();
                }
            }
            else {
                System.out.println("Entered userid is wrong");
                noTrial--;
                verifyingUserPinAndId();
            }

        }
        else{
            System.out.println("You are been blocked by the System. Please visit at your nearest bank branch");
        }
    }
    //For Withdrawal of money
    public static void  Withdrawal(){
        System.out.print("Enter amount to be withdrawn: ");
        int withdrawAmount=sc.nextInt();
        System.out.print("Enter your user pin");
        int cUserPin = sc.nextInt();
        if(cUserPin==userPin){
            if(withdrawAmount<TotalBalance-2000){
                TotalBalance=TotalBalance-withdrawAmount;
                System.out.println("--------- WITHDRAWAL SUCCESSFUll ---------");
                System.out.println("*************Remaining balance: "+"'"+TotalBalance+"' " +"******");
                Str= formatter.format(date)+"  WITHDRAW             "+ "'-"+withdrawAmount+"'  '"+TotalBalance+"'";
                // saving transaction history
                record(Str);
            }
            else{
                System.out.println("ohhh ! The entered amount is out of your  balance");
            }
        }
        else  {
            System.out.println("Entered pin is wrong" );
        }
        System.out.println("--------------------------------------------");

    }
    //For Depositing the money
    public static void Deposits(){
        System.out.println("Enter amount you want to deposit");
        int depositAmount=sc.nextInt();
        TotalBalance=TotalBalance+depositAmount;
        System.out.println("-------- DEPOSITED SUCCESSFULl --------");
        System.out.println("----Total Balance "+"'"+TotalBalance+"' "+"----------");
        System.out.println("------------------------");
        Str= formatter.format(date)+"  DEPOSIT             "+ "'+"+depositAmount+"'  '"+TotalBalance+"'";
// saving transaction history
        record(Str);
    }
//For money Transfering

    public static void Transfering() {

        System.out.print("Enter the userid to whom you want to transfer : ");
        int transferUserId= sc.nextInt();
        System.out.println("ENTER AMOUNT");
        int transferAmount=sc.nextInt();
        TotalBalance=TotalBalance-transferAmount;
        System.out.println("-------- TRANSFER SUCCESSFUL ---------");
        System.out.println("             Money transfer to user-id : "+transferUserId);
        System.out.println("             Transfer Amount was: "+transferAmount);
        System.out.println("             Total remaining Amount="+TotalBalance);
        System.out.println("--------------------------------------------------");
        Str= formatter.format(date)+"  TRANSFER TO id: "+transferUserId+ " '-"+transferAmount+"'  '"+TotalBalance+"'";
        // saving transaction history
        record(Str);
    }

    public static void Main(){
        boolean run=true;
        while(run){
            int event;
            System.out.println("ENTER 1 FOR WITHDRAWAL ");
            System.out.println("ENTER 2 FOR DEPOSIT ");
            System.out.println("ENTER 3 FOR TRANSFER ");
            System.out.println("ENTER 4 FOR TRANSACTION HISTORY");
            System.out.println("ENTER 5 FOR QUIT");
            event=sc.nextInt();
            switch (event){
                case 1:{
                    Withdrawal();
                    break;
                }
                case 2:{
                    Deposits();
                    break;
                }
                case 3 :{
                    Transfering();
                    break;
                }
                case 4:{
                    Transactionrecord();
                    break;
                }
                case 5:{
                    run=false;
                    break;
                }
                default:{
                    System.out.println(" you have selected wrong option");
                }
            }

        }
    }



    public static void main(String[] args) {
        System.out.println("--------   WELCOME TO ATM   ---------");
        verifyingUserPinAndId();

    }

}