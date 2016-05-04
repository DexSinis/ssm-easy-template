package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.TNews;
import com.github.ichenkaihua.service.TNewsService;
import com.github.ichenkaihua.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("tNewss")
@RestController
public class TNewsAccountController {
    private Logger logger = LoggerFactory.getLogger(TNewsAccountController.class);

    @Autowired
    TNewsService tNewsService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity getTNewsBYId(@PathVariable int id){
        TNews tNews = tNewsService.getTNewsById(id);
        if(tNews==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tNews);
    }

//    @RequestMapping(value = "tNewss",method = RequestMethod.POST)
//    public ResponseEntity addTNews(@RequestBody TNews tNews)  {
//
//        TNews countTNews = new TNews();
////        tNews.setNewsname(tNews.getNewsname());
//        //如果存在，返回错误码
//        if (tNewsService.isExist(countTNews)) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//        tNewsService.addTNews(tNews);
//        return ResponseEntity.created(URIUtils.createURI("tNewss/{id}",tNews.getId())).body(tNews);
//
//    }


    @RequestMapping(value = "newsViewModel",method =RequestMethod.POST)
    public ResponseEntity newsViewModel(){
        List<TNews> tNewss =tNewsService.getTNewss(null);

        Map data = new HashMap();
        Map viewModel = new HashMap();
        viewModel.put("date",20151226);
        viewModel.put("daysDataList",tNewss);
        viewModel.put("top_stories",tNewss);
        data.put("viewModel",viewModel);

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @RequestMapping(value = "newsContentViewModel",method =RequestMethod.POST)
    public ResponseEntity newsContentViewModel(){
        List<TNews> tNewss =tNewsService.getTNewss(null);

        Map data = new HashMap();
        List js = new ArrayList();
        List css = new ArrayList();
        css.add("http://news.at.zhihu.com/css/news_qa.auto.css?v=77778");
//        Map viewModel = new HashMap();
        data.put("body","<div class='main-wrap content-wrap'>\n<div class='headline'>\n\n<div class='img-place-holder'></div>\n\n\n\n</div>\n\n<div class='content-inner'>\n\n\n\n\n<div class='question'>\n<h2 class='question-title'>老炮儿里法拉利恩佐车漆的价钱？</h2>\n\n<div class='answer'>\n\n<div class='meta'>\n<img class='avatar' src='http://pic3.zhimg.com/d583a2d0fe17155e29143e21b912fc66_is.jpg'>\n<span class='author'>戴少鹤，</span><span class='bio'>涂装逗逼狮/主机厂从业人员/WOWer/</span>\n</div>\n\n<div class='content'>\n<p><strong>（有剧透）</strong></p>\r\n<p>去看了老炮儿，确实很精彩，我看电影比较少，这大概是我今年看过的最精彩的剧情片了，一帮老戏骨演的也很有味，没有血溅街头，没有钢筋肌肉，却有着辛辣的荷尔蒙，就好像小卖部里随处可见的二两半的二锅头，瓶子小小的，包装简陋，不起眼的摆在那里，倘若你一口闷了下去，也会呛得你咳嗽连连，眼泛泪水。出于职业的敏感，当我看到那辆恩佐车门上的那一道子的时候，眼角不禁的抽抽了一下，感觉那一道子就好像划在了脸上一样，这种事情放在恩佐身上，已经不是一个简单的补漆的事情。</p>\r\n<p>首先要明白，<strong>恩佐并不仅仅是一辆很贵的跑车，它是一件为了纪念而诞生的艺术品，也是法拉利造车技术和理念的大成之作</strong>，购买条件严苛，全球总共限产 400 台，一台送给了上帝，对外出售的只有 399 台。这种艺术品，任何一点损伤都是难以接受的，在知乎上，我一直在讲一个理念，那就是&ldquo;车漆的完美成型于出炉的一瞬间，一经损坏，即是永久&rdquo;。而那一道贯穿整个车门划痕，直接把那辆恩佐从一个完美的艺术品杀破成了一个有瑕疵的艺术品，即使用神乎其技的手法将车漆修补到近乎完美，也无法掩盖它已经不再完美的事实。这种行为，根本不是钱不钱的问题，这简直就是在犯罪！</p>\r\n<p>唉，算了，平复一下心情，从技术方面来讲一下吧，我们先来讲一下那道十万的划痕，其实看到那里的时候，我女票也很惊讶的问我，真的要十万吗？</p>\r\n<p>我告诉她说，&ldquo;其实，<strong>十万块钱搞不定的！</strong>&rdquo;</p>\r\n<p>大家看电影里那道划痕，是泛着灰白色，这说明这道划痕是漆面划痕里最严重的一种，已经伤到了电泳层，晓波那孙子下手真是狠啊，对于这种情况，一般的车也就是正常的补漆，但恩佐这种艺术品，没那么简单。里面那个抽老炮六爷耳光的小哥说&ldquo;我这车漆都要从英国进口，一道划痕喷好至少要十万！&rdquo;，事实上，我很怀疑他是否真的有能力来补好，真正的恩佐被划了这么大的一道，那种改装厂是根本没有能力修补的，应该是把车运回意大利摩德纳进行修补，单是运费，保险费都要数万了，到摩德纳之后，补漆的材料费，工时费，厂家的利润，总共加起来何止十万。</p>\r\n<p>我们再来说一下那个值半个车价的车门，后面六爷的猪队友灯罩儿为了尽自己的一份力，偷偷地去用自己的方法私自补漆，结果把整个车门毁了，小飞说要全车喷漆，价钱差不多是全车的一半。</p>\r\n<p><strong>一个车门值半个车，一点都不夸张。</strong></p>\r\n<p>对普通的车来讲，顶多是把整个车门重喷，有些人比较讲究，就干脆换个车门，但对于恩佐，并没有那么简单，最次也要全车喷漆，而不是简单地喷个车门。在最开始我就说了，恩佐不仅仅是一辆普通的跑车，更是一个艺术品，应该是把它当作一个艺术品来看。一个艺术品，最基本的要素就是完美，即使残缺，无序，乖离，也是一种完美的残缺无序乖离。</p>\r\n<p>那么对于这种艺术品的修补最容易出现的问题是什么呢？</p>\r\n<p>跟普通的家用车补漆一样，最容易出现的问题就是<strong>色差。</strong>对于色差问题，普通车在 4S 店补漆的时候，一般肉眼分别不出来就可以了。但对于恩佐这种艺术品来讲，却是完全不能接受的。这就是为什么只是一扇车门花了，但小飞却说要全车喷漆，可以看得出来，他确实是一个懂车的人，因为如果把整个车门打磨补漆，那么整个车门喷完后必然会与整个车身产生色差，大家在外面补漆也是一样的，要记住，<strong>补漆的范围越大，补漆的地方与周围的色差就越明显。</strong>对于普通车来讲，只要不是很严重，倒也可以接受，但是恩佐表示，这完全不能接受。为了追求漆面的完美，就只能把整个车身都重新喷漆，这要求的难度极高，可以肯定，国内做不了，估计要返到摩德纳来喷，整个过程的工时费、材料费、工时补偿和利润等所有的开销加起来 300 万，并不算是太夸张。这其中主要是工时费，要知道，我们公司请一个日本的技术人员来现场调试设备，一人一天的开销就是 2 万，这还不算贵，某个朋友公司里请一个美国人，每小时 400 美元，从他离开美国公司去机场的路上开始算，一直到他干完活回到美国公司结束。法拉利怎么来算这笔钱，说实话，我也不清楚，但可以肯定，不会便宜。事实上，这种方法对于恩佐而言，只是一个下策，上策是把整个车身换掉。把所有的零部件拆下来，再重新总装到新的车身上，这样可以让恩佐再次变得完美。这个方法的难点在于，要重启恩佐的生产线。要知道恩佐早已经停产了，生产线据说给废除了，重启生产线的话，费用平摊下来，估计单台车身也是百万级别的了。</p>\r\n<p>再啰嗦一句，<strong>恩佐是辆好车，《老炮儿》是部好电影，去看吧，值那个价儿。</strong></p>\r\n<p>@贰肆 在评论区里提了一个好问题<strong>&ldquo;直接换一个车门会不会便宜一些？&rdquo;</strong></p>\r\n<p>恩，其实这也是一个方案，但这个方案有两个问题。</p>\r\n<p>1、<strong>恩佐的生产线问题。</strong>恩佐已经停产，生产线据说废除了，由于车门是一个钣金件，即使生产一个车门，也得把冲压，焊接，涂装三大车间再走一遍，四大车间走了三个，差不多算是重启生产线了，重启恩佐的生产线是一件非常大的事情，花费可能更大，如果不走生产线，而只是手工把几块板材敲成完全合乎规格的车门，然后手工焊接，在手工涂装，那花费倒是小事，有没有人愿意做那是个大问题，毕竟能够完全手工做出一个完全合乎规格标准车门的人，即使法拉利也没有几个人吧。</p>\r\n<p>2、<strong>色差问题。</strong>凡是说起补漆，我就必定会提色差问题，色差就是涂装工程师一个终身的宿敌。<strong>所有的车漆从见到阳光的那一刻起，就会开始褪色，这是车漆的物理特性，上至千万级别的宾利，下至七八万的飞度都无法避免。</strong>优秀的车漆和劣质的车漆分别就在于好车漆褪色慢，并且褪色均匀，在车子的使用寿命之内，你很难看出车漆褪色了。如果给恩佐换一个车门，<strong>只要那个车门不是跟那一辆恩佐同时涂装的，那么它的褪色程度跟那辆恩佐就是不一样的，那样就破坏了恩佐的统一性。我说过，恩佐是为了纪念而诞生的艺术品，它天生是用作收藏，艺术品最重要的就是完美和统一。</strong>如果给那辆恩佐换一个车门，经过数十年时光的磨砺，忽然有一天，在午后明媚的阳光下，藏主发现那个车门的红色似乎与车身的红色不太一致，这一瞬间，艺术的完美就碎裂了，你说藏主会不会有一种内心崩溃的感觉。所以，为了艺术性的完美统一，单纯的换个车门是不行的，最好的做法是把整个车身换掉。</p>\r\n<p><strong>未经许可，禁止转载。（知乎日报已获得授权）</strong></p>\n</div>\n</div>\n\n\n<div class='view-more'><a href='http://www.zhihu.com/question/38871911'>查看知乎讨论<span class='js-question-holder'></span></a></div>\n\n</div>\n\n\n</div>\n</div>");
        data.put("image_source","《老炮儿》");
        data.put("title","李易峰划了车，吴亦凡让冯小刚赔十万，其实十万哪够啊");
        data.put("image","http://pic1.zhimg.com/c1cf2f534dd11384facdd879ff209894.jpg");
        data.put("share_url","http://daily.zhihu.com/story/7667220");
        data.put("js",js);
        data.put("ga_prefix","123015");
        data.put("type","0");
        data.put("id","7667220");
        data.put("css",css);


//        data.put("viewModel",viewModel);

        return new ResponseEntity(data, HttpStatus.OK);
    }





    @RequestMapping(value = "/tNews/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        tNewsService.deleteById(id);
    }

    @RequestMapping(value = "/tNews/sad",method = RequestMethod.GET)
    public void update(@RequestBody TNews tNews){
        tNewsService.update(tNews);
    }











}
