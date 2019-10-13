package org.fenix.ug;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Benjamin E Ndugga
 */
public class Main {

    public static void main(String[] args) {
        //get_days_of_power(1000, 3, 500, 10, 1500, 7, 21000);
        //get_days_of_power(3000, 3, 500, 10, 1500, 7, 700000);
        //get_days_of_power(1300, 0, 500, 0, 1500, 7, 10000);
        get_days_of_power(10000, 3, 500, 10, 1500, 7, 11000);
    }

    /**
     * computes the days of power for a based on the the number of loans [R,D]
     * for a given payment K. Assumption is that you have a maximum of 3 loans.
     * orders the loans based on the days the loan starts running.
     *
     * @param R1 given rate for loan1
     * @param D1 daily rate for loan1
     * @param R2 given rate for loan2
     * @param D2 daily rate for loan2
     * @param R3 given rate for loan3
     * @param D3 daily rate for loan3
     * @param K the amount payed
     * @return the total days of power for these 3 loans
     */
    public static int get_days_of_power(int R1, int D1, int R2, int D2, int R3, int D3, int K) {
        int accountBalance = K;
        int total_days_of_power = 0;

        ArrayList<Loan> loans = new ArrayList<>();

        loans.add(new Loan(R1, D1));
        loans.add(new Loan(R2, D2));
        loans.add(new Loan(R3, D3));

        //sort these loans based on the the start days 
        Collections.sort(loans);
        System.out.println("Amount Paid: " + K + "/-");
        System.out.println("Taking Customer loans in the order: " + loans + "\n");

        //pick the loan that starts running first
        Loan loan1 = loans.get(0);
        Loan loan2 = loans.get(1);
        Loan loan3 = loans.get(2);

        //check the current balance Value if is above rate for the day
        if (accountBalance > loan1.getDailyRate() && loan1.getStartsInDays() > 0) {
            System.out.println("Computing Days of Lighting: " + loan1);
            //proceed to compute the days of power and adjust balance
            int charge_for_loan1 = 0;
            int days_of_power_loan1 = 0;

            for (int i = loan1.getStartsInDays(); i < loan2.getStartsInDays(); i++) {
                charge_for_loan1 += loan1.getDailyRate();
                total_days_of_power += 1;
                days_of_power_loan1 += 1;

                //update the current balance for this lighting
                accountBalance -= charge_for_loan1;

                //check if the account balance has fallen below rate and break
                if (accountBalance < loan1.getDailyRate()) {
                    break;
                }

            }
            System.out.println("Charge for loan1: " + charge_for_loan1 + "/-");

            //accountBalance -= charge_for_loan1;
            System.out.println("Current account balance after loan1 : " + accountBalance + "/-");
            System.out.println("Days of Power: " + days_of_power_loan1);
            System.out.println("Total Days of Power after loan1 : " + total_days_of_power);
        }

        if (accountBalance > loan2.getDailyRate() && loan2.getStartsInDays() > 0) {
            System.out.println();
            System.out.println("Computing Days of Lighting: " + loan2);
            //proceed to compute the days of powe and adjust balance
            int charge_for_loan2 = 0;
            int days_of_power_loan2 = 0;

            for (int i = loan2.getStartsInDays(); i < loan3.getStartsInDays(); i++) {
                //System.out.println(i);
                charge_for_loan2 += loan2.getDailyRate();
                total_days_of_power += 1;
                days_of_power_loan2 += 1;

                //update the current balance for this lighting
                accountBalance -= charge_for_loan2;

                //check if the account balance has fallen below rate and break
                if (accountBalance < loan2.getDailyRate()) {
                    break;
                }

            }
            System.out.println("Charge for loan2: " + charge_for_loan2 + "/-");

            //accountBalance -= charge_for_loan2;
            System.out.println("Current account balance after loan2: " + accountBalance + "/-");
            System.out.println("Days of Power: " + days_of_power_loan2);
            System.out.println("Total Days of Power after loan2: " + total_days_of_power);

        }

        //compute days of power for loan3 if the account balance is sufficient
        if (accountBalance > loan3.getDailyRate() && loan3.getStartsInDays() > 0) {
            System.out.println();
            System.out.println("Computing Days of Lighting: " + loan3);
            int charge_for_loan3 = accountBalance;
            System.out.println("Charge for loan2: " + charge_for_loan3 + "/-");
            int days_of_power_loan3 = (accountBalance / loan3.getDailyRate());
            total_days_of_power += days_of_power_loan3;
            System.out.println("Current account balance after loan3: " + (accountBalance -= charge_for_loan3) + "/-");
            System.out.println("Days of Power: " + days_of_power_loan3);
            System.out.println("Total Days of Power after loan3: " + total_days_of_power);
        }
        System.out.println();
        System.out.println("Total Computed Days of Power: " + total_days_of_power);
        return total_days_of_power;

    }

    private static class Loan implements Comparable<Loan> {

        private int dailyRate;
        private int startsInDays;

        public Loan(int dailyRate, int startsInDays) {
            this.dailyRate = dailyRate;
            this.startsInDays = startsInDays;
        }

        public int getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(int dailyRate) {
            this.dailyRate = dailyRate;
        }

        public int getStartsInDays() {
            return startsInDays;
        }

        public void setStartsInDays(int startsInDays) {
            this.startsInDays = startsInDays;
        }

        @Override
        public String toString() {
            return "Loan{" + "dailyRate=" + dailyRate + ", startsInDays=" + startsInDays + '}';
        }

        /**
         * sorts loans based on the startsInDays
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Loan o) {

            if (getStartsInDays() == o.getStartsInDays()) {
                return 0;
            } else if (getStartsInDays() < o.getStartsInDays()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
