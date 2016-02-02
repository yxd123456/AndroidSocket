// Generated code from Butter Knife. Do not modify!
package com.example.androidsocket;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainActivity$$ViewInjector<T extends com.example.androidsocket.MainActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427408, "field 'et_conn'");
    target.et_conn = finder.castView(view, 2131427408, "field 'et_conn'");
    view = finder.findRequiredView(source, 2131427410, "field 'et_message'");
    target.et_message = finder.castView(view, 2131427410, "field 'et_message'");
    view = finder.findRequiredView(source, 2131427409, "field 'tv_content'");
    target.tv_content = finder.castView(view, 2131427409, "field 'tv_content'");
  }

  @Override public void reset(T target) {
    target.et_conn = null;
    target.et_message = null;
    target.tv_content = null;
  }
}
