# Toaster
<br>a convenient toast util
<br>这是一个简单方便的Toast工具类
====
<br>实现了基本Toast显示，通过改变字体颜色，背景样式，显示位置，以及基于他们的组合，实现灵活的Toast显示
<br>由于日常很少用到长时间的Toast显示，所以本库均使用默认短时间显示2s
<br>
![](https://github.com/bayanhot/Toaster/blob/master/app/src/main/res/drawable/toaster.gif)
<br>
<br>基本使用步骤如下：
-------
<br>1，添加依赖
-------
<br>在项目的build.gradle文件的allprojects下的repositories中添加 maven { url 'https://jitpack.io' }

```
allprojects {
    repositories {
        google()
        jcenter()
        ``maven { url 'https://jitpack.io' }``
        
    }
}
```

<br>在app的build.gradle下添加依赖
```Java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.github.bayanhot:Toaster:1.0.1'
}
```

<br>2，初始化
-------
<br>在Application的onCreate()中进行初始化
```
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toaster.init(this);
    }
}
```

<br>3，使用
-------
<br>在需要执行Toast显示的地方调用方法Toast.show()
```
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toaster.show("Toaster");
                break;
        }
```

<br>扩展：
-------
<br>1，基本显示
```
Toaster.show("Toaster");
```
<br>2，改变字体颜色
```
Toaster.show("Toaster",R.color.colorblue);
```
<br>3，改变字体颜色，背景样式
```
Toaster.show("Toaster",R.color.white,R.drawable.toast_bg_style);
```
<br>4，改变显示位置
```
Toaster.showAt("Toaster", Gravity.CENTER_HORIZONTAL|Gravity.TOP);
```
<br>5，改变显示位置，字体颜色
```
Toaster.showAt("Toaster", R.color.colorblue,Gravity.CENTER_HORIZONTAL|Gravity.TOP);
```
<br>6，改变显示位置，字体颜色，背景样式
```
Toaster.showAt("Toaster", R.color.white,R.drawable.toast_bg_style,Gravity.CENTER_HORIZONTAL|Gravity.TOP);
```
<br>7，改变显示位置+偏移，字体颜色，背景样式
```
Toaster.showAt("Toaster", R.color.white,R.drawable.toast_bg_style,Gravity.CENTER_HORIZONTAL|Gravity.TOP,0,500);
```

<br>想在需要的地方取消，可调用Toaster.cancel()
```
    @Override
    protected void onStop() {
        super.onStop();
        Toaster.cancel();
    }
```
