package com.example.ps.muggle.app;

import android.os.Environment;

import java.io.File;

public class Constants {

    //================= PATH ====================

    public static final String PATH_DATA = MyApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "ps" + File.separator + "muggle";

    public static final String SPNAME = "my_sp";



}
