package tech.mstava.skeera.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.mstava.skeera.R;

public class ScoreGameViewAdapter extends RecyclerView.Adapter<ScoreGameViewAdapter.ScoreGameViewHolder> {

    private Context mContext;
    private List<ScoreGameCard> mScoreGameCardData;

    public ScoreGameViewAdapter(Context context, List<ScoreGameCard> scoreGameCardData) {
        this.mContext = context;
        this.mScoreGameCardData = scoreGameCardData;
    }

    @NonNull
    @Override
    public ScoreGameViewAdapter.ScoreGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.score_game_card_view, parent, false);
        return new ScoreGameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreGameViewAdapter.ScoreGameViewHolder holder, final int position) {

        holder.scoreGameTitle.setText(mScoreGameCardData.get(position).getScoreGameTitle());
        holder.scoreGameIcon.setImageResource(mScoreGameCardData.get(position).getScoreGameIconID());
        holder.scoreGameIcon.setColorFilter(Color.BLACK);

        holder.scoreGameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TeamsActivity.class);
                intent.putExtra("scoreGameTitle", mScoreGameCardData.get(position).getScoreGameTitle());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mScoreGameCardData.size();
    }

    public static class ScoreGameViewHolder extends RecyclerView.ViewHolder {

        private TextView scoreGameTitle;
        private ImageView scoreGameIcon;
        private CardView scoreGameCard;

        public ScoreGameViewHolder(@NonNull View itemView) {
            super(itemView);
            scoreGameTitle = itemView.findViewById(R.id.score_game_title);
            scoreGameIcon = itemView.findViewById(R.id.score_game_icon);
            scoreGameCard = itemView.findViewById(R.id.score_game_card);
        }
    }
}
