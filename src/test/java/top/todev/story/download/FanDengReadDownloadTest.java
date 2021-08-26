package top.todev.story.download;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.todev.story.download.m3u8.download.M3u8DownloadFactory;
import top.todev.story.download.m3u8.listener.DownloadListener;
import top.todev.story.download.m3u8.utils.Constant;

/**
 * <p>樊登读书下载</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-04-21 20:24
 * @since 0.0.1
 */
@Slf4j
public class FanDengReadDownloadTest {

    private final String saveDir = "E:\\read";

    @Test
    public void testDownload1() throws InterruptedException {
        String url1 = "https://cdn-ali-dest.dushu365.com/media/video/1593999789ebbb0823109fb9676446dfd3fec13be44chpkj/2/playlist.m3u8";
        String name1 = "一生的旅程";
        downloadStory(url1, saveDir, name1);

        Thread.sleep(200_000);
    }
    @Test
    public void testDownload2() throws InterruptedException {
        String url2 = "https://cdn-ali-dest.dushu365.com/media/video/161156668304b685baf7a1ea0bbe34c3a2936329975y7o3v/2/playlist.m3u8";
        String name2 = "这才是心理学";
        downloadStory(url2, saveDir, name2);

        Thread.sleep(50_000);
    }

    @Test
    public void testDownload3() throws InterruptedException {
        String url = "https://cdn-ali-dest.dushu365.com/media/video/1589958477cda8faed2d10304c8b2cf3bfc4eb5698e2gcnm/2/playlist.m3u8";
        String name = "授权-如何激发全员领导力";
        downloadStory(url, saveDir, name);

        Thread.sleep(50_000);
    }

    @Test
    public void testDownload4() throws InterruptedException {
        String url = "https://cdn-ali-dest.dushu365.com/media/video/1603774961cd102209e83408d9177fc80aa1d907fb4vkb12/2/playlist.m3u8";
        String name = "逆商";
        downloadStory(url, saveDir, name);

        Thread.sleep(50_000);
    }

    @Test
    public void testDownload5() throws InterruptedException {
        String url = "https://cdn-tencent-dest.dushu365.com/media/video/1618466320231f24dd26d5379634298771448b8907g8xhi3/2/playlist.m3u8";
        String name = "一平方米的静心";
        downloadStory(url, saveDir, name);

        Thread.sleep(50_000);
    }

    @Test
    public void testDownload6() throws InterruptedException {
        String url = "https://cdn-ali-dest.dushu365.com/media/video/1610595845c30756ffc072bbcbf4c1c6b8fbb55690ppvvt4/2/playlist.m3u8";
        String name = "关键对话";
        downloadStory(url, saveDir, name);

        Thread.sleep(50_000);
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
