package team12.cs4850.com.adventurecreator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class CreateNewAdventureActivity extends MyBaseActivity {

    private EditText mAdventureName, mAdventureDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdventureName = findViewById(R.id.etAdventureName);
        mAdventureDescription = findViewById(R.id.etAdventureDescription);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_create_new_adventure;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_signout:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (isSignedIn()) {
            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                finish();
                break;
            case R.id.btnSave:
                String adventureName = mAdventureName.getText().toString().trim();
                if (TextUtils.isEmpty(adventureName)) {
                    mAdventureName.setError("Required.");
                    mAdventureName.clearFocus();
                    mAdventureName.requestFocus();
                }
                else {
                    mAdventureName.setError(null);

                    String adventureDescription = mAdventureDescription.getText().toString().trim();
                    if (TextUtils.isEmpty(adventureDescription)) {
                        mAdventureDescription.setError("Required.");
                        mAdventureDescription.clearFocus();
                        mAdventureDescription.requestFocus();
                    }

                    else {

                        mAdventureDescription.setError(null);

                        //need to check if adventureName is duplicate
                        ZAdventure newAdventure = new ZAdventure(auth.getUid(), adventureName, adventureDescription);
                        mDatabase.child("adventures").child(adventureName).setValue(newAdventure);
                        mDatabase.child("users").child(auth.getUid()).child("myAdventures").child(adventureName).setValue(true);
                        //String key = newDatabaseReference.getKey();
                        finish();
                    }
                }

                break;
        }
    }
}

