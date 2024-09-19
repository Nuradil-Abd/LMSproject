package lms;

import lms.commands.Runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Runner.run(scan);

    }
}