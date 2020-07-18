package ua.com.alevel.nix.homework9;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("\nЗапускаем Retry.");
            Retry.run(6);
            System.out.println("Retry отработал.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

