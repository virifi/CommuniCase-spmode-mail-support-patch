package net.virifi.android.spmodemail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckWlanPasswordActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        
        TextView textView = new TextView(this);
        textView.setText("このパッチではwifi接続確認をすることは出来ません。実際にメールを送受信することにより確認してください。");
        ll.addView(textView);
        
        Button button = new Button(this);
        button.setText("OK");
        button.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				finish();
			}
		});
        ll.addView(button);
	}
}
