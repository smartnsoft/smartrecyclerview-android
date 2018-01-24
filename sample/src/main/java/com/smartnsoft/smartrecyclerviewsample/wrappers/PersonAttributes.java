package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.view.View;

import com.smartnsoft.smartrecyclerviewsample.BR;
import com.smartnsoft.smartrecyclerviewsample.bo.Person;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

public final class PersonAttributes
    extends AbstractDataBindedAttributes<Person>
{

  public PersonAttributes(View view)
  {
    super(view);
  }

  @Override
  protected int getVariableID()
  {
    return BR.person;
  }
}
