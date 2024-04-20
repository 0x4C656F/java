import java.util.ArrayList;

import soundmakers.Animal;
import soundmakers.Bee;
import soundmakers.Cat;
import soundmakers.Cow;
import soundmakers.Cricket;
import soundmakers.Dog;
import soundmakers.Frog;
import soundmakers.Pig;
import soundmakers.SoundMaker;

public class Part1 {
    public static void main(String[] args) throws Exception {
        //PART 1.1
        SuperClass superClass = new SubClass();
        superClass.print();
        
        //PART 1.2
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());
        animals.add(new Pig());

        for (Animal animal : animals) {
            animal.makeSound();
        }

        //PART 1.3
        ArrayList<SoundMaker> soundMakers = new ArrayList<>();
        soundMakers.add(new Cat());
        soundMakers.add(new Dog());
        soundMakers.add(new Cow());
        soundMakers.add(new Pig());
        soundMakers.add(new Bee());
        soundMakers.add(new Cricket());
        soundMakers.add(new Frog());

        for (SoundMaker soundMaker : soundMakers) {
            soundMaker.makeSound();
        }
    }
    //PART 1.1
    static class SuperClass {
        public void print() {
            System.out.println("Print in SuperClass");
        }
    }
    //PART 1.1
    static class SubClass extends SuperClass {
        @Override
        public void print() {
            System.out.println("Print in SubClass");
        }
    }

}
