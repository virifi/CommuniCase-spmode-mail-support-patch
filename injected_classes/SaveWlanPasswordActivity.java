package net.virifi.android.spmodemail;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SaveWlanPasswordActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        
        TextView textView = new TextView(this);
        textView.setText("wifi接続用パスワード");
        ll.addView(textView);
        
        final EditText editText = new EditText(this);
        editText.setText(WlanPasswordManager.getWlanPassword(this));
        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        ll.addView(editText);
        
        LinearLayout ll2 = new LinearLayout(this);
        ll2.setOrientation(LinearLayout.HORIZONTAL);
        ll.addView(ll2);
        
        Button cancelButton = new Button(this);
        cancelButton.setText("キャンセル");
        ll2.addView(cancelButton);
        
        Button saveButton = new Button(this);
        saveButton.setText("保存");
        ll2.addView(saveButton);
        
        cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
        
        saveButton.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				String password = editText.getText().toString();
				WlanPasswordManager.saveWlanPassword(SaveWlanPasswordActivity.this, password);
				setResult(RESULT_OK);
				finish();
			}
		});
    }
}
