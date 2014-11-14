package com.ladwa.aditya.dslab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LabFragment extends Fragment {

    private TextView tv;
    private SharedPreferences sp;
    private static String PREF_FONT_SIZE = "fontSize";
    private int fontsize;

    public LabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test, container, false);

        Bundle extra = getArguments();
        Integer pos = extra.getInt("pos");
        sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        fontsize = sp.getInt(PREF_FONT_SIZE,15);

        tv = (TextView) rootView.findViewById(R.id.tvContent);
        tv.setTextSize(fontsize);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(getResources().getAssets().open(pos + ".txt")));
            String line;
            while ((line = br.readLine()) != null) {
                tv.append(line);
                tv.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return rootView;
    }


}
