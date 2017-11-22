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

package com.raywenderlich.tastyversions.viewholders;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.raywenderlich.tastyversions.databinding.TastyVersionViewHolderBinding;
import com.raywenderlich.tastyversions.models.TastyVersionModel;

public class VersionItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  private Context context;
  private TastyVersionModel tastyVersionModel;
  private TastyVersionViewHolderBinding binding;
  private int position;

  public VersionItemViewHolder(Context context, View itemView) {
    super(itemView);
    this.context = context;
    this.binding = DataBindingUtil.bind(itemView);
    itemView.setOnClickListener(this);
  }

  public void bindTastyVersionModel(TastyVersionModel tastyVersionModel, int position) {
    this.position = position;
    this.tastyVersionModel = tastyVersionModel;
    this.binding.versionTextView.setText(tastyVersionModel.getName());
    this.binding.versionImageView.setImageResource(tastyVersionModel.getImageResource());
  }

  @Override
  public void onClick(View v) {
    if (this.tastyVersionModel != null) {
      Toast.makeText(this.context, "Version API # "
              + this.tastyVersionModel.getApiVersion()
              + " at position "
              + this.position,
          Toast.LENGTH_SHORT)
          .show();
    }
  }
}
