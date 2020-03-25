package com.example.hwandroid112;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class DataItemsAdapter extends BaseAdapter {
    private List<DataItems> dataItems;
    private LayoutInflater inflater;
    public DataItemsAdapter(List<DataItems> dataItems, Context context) {
        this.dataItems = dataItems;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return dataItems != null ? dataItems.size() : 0;
    }
    @Override
    public Object getItem(int position) {
        return dataItems != null ? dataItems.get(position) : 0;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View currentView;
        if (convertView != null) {
            currentView = convertView;
        } else {
            currentView = inflater.inflate(R.layout.item_list_view, parent, false);
        }

        final DataItems model = (DataItems) getItem(position);

        if (model != null) {
            TextView title = currentView.findViewById(R.id.title);
            TextView subTitle = currentView.findViewById(R.id.subtitle);
            CheckBox checkBox = currentView.findViewById(R.id.checkbox);
            ImageView imageView = currentView.findViewById(R.id.icon_view);
            Button buttonDelete = currentView.findViewById(R.id.btn_delete);

            imageView.setBackgroundResource(model.getImageID());
            title.setText(model.getTitle_view());
            subTitle.setText(model.getSubTitle_view());
            checkBox.setOnCheckedChangeListener(myCheckChangeList);
            checkBox.setTag(position);
            checkBox.setChecked(model.isChecked());
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnDel(position);
                }
            });
        }
        return currentView;
    }


    private void btnDel(int position) {
        dataItems.remove(position);
        notifyDataSetChanged();
    }


    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

        }
    };
}
