package com.leapfrog.mergelayoutswithevents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 12/16/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    String[] userNames = new String[]{"Jack", "Jill", "Bill", "Chris", "Tori", "Tom", "Jeff", "Seth", "Jonah", "Jimmy"};
    String[] ivURL = new String[]{"http://www.worldculturepictorial.com/images/content/the-simpsons_family.jpg",
            "http://crunchpics.com/wp-content/uploads/2014/09/old-and-better-cartoon-picture.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/98/b3/71/98b371cd43ead599d22bb40590df8287.jpg",
            "http://g02.a.alicdn.com/kf/HTB1CJ5.IXXXXXcUXpXXq6xXFXXXZ/-Cartoon-New-2015-The-Simpsons-Bag-Women-Middle-The-Simpsons-School-Bag-for-Student-boys.jpg",
            "Tori", "Tom", "Jeff", "Seth", "Jonah", "Jimmy"};

    Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new CustomViewGroup(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvUserName.setText(Html.fromHtml("<b>" + userNames[position] + "</b>" + " has added a new video."));

//        Picasso.with(context).load(ivURL[position]).into(holder.ivTest, new Callback() {
//            @Override
//            public void onSuccess() {
//                Rect rect = holder.ivTest.getDrawable().getBounds();
////                Log.e("height ", "f " + rect.height());
////                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, rect.height()));
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return userNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_username)
        TextView tvUserName;

        @Bind(R.id.iv_test)
        ImageView ivTest;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
