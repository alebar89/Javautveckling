package Elevator;

//Creating class Elevator
public class Elevator {
    //Instance variable private so that the user cant change the value
    private int level;

    //Constants deciding the floors
    final int bottomFloor = -2;
    final int topFloor = 10;

    //Constructor to create objects with new values
    public Elevator(int level) {
        this.level = level;
    }

    //Getter and setter to be able to temporarily keep track, and change the value of, level
    //in the program
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //Method for moving the elevator
    //(almost) All error-handling is put here
    //Checking so that the user put in:
    //1. A floor between -2-10
    //2. Not the same floor as we are on already
    //3. And displaying a message when the elevator is moving
    //4. The check if a valid integer is typed in is located in the main-method
    //5. Changing the floor if user typed in a valid (new) floor
    public void goTo(int i) {
        if (i < bottomFloor) {
            System.out.println("Du har angett ett för lågt våningsplan");
        } else if (i > topFloor) {
            System.out.println("Du har angett ett för högt våningsplan");
        } else if (i == getLevel()) {
            System.out.println("Du står redan på våning " + getLevel());
        } else if (i > getLevel()) {
            System.out.println("Hissen åker upp till våning " + i);
            setLevel(i);
        } else {
            System.out.println("Hissen åker ner till våning " + i);
            setLevel(i);
        }
    }

    //Method for keeping track of the elevator and giving the user an opportunity
    //to check where the elevator is
    public int where() {
        System.out.println("Hissen står just nu på våning " + getLevel());
        return this.level;
    }
}