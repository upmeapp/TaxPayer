
package assaf.zfani.taxpayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<TaxPayer>taxPayers=new ArrayList<TaxPayer>();
        ListView listView = (ListView)findViewById(R.id.listView) ;
        taxPayers.add(new TaxPayer("yosi",100,10,10,false));
        taxPayers.add(new TaxPayer("yoav",500000,100000,0,true));
        taxPayers.add(new TaxPayer("beni",300000,800000,100000,true));
        taxPayers.add(new TaxPayer("miri",50000,30000,200000,false));
        MyListAdaper adapter = new MyListAdaper(this,taxPayers);
        listView.setAdapter(adapter);

        }
    }

