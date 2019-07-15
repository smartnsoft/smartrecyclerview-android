package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.content.Context;
import android.view.View;

import com.smartnsoft.smartrecyclerviewsample.R;
import com.smartnsoft.smartrecyclerviewsample.bo.Person;

/**
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

public final class PersonWrapper
    extends AbstractDataBindedViewWrapper<Person>
{

  public PersonWrapper(Person businessObject)
  {
    super(businessObject, WrapperType.PersonWrapper, R.layout.person_item);
  }

  @Override
  protected Object extractNewViewAttributes(Context context, View view, Person person)
  {
    return new PersonAttributes(view);
  }

}
