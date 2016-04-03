package com.fll.comicreader.comicreader;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/1/25.
 */
public class Downloader {

    public static String TAG = "Downloader";

    /**
     * download a file by an url, and save it as filePath
     *
     * @param url
     * @param filePath
     */
    public static boolean downloadFile(String url, String filePath) {

        FileOutputStream fop = null;
        try {
            URL downloadUrl = new URL(url);

            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fop = new FileOutputStream(file);
            URLConnection conn = downloadUrl.openConnection();

            byte[] buffer = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            int len;
            while ((len = bis.read(buffer, 0, 1024)) != -1) {
                fop.write(buffer, 0, len);
            }
            Log.d(TAG, "finish download:"
                    + filePath);
            fop.flush();
            fop.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static InputStream getHTMLInputStream(String url) throws IOException {
        URL downloadUrl = new URL(url);
        URLConnection conn = downloadUrl.openConnection();
        return conn.getInputStream();
    }

}
