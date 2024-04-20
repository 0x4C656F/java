public class Part2 {
    public static void main(String[] args) {
        Part2 garden = new Part2();
        garden.startGarden();
    }

    // Non-static inner class
    class Flower {
        void bloom() {
            System.out.println("The flower blooms beautifully.");
        }
    }

    public void startGarden() {
        Flower flower = new Flower();
        flower.bloom();

        // Local class 
        class Tree {
            void grow() {
                System.out.println("The tree grows tall and strong.");
            }
        }

        Tree tree = new Tree();
        tree.grow();

        // Anonymous class using an interface
        Growable grass = new Growable() {
            @Override
            public void grow() {
                System.out.println("Grass spreads across the ground.");
            }
        };

        grass.grow();
    }

    interface Growable {
        void grow();
    }
}
