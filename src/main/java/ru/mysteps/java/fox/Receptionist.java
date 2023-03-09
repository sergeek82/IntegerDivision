package ru.mysteps.java.fox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptionist {

    private static final Logger logger = Logger.getLogger(DivisionData.class.getName());

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int divisor, divisible;
            System.out.println("type divisible number");
            divisible = Integer.parseInt(reader.readLine());
            System.out.println("type divisor number");
            divisor = Integer.parseInt(reader.readLine());
            System.out.println(new Facade(new Calculator(),new Assembler())
                .divide(divisible, divisor));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Something went wrong while console reading", e);
        }
    }
}