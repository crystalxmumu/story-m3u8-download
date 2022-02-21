package top.todev.story.download;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.todev.story.download.m3u8.download.M3u8DownloadFactory;
import top.todev.story.download.m3u8.listener.DownloadListener;
import top.todev.story.download.m3u8.utils.Constant;

/**
 * <p>一书一课下载</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-04-21 20:24
 * @since 0.0.1
 */
@Slf4j
public class YiShuYiKeDownloadTest {

    private final String saveDir = "E:\\book";

    @Test
    public void testDownload1() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/9b000123a12646bb95bd1ed0dc97e4b2/eb903a02e0874d8a99cafc742c38f408-58a17fe7757e0e67a7ab1b29b0c14afc-ld.m3u8";
        String name1 = "用流程解放管理01";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload2() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/8230b79a9aeb46dcbda90617e0840520/902a4824fce297422590af03302bcde0-ld.m3u8";
        String name1 = "用流程解放管理02";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload3() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/8a141538c43f4b80b7435dfe8219a6c2/9e84038ae7a40e479d19ef1d051a4b13-ld.m3u8";
        String name1 = "用流程解放管理03";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload4() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/4d2c9d4e53744ce3b83c85c7288bcb1a/ce4f075a988126409f37af76edeb3c1e-ld.m3u8";
        String name1 = "用流程解放管理04";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload5() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/211868bb92c44162abeecb80059c6e42/edaef8dfc84cb880a51abc94bf6e603c-ld.m3u8";
        String name1 = "用流程解放管理05";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload6() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/0ccc338377f94d23b63bfa529e07b99a/3942d180f9d4e1094a598c0e49cd06b2-ld.m3u8";
        String name1 = "用流程解放管理06";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
    }

    @Test
    public void testDownload7() throws InterruptedException {
        String url1 = "https://video.chiyue365.com/17febf9df53946dca9206e61a60e1440/e89013d91b3dc0166a98c9819b867327-ld.m3u8";
        String name1 = "用流程解放管理07";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(20_000);
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
