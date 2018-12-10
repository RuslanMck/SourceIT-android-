package android.sourceit.sourceitsample.adapter;

import android.sourceit.sourceitsample.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 12.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class SampleRecycleAdapter extends RecyclerView.Adapter<SampleRecycleAdapter.SampleViewHolder> {

    private List<String> lst;

    private LayoutInflater layoutInflater;

    public SampleRecycleAdapter(List<String> lst) {
        this.lst = lst;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("-----", String.format("Inflate view for position %d", i));
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, true);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, int i) {
        Log.i("-----", String.format("onBindViewHolder for position %d", i));
        ((TextView)sampleViewHolder.itemView.findViewById(android.R.id.text1)).setText(lst.get(i));

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    class SampleViewHolder extends RecyclerView.ViewHolder{

        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
