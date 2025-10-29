import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import huiyuanList from '../pages/huiyuan/list'
import huiyuanDetail from '../pages/huiyuan/detail'
import huiyuanAdd from '../pages/huiyuan/add'
import jiaolianList from '../pages/jiaolian/list'
import jiaolianDetail from '../pages/jiaolian/detail'
import jiaolianAdd from '../pages/jiaolian/add'
import mafangList from '../pages/mafang/list'
import mafangDetail from '../pages/mafang/detail'
import mafangAdd from '../pages/mafang/add'
import kechengfenleiList from '../pages/kechengfenlei/list'
import kechengfenleiDetail from '../pages/kechengfenlei/detail'
import kechengfenleiAdd from '../pages/kechengfenlei/add'
import kechengxinxiList from '../pages/kechengxinxi/list'
import kechengxinxiDetail from '../pages/kechengxinxi/detail'
import kechengxinxiAdd from '../pages/kechengxinxi/add'
import kechengyudingList from '../pages/kechengyuding/list'
import kechengyudingDetail from '../pages/kechengyuding/detail'
import kechengyudingAdd from '../pages/kechengyuding/add'
import jiaolianxinxiList from '../pages/jiaolianxinxi/list'
import jiaolianxinxiDetail from '../pages/jiaolianxinxi/detail'
import jiaolianxinxiAdd from '../pages/jiaolianxinxi/add'
import yuyuesijiaoList from '../pages/yuyuesijiao/list'
import yuyuesijiaoDetail from '../pages/yuyuesijiao/detail'
import yuyuesijiaoAdd from '../pages/yuyuesijiao/add'
import pingjiafankuiList from '../pages/pingjiafankui/list'
import pingjiafankuiDetail from '../pages/pingjiafankui/detail'
import pingjiafankuiAdd from '../pages/pingjiafankui/add'
import mapizhongleiList from '../pages/mapizhonglei/list'
import mapizhongleiDetail from '../pages/mapizhonglei/detail'
import mapizhongleiAdd from '../pages/mapizhonglei/add'
import mapixinxiList from '../pages/mapixinxi/list'
import mapixinxiDetail from '../pages/mapixinxi/detail'
import mapixinxiAdd from '../pages/mapixinxi/add'
import mapixunlianList from '../pages/mapixunlian/list'
import mapixunlianDetail from '../pages/mapixunlian/detail'
import mapixunlianAdd from '../pages/mapixunlian/add'
import mapijiankangList from '../pages/mapijiankang/list'
import mapijiankangDetail from '../pages/mapijiankang/detail'
import mapijiankangAdd from '../pages/mapijiankang/add'
import changdileixingList from '../pages/changdileixing/list'
import changdileixingDetail from '../pages/changdileixing/detail'
import changdileixingAdd from '../pages/changdileixing/add'
import changdixinxiList from '../pages/changdixinxi/list'
import changdixinxiDetail from '../pages/changdixinxi/detail'
import changdixinxiAdd from '../pages/changdixinxi/add'
import changdiyudingList from '../pages/changdiyuding/list'
import changdiyudingDetail from '../pages/changdiyuding/detail'
import changdiyudingAdd from '../pages/changdiyuding/add'
import changdiyanghuList from '../pages/changdiyanghu/list'
import changdiyanghuDetail from '../pages/changdiyanghu/detail'
import changdiyanghuAdd from '../pages/changdiyanghu/add'
import shebeileixingList from '../pages/shebeileixing/list'
import shebeileixingDetail from '../pages/shebeileixing/detail'
import shebeileixingAdd from '../pages/shebeileixing/add'
import sheshishebeiList from '../pages/sheshishebei/list'
import sheshishebeiDetail from '../pages/sheshishebei/detail'
import sheshishebeiAdd from '../pages/sheshishebei/add'
import shebeiyudingList from '../pages/shebeiyuding/list'
import shebeiyudingDetail from '../pages/shebeiyuding/detail'
import shebeiyudingAdd from '../pages/shebeiyuding/add'
import shebeiyanghuList from '../pages/shebeiyanghu/list'
import shebeiyanghuDetail from '../pages/shebeiyanghu/detail'
import shebeiyanghuAdd from '../pages/shebeiyanghu/add'
import feiyongmingxiList from '../pages/feiyongmingxi/list'
import feiyongmingxiDetail from '../pages/feiyongmingxi/detail'
import feiyongmingxiAdd from '../pages/feiyongmingxi/add'
import huodongleixingList from '../pages/huodongleixing/list'
import huodongleixingDetail from '../pages/huodongleixing/detail'
import huodongleixingAdd from '../pages/huodongleixing/add'
import huodongxinxiList from '../pages/huodongxinxi/list'
import huodongxinxiDetail from '../pages/huodongxinxi/detail'
import huodongxinxiAdd from '../pages/huodongxinxi/add'
import baominghuodongList from '../pages/baominghuodong/list'
import baominghuodongDetail from '../pages/baominghuodong/detail'
import baominghuodongAdd from '../pages/baominghuodong/add'
import huodongqiandaoList from '../pages/huodongqiandao/list'
import huodongqiandaoDetail from '../pages/huodongqiandao/detail'
import huodongqiandaoAdd from '../pages/huodongqiandao/add'
import jifenshangpinList from '../pages/jifenshangpin/list'
import jifenshangpinDetail from '../pages/jifenshangpin/detail'
import jifenshangpinAdd from '../pages/jifenshangpin/add'
import shangpinfenleiList from '../pages/shangpinfenlei/list'
import shangpinfenleiDetail from '../pages/shangpinfenlei/detail'
import shangpinfenleiAdd from '../pages/shangpinfenlei/add'
import jifenduihuanList from '../pages/jifenduihuan/list'
import jifenduihuanDetail from '../pages/jifenduihuan/detail'
import jifenduihuanAdd from '../pages/jifenduihuan/add'
import paibanxinxiList from '../pages/paibanxinxi/list'
import paibanxinxiDetail from '../pages/paibanxinxi/detail'
import paibanxinxiAdd from '../pages/paibanxinxi/add'
import jixiaokaoheList from '../pages/jixiaokaohe/list'
import jixiaokaoheDetail from '../pages/jixiaokaohe/detail'
import jixiaokaoheAdd from '../pages/jixiaokaohe/add'
import caiwuxinxiList from '../pages/caiwuxinxi/list'
import caiwuxinxiDetail from '../pages/caiwuxinxi/detail'
import caiwuxinxiAdd from '../pages/caiwuxinxi/add'
import forumtypeList from '../pages/forumtype/list'
import forumtypeDetail from '../pages/forumtype/detail'
import forumtypeAdd from '../pages/forumtype/add'
import forumreportList from '../pages/forumreport/list'
import forumreportDetail from '../pages/forumreport/detail'
import forumreportAdd from '../pages/forumreport/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import menuList from '../pages/menu/list'
import menuDetail from '../pages/menu/detail'
import menuAdd from '../pages/menu/add'
import discusskechengxinxiList from '../pages/discusskechengxinxi/list'
import discusskechengxinxiDetail from '../pages/discusskechengxinxi/detail'
import discusskechengxinxiAdd from '../pages/discusskechengxinxi/add'
import discussjiaolianxinxiList from '../pages/discussjiaolianxinxi/list'
import discussjiaolianxinxiDetail from '../pages/discussjiaolianxinxi/detail'
import discussjiaolianxinxiAdd from '../pages/discussjiaolianxinxi/add'
import discusschangdixinxiList from '../pages/discusschangdixinxi/list'
import discusschangdixinxiDetail from '../pages/discusschangdixinxi/detail'
import discusschangdixinxiAdd from '../pages/discusschangdixinxi/add'
import discusssheshishebeiList from '../pages/discusssheshishebei/list'
import discusssheshishebeiDetail from '../pages/discusssheshishebei/detail'
import discusssheshishebeiAdd from '../pages/discusssheshishebei/add'
import discusshuodongxinxiList from '../pages/discusshuodongxinxi/list'
import discusshuodongxinxiDetail from '../pages/discusshuodongxinxi/detail'
import discusshuodongxinxiAdd from '../pages/discusshuodongxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'huiyuan',
					component: huiyuanList
				},
				{
					path: 'huiyuanDetail',
					component: huiyuanDetail
				},
				{
					path: 'huiyuanAdd',
					component: huiyuanAdd
				},
				{
					path: 'jiaolian',
					component: jiaolianList
				},
				{
					path: 'jiaolianDetail',
					component: jiaolianDetail
				},
				{
					path: 'jiaolianAdd',
					component: jiaolianAdd
				},
				{
					path: 'mafang',
					component: mafangList
				},
				{
					path: 'mafangDetail',
					component: mafangDetail
				},
				{
					path: 'mafangAdd',
					component: mafangAdd
				},
				{
					path: 'kechengfenlei',
					component: kechengfenleiList
				},
				{
					path: 'kechengfenleiDetail',
					component: kechengfenleiDetail
				},
				{
					path: 'kechengfenleiAdd',
					component: kechengfenleiAdd
				},
				{
					path: 'kechengxinxi',
					component: kechengxinxiList
				},
				{
					path: 'kechengxinxiDetail',
					component: kechengxinxiDetail
				},
				{
					path: 'kechengxinxiAdd',
					component: kechengxinxiAdd
				},
				{
					path: 'kechengyuding',
					component: kechengyudingList
				},
				{
					path: 'kechengyudingDetail',
					component: kechengyudingDetail
				},
				{
					path: 'kechengyudingAdd',
					component: kechengyudingAdd
				},
				{
					path: 'jiaolianxinxi',
					component: jiaolianxinxiList
				},
				{
					path: 'jiaolianxinxiDetail',
					component: jiaolianxinxiDetail
				},
				{
					path: 'jiaolianxinxiAdd',
					component: jiaolianxinxiAdd
				},
				{
					path: 'yuyuesijiao',
					component: yuyuesijiaoList
				},
				{
					path: 'yuyuesijiaoDetail',
					component: yuyuesijiaoDetail
				},
				{
					path: 'yuyuesijiaoAdd',
					component: yuyuesijiaoAdd
				},
				{
					path: 'pingjiafankui',
					component: pingjiafankuiList
				},
				{
					path: 'pingjiafankuiDetail',
					component: pingjiafankuiDetail
				},
				{
					path: 'pingjiafankuiAdd',
					component: pingjiafankuiAdd
				},
				{
					path: 'mapizhonglei',
					component: mapizhongleiList
				},
				{
					path: 'mapizhongleiDetail',
					component: mapizhongleiDetail
				},
				{
					path: 'mapizhongleiAdd',
					component: mapizhongleiAdd
				},
				{
					path: 'mapixinxi',
					component: mapixinxiList
				},
				{
					path: 'mapixinxiDetail',
					component: mapixinxiDetail
				},
				{
					path: 'mapixinxiAdd',
					component: mapixinxiAdd
				},
				{
					path: 'mapixunlian',
					component: mapixunlianList
				},
				{
					path: 'mapixunlianDetail',
					component: mapixunlianDetail
				},
				{
					path: 'mapixunlianAdd',
					component: mapixunlianAdd
				},
				{
					path: 'mapijiankang',
					component: mapijiankangList
				},
				{
					path: 'mapijiankangDetail',
					component: mapijiankangDetail
				},
				{
					path: 'mapijiankangAdd',
					component: mapijiankangAdd
				},
				{
					path: 'changdileixing',
					component: changdileixingList
				},
				{
					path: 'changdileixingDetail',
					component: changdileixingDetail
				},
				{
					path: 'changdileixingAdd',
					component: changdileixingAdd
				},
				{
					path: 'changdixinxi',
					component: changdixinxiList
				},
				{
					path: 'changdixinxiDetail',
					component: changdixinxiDetail
				},
				{
					path: 'changdixinxiAdd',
					component: changdixinxiAdd
				},
				{
					path: 'changdiyuding',
					component: changdiyudingList
				},
				{
					path: 'changdiyudingDetail',
					component: changdiyudingDetail
				},
				{
					path: 'changdiyudingAdd',
					component: changdiyudingAdd
				},
				{
					path: 'changdiyanghu',
					component: changdiyanghuList
				},
				{
					path: 'changdiyanghuDetail',
					component: changdiyanghuDetail
				},
				{
					path: 'changdiyanghuAdd',
					component: changdiyanghuAdd
				},
				{
					path: 'shebeileixing',
					component: shebeileixingList
				},
				{
					path: 'shebeileixingDetail',
					component: shebeileixingDetail
				},
				{
					path: 'shebeileixingAdd',
					component: shebeileixingAdd
				},
				{
					path: 'sheshishebei',
					component: sheshishebeiList
				},
				{
					path: 'sheshishebeiDetail',
					component: sheshishebeiDetail
				},
				{
					path: 'sheshishebeiAdd',
					component: sheshishebeiAdd
				},
				{
					path: 'shebeiyuding',
					component: shebeiyudingList
				},
				{
					path: 'shebeiyudingDetail',
					component: shebeiyudingDetail
				},
				{
					path: 'shebeiyudingAdd',
					component: shebeiyudingAdd
				},
				{
					path: 'shebeiyanghu',
					component: shebeiyanghuList
				},
				{
					path: 'shebeiyanghuDetail',
					component: shebeiyanghuDetail
				},
				{
					path: 'shebeiyanghuAdd',
					component: shebeiyanghuAdd
				},
				{
					path: 'feiyongmingxi',
					component: feiyongmingxiList
				},
				{
					path: 'feiyongmingxiDetail',
					component: feiyongmingxiDetail
				},
				{
					path: 'feiyongmingxiAdd',
					component: feiyongmingxiAdd
				},
				{
					path: 'huodongleixing',
					component: huodongleixingList
				},
				{
					path: 'huodongleixingDetail',
					component: huodongleixingDetail
				},
				{
					path: 'huodongleixingAdd',
					component: huodongleixingAdd
				},
				{
					path: 'huodongxinxi',
					component: huodongxinxiList
				},
				{
					path: 'huodongxinxiDetail',
					component: huodongxinxiDetail
				},
				{
					path: 'huodongxinxiAdd',
					component: huodongxinxiAdd
				},
				{
					path: 'baominghuodong',
					component: baominghuodongList
				},
				{
					path: 'baominghuodongDetail',
					component: baominghuodongDetail
				},
				{
					path: 'baominghuodongAdd',
					component: baominghuodongAdd
				},
				{
					path: 'huodongqiandao',
					component: huodongqiandaoList
				},
				{
					path: 'huodongqiandaoDetail',
					component: huodongqiandaoDetail
				},
				{
					path: 'huodongqiandaoAdd',
					component: huodongqiandaoAdd
				},
				{
					path: 'jifenshangpin',
					component: jifenshangpinList
				},
				{
					path: 'jifenshangpinDetail',
					component: jifenshangpinDetail
				},
				{
					path: 'jifenshangpinAdd',
					component: jifenshangpinAdd
				},
				{
					path: 'shangpinfenlei',
					component: shangpinfenleiList
				},
				{
					path: 'shangpinfenleiDetail',
					component: shangpinfenleiDetail
				},
				{
					path: 'shangpinfenleiAdd',
					component: shangpinfenleiAdd
				},
				{
					path: 'jifenduihuan',
					component: jifenduihuanList
				},
				{
					path: 'jifenduihuanDetail',
					component: jifenduihuanDetail
				},
				{
					path: 'jifenduihuanAdd',
					component: jifenduihuanAdd
				},
				{
					path: 'paibanxinxi',
					component: paibanxinxiList
				},
				{
					path: 'paibanxinxiDetail',
					component: paibanxinxiDetail
				},
				{
					path: 'paibanxinxiAdd',
					component: paibanxinxiAdd
				},
				{
					path: 'jixiaokaohe',
					component: jixiaokaoheList
				},
				{
					path: 'jixiaokaoheDetail',
					component: jixiaokaoheDetail
				},
				{
					path: 'jixiaokaoheAdd',
					component: jixiaokaoheAdd
				},
				{
					path: 'caiwuxinxi',
					component: caiwuxinxiList
				},
				{
					path: 'caiwuxinxiDetail',
					component: caiwuxinxiDetail
				},
				{
					path: 'caiwuxinxiAdd',
					component: caiwuxinxiAdd
				},
				{
					path: 'forumtype',
					component: forumtypeList
				},
				{
					path: 'forumtypeDetail',
					component: forumtypeDetail
				},
				{
					path: 'forumtypeAdd',
					component: forumtypeAdd
				},
				{
					path: 'forumreport',
					component: forumreportList
				},
				{
					path: 'forumreportDetail',
					component: forumreportDetail
				},
				{
					path: 'forumreportAdd',
					component: forumreportAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'menu',
					component: menuList
				},
				{
					path: 'menuDetail',
					component: menuDetail
				},
				{
					path: 'menuAdd',
					component: menuAdd
				},
				{
					path: 'discusskechengxinxi',
					component: discusskechengxinxiList
				},
				{
					path: 'discusskechengxinxiDetail',
					component: discusskechengxinxiDetail
				},
				{
					path: 'discusskechengxinxiAdd',
					component: discusskechengxinxiAdd
				},
				{
					path: 'discussjiaolianxinxi',
					component: discussjiaolianxinxiList
				},
				{
					path: 'discussjiaolianxinxiDetail',
					component: discussjiaolianxinxiDetail
				},
				{
					path: 'discussjiaolianxinxiAdd',
					component: discussjiaolianxinxiAdd
				},
				{
					path: 'discusschangdixinxi',
					component: discusschangdixinxiList
				},
				{
					path: 'discusschangdixinxiDetail',
					component: discusschangdixinxiDetail
				},
				{
					path: 'discusschangdixinxiAdd',
					component: discusschangdixinxiAdd
				},
				{
					path: 'discusssheshishebei',
					component: discusssheshishebeiList
				},
				{
					path: 'discusssheshishebeiDetail',
					component: discusssheshishebeiDetail
				},
				{
					path: 'discusssheshishebeiAdd',
					component: discusssheshishebeiAdd
				},
				{
					path: 'discusshuodongxinxi',
					component: discusshuodongxinxiList
				},
				{
					path: 'discusshuodongxinxiDetail',
					component: discusshuodongxinxiDetail
				},
				{
					path: 'discusshuodongxinxiAdd',
					component: discusshuodongxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
