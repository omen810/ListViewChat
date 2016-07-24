package com.omen.www.listviewchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private EditText mEditText;
    private Button mButton;
    private MsgAdapter mMsgAdapter;
    /*为什么用ArrayList，而不是直接用List*/
    private List<Msg> mMsgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        mMsgAdapter = new MsgAdapter(this, R.layout.list_item_msg, mMsgList);
        mListView = (ListView) findViewById(R.id.activity_main_list_view);
        mListView.setAdapter(mMsgAdapter);
        mButton = (Button) findViewById(R.id.activity_main_btn_send);
        mEditText = (EditText) findViewById(R.id.activity_main_tv_input);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=mEditText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    mMsgAdapter.notifyDataSetChanged();
                    mListView.setSelection(mMsgList.size());
                    mEditText.setText("");
                }
            }
        });

    }

    private void initMsgs() {
        mMsgList.add(new Msg("haihaiahaiaha!",Msg.TYPE_RECEIVED));
        mMsgList.add(new Msg("oooooooooo!",Msg.TYPE_SENT));
    }
}


