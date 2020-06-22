package top.todev.story.download;


import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import top.todev.story.download.data.item.ItemResult;
import top.todev.story.download.data.product.ProductResult;
import top.todev.story.download.data.product.ResultBean;
import top.todev.story.download.m3u8.download.M3u8DownloadFactory;
import top.todev.story.download.m3u8.listener.DownloadListener;
import top.todev.story.download.m3u8.utils.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static top.todev.story.download.constant.KaiShuStoryConstant.*;

@Slf4j
public class KaiShuStoryDownloadTest {

    private int[] productIds = new int[]{1772};

    private String saveDir = "E:\\story";

    @Test
    public void testDownload() {
        Security.addProvider(new BouncyCastleProvider());
        Arrays.stream(productIds)
                .forEach(
                        id -> {
                            AtomicInteger index = new AtomicInteger();
                            ProductResult productInfo = getProductInfo(id);
//                            log.info("商品信息：{}", productInfo);
                            try {
                                String dir = saveDir + File.separator + productInfo.getResult().getProduct().getProductname().replaceAll(" ", "_");
                                Files.createDirectories(Paths.get(dir));
                                productInfo.getResult()
                                        .getModulelistvalue()
                                        .forEach(products -> {
                                            products.getList()
                                                    .forEach(product -> {
                                                        ItemResult itemInfo = getItemInfo(id, product.getStoryid());
                                                        String sd = NumberUtil.decimalFormat("000", index.incrementAndGet());
                                                        downloadStory(itemInfo.getResult().getSecrecyUrl(),
                                                                dir  + File.separator + sd,
                                                                StrUtil.format(NAME_STORY,
                                                                        sd,
                                                                        product.getStoryname()));
                                                        /*try {
                                                            Thread.sleep(5_000);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        }*/
                                                    });
                                        });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
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

    private ItemResult getItemInfo(int productId, int itemId) {
        String url = StrUtil.format(URL_ITEM_INFO, USER_ID, itemId, DEVICE_ID, productId);
        String result = HttpRequest.get(url)
                .header(Header.HOST, "m.kaishustory.com")
                .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/12.0 Mobile/15A372 Safari/604.1")
                .header(Header.ACCEPT, "*/*")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate, br")
                .header(Header.CONTENT_TYPE, "application/json")
                .header("clientform", "h5")
                .header("device", "h5")
                .header("appid", "992099001")
                .header("appversion", "6.7.0")
                .header("usersource", "kaishu")
                .header("platform", "kaishu")
                .header("deviceid", DEVICE_ID)
                .header("token", TOKEN)
                .header("channelid", "ks")
                .header("userid", String.valueOf(USER_ID))
                .header("mccCode", "")
                .header(Header.CONNECTION, "keep-alive")
                .header(Header.REFERER, StrUtil.format(URL_ITEM_REFER_3, itemId, productId))
                .cookie(COOKIE)
                .timeout(20000)//超时，毫秒
                .execute()
                .body();
        return JSONUtil.toBean(result, ItemResult.class);
    }

    /**
     * 获取故事信息
     * @param id
     * @return
     */
    private ProductResult getProductInfo(int id) {
        String url = StrUtil.format(URL_PRODUCT_INFO, 1, id, USER_ID);
        String result = HttpRequest.get(url)
                .header(Header.HOST, "m.kaishustory.com")
                .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/12.0 Mobile/15A372 Safari/604.1")
                .header(Header.ACCEPT, "*/*")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate, br")
                .header(Header.CONTENT_TYPE, "application/json")
                .header("clientform", "h5")
                .header("device", "h5")
                .header("appid", "992099001")
                .header("appversion", "6.7.0")
                .header("usersource", "kaishu")
                .header("platform", "kaishu")
                .header("deviceid", DEVICE_ID)
                .header("token", TOKEN)
                .header("channelid", "ks")
                .header("userid", String.valueOf(USER_ID))
                .header("mccCode", "")
                .header(Header.CONNECTION, "keep-alive")
                .header(Header.REFERER, StrUtil.format(URL_PRODUCT_REFER, id))
                .cookie(COOKIE)
                .timeout(20000)//超时，毫秒
                .execute()
                .body();
        return JSONUtil.toBean(result, ProductResult.class);
    }
}
