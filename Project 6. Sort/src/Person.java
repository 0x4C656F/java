public class Person implements Comparable<Person> {
    private int birthYear;

    public Person(int birthYear) {
        this.birthYear = birthYear;
    }

    public int compareTo(Person other) {
        return Integer.compare(this.birthYear, other.birthYear);
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static void main(String[] args) {
        Person person1 = new Person(1990);
        Person person2 = new Person(1985);
        Person person3 = new Person(1990);

        System.out.println("Comparing person1 (1990) with person2 (1985): " + person1.compareTo(person2));
        System.out.println("Comparing person2 (1985) with person1 (1990): " + person2.compareTo(person1));
        System.out.println("Comparing person1 (1990) with person3 (1990): " + person1.compareTo(person3));
    }
}
