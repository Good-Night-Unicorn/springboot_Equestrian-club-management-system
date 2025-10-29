<template>
	<div class="home-preview">



		<!-- 关于我们 -->
		<div id="about" class="animate__animated">
			<div class="about_item">
				<div class="about_title_box">
					<div class="about_title">{{aboutUsDetail.title}}</div>
					<div class="about_subtitle">{{aboutUsDetail.subtitle}}</div>
				</div>
				<div class="about_img">
					<img :src="baseUrl + aboutUsDetail.picture1">
					<img :src="baseUrl + aboutUsDetail.picture2">
					<img :src="baseUrl + aboutUsDetail.picture3">
				</div>
				<div class="about_content" v-html="aboutUsDetail.content"></div>
				<div class="about_idea1" />
				<div class="about_idea2" />
				<div class="about_idea3" />
				<div class="about_idea4" />
				<div class="about_more" @click="toDetail('aboutusDetail',aboutUsDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-gengduo1"></span>
				</div>
			</div>
		</div>
		<!-- 关于我们 -->

		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告资讯</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div class="list list11 index-pv1">
				<div class="left_box">
					<div class="list-item" v-for="(item,index) in newsList" :key="index" v-if="index<Number(2)" @click="toDetail('newsDetail', item)">
						<div class="img"><img :src="baseUrl + item.picture" alt=""></div>
						<div class="infoBox">
							<div class="name">{{item.title}}</div>
							<div class="time">{{item.addtime}}</div>
							<div class="desc">{{ item.introduction }}</div>
						</div>
					</div>
				</div>
				<div class="right_box">
					<div class="list-item" :class="newsIndex11==index?'list-item-active':''" @click="newsTabClick11(index)"  v-for="(item,index) in newsList" :key="index" v-if="index>=Number(2)&&index<(Number(2) + Number(4))">
						<div class="name">{{item.title}}</div>
						<div class="list-item2" @click="toDetail('newsDetail', item)">
							<div class="desc">{{ item.introduction }}</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendkechengxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">课程信息推荐</span>
				<span class="recommend_subhead">{{'kechengxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="kechengxinxiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in kechengxinxiRecommend" :key="index"  @click="toDetail('kechengxinxiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.kechengfengmian)" :src="item.kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.kechengfengmian?item.kechengfengmian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">课程名称:{{item.kechengmingcheng}}</div>
							<div class="name">{{item.kechengfenlei}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{item.jiaolianzhanghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.kechengjianjie"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('kechengxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendjiaolianxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">教练信息推荐</span>
				<span class="recommend_subhead">{{'jiaolianxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="jiaolianxinxiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in jiaolianxinxiRecommend" :key="index"  @click="toDetail('jiaolianxinxiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.jiaolianxingming}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.zizhizhengshu"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('jiaolianxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendchangdixinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">场地信息推荐</span>
				<span class="recommend_subhead">{{'changdixinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="changdixinxiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in changdixinxiRecommend" :key="index"  @click="toDetail('changdixinxiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.changdimingcheng}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.changdiguiyue"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('changdixinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendsheshishebei" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">设施设备推荐</span>
				<span class="recommend_subhead">{{'sheshishebei'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="sheshishebeiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in sheshishebeiRecommend" :key="index"  @click="toDetail('sheshishebeiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.shebeitupian)" :src="item.shebeitupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.shebeitupian?item.shebeitupian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.shebeimingcheng}}</div>
							<div class="name">{{item.shebeileixing}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.shebeiyongtu"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('sheshishebei')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendhuodongxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">活动信息推荐</span>
				<span class="recommend_subhead">{{'huodongxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="huodongxinxiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in huodongxinxiRecommend" :key="index"  @click="toDetail('huodongxinxiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.huodongmingcheng}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{item.jiaolianzhanghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.huodongxiangqing"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('huodongxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendjifenshangpin" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">积分商品推荐</span>
				<span class="recommend_subhead">{{'jifenshangpin'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="jifenshangpinRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in jifenshangpinRecommend" :key="index"  @click="toDetail('jifenshangpinDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.shangpintupian)" :src="item.shangpintupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.shangpintupian?item.shangpintupian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.shangpinmingcheng}}</div>
							<div class="name">{{item.shangpinfenlei}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc" v-html="item.shangpinjieshao"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('jifenshangpin')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				aboutUsDetail: {},
				newsList: [],
				kechengxinxiRecommend: [],
				jiaolianxinxiRecommend: [],
				changdixinxiRecommend: [],
				sheshishebeiRecommend: [],
				huodongxinxiRecommend: [],
				jifenshangpinRecommend: [],


				newsIndex11: Number(2),



			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getAboutUs();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			newsTabClick11(index){
				this.newsIndex11 = index
			},
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendkechengxinxi',css:'animate__'},
					{id:'animate_recommendjiaolianxinxi',css:'animate__'},
					{id:'animate_recommendchangdixinxi',css:'animate__'},
					{id:'animate_recommendsheshishebei',css:'animate__'},
					{id:'animate_recommendhuodongxinxi',css:'animate__'},
					{id:'animate_recommendjifenshangpin',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			getAboutUs() {
				this.$http.get('aboutus/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.aboutUsDetail = res.data.data;
					}
				})
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 7,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "kechengxinxi/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.kechengxinxiRecommend = res.data.data.list;
					}
				});
				autoSortUrl = "jiaolianxinxi/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.jiaolianxinxiRecommend = res.data.data.list;
					}
				});
				autoSortUrl = "changdixinxi/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.changdixinxiRecommend = res.data.data.list;
					}
				});
				autoSortUrl = "sheshishebei/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.sheshishebeiRecommend = res.data.data.list;
					}
				});
				autoSortUrl = "huodongxinxi/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.huodongxinxiRecommend = res.data.data.list;
					}
				});
				autoSortUrl = "jifenshangpin/autoSort";
				data = {
					page: 1,
					limit: 4,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.jifenshangpinRecommend = res.data.data.list;
					}
				});
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		#about {
			padding: 0px calc(50% - 625px);
			margin: 0;
			background: url(http://codegen.caihongy.cn/20241105/fec6af9d39bc4f278f92196e5dc7d882.webp) no-repeat bottom;
			width: 100%;
			position: relative;
			height: auto;
			order: 6;
			.about_item {
				padding: 0;
				margin: 0;
				z-index: 9;
				overflow: hidden;
				background: none;
				display: block;
				width: 100%;
				flex-wrap: wrap;
				.about_title_box {
					padding: 0;
					margin: 50px auto 0;
					background: none;
					width: 100%;
					position: relative;
					text-align: left;
					height: auto;
					.about_title {
						padding: 0;
						margin: 0 0 20px 0;
						color: #000000;
						background: none;
						display: inline-block;
						width: auto;
						font-size: 40px;
						line-height: inherit;
						height: auto;
					}
					.about_subtitle {
						margin: 0 0 10px;
						color: #5DB5B7;
						display: block;
						width: 100%;
						font-size: 30px;
						line-height: 1.5;
						text-align: left;
					}
				}
				.about_img {
					padding: 0;
					margin: 20px 0 0;
					background: none;
					display: flex;
					gap: 20px;
					width: auto;
					align-items: center;
					float: left;
					flex-wrap: wrap;
					height: 500px;
					img:nth-child(1) {
						margin: 0;
						object-fit: cover;
						display: block;
						width: 246px;
						height: 360px;
					}
					img:nth-child(2) {
						margin: 0;
						object-fit: cover;
						display: block;
						width: 246px;
						height: 360px;
					}
					img:nth-child(3) {
						margin: 0;
						object-fit: cover;
						display: block;
						width: 246px;
						height: 360px;
					}
				}
				.about_content {
					padding: 0;
					margin: 100px 0 10px 0;
					overflow: hidden;
					color: #000000;
					background: none;
					width: 450px;
					font-size: 16px;
					line-height: 30px;
					float: right;
					height: auto;
				}
				.about_idea1 {
					z-index: -1;
					top: 0;
					background: url(http://codegen.caihongy.cn/20240809/4c886953e8824f4fbce50991f268e35d.png) no-repeat center top / cover;
					display: none;
					width: 100%;
					position: absolute;
					right: 0;
					height: 100%;
				}
				.about_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_more {
					border: 0;
					cursor: pointer;
					margin: 80px 0 0;
					top: 0;
					background: none;
					display: block;
					width: auto;
					line-height: 32px;
					position: absolute;
					right: calc(50% - 625px);
					border-bottom: 2px solid #5DB5B7;
					text-align: center;
					span:nth-child(1) {
						color: #9E9E9E;
						font-size: 15px;
					}
					span:nth-child(2) {
						color: #333;
						display: none;
						font-size: 15px;
					}
				}
				.about_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		.news {
			padding: 30px calc(50% - 625px);
			margin: 0;
			background: url(http://codegen.caihongy.cn/20241105/c9ba40563845438b8dd19c83a96af3b4.webp) no-repeat bottom;
			width: 100%;
			position: relative;
			order: 1;
			.news_title_box {
				padding: 0;
				margin: 0;
				background: none;
				width: 100%;
				position: relative;
				text-align: left;
				height: auto;
				.news_title {
					padding: 0;
					margin: 0 0 20px 0;
					color: #000000;
					background: none;
					display: inline-block;
					width: auto;
					font-size: 40px;
					line-height: inherit;
					height: auto;
				}
				.news_subhead {
					margin: 0 0 10px;
					color: #5DB5B7;
					display: block;
					width: 100%;
					font-size: 30px;
					line-height: 1.5;
					text-align: left;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list11 {
				padding: 0;
				margin: 30px auto 0;
				overflow: hidden;
				background: none;
				display: flex;
				width: 100%;
				justify-content: space-between;
				.left_box {
					width: 48%;
					.list-item {
						border: none;
						cursor: pointer;
						padding: 0 0 25px;
						margin: 0;
						overflow: hidden;
						display: flex;
						width: 100%;
						border-width: 0;
						justify-content: space-between;
						.img {
							flex: 0 0 auto;
							width: 200px;
							height: 200px;
							img {
								object-fit: cover;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 20px;
							background: #F9F9F9;
							flex: 1 1 auto;
							width: 100%;
							.name {
								overflow: hidden;
								color: #666;
								white-space: nowrap;
								font-weight: 600;
								width: 100%;
								font-size: 16px;
								line-height: 26px;
								text-overflow: ellipsis;
							}
							.time {
								border-radius: 5px;
								margin: 10px 0;
								color: #fff;
								background: #5DB5B7;
								width: 150px;
								font-size: 14px;
								text-align: center;
							}
							.desc {
								overflow: hidden;
								color: #858585;
								line-height: 24px;
								height: 72px;
							}
						}
					}
					.list-item:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							.name {
								color: #5DB5B7;
							}
						}
					}
				}
				.right_box {
					padding: 0 0 0 30px;
					overflow: hidden;
					width: 48%;
					height: 418px;
					.list-item {
						position: relative;
						.name {
							cursor: pointer;
							padding: 0 50px 0 25px;
							overflow: hidden;
							color: #353535;
							white-space: nowrap;
							font-weight: normal;
							width: 100%;
							font-size: 15px;
							line-height: 40px;
							position: relative;
							text-overflow: ellipsis;
						}
						.name::before {
							color:  #666;
							top: 0;
							font-weight: normal;
							font-size: 22px;
							line-height: 40px;
							position: absolute;
							right: 25px;
							content: "+";
						}
						.list-item2 {
							border: 1px dashed #bbbbbb;
							padding: 0 25px;
							margin: 0;
							overflow: hidden;
							display: block;
							border-width: 0 0 1px;
							opacity: 0;
							transition: all 0.5s;
							height: 0;
							.desc {
								cursor: pointer;
								margin: 10px 0 0;
								overflow: hidden;
								color: #909090;
								font-size: 14px;
								line-height: 25px;
								height: 200px;
							}
						}
					}
					.list-item.list-item-active {
						.name {
							color: #FFF;
							background: #5DB5B7;
						}
						.name::before {
							color: #fff;
							content: "-";
						}
						.list-item2 {
							padding: 0 25px 16px;
							margin: 0 0 10px;
							display: block;
							opacity: 1;
							transition: all 0.5s;
							height: 174px;
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 80px 0 0;
				top: 0;
				background: none;
				display: block;
				width: auto;
				line-height: 32px;
				position: absolute;
				right: calc(50% - 625px);
				border-bottom: 2px solid #5DB5B7;
				text-align: center;
				.text {
					color: #9E9E9E;
					font-size: 15px;
				}
				.icon {
					color: #000;
					display: none;
					font-size: 15px;
				}
			}
		}
		.recommend {
			padding: 0 calc(50% - 625px);
			margin: 0;
			background: url(http://codegen.caihongy.cn/20241105/de478d9056db48f2b1bb4df58e4742af.webp) no-repeat center;
			width: 100%;
			position: relative;
			order: 2;
			.recommend_title_box {
				padding: 0;
				margin: 40px auto 0;
				background: none;
				width: 100%;
				position: relative;
				text-align: left;
				height: auto;
				.recommend_title {
					padding: 0;
					margin: 0 0 20px 0;
					color: #000000;
					background: none;
					display: inline-block;
					width: auto;
					font-size: 40px;
					line-height: inherit;
					height: auto;
				}
				.recommend_subhead {
					margin: 0 0 10px;
					color: #5DB5B7;
					display: block;
					width: 100%;
					font-size: 30px;
					line-height: 1.5;
					text-align: left;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list16 {
				padding: 0;
				margin: 0 auto;
				color: #5DB5B7;
				background: none;
				display: flex;
				width: 100%;
				font-size: 14px;
				justify-content: space-between;
				flex-wrap: wrap;
				height: auto;
				.list-item {
					padding: 0;
					margin: 0 0 20px;
					background: none;
					display: flex;
					width: 49%;
					position: relative;
					height: auto;
					.img {
						border: 1px solid #777777;
						padding: 15px;
						overflow: hidden;
						background: none;
						width: 250px;
						height: 200px;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							height: 100%;
						}
					}
					.infoBox {
						padding: 0 10px;
						overflow: hidden;
						flex: 1;
						display: flex;
						height: auto;
						.info-left {
							padding: 0;
							width: 100%;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #000000;
								white-space: nowrap;
								width: 100%;
								font-size: 20px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #D00000;
								font-size: 16px;
								line-height: 2;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
									line-height: 28px;
								}
								.label {
									line-height: 1.5;
								}
								.text {
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
									line-height: 28px;
								}
								.label {
									line-height: 1.5;
								}
								.text {
									line-height: 28px;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
									line-height: 28px;
								}
								.label {
									line-height: 1.5;
								}
								.text {
									line-height: 28px;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
									line-height: 28px;
								}
								.label {
									line-height: 1.5;
								}
								.text {
									line-height: 28px;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
									line-height: 28px;
								}
								.label {
									line-height: 1.5;
								}
								.text {
									line-height: 28px;
								}
							}
						}
						.desc {
							color: #666;
							flex: 1;
							display: none;
							font-size: 14px;
							line-height: 1.5;
						}
					}
				}
				.list-item:hover {
					cursor: pointer;
					background: #F4FFFF;
					.infoBox {
						.info-left {
							.name {
							}
							.price {
							}
							.time_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.publisher_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.like_item {
								.icon {
									color: #fff;
								}
								.label {
								}
								.text {
								}
							}
							.collect_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.view_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
						}
						.desc {
							color: #fff;
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 80px 0 0;
				top: 0;
				background: none;
				display: block;
				width: auto;
				line-height: 32px;
				position: absolute;
				right: calc(50% - 625px);
				border-bottom: 2px solid #5DB5B7;
				text-align: center;
				.text {
					color: #9E9E9E;
					font-size: 15px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
	}
</style>
