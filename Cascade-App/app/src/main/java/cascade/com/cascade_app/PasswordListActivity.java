package cascade.com.cascade_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import model.Account;
import model.CustomAdapter;
import model.AccountListModel;
import model.Password;


public class PasswordListActivity extends Activity {

    ListView list;
    CustomAdapter adapter;
    public PasswordListActivity CustomListView = null;
    public ArrayList<AccountListModel> CustomListViewValuesArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_list);

        CustomListView = this;

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();

        Resources res = getResources();
        list = (ListView) findViewById(R.id.list);  // List defined in XML ( See Below )

        /**************** Create Custom Adapter *********/
        adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr, res);
        list.setAdapter(adapter);

    }

    /**
     * *** Function to set data in ArrayList ************
     */
    public void setListData() {

        AccountListModel facebook = new AccountListModel();
        Account facebookAccount = new Account("Facebook", new Password("facebook"));
        facebook.setAccount(facebookAccount);
        facebook.setImage("facebook");
        CustomListViewValuesArr.add(facebook);

        AccountListModel outlook = new AccountListModel();
        Account outlookAccount = new Account("Outlook", new Password("outlook"));
        outlook.setAccount(outlookAccount);
        outlook.setImage("outlook");
        CustomListViewValuesArr.add(outlook);

        AccountListModel gmail = new AccountListModel();
        Account gmailAccount = new Account("Gmail", new Password("gmail"));
        gmail.setAccount(gmailAccount);
        gmail.setImage("gmail");
        CustomListViewValuesArr.add(gmail);

        AccountListModel adobe = new AccountListModel();
        Account adobeAccount = new Account("Adobe", new Password("Adobe"));
        adobe.setAccount(adobeAccount);
        adobe.setImage("adobe");
        CustomListViewValuesArr.add(adobe);

        AccountListModel visa = new AccountListModel();
        Account visaAccount = new Account("Visa", new Password("visa"));
        visa.setAccount(visaAccount);
        visa.setImage("visa");
        CustomListViewValuesArr.add(visa);

    }

    public void onLongClick(int mPosition) {
        final AccountListModel tempValues = (AccountListModel) CustomListViewValuesArr.get(mPosition);

        final AlertDialog.Builder b = new AlertDialog.Builder(PasswordListActivity.this);
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setNeutralButton("Copy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Password", tempValues.getAccount().getPassword().getText());
                clipboard.setPrimaryClip(clip);
            }
        });
        b.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                AlertDialog.Builder alert = new AlertDialog.Builder(PasswordListActivity.this);

                alert.setTitle("Edit");
                alert.setMessage("Enter new password");

                // Set an EditText view to get user input
                final EditText input = new EditText(PasswordListActivity.this);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        tempValues.getAccount().getPassword().setText(value);
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
            }
        });

        b.setNegativeButton("Remove", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                final AlertDialog.Builder remove = new AlertDialog.Builder(PasswordListActivity.this);
                remove.setIcon(android.R.drawable.ic_dialog_alert);
                remove.setMessage("Do you want to remove this password?");

                remove.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        CustomListViewValuesArr.remove(tempValues);
                        Resources res = getResources();
                        adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr, res);
                        list.setAdapter(adapter);
                    }
                });

                remove.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                remove.show();
            }
        });

        b.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

