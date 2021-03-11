package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> startPole;
    static Stack<Integer> midPole;
    static Stack<Integer> endPole;
    static int count;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press a number. Anything over 20 will take a looong time.");

        while (scan.hasNext()){
            count = 0;
            int n = scan.nextInt();
            setup(n);
            printTowers();
            towerOfHanoi(n,startPole, endPole, midPole);
            System.out.println("There were " + count + " moves.\nPress a number. Anything over 20 will take a looong time.");
        }

    }

    static void setup(int n) {
        startPole = new Stack<>();
        midPole = new Stack<>();
        endPole = new Stack<>();

        for (int i = n; i >= 1; i--) {
            startPole.push(i);
        }
    }

    static void towerOfHanoi(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> helper) {

        if (n == 1) {
            move(from, to);
            return;
        }

        towerOfHanoi(n - 1, from, helper, to);
        move(from, to);

        towerOfHanoi(n - 1, helper, to, from);

    }

    static void move (Stack<Integer> from, Stack<Integer> to) {
        var disk = from.pop();
        to.push(disk);
        printTowers();
        count++;
    }

    static void printTowers() {
        System.out.println(startPole.toString());
        System.out.println(midPole.toString());
        System.out.println(endPole.toString());
        System.out.println("\n");
    }

}



