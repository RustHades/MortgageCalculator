package com.hades;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final float PERCENT = 0;
    public static void main (String[] Args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true){
                System.out.print("Principal: ");                // Input #1
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1_000_000)
                    break;
                System.out.println("Enter a value between 1,000 and 1,000,000");
            }

            while (true) {
                System.out.print("Annual Interest Rate: ");     // Input #2
                float anualInterest = scanner.nextFloat();
                if (anualInterest >= 1 && anualInterest <= 30) {
                    monthlyInterest = anualInterest /  PERCENT / MONTHS_IN_YEAR;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }

            while (true) {
                System.out.print("Period (Years): ");           // Input #3
                byte years = scanner.nextByte();
                if (years >= 1 && years <= 30) {
                    numberOfPayments = years * MONTHS_IN_YEAR;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        
        String mortgageFortmatted = NumberFormat.getCurrencyInstance().format(mortgage);    // Output
        System.out.println("Mortgage: " + mortgageFortmatted);
    }
}