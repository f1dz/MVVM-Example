package com.iteqno.mvvmexample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

@Entity(tableName = "team")
public class TeamDetail extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "team_name")
    @SerializedName("strTeam")
    public String teamName;

    @ColumnInfo(name = "team_logo")
    @SerializedName("strTeamBadge")
    public String teamLogo;

    public int getmId() {
        return mId;
    }

    @Bindable
    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public TeamDetail(int mId, String teamName, String teamLogo) {
        this.mId = mId;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

    @BindingAdapter({"teamLogo"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }
}
