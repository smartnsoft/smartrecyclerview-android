// The MIT License (MIT)
//
// Copyright (c) 2017 Smart&Soft
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package com.smartnsoft.recyclerview.adapter;

import java.util.Collections;

import android.app.Activity;
import android.view.LayoutInflater;

import com.smartnsoft.recyclerview.recyclerview.SmartReorderRecyclerView.ReorderAdapter;

/**
 * @author Adrien Vitti
 * @since 2015.06.01
 */
public class SmartReorderAdapter
    extends ReorderAdapter
{

  public SmartReorderAdapter(Activity activity, LayoutInflater inflater)
  {
    super(activity, inflater);
  }

  @Override
  public void swapElements(int fromIndex, int toIndex)
  {
    Collections.swap(wrappers, fromIndex, toIndex);
    final int startPosition;
    final int range;
    if (fromIndex > toIndex)
    {
      startPosition = toIndex;
      range = fromIndex - toIndex + 1;
    }
    else
    {
      startPosition = fromIndex;
      range = toIndex - fromIndex + 1;
    }
    notifyItemRangeChanged(startPosition, range);
  }

}
