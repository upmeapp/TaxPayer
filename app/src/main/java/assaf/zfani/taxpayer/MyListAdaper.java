package assaf.zfani.taxpayer;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class MyListAdaper implements ListAdapter {
    Context context;
    ArrayList<TaxPayer> taxPayers;

    public  MyListAdaper(Context context,ArrayList<TaxPayer> taxPayers)
    {
        this.context=context;
        this.taxPayers= taxPayers;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return taxPayers.size();
    }

    @Override
    public Object getItem(int position) {
        return taxPayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v;
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.linecontent, null);
        }
        else
            v = view;
        
        TextView textView =(TextView)v.findViewById(R.id.NametextView);
        CheckBox checkBox =(CheckBox)v.findViewById(R.id.checkBox);
        TextView textView1 = (TextView)v.findViewById(R.id.textView2);
        Button button = (Button)v.findViewById(R.id.button);
        final TaxPayer currentPayer = taxPayers.get(position);
        textView.setText(currentPayer.getName());
        checkBox.setEnabled(currentPayer.isRich());
        textView1.setText(currentPayer.sumAssets() +" ");
        if(currentPayer.isImmunity())
        {
            button.setEnabled(false);
        }
        else
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentPayer.removeTax();
                }
            });

        return v;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return taxPayers.size()==0;
    }
}
