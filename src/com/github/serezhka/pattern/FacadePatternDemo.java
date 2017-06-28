package com.github.serezhka.pattern;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 * This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.
 * <p>
 * This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
 *
 * @author Sergei Fedorov (sergei.fedorov@t-systems.ru)
 * @since 28.06.2017
 */
public class FacadePatternDemo {
    private static class WelcomeToBank {
        public WelcomeToBank() {
            System.out.println("Welcome to Bank!");
        }
    }

    private static class AccountNumberChecker {
        private final int validAccountNumber = 12345678;

        public boolean check(int accountNumber) {
            return validAccountNumber == accountNumber;
        }
    }

    private static class SecurityCodeChecker {
        private final int validSecurityCode = 12345;

        public boolean check(int securityCode) {
            return validSecurityCode == securityCode;
        }
    }

    private static class FundsChecker {
        private double cash = 100.00;

        public boolean makeWithdraw(double cash) {
            if (this.cash >= cash) {
                this.cash -= cash;
                System.out.println("Withdraw complete! Balance: " + this.cash);
                return true;
            } else {
                System.out.println("Not enough cash! Balance: " + this.cash);
                return false;
            }
        }

        public boolean makeDeposit(double cash) {
            this.cash += cash;
            System.out.println("Deposit complete! Balance: " + this.cash);
            return true;
        }
    }

    private static class BankAccountFacade {
        private final int accountNumber;
        private final int securityCode;

        private final WelcomeToBank welcomeToBank;
        private final AccountNumberChecker accountNumberChecker;
        private final SecurityCodeChecker securityCodeChecker;
        private final FundsChecker fundsChecker;

        private BankAccountFacade(int accountNumber, int securityCode) {
            this.accountNumber = accountNumber;
            this.securityCode = securityCode;
            welcomeToBank = new WelcomeToBank();
            accountNumberChecker = new AccountNumberChecker();
            securityCodeChecker = new SecurityCodeChecker();
            fundsChecker = new FundsChecker();
        }

        public void makeWithdraw(double cash) {
            if (accountNumberChecker.check(accountNumber) && securityCodeChecker.check(securityCode) && fundsChecker.makeWithdraw(cash)) {
                System.out.println("Transaction complete!\n");
            } else {
                System.out.println("Transaction failed!\n");
            }
        }

        public void makeDeposite(double cash) {
            if (accountNumberChecker.check(accountNumber) && securityCodeChecker.check(securityCode) && fundsChecker.makeDeposit(cash)) {
                System.out.println("Transaction complete!\n");
            } else {
                System.out.println("Transaction failed!\n");
            }
        }
    }

    public static void main(String[] args) {
        BankAccountFacade facade = new BankAccountFacade(12345678, 12345);
        facade.makeWithdraw(50.00);
        facade.makeWithdraw(100.00);
        facade.makeDeposite(200.00);
    }
}
