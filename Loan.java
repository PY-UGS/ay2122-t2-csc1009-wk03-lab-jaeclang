import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.Math;

public class Loan {
    private double annualInterestRate;
    private double loanAmount;
    private Date loanDate;
    private int numberOfYears;

    // DEFAULT Loan Constructor
    public Loan(){
        this.annualInterestRate = 2.5;
        this.loanAmount = 100;
        this.loanDate = new Date();
        this.numberOfYears = 1;
    }
    // SPECIFIED Loan Constructor
    public Loan(double annualInterestRate, double loanAmount, int numberOfYears){
        this.annualInterestRate = annualInterestRate;
        this.loanAmount = loanAmount;
        this.numberOfYears = numberOfYears;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public int getNumberOfYears(){
        return numberOfYears;
    }
    public double getLoanAmount(){
        return loanAmount;
    }
    public Date getLoanDate() {
        return loanDate;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    public double getMonthlyPayment(){
        double l_amount = getLoanAmount();
        double i_rate = getAnnualInterestRate()/12/100;
        int num_years = getNumberOfYears();
        double monthlyPayment = (l_amount * i_rate) / (1 - (1/Math.pow(1+i_rate, num_years*12)));
        return monthlyPayment;
    }
    public double getTotalPayment(){
        double m_payment = getMonthlyPayment();
        int num_years = getNumberOfYears();
        double totalPayment = m_payment * num_years * 12;
        return totalPayment;
    }

    public static void main(String[] args){
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        Scanner input = new Scanner(System.in);
        double a_i_rate = input.nextDouble();

        System.out.print("Enter number of years as an integer: ");
        // Scanner input = new Scanner(System.in);
        int num_years = input.nextInt();

        System.out.print("Enter loan amount, for example, 120000.95: ");
        // Scanner loan_input = new Scanner(System.in);
        double loan_amount = input.nextDouble();
        input.close();

        Loan loan1 = new Loan();
        loan1.setAnnualInterestRate(a_i_rate);
        loan1.setNumberOfYears(num_years);
        loan1.setLoanAmount(loan_amount);

        Date created_date = loan1.getLoanDate();

        String data_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
        SimpleDateFormat date_string = new SimpleDateFormat(data_pattern);
        String date = date_string.format(created_date);
        System.out.println("The loan was created on " + date);

        double monthly_payment = loan1.getMonthlyPayment();
        double total_payment = loan1.getTotalPayment();

        String monthly_string = String.format("The monthly payment is %.2f", monthly_payment);
        String total_string = String.format("The total payment is %.2f", total_payment);

        System.out.println(monthly_string);
        System.out.println(total_string);
    }
}
