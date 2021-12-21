package ru.darvell.gb.interview.lesson1;

public class Main {

    public static void main(String[] args) {
        Person moscowPerson = new Person.Builder()
                .setAddress("Moscow")
                .setFirstName("Oleg")
                .setLastName("Olegov")
                .setCountry("Russia")
                .build();
        Person homelessPerson = new Person.Builder()
                .setFirstName("Stas")
                .setLastName("Stasov")
                .setAge(21)
                .build();

        System.out.println(moscowPerson);
        System.out.println(homelessPerson);
    }
}
