package zonaapp.co.cancharapida.Adapters;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zonaapp.co.cancharapida.Entities.Noticias;
import zonaapp.co.cancharapida.R;

public class BaseAdapterNoticias extends BaseAdapter {

    private Activity actx;
    private List<Noticias> data;

    public BaseAdapterNoticias(Activity actx, List<Noticias> data){
        this.actx = actx;
        this.data = data;
    }

    @Override
    public int getCount() {
        if(data == null || data.size() < 0) return 0;

        return data.size();
    }

    @Override
    public Noticias getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(actx, R.layout.item_noticias, null);
            new ViewHolder(convertView);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        Noticias item = getItem(position);

        holder.titulo.setText(item.getTitulo());
        holder.contenido.setText(item.getContenido());

        return convertView;
    }

    class ViewHolder {

        TextView titulo;
        TextView contenido;

        public ViewHolder(View view) {
            titulo = (TextView) view.findViewById(R.id.txtTitulo);
            contenido = (TextView) view.findViewById(R.id.txtContenido);
            view.setTag(this);
        }
    }

}
