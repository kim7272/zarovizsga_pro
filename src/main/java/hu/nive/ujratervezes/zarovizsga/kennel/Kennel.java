package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();


    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void feedAll() {
        for (Dog dog : dogs){
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        Dog result = null;
        for (Dog dog : dogs){
            if (dog.getName().equals(name)){
                result = dog;
            }
        }
        if (result == null){
            throw new IllegalArgumentException("Invalid parameter!");
        }
        return result;
    }

    public void playWith(String name, int hours) {
        for (Dog dog : dogs){
            if (dog.getName().equals(name)){
                dog.play(hours);
            }
        }
    }

    public List<String> getHappyDogNames(int i) {
        List<String> result =  new ArrayList<>();
        for (Dog dog : dogs){
            if (dog.getHappiness() > i){
                result.add(dog.getName());
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Kennel kennel = new Kennel();
        Beagle beagle = new Beagle("Bigli");
        kennel.addDog(beagle);
        Husky husky = new Husky("Morzsi");
        kennel.addDog(husky);
        Husky husky2 = new Husky("Zokni");
        kennel.addDog(husky2);

        kennel.playWith("Morzsi", 4);
        kennel.playWith("Bigli", 4);
        kennel.playWith("Zokni", 2);

        System.out.println(kennel.getHappyDogNames(7));
    }
}


