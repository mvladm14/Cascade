package cascade.com.cascade_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class AuthenticationSource extends Activity {

    private TextView IdOftestView;
    private String sourceName;

    public static String SOURCE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authetication_source);

        IdOftestView = (TextView) findViewById(R.id.IdOftestView);

        // Get the message from the intent
        Intent intent = getIntent();
        sourceName = intent.getStringExtra(MainActivity.SOURCE_NAME);

        IdOftestView.append(" " + '"' + sourceName + '"' + ":");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_authetication_source, menu);
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

    public void openLinkAccountSourceActivity(View view) {
        Intent intent = new Intent(this, LinkAccountSource.class);
        intent.putExtra(SOURCE_NAME, sourceName);

        startActivity(intent);
    }
}
