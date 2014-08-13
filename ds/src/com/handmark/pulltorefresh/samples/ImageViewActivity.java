/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.handmark.pulltorefresh.samples;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import com.handmark.pulltorefresh.library.PullImageView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public final class ImageViewActivity extends Activity {

	PullImageView mPullImageView;
	ImageView mImageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ptr_imageview);
		
		mPullImageView = (PullImageView) findViewById(R.id.pull_image);
		mPullImageView.setOnRefreshListener(new OnRefreshListener<ImageView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ImageView> refreshView) {
                new GetDataTask().execute();
            }
        });

		mImageView = mPullImageView.getRefreshableView();
		
		mImageView.setImageResource(R.drawable.t);
	}
	
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            // Do some stuff here
            // Call onRefreshComplete when the list has been refreshed.
            mPullImageView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }
}//end class
