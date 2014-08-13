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
package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.handmark.pulltorefresh.samples.R;

public class PullImageView extends PullToRefreshBase<ImageView>
{
    public PullImageView(Context context)
    {
        super(context);
    }

    public PullImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullImageView(Context context, Mode mode)
    {
        super(context, mode);
    }

    public PullImageView(Context context, Mode mode, AnimationStyle style)
    {
        super(context, mode, style);
    }

    @Override
    public final Orientation getPullToRefreshScrollDirection()
    {
        return Orientation.VERTICAL;
    }

    @Override
    protected final ImageView createRefreshableView(Context context,
            AttributeSet attrs)
    {
        final ImageView img;
        // if (VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD) {
        // gv = new InternalGridViewSDK9(context, attrs);
        // } else {
        // gv = new InternalGridView(context, attrs);
        // }
        img = new ImageView(context, attrs);
        // Use Generated ID (from res/values/ids.xml)
        img.setId(R.id.pull_image);
        return img;
    }

    @Override
    protected boolean isReadyForPullEnd()
    {
        //return mRefreshableView.getScrollY() == 0;
        return true;
    }

    @Override
    protected boolean isReadyForPullStart()
    {
        //return mRefreshableView.getScrollY() >= (mRefreshableView.getHeight() - getHeight());
        return true;
    }
}// end class
