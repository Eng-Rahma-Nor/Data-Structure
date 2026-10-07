import java.util.Date;

public class loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public loan() {
        this(2.5, 1, 1000);
    }

    public loan(double rate, int years, double amount) {
        annualInterestRate = rate;
        numberOfYears = years;
        loanAmount = amount;
        loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int years) {
        numberOfYears = years;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double amount) {
        loanAmount = amount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public double getMonthlyPayment() {
        double monthlyRate = annualInterestRate / 1200;
        int payments = numberOfYears * 12;

        return (loanAmount * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -payments));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}