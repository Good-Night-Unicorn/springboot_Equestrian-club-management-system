import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import jixiaokaohe from '@/views/modules/jixiaokaohe/list'
	import jiaolianxinxi from '@/views/modules/jiaolianxinxi/list'
	import feiyongmingxi from '@/views/modules/feiyongmingxi/list'
	import kechengyuding from '@/views/modules/kechengyuding/list'
	import yuyuesijiao from '@/views/modules/yuyuesijiao/list'
	import mapixinxi from '@/views/modules/mapixinxi/list'
	import mafang from '@/views/modules/mafang/list'
	import shebeiyanghu from '@/views/modules/shebeiyanghu/list'
	import baominghuodong from '@/views/modules/baominghuodong/list'
	import shebeileixing from '@/views/modules/shebeileixing/list'
	import changdileixing from '@/views/modules/changdileixing/list'
	import jifenshangpin from '@/views/modules/jifenshangpin/list'
	import forumtype from '@/views/modules/forumtype/list'
	import paibanxinxi from '@/views/modules/paibanxinxi/list'
	import changdiyanghu from '@/views/modules/changdiyanghu/list'
	import pingjiafankui from '@/views/modules/pingjiafankui/list'
	import mapizhonglei from '@/views/modules/mapizhonglei/list'
	import mapixunlian from '@/views/modules/mapixunlian/list'
	import huodongleixing from '@/views/modules/huodongleixing/list'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import discusssheshishebei from '@/views/modules/discusssheshishebei/list'
	import sheshishebei from '@/views/modules/sheshishebei/list'
	import mapijiankang from '@/views/modules/mapijiankang/list'
	import changdiyuding from '@/views/modules/changdiyuding/list'
	import jiaolian from '@/views/modules/jiaolian/list'
	import huiyuan from '@/views/modules/huiyuan/list'
	import huodongxinxi from '@/views/modules/huodongxinxi/list'
	import changdixinxi from '@/views/modules/changdixinxi/list'
	import discusshuodongxinxi from '@/views/modules/discusshuodongxinxi/list'
	import jifenduihuan from '@/views/modules/jifenduihuan/list'
	import caiwuxinxi from '@/views/modules/caiwuxinxi/list'
	import menu from '@/views/modules/menu/list'
	import discusskechengxinxi from '@/views/modules/discusskechengxinxi/list'
	import kechengxinxi from '@/views/modules/kechengxinxi/list'
	import discusschangdixinxi from '@/views/modules/discusschangdixinxi/list'
	import huodongqiandao from '@/views/modules/huodongqiandao/list'
	import forum from '@/views/modules/forum/list'
	import shebeiyuding from '@/views/modules/shebeiyuding/list'
	import discussjiaolianxinxi from '@/views/modules/discussjiaolianxinxi/list'
	import kechengfenlei from '@/views/modules/kechengfenlei/list'
	import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/jixiaokaohe',
		name: '绩效考核',
		component: jixiaokaohe
	}
	,{
		path: '/jiaolianxinxi',
		name: '教练信息',
		component: jiaolianxinxi
	}
	,{
		path: '/feiyongmingxi',
		name: '费用明细',
		component: feiyongmingxi
	}
	,{
		path: '/kechengyuding',
		name: '课程预订',
		component: kechengyuding
	}
	,{
		path: '/yuyuesijiao',
		name: '预约私教',
		component: yuyuesijiao
	}
	,{
		path: '/mapixinxi',
		name: '马匹信息',
		component: mapixinxi
	}
	,{
		path: '/mafang',
		name: '马房管理员',
		component: mafang
	}
	,{
		path: '/shebeiyanghu',
		name: '设备养护',
		component: shebeiyanghu
	}
	,{
		path: '/baominghuodong',
		name: '报名活动',
		component: baominghuodong
	}
	,{
		path: '/shebeileixing',
		name: '设备类型',
		component: shebeileixing
	}
	,{
		path: '/changdileixing',
		name: '场地类型',
		component: changdileixing
	}
	,{
		path: '/jifenshangpin',
		name: '积分商品',
		component: jifenshangpin
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/paibanxinxi',
		name: '排班信息',
		component: paibanxinxi
	}
	,{
		path: '/changdiyanghu',
		name: '场地养护',
		component: changdiyanghu
	}
	,{
		path: '/pingjiafankui',
		name: '评价反馈',
		component: pingjiafankui
	}
	,{
		path: '/mapizhonglei',
		name: '马匹种类',
		component: mapizhonglei
	}
	,{
		path: '/mapixunlian',
		name: '马匹训练',
		component: mapixunlian
	}
	,{
		path: '/huodongleixing',
		name: '活动类型',
		component: huodongleixing
	}
	,{
		path: '/news',
		name: '公告资讯',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/discusssheshishebei',
		name: '设施设备评论',
		component: discusssheshishebei
	}
	,{
		path: '/sheshishebei',
		name: '设施设备',
		component: sheshishebei
	}
	,{
		path: '/mapijiankang',
		name: '马匹健康',
		component: mapijiankang
	}
	,{
		path: '/changdiyuding',
		name: '场地预订',
		component: changdiyuding
	}
	,{
		path: '/jiaolian',
		name: '教练',
		component: jiaolian
	}
	,{
		path: '/huiyuan',
		name: '会员',
		component: huiyuan
	}
	,{
		path: '/huodongxinxi',
		name: '活动信息',
		component: huodongxinxi
	}
	,{
		path: '/changdixinxi',
		name: '场地信息',
		component: changdixinxi
	}
	,{
		path: '/discusshuodongxinxi',
		name: '活动信息评论',
		component: discusshuodongxinxi
	}
	,{
		path: '/jifenduihuan',
		name: '积分兑换',
		component: jifenduihuan
	}
	,{
		path: '/caiwuxinxi',
		name: '财务信息',
		component: caiwuxinxi
	}
	,{
		path: '/menu',
		name: '菜单列表',
		component: menu
	}
	,{
		path: '/discusskechengxinxi',
		name: '课程信息评论',
		component: discusskechengxinxi
	}
	,{
		path: '/kechengxinxi',
		name: '课程信息',
		component: kechengxinxi
	}
	,{
		path: '/discusschangdixinxi',
		name: '场地信息评论',
		component: discusschangdixinxi
	}
	,{
		path: '/huodongqiandao',
		name: '活动签到',
		component: huodongqiandao
	}
	,{
		path: '/forum',
		name: '论坛交流',
		component: forum
	}
	,{
		path: '/shebeiyuding',
		name: '设备预订',
		component: shebeiyuding
	}
	,{
		path: '/discussjiaolianxinxi',
		name: '教练信息评论',
		component: discussjiaolianxinxi
	}
	,{
		path: '/kechengfenlei',
		name: '课程分类',
		component: kechengfenlei
	}
	,{
		path: '/shangpinfenlei',
		name: '商品分类',
		component: shangpinfenlei
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '公告资讯分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
