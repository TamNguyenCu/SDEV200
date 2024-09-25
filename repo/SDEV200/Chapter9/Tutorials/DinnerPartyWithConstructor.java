package Chapter9.Tutorials;

public class DinnerPartyWithConstructor extends PartyWithConstructor {
    private int dinnerChoice;

    public int getDinnerChoice() {
        return this.dinnerChoice;
    }

    public void setDinnerChoice(int dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
    }
    
    @Override
    public void displayInvitation() {
        System.out.println("PLease come to my dinner party!");
    }
}
