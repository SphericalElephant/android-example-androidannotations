package com.sphericalelephant.example.androidannotations.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sphericalelephant.example.androidannotations.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DrawableRes;

/**
 * This is an example illustrating the use of AndroidAnnotations, a sophisticated dependency injection framework for android (it can actually do more than that).
 * AndroidAnnotations can be found here (https://github.com/excilys/androidannotations/)
 * <p/>
 * We are using AppCompatActivity to stay compatible with future releases of Android. Originally, AppCompatActivity
 * was used to provide Actionbar functionality (now known as the toolbar) to older Android systems, but starting from
 * 5.x.x it is also required to implement Material design features.
 * <p/>
 * AndroidAnnotations support bindings layouts directly, we need to specify the @EActivity annotation in order to make AndroidAnnotations understand what to do
 */
@EActivity(R.layout.activity_mainactivity)
public class MainActivity extends AppCompatActivity {
	/**
	 * We are binding the view instance to the view here, this is equivalent to calling
	 * <p/>
	 * testButton = (Button) findViewById(R.id.activity_mainactivity_b_test);
	 * <p/>
	 * after setContentView(...)
	 */
	@ViewById(R.id.activity_mainactivity_b_test)
	Button testButton;

	@ViewById(R.id.activity_mainactivity_iv_image)
	ImageView image;

	/**
	 * There are many more resource binding annotations, check
	 */
	@DrawableRes(R.drawable.activity_mainactivity_sellogo)
	Drawable activity_mainactivity_sellogo;


	/**
	 * Simple button binding example
	 */
	@Click(R.id.activity_mainactivity_b_hide)
	public void hide(View hideButton) {
		image.setVisibility(View.INVISIBLE);
	}

	/**
	 * Simple button binding example
	 */
	@Click(R.id.activity_mainactivity_b_show)
	public void show(View showButton) {
		image.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		image.setImageDrawable(activity_mainactivity_sellogo);
	}

	/**
	 * This annotation sets an onClick listener. You can provide a parameter here (instance of View) that will automatically casted
	 * to the type of the View in question.
	 */
	@Click(R.id.activity_mainactivity_b_test)
	public void testButtonClicked(View testButton) {
		Toast.makeText(getApplicationContext(), R.string.activity_mainactivity_testpressed, Toast.LENGTH_SHORT).show();
	}
}
