package top.todev.story.download;

import cn.hutool.core.util.URLUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.todev.story.download.m3u8.download.M3u8DownloadFactory;
import top.todev.story.download.m3u8.listener.DownloadListener;
import top.todev.story.download.m3u8.utils.Constant;

/**
 * <p>OA培训下载</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-04-21 20:24
 * @since 0.0.1
 */
@Slf4j
public class OaTrainDownloadTest {

    private final String saveDir = "E:\\oa\\train";

    @Test
    public void testDownload1() throws InterruptedException {
        String url1 = "https://tehlsvodhls02.vhallyun.com/vhallyun/vhallrecord/8877e708/20210423104544_8877e708/record.m3u8?token=323CC2F3_ODIxMzY5Nzc4XzY0NTBENTkzX09EZzNOMlUzTURnX2RtbHphWFJmTnpnM016ZzJPVFExX3ZvZA";
        String name1 = "Ecology9.0表单建模二次开发培训";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(200_000);
    }
    @Test
    public void testDownload2() throws InterruptedException {
        String url2 = "https://tehlsvodhls02.vhallyun.com/vhallyun/vhallrecord/74e01e9c/20211122163340_74e01e9c/record.m3u8?token=C3699052_MjE1OTYxOTc3XzY0NTBERTk4X056UmxNREZsT1dNX2RtbHphWFJmTnpnM016ZzJPVFExX3ZvZA";
        String name2 = "[E9]办公用品管理应用场景培训(云平台)";
        downloadStory(url2, saveDir, name2);

        Thread.sleep(50_000);
    }

    @Test
    public void testDownload3() throws InterruptedException {
        String url2 = "https://tehlsvodhls02.vhallyun.com/vhallyun/vhallrecord/678de50b/20210730094840_678de50b/record.m3u8?token=B06A624A_MjI1ODg1MTQzXzY0NTBFMDI4X05qYzRaR1UxTUdJX2RtbHphWFJmTnpnM016ZzJPVFExX3ZvZA";
        String name2 = "[E9]采购管理应用场景";
        downloadStory(url2, saveDir, name2);

        Thread.sleep(120_000);
    }

    @Test
    public void testUrlHost() {
        String url = "https://tehlsvodhls02.vhallyun.com/vhallyun/vhallrecord/8877e708/20210423104544_8877e708/record.m3u8?token=323CC2F3_ODIxMzY5Nzc4XzY0NTBENTkzX09EZzNOMlUzTURnX2RtbHphWFJmTnpnM016ZzJPVFExX3ZvZA";
        String host = URLUtil.getHost(URLUtil.url(url)).toString();
        log.info("URL-host: {}", host);
    }


    private void downloadStory(String url, String dir, String name) {
        M3u8DownloadFactory.M3u8Download m3u8Download = new M3u8DownloadFactory.M3u8Download(url);
        //设置生成目录
        m3u8Download.setDir(dir);
        //设置视频名称
        m3u8Download.setFileName(name);
        //设置线程数
        m3u8Download.setThreadCount(100);
        //设置重试次数
        m3u8Download.setRetryCount(100);
        //设置连接超时时间（单位：毫秒）
        m3u8Download.setTimeoutMillisecond(10000L);
        /*
        设置日志级别
        可选值：NONE INFO DEBUG ERROR
        */
        m3u8Download.setLogLevel(Constant.INFO);
        //设置监听器间隔（单位：毫秒）
        m3u8Download.setInterval(500L);
        //添加额外请求头
      /*  Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "text/html;charset=utf-8");
        m3u8Download.addRequestHeaderMap(headersMap);*/
        //添加监听器
        m3u8Download.addListener(new DownloadListener() {
            @Override
            public void start() {
                System.out.println("开始下载！");
            }

            @Override
            public void process(String downloadUrl, int finished, int sum, float percent) {
                System.out.println("下载网址：" + downloadUrl + "\t已下载" + finished + "个\t一共" + sum + "个\t已完成" + percent + "%");
            }

            @Override
            public void speed(String speedPerSecond) {
                System.out.println("下载速度：" + speedPerSecond);
            }

            @Override
            public void end() {
                System.out.println("下载完毕");
            }
        });
        //开始下载
        m3u8Download.start();
    }
}
