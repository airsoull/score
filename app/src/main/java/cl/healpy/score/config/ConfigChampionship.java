package cl.healpy.score.config;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cl.healpy.score.R;

public class ConfigChampionship {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    private AppCompatActivity mActivity;

    public ConfigChampionship(AppCompatActivity activity){
        this.setActivity(activity);
        this.setVariables();
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public void setActivity(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    private void setVariables(){
        ButterKnife.inject(getActivity());
    }

    public void setToolbar(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        getActivity().setSupportActionBar(toolbar);
        try {
            getActivity().getSupportActionBar().setElevation(10);
        } catch (NullPointerException e){}
    }

}
