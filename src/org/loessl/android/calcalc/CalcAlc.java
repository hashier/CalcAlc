package org.loessl.android.calcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcAlc extends Activity implements OnClickListener, View.OnKeyListener {

	private Button calc, del1, del2;
	private EditText quant1, quant2, per1, per2, price1, price2; 
	private TextView solution1, solution2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		calc = (Button) findViewById(R.id.MainButtonCalc);

		del1 = (Button) findViewById(R.id.MainButtonDel1);
		del2 = (Button) findViewById(R.id.MainButtonDel2);

		quant1 = (EditText) findViewById(R.id.MainEditQuantity1);
		quant2 = (EditText) findViewById(R.id.MainEditQuantity2);
		per1 = (EditText) findViewById(R.id.MainEditPer1);
		per2 = (EditText) findViewById(R.id.MainEditPer2);
		price1 = (EditText) findViewById(R.id.MainEditPrice1);
		price2 = (EditText) findViewById(R.id.MainEditPrice2);

		solution1 = (TextView) findViewById(R.id.MainTextViewSolution1);
		solution2 = (TextView) findViewById(R.id.MainTextViewSolution2);

		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Float tmp;

				if ( (quant1.length() > 0) && (price1.length() > 0) && (per1.length() > 0) ) {
					tmp =
						Float.parseFloat(quant1.getText().toString()) *
						Float.parseFloat(price1.getText().toString()) / 100 *
						Float.parseFloat(per1.getText().toString());
					solution1.setText(tmp.toString());
				} else {
					solution1.setText(R.string.MainTextViewError);
				}

				if ( (quant2.length() > 0) && (price2.length() > 0) && (per2.length() > 0) ) {
					tmp =
						Float.parseFloat(quant2.getText().toString()) *
						Float.parseFloat(price2.getText().toString()) / 100 *
						Float.parseFloat(per2.getText().toString());
					solution2.setText(tmp.toString());
				} else {
					solution2.setText(R.string.MainTextViewError);
				}
			}
		});
		
		del1.setOnClickListener(this);
		del2.setOnClickListener(this);
		
		//per1.setOnKeyListener(this);
	}

	public void onClick(View v) {
		if ( v.getId() == R.id.MainButtonDel1 ) {
			quant1.setText(null);
			price1.setText(null);
			per1.setText(null);
		} else if ( v.getId() == R.id.MainButtonDel2 ) {
			quant2.setText(null);
			price2.setText(null);
			per2.setText(null);
		}
	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {
		per2.setText("works");
		
		return false;
	}

}