package com.com.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jainish on 10-03-2017.
 */
 class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }

    static List<PetrolPump> getAll(int[] petrol, int[] distance) {
        List<PetrolPump> petrolPumps = new ArrayList<PetrolPump>(distance.length);

        for (int i = 0; i < distance.length; i++) {
            petrolPumps.add(new PetrolPump(petrol[i], distance[i]));
        }

        return petrolPumps;
    }
}

public class CalculatePath {
    public static void main(String[] args) {

        int petrol[] = { 1, 3, 4, 4, 1 };
        int distance[] = { 1, 4, 2, 2, 2 };

        petrol = new int[] { 4, 6, 7, 4 };
        distance = new int[] { 6, 5, 3, 5 };
        List<PetrolPump> petrolPumps = PetrolPump.getAll(petrol, distance);

        int start = 0;
        int end = petrol.length;

        int remainingPetrol = 0;

        do {
            remainingPetrol += petrolPumps.get(start).petrol - petrolPumps.get(start).distance;

            if (remainingPetrol < 0) {
                remainingPetrol = 0;
                end = start;
            }

            start++;
            if (start >= petrol.length) {
                start = 0;
            }
        } while (start != end);

        System.out.println(end + 1);
    }
}



