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

package com.raywenderlich;

import android.app.Application;

import com.raywenderlich.tasty_versions.R;
import com.raywenderlich.tasty_versions.models.TastyVersionModel;

import java.util.ArrayList;
import java.util.List;

public class TastyVersionsApplication extends Application {

  private static TastyVersionsApplication sharedInstance;
  private List<TastyVersionModel> versions;

  public TastyVersionsApplication() {
    sharedInstance = this;
  }

  public static TastyVersionsApplication getSharedInstance() {
    return sharedInstance;
  }

  public List<TastyVersionModel> getVersions() {
    return versions;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    loadVersions();
  }

  public void loadVersions() {
    versions = new ArrayList<>();
    versions.add(new TastyVersionModel("Cupcake", "1.5", R.drawable.cupcake));
    versions.add(new TastyVersionModel("Donut", "1.6", R.drawable.donut));
    versions.add(new TastyVersionModel("Eclair", "2.0 – 2.1", R.drawable.eclair));
    versions.add(new TastyVersionModel("Froyo", "2.2 – 2.2.3", R.drawable.froyo));
    versions.add(new TastyVersionModel("Gingerbread", "2.3 – 2.3.7", R.drawable.gingerbread));
    versions.add(new TastyVersionModel("Honeycomb", "3.0 – 3.2.6", R.drawable.honeycomb));
    versions.add(new TastyVersionModel("Ice cream Sandwich", "4.0 – 4.0.4", R.drawable.icecream_sandwich));
    versions.add(new TastyVersionModel("Jellybean", "4.1 – 4.3.1", R.drawable.jellybean));
    versions.add(new TastyVersionModel("KitKat", "4.4 – 4.4.4", R.drawable.kitkat));
    versions.add(new TastyVersionModel("Lollipop", "5.0 – 5.1.1", R.drawable.lollipop));
    versions.add(new TastyVersionModel("Marshmallow", "6.0 – 6.0.1", R.drawable.marshmallow));
    versions.add(new TastyVersionModel("Nougat", "7.0 – 7.1.2", R.drawable.nougat));
    versions.add(new TastyVersionModel("Oreo", "8.0", R.drawable.oreo));
  }
}
