package top.todev.story.download.data.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDetailBean {
    /**
     * storyid : 113848
     * storyname : 神奇图书馆2 来啦
     * playcount : 8655629
     * commentcount : 277
     * iconurl : https://cdn.kaishuhezi.com/kstory/story/image/c0d1af82-2d47-4290-a827-464ec89eeab0.jpg
     * coverurl : https://cdn.kaishuhezi.com/kstory/story/image/12cb17d2-95de-4b02-b994-3415be2ee8b3.jpg
     * buyurl :
     * voiceurl :
     * duration : 175
     * timetext : 02:55
     * audiosize :
     * createtime :
     * storydescribe :
     * isdownload : true
     * status : 1
     * alreadybuy : 0
     * auditiduration : 1
     * downloadState : 0
     * ispreparation : 0
     * packPer : 0
     * articleid :
     * banduid :
     * saletime :
     * subhead : 冒险再次启程
     * feetype : 01
     * voicetype : 1
     */

    private int storyid;
    private String storyname;
    private int playcount;
    private int commentcount;
    private String iconurl;
    private String coverurl;
    private String buyurl;
    private String voiceurl;
    private int duration;
    private String timetext;
    private String audiosize;
    private String createtime;
    private String storydescribe;
    private boolean isdownload;
    private int status;
    private int alreadybuy;
    private int auditiduration;
    private int downloadState;
    private int ispreparation;
    private int packPer;
    private String articleid;
    private String banduid;
    private String saletime;
    private String subhead;
    private String feetype;
    private int voicetype;
}
