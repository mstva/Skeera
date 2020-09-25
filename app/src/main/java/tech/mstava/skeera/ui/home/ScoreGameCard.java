package tech.mstava.skeera.ui.home;

public class ScoreGameCard {

    private String mScoreGameTitle;
    private int mScoreGameIconID;

    public ScoreGameCard(String scoreGameTitle, int scoreGameIconID) {
        this.mScoreGameTitle = scoreGameTitle;
        this.mScoreGameIconID = scoreGameIconID;
    }

    public String getScoreGameTitle() {
        return mScoreGameTitle;
    }

    public int getScoreGameIconID() {
        return mScoreGameIconID;
    }
}
