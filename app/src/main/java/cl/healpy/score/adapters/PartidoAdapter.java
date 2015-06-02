package cl.healpy.score.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import cl.healpy.score.R;
import cl.healpy.score.models.data.PartidoData;


public class PartidoAdapter extends ArrayAdapter<PartidoData> {

    private Context mContext;
    private List<PartidoData> partido;
    private int id;

    public PartidoAdapter(Context context, int resource, List<PartidoData> partido) {
        super(context, resource);
        this.mContext = context;
        this.partido = partido;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public int getCount() {
        return partido.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {

            String fecha = partido.get(position).getFecha();
            String[] parts = fecha.split("/");
            int day = Integer.parseInt(parts[0]);
            int layout = day % 2 == 0 ? R.layout.partido_list : R.layout.partido_list_pair;

            view = LayoutInflater.from(mContext).inflate(layout, parent, false);

            this.setId(partido.get(position).get_id());

            ImageView img_visita = (ImageView) view.findViewById(R.id.img_escudoVisita);
            ImageView img_escudoLocal = (ImageView) view.findViewById(R.id.img_escudoLocal);
            TextView textView_nombreVisita = (TextView) view.findViewById(R.id.textView_nombreVisita);
            TextView textView_nombreLocal = (TextView) view.findViewById(R.id.textView_nombreLocal);
            TextView textView_golVisita = (TextView) view.findViewById(R.id.textView_golVisita);
            TextView textView_golLocal = (TextView) view.findViewById(R.id.textView_golLocal);
            TextView textView_idPartido = (TextView) view.findViewById(R.id.textView_idPartido);

            Picasso.with(mContext).load(partido.get(position).getEscudoVisita()).into(img_visita);
            Picasso.with(mContext).load(partido.get(position).getEscudoLocal()).into(img_escudoLocal);
            textView_nombreVisita.setText(partido.get(position).getNombreVisita());
            textView_nombreLocal.setText(partido.get(position).getNombreLocal());
            textView_golVisita.setText(partido.get(position).getGolVisita());
            textView_golLocal.setText(partido.get(position).getGolLocal());
            textView_idPartido.setText(String.valueOf(partido.get(position).get_id()));

        }
        return view;
    }
}
