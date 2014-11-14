package com.ladwa.aditya.dslab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


public class SettingsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener  {

    private TextView tvFont;
    private SharedPreferences sp;
    private int fontSize;

    private static String PREF_FONT_SIZE = "fontSize";



    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings, container, false);
        SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seekfont);

        tvFont = (TextView) rootView.findViewById(R.id.tv_font);

        sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        fontSize= sp.getInt(PREF_FONT_SIZE,20);

        tvFont.setTextSize(fontSize);
        seekBar.setProgress(fontSize);
        tvFont.setText(getString(R.string.font) + "  " + String.valueOf(fontSize));


        seekBar.setOnSeekBarChangeListener(this);





        return rootView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tvFont.setTextSize(seekBar.getProgress());
        tvFont.setText(getString(R.string.font) +  "  " +  String.valueOf(seekBar.getProgress()));
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(PREF_FONT_SIZE,(int)seekBar.getProgress());
        editor.apply();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}
