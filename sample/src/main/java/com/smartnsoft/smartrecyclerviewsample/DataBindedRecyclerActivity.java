package com.smartnsoft.smartrecyclerviewsample;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;

import com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper;

import com.smartnsoft.smartrecyclerviewsample.bo.Person;
import com.smartnsoft.smartrecyclerviewsample.wrappers.PersonWrapper;
import com.smartnsoft.smartrecyclerviewsample.wrappers.SimpleTextWrapper;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

public final class DataBindedRecyclerActivity
    extends SimpleRecyclerActivity
{

  @NonNull
  @Override
  protected List<SmartRecyclerViewWrapper<?>> createWrappers()
  {
    final List<SmartRecyclerViewWrapper<?>> wrappers = new ArrayList<>();
    final String[] personNames = getResources().getStringArray(R.array.personNames);
    for (int index = 0; index < personNames.length; index++)
    {
      wrappers.add(new PersonWrapper(new Person(personNames[index])));
    }
    return wrappers;
  }
}
