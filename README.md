# SwipeRefreshDemo

1. import jar. android-support-v7-recyclerview.jar

2. set anim.

<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:drawable="@drawable/pull_header1"
        android:duration="600" />
    <item
        android:drawable="@drawable/pull_header2"
        android:duration="600" />
    <item
        android:drawable="@drawable/pull_header3"
        android:duration="600" />
</animation-list>

3. set head xml.

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="20dp">

    <TextView
        android:id="@+id/refresh_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:padding="10dp"
        android:text="正在刷新" />

    <ImageView
        android:id="@+id/refresh_img"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_toLeftOf="@id/refresh_text"
        android:layout_toStartOf="@id/refresh_text" />

</RelativeLayout>

then codes.
