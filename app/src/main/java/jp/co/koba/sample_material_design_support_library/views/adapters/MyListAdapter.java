package jp.co.koba.sample_material_design_support_library.views.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jp.co.koba.sample_material_design_support_library.R;
import jp.co.koba.sample_material_design_support_library.models.Item;

import static butterknife.ButterKnife.findById;

/**
 * ListViewのAdapterクラス。
 */
public class MyListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater layoutInflater;
    private Context context;

    /**
     * Adapter内のホルダークラス。
     */
    class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView contentTextView;

        /**
         * コンストラクタ。
         *
         * @param view view
         */
        ViewHolder(View view) {
            imageView = findById(view, R.id.image_view);
            nameTextView = findById(view, R.id.item_name);
            contentTextView = findById(view, R.id.item_content);
        }
    }

    /**
     * コンストラクタ。
     *
     * @param context            コンストラクタ
     * @param textViewResourceId resourceId
     * @param list               ListViewに配置する対象のオブジェクト群
     */
    public MyListAdapter(Context context, int textViewResourceId, List<Item> list) {
        super(context, textViewResourceId, list);
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (item != null) {
            holder.imageView.setImageBitmap(
                    BitmapFactory.decodeResource(context.getResources(), item.getImageResId()));
            holder.nameTextView.setText(item.getName());
            holder.contentTextView.setText(item.getContent());
        }

        return convertView;
    }
}
