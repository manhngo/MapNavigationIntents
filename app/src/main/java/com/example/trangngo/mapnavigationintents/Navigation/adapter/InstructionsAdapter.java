package com.example.trangngo.mapnavigationintents.Navigation.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trangngo.mapnavigationintents.Navigation.model.Instructions;
import com.example.trangngo.mapnavigationintents.Navigation.utils.Key;
import com.example.trangngo.mapnavigationintents.R;

import java.util.List;

/**
 * Created by NgoXuanManh on 7/15/2017.
 */

public class InstructionsAdapter extends PagerAdapter {

    private List<Instructions> instructionsList;
    private LayoutInflater layoutInflater;

    public InstructionsAdapter(Context context, List<Instructions> instructionsList) {
        this.instructionsList = instructionsList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return instructionsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @SuppressWarnings("deprecation")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.item_instructions, container, false);

        TextView tvDistance = (TextView) view.findViewById(R.id.tvDistance);
        tvDistance.setTag(Key.DISTANCETAG + position);
        TextView tvInstructions = (TextView) view.findViewById(R.id.tvInstruction);

        Instructions instructions = instructionsList.get(position);
        tvDistance.setText(instructions.getDistance());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvInstructions.setText(Html.fromHtml(instructions.getInstructions(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            tvInstructions.setText(Html.fromHtml(instructions.getInstructions()));
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
