/*
 *
 *  * Copyright (c) 2017 Razeware LLC
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in
 *  * all copies or substantial portions of the Software.
 *  *
 *  * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 *  * distribute, sublicense, create a derivative work, and/or sell copies of the
 *  * Software in any work that is designed, intended, or marketed for pedagogical or
 *  * instructional purposes related to programming, coding, application development,
 *  * or information technology.  Permission for such use, copying, modification,
 *  * merger, publication, distribution, sublicensing, creation of derivative works,
 *  * or sale is expressly withheld.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 */

package com.raywenderlich.tasty_versions.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.raywenderlich.TastyVersionsApplication;
import com.raywenderlich.tasty_versions.R;
import com.raywenderlich.tasty_versions.adapters.VersionItemAdapter;
import com.raywenderlich.tasty_versions.databinding.ActivityTastyVersionsBinding;
import com.raywenderlich.tasty_versions.decorators.VersionItemDecorator;

public class TastyVersionsActivity extends AppCompatActivity {
  private ActivityTastyVersionsBinding tastyVersionsBinding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    tastyVersionsBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_tasty_versions);
  }

  @Override public void onResume() {
    super.onResume();
    setupUI();
  }

  private void setupUI() {
    LinearLayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    VersionItemDecorator itemDecorator = new VersionItemDecorator(8);
    VersionItemAdapter adapter
        = new VersionItemAdapter(TastyVersionsApplication.getSharedInstance().getVersions(), this);
    tastyVersionsBinding.versionsRecyclerView.setHasFixedSize(true);
    tastyVersionsBinding.versionsRecyclerView.setLayoutManager(layoutManager);
    tastyVersionsBinding.versionsRecyclerView.addItemDecoration(itemDecorator);
    tastyVersionsBinding.versionsRecyclerView.setAdapter(adapter);
  }
}
