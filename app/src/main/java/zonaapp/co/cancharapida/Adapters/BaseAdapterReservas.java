package zonaapp.co.cancharapida.Adapters;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zonaapp.co.cancharapida.Entities.Reserva;
import zonaapp.co.cancharapida.R;

public class BaseAdapterReservas extends BaseAdapter {

    private Activity actx;
    private List<Reserva> data;

    public BaseAdapterReservas(Activity actx, List<Reserva> data){
        this.actx = actx;
        this.data = data;
    }

    @Override
    public int getCount() {
        if(data == null || data.size() < 0) return 0;

        return data.size();
    }

    @Override
    public Reserva getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(actx, R.layout.item_reservas, null);
            new ViewHolder(convertView);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        Reserva item = getItem(position);

        holder.txtCancha.setText(item.getCancha());
        holder.txtFecha.setText(item.getFechaData());
        holder.txtHora.setText(item.getHoraData());
        holder.txtCliente.setText(item.getNombreUsuario());

        return convertView;
    }

    class ViewHolder {

        TextView txtCancha;
        TextView txtFecha;
        TextView txtHora;
        TextView txtCliente;

        public ViewHolder(View view) {
            txtCancha = (TextView) view.findViewById(R.id.txtCancha);
            txtFecha = (TextView) view.findViewById(R.id.txtFecha);
            txtHora = (TextView) view.findViewById(R.id.txtHora);
            txtCliente = (TextView) view.findViewById(R.id.txtCliente);
            view.setTag(this);
        }
    }

}
