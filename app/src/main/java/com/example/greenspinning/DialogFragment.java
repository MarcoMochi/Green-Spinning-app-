package com.example.greenspinning;

import android.app.Activity;
import android.app.Dialog;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;

public class DialogFragment extends AAH_FabulousFragment {

    public static final String TAG = DialogFragment.class.getSimpleName();

    public static DialogFragment newInstance() {
        DialogFragment f = new DialogFragment();
        return f;
    }
    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.filter_sample_view, null);

        RelativeLayout rl_content = (RelativeLayout) contentView.findViewById(R.id.rl_content);
        LinearLayout ll_buttons = (LinearLayout) contentView.findViewById(R.id.ll_buttons);
        contentView.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Lights on";
                sendResult(message);
                closeFilter("closed");
            }
        });
        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(250); // optional; default 400dp //optional; to get back result
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last
    }

    private void sendResult(String message) {
        if( getTargetFragment() == null ) {
            return;
        }
        Intent intent = ProfileFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }
}
