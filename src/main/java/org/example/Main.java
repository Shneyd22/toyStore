package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Toy> toys = new ArrayList<>();
        ArrayDeque<Toy> prizeQueue = new ArrayDeque<>();
        Toy bear = new Toy(1, "Мишка", 5);
        Toy robot = new Toy(2, "Робот", 3);
        Toy doll = new Toy(3, "Кукла", 2);
        toys.add(bear);
        toys.add(robot);
        toys.add(doll);
        prizePoolCreator(toys, prizeQueue);
        System.out.println(prizeQueue);
        prizeIssuanceFileCreator(prizeQueue);

    }
    public static void prizePoolCreator(ArrayList<Toy> toys, ArrayDeque<Toy> prizeQueue){
        ArrayList<Toy> prizePool = new ArrayList<>();
        for (Toy toy: toys) {
            for (int i = 0; i < toy.quantity; i++) {
                prizePool.add(toy);
            }
        }
        Collections.shuffle(prizePool);
        for (Toy prize: prizePool) {
            prizeQueue.add(prize);
        }
    }

    public static void prizeIssuanceFileCreator(ArrayDeque<Toy> prizeQueue) throws Exception{
        File file = new File("prizeIssuance.txt");
        while (prizeQueue.peek()!=null){
            Toy e = prizeQueue.remove();
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter("prizeIssuance.txt", false);
                fileWriter.write("id: " + e.id +
                        ", name: " + e.name +
                        ", quantity: " + e.quantity);
                fileWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter("prizeIssuance.txt", true);
                fileWriter.write("\n" +
                        "id: " + e.id +
                        ", name: " + e.name +
                        ", quantity: " + e.quantity);
                fileWriter.close();
                }
            }
        }
    }



