package com.rohit.fragment_parcelable_factory;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Parceble_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Parceble_Fragment() {
        // Required empty public constructor
    }

    public static Parceble_Fragment newInstance(Person person) {

        Bundle args = new Bundle();
        args.putParcelable("Android",person);
        Parceble_Fragment fragment = new Parceble_Fragment();
        fragment.setArguments(args);
        return fragment;

    }

    // TODO: Rename and change types and number of parameters
    public static Parceble_Fragment newInstance(String param1, String param2) {
        Parceble_Fragment fragment = new Parceble_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parceble_, container, false);

        TextView textView = view.findViewById(R.id.showdata);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Person person = bundle.getParcelable("Android");

            textView.setText(person.getname());
            textView.append(String.valueOf(person.getid()));
            textView.append(person.getemail());

        }

        return view;
    }
}
