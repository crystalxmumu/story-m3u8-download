package top.todev.story.download.data.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResultBean {
    /**
     * MtsHlsUriToken : wFoz1Kkmp%2FugEms5ceAMMVopd4q4ZFnaJ7voDaOG5dMEjJUYWg1sPB2oWBm97lSS
     * voiceUrl :
     * secrecyUrl : https://cdn.kaishuhezi.com/m3u8-mp3-60-audio/ff23e5fb-891a-4b2c-92c8-b53f3a9a8ee0.mp3.a0.m3u8/index.m3u8
     * videoUrl :
     */

    private String MtsHlsUriToken;
    private String voiceUrl;
    private String secrecyUrl;
    private String videoUrl;
}
