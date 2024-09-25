package Chapter9.Tutorials;

public class PartyWithConstructor {
    private int guests;

    public int getGuests() {
        return this.guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
    
    public void displayInvitation() {
        System.out.println("Please come to my party!");
    }

    public PartyWithConstructor() {
        System.out.println("Creating a Party");
    }
}
