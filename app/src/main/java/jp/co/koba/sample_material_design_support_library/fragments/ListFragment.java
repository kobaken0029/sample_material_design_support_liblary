package jp.co.koba.sample_material_design_support_library.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.koba.sample_material_design_support_library.R;
import jp.co.koba.sample_material_design_support_library.activities.TabLayoutActivity;
import jp.co.koba.sample_material_design_support_library.models.Item;
import jp.co.koba.sample_material_design_support_library.views.adapters.MyListAdapter;

import static butterknife.ButterKnife.findById;

public class ListFragment extends Fragment {
    private TabLayoutActivity activity;
    private List<Item> items;

    @InjectView(R.id.list_view)
    ListView listView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (TabLayoutActivity) activity;
        addItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(new MyListAdapter(activity, 0, items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = items.get(position);
                Snackbar.make(findById(activity, R.id.coordinator_layout),
                        selectedItem.getName() + " " + selectedItem.getContent(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * itemsにitemを追加する。
     */
    private void addItems() {
        Item item = new Item();
        item.setName("アイテム");
        item.setContent("これは、アイテムです");
        item.setImageResId(R.mipmap.ic_launcher);

        Item strongItem = new Item();
        strongItem.setName("強いアイテム");
        strongItem.setContent("これは、強いアイテムです");
        strongItem.setImageResId(R.mipmap.ic_launcher);

        Item weekItem = new Item();
        weekItem.setName("弱いアイテム");
        weekItem.setContent("これは、弱いアイテムです");
        weekItem.setImageResId(R.mipmap.ic_launcher);

        items = new ArrayList<>();
        items.add(item);
        items.add(weekItem);
        items.add(item);
        items.add(strongItem);
        items.add(item);
        items.add(item);
        items.add(weekItem);
        items.add(item);
        items.add(weekItem);
    }
}
