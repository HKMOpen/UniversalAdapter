package fr.ydelouis.universaladaptersample;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.ydelouis.universaladapter.UAdaptable;

public class MyItemView extends LinearLayout implements UAdaptable<String, MyItemView>
{
	private TextView	text;
	private ImageView	image1;
	private ImageView	image2;
	private int			nbImages;
	
	public MyItemView(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		View.inflate(getContext(), R.layout.myitemview, this);
		text = (TextView) findViewById(R.id.myItemView_text);
		image1 = (ImageView) findViewById(R.id.myItemView_image1);
		image2 = (ImageView) findViewById(R.id.myItemView_image2);
		nbImages = android.R.drawable.ic_menu_zoom - android.R.drawable.ic_menu_add;
	}

	@Override
	public void bind(int position, String item, Adapter adapter) {
		text.setText(item);
		image1.setImageResource(android.R.drawable.ic_menu_add + (position % nbImages));
		image2.setImageResource(android.R.drawable.ic_menu_add + ((position + nbImages / 2) % nbImages));
	}

	@Override
	public MyItemView newInstance() {
		return new MyItemView(getContext());
	}
}
