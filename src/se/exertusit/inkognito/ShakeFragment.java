package se.exertusit.inkognito;

import java.io.InputStream;
import java.util.Random;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ShakeFragment extends Fragment {
	private ImageView scaryGuy;
	private RelativeLayout layout;
	private ImageView firstBall;
	private ImageView secondBall;
	private ImageView thirdBall;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.shake_fragment, container,
				false);
		layout = (RelativeLayout) rootView.findViewById(R.id.layout);

		scaryGuy = (ImageView)rootView.findViewById(R.id.scaryGuyImage);
		firstBall = new ImageView(getActivity());
		secondBall = new ImageView(getActivity());
		thirdBall = new ImageView(getActivity());
		firstBall.setImageResource(random());
		secondBall.setImageResource(random());
		thirdBall.setImageResource(random());

		layout.addView(firstBall);
		layout.addView(secondBall);
		layout.addView(thirdBall);

		RelativeLayout.LayoutParams margin = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		margin.height = 220;
		margin.width = 220;
		margin.setMargins(325, 1500, ¨0, 0);
		firstBall.setLayoutParams(margin);

		RelativeLayout.LayoutParams marginSecond = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		marginSecond.height = 220;
		marginSecond.width = 220;
		marginSecond.setMargins(625, 1525, 0, 0);
		secondBall.setLayoutParams(marginSecond);

		RelativeLayout.LayoutParams marginThird = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		marginThird.height = 220;
		marginThird.width = 220;
		marginThird.setMargins(925, 1500, 0, 0);
		thirdBall.setLayoutParams(marginThird);

		scaryGuy.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				firstBall.setImageResource(random());
				secondBall.setImageResource(random());
				thirdBall.setImageResource(random());

			}
		});
		return rootView;
	}

	int random() {

		int rad = randInt(0, 4);
		if (rad == 0)
			return R.drawable.blue;
		else if (rad == 1)
			return R.drawable.yellow;
		else if (rad == 2)
			return R.drawable.red;
		else if (rad == 3)
			return R.drawable.black;
		else if (rad == 4)
			return R.drawable.white;

		return 0;

	}

	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
