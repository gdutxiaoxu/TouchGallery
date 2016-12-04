/*
 Copyright (c) 2012 Roman Truba

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial
 portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package ru.truba.touchgallery;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.xujun.touchgallery.GalleryWidget.BasePagerAdapter;
import ru.xujun.touchgallery.GalleryWidget.GalleryViewPager;
import ru.xujun.touchgallery.GalleryWidget.UrlPagerAdapter;

public class GalleryUrlActivity extends Activity {

    private GalleryViewPager mViewPager;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] urls = {
                "http://pic.yesky.com/uploadImages/2016/312/42/0V3RDL22393L.jpg",
                "http://img5.duitang.com/uploads/item/201601/11/20160111210742_jWVyh.jpeg",
                "http://img5.duitang.com/uploads/item/201601/11/20160111210742_jWVyh.jpeg",
                "http://img5q.duitang.com/uploads/item/201409/28/20140928213723_5vQCE.thumb.700_0.jpeg",
                "http://img5q.duitang.com/uploads/item/201409/28/20140928213723_5vQCE.thumb.700_0.jpeg",
                "http://img3.duitang.com/uploads/item/201601/12/20160112193018_ftvm3.jpeg"
        };
        List<String> items = new ArrayList<String>();
        Collections.addAll(items, urls);

        UrlPagerAdapter pagerAdapter = new UrlPagerAdapter(this, items);
        pagerAdapter.setOnItemChangeListener(new BasePagerAdapter.OnItemChangeListener()
		{
			@Override
			public void onItemChange(int currentPosition)
			{
				Toast.makeText(GalleryUrlActivity.this, "Current item is " + currentPosition, Toast.LENGTH_SHORT).show();
			}
		});
        
        mViewPager = (GalleryViewPager)findViewById(R.id.viewer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(pagerAdapter);
        
    }

}