package model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cascade.com.cascade_app.PasswordListActivity;
import cascade.com.cascade_app.R;

/**
 * Created by Vlad on 4/27/2015.
 */
public class CustomAdapter extends BaseAdapter implements View.OnClickListener {

    /**
     * ******** Declare Used Variables ********
     */
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    AccountListModel tempValues = null;
    int i = 0;

    /**
     * **********  CustomAdapter Constructor ****************
     */
    public CustomAdapter(Activity a, ArrayList d, Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data = d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     * ***** What is the size of Passed Arraylist Size ***********
     */
    public int getCount() {

        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /**
     * ****** Create a holder Class to contain inflated xml file elements ********
     */
    public static class ViewHolder {

        public TextView text;
        public ImageView image;

    }

    /**
     * *** Depends upon data size called for each row , Create each ListView row ****
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.tabitem, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.text);
            holder.image = (ImageView) vi.findViewById(R.id.image);

            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();

        if (data.size() <= 0) {
            holder.text.setText("No Data");

        } else {
            /***** Get each Model object from Arraylist ********/
            tempValues = null;
            tempValues = (AccountListModel) data.get(position);

            /************  Set Model values in Holder elements ***********/

            holder.text.setText(tempValues.getAccount().getName());
            holder.image.setImageResource(
                    res.getIdentifier(
                            "cascade.com.cascade_app:drawable/" + tempValues.getImage()
                            , null, null));
            /******** Set Item Click Listener for LayoutInflater for each row *******/

            vi.setOnLongClickListener(new OnLongClickListener(position));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    private class OnLongClickListener implements View.OnLongClickListener {

        private int mPosition;

        OnLongClickListener(int position) {
            mPosition = position;
        }

        @Override
        public boolean onLongClick(View v) {
            PasswordListActivity sct = (PasswordListActivity) activity;

            /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

            sct.onLongClick(mPosition);

            return true;
        }
    }
}
