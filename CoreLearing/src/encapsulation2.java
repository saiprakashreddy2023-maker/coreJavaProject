class machine {
    private String AccountholderName;
    private int Deposit;
    String BankName="Axis banak";

    {
        System.out.println("ACCOUNT DETAILS");
    }

    public void setDeposit(int deposit) {
        Deposit = deposit;
    }

    public int getDeposit() {
        return Deposit;
    }

    public void setAccountholderName(String accountholderName) {
        AccountholderName = accountholderName;
    }

    public String getAccountholderName() {
        return AccountholderName;
    }

    public void withdraw(int amount) {
        if (amount <= Deposit) {
            Deposit = Deposit - amount;


                System.out.println("withdraw successfull:" + amount);
            }else{
                System.out.println("invalid balance");
            }
        }
    }

    public class encapsulation2 {
        public static void main(String[] args) {
            machine m = new machine();
            m.setAccountholderName("sai");
            m.setDeposit(1000);
            {
                System.out.println("bank name:"+m.BankName);
                System.out.println("Holder mame:" + m.getAccountholderName());
                System.out.println("Deposit balance:" + m.getDeposit());
                m.withdraw(1000);
                System.out.println("remaing balance:" + m.getDeposit());
            }
        }
    }

