package cascade.com.cascade_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class LinkAccountSource extends Activity {

    private TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_account_source);

        greetingTextView = (TextView) findViewById(R.id.greetingTextView);

        // Get the message from the intent
        Intent intent = getIntent();
        String sourceName = intent.getStringExtra(AuthenticationSource.SOURCE_NAME);

        greetingTextView.append(" " + '"' + sourceName + '"');


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_authentification_source, menu);
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

    public void openPasswordListActivity(View view) {
        Intent intent = new Intent(this, PasswordListActivity.class);
        startActivity(intent);
    }
}
