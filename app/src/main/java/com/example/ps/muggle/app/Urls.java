package com.example.ps.muggle.app;

public class Urls {
    /**
     * 本地服务器
     */
//    public static final String SERVER = "http://192.168.5.102:10002";

    /**
     * 测试服务器
     */
//    public static final String SERVER = "https://test.fankcool.com";


    /**
     * 正式服务器
     */
    public static final String SERVER = "https://api.fankcool.com";

    public static final String HOME_VIDEO_LIST = "api/v2/videos/query";

    public static final String LISTBYVOTE = "api/v2/videos/listByVote";//热门

    public static final String VIDEO_DETAIL_COMMENT = "api/v2/comments/query";

    public static final String LIKE = "api/v2/votes";//点赞

    public static final String TRASH = "api/v2/dislikes";                                       //新增不喜歡,垃圾桶

    public static final String DISLIKE = "api/v2/votes/delete";//取消点赞


    public static final String VIDEO_CLASSIFY = "api/v2/type";                                   //视频分类

    public static final String HOME_RECYCLERVIEW = "api/v2/home";

    public static final String HOME_VIEWPAGER = "api/v2/banner";

    public static final String SEARCH = "api/v2/search/query";                                  //搜索

    public static final String SUEGGEST = "api/v2/feedbacks";                                     //建议提交

    //    public static final String USERINFO = "api/v2/users";//用户信息
    public static final String USERINFO = "api/v2/users/info";//用户信息

    public static final String ATTENTION = "api/v2/attentions";//关注

    public static final String DISATTENTION = "api/v2/attentions/delete";//取消关注

    public static final String COMMENTS = "/api/v2/comments";//新增评论


    public static final String VIDEOLIST = "api/v2/videos/query/list";

    public static final String VIDEO_DETAIL = "api/v2/videos/look";

    public static final String TO_LOGIN = "api/v2/users/login";                                     //用户登录

    public static final String GET_VERIFICATION = "/api/v2/codes";                             //获取验证码

    public static final String BINDTH = "api/v2/users/bindth"; //

    public static final String SAVE_PERSON_DATA = "api/v2/users";

    public static final String GET_PERSON_DATA = "api/v2/users/token";                              //获取个人资料

    public static final String GET_MSG_COUNT = "api/v2/log";                              //获取消息条数

    public static final String GET_HOT_SEARCH = "api/v2/search/heat";                              //热门搜索

    public static final String SHARES = "api/v2/shares";//分享成功后提交服务器

    public static final String COLLECTS = "api/v2/collects";//收藏

    public static final String DELETECOLLECTS = "api/v2/collects/delete";//取消收藏

    public static final String QUERYCOLLECTS = "api/v2/collects/query";//获取收藏

    public static final String WATCHHISTORYS = "api/v2/videos/listByUserId";//获取历史记录

    public static final String REPORTS = "api/v2/reports";//举报

    public static final String GETATTENTIONS = "api/v2/attentions/getattentions";//获取关注的人

    public static final String GETFANS = "api/v2/attentions/getfans";//获取关注的人

    public static final String LASTAPK = "api/v2/android/lastapk";//版本检测

    public static final String DELETEVIDEO = "api/v2/videos/delete";//删除视频

    public static final String ATTEVIDEO = "api/v2/videos/atte";//关注人的视频

    public static final String RECOMMENDVIDEO = "api/v2/videos/listByVote";//关注人的视频

    public static final String listByType = "api/v2/videos/listByType";//最新

    public static final String GIFTNUM = "api/v2/user/gift";//硬币数量

    public static final String FIRSTLOGIN = "api/v2/user/firstLogin";//启动App

    public static final String VIDEOREWARD = "api/v2/videos/play";//打赏硬币

    public static final String LOGS = "api/v2/accounts/logs";//礼物历史记录

    public static final String VIDEORECS = "api/v2/videorecs";//首页推荐

    public static final String VIDEORECSV3 = "api/v2/videoRecsList";//首页推荐v3

    public static final String INCREASE = "api/v2/video/increase";//自动播放时调用增加热度

    public static final String ACTIVITY = "api/v2/get/activity";//活动列表

    public static final String ACTIVITYDETAIL = "api/v2/get/detail";//活动详情列表

    public static final String TASK = "/api/v2/accountTask/token";//活动详情列表

    public static final String ADD_VIDEO = "api/v2/videos";                                         //新增视频

    public static final String POST_MSGCENTER = "api/v2/log";                                         //消息中心数据

    public static final String PTPCOMMENTLIST="api/v2/comments";//p2p评论记录

    public static final String USERAGREEMENT ="/api/v2/userAgreement";//用户协议

    public static final String GIFTHTML ="/api/v2/giftHtml";//放币兑换
}
