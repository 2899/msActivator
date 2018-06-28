package com.dabai.djn;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static String cliptext = "";
    public static String insertExt = "";
    public static String HTML="";
    public static String CID="";
    private long exitTime = 0;
    WebView webView;
    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    String url = "https://microsoft.gointeract.io/interact/index?interaction=1461173234028-3884f8602eccbe259104553afa8415434b4581-05d1&accountId=microsoft&appkey=196de13c-e946-4531-98f6-2719ec8405ce&Language=English&CountryCode=US&CountryLanguage=EN";


    public void id() {

        getTextFromClip();
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(cliptext);
        insertExt = m.replaceAll("").trim();

        if (insertExt.length() == 54 || insertExt.length() == 63) {
            textView.setTextColor(Color.rgb(0, 200, 0));
            char[] insertconsole = insertExt.toCharArray();

            String str1 = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            int i;
            if (insertExt.length() == 54) {
                for (i = 0; i <= 5; i++) {
                    str1 = str1 + insertconsole[i];
                }
                for (i = 6; i <= 11; i++) {
                    str2 = str2 + insertconsole[i];
                }
                for (i = 12; i <= 17; i++) {
                    str3 = str3 + insertconsole[i];
                }
                for (i = 18; i <= 23; i++) {
                    str4 = str4 + insertconsole[i];
                }
                for (i = 24; i <= 29; i++) {
                    str5 = str5 + insertconsole[i];
                }
                for (i = 30; i <= 35; i++) {
                    str6 = str6 + insertconsole[i];
                }
                for (i = 36; i <= 41; i++) {
                    str7 = str7 + insertconsole[i];
                }
                for (i = 42; i <= 47; i++) {
                    str8 = str8 + insertconsole[i];
                }
                for (i = 48; i <= 53; i++) {
                    str9 = str9 + insertconsole[i];
                }
            } else if (insertExt.length() == 63) {
                for (i = 0; i <= 6; i++) {
                    str1 = str1 + insertconsole[i];
                }
                for (i = 7; i <= 13; i++) {
                    str2 = str2 + insertconsole[i];
                }
                for (i = 14; i <= 20; i++) {
                    str3 = str3 + insertconsole[i];
                }
                for (i = 21; i <= 27; i++) {
                    str4 = str4 + insertconsole[i];
                }
                for (i = 28; i <= 34; i++) {
                    str5 = str5 + insertconsole[i];
                }
                for (i = 35; i <= 41; i++) {
                    str6 = str6 + insertconsole[i];
                }
                for (i = 42; i <= 48; i++) {
                    str7 = str7 + insertconsole[i];
                }
                for (i = 49; i <= 55; i++) {
                    str8 = str8 + insertconsole[i];
                }
                for (i = 56; i <= 62; i++) {
                    str9 = str9 + insertconsole[i];
                }
            }
            textView.setText("ID found!\n" + str1 + "   " + str2 + "   " + str3 + "\n" + str4 + "   " + str5 + "   " + str6 + "\n" + str7 + "   " + str8 + "   " + str9);
            Toast.makeText(this, "ID found!\n" + str1 + "   " + str2 + "   " + str3 + "\n" + str4 + "   " + str5 + "   " + str6 + "\n" + str7 + "   " + str8 + "   " + str9, Toast.LENGTH_LONG).show();
            return;
        }
        textView.setTextColor(Color.rgb(200, 0, 0));
        textView.setText("No ID found!");
        Toast.makeText(this, "No ID found!", Toast.LENGTH_LONG).show();
    }

    public void onClick1(View view) {
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(false);//设置使用够执行JS脚本
        webView.reload();
        webView.getSettings().setJavaScriptEnabled(true);//设置使用够执行JS脚本
        Toast.makeText(this, "正在刷新网页", Toast.LENGTH_LONG).show();
    }


    public void onClick2(View view) throws InterruptedException {
        id();
        if (insertExt.length() == 54 || insertExt.length() == 63) {
            if (insertExt.length() == 54) {
                webView.loadUrl("javascript:document.getElementsByTagName('a')[0].click()");
            } else if (insertExt.length() == 63) {
                webView.loadUrl("javascript:document.getElementsByTagName('a')[1].click()");
            }
            new Handler().postDelayed(new Runnable(){
                public void run() {
                   autoClick();
                }
            }, 3000);
        } else {
            Toast.makeText(this, "未发现ID，无法输入", Toast.LENGTH_LONG).show();
        }


    }

    public void onClick3(View view) {
        final EditText et = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入激活网址")
                //.setIcon(android.R.drawable.sym_def_app_icon)
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //按下确定键后的事件
                        String text = et.getText().toString();
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
                        write(text);
                        webView.clearCache(true);
                        webView.getSettings().setJavaScriptEnabled(false);//设置使用够执行JS脚本
                        webView.loadUrl(text);
                        webView.getSettings().setJavaScriptEnabled(true);
                    }
                }).setNegativeButton("取消", null).show();
    }


    public void autoClick(){
        char[] toCharArray = insertExt.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            if (i == 0) {
                webView.dispatchKeyEvent(new KeyEvent(0, 61));
                webView.dispatchKeyEvent(new KeyEvent(1, 61));
            }
            if (toCharArray[i] == '0') {
                webView.dispatchKeyEvent(new KeyEvent(0, 7));
                webView.dispatchKeyEvent(new KeyEvent(1, 7));
            }
            if (toCharArray[i] == '1') {
                webView.dispatchKeyEvent(new KeyEvent(0, 8));
                webView.dispatchKeyEvent(new KeyEvent(1, 8));
            }
            if (toCharArray[i] == '2') {
                webView.dispatchKeyEvent(new KeyEvent(0, 9));
                webView.dispatchKeyEvent(new KeyEvent(1, 9));
            }
            if (toCharArray[i] == '3') {
                webView.dispatchKeyEvent(new KeyEvent(0, 10));
                webView.dispatchKeyEvent(new KeyEvent(1, 10));
            }
            if (toCharArray[i] == '4') {
                webView.dispatchKeyEvent(new KeyEvent(0, 11));
                webView.dispatchKeyEvent(new KeyEvent(1, 11));
            }
            if (toCharArray[i] == '5') {
                webView.dispatchKeyEvent(new KeyEvent(0, 12));
                webView.dispatchKeyEvent(new KeyEvent(1, 12));
            }
            if (toCharArray[i] == '6') {
                webView.dispatchKeyEvent(new KeyEvent(0, 13));
                webView.dispatchKeyEvent(new KeyEvent(1, 13));
            }
            if (toCharArray[i] == '7') {
                webView.dispatchKeyEvent(new KeyEvent(0, 14));
                webView.dispatchKeyEvent(new KeyEvent(1, 14));
            }
            if (toCharArray[i] == '8') {
                webView.dispatchKeyEvent(new KeyEvent(0, 15));
                webView.dispatchKeyEvent(new KeyEvent(1, 15));
            }
            if (toCharArray[i] == '9') {
                webView.dispatchKeyEvent(new KeyEvent(0, 16));
                webView.dispatchKeyEvent(new KeyEvent(1, 16));
            }
            if (i == toCharArray.length - 1) {
                webView.dispatchKeyEvent(new KeyEvent(0, 61));
                webView.dispatchKeyEvent(new KeyEvent(1, 61));
                webView.dispatchKeyEvent(new KeyEvent(0, 61));
                webView.dispatchKeyEvent(new KeyEvent(1, 61));
            }
        }
        Toast.makeText(this, "输入完成", Toast.LENGTH_LONG).show();
        webView.loadUrl("javascript:document.getElementById('custom-msft-submit').click()");
        new Handler().postDelayed(new Runnable(){
            public void run() {
                webView.loadUrl("javascript:window.java_obj.getCID(document.getElementsByTagName('tbody')[0].innerHTML);");


            }

        }, 8000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        webView();
    }


    public void webView() {
        webView = (WebView) findViewById(R.id.webView1);
        if (read()!=null){ url = read();}
        webView.getSettings().setJavaScriptEnabled(true);//设置使用够执行JS脚本
        webView.getSettings().setBuiltInZoomControls(false);//设置使支持缩放
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "java_obj");
//        webView.getSettings().setDefaultFontSize(5);
//        WebSettings settings = this.webView.getSettings();
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);// 使用当前WebView处理跳转
                return true;//true表示此事件在此处被处理，不需要再广播
            }

            @Override   //转向错误时的处理
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "网络无法加载，因为" + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // 在结束加载网页时会回调

                // 获取页面内容
                //view.loadUrl("javascript:window.java_obj.showSource("
                //       + "document.getElementsByTagName('html')[0].innerHTML);");

                Toast.makeText(MainActivity.this, "网页加载完成" , Toast.LENGTH_SHORT).show();
                super.onPageFinished(view, url);
            }
        });
    }


    @Override   //默认点回退键，会退出Activity，需监听按键操作，使回退在WebView内发生
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(webView.canGoBack()){
                webView.goBack();
                return true;
            }
            else if ((System.currentTimeMillis() - exitTime) > 1000) {
                    Toast.makeText(getApplicationContext(), "再按一次退出程序",
                            Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
            } else {
                    finish();
                    System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("message.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }

            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String msg){
        // 步骤1：获取输入值
        if(msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            FileOutputStream fos = openFileOutput("message.txt", MODE_PRIVATE);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "cliptext/html", "utf-8", null);
            webView.clearHistory();

            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    public void putTextIntoClip(String text){
        ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        //创建ClipData对象
        ClipData clipData = ClipData.newPlainText("simple text copy", text);
        //添加ClipData对象到剪切板中
        cm.setPrimaryClip(clipData);
    }
    public void getTextFromClip(){
        ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if (cm.hasPrimaryClip()) {
            ClipData data1 = cm.getPrimaryClip();
            //  ClipData 里保存了一个ArryList 的 Item 序列， 可以用 getItemCount() 来获取个数
            ClipData.Item item = data1.getItemAt(0);
            cliptext = item.getText().toString();// 注意 item.getText 可能为空
            //Toast.makeText(this, cliptext, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "剪切板为空", Toast.LENGTH_LONG).show();
        }

    }

    public final class InJavaScriptLocalObj
    {

        @JavascriptInterface
        public void showSource(String html) {
            HTML=html;
        }
        @JavascriptInterface
       /* public void getCID(String tbody) {
            String regEx = "<tr[\\S\\s]*?>";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(tbody);
            String str1 = m.replaceAll("").trim();
            Pattern p1 = Pattern.compile("[^0-9]");
            Matcher m1 = p1.matcher(str1);
            CID = m1.replaceAll("").trim();
            if(CID.length()==48){
                putTextIntoClip("确认ID："+CID);
                Toast.makeText(MainActivity.this, "已复制确认ID" , Toast.LENGTH_SHORT).show();
            }
            else{Toast.makeText(MainActivity.this, "未检测到确认ID" , Toast.LENGTH_SHORT).show();}
        }*/
        public void getCID(String tbody) {
            Matcher b1 = Pattern.compile("\\d{6}").matcher(tbody);
            if(b1.find()){
                CID=b1.group();
            }
            while(b1.find()) {
                CID=CID+"-"+b1.group();
            }
            if(CID.length()==55){
                putTextIntoClip("确认ID："+CID);
                Toast.makeText(MainActivity.this, "已复制确认ID" , Toast.LENGTH_SHORT).show();
            }
            else{Toast.makeText(MainActivity.this, "未检测到确认ID" , Toast.LENGTH_SHORT).show();}
            //Log.e( "getCID: ",CID);
        }
    }


}