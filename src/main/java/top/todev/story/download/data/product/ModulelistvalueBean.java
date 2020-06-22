package top.todev.story.download.data.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ModulelistvalueBean {
    /**
     * list : [{"storyid":113848,"storyname":"神奇图书馆2 来啦","playcount":8655629,"commentcount":277,"iconurl":"https://cdn.kaishuhezi.com/kstory/story/image/c0d1af82-2d47-4290-a827-464ec89eeab0.jpg","coverurl":"https://cdn.kaishuhezi.com/kstory/story/image/12cb17d2-95de-4b02-b994-3415be2ee8b3.jpg","buyurl":"","voiceurl":"","duration":175,"timetext":"02:55","audiosize":"","createtime":"","storydescribe":"","isdownload":true,"status":1,"alreadybuy":0,"auditiduration":1,"downloadState":0,"ispreparation":0,"packPer":0,"articleid":"","banduid":"","saletime":"","subhead":"冒险再次启程","feetype":"01","voicetype":1},{"storyid":113953,"storyname":"神奇之旅","playcount":7343384,"commentcount":814,"iconurl":"https://cdn.kaishuhezi.com/kstory/story/image/5630d982-918a-45e5-8398-1e02a633db07.jpg","coverurl":"https://cdn.kaishuhezi.com/kstory/story/image/89101b91-81ff-44fc-acdd-fbf7265c51f9.jpg","buyurl":"","voiceurl":"","duration":217,"timetext":"03:37","audiosize":"","createtime":"","storydescribe":"","isdownload":true,"status":1,"alreadybuy":0,"auditiduration":1,"downloadState":0,"ispreparation":0,"packPer":0,"articleid":"","banduid":"","saletime":"","subhead":"神奇图书馆主题曲","feetype":"01","voicetype":1},{"storyid":113955,"storyname":"引子：图书馆里的海豹","playcount":3528147,"commentcount":584,"iconurl":"https://cdn.kaishuhezi.com/kstory/story/image/baf1ed90-844b-4d5f-8302-eb07077ecc61.jpg","coverurl":"https://cdn.kaishuhezi.com/kstory/story/image/03e4451e-5bd2-40e6-a513-291fc5f25267.jpg","buyurl":"","voiceurl":"","duration":801,"timetext":"13:21","audiosize":"","createtime":"","storydescribe":"","isdownload":true,"status":1,"alreadybuy":0,"auditiduration":1,"downloadState":0,"ispreparation":0,"packPer":0,"articleid":"","banduid":"","saletime":"","subhead":"凯糊涂老师的新发明","feetype":"01","voicetype":1},{"storyid":113954,"storyname":"科学家寄语","playcount":3495881,"commentcount":105,"iconurl":"https://cdn.kaishuhezi.com/kstory/story/image/8e9343e4-6b91-4ec0-8501-c51db2493609.jpg","coverurl":"https://cdn.kaishuhezi.com/kstory/story/image/ad4c3849-e6a2-4d4f-8edd-f5081fd24cfb.jpg","buyurl":"","voiceurl":"","duration":73,"timetext":"01:13","audiosize":"","createtime":"","storydescribe":"","isdownload":true,"status":1,"alreadybuy":0,"auditiduration":1,"downloadState":0,"ispreparation":0,"packPer":0,"articleid":"","banduid":"","saletime":"","subhead":"李新正教授给孩子的话","feetype":"01","voicetype":1}]
     * moduleid : 332
     * modulename :
     * prestorycount : 4
     * loadstorycount : 4
     * iconurl :
     * isshow : 0
     * bgurl : https://cdn.kaishuhezi.com/kstory/story/image/751475ce-6aef-4fb3-99a9-ba91ad133a78.jpg
     * bgurlnew : https://cdn.kaishuhezi.com/kstory/story/image/751475ce-6aef-4fb3-99a9-ba91ad133a78.jpg
     * bgcolor :
     * isexpect : 0
     */

    private int moduleid;
    private String modulename;
    private int prestorycount;
    private int loadstorycount;
    private String iconurl;
    private int isshow;
    private String bgurl;
    private String bgurlnew;
    private String bgcolor;
    private int isexpect;
    private List<ProductDetailBean> list;
}
