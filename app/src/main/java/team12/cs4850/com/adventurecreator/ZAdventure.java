package team12.cs4850.com.adventurecreator;

/**
 * Created by siatk on 3/3/2018.
 */

//storage class for an Adventure in Firebase
public class ZAdventure {
    public String userid;
    public String adventureName;
    public String adventureDescription;
    public long dateModified;    //long currDate = System.currentTimeMillis();     //use mDate = Date(currDate) to get it back.

    public ZAdventure() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ZAdventure(String userid, String adventureName, String adventureDescription) {
        this.userid = userid;
        this.adventureName = adventureName;
        this.adventureDescription = adventureDescription;
        this.dateModified = System.currentTimeMillis();
    }

}
