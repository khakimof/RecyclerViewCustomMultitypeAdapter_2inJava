package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcustommultitypeadapter_2injava.R;

import java.util.List;

import model.Member;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;
    private static final int TYPE_AVAILABLE_BG_COLOR = 2;

    private Context context;
    private List<Member> members;
    public CustomAdapter(Context context,List<Member> members) {
       this.context = context;
       this.members = members;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == TYPE_AVAILABLE_YES) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_custom_layout_yes,viewGroup,false);
            return new CustomViewYesHolder(view);
        }
        if (viewType == TYPE_AVAILABLE_BG_COLOR) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_custom_layout_background,viewGroup,false);
            return new CustomViewBGColorHolder(view);
        }
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_custom_layout_not,viewGroup,false);
        return new CustomViewNotHolder(view);
    }

    @Override
    public int getItemViewType(int position) {

        Member member = members.get(position);

        if (members.get(position).isAvailable() == 0) {
            return TYPE_AVAILABLE_YES;
        }
        if (members.get(position).isAvailable() == 2) {
            return TYPE_AVAILABLE_BG_COLOR;
        }
        return TYPE_AVAILABLE_NOT;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder) {
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }
    }

    //
    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewNotHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name,last_name;
        public CustomViewNotHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }

    private class CustomViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name,last_name;
        public CustomViewYesHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }

    private class CustomViewBGColorHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name,last_name;
        public CustomViewBGColorHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
