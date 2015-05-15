package Hw14_4;

public class IllArgExp  {

    /**設定illeage arguement exception 的條件**/
public static void main(String[] args)  {
    try {
        new NewLoan(7.5, 30, 100000);
        NewLoan m = new NewLoan(-1, 3, 3);
        new NewLoan(7.5, 30, 20000);
      }
      catch (Exception ex) {
        System.out.println(ex);
      }

      System.out.println("End of program");
    }
}

     /**class NewLoan**/
  class NewLoan {
    private double annualInterestRate;
    private int numOfYears;
    private double loanAmount;

    /**預設建構子 constructor */
    public NewLoan() {
      this(7.5, 30, 100000);
    }

    /** NewLoan 的建構子 */
    public NewLoan(double annualInterestRate, int numOfYears,
      double loanAmount) {
      if (annualInterestRate <= 0)
        throw new IllegalArgumentException("年利率必須大於零");
      if (numOfYears <= 0)
        throw new IllegalArgumentException("年數必須大於零");
      if (loanAmount <= 0)
        throw new IllegalArgumentException("貸款金額必須大於零");
      setAnnualInterestRate(annualInterestRate);
      setNumOfYears(numOfYears);
      setLoanAmount(loanAmount);
    }

    /**傳回年利率 */
    public double getAnnualInterestRate() {
      return annualInterestRate;
    }

    /** 設定新的年利率*/
    public void setAnnualInterestRate(double annualInterestRate) {
      if (annualInterestRate <= 0)
        throw new IllegalArgumentException("年利率必須大於零");
      this.annualInterestRate = annualInterestRate;
    }

    /** 傳回年數 */
    public int getNumOfYears() {
      return numOfYears;
    }

    /** 設ˇ應新的年數 */
    public void setNumOfYears(int numOfYears) {
      if (numOfYears <= 0)
        throw new IllegalArgumentException("年數必須大於零");
      this.numOfYears = numOfYears;
    }

    /** 傳回貸款金額 */
    public double getLoanAmount() {
      return loanAmount;
    }

    /** 訂新的貸款金額 */
    public void setLoanAmount(double loanAmount) {
      if (loanAmount <= 0)
        throw new IllegalArgumentException("貸款金額必須大於零");
      this.loanAmount = loanAmount;
    }

    /** 計算每月攤還 */
    public double monthlyPayment() {
      double monthlyInterestRate = annualInterestRate / 1200;
      return loanAmount * monthlyInterestRate / (1 -
        (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
    }

    /** 計算總攤還金額 */
    public double totalPayment() {
      return monthlyPayment() * numOfYears * 12;
    }
  }
