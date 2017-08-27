package university;

/**
 * This program displays the concept of polymorphism.
 */
public class President {
    public static void main(String[] args) {
        // staff poorBoy = new staff();
        // janitor madFellow = new janitor();
        // rectorat strangeGuy = new rectorat();
        // HeadOfDept angryMan = new HeadOfDept();

        Staff []x = new Staff[4];
        x[0] = new Staff();
        x[1] = new Janitor();
        x[2] = new Rectorat();
        x[3] = new HeadOfDept();

        for (int i=0; i<4; i++) {
            x[i].employ();
            //x[1].employ();
            //x[2].employ();
        }

        //poorBoy.employ();
        //strangeGuy.employ();
        //angryMan.employ();
    }
}
