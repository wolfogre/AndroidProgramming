package wolfogre.kh6_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Jason Song(wolfogre@outlook.com) on 02/19/2016.
 */
public class PeopleListViewAdapter extends BaseAdapter {

	String[] peopleNames;
	LayoutInflater layoutInflater;

	public PeopleListViewAdapter(Context context, int groupId, String gameName){
		peopleNames = GameInfoBySharedPreferences.getPeopleNames(gameName, groupId);
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return peopleNames.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.item_people_list_view, null);
			textView = (TextView) convertView.findViewById(R.id.tvPeopleName);
			convertView.setTag(textView);
		} else {
			textView = (TextView) convertView.getTag();
		}
		textView.setText(peopleNames[position]);
		return convertView;
	}
}
